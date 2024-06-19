/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 5.7.34 : Database - spring_react
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`spring_react` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `spring_react`;

/*Data for the table `books` */

insert  into `books`(`id`,`title`,`author`,`isbn`,`publication_date`,`genre`,`description`,`file_path`) values 
(1,'Spring In Action','Craig Walls','20240408',NULL,'coder','todo',NULL),
(6,'Spring Boot in Action','Craig Walls','20240408',NULL,'coder','todo',NULL),
(7,'Fullstack React: The Complete Guide to ReactJS and Friends','Anthony Accomazzo、Nate Murray、HMR、and Clay Allsopp','20240408',NULL,'coder','todo',NULL),
(8,'React Native Cookbook','Dan Ward','20240408',NULL,'coder','todo',NULL),
(9,'Docker in Action','Jeff Nickoloff、Stephen Kuenzli','20240408',NULL,'coder','todo',NULL),
(10,'Jenkins: The Definitive Guide','John Ferguson Smart','20240408',NULL,'coder','todo',NULL),
(11,'Effective Java','Joshua Bloch','20240408',NULL,'coder','todo',NULL),
(12,'Continuous Delivery: Reliable Software Releases through Build, Test, and Deployment Automation','Jez Humble、David Farley','20240408',NULL,'coder','todo',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
