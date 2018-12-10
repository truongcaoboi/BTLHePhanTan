-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 10, 2018 lúc 04:10 AM
-- Phiên bản máy phục vụ: 10.1.37-MariaDB
-- Phiên bản PHP: 7.1.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `minibank2`
--

DELIMITER $$
--
-- Thủ tục
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertAccount` (IN `stk` VARCHAR(20), IN `address` VARCHAR(1000), IN `bal` DOUBLE, IN `birth` VARCHAR(10), IN `email` VARCHAR(200), IN `name` VARCHAR(200), IN `gen` INT, IN `iden` VARCHAR(20), IN `phone` VARCHAR(20), IN `sta` INT)  BEGIN
   insert into account(Account_No,address,balance,birth,date_create,email,fullname,gender,iden_no,phone,sta) values ('\''+stk+'\'','\''+address+'\'',bal,'\''+birth+'\'',now(),'\''+email+'\'','\''+name+'\'',gen,'\''+iden+'\'','\''+phone+'\'',sta);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertAcount` (`stk` VARCHAR(20), `name` VARCHAR(200), `bal` DOUBLE, `birth` VARCHAR(10), `email` VARCHAR(200), `address` VARCHAR(1000), `gender` INT, `iden` VARCHAR(20), `phone` VARCHAR(20), `sta` INT)  BEGIN
   insert into account(Account_No,address,balance,birth,date_create,email,fullname,gender,iden_no,phone,sta) VALUES ('\''+stk+'\'','\''+address+'\'',bal,'\''+birth+'\'',now(),'\''+email+'\'','\''+name+'\'',gender,'\''+iden+'\'','\''+phone+'\'',sta);
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `account`
--

CREATE TABLE `account` (
  `Account_No` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `fullname` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `birth` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `phone` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `address` varchar(1000) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `iden_no` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `gender` int(11) NOT NULL,
  `date_create` date NOT NULL,
  `balance` double NOT NULL,
  `sta` int(11) NOT NULL,
  `MarkLock` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `account`
--

INSERT INTO `account` (`Account_No`, `fullname`, `birth`, `phone`, `address`, `email`, `iden_no`, `gender`, `date_create`, `balance`, `sta`, `MarkLock`) VALUES
('355716145997', 'Hoành A Tráng', '1997', '01236987451', 'Hai Bà Trưng - Hà Nội', '01236985211', '0123698521', 1, '2018-12-10', 50000, 1, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `card`
--

CREATE TABLE `card` (
  `card_no` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `pass` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `type` int(11) NOT NULL,
  `sta` int(11) NOT NULL,
  `date_create` date NOT NULL,
  `account_no` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `card`
--

INSERT INTO `card` (`card_no`, `pass`, `type`, `sta`, `date_create`, `account_no`) VALUES
('7252298444069658', '123456', 0, 1, '2018-12-10', '355716145997'),
('7896936117570947', '123456', 1, 0, '2018-12-10', '355716145997');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `transaction`
--

CREATE TABLE `transaction` (
  `id` int(11) NOT NULL,
  `bill_no` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL,
  `card_no` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `amount` double NOT NULL,
  `type` int(11) NOT NULL,
  `receiver` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `sta` int(11) NOT NULL,
  `exchage_at` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `date_create` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `transaction`
--

INSERT INTO `transaction` (`id`, `bill_no`, `card_no`, `amount`, `type`, `receiver`, `sta`, `exchage_at`, `date_create`) VALUES
(21, '25115569253212573512490597010595', '7252298444069658', 10000, 1, '355716145997', 0, 'Ngân hàng', '2018-12-10 09:31:11'),
(22, '47510469623223706124917754296957', '7252298444069658', 10000, 2, '355716145997', 0, 'Ngân hàng', '2018-12-10 09:32:15'),
(23, '68161238902650605002730078070012', '7252298444069658', 10000, 3, '355716145997', 0, 'Ngân hàng', '2018-12-10 09:32:41');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`Account_No`),
  ADD UNIQUE KEY `phone` (`phone`),
  ADD UNIQUE KEY `iden_no` (`iden_no`);

--
-- Chỉ mục cho bảng `card`
--
ALTER TABLE `card`
  ADD PRIMARY KEY (`card_no`),
  ADD KEY `fk_card_account` (`account_no`);

--
-- Chỉ mục cho bảng `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_transaction_card` (`card_no`),
  ADD KEY `fk_tran_account` (`receiver`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `transaction`
--
ALTER TABLE `transaction`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `card`
--
ALTER TABLE `card`
  ADD CONSTRAINT `fk_card_account` FOREIGN KEY (`account_no`) REFERENCES `account` (`Account_No`);

--
-- Các ràng buộc cho bảng `transaction`
--
ALTER TABLE `transaction`
  ADD CONSTRAINT `fk_tran_account` FOREIGN KEY (`receiver`) REFERENCES `account` (`Account_No`),
  ADD CONSTRAINT `fk_transaction_card` FOREIGN KEY (`card_no`) REFERENCES `card` (`card_no`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
