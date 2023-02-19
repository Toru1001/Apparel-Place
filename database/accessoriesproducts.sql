-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 19, 2023 at 07:40 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `apparel_accounts`
--

-- --------------------------------------------------------

--
-- Table structure for table `accessoriesproducts`
--

CREATE TABLE `accessoriesproducts` (
  `Id` int(11) NOT NULL,
  `product` varchar(250) NOT NULL,
  `description` varchar(250) NOT NULL,
  `price` int(11) NOT NULL,
  `brand` varchar(250) NOT NULL,
  `icon` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `accessoriesproducts`
--

INSERT INTO `accessoriesproducts` (`Id`, `product`, `description`, `price`, `brand`, `icon`) VALUES
(1, 'Sunglasses', 'Rococo 01', 400, 'Gentle Monster', '/com/apparel/items/accessories/Gentle Monster  Rococo 01.png'),
(2, 'Beanie ', 'Rib-knit Cotton Beanie', 250, 'H&M', '/com/apparel/items/accessories/H_M  Rib-knit Cotton Beanie.png'),
(3, 'Eyeglasses', 'Round Frame Metal Sunglasses', 350, 'Uniqlo', '/com/apparel/items/accessories/Uniqlo  Round Frame Metal Sunglasses.png'),
(4, 'Hat', 'UV Protection Hat', 300, 'Uniqlo', '/com/apparel/items/accessories/Uniqlo UV Protection Hat.png'),
(5, 'Earrings', 'Resin Flower Earrings', 250, 'Zara', '/com/apparel/items/accessories/Zara RESIN FLOWER EARRINGS.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accessoriesproducts`
--
ALTER TABLE `accessoriesproducts`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `accessoriesproducts`
--
ALTER TABLE `accessoriesproducts`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
