-- MySQL dump 10.13  Distrib 8.0.19, for macos10.15 (x86_64)
--
-- Host: 127.0.0.1    Database: gymcarry
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `CHATROOM`
--

DROP TABLE IF EXISTS `CHATROOM`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CHATROOM` (
  `MESSAGEIDX` int NOT NULL AUTO_INCREMENT COMMENT '메세지 번호',
  `CHATIDX` int NOT NULL COMMENT '채팅방번호',
  `CHATCONTENT` mediumtext NOT NULL COMMENT '대화내용',
  `CHATDATE` timestamp NOT NULL COMMENT '대화시간',
  `CRIDX` int NOT NULL COMMENT '캐리번호',
  `MEMIDX` int NOT NULL COMMENT '회원번호',
  PRIMARY KEY (`MESSAGEIDX`),
  KEY `FK_CARRY_TO_CHATROOM` (`CRIDX`),
  KEY `FK_MEMBER_TO_CHATROOM` (`MEMIDX`),
  KEY `FK_CHATLIST_TO_CHATROOM` (`CHATIDX`),
  CONSTRAINT `FK_CARRY_TO_CHATROOM` FOREIGN KEY (`CRIDX`) REFERENCES `CARRY` (`CRIDX`),
  CONSTRAINT `FK_CHATLIST_TO_CHATROOM` FOREIGN KEY (`CHATIDX`) REFERENCES `CHATLIST` (`CHATIDX`),
  CONSTRAINT `FK_MEMBER_TO_CHATROOM` FOREIGN KEY (`MEMIDX`) REFERENCES `MEMBER` (`MEMIDX`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='채팅방내용';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CHATROOM`
--

LOCK TABLES `CHATROOM` WRITE;
/*!40000 ALTER TABLE `CHATROOM` DISABLE KEYS */;
/*!40000 ALTER TABLE `CHATROOM` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-24  2:00:36
