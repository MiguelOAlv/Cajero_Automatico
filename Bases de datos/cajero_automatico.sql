drop DATABASE if exists `proyecto_final2`;
create DATABASE `proyecto_final2`;
USE `proyecto_final2`;

CREATE TABLE clientes (
  ID_Cliente INT PRIMARY KEY AUTO_INCREMENT DEFAULT 1,
  Nombre VARCHAR(50),
  Apellido VARCHAR(50),
  Correo_electronico VARCHAR(100),
  Telefono VARCHAR(20),
  Direccion VARCHAR(100)
);

CREATE TABLE cuentas (
  ID_Cuenta INT PRIMARY KEY AUTO_INCREMENT,
  ID_Cliente INT,
  Saldo FLOAT,
  Fecha_apertura DATE,
  Tipo_cuenta VARCHAR(20),
  FOREIGN KEY (ID_Cliente) REFERENCES Clientes(ID_Cliente)
);

CREATE TABLE tarjetas_de_credito (
  ID_Tarjeta INT PRIMARY KEY,
  ID_Cliente INT,
  PIN INT not null,
  Limite_de_credito FLOAT,
  Saldo_actual FLOAT,
  Fecha_vencimiento DATE,
  FOREIGN KEY (ID_Cliente) REFERENCES Clientes(ID_Cliente)
);

-- Trigger para no introducir tarjetas de credito con una fecha de vencimiento menor que la actual.
DELIMITER //
CREATE TRIGGER fecha_pasada BEFORE INSERT ON Tarjetas_de_credito
FOR EACH ROW
BEGIN
    IF NEW.Fecha_vencimiento < CURDATE() THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'No se puede añadir una fecha de vencimiento con una fecha anterior a la fecha actual.';
    END IF;
END //
DELIMITER ;

CREATE TABLE movimientos (
  ID_Movimiento INT PRIMARY KEY,
  ID_Cuenta INT,
  ID_Tarjeta INT,
  Fecha DATE,
  Hora TIME,
  Tipo_movimiento VARCHAR(20),
  Monto FLOAT,
  FOREIGN KEY (ID_Cuenta) REFERENCES Cuentas(ID_Cuenta),
  FOREIGN KEY (ID_Tarjeta) REFERENCES Tarjetas_de_credito(ID_Tarjeta)
);

CREATE TABLE administradores (
  ID_Administrador INT PRIMARY KEY,
  Nombre VARCHAR(50),
  Apellido VARCHAR(50),
  Correo_electronico VARCHAR(100),
  Telefono VARCHAR(20),
  Contrasena VARCHAR(50)
);

CREATE TABLE cajeros_automaticos (
  ID_Cajero INT PRIMARY KEY,
  Ubicacion VARCHAR(100),
  Cantidad_de_efectivo_actual FLOAT
);

INSERT INTO Cajeros_automaticos VALUES (ID_Cajero, Ubicacion, Cantidad_de_efectivo_actual)
VALUES ('1','P.º de Zorrilla, 1, 47007 Valladolid','50000');
