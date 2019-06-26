-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: progettoFinale
-- ------------------------------------------------------
-- Server version	5.6.23-log

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cliente` (
  `username` varchar(30) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `cognome` varchar(45) DEFAULT NULL,
  `tipologia` tinyint(1) NOT NULL,
  `partitaIva` varchar(45) DEFAULT NULL,
  `codiceFiscale` varchar(45) DEFAULT NULL,
  `cellulare` varchar(45) DEFAULT NULL,
  `telefonoFisso` varchar(45) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `attivo` tinyint(1) NOT NULL,
  `admin` tinyint(1) NOT NULL,
  `affidabile` tinyint(1) NOT NULL,
  `via` varchar(45) NOT NULL,
  `cap` varchar(45) NOT NULL,
  `comune` varchar(45) NOT NULL,
  `provincia` varchar(45) NOT NULL,
  `nazione` varchar(45) NOT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `idCliente_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES ('fabio79','fabio',NULL,1,'9873647567',NULL,'3298777890','086457234','fabioloz@libero.it','fabiolopezn',1,0,1,'casilinia','030137','ferentino','fr','italia'),('fra45','francesca',NULL,1,'12345678',NULL,'3894038654','0518936456','frabu@gmail.com','francesca92',1,1,1,'bertina','01027','montefiascone','vt','italia'),('vero21','veronica','de ang',0,NULL,'dngvnc95','3492837457',NULL,'vero@gmail.com','veronica95',1,1,1,'piella','40126','bologna','bo','italia');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-26 15:33:52
