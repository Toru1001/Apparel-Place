-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 17, 2023 at 01:33 PM
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
-- Table structure for table `clothesproduct`
--

CREATE TABLE `clothesproduct` (
  `Id` int(11) NOT NULL,
  `product` varchar(250) NOT NULL,
  `description` varchar(250) NOT NULL,
  `price` int(11) NOT NULL,
  `brand` varchar(250) NOT NULL,
  `icon` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `clothesproduct`
--

INSERT INTO `clothesproduct` (`Id`, `product`, `description`, `price`, `brand`, `icon`) VALUES
(1, 'Hoodies', 'Poison Apple Hood', 950, '99 Percentis', '/com/apparel/items/shirt/99 Percentis Poison Apple Hood'),
(2, 'Sweater', 'Plant Flea Market L/S', 850, 'Nike x Cactus', '/com/apparel/items/shirt/Nike x Cactus Plant Flea Market  T-shirt.jpeg'),
(3, 'Jacket', 'Windrunner Jacket', 900, 'Nike x Stussy', '/com/apparel/items/shirt/Nike x Stussy Windrunner Jacket.png'),
(4, 'Hoodies', 'Women\'s French Circa 96', 950, 'Nike', '/com/apparel/items/shirt/Nike Sportswear Circa 96 Women\'s French Terry Hoodies.png'),
(5, 'Hoodies', 'Ron Bass UO Crew Neck Sweatshirt', 450, 'Urban Outfitters', '/com/apparel/items/shirt/Ron Bass UO Exclusive Love Icon Crew Neck Sweatshirt.png'),
(6, 'Cargo Pants', 'Cotton Linen Cargo Pants', 750, 'Louis Vuitton', '/com/apparel/items/shirt/LV Cotton Linen Cargo Pants.png'),
(7, 'Dart Pants', 'Mini Dot Dart Pants', 650, 'Louis Vuitton', '/com/apparel/items/shirt/LV Mini Dot Dart Pants.png'),
(8, 'Cargo Trousers', 'H&M Wide cargo trousers', 850, 'H%M', '/com/apparel/items/shirt/H&M Wide cargo trousers.png'),
(9, 'Trousers', 'Double Pleated Trouser', 750, 'Reese Cooper', '/com/apparel/items/shirt/Reese Cooper  Double Pleated Trouser.png'),
(10, 'Mini Skirt', 'Washed Denim Strap Mini Skirt', 550, 'Louis Vuitton', '/com/apparel/items/shirt/LV WASHED DENIM STRAP DETAIL MINI WRAP SKIRT.png'),
(11, 'T-Shirt', 'Monogram Jet Ski Self-Tie T-Shirt', 250, 'Louis Vuitton', 'LV Monogram Jet Ski Self-Tie T-Shirt.png'),
(12, 'Denim Shirt', 'Short-Sleeved Denim Shirt', 350, 'Louis Vuitton', '/com/apparel/items/shirt/LV SHORT-SLEEVED DENIM SHIRT.png'),
(13, 'Polo Shirt', '22SS Rimming Baseball Shirt', 400, 'Sasquatchfabrix', 'Sasquatchfabrix.22SS RIMMING BASEBALL  SHIRT.jpeg'),
(14, 'Basketball T-Shirt', 'Max90 Basketball Shirt', 350, 'Nike', '/com/apparel/items/shirt/Nike Max90 Basketball T-Shirt.jpg'),
(15, 'Dri-FIT Shirt', 'Yoga Dri-FIT Luxe', 300, 'Nike', '/com/apparel/items/shirt/Nike Sportswear Circa 96 Women\'s French Terry Hoodies.png');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `clothesproduct`
--
ALTER TABLE `clothesproduct`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `clothesproduct`
--
ALTER TABLE `clothesproduct`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
