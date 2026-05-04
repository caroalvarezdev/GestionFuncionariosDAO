CREATE DATABASE gestion_funcionarios;
USE gestion_funcionarios;
CREATE TABLE cargo (
    id_cargo INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

CREATE TABLE dependencia (
    id_dependencia INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

CREATE TABLE funcionario (
    id_funcionario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    documento VARCHAR(50) UNIQUE NOT NULL,
    id_cargo INT,
    id_dependencia INT,
    FOREIGN KEY (id_cargo) REFERENCES cargo(id_cargo),
    FOREIGN KEY (id_dependencia) REFERENCES dependencia(id_dependencia)
);

INSERT INTO cargo (nombre) VALUES 
('Desarrollador'),
('Analista'),
('QA');

INSERT INTO dependencia (nombre) VALUES 
('TI'),
('Recursos Humanos'),
('Finanzas');

INSERT INTO funcionario (nombre, apellido, documento, id_cargo, id_dependencia) VALUES
('Julian', 'Perez', '10122345', 1, 1),
('Mariana', 'Gomez', '10267890', 2, 2);

SELECT nombre, apellido FROM funcionario;
