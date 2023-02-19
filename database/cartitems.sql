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
-- Table structure for table `cartitems`
--

CREATE TABLE `cartitems` (
  `size` varchar(250) NOT NULL,
  `quantity` varchar(250) NOT NULL,
  `product` varchar(250) NOT NULL,
  `description` varchar(250) NOT NULL,
  `price` int(11) NOT NULL,
  `brand` varchar(250) NOT NULL,
  `icon` varchar(250) NOT NULL,
  `userEmail` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `cartitems`
--

INSERT INTO `cartitems` (`size`, `quantity`, `product`, `description`, `price`, `brand`, `icon`, `userEmail`) VALUES
('--', '1', 'Earrings', 'Resin Flower Earrings', 250, 'Zara', '/com/apparel/items/accessories/Zara RESIN FLOWER EARRINGS.jpg', 'jmirafuentes47@gmail.com'),
('S', '1', 'Jacket', 'Windrunner Jacket', 900, 'Nike x Stussy', '/com/apparel/items/shirt/Nike x Stussy Windrunner Jacket.png', 'jmirafuentes47@gmail.com'),
('--', '2', 'Eyeglasses', 'Round Frame Metal Sunglasses', 350, 'Uniqlo', '/com/apparel/items/accessories/Uniqlo  Round Frame Metal Sunglasses.png', 'jmirafuentes47@gmail.com'),
('XS', '1', 'Hoodies', 'Womens French Circa 96', 950, 'Nike', '/com/apparel/items/shirt/Nike Sportswear Circa 96 Women_s French Terry Hoodies.png', 'jmirafuentes47@gmail.com'),
(' ', '1', 'Daily Bag', 'Dual Pocket Tote', 300, 'New Balance', '/com/apparel/items/bagProducts/New Balance  Dual Pocket Tote.png', 'testing'),
('42', '3', 'Elevate Sneakers', ' Air Jordan 1 Elevate High', 2950, 'Nike', '/com/apparel/items/footwear/Nike  Air Jordan 1 Elevate High.png', 'testing');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
