-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 04, 2023 at 07:54 PM
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
-- Table structure for table `toshipitems`
--

CREATE TABLE `toshipitems` (
  `email` varchar(250) NOT NULL,
  `firstname` varchar(250) NOT NULL,
  `lastname` varchar(250) NOT NULL,
  `size` varchar(250) NOT NULL,
  `quantity` varchar(250) NOT NULL,
  `product` varchar(250) NOT NULL,
  `description` varchar(250) NOT NULL,
  `price` int(11) NOT NULL,
  `totalPrice` varchar(250) NOT NULL,
  `brand` varchar(250) NOT NULL,
  `icon` varchar(250) NOT NULL,
  `timeOrder` varchar(250) NOT NULL,
  `estRecieveDate` varchar(250) NOT NULL,
  `username` varchar(250) NOT NULL,
  `address` varchar(250) NOT NULL,
  `mobileNumber` varchar(250) NOT NULL,
  `paymentMethod` varchar(250) NOT NULL,
  `status` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `toshipitems`
--

INSERT INTO `toshipitems` (`email`, `firstname`, `lastname`, `size`, `quantity`, `product`, `description`, `price`, `totalPrice`, `brand`, `icon`, `timeOrder`, `estRecieveDate`, `username`, `address`, `mobileNumber`, `paymentMethod`, `status`) VALUES
('jmirafuentes47@gmail.com', 'Jonniel', 'Mirafuentes', 'M', '1', 'Sweater', 'Plant Flea Market L/S', 850, 'PHP 1,700 .00', 'Nike x Cactus', '/com/apparel/items/shirt/Nike x Cactus Plant Flea Market  T-shirt.jpeg', '03/04/2023', '03/11/2023', 'jonniel123', 'Purok 9, Lower Lacson, Calinan Davao City', '09982066249', 'Cash On Delivery', 'Recieved'),
('jmirafuentes47@gmail.com', 'Jonniel', 'Mirafuentes', 'XL', '1', 'Cargo Pants', 'Cotton Linen Cargo Pants', 750, 'PHP 1,700 .00', 'Louis Vuitton', '/com/apparel/items/shirt/LV Cotton Linen Cargo Pants.png', '03/04/2023', '03/11/2023', 'jonniel123', 'Purok 9, Lower Lacson, Calinan Davao City', '09982066249', 'Cash On Delivery', 'Recieved'),
('jmirafuentes47@gmail.com', 'Jonniel', 'Mirafuentes', 'S', '1', 'Jacket', 'Windrunner Jacket', 900, 'PHP 1,000 .00', 'Nike x Stussy', '/com/apparel/items/shirt/Nike x Stussy Windrunner Jacket.png', '03/04/2023', '03/11/2023', 'jonniel123', 'Purok 9, Lower Lacson, Calinan Davao City', '09982066249', 'Cash On Delivery', 'Recieved');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
