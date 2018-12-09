-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 09, 2018 lúc 09:15 PM
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
('123098731456', 'Tạ Tuyết Trinh', '1990', '4567893221', 'Mỹ Đình - Hà Nội', 'trinh@gmail.com', '1230098712', 0, '2018-12-01', 10000, 0, 0),
('1234', 'Ngân hàng', '2018', '11111111111', 'DHBKHN', 'email@hust.edu.vn', '2015', 1, '2018-12-06', 10000000000, 0, 0),
('127893056478', 'Trần Đình Tú', '1994', '1256784356', 'Hoàng Mai - Hà Nội', 'email@gmail.com', '125666783', 1, '2018-12-04', 60000, 1, 0),
('250449290031', 'Đào Xuân Hải', '1989', '088345789', 'Thanh Xuân - Hà Nội', '', '234590876', 1, '2018-12-05', 30000, 1, 0),
('566840037431', 'Hà Đức Chinh', '1997', '3457392342', 'Chương Mỹ - Hà Nội', 'ahii@gmail.com', '0032897456', 1, '2018-12-06', 30000, 0, 0),
('706723747014', 'Đặng Xuân Trường', '1997', '1234567654', 'Hai Bà Trưng - Hà Nội', 'truong@mail.com', '1111111111', 1, '2018-12-09', 900000, 1, 0);

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
('0025365478523654', '1', 1, 0, '2018-12-05', '123098731456'),
('0592067786785322', '123456', 1, 0, '2018-12-09', '706723747014'),
('0765568457143214', '123456', 0, 1, '2018-12-10', '1234'),
('0943585586881910', '123456', 1, 0, '2018-12-09', '1234'),
('1068041135025161', '123456', 1, 1, '2018-12-09', '1234'),
('1863615707677901', '123456', 1, 1, '2018-12-10', '123098731456'),
('3701334079203769', '123456', 1, 1, '2018-12-09', '1234'),
('4623788583952545', '123456', 1, 1, '2018-12-06', '566840037431'),
('5489667270705677', '123456', 1, 1, '2018-12-05', '123098731456'),
('5944870677710372', '123456', 0, 1, '2018-12-09', '1234'),
('6089821908891815', '123456', 1, 1, '2018-12-09', '127893056478'),
('6151373086122627', '123456', 0, 0, '2018-12-05', '123098731456'),
('6412770907404618', '123456', 1, 1, '2018-12-09', '1234'),
('7651090082608424', '123456', 0, 1, '2018-12-09', '1234'),
('9354584540633493', '123456', 1, 1, '2018-12-10', '1234');

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
(1, '12346777', '0025365478523654', 500000, 1, '123098731456', 1, 'ngân hàng', '2018-12-04 00:00:00'),
(2, '34815425062609011129366234110984', '5489667270705677', 500000, 1, '123098731456', 1, 'ATM', '2018-12-05 11:22:30'),
(4, '89005940379431171925449071026170', '5489667270705677', 30000, 2, '1234', 0, 'ATM', '2018-12-06 00:19:03'),
(5, '41269250884684896885667648619980', '5489667270705677', 30000, 1, '123098731456', 0, 'ATM', '2018-12-06 00:23:04'),
(6, '04812624484263519046604083360268', '5489667270705677', 30000, 2, '1234', 0, 'ATM', '2018-12-06 00:23:58'),
(7, '23061424744584281706706059147947', '5489667270705677', 30000, 2, '123098731456', 0, 'ATM', '2018-12-06 00:24:26'),
(8, '34880552250681790885940798886186', '5489667270705677', 30000, 1, '127893056478', 0, 'ATM', '2018-12-06 00:33:20'),
(9, '86745913073350203804769700848670', '5489667270705677', 30000, 1, '127893056478', 0, 'ATM', '2018-12-06 00:33:34'),
(10, '63569792451882811983137928870299', '4623788583952545', 30000, 2, '566840037431', 0, 'ATM', '2018-12-06 23:27:16'),
(11, '11282149763647796576319337127521', '4623788583952545', 30000, 3, '566840037431', 0, 'ATM', '2018-12-06 23:28:41'),
(12, '75380756158463906977085129299336', '0025365478523654', 1000, 1, '123098731456', 0, 'ATM', '2018-12-07 23:16:04'),
(13, '67293404682362100507104696972562', '0025365478523654', 1000, 2, '123098731456', 0, 'ATM', '2018-12-07 23:16:18'),
(14, '96425288041570106967942027946535', '0025365478523654', 5000, 1, '123098731456', 0, 'ATM', '2018-12-07 23:17:00'),
(15, '60435279884074544338546219636981', '0025365478523654', 5000, 1, '123098731456', 0, 'ATM', '2018-12-07 23:18:09'),
(16, '54930018167458955748426664741795', '0025365478523654', 20000, 2, '123098731456', 0, 'ATM', '2018-12-07 23:19:43'),
(17, '95620828632395878005251238148226', '0025365478523654', 10000, 3, '123098731456', 0, 'ATM', '2018-12-07 23:20:13'),
(18, '32101807617526235132944791971795', '0025365478523654', 30000, 1, '123098731456', 0, 'Ngân hàng', '2018-12-10 01:14:38'),
(19, '73366856179542936518288513741813', '0025365478523654', 30000, 2, '123098731456', 0, 'Ngân hàng', '2018-12-10 01:14:55'),
(20, '07453761840180939930838715181424', '0025365478523654', 30000, 3, '250449290031', 0, 'Ngân hàng', '2018-12-10 01:15:25');

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

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
