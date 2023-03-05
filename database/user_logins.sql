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
-- Table structure for table `user_logins`
--

CREATE TABLE `user_logins` (
  `user_id` int(11) NOT NULL,
  `first_name` varchar(65) NOT NULL,
  `last_name` varchar(65) NOT NULL,
  `username` varchar(65) NOT NULL,
  `email` varchar(65) NOT NULL,
  `mobile_number` varchar(13) NOT NULL,
  `password` varchar(65) NOT NULL,
  `local_address` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user_logins`
--

INSERT INTO `user_logins` (`user_id`, `first_name`, `last_name`, `username`, `email`, `mobile_number`, `password`, `local_address`) VALUES
(1, 'Jonniel', 'Mirafuentes', 'jonniel123', 'jmirafuentes47@gmail.com', '09982066249', 'jonniel123', 'Purok 9, Lower Lacson, Calinan Davao City'),
(4, 'Testimony', 'tests', 'test', 'testing', '09982066248', 'test123', 'testing'),
(5, 'Anna May', 'Bote', 'anna05', 'a.bote.56784@umindanao.edu.ph', '09125353674', 'anna123', 'Quirino Street, Davao City'),
(6, 'Jessa', 'Mae', 'jm123', '', '09982066249', 'test123', ''),
(7, 'Admin', 'Administrator', 'admin', 'apparel.items@gmail.com', '09982066249', 'admin123', '3H8W+7HQ, New, Matina Pangi Rd, Davao City, Davao del Sur');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user_logins`
--
ALTER TABLE `user_logins`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user_logins`
--
ALTER TABLE `user_logins`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
