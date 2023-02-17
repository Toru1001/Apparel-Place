-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 17, 2023 at 10:19 AM
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
-- Table structure for table `footwearproducts`
--

CREATE TABLE `footwearproducts` (
  `Id` int(11) NOT NULL,
  `product` varchar(250) NOT NULL,
  `description` varchar(250) NOT NULL,
  `price` int(11) NOT NULL,
  `brand` varchar(250) NOT NULL,
  `icon` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `footwearproducts`
--

INSERT INTO `footwearproducts` (`Id`, `product`, `description`, `price`, `brand`, `icon`) VALUES
(1, 'Loafers', 'O\'Lock Loafers ', 3500, 'Fendi', '/com/apparel/items/footwear/Fendi O\'Lock Loafers.png'),
(2, 'Leather Shoes', 'Lace Up Shoes', 3250, 'Gucci', '/com/apparel/items/footwear/Gucci  Lace Up Shoes.png'),
(3, 'Loafers', 'Men\'s Interlocking G Loafers', 3500, 'Gucci', '/com/apparel/items/footwear/Gucci  Men\'s Interlocking G Loafers.png'),
(4, 'Formal Shoes', 'MV 22146A Black Men Formal Shoes ', 1750, 'Mario D boro', '/com/apparel/items/footwear/Mario D boro  MV 22146A Black Men Formal Shoes.png'),
(5, 'Platform Sandals', 'Quilted Nappa Platform Sandals', 2500, 'Prada', '/com/apparel/items/footwear/Prada  Quilted nappa leather platform sandals.png'),
(6, 'Sneakers', ' Rivalry Low 86 Shoes', 2900, 'Adidas', '/com/apparel/items/footwear/Adidas  Rivalry Low 86 Shoes.png'),
(7, 'Elevate Sneakers', ' Air Jordan 1 Elevate High', 2950, 'Nike', '/com/apparel/items/footwear/Nike  Air Jordan 1 Elevate High.png'),
(8, 'High Top ', 'Chuck 70 AT-CX ', 3500, 'Converse', '/com/apparel/items/footwear/Converse Chuck 70 AT-CX Earth Tones.png'),
(9, 'Sneakers', 'Air Force 1 Shadow ', 3000, 'Nike', '/com/apparel/items/footwear/Nike  Air Force 1 Shadow.png'),
(10, 'Sneakers', 'Club C 85 Shoes', 2750, 'Reebok', '/com/apparel/items/footwear/Reebok x DC Club C 85 Shoes.png'),
(11, 'Running Shoes', 'Supernova 2.0 Shoes - Running Shoes ', 2500, 'Adidas', '/com/apparel/items/footwear/Adidas  Supernova 2.0 Shoes - Running Shoes.png'),
(12, 'Training Shoes', 'Trainer V Shoes', 2550, 'Adidas', '/com/apparel/items/footwear/Adidas  Trainer V Shoes.png'),
(13, 'Training Shoes', 'Faster Trainers', 3000, 'Fendi', '/com/apparel/items/footwear/Fendi Faster Trainers.png'),
(14, 'Training Shoes', 'Free Metcon 4', 2750, 'Nike', '/com/apparel/items/footwear/Nike  Free Metcon 4.png'),
(15, 'Training Shoes', 'Pegasus 39 Premium ', 2800, 'Nike', '/com/apparel/items/footwear/Nike  Pegasus 39 Premium.png');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `footwearproducts`
--
ALTER TABLE `footwearproducts`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `footwearproducts`
--
ALTER TABLE `footwearproducts`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
