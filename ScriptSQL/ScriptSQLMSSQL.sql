--Eliminacion de tablas
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
--Registros
INSERT INTO Area(nombre,activa) VALUES('FINANZAS',1);
GO
--Eliminacion de procedimientos almacenados
DROP PROCEDURE IF EXISTS INSERTAR_AREA;
DROP PROCEDURE IF EXISTS OBTENER_AREA_X_ID;
DROP PROCEDURE IF EXISTS MODIFICAR_AREA;
DROP PROCEDURE IF EXISTS ELIMINAR_AREA;
DROP PROCEDURE IF EXISTS LISTAR_AREAS_TODAS;
GO
--Creacion de procedimientos almacenados
CREATE PROCEDURE INSERTAR_AREA
	@id_area INT OUTPUT,
	@nombre VARCHAR(75)
AS
BEGIN
	INSERT INTO Area(nombre,activa) 
	VALUES(@nombre,1);
	SET @id_area = @@IDENTITY;
END
GO
CREATE PROCEDURE OBTENER_AREA_X_ID
	@id_area INT
AS
BEGIN
	SELECT id_area, nombre, activa FROM area WHERE id_area = @id_area;
END
GO
CREATE PROCEDURE MODIFICAR_AREA
	@id_area INT,
    @nombre VARCHAR(75)
AS
BEGIN
	UPDATE area SET nombre = @nombre WHERE id_area = @id_area;
END
GO
CREATE PROCEDURE ELIMINAR_AREA
	@id_area INT
AS
BEGIN
	UPDATE area SET activa = 0 WHERE id_area = @id_area;
END
GO
CREATE PROCEDURE LISTAR_AREAS_TODAS
AS
BEGIN
	SELECT id_area, nombre, activa FROM area WHERE activa = 1;
END
GO
--Probando procedimientos almacenados
DECLARE @id_area AS INT;
EXEC INSERTAR_AREA @id_area, 'RECURSOS HUMANOS';
GO