-- cracion de la BASE DE DATOS: EXAMEN_BDD
CREATE DATABASE fitzone_api;
USE fitzone_api;

-- 1 CREACION DE LA TABLA: SOCIOS

CREATE TABLE socios (
    id_socio INT PRIMARY KEY,
    nombres VARCHAR(50) NOT NULL,
    apellidos VARCHAR(50) NOT NULL,
    edad INT NOT NULL,
    fecha_registro VARCHAR(10) NOT NULL,
    activo BOOLEAN NOT NULL
);

-- 2 INSERCION DE DATOS
INSERT INTO socios ( id_socio, nombres, apellidos, edad, fecha_registro, activo) 
VALUES 	(1, 'Arturo', 'Cueva', 45, '2026-01-01', TRUE),
		(2, 'Juan', 'Perez', 40, '2026-02-02', TRUE),
		(3, 'Marina', 'Torres', 35, '2026-03-03', FALSE),
		(4, 'Carlos', 'Sanchez', 30, '2026-04-04', TRUE),
		(5, 'Diana', 'Martinez', 25, '2026-05-05', FALSE);
        
SELECT * FROM socios;

--  3. consultas sql
-- Consulta 1: Mostrar únicamente nombres, apellidos y edad de los socios que tengan activo = true y sean mayores a 18 años
SELECT nombres, apellidos, edad
FROM socios
WHERE activo = TRUE AND edad > 18;

-- Consulta 2: Mostrar los socios registrados después de '2026-02-01' utilizando comparación sobre el campo fecha_registro.
SELECT nombres, apellidos, fecha_registro
FROM socios
WHERE fecha_registro > '2026-02-01';

-- Consulta 3: Mostrar todos los socios ordenados por edad de mayor a menor (ORDER BY DESC).
SELECT nombres, apellidos, edad
FROM socios
ORDER BY edad DESC;

-- 4 modificacion y actualizacion de tabala
-- Agregar la columna email.
ALTER TABLE socios
ADD COLUMN email VARCHAR(100);

-- Asignar un correo al socio identificado por su clave primaria.
UPDATE socios
SET email = 'a_cueva@google.com'
WHERE id_socio = 1;
