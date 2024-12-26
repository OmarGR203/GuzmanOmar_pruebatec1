-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-12-2024 a las 18:33:44
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `empleados`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `ID` int(11) NOT NULL,
  `APELLIDO` varchar(255) DEFAULT NULL,
  `CARGO` varchar(255) DEFAULT NULL,
  `FECHAINICIO` date DEFAULT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL,
  `SALARIO` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`ID`, `APELLIDO`, `CARGO`, `FECHAINICIO`, `NOMBRE`, `SALARIO`) VALUES
(2, 'Guzman', 'Auxiliar de RH', '2023-06-14', 'Omar', 1500.5),
(3, 'Sandoval', 'Ejecutivo de Altas', '2024-05-20', 'Carlos', 1400),
(5, 'Sanchez', 'Ejecutivo de Altas', '2021-05-20', 'Daniel', 1400),
(6, 'Ortiz', 'Jefe de RH', '2021-05-18', 'Javier', 2000),
(7, 'Zavala', 'Coordinador', '2020-12-14', 'Alicia', 3000),
(8, 'Roa', 'Director Operativo', '2020-04-05', 'Janner', 2500),
(9, 'Lopez', 'Ejecutivo de Altas', '2024-05-05', 'Diana', 1400.5),
(10, 'Romero', 'Gerente de Administracion', '2015-05-14', 'Elizabeth', 25000.2),
(11, 'Hernandez', 'Jefe de Analisis', '2019-05-25', 'Julia', 1800),
(12, 'Herrera', 'Ejecutivo de Analisis', '2019-09-21', 'Miguel', 1500),
(13, 'Jimenez', 'Ejecutivo de Altas', '2018-11-16', 'Alfredo', 1400),
(14, 'Juarez', 'Auxiliar de finanzas', '2015-08-05', 'Silvia', 1900),
(15, 'Salgado', 'Gerente de Finanzas', '2019-12-02', 'Evelin', 2500),
(16, 'Garcia', 'Jefe de Almacen', '2015-04-05', 'Genaro', 1800),
(17, 'Carmona', 'Ejecutivo de Analisis', '2016-09-12', 'Camilo', 1500),
(18, 'Ibarra', 'Ejecutivo de Portabilidades', '2021-12-16', 'Edgar', 1400);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `empleado`
--
ALTER TABLE `empleado`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
