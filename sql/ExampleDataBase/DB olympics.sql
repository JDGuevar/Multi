SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Databse: `OLYMPICS`
--
CREATE DATABASE IF NOT EXISTS `OLYMPICS`;
USE `OLYMPICS`;

-- --------------------------------------------------------

--
-- Table structure `STUDENT`
--

DROP TABLE IF EXISTS `STUDENT`;
CREATE TABLE IF NOT EXISTS `STUDENT` (
  `school_id` int NOT NULL,
  `id` int(2) unsigned zerofill NOT NULL,
  `name` varchar(45) NOT NULL,
  `birthdate` date,
  `gender` enum('M','F'),
  PRIMARY KEY (`school_id`,`id`)
) ENGINE=InnoDB;

--
-- `STUDENT` data
--
INSERT INTO `STUDENT` VALUES (1,13,'Alicia Ros Castells','2000-10-25','F');
INSERT INTO `STUDENT` (`school_id`, `id`, `name`, `birthdate`, `gender`) VALUES
(1, 01, ' Gallego Gil, Fernando', '1994-03-24', 'M'),
(1, 02, ' Rocha Gil, Lidia', '1994-02-02', 'F'),
(1, 03, ' Gomez Ceballos, Mario', '1992-07-29', 'M'),
(1, 04, ' Gomez Gomez, Lidia', '1990-08-24', 'F'),
(1, 05, ' Parrado Gomez, Gabriel', '1995-07-16', 'M'),
(1, 06, ' Fernandez Aragon, Lidia', '1990-09-28', 'F'),
(1, 07, ' Rocha Montiel, Alfredo', '1993-04-19', 'M'),
(1, 08, ' Fernandez Ceballos, Irene', '1993-10-13', 'F'),
(1, 09, ' Sanchez del Monte, Fernando', '1997-11-26', 'M'),
(1, 10, ' Alonso Aranda, Rosa', '1999-05-31', 'F'),
(1, 11, ' Argudo Ceballos, Mario', '1994-11-01', 'M'),
(1, 12, ' Gomez Arana, Lidia', '1996-01-05', 'F'),
(2, 01, ' Fernandez Perez, Gonzalo', '1995-05-28', 'M'),
(2, 02, ' Gomez del Monte, Juana', '1998-06-08', 'F'),
(2, 03, ' Cano Ceballos, Gonzalo', '1994-09-30', 'M'),
(2, 04, ' Rodriguez Perez, Inmaculada', '1993-03-30', 'F'),
(2, 05, ' Gomez Aguirre, Alfredo', '1997-08-14', 'M'),
(2, 06, ' Alonso del Valle, Herminia', '1996-09-05', 'F'),
(2, 07, ' Garcia Arana, Angel', '1994-04-17', 'M'),
(2, 08, ' Parrado Arana, Inmaculada', '1992-02-27', 'F'),
(2, 09, ' Argudo Carrasco, Mario', '1996-05-28', 'M'),
(2, 10, ' Fernandez Diaz, Lucia', '1993-05-01', 'F'),
(2, 11, ' Avila Diaz, Gonzalo', '1993-02-17', 'M'),
(2, 12, ' Rodriguez Arana, Irene', '1994-09-27', 'F'),
(3, 01, ' Acevedo del Valle, Moises', '1997-08-24', 'M'),
(3, 02, ' Avila Gil, Irene', '1998-07-24', 'F'),
(3, 03, ' Castilla Carrasco, Juan', '1997-08-19', 'M'),
(3, 04, ' Lopez Carrasco, Inmaculada', '1992-06-06', 'F'),
(3, 05, ' Castilla Aguirre, Lorenzo', '1992-12-13', 'M'),
(3, 06, ' Alonso Gomez, Antonia', '1991-12-11', 'F'),
(3, 07, ' Gallego Ceballos, Moises', '1996-07-06', 'M'),
(3, 08, ' Rodriguez Aragon, Cristina', '1996-03-29', 'F'),
(3, 09, ' Alvarez Rey, Mario', '1994-02-04', 'M'),
(3, 10, ' Gomez Ceballos, Lola', '1999-05-24', 'F'),
(3, 11, ' Lopez Carrasco, Gabriel', '1995-09-10', 'M'),
(3, 12, ' Avila Montiel, Lola', '1998-02-14', 'F'),
(4, 01, ' Jose Gallego Gomez, Juan', '1993-07-12', 'M'),
(4, 02, ' Alonso Aranda, Maria', '1996-11-20', 'F'),
(4, 03, ' Gallego Gil, Luis', '1995-06-22', 'M'),
(4, 04, ' Acevedo Aranda, Lucia', '1994-03-30', 'F'),
(4, 05, ' Argudo Gil, Moises', '1996-05-06', 'M'),
(4, 06, ' Dominguez del Rio, Rosa', '1994-06-04', 'F'),
(4, 07, ' Rodriguez Montiel, Juan', '1997-09-23', 'M'),
(4, 08, ' Castilla Aragon, Herminia', '1994-07-05', 'F'),
(4, 09, ' Fernandez Gallego, Angel', '1999-07-22', 'M'),
(4, 10, ' Cano Aragon, Lucia', '1996-06-04', 'F'),
(4, 11, ' Antonio Lopez Perez, Jose', '1998-04-11', 'M'),
(4, 12, ' Avila Perez, Maria', '1997-12-08', 'F'),
(5, 01, ' Gomez Diaz, Angel', '1990-06-18', 'M'),
(5, 02, ' Garcia Fernandez, Herminia', '1992-07-06', 'F'),
(5, 03, ' Jose Sanchez del Rio, Juan', '1993-12-05', 'M'),
(5, 04, ' Acevedo Diaz, Luisa', '1997-03-04', 'F'),
(5, 05, ' Acevedo Gallego, Ramon', '1997-03-05', 'M'),
(5, 06, ' Castilla del Rio, Rosa', '1991-09-03', 'F'),
(5, 07, ' Alonso Montiel, Luis', '1995-09-05', 'M'),
(5, 08, ' Alvarez Carrasco, Lola', '1996-02-23', 'F'),
(5, 09, ' Rodriguez Aguirre, Moises', '1993-12-18', 'M'),
(5, 10, ' Avila Gallego, Lucia', '1997-01-11', 'F'),
(5, 11, ' Alvarez Rey, Gonzalo', '1993-01-01', 'M'),
(5, 12, ' Castilla Arana, Juana', '1997-09-05', 'F'),
(6, 01, ' Gomez Aguirre, Juan', '1994-06-19', 'M'),
(6, 02, ' Cano Gomez, Antonia', '1997-07-22', 'F'),
(6, 03, ' Castilla Fernandez, Luis', '1994-11-24', 'M'),
(6, 04, ' Alvarez Diaz, Herminia', '1993-05-10', 'F'),
(6, 05, ' Lopez Ceballos, Luis', '1997-06-03', 'M'),
(6, 06, ' Fernandez Aragon, Juana', '1997-04-25', 'F'),
(6, 07, ' Cano Ceballos, Angel', '1999-04-11', 'M'),
(6, 08, ' Rocha Gomez, Lucia', '1990-12-02', 'F'),
(6, 09, ' Alvarez Rey, Ramon', '1993-11-16', 'M'),
(6, 10, ' Gallego Perez, Luisa', '1995-08-03', 'F'),
(6, 11, ' Avila Aguirre, Mario', '1999-08-18', 'M'),
(6, 12, ' Argudo Gomez, Clara', '1997-09-23', 'F'),
(7, 01, ' Dominguez Carrasco, Gonzalo', '1992-01-17', 'M'),
(7, 02, ' Rodriguez Gil, Irene', '1997-03-23', 'F'),
(7, 03, ' Rocha Arana, Gonzalo', '1996-09-12', 'M'),
(7, 04, ' Lopez del Rio, Inmaculada', '1991-11-09', 'F'),
(7, 05, ' Fernandez Aranda, Lorenzo', '1990-05-23', 'M'),
(7, 06, ' Garcia Aguirre, Herminia', '1997-03-16', 'F'),
(7, 07, ' Sanchez Aguirre, Angel', '1999-10-20', 'M'),
(7, 08, ' Lopez Gil, Lucia', '1991-08-07', 'F'),
(7, 09, ' Gallego Aranda, Ramon', '1997-11-13', 'M'),
(7, 10, ' Avila Aguirre, Cristina', '1993-04-21', 'F'),
(7, 11, ' Jose Rodriguez Diaz, Juan', '1999-06-24', 'M'),
(7, 12, ' Parrado Gallego, Maria', '1991-10-22', 'F'),
(8, 01, ' Jose Argudo Aguirre, Juan', '1994-06-17', 'M'),
(8, 02, ' Alvarez Gomez, Irene', '1997-11-15', 'F'),
(8, 03, ' Rocha Rey, Manuel', '1995-04-01', 'M'),
(8, 04, ' Lopez del Valle, Carmen', '1998-08-12', 'F'),
(8, 05, ' Antonio Alonso Fernandez, Jose', '1996-08-11', 'M'),
(8, 06, ' Lopez Ceballos, Maria', '1997-03-07', 'F'),
(8, 07, ' Cano Arana, Elias', '1991-06-26', 'M'),
(8, 08, ' Castilla del Monte, Lidia', '1991-11-06', 'F'),
(8, 09, ' Avila Aguirre, Ramon', '1991-04-28', 'M'),
(8, 10, ' Garcia Carrasco, Lidia', '1990-07-07', 'F'),
(8, 11, ' Fernandez Aranda, Moises', '1996-02-18', 'M'),
(8, 12, ' Lopez del Rio, Rocio', '1994-02-23', 'F');

-- --------------------------------------------------------

--
-- Table structure `SCHOOL`
--

DROP TABLE IF EXISTS `SCHOOL`;
CREATE TABLE IF NOT EXISTS `SCHOOL` (
  `id` int NOT NULL,
  `name` varchar(45) NOT NULL,
  `manager` varchar(45) DEFAULT NULL,
  `city_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

--
-- `SCHOOL` data
--

INSERT INTO `SCHOOL` (`id`, `name`, `manager`, `city_id`) VALUES
(1, 'Romero Vargas', 'Juana', 1),
(2, 'La Granja', 'Miguel', 1),
(3, 'Hozgarganta', 'Ana Maria', 2),
(4, 'Bahia de Cadiz', 'Jaime', 3),
(5, 'San Valeriano', 'Alfonso', 5),
(6, 'Doñana', 'Fernando', 4),
(7, 'Kursaal', 'Alfonso', 6),
(8, 'Drago', 'Maria', 3);

-- --------------------------------------------------------

--
-- Table structure `CITY`
--

DROP TABLE IF EXISTS `CITY`;
CREATE TABLE IF NOT EXISTS `CITY` (
  `id` int NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

--
-- `CITY` data
--

INSERT INTO `CITY` (`id`, `name`) VALUES
(1, 'Jerez'),
(2, 'Jimena'),
(3, 'Cadiz'),
(4, 'Sanlucar'),
(5, 'Algodonales'),
(6, 'Algeciras');

-- --------------------------------------------------------

--
-- Table structure `MODALITY`
--

DROP TABLE IF EXISTS `MODALITY`;
CREATE TABLE IF NOT EXISTS `MODALITY` (
  `id` int NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

--
-- `MODALITY` data
--

INSERT INTO `MODALITY` (`id`, `name`) VALUES
(1, 'Administrative'),
(2, 'Electronics'),
(3, 'Information Technology');

-- --------------------------------------------------------

--
-- Table structure `PARTICIPANT`
--

DROP TABLE IF EXISTS `PARTICIPANT`;
CREATE TABLE IF NOT EXISTS `PARTICIPANT` (
  `student_school_id` int NOT NULL,
  `student_id` int unsigned NOT NULL,
  `modality_id` int NOT NULL,
  PRIMARY KEY (`student_school_id`,`student_id`,`modality_id`)
) ENGINE=InnoDB;

--
-- `PARTICIPANT` data
--

INSERT INTO `PARTICIPANT` (`student_school_id`, `student_id`, `modality_id`) VALUES
(1, 02, 1),
(1, 03, 1),
(1, 04, 1),
(2, 01, 1),
(2, 02, 1),
(2, 03, 1),
(2, 04, 1),
(3, 01, 1),
(3, 02, 1),
(3, 03, 1),
(3, 04, 1),
(4, 01, 1),
(4, 02, 1),
(4, 03, 1),
(4, 04, 1),
(5, 01, 1),
(5, 02, 1),
(5, 03, 1),
(5, 04, 1),
(6, 01, 1),
(6, 02, 1),
(6, 03, 1),
(6, 04, 1),
(7, 01, 1),
(7, 02, 1),
(7, 03, 1),
(7, 04, 1),
(8, 01, 1),
(8, 02, 1),
(8, 03, 1),
(8, 04, 1),
(1, 05, 2),
(1, 06, 2),
(1, 07, 2),
(1, 08, 2),
(2, 05, 2),
(2, 06, 2),
(2, 07, 2),
(2, 08, 2),
(3, 05, 2),
(3, 06, 2),
(3, 07, 2),
(3, 08, 2),
(4, 05, 2),
(4, 06, 2),
(4, 07, 2),
(4, 08, 2),
(5, 05, 2),
(5, 06, 2),
(5, 07, 2),
(5, 08, 2),
(6, 05, 2),
(6, 06, 2),
(6, 07, 2),
(6, 08, 2),
(7, 05, 2),
(7, 06, 2),
(7, 07, 2),
(7, 08, 2),
(8, 05, 2),
(8, 06, 2),
(8, 07, 2),
(8, 08, 2),
(1, 09, 3),
(1, 10, 3),
(1, 11, 3),
(1, 12, 3),
(2, 09, 3),
(2, 10, 3),
(2, 11, 3),
(2, 12, 3),
(3, 09, 3),
(3, 10, 3),
(3, 11, 3),
(3, 12, 3),
(4, 09, 3),
(4, 10, 3),
(4, 11, 3),
(4, 12, 3),
(5, 09, 3),
(5, 10, 3),
(5, 11, 3),
(5, 12, 3),
(6, 09, 3),
(6, 10, 3),
(6, 11, 3),
(6, 12, 3),
(7, 09, 3),
(7, 10, 3),
(7, 11, 3),
(7, 12, 3),
(8, 09, 3),
(8, 10, 3),
(8, 11, 3),
(8, 12, 3);

-- --------------------------------------------------------

--
-- Table structure`WINNER`
--

DROP TABLE IF EXISTS `WINNER`;
CREATE TABLE IF NOT EXISTS `WINNER` (
  `school_id` int NOT NULL,
  `modality_id` int NOT NULL,
  `position` enum('1','2','3') NOT NULL,
  PRIMARY KEY (`school_id`,`modality_id`,`position`)
) ENGINE=InnoDB;

--
-- Dades per la taula `WINNER`
--

INSERT INTO `WINNER` (`school_id`, `modality_id`, `position`) VALUES
(1, 1, '2'),
(1, 2, '1'),
(1, 3, '1'),
(2, 1, '3'),
(3, 1, '1'),
(3, 3, '3'),
(5, 2, '2'),
(6, 3, '2'),
(7, 2, '3');

--
-- Restrictions
--

--
-- Foreign keys for `STUDENT` table
--
ALTER TABLE `STUDENT`
  ADD FOREIGN KEY (`school_id`) REFERENCES `SCHOOL` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Foreign keys for `SCHOOL` table
--
ALTER TABLE `SCHOOL`
  ADD FOREIGN KEY (`city_id`) REFERENCES `CITY` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Foreign keys for `PARTICIPANT` table
--
ALTER TABLE `PARTICIPANT`
  ADD FOREIGN KEY (`student_school_id`, `student_id`) REFERENCES `STUDENT` (`school_id`, `id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD FOREIGN KEY (`modality_id`) REFERENCES `MODALITY` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Foreign keys for `WINNER` table
--
ALTER TABLE `WINNER`
  ADD FOREIGN KEY (`modality_id`) REFERENCES `MODALITY` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD FOREIGN KEY (`school_id`) REFERENCES `SCHOOL` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
