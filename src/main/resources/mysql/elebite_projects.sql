CREATE DATABASE  IF NOT EXISTS `elebite` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `elebite`;
-- MySQL dump 10.13  Distrib 8.0.29, for macos12 (x86_64)
--
-- Host: localhost    Database: elebite
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `projects`
--

DROP TABLE IF EXISTS `projects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `projects` (
  `projectid` bigint NOT NULL AUTO_INCREMENT,
  `project_created_date_time` datetime(6) DEFAULT NULL,
  `project_description` mediumtext,
  `project_end_date` date DEFAULT NULL,
  `project_estimated_hours` double DEFAULT NULL,
  `project_name` varchar(255) DEFAULT NULL,
  `project_photo_url` varchar(255) DEFAULT NULL,
  `project_start_date` date DEFAULT NULL,
  `project_status` varchar(255) DEFAULT NULL,
  `project_team_name` varchar(100) DEFAULT NULL,
  `project_updated_date_time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`projectid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projects`
--

LOCK TABLES `projects` WRITE;
/*!40000 ALTER TABLE `projects` DISABLE KEYS */;
INSERT INTO `projects` VALUES (1,'2023-05-30 10:43:20.727563','**Projekt Titel**: EleBite: Projekt Estimeringsværktøj \r\n\r\n**Kunde**: Alpha Solution\r\n\r\n**Beskrivelse**: Dette er et Scrum-styret IT-projekt, der har til formål at udvikle den første version af et system ved navn \"EleBite\". EleBite er designet til at hjælpe Alpha Solution med at estimere tid og ressourcer til deres IT-projekter mere præcist og effektivt.\r\n\r\nDette projekt er bestilt af Alpha Solution og vil blive implementeret som et 1. års eksamensprojekt af Datamatiker-studerende, Martin Grosen. Projektet vil anvende Scrum-metodologi for at sikre iterativ udvikling og levering af produktet, samt løbende feedback og forbedring.\r\n\r\nFokus for denne første version af EleBite vil være på at levere grundlæggende, men kritiske, funktionaliteter, der kan illustrere potentialet i det endelige produkt. Målet er at skabe en solid og pålidelig løsning, der kan give Alpha Solution de værktøjer, de har brug for til bedre at forvalte deres projektestimeringer.\r\n\r\n**Produkt Backlog**: Produkt backloggen vil indeholde alle de krævede funktioner for dette system, prioriteret efter deres forretningsværdi for Alpha Solution. Den vil blive forvaltet af Martin og vil være under konstant reevaluering og justering gennem hele projektet.\r\n\r\n**Sprint**: Hver sprint vil vare i 2-3 uger, hvorefter der vil være et review og en retrospektiv. Målet er at levere et potentielt shippable produktinkrement efter hver sprint.\r\n\r\n**Godkendelse**: Efter hver sprint vil Alpha Solution have mulighed for at vurdere og godkende det arbejde, der er udført, samt at bidrage til den videre planlægning af projektet.\r\n\r\n**Endelig Version**: Mens dette projekt er tænkt som en første version af EleBite, er det vores håb, at det vil demonstrere det fulde potentiale for dette værktøj og bane vejen for yderligere udvikling og forbedring i fremtiden.\r\n','2023-06-01',250,'EleBite V1',NULL,'2023-04-24','Time-Boxed','Code Warriors','2023-05-30 22:46:20.493957'),(3,'2023-05-30 22:36:35.913044','** Pending Approval **',NULL,NULL,'EleBite V2',NULL,NULL,'Pending Approval','','2023-05-31 08:16:41.734504');
/*!40000 ALTER TABLE `projects` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-31  8:43:04
