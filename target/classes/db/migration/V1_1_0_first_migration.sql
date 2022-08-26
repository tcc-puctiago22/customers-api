DROP TABLE IF EXISTS `occupational`;
DROP TABLE IF EXISTS `provider`;
DROP TABLE IF EXISTS `address`;
DROP TABLE IF EXISTS `phone`;
DROP TABLE IF EXISTS `email`;
DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
    `id` bigint(20) AUTO_INCREMENT NOT NULL ,
    `uuid` varchar(36) NOT NULL,
    `given_name` varchar(100) NOT NULL,
    `status` varchar(30) NOT NULL,
    `updated_at` timestamp,
    `create_at` timestamp,
    `user_` varchar(50) NOT NULL,
     PRIMARY KEY (`id`)
);

CREATE TABLE `address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `postcode` varchar(9) NOT NULL,
  `street_name` varchar(255) NOT NULL,
  `street_number` mediumint(6) NOT NULL,
  `complement` varchar(255) DEFAULT NULL,
  `district` varchar(255) NOT NULL,
  `country` smallint(5) NOT NULL,
  `country_desc` varchar(255) NOT NULL,
  `uf` char(2) NOT NULL,
  `city` varchar(100) NOT NULL,
  `createdAt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `deletedAt` datetime DEFAULT NULL,
  `customer_id` bigint(20) NOT NULL,
   PRIMARY KEY (`id`),
  KEY `customer_id` (`customer_id`),
  CONSTRAINT `address_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
);

CREATE TABLE `phone` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dd` varchar(2) NOT NULL,
  `country` varchar(3) NOT NULL,
  `phone_number` varchar(11) NOT NULL,
  `type` varchar(100) DEFAULT NULL,
  `customer_id` bigint(20) NOT NULL,
  `createdAt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `customer_id` (`customer_id`),
  CONSTRAINT `phone_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
);

CREATE TABLE `email` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(14) NOT NULL,
  `type` varchar(100) DEFAULT NULL,
  `customer_id` bigint(20) NOT NULL,
  `createdAt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `customer_id` (`customer_id`),
  CONSTRAINT `email_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
);

CREATE TABLE IF NOT EXISTS `provider` (
    `id`  bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `uuid` varchar(36) NOT NULL,
    `registration` varchar(100),
    `status` varchar(30),
    `updated_at` timestamp,
    `create_at` timestamp,
    `user` varchar(50),
    `customer_id` bigint(20) NOT NULL,
   KEY `customer_id` (`customer_id`),
  CONSTRAINT `provider_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
);

CREATE TABLE `occupational` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(200) NOT NULL,
  `code` varchar(50) DEFAULT NULL,
  `provider_id` bigint(20) NOT NULL,
  `createdAt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `provider_id` (`provider_id`),
  CONSTRAINT `occupational_ibfk_1` FOREIGN KEY (`provider_id`) REFERENCES `provider` (`id`)
);
