DROP TABLE IF EXISTS `provider_partner`;
DROP TABLE IF EXISTS `partner`;
DROP TABLE IF EXISTS `provider`;
DROP TABLE IF EXISTS `associate`;
DROP TABLE IF EXISTS `occupational`;
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
    `user` varchar(50) DEFAULT 'SYSTEM' NOT NULL,
     PRIMARY KEY (`id`)
);

CREATE TABLE `address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `postcode` varchar(9) NOT NULL,
  `street_name` varchar(255) NOT NULL,
  `street_number` mediumint(6) NOT NULL,
  `complement` varchar(255) DEFAULT NULL,
  `district` varchar(255) NOT NULL,
  `country` varchar(100) NOT NULL,
  `uf` char(2) NOT NULL,
  `city` varchar(100) NOT NULL,
  `create_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   `user` varchar(50) DEFAULT 'SYSTEM' NOT NULL,
   `status` varchar(10)  DEFAULT 'ACTIVE',
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
  `create_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user` varchar(50) DEFAULT 'SYSTEM',
   `status` varchar(10)  DEFAULT 'ACTIVE',
  PRIMARY KEY (`id`),
  KEY `customer_id` (`customer_id`),
  CONSTRAINT `phone_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
);

CREATE TABLE `email` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(14) NOT NULL,
  `type` varchar(100) DEFAULT NULL,
  `customer_id` bigint(20) NOT NULL,
   `status` varchar(10)  DEFAULT 'ACTIVE',
  `create_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user` varchar(50) DEFAULT 'SYSTEM',
  PRIMARY KEY (`id`),
  KEY `customer_id` (`customer_id`),
  CONSTRAINT `email_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
);

CREATE TABLE `occupational` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(200) NOT NULL,
  `code` varchar(50) DEFAULT NULL,
  `create_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user` varchar(50) DEFAULT 'SYSTEM',
  `status` varchar(10)  DEFAULT 'ACTIVE',
  PRIMARY KEY (`id`)
);

CREATE TABLE `provider` (
    `id`  bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `uuid` varchar(36) NOT NULL,
    `registration` varchar(100),
	`create_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   `user` varchar(50) DEFAULT 'SYSTEM',
   `status` varchar(10)  DEFAULT 'ACTIVE',
   `customer_id` bigint(20) NOT NULL,
    KEY `customer_id` (`customer_id`),
    `occupational_id` bigint(20) NOT NULL,
    KEY `occupational_id` (`occupational_id`),
    CONSTRAINT `provider_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
    CONSTRAINT `occupational_ibfk_1` FOREIGN KEY (`occupational_id`) REFERENCES `occupational` (`id`)
);

CREATE TABLE `partner` (
    `id`  bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `uuid` varchar(36) NOT NULL,
    `registration` varchar(100),
 	`create_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `user` varchar(50) DEFAULT 'SYSTEM',
    `status` varchar(10)  DEFAULT 'ACTIVE',
      `customer_id` bigint(20) NOT NULL,
  KEY `customer_id` (`customer_id`),
  CONSTRAINT `partner_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
 );

CREATE TABLE `provider_partner` (
  `provider_id` bigint(20) NOT NULL,
  `partner_id` bigint(20) NOT NULL,
  PRIMARY KEY (`provider_id`,`partner_id`),
  KEY `provider_id` (`provider_id`),
  CONSTRAINT `provider_partner_ibfk_1`
   FOREIGN KEY (`partner_id`) REFERENCES `partner` (`id`),
  CONSTRAINT `provider_partner_ibfk_2`
   FOREIGN KEY (`provider_id`) REFERENCES `provider` (`id`)
);

CREATE TABLE `associate` (
    `id`  bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `uuid` varchar(36) NOT NULL,
    `registration` varchar(100),
     `plan_uuid` varchar(36),
	`create_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `user` varchar(50) DEFAULT 'SYSTEM',
    `status` varchar(10)  DEFAULT 'ACTIVE',
	`customer_id` bigint(20) NOT NULL,
    KEY `customer_id` (`customer_id`),
   CONSTRAINT `associate_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
 );

INSERT INTO occupational (code, description, create_at , user)
VALUES
 ('M01', 'Médico', '2022-08-26 00:00:00', 'tiagobrito'),
 ('E02', 'Enfermeiro', '2022-08-26 00:00:00', 'tiagobrito'),
 ('F03', 'Farmacêutico', '2022-08-26 00:00:00', 'tiagobrito'),
 ('F04', 'Fisioterapeuta', '2022-08-26 00:00:00', 'tiagobrito'),
 ('F05', 'Fonoaudiólogo', '2022-08-26 00:00:00', 'tiagobrito'),
 ('T06', 'Tecnólogo em sistemas biomédicos', '2022-08-26 00:00:00', 'tiagobrito'),
 ('T07', 'Tecnólogo em radiologia.', '2022-08-26 00:00:00', 'tiagobrito');