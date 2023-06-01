-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Dec 17, 2021 at 06:47 PM
-- Server version: 8.0.21
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `projetjava`
--

-- --------------------------------------------------------
--
-- Table structure for table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `Utilisateur` VARCHAR(20)  NOT NULL,
  `Password` varchar(20) NOT NULL,
  PRIMARY KEY (`Utilisateur`),
  UNIQUE KEY `Utilisateur` (`Utililsateur`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `utilisateur'
--

INSERT INTO `utilisateur` (`Utilisateur`,`Password`) VALUES('admin','adminpwd');

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `CIN` int(8) UNSIGNED ZEROFILL NOT NULL,
  `Nom` varchar(20) NOT NULL,
  `Addresse` varchar(50) NOT NULL,
  `Mobile` int NOT NULL,
  PRIMARY KEY (`CIN`),
  UNIQUE KEY `mobile` (`Mobile`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`CIN`, `Nom`, `Addresse`, `Mobile`) VALUES
(07499234, 'Hassan', 'Soukra', 27708478);

-- --------------------------------------------------------

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
CREATE TABLE IF NOT EXISTS `location` (
  `Matricule` varchar(10) NOT NULL,
  `CIN` int(8) UNSIGNED ZEROFILL NOT NULL,
  `Montant` int NOT NULL,
  `datedeb` date NOT NULL,
  `datefin` date NOT NULL,
  PRIMARY KEY (`Matricule`),
  KEY `fk_cin` (`CIN`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `retour`
--

DROP TABLE IF EXISTS `retour`;
CREATE TABLE IF NOT EXISTS `retour` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Matricule` varchar(10) NOT NULL,
  `CIN` int(8) UNSIGNED ZEROFILL NOT NULL,
  `date_retour` date NOT NULL,
  `amende` int NOT NULL,
  `retard` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `voitures`
--

DROP TABLE IF EXISTS `voitures`;
CREATE TABLE IF NOT EXISTS `voitures` (
  `Matricule` varchar(10) NOT NULL,
  `Marque` varchar(20) NOT NULL,
  `Modele` varchar(20) NOT NULL,
  `Couleur` varchar(20) NOT NULL,
  `Disponibilite` varchar(3) NOT NULL DEFAULT 'Yes',
  PRIMARY KEY (`Matricule`(9)),
  KEY `Disp` (`Disponibilite`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `voitures`
--

INSERT INTO `voitures` (`Matricule`, `Marque`, `Modele`, `Couleur`, `Disponibilite`) VALUES
('210TN1789', 'Hyundai', 'Tucson', 'Grise', 'Yes');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
