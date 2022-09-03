-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         8.0.30 - MySQL Community Server - GPL
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para banca
DROP DATABASE IF EXISTS `banca`;
CREATE DATABASE IF NOT EXISTS `banca` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `banca`;

-- Volcando estructura para tabla banca.cliente
DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
  `cli_clave` varchar(12) DEFAULT NULL,
  `cli_estado` bit(1) DEFAULT NULL,
  `per_id` int NOT NULL,
  PRIMARY KEY (`per_id`),
  CONSTRAINT `FKndty26om7h6vrb00nyfg86qmc` FOREIGN KEY (`per_id`) REFERENCES `persona` (`per_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla banca.cliente: ~3 rows (aproximadamente)
DELETE FROM `cliente`;
INSERT INTO `cliente` (`cli_clave`, `cli_estado`, `per_id`) VALUES
	('1234', b'1', 3),
	('5678', b'1', 4),
	('1245', b'1', 5);

-- Volcando estructura para tabla banca.cuenta
DROP TABLE IF EXISTS `cuenta`;
CREATE TABLE IF NOT EXISTS `cuenta` (
  `cue_id` int NOT NULL AUTO_INCREMENT,
  `cue_estado` bit(1) DEFAULT NULL,
  `cue_numero` varchar(15) DEFAULT NULL,
  `cue_saldo_inicial` int DEFAULT NULL,
  `cue_tipo` varchar(10) DEFAULT NULL,
  `per_id` int DEFAULT NULL,
  PRIMARY KEY (`cue_id`),
  KEY `FK5yb81lite23w8sduulkh327ug` (`per_id`),
  CONSTRAINT `FK5yb81lite23w8sduulkh327ug` FOREIGN KEY (`per_id`) REFERENCES `cliente` (`per_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla banca.cuenta: ~5 rows (aproximadamente)
DELETE FROM `cuenta`;
INSERT INTO `cuenta` (`cue_id`, `cue_estado`, `cue_numero`, `cue_saldo_inicial`, `cue_tipo`, `per_id`) VALUES
	(2, b'1', '478758', 2000, 'ahorros', 3),
	(3, b'1', '225487', 100, 'corriente', 4),
	(4, b'1', '495878', 0, 'ahorros', 5),
	(5, b'1', '496825', 540, 'ahorros', 4),
	(6, b'1', '585545', 1000, 'corriente', 3);

-- Volcando estructura para procedimiento banca.GET_REPORTE
DROP PROCEDURE IF EXISTS `GET_REPORTE`;
DELIMITER //
CREATE PROCEDURE `GET_REPORTE`(
	IN `id` INT,
	IN `fecha1` VARCHAR(10),
	IN `fecha2` VARCHAR(10)
)
BEGIN
	DELETE FROM reporte;
	
	INSERT INTO reporte(cliente, cuenta, estado, fecha, movimiento, saldo_disponible, saldo_inicial, tipo)
	SELECT p.per_nombre, c.cue_numero, c.cue_estado, m.mov_fecha, m.mov_valor, m.mov_saldo, c.cue_saldo_inicial, c.cue_tipo
	FROM movimiento m, cuenta c, cliente cl, persona p
	WHERE m.cue_id = c.cue_id
	AND c.per_id = cl.per_id
	AND c.per_id = p.per_id
	AND cl.per_id = id
	AND m.mov_fecha BETWEEN fecha1 AND fecha2;
	
	SELECT * FROM reporte;
		
END//
DELIMITER ;

-- Volcando estructura para procedimiento banca.GET_SALDO_INICIAL
DROP PROCEDURE IF EXISTS `GET_SALDO_INICIAL`;
DELIMITER //
CREATE PROCEDURE `GET_SALDO_INICIAL`(
	IN `id` INT,
	OUT `saldo` int
)
BEGIN
	DECLARE s INT;

   SELECT ifnull(count(mov_saldo),0) INTO s
	from movimiento
	WHERE cue_id = id;
	
	IF s = 0 THEN
		SELECT cue_saldo_inicial INTO saldo
		FROM cuenta
		WHERE cue_id = id;
	ELSE
		SELECT mov_saldo INTO saldo
		from movimiento
		WHERE cue_id = id
		ORDER BY mov_id desc
		LIMIT 1;
   END IF;
		
END//
DELIMITER ;

-- Volcando estructura para procedimiento banca.GET_TOTAL_SALDO
DROP PROCEDURE IF EXISTS `GET_TOTAL_SALDO`;
DELIMITER //
CREATE PROCEDURE `GET_TOTAL_SALDO`(
	IN `id_in` int,
	IN `fecha_in` VARCHAR(10),
	OUT `sum_out` INT
)
BEGIN
	   SELECT IFNULL(SUM(mov_valor)*-1,0) INTO sum_out
		from movimiento
		WHERE mov_tipo = 'debito'
		AND cue_id = id_in
		AND mov_fecha = fecha_in;
END//
DELIMITER ;

-- Volcando estructura para tabla banca.movimiento
DROP TABLE IF EXISTS `movimiento`;
CREATE TABLE IF NOT EXISTS `movimiento` (
  `mov_id` int NOT NULL AUTO_INCREMENT,
  `mov_fecha` date DEFAULT NULL,
  `mov_saldo` int DEFAULT NULL,
  `mov_tipo` varchar(10) DEFAULT NULL,
  `mov_valor` int DEFAULT NULL,
  `cue_id` int DEFAULT NULL,
  PRIMARY KEY (`mov_id`),
  KEY `FKdd212o9iax2xcvs8v4qe1248w` (`cue_id`),
  CONSTRAINT `FKdd212o9iax2xcvs8v4qe1248w` FOREIGN KEY (`cue_id`) REFERENCES `cuenta` (`cue_id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla banca.movimiento: ~4 rows (aproximadamente)
DELETE FROM `movimiento`;
INSERT INTO `movimiento` (`mov_id`, `mov_fecha`, `mov_saldo`, `mov_tipo`, `mov_valor`, `cue_id`) VALUES
	(33, '2022-09-02', 1425, 'debito', -575, 2),
	(34, '2022-09-02', 700, 'credito', 600, 3),
	(35, '2022-09-02', 150, 'credito', 150, 4),
	(36, '2022-09-02', 0, 'debito', -540, 5);

-- Volcando estructura para tabla banca.persona
DROP TABLE IF EXISTS `persona`;
CREATE TABLE IF NOT EXISTS `persona` (
  `per_id` int NOT NULL AUTO_INCREMENT,
  `per_direccion` varchar(255) DEFAULT NULL,
  `per_edad` int DEFAULT NULL,
  `per_genero` varchar(15) DEFAULT NULL,
  `per_identificacion` varchar(10) DEFAULT NULL,
  `per_nombre` varchar(100) DEFAULT NULL,
  `per_telefono` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`per_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla banca.persona: ~3 rows (aproximadamente)
DELETE FROM `persona`;
INSERT INTO `persona` (`per_id`, `per_direccion`, `per_edad`, `per_genero`, `per_identificacion`, `per_nombre`, `per_telefono`) VALUES
	(3, 'Otavalo sn y principal', 20, 'masculino', '1712345679', 'Jose Lema', '098254785'),
	(4, 'Amazonas y  NNUU', 30, 'femenino', '1712345680', 'Marianela Montalvo', '097548965'),
	(5, '13 junio y Equinoccial', 40, 'masculino', '1712345681', 'Juan Osorio', '098874587');

-- Volcando estructura para tabla banca.reporte
DROP TABLE IF EXISTS `reporte`;
CREATE TABLE IF NOT EXISTS `reporte` (
  `r_id` int NOT NULL AUTO_INCREMENT,
  `cliente` varchar(255) DEFAULT NULL,
  `cuenta` varchar(255) DEFAULT NULL,
  `estado` bit(1) NOT NULL,
  `fecha` varchar(255) DEFAULT NULL,
  `movimiento` int NOT NULL,
  `saldo_disponible` int NOT NULL,
  `saldo_inicial` int NOT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`r_id`)
) ENGINE=InnoDB AUTO_INCREMENT=334 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla banca.reporte: ~0 rows (aproximadamente)
DELETE FROM `reporte`;
INSERT INTO `reporte` (`r_id`, `cliente`, `cuenta`, `estado`, `fecha`, `movimiento`, `saldo_disponible`, `saldo_inicial`, `tipo`) VALUES
	(331, 'Marianela Montalvo', '225487', b'1', '2022-09-02', 600, 700, 100, 'corriente'),
	(332, 'Marianela Montalvo', '496825', b'1', '2022-09-02', -540, 0, 540, 'ahorros');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
