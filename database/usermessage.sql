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
-- Table structure for table `usermessage`
--

CREATE TABLE `usermessage` (
  `fullName` varchar(250) NOT NULL,
  `email` varchar(250) NOT NULL,
  `mobileNumber` varchar(250) NOT NULL,
  `subject` varchar(250) NOT NULL,
  `message` varchar(250) NOT NULL,
  `status` varchar(250) NOT NULL,
  `messageDate` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `usermessage`
--

INSERT INTO `usermessage` (`fullName`, `email`, `mobileNumber`, `subject`, `message`, `status`, `messageDate`) VALUES
('Testimony tests', 'testing', '09982066248', 'tabaaaang', 'kamataaaaaaay', 'Acknowledged', '03/05/2023 02:39'),
('Jonniel Mirafuentes', 'jmirafuentes47@gmail.com', '09982066249', 'hagoooooo kaayuuuuuuuuu', 'haaaaaaaalp', 'Acknowledged', '03/05/2023 02:39');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
