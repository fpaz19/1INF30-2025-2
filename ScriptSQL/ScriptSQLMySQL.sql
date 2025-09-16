-- Eliminando Tablas
DROP TABLE IF EXISTS linea_orden_venta;
DROP TABLE IF EXISTS producto;
DROP TABLE IF EXISTS orden_venta;
DROP TABLE IF EXISTS empleado;
DROP TABLE IF EXISTS area;
DROP TABLE IF EXISTS cliente;
DROP TABLE IF EXISTS persona;
-- Creando Tablas
CREATE TABLE area(
	id_area INT AUTO_INCREMENT,
    nombre VARCHAR(75),
    activa TINYINT,
    PRIMARY KEY(id_area)
)ENGINE=InnoDB;
CREATE TABLE persona(
	id_persona INT AUTO_INCREMENT,
    DNI VARCHAR(8),
    nombre VARCHAR(70),
    apellido_paterno VARCHAR(70),
    sexo CHAR,
    fecha_nacimiento DATE,
    PRIMARY KEY(id_persona)
)ENGINE=InnoDB;
CREATE TABLE empleado(
	id_empleado INT,
    fid_area INT,
    cargo VARCHAR(75),
    sueldo DECIMAL(10,2),
    activo TINYINT,
    PRIMARY KEY(id_empleado),
    FOREIGN KEY(id_empleado) REFERENCES persona(id_persona),
    FOREIGN KEY(fid_area) REFERENCES area(id_area)
)ENGINE=InnoDB;
CREATE TABLE cliente(
	id_cliente INT,
    linea_credito DECIMAL(10,2),
    categoria ENUM('Clasico','VIP','Gold','Platinum'),
    PRIMARY KEY(id_cliente),
    FOREIGN KEY(id_cliente) REFERENCES persona(id_persona)
)ENGINE=InnoDB;
CREATE TABLE orden_venta(
	id_orden_venta INT AUTO_INCREMENT,
    fid_empleado INT,
    fid_cliente INT,
    total DECIMAL(10,2),
    fecha_hora DATETIME,
    activa TINYINT,
    PRIMARY KEY(id_orden_venta),
    FOREIGN KEY(fid_empleado) REFERENCES empleado(id_empleado),
    FOREIGN KEY(fid_cliente) REFERENCES cliente(id_cliente)
)ENGINE=InnoDB;
CREATE TABLE producto(
	id_producto INT AUTO_INCREMENT,
    nombre VARCHAR(100),
    unidad_medida VARCHAR(75),
    precio DECIMAL(10,2),
    activo TINYINT,
    PRIMARY KEY(id_producto)
)ENGINE=InnoDB;
CREATE TABLE linea_orden_venta(
	id_linea_orden_venta INT AUTO_INCREMENT,
    fid_orden_venta INT,
    fid_producto INT,
    cantidad INT,
    subtotal DECIMAL(10,2),
    activa TINYINT,
    PRIMARY KEY(id_linea_orden_venta),
    FOREIGN KEY(fid_orden_venta) REFERENCES orden_venta(id_orden_venta),
    FOREIGN KEY(fid_producto) REFERENCES producto(id_producto)
)ENGINE=InnoDB;
-- Registros
INSERT INTO area(nombre,activa) VALUES('CONTABILIDAD',1);
-- Borrando procedimientos almacenados
DROP PROCEDURE IF EXISTS INSERTAR_AREA;
DROP PROCEDURE IF EXISTS MODIFICAR_AREA;
DROP PROCEDURE IF EXISTS ELIMINAR_AREA;
DROP PROCEDURE IF EXISTS OBTENER_AREA_X_ID;
DROP PROCEDURE IF EXISTS LISTAR_AREAS_TODAS;

DROP PROCEDURE IF EXISTS INSERTAR_EMPLEADO;
DROP PROCEDURE IF EXISTS MODIFICAR_EMPLEADO;
DROP PROCEDURE IF EXISTS ELIMINAR_EMPLEADO;
DROP PROCEDURE IF EXISTS OBTENER_EMPLEADO_X_ID;
DROP PROCEDURE IF EXISTS LISTAR_EMPLEADOS_TODOS;

DROP PROCEDURE IF EXISTS INSERTAR_CLIENTE;
DROP PROCEDURE IF EXISTS MODIFICAR_CLIENTE;
DROP PROCEDURE IF EXISTS ELIMINAR_CLIENTE;
DROP PROCEDURE IF EXISTS OBTENER_CLIENTE_X_ID;
DROP PROCEDURE IF EXISTS LISTAR_CLIENTES_TODOS;

DROP PROCEDURE IF EXISTS INSERTAR_PRODUCTO;
DELIMITER $
CREATE PROCEDURE INSERTAR_AREA(
	OUT _id_area INT,
    IN _nombre VARCHAR(75)
)BEGIN
	INSERT INTO area(nombre,activa) VALUES(_nombre,1);
    SET _id_area = @@last_insert_id;
END$
CREATE PROCEDURE MODIFICAR_AREA(
	IN _id_area INT,
    IN _nombre VARCHAR(75)
)BEGIN
	UPDATE area SET nombre = _nombre WHERE id_area = _id_area;
END$
CREATE PROCEDURE ELIMINAR_AREA(
	IN _id_area INT
)BEGIN
	UPDATE area SET activa = 0 WHERE id_area = _id_area;
END$
CREATE PROCEDURE OBTENER_AREA_X_ID(
	IN _id_area INT
)BEGIN
	SELECT id_area, nombre, activa FROM area WHERE id_area = _id_area;
END$
CREATE PROCEDURE LISTAR_AREAS_TODAS()
BEGIN
	SELECT id_area, nombre, activa FROM area WHERE activa = 1;
END$

CREATE PROCEDURE INSERTAR_EMPLEADO(
	OUT _id_empleado INT,
    IN _fid_area INT,
    IN _DNI VARCHAR(8),
    IN _nombre VARCHAR(70),
    IN _apellido_paterno VARCHAR(70),
    IN _sexo CHAR,
    IN _fecha_nacimiento DATE,
    IN _cargo VARCHAR(75),
    IN _sueldo DECIMAL(10,2)
)
BEGIN
	INSERT INTO persona(DNI,nombre,apellido_paterno,sexo,fecha_nacimiento) VALUES(_DNI,_nombre,_apellido_paterno,_sexo,_fecha_nacimiento);
    SET _id_empleado = @@last_insert_id;
    INSERT INTO empleado(id_empleado,fid_area,cargo,sueldo,activo) VALUES(_id_empleado,_fid_area,_cargo,_sueldo,1);
END$
CREATE PROCEDURE MODIFICAR_EMPLEADO(
	IN _id_empleado INT,
    IN _fid_area INT,
    IN _DNI VARCHAR(8),
    IN _nombre VARCHAR(70),
    IN _apellido_paterno VARCHAR(70),
    IN _sexo CHAR,
    IN _fecha_nacimiento DATE,
    IN _cargo VARCHAR(75),
    IN _sueldo DECIMAL(10,2)
)
BEGIN
	UPDATE persona SET DNI = _DNI, nombre = _nombre, apellido_paterno = _apellido_paterno, sexo = _sexo, fecha_nacimiento = _fecha_nacimiento WHERE id_persona = _id_empleado;
    UPDATE empleado SET fid_area = _fid_area, cargo = _cargo, sueldo = _sueldo WHERE id_empleado = _id_empleado;
END$
CREATE PROCEDURE ELIMINAR_EMPLEADO(
	IN _id_empleado INT
)
BEGIN
    UPDATE empleado SET activo = 0 WHERE id_empleado = _id_empleado;
END$
CREATE PROCEDURE OBTENER_EMPLEADO_X_ID(
	IN _id_empleado INT
)
BEGIN
	SELECT e.id_empleado, p.DNI, p.nombre, p.apellido_paterno, p.sexo, p.fecha_nacimiento, a.id_area, a.nombre as nombre_area, e.cargo, e.sueldo FROM persona p INNER JOIN empleado e ON p.id_persona = e.id_empleado INNER JOIN area a ON e.fid_area = a.id_area WHERE e.id_empleado = _id_empleado;
END$
CREATE PROCEDURE LISTAR_EMPLEADOS_TODOS()
BEGIN
	SELECT e.id_empleado, p.DNI, p.nombre, p.apellido_paterno, p.sexo, p.fecha_nacimiento, a.id_area, a.nombre as nombre_area, e.cargo, e.sueldo FROM persona p INNER JOIN empleado e ON p.id_persona = e.id_empleado INNER JOIN area a ON e.fid_area = a.id_area WHERE e.activo = 1;
END$

CREATE PROCEDURE INSERTAR_CLIENTE(
	OUT _id_cliente INT,
	IN _DNI VARCHAR(8),
    IN _nombre VARCHAR(70),
    IN _apellido_paterno VARCHAR(70),
    IN _sexo CHAR,
    IN _fecha_nacimiento DATE,
    IN _linea_credito DECIMAL(10,2),
    IN _categoria ENUM('Clasico','VIP','Gold','Platinum')
)
BEGIN
	INSERT INTO persona(DNI,nombre,apellido_paterno,sexo,fecha_nacimiento) VALUES(_DNI,_nombre,_apellido_paterno,_sexo,_fecha_nacimiento);
	SET _id_cliente = @@last_insert_id;
	INSERT INTO cliente(id_cliente,linea_credito,categoria) VALUES(_id_cliente,_linea_credito,_categoria);
END$
CREATE PROCEDURE MODIFICAR_CLIENTE(
	IN _id_cliente INT,
	IN _DNI VARCHAR(8),
    IN _nombre VARCHAR(70),
    IN _apellido_paterno VARCHAR(70),
    IN _sexo CHAR,
    IN _fecha_nacimiento DATE,
    IN _linea_credito DECIMAL(10,2),
    IN _categoria ENUM('Clasico','VIP','Gold','Platinum')
)
BEGIN
	UPDATE persona SET DNI = _DNI, nombre = _nombre, apellido_paterno = _apellido_paterno,sexo = _sexo, fecha_nacimiento = _fecha_nacimiento WHERE id_persona = _id_cliente;
	UPDATE cliente SET linea_credito = _linea_credito, categoria = _categoria WHERE id_cliente = _id_cliente;
END$
CREATE PROCEDURE OBTENER_CLIENTE_X_ID(
	IN _id_cliente INT
)
BEGIN
	SELECT c.id_cliente, p.DNI, p.nombre, p.apellido_paterno, p.sexo, p.fecha_nacimiento, c.linea_credito, c.categoria FROM persona p INNER JOIN cliente c ON p.id_persona = c.id_cliente WHERE c.id_cliente = _id_cliente;
END$

CREATE PROCEDURE INSERTAR_PRODUCTO(
	OUT _id_producto INT,
    IN _nombre VARCHAR(100),
    IN _unidad_medida VARCHAR(75),
    IN _precio DECIMAL(10,2)
)
BEGIN
	INSERT INTO producto(nombre,unidad_medida,precio,activo) VALUES(_nombre,_unidad_medida,_precio,1);
    SET _id_producto = @@last_insert_id;
END$
-- Insertando registros
CALL INSERTAR_AREA(@id_area1,'VENTAS');
CALL INSERTAR_AREA(@id_area2,'CONTABILIDAD');
CALL INSERTAR_AREA(@id_area3,'FINANZAS');

CALL INSERTAR_EMPLEADO(@id_empleado1,@id_area1,'28761129','MANUEL','GONZALES','M','1986-11-01','VENDEDOR',2300.00);
CALL INSERTAR_EMPLEADO(@id_empleado2,@id_area2,'27519001','KARLA','CORDOVA','F','1993-08-17','JEFE DE VENTAS',1650.00);
CALL INSERTAR_EMPLEADO(@id_empleado3,@id_area1,'12987109','KAREN','DIAZ','F','1986-11-01','CAJERA',1500.00);
CALL INSERTAR_EMPLEADO(@id_empleado4,@id_area1,'29121803','JUAN','ARENAS','M','1991-02-19','VENDEDOR','1750.00');
CALL INSERTAR_EMPLEADO(@id_empleado5,@id_area2,'17300362','MANUEL','CARRASCO','M','1982-07-18','ANALISTA CONTABLE','2500.00');
CALL INSERTAR_EMPLEADO(@id_empleado6,@id_area2,'18762501','KAREN','MARTINEZ','F','1976-01-14','JEFE DE CONTABILIDAD','3200.00');

CALL INSERTAR_CLIENTE(@id_cliente1,'87261109','FATIMA','MORALES','F','1992-10-04',1500.50,'Platinum');
CALL INSERTAR_CLIENTE(@id_cliente2,'13007065','CAROLINA','SALVADOR','F','1992-11-22',2500.00,'Platinum');
CALL INSERTAR_CLIENTE(@id_cliente3,'18732004','DANIELA','VILLANUEVA','F','1984-03-15',1000.00,'Clasico');
CALL INSERTAR_CLIENTE(@id_cliente4,'39871002','HUGO','VALDIVIA','M','1992-03-03',2000.00,'Clasico');
CALL INSERTAR_CLIENTE(@id_cliente5,'28709982','OSCAR','CARRANZA','M','1993-10-30',2000.00,'VIP');
CALL INSERTAR_CLIENTE(@id_cliente6,'10920091','ANGELA','GUEVARA','F','1988-03-13',3000.00,'Platinum');
CALL INSERTAR_CLIENTE(@id_cliente7,'33620929','PEDRO','MENDOZA','M','1984-10-09',3700.00,'VIP');
CALL INSERTAR_CLIENTE(@id_cliente8,'17200928','CARMEN','GAVIDIA','F','1981-02-15',1430.00,'Clasico');
CALL INSERTAR_CLIENTE(@id_cliente9,'28779283','PIERINA','RUIZ','F','1984-11-23',3345.00,'VIP');

CALL INSERTAR_PRODUCTO(@id_producto1,'GASEOSA INKA KOLA','500 ML',2.70);
CALL INSERTAR_PRODUCTO(@id_producto2,'GASEOSA COCA COLA','1.5 LT',5.90);
CALL INSERTAR_PRODUCTO(@id_producto3,'DETERGENTE LIQUIDO BOLIVAR','940 ML',16.00);
CALL INSERTAR_PRODUCTO(@id_producto4,'LAVAVAJILLAS EN PASTA LIMON SAPOLIO','900 GR',6.10);