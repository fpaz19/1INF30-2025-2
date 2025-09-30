--Eliminacion de tablas
DROP TABLE IF EXISTS Empleado;
DROP TABLE IF EXISTS Persona;
DROP TABLE IF EXISTS Area;
GO
--Creacion de tablas
CREATE TABLE Area(
	id_area INT IDENTITY(1,1),
	nombre VARCHAR(75),
	activa TINYINT,
	PRIMARY KEY(id_area)
);
GO
CREATE TABLE Persona(
	id_persona INT IDENTITY(1,1),
	DNI VARCHAR(8),
	nombre VARCHAR(70),
    apellido_paterno VARCHAR(70),
    sexo CHAR,
    fecha_nacimiento DATE,
    PRIMARY KEY(id_persona)
);
GO
CREATE TABLE Empleado(
	id_empleado INT,
    fid_area INT,
    cargo VARCHAR(75),
    sueldo DECIMAL(10,2),
    activo TINYINT,
    PRIMARY KEY(id_empleado),
    FOREIGN KEY(id_empleado) REFERENCES persona(id_persona),
    FOREIGN KEY(fid_area) REFERENCES area(id_area)
);
GO
--Registros
INSERT INTO Area(nombre,activa) VALUES('FINANZAS',1);
GO
--Eliminacion de procedimientos almacenados
DROP PROCEDURE IF EXISTS INSERTAR_AREA;
DROP PROCEDURE IF EXISTS OBTENER_AREA_X_ID;
DROP PROCEDURE IF EXISTS MODIFICAR_AREA;
DROP PROCEDURE IF EXISTS ELIMINAR_AREA;
DROP PROCEDURE IF EXISTS LISTAR_AREAS_TODAS;
DROP PROCEDURE IF EXISTS INSERTAR_EMPLEADO;
DROP PROCEDURE IF EXISTS LISTAR_EMPLEADOS_TODOS;
GO
--Creacion de procedimientos almacenados
CREATE PROCEDURE INSERTAR_AREA
	@_id_area INT OUTPUT,
	@_nombre VARCHAR(75)
AS
BEGIN
	INSERT INTO Area(nombre,activa) 
	VALUES(@_nombre,1);
	SET @_id_area = @@IDENTITY;
END
GO
CREATE PROCEDURE OBTENER_AREA_X_ID
	@_id_area INT
AS
BEGIN
	SELECT id_area, nombre, activa FROM Area WHERE id_area = @_id_area;
END
GO
CREATE PROCEDURE MODIFICAR_AREA
	@_id_area INT,
    @_nombre VARCHAR(75)
AS
BEGIN
	UPDATE Area SET nombre = @_nombre WHERE id_area = @_id_area;
END
GO
CREATE PROCEDURE ELIMINAR_AREA
	@_id_area INT
AS
BEGIN
	UPDATE Area SET activa = 0 WHERE id_area = @_id_area;
END
GO
CREATE PROCEDURE LISTAR_AREAS_TODAS
AS
BEGIN
	SELECT id_area, nombre, activa FROM Area WHERE activa = 1;
END
GO
CREATE PROCEDURE INSERTAR_EMPLEADO
	@_id_empleado INT OUTPUT,
    @_fid_area INT,
    @_DNI VARCHAR(8),
    @_nombre VARCHAR(70),
    @_apellido_paterno VARCHAR(70),
    @_sexo CHAR,
    @_fecha_nacimiento DATE,
    @_cargo VARCHAR(75),
    @_sueldo DECIMAL(10,2)
AS
BEGIN
	INSERT INTO persona(DNI,nombre,apellido_paterno,sexo,fecha_nacimiento) VALUES(@_DNI,@_nombre,@_apellido_paterno,@_sexo,@_fecha_nacimiento);
    SET @_id_empleado = @@IDENTITY;
    INSERT INTO empleado(id_empleado,fid_area,cargo,sueldo,activo) VALUES(@_id_empleado,@_fid_area,@_cargo,@_sueldo,1);
END
GO
CREATE PROCEDURE LISTAR_EMPLEADOS_TODOS
AS
BEGIN
	SELECT e.id_empleado, p.DNI, p.nombre, p.apellido_paterno, p.sexo, p.fecha_nacimiento, a.id_area, a.nombre as nombre_area, e.cargo, e.sueldo FROM Persona p INNER JOIN Empleado e ON p.id_persona = e.id_empleado INNER JOIN Area a ON e.fid_area = a.id_area WHERE e.activo = 1;
END
GO
--Probando procedimientos almacenados
DECLARE @id_area AS INT;
EXEC INSERTAR_AREA @id_area, 'RECURSOS HUMANOS';
GO