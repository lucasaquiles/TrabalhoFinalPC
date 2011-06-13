-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.41-3ubuntu12.10


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema trabalhopc_db
--

CREATE DATABASE IF NOT EXISTS trabalhopc_db;
USE trabalhopc_db;

--
-- Definition of table `trabalhopc_db`.`Categoria`
--

DROP TABLE IF EXISTS `trabalhopc_db`.`Categoria`;
CREATE TABLE  `trabalhopc_db`.`Categoria` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `trabalhopc_db`.`Categoria`
--

/*!40000 ALTER TABLE `Categoria` DISABLE KEYS */;
LOCK TABLES `Categoria` WRITE;
INSERT INTO `trabalhopc_db`.`Categoria` VALUES  (5,'opa'),
 (4,'trollagem');
UNLOCK TABLES;
/*!40000 ALTER TABLE `Categoria` ENABLE KEYS */;


--
-- Definition of table `trabalhopc_db`.`Compromisso`
--

DROP TABLE IF EXISTS `trabalhopc_db`.`Compromisso`;
CREATE TABLE  `trabalhopc_db`.`Compromisso` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dataFim` datetime DEFAULT NULL,
  `dataInicio` datetime DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  `categoria_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKC97B84C721C9204D` (`categoria_id`)
) ENGINE=MyISAM AUTO_INCREMENT=41 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `trabalhopc_db`.`Compromisso`
--

/*!40000 ALTER TABLE `Compromisso` DISABLE KEYS */;
LOCK TABLES `Compromisso` WRITE;
INSERT INTO `trabalhopc_db`.`Compromisso` VALUES  (16,NULL,NULL,'','',1),
 (17,NULL,NULL,'','',1),
 (18,NULL,NULL,'','',1),
 (19,NULL,NULL,'teste 										','TEEEEEEEEEEEEEEEEEEEEEEEEEEEEEESSSSSSSSTEEEEEEEEEEEEEEEEE',4),
 (20,NULL,NULL,'','teste',1),
 (21,NULL,NULL,'','',1),
 (22,NULL,NULL,'','',1),
 (23,NULL,NULL,'','opa',1),
 (24,NULL,NULL,'','',1),
 (25,NULL,NULL,'','',1),
 (26,NULL,NULL,'','',1),
 (27,NULL,NULL,'','',1),
 (28,NULL,NULL,'','',1),
 (29,NULL,NULL,'','',1),
 (30,NULL,NULL,'','',1),
 (31,NULL,NULL,'','',1),
 (32,NULL,NULL,'çajkdçfjlkrç;','Teste',1),
 (33,NULL,NULL,'','',1),
 (34,NULL,NULL,'kjdçfjaçd			','opa',2),
 (35,NULL,NULL,'','',1),
 (36,NULL,NULL,'problem?','trollagem',1),
 (37,'0012-12-01 00:00:00','0012-12-01 00:00:00','teste com datas','OOOOOpa',4),
 (38,NULL,NULL,'','',1),
 (39,'2011-06-08 00:00:00','2011-06-08 00:00:00','outro teste com SimpleDateFormat()','mais um teste',3),
 (40,'2011-06-02 00:00:00','2011-06-02 00:00:00','aeeeee \\o/','compromisso esperto',1);
UNLOCK TABLES;
/*!40000 ALTER TABLE `Compromisso` ENABLE KEYS */;


--
-- Definition of table `trabalhopc_db`.`Compromisso_Usuario`
--

DROP TABLE IF EXISTS `trabalhopc_db`.`Compromisso_Usuario`;
CREATE TABLE  `trabalhopc_db`.`Compromisso_Usuario` (
  `Compromisso_id` bigint(20) NOT NULL,
  `participantes_id` bigint(20) NOT NULL,
  PRIMARY KEY (`Compromisso_id`,`participantes_id`),
  UNIQUE KEY `participantes_id` (`participantes_id`),
  KEY `FK90C6FF96B12B030D` (`Compromisso_id`),
  KEY `FK90C6FF9649BFEA5A` (`participantes_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `trabalhopc_db`.`Compromisso_Usuario`
--

/*!40000 ALTER TABLE `Compromisso_Usuario` DISABLE KEYS */;
LOCK TABLES `Compromisso_Usuario` WRITE;
INSERT INTO `trabalhopc_db`.`Compromisso_Usuario` VALUES  (18,6),
 (18,11),
 (19,7);
UNLOCK TABLES;
/*!40000 ALTER TABLE `Compromisso_Usuario` ENABLE KEYS */;


--
-- Definition of table `trabalhopc_db`.`Contato`
--

DROP TABLE IF EXISTS `trabalhopc_db`.`Contato`;
CREATE TABLE  `trabalhopc_db`.`Contato` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dataNascimento` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  `endereco_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9BEFBE0ACDBC1747` (`endereco_id`)
) ENGINE=MyISAM AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `trabalhopc_db`.`Contato`
--

/*!40000 ALTER TABLE `Contato` DISABLE KEYS */;
LOCK TABLES `Contato` WRITE;
INSERT INTO `trabalhopc_db`.`Contato` VALUES  (9,NULL,'','outro teste','',7),
 (10,NULL,'','','',8),
 (11,NULL,'','tr00','',9),
 (12,NULL,'','','',10),
 (13,NULL,'','','',11),
 (14,NULL,'','','',12),
 (15,NULL,NULL,'contato mock',NULL,NULL),
 (16,NULL,'','mais um','',13),
 (17,NULL,'emaildetete@email.com','Usuario de teste','134341',14),
 (18,NULL,'outro@email.com','Tr00','',23),
 (19,NULL,NULL,'contato mock',NULL,NULL),
 (20,NULL,'','','',16),
 (21,NULL,'','','',17),
 (22,NULL,'','','',18),
 (23,NULL,'','eeeeeeeeeeeeeeeeeeeee','',19),
 (24,NULL,'','outro teste','',20),
 (25,NULL,'','aa','',21),
 (26,NULL,'','tr00','',22),
 (27,NULL,NULL,'teeeeeesssssstttteeeeeee',NULL,NULL),
 (28,NULL,NULL,'teeeeeesssssstttteeeeeee',NULL,NULL),
 (29,NULL,NULL,'teeeeeesssssstttteeeeeee',NULL,NULL),
 (30,NULL,NULL,'teeeeeesssssstttteeeeeee',NULL,NULL);
UNLOCK TABLES;
/*!40000 ALTER TABLE `Contato` ENABLE KEYS */;


--
-- Definition of table `trabalhopc_db`.`Contato_Grupo`
--

DROP TABLE IF EXISTS `trabalhopc_db`.`Contato_Grupo`;
CREATE TABLE  `trabalhopc_db`.`Contato_Grupo` (
  `Contato_id` bigint(20) NOT NULL,
  `grupos_id` bigint(20) NOT NULL,
  PRIMARY KEY (`Contato_id`,`grupos_id`),
  UNIQUE KEY `grupos_id` (`grupos_id`),
  KEY `FK43E20DD41D4945AC` (`grupos_id`),
  KEY `FK43E20DD4803A29AD` (`Contato_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `trabalhopc_db`.`Contato_Grupo`
--

/*!40000 ALTER TABLE `Contato_Grupo` DISABLE KEYS */;
LOCK TABLES `Contato_Grupo` WRITE;
INSERT INTO `trabalhopc_db`.`Contato_Grupo` VALUES  (5,4),
 (6,2),
 (9,10);
UNLOCK TABLES;
/*!40000 ALTER TABLE `Contato_Grupo` ENABLE KEYS */;


--
-- Definition of table `trabalhopc_db`.`Endereco`
--

DROP TABLE IF EXISTS `trabalhopc_db`.`Endereco`;
CREATE TABLE  `trabalhopc_db`.`Endereco` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cep` varchar(255) DEFAULT NULL,
  `complemento` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `numero` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `trabalhopc_db`.`Endereco`
--

/*!40000 ALTER TABLE `Endereco` DISABLE KEYS */;
LOCK TABLES `Endereco` WRITE;
INSERT INTO `trabalhopc_db`.`Endereco` VALUES  (1,'2jkçdjfçkads','jkaçdjfkad','ksdlfjakd',23413),
 (2,'4','','',123),
 (3,'4','','',123),
 (4,'ajdkfç','ajk2sçdfj','ajdsçfjak2çd',239),
 (5,'','','',679),
 (6,'','','',134),
 (7,'','','',134),
 (8,'','','',1234),
 (9,'','','',1234),
 (10,'','','',134),
 (11,'','','',2345),
 (12,'','','',890),
 (13,'','','',134),
 (14,'1341234','jdkçfjadçkrfa','Teste',1342),
 (15,'','','',1234),
 (16,'','','',0),
 (17,'','','',0),
 (18,'','','',0),
 (19,'','','',0),
 (20,'','','',0),
 (21,'','','',0),
 (22,'','','',0),
 (23,'','','',1234);
UNLOCK TABLES;
/*!40000 ALTER TABLE `Endereco` ENABLE KEYS */;


--
-- Definition of table `trabalhopc_db`.`Grupo`
--

DROP TABLE IF EXISTS `trabalhopc_db`.`Grupo`;
CREATE TABLE  `trabalhopc_db`.`Grupo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=45 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `trabalhopc_db`.`Grupo`
--

/*!40000 ALTER TABLE `Grupo` DISABLE KEYS */;
LOCK TABLES `Grupo` WRITE;
INSERT INTO `trabalhopc_db`.`Grupo` VALUES  (44,'dfsd'),
 (39,'jkjljkljlj'),
 (41,'outro');
UNLOCK TABLES;
/*!40000 ALTER TABLE `Grupo` ENABLE KEYS */;


--
-- Definition of table `trabalhopc_db`.`Usuario`
--

DROP TABLE IF EXISTS `trabalhopc_db`.`Usuario`;
CREATE TABLE  `trabalhopc_db`.`Usuario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `trabalhopc_db`.`Usuario`
--

/*!40000 ALTER TABLE `Usuario` DISABLE KEYS */;
LOCK TABLES `Usuario` WRITE;
INSERT INTO `trabalhopc_db`.`Usuario` VALUES  (6,'123456',0x00,'mock5'),
 (7,'123456',0x00,'mock5'),
 (8,'123456',0x00,'mock5'),
 (9,'123456',0x00,'mock5'),
 (10,'123456',0x00,'mock5'),
 (11,'password',0x00,'user'),
 (12,'novo',0x00,'novo'),
 (13,'teste',0x00,'teste'),
 (14,'outro',0x00,'outro');
UNLOCK TABLES;
/*!40000 ALTER TABLE `Usuario` ENABLE KEYS */;


--
-- Definition of table `trabalhopc_db`.`Usuario_Compromisso`
--

DROP TABLE IF EXISTS `trabalhopc_db`.`Usuario_Compromisso`;
CREATE TABLE  `trabalhopc_db`.`Usuario_Compromisso` (
  `Usuario_id` bigint(20) NOT NULL,
  `compromissos_id` bigint(20) NOT NULL,
  PRIMARY KEY (`Usuario_id`,`compromissos_id`),
  UNIQUE KEY `compromissos_id` (`compromissos_id`),
  KEY `FKA3E74916C44CDB2D` (`Usuario_id`),
  KEY `FKA3E74916D720B568` (`compromissos_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `trabalhopc_db`.`Usuario_Compromisso`
--

/*!40000 ALTER TABLE `Usuario_Compromisso` DISABLE KEYS */;
LOCK TABLES `Usuario_Compromisso` WRITE;
INSERT INTO `trabalhopc_db`.`Usuario_Compromisso` VALUES  (11,36),
 (11,37),
 (11,39),
 (11,40);
UNLOCK TABLES;
/*!40000 ALTER TABLE `Usuario_Compromisso` ENABLE KEYS */;


--
-- Definition of table `trabalhopc_db`.`Usuario_Contato`
--

DROP TABLE IF EXISTS `trabalhopc_db`.`Usuario_Contato`;
CREATE TABLE  `trabalhopc_db`.`Usuario_Contato` (
  `Usuario_id` bigint(20) NOT NULL,
  `contatos_id` bigint(20) NOT NULL,
  PRIMARY KEY (`Usuario_id`,`contatos_id`),
  UNIQUE KEY `contatos_id` (`contatos_id`),
  KEY `FK2AD001D9C44CDB2D` (`Usuario_id`),
  KEY `FK2AD001D996303FEE` (`contatos_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `trabalhopc_db`.`Usuario_Contato`
--

/*!40000 ALTER TABLE `Usuario_Contato` DISABLE KEYS */;
LOCK TABLES `Usuario_Contato` WRITE;
INSERT INTO `trabalhopc_db`.`Usuario_Contato` VALUES  (11,15),
 (11,17),
 (11,18),
 (11,24);
UNLOCK TABLES;
/*!40000 ALTER TABLE `Usuario_Contato` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
