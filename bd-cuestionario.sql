-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-05-2017 a las 11:11:30
-- Versión del servidor: 5.7.18-log
-- Versión de PHP: 7.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd-cuestionario`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alternativa`
--

CREATE TABLE `alternativa` (
  `idalternativa` int(11) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `valor` tinyint(1) DEFAULT NULL,
  `pregunta_idpregunta` int(11) NOT NULL,
  `tipoalternativa_idtipoalternativa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `idcategoria` int(11) NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`idcategoria`, `descripcion`) VALUES
(1, 'categoriaA'),
(2, 'categoriaB'),
(3, 'categoriaC');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuestionario`
--

CREATE TABLE `cuestionario` (
  `idcuestionario` int(11) NOT NULL,
  `titulo` varchar(45) NOT NULL,
  `fechacreacion` datetime NOT NULL,
  `estado` varchar(45) NOT NULL,
  `fechainicio` datetime DEFAULT NULL,
  `fechafin` datetime DEFAULT NULL,
  `usuario_idusuario` int(11) NOT NULL,
  `categoria_idcategoria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cuestionario`
--

INSERT INTO `cuestionario` (`idcuestionario`, `titulo`, `fechacreacion`, `estado`, `fechainicio`, `fechafin`, `usuario_idusuario`, `categoria_idcategoria`) VALUES
(300, 'CuestionarioNombre', '2017-05-11 03:30:24', 'ACTIVO', '2017-05-11 03:30:24', '2017-05-11 03:30:24', 123, 2),
(400, 'Nombre', '2017-05-11 03:31:45', 'DESACTIVO', '2017-05-11 03:31:45', '2017-05-11 03:31:45', 758, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pregunta`
--

CREATE TABLE `pregunta` (
  `idpregunta` int(11) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `cuestionario_idcuestionario` int(11) NOT NULL,
  `cuestionario_usuario_idusuario` int(11) NOT NULL,
  `cuestionario_idcuestionario1` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipoalternativa`
--

CREATE TABLE `tipoalternativa` (
  `idtipoalternativa` int(11) NOT NULL,
  `descripcion` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL,
  `apellidoPaterno` varchar(45) NOT NULL,
  `apellidoMaterno` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `correo` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idusuario`, `apellidoPaterno`, `apellidoMaterno`, `nombre`, `correo`) VALUES
(1, 'Romano', 'Lara', 'Victor', 'correo@dominio.com'),
(2, 'Moreno', 'Lara', 'Ricardo', 'correo@dominio.com'),
(123, 'Checllo', 'Aguirre', 'Karent', 'karent@gmail.com'),
(758, 'Pumahuacre', 'Navarro', 'Julio', 'juliok144@gmail.com');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alternativa`
--
ALTER TABLE `alternativa`
  ADD PRIMARY KEY (`idalternativa`),
  ADD KEY `fk_Alternativa_Pregunta1_idx` (`pregunta_idpregunta`),
  ADD KEY `fk_Alternativa_TipoAlternativa1_idx` (`tipoalternativa_idtipoalternativa`);

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`idcategoria`);

--
-- Indices de la tabla `cuestionario`
--
ALTER TABLE `cuestionario`
  ADD PRIMARY KEY (`idcuestionario`),
  ADD UNIQUE KEY `idCuestionario_UNIQUE` (`idcuestionario`),
  ADD KEY `fk_Cuestionario_Usuario1_idx` (`usuario_idusuario`),
  ADD KEY `fk_Cuestionario_Categoria1_idx` (`categoria_idcategoria`);

--
-- Indices de la tabla `pregunta`
--
ALTER TABLE `pregunta`
  ADD PRIMARY KEY (`idpregunta`),
  ADD KEY `fk_Pregunta_Cuestionario1_idx` (`cuestionario_idcuestionario1`);

--
-- Indices de la tabla `tipoalternativa`
--
ALTER TABLE `tipoalternativa`
  ADD PRIMARY KEY (`idtipoalternativa`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idusuario`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `alternativa`
--
ALTER TABLE `alternativa`
  ADD CONSTRAINT `fk_Alternativa_Pregunta1` FOREIGN KEY (`pregunta_idpregunta`) REFERENCES `pregunta` (`idpregunta`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Alternativa_TipoAlternativa1` FOREIGN KEY (`tipoalternativa_idtipoalternativa`) REFERENCES `tipoalternativa` (`idtipoalternativa`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `cuestionario`
--
ALTER TABLE `cuestionario`
  ADD CONSTRAINT `fk_Cuestionario_Categoria1` FOREIGN KEY (`categoria_idcategoria`) REFERENCES `categoria` (`idcategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Cuestionario_Usuario1` FOREIGN KEY (`usuario_idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `pregunta`
--
ALTER TABLE `pregunta`
  ADD CONSTRAINT `fk_Pregunta_Cuestionario1` FOREIGN KEY (`cuestionario_idcuestionario1`) REFERENCES `cuestionario` (`idcuestionario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
