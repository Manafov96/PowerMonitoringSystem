-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time:  4 май 2020 в 10:14
-- Версия на сървъра: 5.7.24
-- PHP Version: 7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `powermonitoring`
--

-- --------------------------------------------------------

--
-- Структура на таблица `electric_energy`
--

DROP TABLE IF EXISTS `electric_energy`;
CREATE TABLE IF NOT EXISTS `electric_energy` (
  `id` int(11) NOT NULL,
  `f` double NOT NULL,
  `i1` double NOT NULL,
  `i2` double NOT NULL,
  `i3` double NOT NULL,
  `p` double NOT NULL,
  `q` double NOT NULL,
  `u1` double NOT NULL,
  `u2` double NOT NULL,
  `u3` double NOT NULL,
  `sensorid` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `datetime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Схема на данните от таблица `electric_energy`
--

INSERT INTO `electric_energy` (`id`, `f`, `i1`, `i2`, `i3`, `p`, `q`, `u1`, `u2`, `u3`, `sensorid`, `datetime`) VALUES
(1, 52.5, 10.1, 10, 15, 45.9, 17.2, 19, 20, 22, 'PST05', '2020-05-01 03:00:00'),
(2, 77, 10.2, 15, 12, 33.9, 17.2, 18, 15, 12.3, 'MCP39F501', '2020-05-01 17:25:00'),
(3, 77.2, 15.1, 17, 12, 45.9, 17.9, 10, 11, 15, 'PST05', '2020-05-18 09:00:00'),
(4, 56, 12.2, 14, 13, 33.9, 15, 19.2, 17, 22.01, 'MCP39F501', '2020-05-03 23:00:00');

-- --------------------------------------------------------

--
-- Структура на таблица `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Схема на данните от таблица `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(2),
(2);

-- --------------------------------------------------------

--
-- Структура на таблица `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `role_id` int(11) NOT NULL,
  `role` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Схема на данните от таблица `role`
--

INSERT INTO `role` (`role_id`, `role`) VALUES
(1, 'ADMIN'),
(2, 'USER');

-- --------------------------------------------------------

--
-- Структура на таблица `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL,
  `active` int(11) DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `first_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Схема на данните от таблица `user`
--

INSERT INTO `user` (`id`, `active`, `email`, `first_name`, `last_name`, `password`) VALUES
(1, 1, 'user@user.com', 'Selvi', 'Manafov', '$2a$10$992iZw4zAgR0idXTfsTRrOmu76kQbvKPu8cs/xo8M5zIqB2RWrQKe');

-- --------------------------------------------------------

--
-- Структура на таблица `user_role`
--

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE IF NOT EXISTS `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Схема на данните от таблица `user_role`
--

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(1, 1);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
