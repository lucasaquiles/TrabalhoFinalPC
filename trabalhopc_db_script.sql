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
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `trabalhopc_db`.`Categoria`
--

/*!40000 ALTER TABLE `Categoria` DISABLE KEYS */;
LOCK TABLES `Categoria` WRITE;
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
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `trabalhopc_db`.`Compromisso`
--

/*!40000 ALTER TABLE `Compromisso` DISABLE KEYS */;
LOCK TABLES `Compromisso` WRITE;
INSERT INTO `trabalhopc_db`.`Compromisso` VALUES  (1,NULL,'2011-07-02 00:00:00',NULL,'Reunião de tr00s',NULL);
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
INSERT INTO `trabalhopc_db`.`Compromisso_Usuario` VALUES  (1,1),
 (1,2),
 (1,3);
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
  `grupo_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9BEFBE0ACDBC1747` (`endereco_id`),
  KEY `FK9BEFBE0A68F57E0D` (`grupo_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `trabalhopc_db`.`Contato`
--

/*!40000 ALTER TABLE `Contato` DISABLE KEYS */;
LOCK TABLES `Contato` WRITE;
INSERT INTO `trabalhopc_db`.`Contato` VALUES  (1,NULL,'email@tr00host.com',NULL,'telefone 1',1,NULL),
 (2,NULL,'email2@tr00host.com','contato tr00','telefone 2',2,NULL),
 (3,NULL,'email2@tr00host.com','contato tr00','telefone 2',3,NULL);
UNLOCK TABLES;
/*!40000 ALTER TABLE `Contato` ENABLE KEYS */;


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
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `trabalhopc_db`.`Endereco`
--

/*!40000 ALTER TABLE `Endereco` DISABLE KEYS */;
LOCK TABLES `Endereco` WRITE;
INSERT INTO `trabalhopc_db`.`Endereco` VALUES  (1,'00000000',NULL,'rua tr00',240),
 (2,'00000000',NULL,'rua tr00',240),
 (3,'00000000',NULL,'rua tr00',240);
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
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `trabalhopc_db`.`Grupo`
--

/*!40000 ALTER TABLE `Grupo` DISABLE KEYS */;
LOCK TABLES `Grupo` WRITE;
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
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `trabalhopc_db`.`Usuario`
--

/*!40000 ALTER TABLE `Usuario` DISABLE KEYS */;
LOCK TABLES `Usuario` WRITE;
INSERT INTO `trabalhopc_db`.`Usuario` VALUES  (1,'123456',0x00,'mock1'),
 (2,'senhatr00',0x00,'tr00'),
 (3,'senhaFuckYeah',0x00,'FuckYeah'),
 (4,'senhaTr00',0x00,'UsuarioTr00');
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
INSERT INTO `trabalhopc_db`.`Usuario_Contato` VALUES  (1,2);
UNLOCK TABLES;
/*!40000 ALTER TABLE `Usuario_Contato` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
