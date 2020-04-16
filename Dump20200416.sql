-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: gundam
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `tbl_mission_members`
--

DROP TABLE IF EXISTS `tbl_mission_members`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_mission_members` (
  `username` varchar(50) NOT NULL,
  `mission_id` int(11) NOT NULL,
  `weapon_id` varchar(50) DEFAULT NULL,
  `leader` bit(1) DEFAULT NULL,
  PRIMARY KEY (`username`,`mission_id`),
  KEY `mission_id` (`mission_id`),
  CONSTRAINT `tbl_mission_members_ibfk_1` FOREIGN KEY (`username`) REFERENCES `tbl_users` (`username`),
  CONSTRAINT `tbl_mission_members_ibfk_2` FOREIGN KEY (`mission_id`) REFERENCES `tbl_missions` (`mission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_mission_members`
--

LOCK TABLES `tbl_mission_members` WRITE;
/*!40000 ALTER TABLE `tbl_mission_members` DISABLE KEYS */;
INSERT INTO `tbl_mission_members` VALUES ('testuser',5,'',''),('user1',1,'WEAPON01','\0'),('user1',2,'WEAPON02',''),('user1',3,'WEAPON01',''),('user2',1,'WEAPON03',''),('user3',4,'','');
/*!40000 ALTER TABLE `tbl_mission_members` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_missions`
--

DROP TABLE IF EXISTS `tbl_missions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_missions` (
  `mission_id` int(11) NOT NULL AUTO_INCREMENT,
  `mission_name` varchar(200) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `date_start` varchar(50) DEFAULT NULL,
  `date_end` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`mission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_missions`
--

LOCK TABLES `tbl_missions` WRITE;
/*!40000 ALTER TABLE `tbl_missions` DISABLE KEYS */;
INSERT INTO `tbl_missions` VALUES (1,'Finding Never Land','Desciption 1','2017-09-21','2017-09-28'),(2,'Finding Never Land2','Desciption 2','2017-09-21',''),(3,'Finding Never Land3','Desciption 3','',''),(4,'Finding nerver land','D123123','2018-08-13',''),(5,'MISSION07','TEST','2018-08-28','');
/*!40000 ALTER TABLE `tbl_missions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_robots`
--

DROP TABLE IF EXISTS `tbl_robots`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_robots` (
  `robot_id` varchar(50) NOT NULL,
  `robot_name` varchar(50) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`robot_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_robots`
--

LOCK TABLES `tbl_robots` WRITE;
/*!40000 ALTER TABLE `tbl_robots` DISABLE KEYS */;
INSERT INTO `tbl_robots` VALUES ('GUNDAM01','GUNDAM01','manh me, ca tinh, nang dong','\0'),('GUNDAM02','GUNDAM02','dieu dang, hien hau, dep','\0'),('GUNDAM03','GUNDAM03','dep, kieu mau moi',''),('GUNDAM04','GUNDAM04','dep, kieu mau moi',''),('GUNDAM07','GUNDAM07','ASJDHFAKJSF','');
/*!40000 ALTER TABLE `tbl_robots` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_users`
--

DROP TABLE IF EXISTS `tbl_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_users` (
  `username` varchar(50) NOT NULL,
  `fullname` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `sex` varchar(50) DEFAULT NULL,
  `birthday` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `role` varchar(50) DEFAULT NULL,
  `picture` varchar(200) DEFAULT NULL,
  `robot_id` varchar(59) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `free` bit(1) DEFAULT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_users`
--

LOCK TABLES `tbl_users` WRITE;
/*!40000 ALTER TABLE `tbl_users` DISABLE KEYS */;
INSERT INTO `tbl_users` VALUES ('admin','admin','0123456789','male','1997-09-21','123456','admin','images/avt_1.jpg','','',''),('asdfasdf','123asdfas123','123123123','Male','','123456','user','images/avt_2.jpg','','\0',''),('testuser','123asdfas123','123123123','Male','2018-08-22','123456','user','images/avt_2.jpg','GUNDAM03','\0',''),('user1','pillot_1','0123456789','male','1997-09-21','123456','user','images/avt_2.jpg','GUNDAM01','',''),('user2','pillot_2','0123456789','male','1997-09-21','123456','user','images/avt_2.jpg','GUNDAM02','',''),('user3','pillot_3','0123456789','male','1997-09-21','123456','user','images/avt_2.jpg','','','');
/*!40000 ALTER TABLE `tbl_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_weapons`
--

DROP TABLE IF EXISTS `tbl_weapons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_weapons` (
  `weapon_id` varchar(50) NOT NULL,
  `weapon_name` varchar(50) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `owner` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`weapon_id`),
  KEY `owner` (`owner`),
  CONSTRAINT `tbl_weapons_ibfk_1` FOREIGN KEY (`owner`) REFERENCES `tbl_robots` (`robot_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_weapons`
--

LOCK TABLES `tbl_weapons` WRITE;
/*!40000 ALTER TABLE `tbl_weapons` DISABLE KEYS */;
INSERT INTO `tbl_weapons` VALUES ('SWORD','SWERFJASDF','ASDF','sword','GUNDAM07'),('TESTWP','TESTWP','SDFASDF','shield','GUNDAM07'),('WEAPON01','LIGHNGING GUN','Sung ban nhanh, cong luc manh','gun','GUNDAM01'),('WEAPON02','LIGHNGING SWORD','Kiem ban nhanh, cong luc yeu','sword','GUNDAM01'),('WEAPON04','LIGHTNING SHIELD','Vung chac, bao ve','shield','GUNDAM02');
/*!40000 ALTER TABLE `tbl_weapons` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'gundam'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-16 23:33:20
