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
-- Table structure for table `all_items`
--

CREATE TABLE `all_items` (
  `product` varchar(250) NOT NULL,
  `description` varchar(250) NOT NULL,
  `price` int(11) NOT NULL,
  `brand` varchar(250) NOT NULL,
  `icon` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `all_items`
--

INSERT INTO `all_items` (`product`, `description`, `price`, `brand`, `icon`) VALUES
('Hoodies', 'Poison Apple Hood', 950, '99 Percentis', '/com/apparel/items/shirt/99.jpg'),
('Sweater', 'Plant Flea Market L/S', 850, 'Nike x Cactus', '/com/apparel/items/shirt/Nike x Cactus Plant Flea Market  T-shirt.jpeg'),
('Jacket', 'Windrunner Jacket', 900, 'Nike x Stussy', '/com/apparel/items/shirt/Nike x Stussy Windrunner Jacket.png'),
('Hoodies', 'Ron Bass UO Crew Neck Sweatshirt', 450, 'Urban Outfitters', '/com/apparel/items/shirt/Ron Bass UO Exclusive Love Icon Crew Neck Sweatshirt.png'),
('Cargo Pants', 'Cotton Linen Cargo Pants', 750, 'Louis Vuitton', '/com/apparel/items/shirt/LV Cotton Linen Cargo Pants.png'),
('Dart Pants', 'Mini Dot Dart Pants', 650, 'Louis Vuitton', '/com/apparel/items/shirt/LV Mini Dot Dart Pants.png'),
('Cargo Trousers', 'H&M Wide cargo trousers', 850, 'H%M', '/com/apparel/items/shirt/H_M Wide cargo trousers.png'),
('Trousers', 'Double Pleated Trouser', 750, 'Reese Cooper', '/com/apparel/items/shirt/Reese Cooper  Double Pleated Trouser.png'),
('Mini Skirt', 'Washed Denim Strap Mini Skirt', 550, 'Louis Vuitton', '/com/apparel/items/shirt/LV WASHED DENIM STRAP DETAIL MINI WRAP SKIRT.png'),
('T-Shirt', 'Monogram Jet Ski Self-Tie T-Shirt', 250, 'Louis Vuitton', '/com/apparel/items/shirt/LV Monogram Jet Ski Self-Tie T-Shirt.png'),
('Denim Shirt', 'Short-Sleeved Denim Shirt', 350, 'Louis Vuitton', '/com/apparel/items/shirt/LV SHORT-SLEEVED DENIM SHIRT.png'),
('Basketball T-Shirt', 'Max90 Basketball Shirt', 350, 'Nike', '/com/apparel/items/shirt/Nike Max90 Basketball T-Shirt.png'),
('Loafers', 'O\'Lock Loafers ', 3500, 'Fendi', '/com/apparel/items/footwear/Fendi O_Lock Loafers.png'),
('Leather Shoes', 'Lace Up Shoes', 3250, 'Gucci', '/com/apparel/items/footwear/Gucci  Lace Up Shoes.png'),
('Loafers', 'Men\'s Interlocking G Loafers', 3500, 'Gucci', '/com/apparel/items/footwear/Gucci  Men_s Interlocking G Loafers.png'),
('Formal Shoes', 'MV 22146A Black Men Formal Shoes ', 1750, 'Mario D boro', '/com/apparel/items/footwear/Mario D boro  MV 22146A Black Men Formal Shoes.png'),
('Platform Sandals', 'Quilted Nappa Platform Sandals', 2500, 'Prada', '/com/apparel/items/footwear/Prada  Quilted nappa leather platform sandals.png'),
('Sneakers', ' Rivalry Low 86 Shoes', 2900, 'Adidas', '/com/apparel/items/footwear/Adidas  Rivalry Low 86 Shoes.png'),
('Elevate Sneakers', ' Air Jordan 1 Elevate High', 2950, 'Nike', '/com/apparel/items/footwear/Nike  Air Jordan 1 Elevate High.png'),
('High Top ', 'Chuck 70 AT-CX ', 3500, 'Converse', '/com/apparel/items/footwear/Converse Chuck 70 AT-CX Earth Tones.png'),
('Sneakers', 'Air Force 1 Shadow ', 3000, 'Nike', '/com/apparel/items/footwear/Nike  Air Force 1 Shadow.png'),
('Sneakers', 'Club C 85 Shoes', 2750, 'Reebok', '/com/apparel/items/footwear/Reebok x DC Club C 85 Shoes.png'),
('Running Shoes', 'Supernova 2.0 Shoes - Running Shoes ', 2500, 'Adidas', '/com/apparel/items/footwear/Adidas  Supernova 2.0 Shoes - Running Shoes.png'),
('Training Shoes', 'Trainer V Shoes', 2550, 'Adidas', '/com/apparel/items/footwear/Adidas  Trainer V Shoes.png'),
('Training Shoes', 'Faster Trainers', 3000, 'Fendi', '/com/apparel/items/footwear/Fendi Faster Trainers.png'),
('Training Shoes', 'Free Metcon 4', 2750, 'Nike', '/com/apparel/items/footwear/Nike  Free Metcon 4.png'),
('Training Shoes', 'Pegasus 39 Premium ', 2800, 'Nike', '/com/apparel/items/footwear/Nike  Pegasus 39 Premium.png'),
('Daily Bag', 'Smooth Calfskin Backpack - Black', 475, 'Celine', '/com/apparel/items/bagProducts/Celine Smooth Calfskin Backpack - Black.png'),
('Daily Bag', 'Dual Pocket Tote', 300, 'New Balance', '/com/apparel/items/bagProducts/New Balance  Dual Pocket Tote.png'),
('Daily Bag', 'Sling Bag/Crossbody Bag', 600, 'Playboy Bunny', '/com/apparel/items/bagProducts/Playboy Bunny (Sling Bag).jpg'),
('Daily Bag', 'Roll Top Backpack', 750, 'Uniqlo', '/com/apparel/items/bagProducts/Uniqlo  Roll Top Backpack.png'),
('Daily Bag', 'Yusuke Hanai Bag', 250, 'Uniqlo', '/com/apparel/items/bagProducts/Yusuke Hanai Bag.png'),
('Sports Bag', 'Gym Sack by Stella McCartney ', 450, 'Adidas', '/com/apparel/items/bagProducts/Adidas by Stella McCartney  Gym Sack.png'),
('Sports Bag ', 'Brasilia Printed Duffel Bag', 650, 'Nike', '/com/apparel/items/bagProducts/Nike Brasilia  Printed Duffel Bag.png'),
('Sports Bag', 'Heritage Retro Duffel Bag', 600, 'Nike', '/com/apparel/items/bagProducts/Nike Heritage Retro Duffel Bag.png'),
('Sports Bag', 'Utility Power Training Duffel Bag', 700, 'Nike', '/com/apparel/items/bagProducts/Nike Utility Power  Training Duffel Bag.png'),
('Travel Bag', 'TOIIS L Spinner 55/20 EXP ', 5550, 'Samsonite', '/com/apparel/items/bagProducts/Samsonite TOIIS L Spinner 55 20 EXP.jpg'),
('Travel Bag', 'Cross FR Spinner 55/20 FR', 5250, 'Samsonite', '/com/apparel/items/bagProducts/Samsonite Cross FR Spinner 55 20 FR.jpg'),
('Travel Bag', 'Sigma Cabin 20 Milky', 3200, 'The 815', '/com/apparel/items/bagProducts/The 815 Sigma Cabin 20 Milky.png'),
('Travel Bag', 'Multifunction Travel Bag', 3000, 'Zara', '/com/apparel/items/bagProducts/Zara BANGE 7088 Oxford Multifunction Shoulder Backpack Travel Bag.jpg'),
('Sunglasses', 'Rococo 01', 400, 'Gentle Monster', '/com/apparel/items/accessories/Gentle Monster  Rococo 01.png'),
('Beanie ', 'Rib-knit Cotton Beanie', 250, 'H&M', '/com/apparel/items/accessories/H_M  Rib-knit Cotton Beanie.png'),
('Eyeglasses', 'Round Frame Metal Sunglasses', 350, 'Uniqlo', '/com/apparel/items/accessories/Uniqlo  Round Frame Metal Sunglasses.png'),
('Hat', 'UV Protection Hat', 300, 'Uniqlo', '/com/apparel/items/accessories/Uniqlo UV Protection Hat.png'),
('Earrings', 'Resin Flower Earrings', 250, 'Zara', '/com/apparel/items/accessories/Zara RESIN FLOWER EARRINGS.jpg'),
('Loafers', 'O Lock Loafers ', 3500, 'Fendi', '/com/apparel/items/footwear/Fendi O_Lock Loafers.png'),
('Loafers', 'Mens Interlocking G Loafers', 3500, 'Gucci', '/com/apparel/items/footwear/Gucci  Men_s Interlocking G Loafers.png'),
('Hoodies', 'Womens French Circa 96', 950, 'Nike', '/com/apparel/items/shirt/Nike Sportswear Circa 96 Women_s French Terry Hoodies.png');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
