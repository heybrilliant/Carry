-- MySQL dump 10.13  Distrib 8.0.18, for macos10.14 (x86_64)
--
-- Host: 127.0.0.1    Database: gymcarry
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `BOARD`
--

DROP TABLE IF EXISTS `BOARD`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `BOARD` (
  `POSTIDX` int(11) NOT NULL AUTO_INCREMENT COMMENT '게시글IDX',
  `POSTNAME` varchar(255) NOT NULL COMMENT '제목',
  `POSTCONTENT` text NOT NULL COMMENT '글내용',
  `POSTNICK` varchar(50) NOT NULL COMMENT '닉네임',
  `MEMIDX` int(11) NOT NULL COMMENT '회원번호',
  `UPLOADFILE` mediumblob COMMENT '첨부파일',
  `POSTDATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '작성일자',
  `POSTLIKE` int(11) DEFAULT NULL COMMENT '좋아요갯수',
  `BOARDCATEGORY` varchar(50) NOT NULL COMMENT '말머리',
  `POSTVIEW` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`POSTIDX`),
  KEY `FK_MEMBER_TO_BOARD` (`MEMIDX`),
  CONSTRAINT `FK_MEMBER_TO_BOARD` FOREIGN KEY (`MEMIDX`) REFERENCES `member` (`MEMIDX`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='게시판';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `BOARD`
--

LOCK TABLES `BOARD` WRITE;
/*!40000 ALTER TABLE `BOARD` DISABLE KEYS */;
INSERT INTO `BOARD` VALUES (1,'하이 안녕하삼','테스트 내용인데 게시판 잘 불렸으면 좋겠다. 잘해보자 게시판아.','스프링자바천재',1,NULL,'2021-09-06 08:27:31',NULL,'소통',0),(3,'서강대 맛집 추천','제가 오늘 서강대 건너편 옥정이라는 평양식 만두국집 다녀왔는데요, 너무 맛있네요. 밥도 무료로 주세요. 대신 점심 장사라 2시까지만 합니다. 웨이팅도 있는데 금방 빠져요. 인생 칼만두집을 찾았네요. 이열치열 지대로 느끼고 싶으신 분들 다녀오세요. 입 힐링합니다^^','스프링자바천재',1,NULL,'2021-09-07 03:52:43',NULL,'소통',0),(4,'테스트','테스트내용임','스프링자바천재',1,NULL,'2021-09-07 04:05:22',NULL,'질문',0),(5,'테스트2','테스트내용임2','스프링자바천재',1,NULL,'2021-09-07 04:05:49',NULL,'질문',0),(6,'테스트','테스트내용임','여름밤',1,NULL,'2021-09-07 16:55:14',NULL,'질문',0),(7,'테스트','테스트내용임','여름밤',1,NULL,'2021-09-07 16:55:15',NULL,'질문',0),(8,'테스트','테스트내용임','여름밤',1,NULL,'2021-09-07 16:55:16',NULL,'질문',0),(9,'테스트','테스트내용임','여름밤',1,NULL,'2021-09-07 16:55:19',NULL,'질문',0),(10,'테스트','테스트내용임','여름밤',1,NULL,'2021-09-07 16:55:19',NULL,'질문',0),(11,'테스트','테스트내용임','여름밤',1,NULL,'2021-09-07 16:55:19',NULL,'질문',0),(12,'테스트','테스트내용임','여름밤',1,NULL,'2021-09-07 16:55:19',NULL,'질문',0),(13,'테스트','테스트내용임','여름밤',1,NULL,'2021-09-07 16:55:20',NULL,'질문',0),(14,'테스트','테스트내용임','여름밤',1,NULL,'2021-09-07 16:55:20',NULL,'질문',0),(15,'테스트','테스트내용임','여름밤',1,NULL,'2021-09-07 16:55:20',NULL,'질문',0),(16,'테스트','테스트내용임','여름밤',1,NULL,'2021-09-07 16:55:20',NULL,'질문',0),(17,'테스트','테스트내용임','여름밤',1,NULL,'2021-09-07 16:55:20',NULL,'질문',0),(18,'테스트','테스트내용임','여름밤',1,NULL,'2021-09-07 16:55:21',NULL,'질문',0),(19,'테스트','테스트내용임','여름밤',1,NULL,'2021-09-07 16:55:21',NULL,'질문',0),(20,'테스트','테스트내용임','여름밤',1,NULL,'2021-09-07 16:55:21',NULL,'질문',0),(21,'테스트','테스트내용임','여름밤',1,NULL,'2021-09-07 16:55:21',NULL,'질문',0);
/*!40000 ALTER TABLE `BOARD` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-08  2:27:17
