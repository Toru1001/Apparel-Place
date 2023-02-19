-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 19, 2023 at 07:41 AM
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
-- Table structure for table `bagproducts`
--

CREATE TABLE `bagproducts` (
  `Id` int(11) NOT NULL,
  `product` varchar(250) NOT NULL,
  `description` varchar(250) NOT NULL,
  `price` int(11) NOT NULL,
  `brand` varchar(250) NOT NULL,
  `icon` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `bagproducts`
--

INSERT INTO `bagproducts` (`Id`, `product`, `description`, `price`, `brand`, `icon`) VALUES
(1, 'Daily Bag', 'Smooth Calfskin Backpack - Black', 475, 'Celine', '/com/apparel/items/bagProducts/Celine Smooth Calfskin Backpack - Black.png'),
(2, 'Daily Bag', 'Dual Pocket Tote', 300, 'New Balance', '/com/apparel/items/bagProducts/New Balance  Dual Pocket Tote.png'),
(3, 'Daily Bag', 'Sling Bag/Crossbody Bag', 600, 'Playboy Bunny', '/com/apparel/items/bagProducts/Playboy Bunny (Sling Bag).jpg'),
(4, 'Daily Bag', 'Roll Top Backpack', 750, 'Uniqlo', '/com/apparel/items/bagProducts/Uniqlo  Roll Top Backpack.png'),
(5, 'Daily Bag', 'Yusuke Hanai Bag', 250, 'Uniqlo', '/com/apparel/items/bagProducts/Yusuke Hanai Bag.png'),
(6, 'Sports Bag', 'Gym Sack by Stella McCartney ', 450, 'Adidas', '/com/apparel/items/bagProducts/Adidas by Stella McCartney  Gym Sack.png'),
(7, 'Sports Bag ', 'Brasilia Printed Duffel Bag', 650, 'Nike', '/com/apparel/items/bagProducts/Nike Brasilia  Printed Duffel Bag.png'),
(8, 'Sports Bag', 'Heritage Retro Duffel Bag', 600, 'Nike', '/com/apparel/items/bagProducts/Nike Heritage Retro Duffel Bag.png'),
(9, 'Sports Bag', 'Utility Power Training Duffel Bag', 700, 'Nike', '/com/apparel/items/bagProducts/Nike Utility Power  Training Duffel Bag.png'),
(12, 'Travel Bag', 'TOIIS L Spinner 55/20 EXP ', 5550, 'Samsonite', '/com/apparel/items/bagProducts/Samsonite TOIIS L Spinner 55 20 EXP.jpg'),
(13, 'Travel Bag', 'Cross FR Spinner 55/20 FR', 5250, 'Samsonite', '/com/apparel/items/bagProducts/Samsonite Cross FR Spinner 55 20 FR.jpg'),
(14, 'Travel Bag', 'Sigma Cabin 20 Milky', 3200, 'The 815', '/com/apparel/items/bagProducts/The 815 Sigma Cabin 20 Milky.png'),
(15, 'Travel Bag', 'Multifunction Travel Bag', 3000, 'Zara', '/com/apparel/items/bagProducts/Zara BANGE 7088 Oxford Multifunction Shoulder Backpack Travel Bag.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bagproducts`
--
ALTER TABLE `bagproducts`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bagproducts`
--
ALTER TABLE `bagproducts`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
