-- MySQL dump 10.13  Distrib 8.0.36, for macos14 (arm64)
--
-- Host: localhost    Database: hotel-reservation
-- ------------------------------------------------------
-- Server version	8.3.0

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
-- Table structure for table `file_data`
--

DROP TABLE IF EXISTS `file_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `file_data` (
  `id` int NOT NULL,
  `room_detail_id` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1nlkul99p33agwwiq8glryv6s` (`room_detail_id`),
  CONSTRAINT `FK1nlkul99p33agwwiq8glryv6s` FOREIGN KEY (`room_detail_id`) REFERENCES `room_detail` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file_data`
--

LOCK TABLES `file_data` WRITE;
/*!40000 ALTER TABLE `file_data` DISABLE KEYS */;
INSERT INTO `file_data` VALUES (1,1,'7aaf5937-f9d5-48e6-aed6-59766d4921f5_singleroom.jpeg','/Users/andyvuong/Desktop/Code/MIU_Course/ASD_Campus/cs489/CourseProject/A-Hotel/BackEnd/Hotel_Reservation_Service/src/main/resources/static/images/7aaf5937-f9d5-48e6-aed6-59766d4921f5_singleroom.jpeg','image/jpeg'),(2,2,'1c7658d6-7e8d-4267-a002-32e2749ed62e_doublequeen.jpg','/Users/andyvuong/Desktop/Code/MIU_Course/ASD_Campus/cs489/CourseProject/A-Hotel/BackEnd/Hotel_Reservation_Service/src/main/resources/static/images/1c7658d6-7e8d-4267-a002-32e2749ed62e_doublequeen.jpg','image/jpeg'),(3,3,'2ee8198c-14a5-4a98-bdf5-c36dadd089a4_singleking.jpeg','/Users/andyvuong/Desktop/Code/MIU_Course/ASD_Campus/cs489/CourseProject/A-Hotel/BackEnd/Hotel_Reservation_Service/src/main/resources/static/images/2ee8198c-14a5-4a98-bdf5-c36dadd089a4_singleking.jpeg','image/jpeg'),(4,4,'54648693-e73c-4613-a990-ebd509912209_doubleking.jpeg','/Users/andyvuong/Desktop/Code/MIU_Course/ASD_Campus/cs489/CourseProject/A-Hotel/BackEnd/Hotel_Reservation_Service/src/main/resources/static/images/54648693-e73c-4613-a990-ebd509912209_doubleking.jpeg','image/jpeg');
/*!40000 ALTER TABLE `file_data` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-27 15:28:09
