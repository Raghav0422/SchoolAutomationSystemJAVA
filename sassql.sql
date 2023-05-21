CREATE DATABASE  IF NOT EXISTS `sas` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `sas`;
-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: sas
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `courses` (
  `Id` int(11) NOT NULL,
  `Name` varchar(20) DEFAULT NULL,
  `Fee` int(11) DEFAULT NULL,
  `AdmissionFee` int(6) DEFAULT NULL,
  `PerMFee` int(11) DEFAULT NULL,
  `ExamFee` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Name_UNIQUE` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES (1,'First',3600,100,300,50),(2,'Second',4800,150,400,50),(3,'Third',6000,200,500,50),(4,'Fourth',7200,250,600,50),(5,'Fifth',8400,300,700,50),(6,'Sixth',9600,350,800,50),(7,'Seventh',10800,400,900,50),(8,'Eight',12000,450,1000,NULL),(9,'Ninth',13200,500,1100,NULL);
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `courses_BEFORE_INSERT` BEFORE INSERT ON `courses` FOR EACH ROW BEGIN
declare perMfee int;
    
    set perMfee=new.PerMfee;
    set new.Fee=12*perMFee;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `fee`
--

DROP TABLE IF EXISTS `fee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `fee` (
  `S_Id` int(11) NOT NULL,
  `C_Id` int(11) DEFAULT NULL,
  `C_Rlno` int(11) DEFAULT NULL,
  `jan` int(11) DEFAULT NULL,
  `feb` int(11) DEFAULT NULL,
  `mar` int(11) DEFAULT NULL,
  `apr` int(11) DEFAULT NULL,
  `may` int(11) DEFAULT NULL,
  `jun` int(11) DEFAULT NULL,
  `jul` int(11) DEFAULT NULL,
  `aug` int(11) DEFAULT NULL,
  `sep` int(11) DEFAULT NULL,
  `oct` int(11) DEFAULT NULL,
  `nov` int(11) DEFAULT NULL,
  `decm` int(11) DEFAULT NULL,
  `year1` int(11) DEFAULT NULL,
  `year2` int(11) DEFAULT NULL,
  PRIMARY KEY (`S_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fee`
--

LOCK TABLES `fee` WRITE;
/*!40000 ALTER TABLE `fee` DISABLE KEYS */;
INSERT INTO `fee` VALUES (1,4,1,0,0,0,600,600,600,600,600,600,600,600,600,2021,2022),(2,6,1,0,0,800,800,800,800,800,800,800,800,800,800,2021,2022),(3,7,1,0,900,900,900,900,900,900,900,900,900,900,900,2021,2022),(4,7,2,900,900,900,900,900,900,900,900,900,900,900,900,2021,2022),(5,6,2,800,800,800,800,800,800,800,800,800,800,800,800,2021,2022),(6,6,3,800,800,800,800,800,800,800,800,800,800,800,800,2021,2022),(7,7,3,900,900,900,900,900,900,900,900,900,900,900,900,2021,2022),(8,4,2,0,0,600,600,600,600,600,600,600,600,600,600,2021,2022),(9,4,3,0,600,600,600,600,600,600,600,600,600,600,600,2021,2022),(10,4,4,600,600,600,600,600,600,600,600,600,600,600,600,2021,2022);
/*!40000 ALTER TABLE `fee` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `fee_AFTER_UPDATE` AFTER UPDATE ON `fee` FOR EACH ROW BEGIN
	insert into sas.receipt (C_Id,C_Rn,ReceiptDate,Reason) values (new.C_Id,new.C_Rlno,current_date(),"Monthly Fees");
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `marks`
--

DROP TABLE IF EXISTS `marks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `marks` (
  `srno` int(11) NOT NULL AUTO_INCREMENT,
  `S_Id` int(11) NOT NULL,
  `C_Id` int(11) NOT NULL,
  `Sub_Id` int(11) NOT NULL,
  `Term` int(11) NOT NULL,
  `Marks` int(11) DEFAULT NULL,
  `C_RollNo` int(11) NOT NULL,
  PRIMARY KEY (`srno`)
) ENGINE=InnoDB AUTO_INCREMENT=265 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marks`
--

LOCK TABLES `marks` WRITE;
/*!40000 ALTER TABLE `marks` DISABLE KEYS */;
INSERT INTO `marks` VALUES (1,1,4,1,1,98,1),(2,1,4,2,1,96,1),(3,1,4,3,1,87,1),(4,1,4,4,1,89,1),(5,1,4,5,1,98,1),(6,1,4,6,1,78,1),(7,1,4,7,1,76,1),(8,1,4,8,1,45,1),(9,1,4,9,1,45,1),(10,1,4,10,1,33,1),(11,1,4,1,2,20,1),(12,1,4,2,2,0,1),(13,1,4,3,2,0,1),(14,1,4,4,2,0,1),(15,1,4,5,2,0,1),(16,1,4,6,2,0,1),(17,1,4,7,2,0,1),(18,1,4,8,2,0,1),(19,1,4,9,2,0,1),(20,1,4,10,2,0,1),(21,1,4,1,3,30,1),(22,1,4,2,3,NULL,1),(23,1,4,3,3,NULL,1),(24,1,4,4,3,NULL,1),(25,1,4,5,3,NULL,1),(26,1,4,6,3,NULL,1),(27,1,4,7,3,NULL,1),(28,1,4,8,3,NULL,1),(29,1,4,9,3,NULL,1),(30,1,4,10,3,NULL,1),(31,2,6,1,1,NULL,1),(32,2,6,2,1,NULL,1),(33,2,6,3,1,NULL,1),(34,2,6,4,1,NULL,1),(35,2,6,5,1,NULL,1),(36,2,6,6,1,NULL,1),(37,2,6,7,1,NULL,1),(38,2,6,8,1,NULL,1),(39,2,6,1,2,NULL,1),(40,2,6,2,2,NULL,1),(41,2,6,3,2,NULL,1),(42,2,6,4,2,NULL,1),(43,2,6,5,2,NULL,1),(44,2,6,6,2,NULL,1),(45,2,6,7,2,NULL,1),(46,2,6,8,2,NULL,1),(47,2,6,1,3,NULL,1),(48,2,6,2,3,NULL,1),(49,2,6,3,3,NULL,1),(50,2,6,4,3,NULL,1),(51,2,6,5,3,NULL,1),(52,2,6,6,3,NULL,1),(53,2,6,7,3,NULL,1),(54,2,6,8,3,NULL,1),(55,3,7,1,1,NULL,1),(56,3,7,2,1,NULL,1),(57,3,7,3,1,NULL,1),(58,3,7,4,1,NULL,1),(59,3,7,5,1,NULL,1),(60,3,7,6,1,NULL,1),(61,3,7,7,1,NULL,1),(62,3,7,8,1,NULL,1),(63,3,7,1,2,NULL,1),(64,3,7,2,2,NULL,1),(65,3,7,3,2,NULL,1),(66,3,7,4,2,NULL,1),(67,3,7,5,2,NULL,1),(68,3,7,6,2,NULL,1),(69,3,7,7,2,NULL,1),(70,3,7,8,2,NULL,1),(71,3,7,1,3,NULL,1),(72,3,7,2,3,NULL,1),(73,3,7,3,3,NULL,1),(74,3,7,4,3,NULL,1),(75,3,7,5,3,NULL,1),(76,3,7,6,3,NULL,1),(77,3,7,7,3,NULL,1),(78,3,7,8,3,NULL,1),(79,4,7,1,1,NULL,2),(80,4,7,2,1,NULL,2),(81,4,7,3,1,NULL,2),(82,4,7,4,1,NULL,2),(83,4,7,5,1,NULL,2),(84,4,7,6,1,NULL,2),(85,4,7,7,1,NULL,2),(86,4,7,8,1,NULL,2),(87,4,7,1,2,NULL,2),(88,4,7,2,2,NULL,2),(89,4,7,3,2,NULL,2),(90,4,7,4,2,NULL,2),(91,4,7,5,2,NULL,2),(92,4,7,6,2,NULL,2),(93,4,7,7,2,NULL,2),(94,4,7,8,2,NULL,2),(95,4,7,1,3,NULL,2),(96,4,7,2,3,NULL,2),(97,4,7,3,3,NULL,2),(98,4,7,4,3,NULL,2),(99,4,7,5,3,NULL,2),(100,4,7,6,3,NULL,2),(101,4,7,7,3,NULL,2),(102,4,7,8,3,NULL,2),(103,5,6,1,1,NULL,2),(104,5,6,2,1,NULL,2),(105,5,6,3,1,NULL,2),(106,5,6,4,1,NULL,2),(107,5,6,5,1,NULL,2),(108,5,6,6,1,NULL,2),(109,5,6,7,1,NULL,2),(110,5,6,8,1,NULL,2),(111,5,6,1,2,NULL,2),(112,5,6,2,2,NULL,2),(113,5,6,3,2,NULL,2),(114,5,6,4,2,NULL,2),(115,5,6,5,2,NULL,2),(116,5,6,6,2,NULL,2),(117,5,6,7,2,NULL,2),(118,5,6,8,2,NULL,2),(119,5,6,1,3,NULL,2),(120,5,6,2,3,NULL,2),(121,5,6,3,3,NULL,2),(122,5,6,4,3,NULL,2),(123,5,6,5,3,NULL,2),(124,5,6,6,3,NULL,2),(125,5,6,7,3,NULL,2),(126,5,6,8,3,NULL,2),(127,6,6,1,1,NULL,3),(128,6,6,2,1,NULL,3),(129,6,6,3,1,NULL,3),(130,6,6,4,1,NULL,3),(131,6,6,5,1,NULL,3),(132,6,6,6,1,NULL,3),(133,6,6,7,1,NULL,3),(134,6,6,8,1,NULL,3),(135,6,6,1,2,NULL,3),(136,6,6,2,2,NULL,3),(137,6,6,3,2,NULL,3),(138,6,6,4,2,NULL,3),(139,6,6,5,2,NULL,3),(140,6,6,6,2,NULL,3),(141,6,6,7,2,NULL,3),(142,6,6,8,2,NULL,3),(143,6,6,1,3,NULL,3),(144,6,6,2,3,NULL,3),(145,6,6,3,3,NULL,3),(146,6,6,4,3,NULL,3),(147,6,6,5,3,NULL,3),(148,6,6,6,3,NULL,3),(149,6,6,7,3,NULL,3),(150,6,6,8,3,NULL,3),(151,7,7,1,1,NULL,3),(152,7,7,2,1,NULL,3),(153,7,7,3,1,NULL,3),(154,7,7,4,1,NULL,3),(155,7,7,5,1,NULL,3),(156,7,7,6,1,NULL,3),(157,7,7,7,1,NULL,3),(158,7,7,8,1,NULL,3),(159,7,7,1,2,NULL,3),(160,7,7,2,2,NULL,3),(161,7,7,3,2,NULL,3),(162,7,7,4,2,NULL,3),(163,7,7,5,2,NULL,3),(164,7,7,6,2,NULL,3),(165,7,7,7,2,NULL,3),(166,7,7,8,2,NULL,3),(167,7,7,1,3,NULL,3),(168,7,7,2,3,NULL,3),(169,7,7,3,3,NULL,3),(170,7,7,4,3,NULL,3),(171,7,7,5,3,NULL,3),(172,7,7,6,3,NULL,3),(173,7,7,7,3,NULL,3),(174,7,7,8,3,NULL,3),(175,8,4,1,1,78,2),(176,8,4,2,1,87,2),(177,8,4,3,1,78,2),(178,8,4,4,1,98,2),(179,8,4,5,1,67,2),(180,8,4,6,1,98,2),(181,8,4,7,1,67,2),(182,8,4,8,1,34,2),(183,8,4,9,1,43,2),(184,8,4,10,1,34,2),(185,8,4,1,2,200,2),(186,8,4,2,2,0,2),(187,8,4,3,2,0,2),(188,8,4,4,2,0,2),(189,8,4,5,2,0,2),(190,8,4,6,2,0,2),(191,8,4,7,2,0,2),(192,8,4,8,2,0,2),(193,8,4,9,2,0,2),(194,8,4,10,2,0,2),(195,8,4,1,3,300,2),(196,8,4,2,3,NULL,2),(197,8,4,3,3,NULL,2),(198,8,4,4,3,NULL,2),(199,8,4,5,3,NULL,2),(200,8,4,6,3,NULL,2),(201,8,4,7,3,NULL,2),(202,8,4,8,3,NULL,2),(203,8,4,9,3,NULL,2),(204,8,4,10,3,NULL,2),(205,9,4,1,1,78,3),(206,9,4,2,1,66,3),(207,9,4,3,1,76,3),(208,9,4,4,1,78,3),(209,9,4,5,1,87,3),(210,9,4,6,1,76,3),(211,9,4,7,1,56,3),(212,9,4,8,1,34,3),(213,9,4,9,1,32,3),(214,9,4,10,1,34,3),(215,9,4,1,2,22,3),(216,9,4,2,2,0,3),(217,9,4,3,2,0,3),(218,9,4,4,2,0,3),(219,9,4,5,2,0,3),(220,9,4,6,2,0,3),(221,9,4,7,2,0,3),(222,9,4,8,2,0,3),(223,9,4,9,2,0,3),(224,9,4,10,2,0,3),(225,9,4,1,3,33,3),(226,9,4,2,3,NULL,3),(227,9,4,3,3,NULL,3),(228,9,4,4,3,NULL,3),(229,9,4,5,3,NULL,3),(230,9,4,6,3,NULL,3),(231,9,4,7,3,NULL,3),(232,9,4,8,3,NULL,3),(233,9,4,9,3,NULL,3),(234,9,4,10,3,NULL,3),(235,10,4,1,1,67,4),(236,10,4,2,1,76,4),(237,10,4,3,1,78,4),(238,10,4,4,1,56,4),(239,10,4,5,1,67,4),(240,10,4,6,1,77,4),(241,10,4,7,1,68,4),(242,10,4,8,1,34,4),(243,10,4,9,1,33,4),(244,10,4,10,1,32,4),(245,10,4,1,2,2,4),(246,10,4,2,2,0,4),(247,10,4,3,2,0,4),(248,10,4,4,2,0,4),(249,10,4,5,2,0,4),(250,10,4,6,2,0,4),(251,10,4,7,2,0,4),(252,10,4,8,2,0,4),(253,10,4,9,2,0,4),(254,10,4,10,2,0,4),(255,10,4,1,3,3,4),(256,10,4,2,3,NULL,4),(257,10,4,3,3,NULL,4),(258,10,4,4,3,NULL,4),(259,10,4,5,3,NULL,4),(260,10,4,6,3,NULL,4),(261,10,4,7,3,NULL,4),(262,10,4,8,3,NULL,4),(263,10,4,9,3,NULL,4),(264,10,4,10,3,NULL,4);
/*!40000 ALTER TABLE `marks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receipt`
--

DROP TABLE IF EXISTS `receipt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `receipt` (
  `no` int(11) NOT NULL AUTO_INCREMENT,
  `C_Id` int(11) DEFAULT NULL,
  `C_Rn` int(11) DEFAULT NULL,
  `ReceiptDate` date DEFAULT NULL,
  `Amount` int(11) DEFAULT NULL,
  `reason` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receipt`
--

LOCK TABLES `receipt` WRITE;
/*!40000 ALTER TABLE `receipt` DISABLE KEYS */;
INSERT INTO `receipt` VALUES (1,6,1,'2021-07-01',350,'Admission'),(2,7,1,'2021-07-01',400,'Admission'),(3,6,1,'2021-07-01',800,'Monthly Fees'),(4,7,1,'2021-07-01',900,'Monthly Fees'),(5,4,1,'2021-07-01',600,'Monthly Fees'),(6,6,1,'2021-07-01',800,'Monthly Fees'),(7,4,1,'2021-07-01',600,'Monthly Fees'),(8,4,1,'2021-07-01',600,'Monthly Fees'),(9,4,1,'2021-07-01',600,'Monthly Fees'),(10,7,2,'2021-07-03',400,'Admission'),(11,6,2,'2021-07-03',350,'Admission'),(12,6,3,'2021-07-03',350,'Admission'),(13,7,3,'2021-07-03',400,'Admission'),(14,4,2,'2021-07-03',250,'Admission'),(15,4,3,'2021-07-03',250,'Admission'),(16,4,4,'2021-07-03',250,'Admission'),(17,4,3,'2021-07-05',600,'Monthly Fees'),(18,4,2,'2021-07-06',500,'Monthly Fees'),(19,4,2,'2021-07-06',100,'Monthly Fees'),(20,4,2,'2021-07-06',600,'Monthly Fees');
/*!40000 ALTER TABLE `receipt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studentname`
--

DROP TABLE IF EXISTS `studentname`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `studentname` (
  `Id` int(11) NOT NULL,
  `salu` varchar(4) DEFAULT NULL,
  `StudentFirstName` varchar(10) NOT NULL,
  `StudentLastName` varchar(10) DEFAULT NULL,
  `DOB` date NOT NULL,
  `Gender` varchar(7) NOT NULL,
  `Religion` varchar(15) DEFAULT NULL,
  `Nationality` varchar(15) DEFAULT NULL,
  `Adharno` varchar(15) DEFAULT NULL,
  `Hno` varchar(15) DEFAULT NULL,
  `StreetName` varchar(45) DEFAULT NULL,
  `City` varchar(15) DEFAULT NULL,
  `State` varchar(15) DEFAULT NULL,
  `PIN` varchar(11) DEFAULT NULL,
  `BirthPlace` varchar(15) DEFAULT NULL,
  `BirthState` varchar(15) DEFAULT NULL,
  `ContactNumber` varchar(12) DEFAULT NULL,
  `Email` varchar(40) DEFAULT NULL,
  `Fname` varchar(30) DEFAULT NULL,
  `Foccu` varchar(45) DEFAULT NULL,
  `FContactno` varchar(12) DEFAULT NULL,
  `Mname` varchar(30) DEFAULT NULL,
  `Moccu` varchar(45) DEFAULT NULL,
  `MContactno` varchar(12) DEFAULT NULL,
  `PSchoolClass` varchar(15) DEFAULT NULL,
  `PSchoolN` varchar(45) DEFAULT NULL,
  `PSchoolBoard` varchar(45) DEFAULT NULL,
  `PSPer` varchar(7) DEFAULT NULL,
  `PSCCDate` date DEFAULT NULL,
  `Image` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `CourseId` int(11) NOT NULL,
  `Class_Rn` int(11) DEFAULT NULL,
  `Register_Date` date NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `sC_FK_idx` (`CourseId`),
  CONSTRAINT `sC_FK` FOREIGN KEY (`CourseId`) REFERENCES `courses` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studentname`
--

LOCK TABLES `studentname` WRITE;
/*!40000 ALTER TABLE `studentname` DISABLE KEYS */;
INSERT INTO `studentname` VALUES (1,'Mr.','Raghav','Vehgal','2000-04-22','Male','Hinduism','','','','','','','','','','','raghavVehgal@gmail.com','Sanjeev Kumar','shopkeeper','9853','','','','Third      3','ASSS','PSEB','84','2016-10-11','C:\\Users\\Os\\Pictures\\rv.jpg',4,1,'2021-06-30'),(2,'Mr.','Abhishek','Prajapati','1999-02-02','Male','Hinduism','Indian','789654123','','','','','','Amritsar','Punjab','','abhishekKumar@gmail.com','PAbhi','shopkeeper','7896532','','','','Fifth      5','Rkjhikb','PSEB','77','2016-04-22','C:\\Users\\Os\\Pictures\\abhishek.jpg',6,1,'2021-07-01'),(3,'Mr.','Akhil','Arora','2001-04-02','Male','Hinduism','Indian','56214','','','','','','Amritsar','Punjab','','akhilArora@gmail.com','PAkhil','','','','','','Fourth      4','','','','2001-06-02','C:\\Users\\Os\\Pictures\\akhilesh.jpg',7,1,'2021-07-01'),(4,'Mr.','Ashu','Sohal','2000-02-02','Male','Hinduism','Indian','789654123','7458','jhgfjvh','Amritsar','Punjab','143001','Amritsar','Punjab','7896541236','ashuSohal@gmail.com','','','','','','','Second      2','hfjvk','kvkjvkjhj','25','2016-04-02','C:\\Users\\Os\\Pictures\\ashu.jpg',7,2,'2021-07-03'),(5,'Mr.','Ayush','','2000-02-02','Male','Hinduism','Indian','789654123','7458','jhgfjvh','Amritsar','Punjab','143001','Amritsar','Punjab','7896541236','ayushVehgal@gmail.com','','','','','','','Fifth      5','hfjvk','kvkjvkjhj','25','2016-04-02','C:\\Users\\Os\\Pictures\\ayush.JPG',6,2,'2021-07-03'),(6,'Mr.','Deepanshu','Kalia','2000-02-02','Male','Hinduism','Indian','789654123','7458','jhgfjvh','Amritsar','Punjab','143001','Amritsar','Punjab','7896541236','deepanshuKalia@gmail.com','','','','','','','Fifth      5','hfjvk','kvkjvkjhj','25','2016-04-02','C:\\Users\\Os\\Pictures\\Deepanshu.jpg',6,3,'2021-07-03'),(7,'Mr.','Harjot','Singh','2000-02-02','Male','Hinduism','Indian','789654123','7458','jhgfjvh','Amritsar','Punjab','143001','Amritsar','Punjab','7896541236','harjotSingh@gmail.com','','','','','','','Sixth      6','hfjvk','kvkjvkjhj','25','2016-04-02','C:\\Users\\Os\\Pictures\\harjot.jpg',7,3,'2021-07-03'),(8,'Mr.','Nitish','Shrivastav','2000-02-02','Male','Hinduism','Indian','789654123','236','hgn','Amritsar','Punjab','143001','Amritsar','Punjab','7896541236','nitishShrivastav@gmail.com','','','','','','','Third      3','hfjvk','kvkjvkjhj','25','2016-04-02','C:\\Users\\Os\\Pictures\\Nitish.jpg',4,2,'2021-07-03'),(9,'Mr.','Sushil','Kumar','2000-02-02','Male','Hinduism','Indian','789654123','236','hgn','Amritsar','Punjab','143001','Amritsar','Punjab','7896541236','sushiKumar@gmail.com','','','','','','','Third      3','hfjvk','kvkjvkjhj','25','2016-04-02','C:\\Users\\Os\\Pictures\\sushil.jpg',4,3,'2021-07-03'),(10,'Mr.','Vishnu','','2000-02-02','Male','Hinduism','Indian','789654123','236','hgn','Amritsar','Punjab','143001','Amritsar','Punjab','7896541236','vishnuVehgal@gmail.com','','','','','','','Third      3','hfjvk','kvkjvkjhj','25','2016-04-02','C:\\Users\\Os\\Pictures\\Vishnu.JPG',4,4,'2021-07-03');
/*!40000 ALTER TABLE `studentname` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `studentname_BEFORE_INSERT` BEFORE INSERT ON `studentname` FOR EACH ROW begin
declare rn int;
set new.Register_Date=curdate();
set rn=(select max(C_RollNo) from sas.marks where C_Id=new.CourseId);

if(rn is null) then
	set rn=0;
end if;

set rn=rn+1;

set new.Class_Rn=rn;
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `studentname_AFTER_INSERT` AFTER INSERT ON `studentname` FOR EACH ROW BEGIN
declare sid int;
declare cid int;
declare cnt int;
declare rn int;
declare i int;
declare mf int;
declare yearr int;
declare yearrInc int;
declare af int;


set sid=new.Id;
set cid = new.CourseId;
set cnt=(select count(*) from sas.subjects where CourseId=cid);
set i=1;
set mf=(select PerMFee from sas.courses where Id=cid);

while i<=cnt do
	insert into sas.marks (S_Id,C_Id,Sub_Id,Term,C_RollNo) values(sid,cid,i,1,new.Class_Rn);
	set i=i+1;
end while;
set i=1;
while i<=cnt do
	insert into sas.marks (S_Id,C_Id,Sub_Id,Term,C_RollNo) values(sid,cid,i,2,new.Class_Rn);
	set i=i+1;
end while;
set i=1;
while i<=cnt do
	insert into sas.marks (S_Id,C_Id,Sub_Id,Term,C_RollNo) values(sid,cid,i,3,new.Class_Rn);
	set i=i+1;
end while;

set yearr=(select year(current_date()));
set yearrInc=yearr+1;
insert into sas.fee (S_Id,C_Id,C_Rlno,jan,feb,mar,apr,may,jun,jul,aug,sep,oct,nov,decm,year1,year2) values(sid,cid,new.Class_Rn,mf,mf,mf,mf,mf,mf,mf,mf,mf,mf,mf,mf,yearr,yearrInc);

set af=(select AdmissionFee from sas.courses where Id=cid);
insert into sas.receipt (C_Id,C_Rn,ReceiptDate,Amount,Reason) values (cid,new.Class_Rn,current_date(),af,"Admission");

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `studentname_BEFORE_DELETE` BEFORE DELETE ON `studentname` FOR EACH ROW BEGIN
	delete from sas.marks where S_Id=old.Id;
    delete from sas.fee where S_Id=old.Id;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `subjects`
--

DROP TABLE IF EXISTS `subjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `subjects` (
  `srno` int(11) NOT NULL AUTO_INCREMENT,
  `CourseId` int(11) NOT NULL,
  `Id` int(11) NOT NULL,
  `Name` varchar(25) DEFAULT NULL,
  `MaxMarks` int(11) DEFAULT NULL,
  PRIMARY KEY (`srno`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subjects`
--

LOCK TABLES `subjects` WRITE;
/*!40000 ALTER TABLE `subjects` DISABLE KEYS */;
INSERT INTO `subjects` VALUES (1,1,1,'English',100),(2,1,2,'Math',100),(3,1,3,'Hindi',100),(4,1,4,'Punjbai',100),(5,1,5,'Science',100),(6,1,6,'Social Studies',100),(7,1,7,'Sanskrit',100),(8,2,1,'English',100),(9,2,2,'Math',100),(10,2,3,'Hindi',100),(11,2,4,'Punjbai',100),(12,2,5,'Science',100),(13,2,6,'Social Studies',100),(14,2,7,'Sanskrit',100),(15,2,8,'General Knowledge',50),(16,2,9,'Computer',50),(17,2,10,'Drawing',50),(18,3,1,'English',100),(19,3,2,'Math',100),(20,3,3,'Hindi',100),(21,3,4,'Punjbai',100),(22,3,5,'Science',100),(23,3,6,'Social Studies',100),(24,3,7,'Sanskrit',100),(25,3,8,'General Knowledge',50),(26,3,9,'Computer',50),(27,3,10,'Drawing',50),(28,4,1,'English',100),(29,4,2,'Math',100),(30,4,3,'Hindi',100),(31,4,4,'Punjbai',100),(32,4,5,'Science',100),(33,4,6,'Social Studies',100),(34,4,7,'Sanskrit',100),(35,4,8,'General Knowledge',50),(36,4,9,'Computer',50),(37,4,10,'Drawing',50),(38,5,1,'English',100),(39,5,2,'Math',100),(40,5,3,'Hindi',100),(41,5,4,'Punjbai',100),(42,5,5,'Science',100),(43,5,6,'Social Studies',100),(44,5,7,'Sanskrit',100),(45,5,8,'General Knowledge',50),(46,5,9,'Computer',50),(47,6,1,'English',100),(48,6,2,'Math',100),(49,6,3,'Hindi',100),(50,6,4,'Science',100),(51,6,5,'Social Studies',100),(52,6,6,'Sanskrit',100),(53,6,7,'General Knowledge',50),(54,6,8,'Computer',50),(55,7,1,'English',100),(56,7,2,'Math',100),(57,7,3,'Hindi',100),(58,7,4,'Punjbai',100),(59,7,5,'Science',100),(60,7,6,'Social Studies',100),(61,7,7,'Sanskrit',100),(62,7,8,'Computer',50),(63,8,1,'English',NULL),(64,8,2,'Math',NULL),(65,8,3,'Hindi',NULL),(66,8,4,'Punjabi',NULL),(67,8,5,'Science',NULL),(68,9,1,'English',NULL),(69,9,2,'Math',NULL),(70,9,3,'Science',NULL),(71,9,4,'Punjabi',NULL);
/*!40000 ALTER TABLE `subjects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teachalocation`
--

DROP TABLE IF EXISTS `teachalocation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `teachalocation` (
  `srno` int(11) NOT NULL AUTO_INCREMENT,
  `Cid` int(11) DEFAULT NULL,
  `Tid` int(11) DEFAULT NULL,
  PRIMARY KEY (`srno`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='		';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teachalocation`
--

LOCK TABLES `teachalocation` WRITE;
/*!40000 ALTER TABLE `teachalocation` DISABLE KEYS */;
INSERT INTO `teachalocation` VALUES (28,4,1),(29,7,3),(30,6,1);
/*!40000 ALTER TABLE `teachalocation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subjectpref1` varchar(7) DEFAULT NULL,
  `subjectpref2` varchar(7) DEFAULT NULL,
  `teachercol` varchar(45) DEFAULT NULL,
  `salution` varchar(3) DEFAULT NULL,
  `firstname` varchar(15) DEFAULT NULL,
  `lastname` varchar(15) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `birthCity` varchar(15) DEFAULT NULL,
  `birthState` varchar(15) DEFAULT NULL,
  `gender` varchar(6) DEFAULT NULL,
  `religion` varchar(10) DEFAULT NULL,
  `nationality` varchar(20) DEFAULT NULL,
  `martialStatus` varchar(9) DEFAULT NULL,
  `adharcardno` int(11) DEFAULT NULL,
  `pancardno` varchar(15) DEFAULT NULL,
  `housenumber` varchar(10) DEFAULT NULL,
  `streetName` varchar(45) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `state` varchar(30) DEFAULT NULL,
  `pin` int(11) DEFAULT NULL,
  `mobileno` varchar(11) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `fathername` varchar(45) DEFAULT NULL,
  `fatherOccupation` varchar(45) DEFAULT NULL,
  `fatherContactNumber` varchar(11) DEFAULT NULL,
  `motherName` varchar(45) DEFAULT NULL,
  `motheroccupation` varchar(45) DEFAULT NULL,
  `mothercontactnumber` varchar(45) DEFAULT NULL,
  `highestQualification` varchar(15) DEFAULT NULL,
  `bed` varchar(3) DEFAULT NULL,
  `XIN` varchar(45) DEFAULT NULL,
  `XBoard` varchar(45) DEFAULT NULL,
  `Xper` varchar(5) DEFAULT NULL,
  `Xdate` date DEFAULT NULL,
  `XIIIN` varchar(45) DEFAULT NULL,
  `XIIIBoard` varchar(45) DEFAULT NULL,
  `XIIper` varchar(5) DEFAULT NULL,
  `XIIdate` date DEFAULT NULL,
  `GIN` varchar(45) DEFAULT NULL,
  `GUniversity` varchar(45) DEFAULT NULL,
  `Graduationper` varchar(5) DEFAULT NULL,
  `Gdate` date DEFAULT NULL,
  `PGIN` varchar(45) DEFAULT NULL,
  `PGUniversity` varchar(45) DEFAULT NULL,
  `PGper` varchar(5) DEFAULT NULL,
  `PGdate` date DEFAULT NULL,
  `MPhillIN` varchar(45) DEFAULT NULL,
  `MphillUniversity` varchar(45) DEFAULT NULL,
  `MPhillper` varchar(5) DEFAULT NULL,
  `MPhilldate` date DEFAULT NULL,
  `DIN` varchar(45) DEFAULT NULL,
  `DUniversity` varchar(45) DEFAULT NULL,
  `Dper` varchar(5) DEFAULT NULL,
  `Ddate` date DEFAULT NULL,
  `pic` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1,'Math','Hindi','Teacher','Mr','Raghu','Kumar','2000-04-02','Amritsar','Punjab','Male','Hindusim','Indian','UnMarried',796541236,'98745632','8574','sdfgji','fuyvjh','jgfjhvh',143001,'7896541236','rkranbirkumar567@gmail.com','','','','','','','Graduation','No','','','',NULL,'','','',NULL,'','','',NULL,'','','',NULL,'','','',NULL,'','','',NULL,'C:\\Users\\Os\\Pictures\\rv.jpg'),(3,'English','Punjabi','Teacher','Mr','Parv','Mehta','2000-04-02','Amritsar','Punjab','Male','Hindusim','Indian','UnMarried',796541236,'98745632','8574','sdfgji','fuyvjh','jgfjhvh',143001,'7896541236','parvMehta@gmail.com','','','','','','','Graduation','No','','','',NULL,'','','',NULL,'','','',NULL,'','','',NULL,'','','',NULL,'','','',NULL,'C:\\Users\\Os\\Pictures\\parv.JPG'),(4,'English','Hindi','Clerk','Mr','Souravneet','Singh','1999-06-23','Amritsar','Punjab','Male','Sikh','Indian','UnMarried',789654123,'74896','855jh','gwaliyar','Amritsar','Punjab',143001,'7413698548','souravneet@gmail.com','Amandeep','','','','','','Graduation','No','','','',NULL,'','','',NULL,'','','',NULL,'','','',NULL,'','','',NULL,'','','',NULL,'C:\\Users\\Os\\Pictures\\souravNeet.jpg'),(5,'English','Punjabi','Clerk','Mr','Amritpal','Singh','1998-05-13','Amritsar','Punjab','Male','Hindusim','Indian','UnMarried',78965321,'789654jhj','lk87/','mandi','Amritsar','Pujab',143001,'7946541236','amritpalSingh@gmail.com','Amardeep','','','','','','Graduation','No','','','',NULL,'','','',NULL,'','','',NULL,'','','',NULL,'','','',NULL,'','','',NULL,'C:\\Users\\Os\\Pictures\\amritPal.jpg'),(6,'English','Science','Teacher','Mr','Abhi','Talpade','1998-05-13','Amritsar','Punjab','Male','Hindusim','Indian','UnMarried',78965321,'789654jhj','lk87/','mandi','Amritsar','Pujab',143001,'7946541236','abhiTalpade@gmail.com','Amar','','','','','','Graduation','No','','','',NULL,'','','',NULL,'','','',NULL,'','','',NULL,'','','',NULL,'','','',NULL,'C:\\Users\\Os\\Pictures\\abhi.jpg');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `srno` int(11) NOT NULL AUTO_INCREMENT,
  `Id` varchar(10) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(15) NOT NULL,
  `Category` varchar(2) NOT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`srno`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'1','rkranbirkumar567@gmail.com','RagKum1','t','2021-07-02'),(2,'3','parvMehta@gmail.com','ParMeh3','t','2021-07-02'),(7,'4','souravneet@gmail.com','SouSin4','c','2021-07-08'),(8,'5','amritpalSingh@gmail.com','AmrSin5','c','2021-07-08'),(9,'6','abhiTalpade@gmail.com','AbhTal6','t','2021-07-08'),(10,'22','raghvVehgal@gmail.com','RagVeh','a','2021-07-08');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'sas'
--

--
-- Dumping routines for database 'sas'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-13 10:25:04
