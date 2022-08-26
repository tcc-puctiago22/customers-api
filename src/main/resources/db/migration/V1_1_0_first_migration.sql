CREATE TABLE IF NOT EXISTS `customer` (

    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `uuid` varchar(36) NOT NULL,
    `given_name` varchar(100),
    `status` varchar(30),
    `updated_at` timestamp,
    `create_at` timestamp,
    `user` varchar(50)

)ENGINE=InnoDB DEFAULT CHARSET=UTF8;