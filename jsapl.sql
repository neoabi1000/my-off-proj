-- MySQL dump 10.13  Distrib 5.6.20, for osx10.8 (x86_64)
--
-- Host: localhost    Database: jsapl
-- ------------------------------------------------------
-- Server version	5.6.20

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
-- Table structure for table `CUSTOMER`
--

DROP TABLE IF EXISTS `CUSTOMER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CUSTOMER` (
  `CUSTID` bigint(20) NOT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `PHONE` varchar(255) DEFAULT NULL,
  `PAN` varchar(255) DEFAULT NULL,
  `customerType` int(11) NOT NULL,
  PRIMARY KEY (`CUSTID`),
  KEY `FK_6dd1eu4tvk31m7yk6degeh6yc` (`customerType`),
  CONSTRAINT `FK_6dd1eu4tvk31m7yk6degeh6yc` FOREIGN KEY (`customerType`) REFERENCES `CUSTOMER_TYPE` (`TYPE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CUSTOMER`
--

LOCK TABLES `CUSTOMER` WRITE;
/*!40000 ALTER TABLE `CUSTOMER` DISABLE KEYS */;
INSERT INTO `CUSTOMER` VALUES (7727621757672095745,'Customer ABC','+91 9878987878787','PAN-1ANDKEW',1),(7727621757672095746,'Customer XYZ','+91 9898877676','PAN-2ANDKEW',5);
/*!40000 ALTER TABLE `CUSTOMER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CUSTOMER_CONTACT`
--

DROP TABLE IF EXISTS `CUSTOMER_CONTACT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CUSTOMER_CONTACT` (
  `custId` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  KEY `FK_3dv1du9tyst50d3yc7cdpege5` (`custId`),
  CONSTRAINT `FK_3dv1du9tyst50d3yc7cdpege5` FOREIGN KEY (`custId`) REFERENCES `CUSTOMER` (`CUSTID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CUSTOMER_CONTACT`
--

LOCK TABLES `CUSTOMER_CONTACT` WRITE;
/*!40000 ALTER TABLE `CUSTOMER_CONTACT` DISABLE KEYS */;
INSERT INTO `CUSTOMER_CONTACT` VALUES (7727621757672095745,'Cheryl','Cheryl@kony.com','29784735'),(7727621757672095745,'Clark','Clark@kony.com','+19898998'),(7727621757672095745,'Ram','Raml@gxyz.com','040-2978 4735'),(7727621757672095745,'Venkat','Venkat@xyz.com','040-4000 9965');
/*!40000 ALTER TABLE `CUSTOMER_CONTACT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CUSTOMER_TYPE`
--

DROP TABLE IF EXISTS `CUSTOMER_TYPE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CUSTOMER_TYPE` (
  `TYPE` int(11) NOT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `CREDITLIMIT` int(11) DEFAULT NULL,
  PRIMARY KEY (`TYPE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CUSTOMER_TYPE`
--

LOCK TABLES `CUSTOMER_TYPE` WRITE;
/*!40000 ALTER TABLE `CUSTOMER_TYPE` DISABLE KEYS */;
INSERT INTO `CUSTOMER_TYPE` VALUES (1,'Platinum',200000),(2,'Gold',100000),(3,'Silver',25000),(4,'Bronze',5000),(5,'Walk-in',0);
/*!40000 ALTER TABLE `CUSTOMER_TYPE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SAMPLE`
--

DROP TABLE IF EXISTS `SAMPLE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SAMPLE` (
  `SAMPLEID` bigint(20) NOT NULL,
  `CUSTID` bigint(20) NOT NULL,
  `FORM` varchar(255) DEFAULT NULL,
  `RECEIVEDDATE` date DEFAULT NULL,
  `STATUS` varchar(255) DEFAULT NULL,
  `SIZE` int(11) DEFAULT NULL,
  `STAMPING` varchar(255) DEFAULT NULL,
  `ISTOBERETURNED` char(1) DEFAULT NULL,
  PRIMARY KEY (`SAMPLEID`),
  KEY `FK_4lh4pc48mrawv4u4dpmgwdh6n` (`CUSTID`),
  CONSTRAINT `FK_4lh4pc48mrawv4u4dpmgwdh6n` FOREIGN KEY (`CUSTID`) REFERENCES `CUSTOMER` (`CUSTID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SAMPLE`
--

LOCK TABLES `SAMPLE` WRITE;
/*!40000 ALTER TABLE `SAMPLE` DISABLE KEYS */;
INSERT INTO `SAMPLE` VALUES (7728653054506958849,7727621757672095745,'Powder','2017-02-05','Received',0,'CARVED WITH BIPIN','Y');
/*!40000 ALTER TABLE `SAMPLE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SITE`
--

DROP TABLE IF EXISTS `SITE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SITE` (
  `ID` int(11) NOT NULL,
  `SITECODE` varchar(255) DEFAULT NULL,
  `ADDRESS` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SITE`
--

LOCK TABLES `SITE` WRITE;
/*!40000 ALTER TABLE `SITE` DISABLE KEYS */;
/*!40000 ALTER TABLE `SITE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TEST`
--

DROP TABLE IF EXISTS `TEST`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TEST` (
  `WORKORDERID` bigint(20) NOT NULL,
  `SAMPLEID` bigint(20) NOT NULL,
  `TESTTYPEID` bigint(20) NOT NULL,
  `REQUIREDSPECIFICATION` varchar(255) DEFAULT NULL,
  `TESTSTATUS` varchar(255) DEFAULT NULL,
  `CREATED` date DEFAULT NULL,
  `ASSIGNEDTOWRKODERON` date DEFAULT NULL,
  `TESTER` varchar(255) DEFAULT NULL,
  `TESTRESULTS` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`WORKORDERID`,`SAMPLEID`,`TESTTYPEID`),
  KEY `FK_oymc2avirx41kpegl9avl0xiq` (`SAMPLEID`),
  KEY `FK_8p8tbtoe57o8snj696jhdrwuf` (`TESTTYPEID`),
  CONSTRAINT `FK_2cc7j4w31rfr09d3r2h6de9vs` FOREIGN KEY (`WORKORDERID`) REFERENCES `WORKORDER` (`ID`),
  CONSTRAINT `FK_8p8tbtoe57o8snj696jhdrwuf` FOREIGN KEY (`TESTTYPEID`) REFERENCES `TESTTYPE` (`ID`),
  CONSTRAINT `FK_oymc2avirx41kpegl9avl0xiq` FOREIGN KEY (`SAMPLEID`) REFERENCES `SAMPLE` (`SAMPLEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TEST`
--

LOCK TABLES `TEST` WRITE;
/*!40000 ALTER TABLE `TEST` DISABLE KEYS */;
/*!40000 ALTER TABLE `TEST` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TESTCATEGORY`
--

DROP TABLE IF EXISTS `TESTCATEGORY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TESTCATEGORY` (
  `ID` int(11) NOT NULL,
  `CATEGORY` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TESTCATEGORY`
--

LOCK TABLES `TESTCATEGORY` WRITE;
/*!40000 ALTER TABLE `TESTCATEGORY` DISABLE KEYS */;
INSERT INTO `TESTCATEGORY` VALUES (1,'Chemical'),(2,'Mechanical'),(3,'Non-Destructive'),(4,'Metallography'),(5,'Misc');
/*!40000 ALTER TABLE `TESTCATEGORY` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TESTTYPE`
--

DROP TABLE IF EXISTS `TESTTYPE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TESTTYPE` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `PRICE` double DEFAULT NULL,
  `CATEGORY` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_ge7pmbqx1o3iubnxg3al98nhu` (`CATEGORY`),
  CONSTRAINT `FK_ge7pmbqx1o3iubnxg3al98nhu` FOREIGN KEY (`CATEGORY`) REFERENCES `TESTCATEGORY` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TESTTYPE`
--

LOCK TABLES `TESTTYPE` WRITE;
/*!40000 ALTER TABLE `TESTTYPE` DISABLE KEYS */;
INSERT INTO `TESTTYPE` VALUES (1,'Spectro','Sample Description for Spectro',500,1),(2,'Edxrf','Sample Description for Edxrf',200,1),(3,'Coating','Sample Description for Coating',300,1),(4,'Tensile','Sample Description for Tensile',700,2),(5,'Hardness','Sample Description for Hardness',950,2),(6,'Bend','Sample Description for Bend',1100,2);
/*!40000 ALTER TABLE `TESTTYPE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `WORKORDER`
--

DROP TABLE IF EXISTS `WORKORDER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `WORKORDER` (
  `ID` bigint(20) NOT NULL,
  `CUSTOMER` bigint(20) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `CLIENTINFO` varchar(255) DEFAULT NULL,
  `CREATED` date DEFAULT NULL,
  `UPDATED` date DEFAULT NULL,
  `STATUS` varchar(255) DEFAULT NULL,
  `DATECOMMITED` date DEFAULT NULL,
  `ADVANCEPAID` double DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_63tp4f1mavt2ts7sjk9cdrkeb` (`CUSTOMER`),
  CONSTRAINT `FK_63tp4f1mavt2ts7sjk9cdrkeb` FOREIGN KEY (`CUSTOMER`) REFERENCES `CUSTOMER` (`CUSTID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `WORKORDER`
--

LOCK TABLES `WORKORDER` WRITE;
/*!40000 ALTER TABLE `WORKORDER` DISABLE KEYS */;
INSERT INTO `WORKORDER` VALUES (7728676227600351233,7727621757672095745,'URGENT: Customer wants this completed on time.','Self','2017-02-05','2017-02-05','New','2017-04-01',0);
/*!40000 ALTER TABLE `WORKORDER` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-05 17:53:53
