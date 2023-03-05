-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 05, 2023 at 06:20 AM
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
('testing', 'Testimony', 'tests', 'S,  ,  ', '1, 1, 1', 'Sunglasses', 'Nike x Cactus Sweater 1x Size: S, Uniqlo Daily Bag 1x Size:  , Gentle Monster Sunglasses 1x Size:  ', 400, 'PHP 2,100 .00', 'Gentle Monster', '/com/apparel/items/accessories/Gentle Monster  Rococo 01.png', '03/05/2023 10:42:32', '03/12/2023', 'test', 'testing', '09982066248', 'Cash On Delivery', 'Recieved'),
('testing', 'Testimony', 'tests', 'S, M', '1, 1', 'Jacket', 'Urban Outfitters Hoodies 1x Size: S, Nike x Stussy Jacket 1x Size: M', 900, 'PHP 1,450 .00', 'Nike x Stussy', '/com/apparel/items/shirt/Nike x Stussy Windrunner Jacket.png', '03/05/2023 10:59:39', '03/12/2023', 'test', 'testing', '09982066248', 'Cash On Delivery', 'To Recieve'),
('testing', 'Testimony', 'tests', ' ', '1', 'Daily Bag', 'Celine Daily Bag 1x Size:  ', 475, 'PHP 575 .00', 'Celine', '/com/apparel/items/bagProducts/Celine Smooth Calfskin Backpack - Black.png', '03/05/2023 10:59:54', '03/12/2023', 'test', 'testing', '09982066248', 'Cash On Delivery', 'To Ship'),
('jmirafuentes47@gmail.com', 'Jonniel', 'Mirafuentes', 'M, L, XL', '1, 1, 1', 'Cargo Trousers', '99 Percentis Hoodies 1x Size: M, Nike Hoodies 1x Size: L, H%M Cargo Trousers 1x Size: XL', 850, 'PHP 2,850 .00', 'H%M', '/com/apparel/items/shirt/H_M Wide cargo trousers.png', '03/05/2023 11:03:02', '03/12/2023', 'jonniel123', 'Purok 9, Lower Lacson, Calinan Davao City', '09982066249', 'Cash On Delivery', 'Recieved'),
('jmirafuentes47@gmail.com', 'Jonniel', 'Mirafuentes', 'S,  , 36', '1, 1, 2', 'Leather Shoes', 'Nike x Stussy Jacket 1x Size: S, Playboy Bunny Daily Bag 1x Size:  , Gucci Leather Shoes 2x Size: 36', 3250, 'PHP 8,100 .00', 'Gucci', '/com/apparel/items/footwear/Gucci  Lace Up Shoes.png', '03/05/2023 11:24:59', '03/12/2023', 'jonniel123', 'Purok 9, Lower Lacson, Calinan Davao City', '09982066249', 'Cash On Delivery', 'Recieved');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
