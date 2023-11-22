-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 27, 2023 at 07:38 PM
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
-- Database: `company_database`
--

-- --------------------------------------------------------

--
-- Table structure for table `client_table`
--

CREATE TABLE `client_table` (
  `CLIENT_ID` int(11) NOT NULL,
  `CLIENT_NAME` varchar(255) NOT NULL,
  `CLIENT_ADDRESS` varchar(255) NOT NULL,
  `CLIENT_MOBILE` varchar(255) NOT NULL,
  `CLIENT_EMAIL` varchar(255) NOT NULL,
  `CLIENT_STATUS` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `client_table`
--

INSERT INTO `client_table` (`CLIENT_ID`, `CLIENT_NAME`, `CLIENT_ADDRESS`, `CLIENT_MOBILE`, `CLIENT_EMAIL`, `CLIENT_STATUS`) VALUES
(1, 'User', 'User Address', '0714578485', 'user@gmail.com', 'disable'),
(2, 'Janaka', 'Matale', '0745748965', 'janaka@gmail.com', 'Available'),
(3, 'Sampath', 'Kaluthara', '0715474856', 'sampath@gmail.com', 'Available');

-- --------------------------------------------------------

--
-- Table structure for table `orders_table`
--

CREATE TABLE `orders_table` (
  `ORDER_ID` int(25) NOT NULL,
  `BILL_NUMBER` varchar(255) NOT NULL,
  `BILLED_DATE` varchar(255) NOT NULL,
  `CLIENT_ID` int(11) NOT NULL,
  `PRODUCT_ID` int(11) NOT NULL,
  `ORDER_QUANTITY` int(25) NOT NULL,
  `TOTAL_AMOUNT` int(25) NOT NULL,
  `PAYMENT_METHOD` varchar(255) NOT NULL,
  `PAYMENT_STATUS` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orders_table`
--

INSERT INTO `orders_table` (`ORDER_ID`, `BILL_NUMBER`, `BILLED_DATE`, `CLIENT_ID`, `PRODUCT_ID`, `ORDER_QUANTITY`, `TOTAL_AMOUNT`, `PAYMENT_METHOD`, `PAYMENT_STATUS`) VALUES
(1, 'CF-001', '2023-03-25', 1, 1, 100, 50000, 'Cash', 'Payment Received'),
(2, 'CF-002', '2023-03-27', 2, 3, 200, 200000, 'Credit', 'Payment Pending');

-- --------------------------------------------------------

--
-- Table structure for table `product_table`
--

CREATE TABLE `product_table` (
  `PRODUCT_ID` int(11) NOT NULL,
  `PRODUCT_CODE` varchar(255) NOT NULL,
  `PRODUCT_NAME` varchar(255) NOT NULL,
  `PRODUCT_SIZE` varchar(255) NOT NULL,
  `PRODUCT_PRICE` int(25) NOT NULL,
  `PRODUCT_STATUS` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `product_table`
--

INSERT INTO `product_table` (`PRODUCT_ID`, `PRODUCT_CODE`, `PRODUCT_NAME`, `PRODUCT_SIZE`, `PRODUCT_PRICE`, `PRODUCT_STATUS`) VALUES
(1, 'VTT-101', 'Coco Choice', '5 KG', 500, 'Available'),
(2, 'VTT-201', 'Coco Blend', '5 KG', 750, 'Available'),
(3, 'VTT-301', 'Coco Promix', '5 KG', 1000, 'Available'),
(4, 'VTT-401', 'Coco Gold', '5 KG', 1250, 'Available'),
(5, 'VTT-501', 'Coco Crush Gold', '5 KG', 1500, 'Available');

-- --------------------------------------------------------

--
-- Table structure for table `user_table`
--

CREATE TABLE `user_table` (
  `USER_ID` int(11) NOT NULL,
  `USER_NAME` varchar(255) NOT NULL,
  `USER_PASSWORD` varchar(255) NOT NULL,
  `USER_STATUS` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user_table`
--

INSERT INTO `user_table` (`USER_ID`, `USER_NAME`, `USER_PASSWORD`, `USER_STATUS`) VALUES
(1, 'User', 'user', 'Active'),
(2, 'Ceylon', 'ceylon', 'Deactive');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `client_table`
--
ALTER TABLE `client_table`
  ADD PRIMARY KEY (`CLIENT_ID`);

--
-- Indexes for table `orders_table`
--
ALTER TABLE `orders_table`
  ADD PRIMARY KEY (`ORDER_ID`),
  ADD KEY `fk1` (`CLIENT_ID`),
  ADD KEY `fk2` (`PRODUCT_ID`);

--
-- Indexes for table `product_table`
--
ALTER TABLE `product_table`
  ADD PRIMARY KEY (`PRODUCT_ID`);

--
-- Indexes for table `user_table`
--
ALTER TABLE `user_table`
  ADD PRIMARY KEY (`USER_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `client_table`
--
ALTER TABLE `client_table`
  MODIFY `CLIENT_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `orders_table`
--
ALTER TABLE `orders_table`
  MODIFY `ORDER_ID` int(25) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `product_table`
--
ALTER TABLE `product_table`
  MODIFY `PRODUCT_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `user_table`
--
ALTER TABLE `user_table`
  MODIFY `USER_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `orders_table`
--
ALTER TABLE `orders_table`
  ADD CONSTRAINT `fk1` FOREIGN KEY (`CLIENT_ID`) REFERENCES `client_table` (`CLIENT_ID`),
  ADD CONSTRAINT `fk2` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `product_table` (`PRODUCT_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
