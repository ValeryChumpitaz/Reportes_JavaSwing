CREATE DATABASE bd_tienda;
	USE bd_tienda;
CREATE TABLE clientes (
                          id_cliente INT AUTO_INCREMENT PRIMARY KEY,
                          nombre VARCHAR(100) NOT NULL,
                          correo VARCHAR(100),
                          telefono VARCHAR(20)
);
INSERT INTO clientes (nombre, correo, telefono) VALUES
                                                    ('Valery Flores', 'valeryf@gmail.com', '987654321'),
                                                    ('Luis Ramos', 'luisr@hotmail.com', '965874123'),
                                                    ('María Gutiérrez', 'maria.gutierrez@gmail.com', '912345678'),
                                                    ('Carlos Díaz', 'carlos_dz@yahoo.com', '978451236'),
                                                    ('Sofía Medina', 'sofia.m@gmail.com', '986321547');

INSERT INTO clientes (nombre, correo, telefono) VALUES
                                                    ('Valery Flores', 'valeryf@gmail.com', '987654321'),	('Sofía Medina', 'sofia.m@gmail.com', '986321547');
