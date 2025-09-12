DROP TABLE IF EXISTS empleado;
DROP TABLE IF EXISTS area;
DROP TABLE IF EXISTS cliente;
DROP TABLE IF EXISTS persona;
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
-- Insertando registros
CALL INSERTAR_AREA(@id_area1,'PRODUCCION');
CALL INSERTAR_EMPLEADO(@id_empleado1,@id_area1,'26541190','CARLOS','CARBAJAL','M','1993-10-10','JEFE DE PRODUCCION',1999.22);