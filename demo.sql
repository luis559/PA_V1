-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.1.37-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win32
-- HeidiSQL Versión:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para demo
CREATE DATABASE IF NOT EXISTS `demo` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `demo`;

-- Volcando estructura para tabla demo.persona
CREATE TABLE IF NOT EXISTS `persona` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla demo.persona: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` (`id`, `nombre`) VALUES
	(1, 'juan'),
	(2, 'pedro'),
	(17, 'Pablo Marmol');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;

-- Volcando estructura para tabla demo.personal
CREATE TABLE IF NOT EXISTS `personal` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `cargo` varchar(255) DEFAULT NULL,
  `sueldo` varchar(255) DEFAULT NULL,
  `edad` varchar(255) DEFAULT NULL,
  `celular` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla demo.personal: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `personal` DISABLE KEYS */;
INSERT INTO `personal` (`id`, `created_at`, `nombre`, `cargo`, `sueldo`, `edad`, `celular`) VALUES
	(1, NULL, 'luis', 'almacenista', '5,000', '20', '9191456325');
/*!40000 ALTER TABLE `personal` ENABLE KEYS */;

-- Volcando estructura para tabla demo.productos
CREATE TABLE IF NOT EXISTS `productos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla demo.productos: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` (`id`, `created_at`, `descripcion`, `nombre`) VALUES
	(6, NULL, 'foco de 100w', 'foco'),
	(7, NULL, 'marca china', 'arduino uno');
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;

-- Volcando estructura para tabla demo.proveedores
CREATE TABLE IF NOT EXISTS `proveedores` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `numero` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla demo.proveedores: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
INSERT INTO `proveedores` (`id`, `created_at`, `nombre`, `estado`, `numero`) VALUES
	(1, NULL, 'altos de chiapas ', 'chiapas', '9191234567'),
	(2, '2019-12-13 04:45:45', 'ferresur', 'chiapas', '9191478523'),
	(4, '2019-12-13 05:58:30', 'grijalva ', 'chiapas', '9191459687'),
	(5, '2019-12-13 07:54:27', 'don bosco', 'chiapas', '9196732565');
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;

-- Volcando estructura para procedimiento demo.sppersonalsearch
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `sppersonalsearch`()
BEGIN
SELECT p.* FROM personal p where p.nombre like concat("%",arg,"%") or cargo like concat("%",arg,"%") or sueldo like concat("%",arg,"%") or edad like concat("%",arg,"%") or celular like concat("%",arg,"%");
END//
DELIMITER ;

-- Volcando estructura para procedimiento demo.spproductosearch
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spproductosearch`(IN arg varchar(30))
BEGIN 
    SELECT p.* FROM productos p where p.nombre like concat("%",arg,"%") or descripcion like concat("%",arg,"%");
END//
DELIMITER ;

-- Volcando estructura para procedimiento demo.spproveedores
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spproveedores`()
BEGIN
  SELECT p.* FROM proveedores p where p.nombre like concat("%",arg,"%") or estado like concat("%",arg,"%") or numero like concat("%",arg,"%");
END//
DELIMITER ;

-- Volcando estructura para procedimiento demo.spsucursalessearch
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spsucursalessearch`()
BEGIN
SELECT p.* FROM sucursales p where p.nombre like concat("%",arg,"%") or ciudad like concat("%",arg,"%") or direccion like concat("%",arg,"%") or telefono like concat("%",arg,"%") or gerencia like concat("%",arg,"%");
END//
DELIMITER ;

-- Volcando estructura para tabla demo.sucursales
CREATE TABLE IF NOT EXISTS `sucursales` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `ciudad` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `gerencia` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla demo.sucursales: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `sucursales` DISABLE KEYS */;
INSERT INTO `sucursales` (`id`, `created_at`, `nombre`, `ciudad`, `direccion`, `telefono`, `gerencia`) VALUES
	(1, NULL, 'las palmas', 'jalisco', 'fraccionamiento num 25', '6731425', 'mateo');
/*!40000 ALTER TABLE `sucursales` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
