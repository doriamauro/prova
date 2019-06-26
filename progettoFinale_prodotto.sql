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
-- Table structure for table `prodotto`
--

DROP TABLE IF EXISTS `prodotto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `prodotto` (
  `idProdotto` int(11) NOT NULL,
  `descrizione` varchar(80) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `codiceEAN` varchar(45) NOT NULL,
  `prezzoUni` double NOT NULL,
  `disponibilita` int(11) NOT NULL,
  `linkProduttore` varchar(80) DEFAULT NULL,
  `costoSped` double NOT NULL,
  `tempoConsegna` int(11) NOT NULL,
  `immaginePrimaria` varchar(200) NOT NULL,
  `immagineSec` varchar(200) DEFAULT NULL,
  `categoria` int(11) NOT NULL,
  `sconto` int(11) DEFAULT NULL,
  PRIMARY KEY (`idProdotto`),
  KEY `idCategoria_idx` (`categoria`),
  CONSTRAINT `idCategoria` FOREIGN KEY (`categoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prodotto`
--

LOCK TABLES `prodotto` WRITE;
/*!40000 ALTER TABLE `prodotto` DISABLE KEYS */;
INSERT INTO `prodotto` VALUES (1,'xiomi redmi note 7 64gb black','xiaomi ','38746592837444',199,100,'https://www.xiomi.com',8.99,2,'https://asset.mediaw.it/wcsstore/MMCatalogAssetStore/asset/images/99/16/991688.jpg',NULL,100,0),(2,'hp laptop 15-dw0077 nl','hp','48239840058382',679,20,'https://store.hp.com',4.99,5,'https://asset.mediaw.it/wcsstore/MMCatalogAssetStore/asset/images/99/45/994534.jpg',NULL,200,10),(3,'nikon 3500','nikon','47582934571823',399,40,'https://www.nikon.com/',3.99,3,'https://asset.mediaw.it/wcsstore/MMCatalogAssetStore/asset/images/10/00/100094_1.jpg','https://asset.mediaw.it/wcsstore/MMCatalogAssetStore/asset/images/10/00/100094_4.jpg',700,20),(4,'KENWOOD KCC9068S + KAX980ME','kenwood','49387599448203',1299,15,'https://www.kenwoodworld.com/it-it',9.9,3,'https://asset.mediaw.it/assets/MediaworldIT/asset/images/10/05/k-1005521.jpg','https://media.flixcar.com/f360cdn/Delonghi-2498743532-KCC9000S-Image-1.jpg',400,5),(5,'LENOVO Legion T530-28ICB','lenovo','12314893009283',849,50,'https://www.lenovo.com/',2.99,5,'https://asset.mediaw.it/wcsstore/MMCatalogAssetStore/asset/images/98/47/984731.jpg','https://asset.mediaw.it/wcsstore/MMCatalogAssetStore/asset/images/98/47/984731_1.jpg',600,5),(6,'APPLE iPhone Xs Max 256GB Silver','iPhone','78439450283744',1349,100,'https://www.apple.com/it/',9.99,4,'https://asset.mediaw.it/wcsstore/MMCatalogAssetStore/asset/images/98/57/985787.jpg',NULL,100,5),(7,'HONOR 9 Lite 32gb Black','honor','84938755641654',139,70,'https://www.hihonor.com/it/',5.99,2,'https://asset.mediaw.it/wcsstore/MMCatalogAssetStore/asset/images/74/99/749993.jpg','https://asset.mediaw.it/wcsstore/MMCatalogAssetStore/asset/images/74/99/749993_1.jpg',100,5),(8,'APPLE MacBook Pro 15 MV912T/A Space Grey','apple','44654646678631',3399,20,'https://www.apple.com/it/',12.99,5,'https://asset.mediaw.it/wcsstore/MMCatalogAssetStore/asset/images/10/01/100123.jpg',NULL,200,25),(9,'MIELE WCR 890 WIFI TD&PW VAPORE','miele','46646878794497',1999,200,'https://www.miele.it/',4.99,4,'https://asset.mediaw.it/wcsstore/MMCatalogAssetStore/asset/images/98/53/985338.jpg','https://asset.mediaw.it/wcsstore/MMCatalogAssetStore/asset/images/98/53/985338_2.jpg',500,15),(10,'SAMSUNG GALAXY TAB S5E Silver','samsung','98974966388978',499,300,'https://www.samsung.com/it/',5.99,4,'https://asset.mediaw.it/wcsstore/MMCatalogAssetStore/asset/images/99/20/992086.jpg','https://asset.mediaw.it/wcsstore/MMCatalogAssetStore/asset/images/99/20/992086_1.jpg',900,0),(11,'SONY PS4 1TB F + 2 Dualshock 4 Wireless Controller','sony','76666746433333',359,90,'https://www.sony.it/',0,5,'https://asset.mediaw.it/wcsstore/MMCatalogAssetStore/asset/images/98/74/987485.jpg',NULL,600,5),(12,'SMEG SF6341GVX','smeg','63685868655488',599,150,'https://www.smeg.it/',4.99,4,'https://asset.mediaw.it/wcsstore/MMCatalogAssetStore/asset/images/99/15/991506.jpg','https://asset.mediaw.it/wcsstore/MMCatalogAssetStore/asset/images/99/15/991506_2.jpg',500,15);
/*!40000 ALTER TABLE `prodotto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-25 17:48:59
