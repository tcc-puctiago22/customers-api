DROP TABLE IF EXISTS `provider_partner`;
DROP TABLE IF EXISTS `provider_occupational`;
DROP TABLE IF EXISTS `partner`;
DROP TABLE IF EXISTS `provider`;
DROP TABLE IF EXISTS `associate`;
DROP TABLE IF EXISTS `occupational`;
DROP TABLE IF EXISTS `address`;
DROP TABLE IF EXISTS `phone`;
DROP TABLE IF EXISTS `email`;
DROP TABLE IF EXISTS `customer`;

DROP TABLE IF EXISTS `customer_aud`;
DROP TABLE IF EXISTS `address_aud`;
DROP TABLE IF EXISTS `email_aud`;
DROP TABLE IF EXISTS `phone_aud`;
DROP TABLE IF EXISTS `revinfo`;

CREATE TABLE `customer` (
    `id` bigint(20) AUTO_INCREMENT NOT NULL ,
    `uuid` varchar(36) NOT NULL UNIQUE,
    `document` varchar(15) NOT NULL UNIQUE,
    `person_type` varchar(2) NOT NULL,
    `given_name` varchar(100) NOT NULL,
    `status` varchar(30) NOT NULL,
    `updated_at` timestamp DEFAULT CURRENT_TIMESTAMP,
    `create_at` timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `user` varchar(50) DEFAULT 'SYSTEM' NOT NULL,
     PRIMARY KEY (`id`)
);

CREATE TABLE `address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `uuid` varchar(36) NOT NULL UNIQUE,
  `postcode` varchar(9) NOT NULL,
  `street_name` varchar(255) NOT NULL,
  `street_number` mediumint(6) NOT NULL,
  `complement` varchar(255) DEFAULT NULL,
  `district` varchar(255) NOT NULL,
  `country` varchar(100) NOT NULL,
  `uf` char(2) NOT NULL,
  `city` varchar(100) NOT NULL,
  `create_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   `user` varchar(50) DEFAULT 'SYSTEM' NOT NULL,
   `status` varchar(10)  DEFAULT 'ACTIVE',
  `customer_id` bigint(20),
   PRIMARY KEY (`id`),
  KEY `customer_id` (`customer_id`),
  CONSTRAINT `address_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
);

CREATE TABLE `phone` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `uuid` varchar(36) NOT NULL UNIQUE,
  `ddd` varchar(2) NOT NULL,
  `country` varchar(3) NOT NULL,
  `phone_number` varchar(11) NOT NULL,
  `type` varchar(100) DEFAULT NULL,
  `customer_id` bigint(20),
  `create_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user` varchar(50) DEFAULT 'SYSTEM',
   `status` varchar(10)  DEFAULT 'ACTIVE',
  PRIMARY KEY (`id`),
  KEY `customer_id` (`customer_id`),
  CONSTRAINT `phone_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
);

CREATE TABLE `email` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `uuid` varchar(36) NOT NULL UNIQUE,
  `email` varchar(255) NOT NULL,
  `type` varchar(100) DEFAULT NULL,
  `customer_id` bigint(20),
   `status` varchar(10)  DEFAULT 'ACTIVE',
  `create_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user` varchar(50) DEFAULT 'SYSTEM',
  PRIMARY KEY (`id`),
  KEY `customer_id` (`customer_id`),
  CONSTRAINT `email_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
);

CREATE TABLE `occupational` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
   `uuid` varchar(36) NOT NULL UNIQUE,
  `type` varchar(10) NOT NULL,
  `description` varchar(200) NOT NULL,
  `code` varchar(50) DEFAULT NULL,
  `create_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user` varchar(50) DEFAULT 'SYSTEM',
  `status` varchar(10)  DEFAULT 'ACTIVE',
  PRIMARY KEY (`id`)
);

CREATE TABLE `provider` (
    `id`  bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `uuid` varchar(36) NOT NULL,
    `registration` varchar(100),
	`create_at` datetime DEFAULT CURRENT_TIMESTAMP,
	`updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   `user` varchar(50) DEFAULT 'SYSTEM',
   `status` varchar(10)  DEFAULT 'ACTIVE',
   `customer_id` bigint(20),
    KEY `customer_id` (`customer_id`),
    `occupational_id` bigint(20),
    KEY `occupational_id` (`occupational_id`),
    CONSTRAINT `provider_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
    CONSTRAINT `occupational_ibfk_1` FOREIGN KEY (`occupational_id`) REFERENCES `occupational` (`id`)
);

CREATE TABLE `partner` (
    `id`  bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `uuid` varchar(36) NOT NULL,
    `fantasy_name` varchar(100) NOT NULL,
    `registration` varchar(100),
 	`create_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `user` varchar(50) DEFAULT 'SYSTEM',
    `status` varchar(10)  DEFAULT 'ACTIVE',
     `customer_id` bigint(20),
  KEY `customer_id` (`customer_id`),
  CONSTRAINT `partner_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
 );

CREATE TABLE `provider_partner` (
  `provider_id` bigint(20) NOT NULL,
  `partner_id` bigint(20) NOT NULL,
  PRIMARY KEY (`provider_id`,`partner_id`),
  KEY `provider_id` (`partner_id`),
  CONSTRAINT `provider_partner_ibfk_1`
    FOREIGN KEY (`partner_id`) REFERENCES `partner` (`id`),
  CONSTRAINT `provider_partner_ibfk_2`
    FOREIGN KEY (`provider_id`) REFERENCES `provider` (`id`)
);

CREATE TABLE `provider_occupational` (
  `occupational_id` bigint(20) NOT NULL,
  `provider_id` bigint(20) NOT NULL,
  PRIMARY KEY (`occupational_id`,`provider_id`),
  KEY `occupational_id` (`provider_id`),
    CONSTRAINT `provider_occupational_ibfk_1`
    FOREIGN KEY (`occupational_id`) REFERENCES `occupational` (`id`),
 CONSTRAINT `provider_occupational_ibfk_2`
    FOREIGN KEY (`provider_id`) REFERENCES `provider` (`id`)
);

CREATE TABLE `associate` (
    `id`  bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `uuid` varchar(36) NOT NULL UNIQUE,
    `registration` varchar(100) NOT NULL,
     `plan_uuid` varchar(36),
     `account_uuid` varchar(36),
	`create_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `user` varchar(50) DEFAULT 'SYSTEM',
    `status` varchar(10)  DEFAULT 'ACTIVE',
	`customer_id` bigint(20),
    KEY `customer_id` (`customer_id`),
   CONSTRAINT `associate_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
 );

INSERT INTO occupational (code,uuid, type, description, create_at , user)
VALUES
 ('MC01','2f04150e-c6b3-4ede-900f-f803a2039456','MEDICO', 'Cardiologia', '2022-08-26 00:00:00', 'tiagobrito'),
 ('MC02','ec019059-83b3-4bce-b812-171e8f7db36b',"MEDICO",'Clinico Geral', '2022-08-26 00:00:00', 'tiagobrito'),
 ('MD03','1f9336be-e17e-48af-a607-9066b16c7492','MEDICO', 'Dermatologia', '2022-08-26 00:00:00', 'tiagobrito'),
 ('ME04','9b715541-967a-4e79-9c10-c1b0d334a6bd','MEDICO', 'Enfermagem', '2022-08-26 00:00:00', 'tiagobrito'),
 ('MP05','38da7543-a8a1-45cc-b1c7-fe6845bdd08e','MEDICO', 'Pediatria', '2022-08-26 00:00:00', 'tiagobrito'),
 ('MT06','7f2dd0f6-cb71-43ef-82e8-1168511340a0','MEDICO', 'Terapia Ocupacional', '2022-08-26 00:00:00', 'tiagobrito'),
 ('MU07','b5b520fd-5f17-463c-b95b-f1ffd213256a','MEDICO', 'Urologia', '2022-08-26 00:00:00', 'tiagobrito'),
 ('OE08','4bbe9ca2-dd69-40f0-a015-54f4fe056067','ODONTO', 'Endodontia', '2022-08-26 00:00:00', 'tiagobrito'),
 ('OE09','9dc52c0b-61fc-41b3-8c61-67b84c2074a3','ODONTO', 'Implantes', '2022-08-26 00:00:00', 'tiagobrito'),
 ('OE010','a2d945d5-0858-4a43-a2b4-f0f770bb2b41','ODONTO', 'Ordontia', '2022-08-26 00:00:00', 'tiagobrito');