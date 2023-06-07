-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-06-2023 a las 03:16:18
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyecto_final`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administradores`
--

CREATE TABLE `administradores` (
  `ID_Administrador` int(11) NOT NULL,
  `Nombre` varchar(50) DEFAULT NULL,
  `Apellido` varchar(50) DEFAULT NULL,
  `Correo_electronico` varchar(100) DEFAULT NULL,
  `Telefono` varchar(20) DEFAULT NULL,
  `Contrasena` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `administradores`
--

INSERT INTO `administradores` (`ID_Administrador`, `Nombre`, `Apellido`, `Correo_electronico`, `Telefono`, `Contrasena`) VALUES
(1, 'Miguel', 'Ortega', 'migueloa@alumnos.iesgalileo.es', '983455445', '1234.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `arqueos`
--

CREATE TABLE `arqueos` (
  `ID_Arqueo` int(11) NOT NULL,
  `ID_Cajero` int(11) DEFAULT NULL,
  `ID_Administrador` int(11) DEFAULT NULL,
  `Fecha_Inicio` date DEFAULT NULL,
  `Fecha_Fin` date DEFAULT NULL,
  `Fecha_arqueo_realizado` date DEFAULT NULL,
  `Hora` time DEFAULT NULL,
  `total_esperado` int(11) DEFAULT NULL,
  `total_contado` int(11) DEFAULT NULL,
  `diferencia` int(11) GENERATED ALWAYS AS (`total_esperado` - `total_contado`) VIRTUAL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cajeros_automaticos`
--

CREATE TABLE `cajeros_automaticos` (
  `ID_Cajero` int(11) NOT NULL,
  `Ubicacion` varchar(100) DEFAULT NULL,
  `Cantidad_de_efectivo_actual` float DEFAULT NULL,
  `limite_diario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cajeros_automaticos`
--

INSERT INTO `cajeros_automaticos` (`ID_Cajero`, `Ubicacion`, `Cantidad_de_efectivo_actual`, `limite_diario`) VALUES
(1, 'P.º de Zorrilla, 1, Valladolid', 49950, 20000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `ID_Cliente` int(11) NOT NULL,
  `DNI` varchar(50) NOT NULL,
  `Nombre` varchar(50) DEFAULT NULL,
  `Apellido` varchar(50) DEFAULT NULL,
  `Correo_electronico` varchar(100) DEFAULT NULL,
  `Telefono` varchar(20) DEFAULT NULL,
  `Direccion` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`ID_Cliente`, `DNI`, `Nombre`, `Apellido`, `Correo_electronico`, `Telefono`, `Direccion`) VALUES
(1, '12433016K', 'Miguel', 'Ortega', 'migueloa@alumnos.iesgalileo.es', '638494994', 'C. de Villabañez, 123, 47012 Valladolid'),
(2, '58999572H', 'Pepito', 'Martinez', 'pepitoma@alumnos.iesgalileo.es', '638323232', 'C. Golondrina, 14, 47012 Valladolid'),
(3, '99727004Q', 'Pepita', 'Martinez', 'pepitama@alumnos.iesgalileo.es', '638303030', 'C. del Mirlo, 8, 47012 Valladolid'),
(4, '32091459L', 'Juan', 'Perez', 'juan.perez@email.com', '123456789', 'C. de Villabañez, 50, 47012 Valladolid'),
(5, '54620814T', 'Ana', 'Gomez', 'ana.gomez@email.com', '234567890', 'C. de Embajadores, 34, 47012 Valladolid'),
(6, '99724878Y', 'Carlos', 'Rodriguez', 'carlos.rodriguez@email.com', '345678901', 'C. de Panaderos, 98, 47004 Valladolid'),
(7, '71676666H', 'Maria', 'Lopez', 'maria.lopez@email.com', '456789012', 'C. de Acera de Recoletos, 75, 47004 Valladolid'),
(8, '05010977J', 'Jaime', 'Gonzalez', 'pedro.gonzalez@email.com', '567890123', 'C. de Duque de la Victoria, 22, 47001 Valladolid'),
(9, '63948428X', 'Paco', 'Gonzalez', 'paco.gonzalez@email.com', '654789987', 'C. de Fuente el Sol, 112, 47009 Valladolid'),
(10, '54539135V', 'David', 'Sanchez', 'david.sanchez@email.com', '678543432', 'C. de la Estación, 67, 47004 Valladolid');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuentas`
--

CREATE TABLE `cuentas` (
  `ID_Cuenta` int(11) NOT NULL,
  `ID_Cliente` int(11) DEFAULT NULL,
  `Saldo` float DEFAULT NULL CHECK (`Saldo` >= 0),
  `Fecha_apertura` date DEFAULT NULL,
  `Tipo_cuenta` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cuentas`
--

INSERT INTO `cuentas` (`ID_Cuenta`, `ID_Cliente`, `Saldo`, `Fecha_apertura`, `Tipo_cuenta`) VALUES
(13692818, 2, 10200, '2023-06-06', 'Corriente'),
(17949006, 1, 20000, '2023-06-07', 'Ahorros'),
(21743727, 1, 9650, '2023-06-06', 'Corriente'),
(53036149, 3, 15000, '2023-06-06', 'Corriente'),
(74360327, 4, 10000, '2023-06-07', 'Ahorros'),
(82881144, 5, 30000, '2023-06-07', 'Corriente');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movimientos`
--

CREATE TABLE `movimientos` (
  `ID_Movimiento` int(11) NOT NULL,
  `ID_Cuenta` int(11) DEFAULT NULL,
  `ID_Tarjeta` int(11) DEFAULT NULL,
  `ID_Cliente` int(11) DEFAULT NULL,
  `Fecha` date DEFAULT NULL,
  `Hora` time DEFAULT NULL,
  `Tipo_movimiento` varchar(20) DEFAULT NULL,
  `Monto` float DEFAULT NULL CHECK (`Monto` >= 0)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `movimientos`
--

INSERT INTO `movimientos` (`ID_Movimiento`, `ID_Cuenta`, `ID_Tarjeta`, `ID_Cliente`, `Fecha`, `Hora`, `Tipo_movimiento`, `Monto`) VALUES
(1, 21743727, 52531152, 1, '2023-06-06', '21:44:47', 'Retirada', 50),
(2, 21743727, 52531152, 1, '2023-06-06', '21:54:51', 'Transferencia', 100),
(3, 21743727, 52531152, 1, '2023-06-06', '21:55:09', 'Transferencia', 100),
(4, 21743727, 52531152, 1, '2023-06-06', '21:58:12', 'Pago Factura', 200);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tarjetas_de_credito`
--

CREATE TABLE `tarjetas_de_credito` (
  `ID_Tarjeta` int(11) NOT NULL,
  `ID_Cliente` int(11) DEFAULT NULL,
  `PIN` int(11) NOT NULL,
  `Limite_de_credito` float DEFAULT NULL,
  `Fecha_vencimiento` date NOT NULL,
  `Bloqueada` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tarjetas_de_credito`
--

INSERT INTO `tarjetas_de_credito` (`ID_Tarjeta`, `ID_Cliente`, `PIN`, `Limite_de_credito`, `Fecha_vencimiento`, `Bloqueada`) VALUES
(52531152, 1, 1231, 1000, '2028-06-01', 0),
(53431322, 1, 1234, 1000, '2028-05-23', 0),
(84505285, 2, 1111, 5500, '2028-06-01', 0);

--
-- Disparadores `tarjetas_de_credito`
--
DELIMITER $$
CREATE TRIGGER `verificar_fecha_vencimiento` BEFORE INSERT ON `tarjetas_de_credito` FOR EACH ROW BEGIN
  IF NEW.Fecha_vencimiento < CURDATE() THEN 
    SIGNAL SQLSTATE '45000'
    SET MESSAGE_TEXT = 'La Fecha_vencimiento no puede ser anterior a la fecha actual.';
  END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `transacciones_cajeros`
--

CREATE TABLE `transacciones_cajeros` (
  `ID_Transaccion` int(11) NOT NULL,
  `ID_Cajero` int(11) DEFAULT NULL,
  `ID_Tarjeta` int(11) DEFAULT NULL,
  `Fecha` date DEFAULT NULL,
  `Hora` time DEFAULT NULL,
  `Tipo_transaccion` varchar(20) DEFAULT NULL,
  `Monto` float NOT NULL
) ;

--
-- Volcado de datos para la tabla `transacciones_cajeros`
--

INSERT INTO `transacciones_cajeros` (`ID_Transaccion`, `ID_Cajero`, `ID_Tarjeta`, `Fecha`, `Hora`, `Tipo_transaccion`, `Monto`) VALUES
(1, 1, 52531152, '2023-06-06', '21:44:47', 'Retirada', 50);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administradores`
--
ALTER TABLE `administradores`
  ADD PRIMARY KEY (`ID_Administrador`);

--
-- Indices de la tabla `arqueos`
--
ALTER TABLE `arqueos`
  ADD PRIMARY KEY (`ID_Arqueo`),
  ADD KEY `ID_Cajero` (`ID_Cajero`),
  ADD KEY `ID_Administrador` (`ID_Administrador`);

--
-- Indices de la tabla `cajeros_automaticos`
--
ALTER TABLE `cajeros_automaticos`
  ADD PRIMARY KEY (`ID_Cajero`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`ID_Cliente`);

--
-- Indices de la tabla `cuentas`
--
ALTER TABLE `cuentas`
  ADD PRIMARY KEY (`ID_Cuenta`),
  ADD KEY `ID_Cliente` (`ID_Cliente`);

--
-- Indices de la tabla `movimientos`
--
ALTER TABLE `movimientos`
  ADD PRIMARY KEY (`ID_Movimiento`),
  ADD KEY `ID_Cuenta` (`ID_Cuenta`),
  ADD KEY `ID_Cliente` (`ID_Cliente`),
  ADD KEY `movimientos_ibfk_2` (`ID_Tarjeta`);

--
-- Indices de la tabla `tarjetas_de_credito`
--
ALTER TABLE `tarjetas_de_credito`
  ADD PRIMARY KEY (`ID_Tarjeta`),
  ADD KEY `ID_Cliente` (`ID_Cliente`);

--
-- Indices de la tabla `transacciones_cajeros`
--
ALTER TABLE `transacciones_cajeros`
  ADD PRIMARY KEY (`ID_Transaccion`),
  ADD KEY `ID_Cajero` (`ID_Cajero`),
  ADD KEY `transacciones_cajeros_ibfk_2` (`ID_Tarjeta`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `administradores`
--
ALTER TABLE `administradores`
  MODIFY `ID_Administrador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `arqueos`
--
ALTER TABLE `arqueos`
  MODIFY `ID_Arqueo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `ID_Cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `movimientos`
--
ALTER TABLE `movimientos`
  MODIFY `ID_Movimiento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `transacciones_cajeros`
--
ALTER TABLE `transacciones_cajeros`
  MODIFY `ID_Transaccion` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `arqueos`
--
ALTER TABLE `arqueos`
  ADD CONSTRAINT `arqueos_ibfk_1` FOREIGN KEY (`ID_Cajero`) REFERENCES `cajeros_automaticos` (`ID_Cajero`),
  ADD CONSTRAINT `arqueos_ibfk_2` FOREIGN KEY (`ID_Administrador`) REFERENCES `administradores` (`ID_Administrador`);

--
-- Filtros para la tabla `cuentas`
--
ALTER TABLE `cuentas`
  ADD CONSTRAINT `cuentas_ibfk_1` FOREIGN KEY (`ID_Cliente`) REFERENCES `clientes` (`ID_Cliente`);

--
-- Filtros para la tabla `movimientos`
--
ALTER TABLE `movimientos`
  ADD CONSTRAINT `movimientos_ibfk_1` FOREIGN KEY (`ID_Cuenta`) REFERENCES `cuentas` (`ID_Cuenta`),
  ADD CONSTRAINT `movimientos_ibfk_2` FOREIGN KEY (`ID_Tarjeta`) REFERENCES `tarjetas_de_credito` (`ID_Tarjeta`),
  ADD CONSTRAINT `movimientos_ibfk_3` FOREIGN KEY (`ID_Cliente`) REFERENCES `clientes` (`ID_Cliente`);

--
-- Filtros para la tabla `tarjetas_de_credito`
--
ALTER TABLE `tarjetas_de_credito`
  ADD CONSTRAINT `tarjetas_de_credito_ibfk_1` FOREIGN KEY (`ID_Cliente`) REFERENCES `clientes` (`ID_Cliente`);

--
-- Filtros para la tabla `transacciones_cajeros`
--
ALTER TABLE `transacciones_cajeros`
  ADD CONSTRAINT `transacciones_cajeros_ibfk_1` FOREIGN KEY (`ID_Cajero`) REFERENCES `cajeros_automaticos` (`ID_Cajero`),
  ADD CONSTRAINT `transacciones_cajeros_ibfk_2` FOREIGN KEY (`ID_Tarjeta`) REFERENCES `tarjetas_de_credito` (`ID_Tarjeta`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
