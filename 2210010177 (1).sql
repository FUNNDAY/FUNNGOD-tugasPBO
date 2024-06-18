-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jun 18, 2024 at 04:55 AM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `2210010177`
--

-- --------------------------------------------------------

--
-- Table structure for table `desa`
--

CREATE TABLE `desa` (
  `IdDesa` int NOT NULL,
  `NamaDesa` char(25) NOT NULL,
  `Warna` varchar(25) NOT NULL,
  `CenterLat` varchar(25) NOT NULL,
  `CenterLong` varchar(25) NOT NULL,
  `JumlahPenduduk` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `desa`
--

INSERT INTO `desa` (`IdDesa`, `NamaDesa`, `Warna`, `CenterLat`, `CenterLong`, `JumlahPenduduk`) VALUES
(1, 'Kurau', 'Biru', '100', '100', 100),
(2, 'Handil', 'Kuning', '45644', '56446', 10),
(10, 'Handil Birayang', 'Hijau', '100000', '200000', 50);

-- --------------------------------------------------------

--
-- Table structure for table `jentik`
--

CREATE TABLE `jentik` (
  `IdJentik` int NOT NULL,
  `IdDesa` int NOT NULL,
  `rd` varchar(20) NOT NULL,
  `rj` varchar(20) NOT NULL,
  `Tahun` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `jentik`
--

INSERT INTO `jentik` (`IdJentik`, `IdDesa`, `rd`, `rj`, `Tahun`) VALUES
(1, 1, 'ada', 'Tidak ada', 4000),
(2, 2, 'Tidak ada', 'Tidak ada', 4000);

-- --------------------------------------------------------

--
-- Table structure for table `map`
--

CREATE TABLE `map` (
  `IdMap` int NOT NULL,
  `IdDesa` int NOT NULL,
  `NoPoligon` int NOT NULL,
  `LatMap` int NOT NULL,
  `LongMap` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `map`
--

INSERT INTO `map` (`IdMap`, `IdDesa`, `NoPoligon`, `LatMap`, `LongMap`) VALUES
(1, 1, 20000, 10000, 1000),
(2, 2, 20000, 10000, 1000);

-- --------------------------------------------------------

--
-- Table structure for table `penderita`
--

CREATE TABLE `penderita` (
  `IdPenderita` int NOT NULL,
  `NamaPenderita` char(25) NOT NULL,
  `Alamat` varchar(50) NOT NULL,
  `IdDesa` int NOT NULL,
  `JenisKelamin` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Umur` int NOT NULL,
  `Tahun` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `penderita`
--

INSERT INTO `penderita` (`IdPenderita`, `NamaPenderita`, `Alamat`, `IdDesa`, `JenisKelamin`, `Umur`, `Tahun`) VALUES
(1, 'joshua', 'banjarmasin', 3, 'laki-laki', 30, 2020),
(2, 'Dayat', 'Kurau', 9, 'Laki-laki', 90, 2009);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `desa`
--
ALTER TABLE `desa`
  ADD PRIMARY KEY (`IdDesa`);

--
-- Indexes for table `jentik`
--
ALTER TABLE `jentik`
  ADD PRIMARY KEY (`IdJentik`);

--
-- Indexes for table `map`
--
ALTER TABLE `map`
  ADD PRIMARY KEY (`IdMap`);

--
-- Indexes for table `penderita`
--
ALTER TABLE `penderita`
  ADD PRIMARY KEY (`IdPenderita`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
