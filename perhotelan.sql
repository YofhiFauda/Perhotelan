-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 24, 2022 at 01:37 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `perhotelan`
--

-- --------------------------------------------------------

--
-- Table structure for table `penyewa`
--

CREATE TABLE `penyewa` (
  `id` int(11) NOT NULL,
  `nama` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `alamat` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ktp` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `noHp` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `kamar` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `penyewa`
--

INSERT INTO `penyewa` (`id`, `nama`, `alamat`, `ktp`, `noHp`, `kamar`) VALUES
(1, 'Yopie', 'Solo', '21533425', '0895706313090', 'Single'),
(2, 'Bapakmu', 'NTT', '21533425123', '08935666342', 'Single'),
(3, 'Joko', 'Plosok', '51244426980', '085215532552', 'Double'),
(4, 'Bambang', 'Surabaya', '517223855321', '0895706313090', 'Double'),
(5, 'Waluyo', 'Pijeran', '2155532555', '08946464212', 'Suite'),
(6, 'Tijo', 'Pulunh', '21555213', '2112412312', 'Single'),
(7, 'Sanusi', 'Jember', '214555224', '7899076345', 'Suite'),
(8, 'Sriti', 'Uruguay', '52133125', '080908989312', 'Single'),
(9, 'Wahyuni', 'Kepepet', '51723440902', '085225526612', 'Double');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id` int(11) NOT NULL,
  `nama` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `alamat` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ktp` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `noHp` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `kamar` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `sewa` int(11) NOT NULL,
  `totalPembayaran` int(11) NOT NULL,
  `bayar` int(11) NOT NULL,
  `kembalian` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`id`, `nama`, `alamat`, `ktp`, `noHp`, `kamar`, `sewa`, `totalPembayaran`, `bayar`, `kembalian`) VALUES
(1, 'Bambang', 'Surabaya', '517223855321', '0895706313090', 'Double', 10, 2250000, 250000, -2000000),
(2, 'Waluyo', 'Pijeran', '2155532555', '08946464212', 'Suite', 5, 1500000, 2000000, 500000),
(3, 'Tijo', 'Pulunh', '21555213', '2112412312', 'Single', 20, 3500000, 4000000, 500000),
(4, 'Sanusi', 'Jember', '214555224', '7899076345', 'Suite', 3, 900000, 1000000, 100000),
(5, 'Sriti', 'Uruguay', '52133125', '080908989312', 'Single', 6, 1050000, 2000000, 950000),
(6, 'Wahyuni', 'Kepepet', '51723440902', '085225526612', 'Double', 15, 3375000, 3500000, 125000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `penyewa`
--
ALTER TABLE `penyewa`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `penyewa`
--
ALTER TABLE `penyewa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
