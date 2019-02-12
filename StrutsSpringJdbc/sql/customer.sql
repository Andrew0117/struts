DROP DATABASE IF EXISTS `customer`;

CREATE DATABASE `customer`
  CHARACTER SET = 'utf8'
  COLLATE = 'utf8_unicode_ci';

USE `customer`;

DELIMITER //

CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `surName` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `birthday` datetime NOT NULL,
  `gender` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

//
DELIMITER ;