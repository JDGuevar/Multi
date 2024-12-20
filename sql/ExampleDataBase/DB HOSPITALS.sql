CREATE DATABASE  IF NOT EXISTS `HOSPITALS` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `HOSPITALS`;
-- MySQL dump 10.13  Distrib 5.7.17, for Linux (x86_64)
--
-- Host: localhost    Database: HOSPITAL
-- ------------------------------------------------------
-- Server version	5.7.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `DOCTOR`
--

DROP TABLE IF EXISTS `DOCTOR`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DOCTOR` (
  `HOSPITAL_COD` tinyint(2) NOT NULL,
  `DOCTOR_NO` smallint(3) NOT NULL,
  `LASTNAME` varchar(13) NOT NULL,
  `SPECIALITY` varchar(16) NOT NULL,
  PRIMARY KEY (`HOSPITAL_COD`,`DOCTOR_NO`),
  KEY `IDX_DOCTOR_HOSP` (`HOSPITAL_COD`),
  KEY `DOCTOR_ESP_HOSP` (`SPECIALITY`,`HOSPITAL_COD`),
  KEY `DOCTOR_HOSP_ESP` (`HOSPITAL_COD`,`SPECIALITY`),
  CONSTRAINT `DOCTOR_ibfk_1` FOREIGN KEY (`HOSPITAL_COD`) REFERENCES `HOSPITAL` (`HOSPITAL_COD`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DOCTOR`
--

LOCK TABLES `DOCTOR` WRITE;
/*!40000 ALTER TABLE `DOCTOR` DISABLE KEYS */;
INSERT INTO `DOCTOR` VALUES (13,435,'López A.','Cardiologia'),(18,585,'Miller G.','Ginecologia'),(18,982,'Cajal R.','Cardiologia'),(22,386,'Cabeza D.','Psiquiatria'),(22,398,'Best K.','Urologia'),(22,453,'Galo D.','Pediatria'),(45,522,'Adams C.','Neurologia'),(45,607,'Nico P.','Pediatria');
/*!40000 ALTER TABLE `DOCTOR` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `HOSPITAL`
--

DROP TABLE IF EXISTS `HOSPITAL`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `HOSPITAL` (
  `HOSPITAL_COD` tinyint(2) NOT NULL,
  `NAME` varchar(10) NOT NULL,
  `ADDRESS` varchar(20) DEFAULT NULL,
  `PHONE` varchar(8) DEFAULT NULL,
  `QTTY_BEDS` smallint(3) unsigned DEFAULT '0',
  PRIMARY KEY (`HOSPITAL_COD`),
  KEY `HOSPITAL_NAME` (`NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `HOSPITAL`
--

LOCK TABLES `HOSPITAL` WRITE;
/*!40000 ALTER TABLE `HOSPITAL` DISABLE KEYS */;
INSERT INTO `HOSPITAL` VALUES (13,'Provincial','O Donell 50','964-4264',88),(18,'General','Atocha s/n','595-3111',63),(22,'La Paz','Castellana 1000','923-5411',162),(45,'San Carlos','Ciudad Universitaria','597-1500',92);
/*!40000 ALTER TABLE `HOSPITAL` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `HOSPITALIZATION`
--

DROP TABLE IF EXISTS `HOSPITALIZATION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `HOSPITALIZATION` (
  `INSCRIPTION` int(5) NOT NULL,
  `HOSPITAL_COD` tinyint(2) NOT NULL,
  `ROOM_COD` tinyint(2) NOT NULL,
  `BED` smallint(4) unsigned DEFAULT NULL,
  `ENTRYDATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ENDDATE` datetime DEFAULT NULL,
  PRIMARY KEY (`INSCRIPTION`),
  KEY `IDX_HOSPITALISATION_INSCRIPTION` (`INSCRIPTION`),
  KEY `IDX_HOSPITALISATION_HOSP_ROOM` (`HOSPITAL_COD`,`ROOM_COD`),
  KEY `HOSPITALISATION_HOSP_ROOM` (`HOSPITAL_COD`,`ROOM_COD`),
  CONSTRAINT `HOSPITALIZATION_ibfk_1` FOREIGN KEY (`INSCRIPTION`) REFERENCES `PATIENT` (`INSCRIPTION`),
  CONSTRAINT `HOSPITALIZATION_ibfk_2` FOREIGN KEY (`HOSPITAL_COD`, `ROOM_COD`) REFERENCES `ROOM` (`HOSPITAL_COD`, `ROOM_COD`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `HOSPITALIZATION`
--

LOCK TABLES `HOSPITALIZATION` WRITE;
/*!40000 ALTER TABLE `HOSPITALIZATION` DISABLE KEYS */;
INSERT INTO `HOSPITALIZATION` VALUES (10995,13,3,1,'2019-04-23 10:03:07',NULL),(14024,13,3,3,'2019-04-23 10:03:07',NULL),(18004,13,3,2,'2019-04-23 10:03:07',NULL),(36658,18,4,1,'2019-04-23 10:03:07',NULL),(38702,18,4,2,'2019-04-23 10:03:07',NULL),(39217,22,6,1,'2019-04-23 10:03:07',NULL),(59076,22,6,2,'2019-04-23 10:03:07',NULL),(63827,22,6,3,'2019-04-23 10:03:07',NULL),(64823,22,2,1,'2019-04-23 10:03:07',NULL);
/*!40000 ALTER TABLE `HOSPITALIZATION` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PATIENT`
--

DROP TABLE IF EXISTS `PATIENT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PATIENT` (
  `INSCRIPTION` int(5) NOT NULL,
  `LASTNAME` varchar(15) NOT NULL,
  `ADDRESS` varchar(20) DEFAULT NULL,
  `BIRTHDATE` date DEFAULT NULL,
  `SEX` char(1) NOT NULL,
  `SOCIALSECURITYNUMBER` char(9) DEFAULT NULL,
  PRIMARY KEY (`INSCRIPTION`),
  KEY `PATIENT_NAIX_LASTNAME` (`BIRTHDATE`,`LASTNAME`),
  KEY `PATIENT_LASTNAME_NAIX` (`LASTNAME`,`BIRTHDATE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PATIENT`
--

LOCK TABLES `PATIENT` WRITE;
/*!40000 ALTER TABLE `PATIENT` DISABLE KEYS */;
INSERT INTO `PATIENT` VALUES (10995,'Laguía M.','Goya 20','1956-05-16','H','280862482'),(14024,'Fernández M.','Recoletos 50','1967-06-23','D','321790059'),(18004,'Serrano V.','Alcala 12','1960-05-21','D','284991452'),(36658,'Domin S.','Mayor 71','1942-01-01','H','160657471'),(38702,'Neal R.','Orense 11','1940-06-18','D','380010217'),(39217,'Cervantes M.','Peron 38','1952-02-29','H','440294390'),(59076,'Miller G.','Lopez de Hoyos 2','1945-09-16','D','311969044'),(63827,'Ruíz P.','Esquerdo 103','1980-12-26','H','100973253'),(64823,'Fraser A.','Soto 3','1980-07-10','D','285201776'),(74835,'Benítez E.','Argentina 5','1957-10-05','H','154811767');
/*!40000 ALTER TABLE `PATIENT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ROOM`
--

DROP TABLE IF EXISTS `ROOM`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ROOM` (
  `HOSPITAL_COD` tinyint(2) NOT NULL,
  `ROOM_COD` tinyint(2) NOT NULL,
  `NAME` varchar(20) NOT NULL,
  `QTTY_BEDS` smallint(3) unsigned DEFAULT '0',
  PRIMARY KEY (`HOSPITAL_COD`,`ROOM_COD`),
  KEY `IDX_ROOM_HOSPITAL_COD` (`HOSPITAL_COD`),
  KEY `ROOM_HOSP_NAME` (`HOSPITAL_COD`,`NAME`),
  CONSTRAINT `ROOM_ibfk_1` FOREIGN KEY (`HOSPITAL_COD`) REFERENCES `HOSPITAL` (`HOSPITAL_COD`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ROOM`
--

LOCK TABLES `ROOM` WRITE;
/*!40000 ALTER TABLE `ROOM` DISABLE KEYS */;
INSERT INTO `ROOM` VALUES (13,3,'Cures Intensives',21),(13,6,'Psiquiàtric',67),(18,3,'Cures Intensives',10),(18,4,'Cardiologia',53),(22,1,'Recuperació',10),(22,2,'Maternitat',34),(22,6,'Psiquiàtric',118),(45,1,'Recuperació',13),(45,2,'Maternitat',24),(45,4,'Cardiologia',55);
/*!40000 ALTER TABLE `ROOM` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `STAFF`
--

DROP TABLE IF EXISTS `STAFF`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `STAFF` (
  `HOSPITAL_COD` tinyint(2) NOT NULL,
  `ROOM_COD` tinyint(2) NOT NULL,
  `EMPLOYEE_NO` smallint(4) NOT NULL,
  `LASTNAME` varchar(15) NOT NULL,
  `FUNCTION` varchar(10) DEFAULT NULL,
  `SHIFT` varchar(1) DEFAULT NULL,
  `ROOMRI` int(10) DEFAULT NULL,
  PRIMARY KEY (`HOSPITAL_COD`,`ROOM_COD`,`EMPLOYEE_NO`),
  KEY `IDX_STAFF_HOSP_ROOM` (`HOSPITAL_COD`,`ROOM_COD`),
  KEY `STAFF_HOSP_LASTNAME` (`HOSPITAL_COD`,`LASTNAME`),
  KEY `STAFF_HOSP_FUNCTION` (`HOSPITAL_COD`,`FUNCTION`),
  KEY `STAFF_FUNCTION_HOSP_ROOM` (`FUNCTION`,`HOSPITAL_COD`,`ROOM_COD`),
  CONSTRAINT `STAFF_ibfk_1` FOREIGN KEY (`HOSPITAL_COD`, `ROOM_COD`) REFERENCES `ROOM` (`HOSPITAL_COD`, `ROOM_COD`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `STAFF`
--

LOCK TABLES `STAFF` WRITE;
/*!40000 ALTER TABLE `STAFF` DISABLE KEYS */;
INSERT INTO `STAFF` VALUES (13,6,3106,'Hernández J.','Infermer','T',2755000),(13,6,3754,'Díaz B.','Infermera','T',2262000),(18,4,6357,'Karplus W.','Intern','T',3379000),(22,1,6065,'Rivera G.','Infermera','N',1626000),(22,1,7379,'Carlos R.','Infermera','T',2119000),(22,2,9901,'Adams C.','Intern','M',2210000),(22,6,1009,'Higueras D.','Infermera','T',2005000),(22,6,8422,'Bocina G.','Infermer','M',1638000),(45,1,8526,'Frank H.','Infermera','T',2522000),(45,4,1280,'Amigó R.','Intern','N',2210000);
/*!40000 ALTER TABLE `STAFF` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'HOSPITAL'
--

--
-- Dumping routines for database 'HOSPITAL'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-23 12:45:56
