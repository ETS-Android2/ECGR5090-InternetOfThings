-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 10, 2020 at 01:24 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `49nersense`
--

-- --------------------------------------------------------

--
-- Table structure for table `details`
--

CREATE TABLE `details` (
  `id` int(255) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` mediumtext NOT NULL,
  `email` varchar(45) NOT NULL,
  `phone` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `details`
--

INSERT INTO `details` (`id`, `username`, `password`, `email`, `phone`) VALUES
(0, 'demo', 'demo', 'a@a.com', 123456789);

-- --------------------------------------------------------

--
-- Table structure for table `senseactuat`
--

CREATE TABLE `senseactuat` (
  `houseID` int(11) NOT NULL COMMENT 'House ID',
  `gdoor1` tinyint(1) DEFAULT NULL COMMENT 'Garage Door One Control Status',
  `gdoor2` tinyint(1) DEFAULT NULL COMMENT 'Garage Door Two Control Status',
  `lightsFlr2` tinyint(4) DEFAULT NULL COMMENT 'Lights Status Floor 2',
  `lightsFlr1` tinyint(4) DEFAULT NULL COMMENT 'Lights Status Floor 1',
  `lockFrontDoor` tinyint(1) DEFAULT NULL COMMENT 'Front Door Lock Status',
  `lockBackDoor` tinyint(1) DEFAULT NULL COMMENT 'Back Door Lock Status',
  `lockGrgdoors` tinyint(1) DEFAULT NULL COMMENT 'Garage Door Lock Status',
  `sensorFlr2` tinyint(1) DEFAULT NULL COMMENT 'Floor 2 Door Window Sensor Status',
  `sensorFlr1` tinyint(1) DEFAULT NULL COMMENT 'Floor 1 Door Window Sensor Status',
  `motionDtctFlr1` tinyint(1) DEFAULT NULL COMMENT 'Motion Detector Status Floor 1',
  `motionDtctFlr2` tinyint(1) DEFAULT NULL COMMENT 'Motion Detector Status Floor 2',
  `secStatus` tinyint(1) DEFAULT NULL COMMENT 'House Security Status i.e Armed Home, Disarmed and Armed Away'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Table Representing The Status Of All Devices And Sensors';

--
-- Dumping data for table `senseactuat`
--

INSERT INTO `senseactuat` (`houseID`, `gdoor1`, `gdoor2`, `lightsFlr2`, `lightsFlr1`, `lockFrontDoor`, `lockBackDoor`, `lockGrgdoors`, `sensorFlr2`, `sensorFlr1`, `motionDtctFlr1`, `motionDtctFlr2`, `secStatus`) VALUES
(112, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `thermostat`
--

CREATE TABLE `thermostat` (
  `houseID` int(11) NOT NULL COMMENT 'House ID',
  `flr1_tempControl` int(11) DEFAULT NULL COMMENT 'Floor Temperature Control',
  `flr2_tempControl` int(11) DEFAULT NULL COMMENT 'Floor 2 Temperature Control',
  `flr1_tempCurrent` int(11) DEFAULT NULL COMMENT 'Floor 1 Temp Current',
  `flr2_tempCurrent` int(11) DEFAULT NULL COMMENT 'Floor 2 Temp Current',
  `flr1_tempFan` int(11) DEFAULT NULL COMMENT 'Floor 1 Fan Status',
  `flr2_tempFan` int(11) DEFAULT NULL COMMENT 'Floor 2 Fan Status',
  `flr1_tempMode` tinyint(1) DEFAULT NULL COMMENT 'Floor 1 Temp Mode',
  `flr2_tempMode` tinyint(1) DEFAULT NULL COMMENT 'Floor 2 Temp Mode'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `thermostat`
--

INSERT INTO `thermostat` (`houseID`, `flr1_tempControl`, `flr2_tempControl`, `flr1_tempCurrent`, `flr2_tempCurrent`, `flr1_tempFan`, `flr2_tempFan`, `flr1_tempMode`, `flr2_tempMode`) VALUES
(112, 55, 55, 70, 71, 1, 1, 1, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `details`
--
ALTER TABLE `details`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `senseactuat`
--
ALTER TABLE `senseactuat`
  ADD PRIMARY KEY (`houseID`);

--
-- Indexes for table `thermostat`
--
ALTER TABLE `thermostat`
  ADD PRIMARY KEY (`houseID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
