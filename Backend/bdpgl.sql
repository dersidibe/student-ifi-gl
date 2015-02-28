-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Feb 28, 2015 at 05:15 PM
-- Server version: 5.5.41-0ubuntu0.14.04.1
-- PHP Version: 5.5.9-1ubuntu4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `bdpgl`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_structure`(lat1 DOUBLE, lng1 DOUBLE, typeStruct INT)
BEGIN 
	DECLARE type INT;
	Set type = typeStruct;
	CASE type

		WHEN 1 THEN SELECT *, get_distance_metres(lat1, lng1, latStruct, lgStruct) AS distance FROM pharmacie
	 		Having distance < 2000 ORDER BY distance ASC LIMIT 10;

		WHEN 2 THEN SELECT *, get_distance_metres(lat1, lng1, latStruct, lgStruct) AS distance FROM clinique
	 		Having distance < 2000 ORDER BY distance ASC LIMIT 10;

		WHEN 3 THEN SELECT *, get_distance_metres(lat1, lng1, latStruct, lgStruct) AS distance FROM hopital
	 		Having distance < 2000 ORDER BY distance ASC LIMIT 10;
	END CASE;

END$$

--
-- Functions
--
CREATE DEFINER=`root`@`localhost` FUNCTION `get_distance_metres`(`lat1` DOUBLE, `lng1` DOUBLE, `lat2` DOUBLE, `lng2` DOUBLE) RETURNS double
BEGIN
    DECLARE rlo1 DOUBLE;
    DECLARE rla1 DOUBLE;
    DECLARE rlo2 DOUBLE;
    DECLARE rla2 DOUBLE;
    DECLARE dlo DOUBLE;
    DECLARE dla DOUBLE;
    DECLARE a DOUBLE;
    
    SET rlo1 = RADIANS(lng1);
    SET rla1 = RADIANS(lat1);
    SET rlo2 = RADIANS(lng2);
    SET rla2 = RADIANS(lat2);
    SET dlo = (rlo2 - rlo1) / 2;
    SET dla = (rla2 - rla1) / 2;
    SET a = SIN(dla) * SIN(dla) + COS(rla1) * COS(rla2) * SIN(dlo) * SIN(dlo);
    RETURN ROUND((6378137 * 2 * ATAN2(SQRT(a), SQRT(1 - a))),2);
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Stand-in structure for view `clinique`
--
CREATE TABLE IF NOT EXISTS `clinique` (
`idStruct` int(11)
,`nomStruct` text
,`rueStruct` text
,`latStruct` text
,`lgStruct` text
,`telStruct` text
);
-- --------------------------------------------------------

--
-- Table structure for table `forum`
--

CREATE TABLE IF NOT EXISTS `forum` (
  `idForum` int(11) NOT NULL AUTO_INCREMENT,
  `idStruct` int(11) NOT NULL,
  `nomUser` varchar(40) NOT NULL,
  `content` text NOT NULL,
  PRIMARY KEY (`idForum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Stand-in structure for view `hopital`
--
CREATE TABLE IF NOT EXISTS `hopital` (
`idStruct` int(11)
,`nomStruct` text
,`rueStruct` text
,`latStruct` text
,`lgStruct` text
,`telStruct` text
);
-- --------------------------------------------------------

--
-- Stand-in structure for view `pharmacie`
--
CREATE TABLE IF NOT EXISTS `pharmacie` (
`idStruct` int(11)
,`nomStruct` text
,`rueStruct` text
,`latStruct` text
,`lgStruct` text
,`telStruct` text
);
-- --------------------------------------------------------

--
-- Table structure for table `structure`
--

CREATE TABLE IF NOT EXISTS `structure` (
  `idStruct` int(11) NOT NULL AUTO_INCREMENT,
  `nomStruct` text NOT NULL,
  `rueStruct` text NOT NULL,
  `latStruct` text NOT NULL,
  `lgStruct` text NOT NULL,
  `telStruct` text NOT NULL,
  `typeStruct` int(11) NOT NULL,
  PRIMARY KEY (`idStruct`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=19 ;

--
-- Dumping data for table `structure`
--

INSERT INTO `structure` (`idStruct`, `nomStruct`, `rueStruct`, `latStruct`, `lgStruct`, `telStruct`, `typeStruct`) VALUES
(1, 'Cua Hang Nhung Huou Viet', '1B9 Ngõ 201, Tran Quoc Hoàn, Quan Cau Giay', '21.041619', '105.781903', '+84 4 8585 8574', 1),
(3, 'Private Pharmacy', 'Tran Quoc Hoàn, Dich Vong Hau, Cau Giay', '21.041979', '105.782204', '+84 94 666 90 34', 1),
(4, 'Công Ty TNHH Duoc Pham Pectin', '243, Tran Quoc Hoàn, Dich Vong Hau, Quan Cau Giay', '21.041599', '105.785573', '+84 90 329 15 69', 1),
(5, 'Nhà thuoc HY VONG', 'Dich Vong Hau Cau Giay', '21.041118', '105.788770', '+84 4 3791 1442', 1),
(6, 'Kamin Pharma Joint Stock Company', '27, Xuan Thuy Street, Dich Vong Hau Ward, Cau Giay District', '21.036952', '105.789371', '+84 125 874 5911', 1),
(7, '30 Nguyen Phong Sac Pharmacy', '30, Nguyen Phong Sac Street, Nghia Tan Ward, Cau Giay District', '21.044402', '105.789843', '+84 98 624 34 15', 1),
(8, 'Hong Loan Pharmacy', '27 To Hieu Street, Cau Giay District', '21.041819', '105.791388', '+84 4 3836 4798', 1),
(9, 'Nhà Thuoc So 3', 'P101-C1, Phuong Nghia Tan, Quan Cau Giay', '21.043681', '105.792010', '+84 4 3791 3984', 1),
(10, 'Nhà Thuoc Mai Huong', '108b - A12 Nghia Tân Cau Giay', '21.043561', '105.793319', '+84 4 3756 5747', 1),
(11, 'Công Ty Trách Nhiem Huu Han Duoc Pham An Phú', '197, Tran Dang Ninh, Phuong Dich Vong, Quan Cau Giay', '21.038975', '105.792289', '+84 4 6299 8979', 1),
(12, 'Hoang Phat Pharmaceutical & Trading JSC', '6, Ngõ 5, Duong Tran Quý Kiên, Quan Cau Giay', '21.037513', '105.791709', '+84 4 3769 0103', 1),
(13, 'Cong Minh Pharmacy', '217 Tran Dang Ninh Street, Cau Giay District', '21.036792', '105.794349', '+84 4 3754 5605', 1),
(14, 'Nhà Thuoc Tâm An', '145 Tran Dang Ninh Dich Vong, Cau Giay', '21.038494', '105.793190', '+84 4 6283 1975', 1),
(15, 'Dich Vu Mua Bán Duoc Pham Vu Thi Kim Thoa', 'A15, Duong Com Vòng, Phuong Dich Vong Hau, Quan Cau Giay', '21.031050', '105.785560', '+84 92 557 83 89', 1),
(16, '3a Pharmaceutical Co., Ltd', 'Lô A1E, P. Dich Vong Hau, Q. Cau Giay, Hà Noi', '21.033574', '105.786826', '+84 4 3633 3126', 1),
(17, 'Quay Thuoc Tây Nguyen Thi Thanh Thu', '34, Dich Vong, Quan Cau Giay', '21.032247', '105.792734', '+84 164 691 9101', 1),
(18, 'Nhà Thuoc 52B Dich Vong', '52B, Dich Vong, Quan Cau Giay', '21.033869', '105.793593', '+84 91 900 15 61', 1);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `idUser` int(11) NOT NULL AUTO_INCREMENT,
  `nomUser` varchar(40) NOT NULL,
  PRIMARY KEY (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure for view `clinique`
--
DROP TABLE IF EXISTS `clinique`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `clinique` AS select `s`.`idStruct` AS `idStruct`,`s`.`nomStruct` AS `nomStruct`,`s`.`rueStruct` AS `rueStruct`,`s`.`latStruct` AS `latStruct`,`s`.`lgStruct` AS `lgStruct`,`s`.`telStruct` AS `telStruct` from `structure` `s` where (`s`.`typeStruct` = 2);

-- --------------------------------------------------------

--
-- Structure for view `hopital`
--
DROP TABLE IF EXISTS `hopital`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `hopital` AS select `s`.`idStruct` AS `idStruct`,`s`.`nomStruct` AS `nomStruct`,`s`.`rueStruct` AS `rueStruct`,`s`.`latStruct` AS `latStruct`,`s`.`lgStruct` AS `lgStruct`,`s`.`telStruct` AS `telStruct` from `structure` `s` where (`s`.`typeStruct` = 3);

-- --------------------------------------------------------

--
-- Structure for view `pharmacie`
--
DROP TABLE IF EXISTS `pharmacie`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `pharmacie` AS select `s`.`idStruct` AS `idStruct`,`s`.`nomStruct` AS `nomStruct`,`s`.`rueStruct` AS `rueStruct`,`s`.`latStruct` AS `latStruct`,`s`.`lgStruct` AS `lgStruct`,`s`.`telStruct` AS `telStruct` from `structure` `s` where (`s`.`typeStruct` = 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
