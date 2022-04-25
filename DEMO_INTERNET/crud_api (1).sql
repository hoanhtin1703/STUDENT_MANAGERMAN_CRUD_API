-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th4 25, 2022 lúc 07:53 AM
-- Phiên bản máy phục vụ: 10.4.22-MariaDB
-- Phiên bản PHP: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `crud_api`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `account`
--

CREATE TABLE `account` (
  `id` int(11) NOT NULL,
  `user_name` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `account`
--

INSERT INTO `account` (`id`, `user_name`, `password`, `name`) VALUES
(1, 'Ten Dang Nhap', 'Mat Khau', 'Ten Nguoi Dung'),
(2, 'Ten Dang Nhap', 'Mat Khau', 'Ten Nguoi Dung'),
(3, 'Ten Dang Nhap', 'Mat Khau', 'Ten Nguoi Dung'),
(4, 'Ten Dang Nhap', 'Mat Khau', 'Ten Nguoi Dung'),
(5, 'tin123', '123', '123123'),
(6, '123', '123', '1123'),
(7, '123', '123', '123123'),
(8, '123', '123123', '123123'),
(9, '123', '123123', '123123'),
(10, 'tin123', '123123', '123123'),
(11, 'tin123', '123123', '123123'),
(12, '123123', '123123123', '123123123'),
(13, '123123 tin123123', '123123123', '123123123'),
(14, '123123 tin123123', '123123123', '123123123'),
(15, '123123', '123123123123213', '123123123'),
(16, '123', '123123', '123123123g'),
(17, '123123', '123123', '123123'),
(18, '1', '2', '12'),
(19, '123', '123123', '123123'),
(20, '123', '123123', '123123'),
(21, '123', '123213', '12312321'),
(22, '12312', '123123', '123123123'),
(23, '12312', '123123', '123123123'),
(24, '12312', '123123', '123123123'),
(25, '12312', '123123', '123123123'),
(26, '123', '123123', '123123'),
(27, '123123', '123123123123123', '123123123123123'),
(28, '123123', '123123', '123123123'),
(29, '12312', '123123', '123123123'),
(30, '123123', '123123', '123123'),
(31, '12312', '3123123', '123123'),
(32, '123123', '12312312', '312312312321'),
(33, '123', '123123', '1231231'),
(34, '123123', '123123', '123123123123'),
(35, '123', '123', '123123123213'),
(36, 'anh tin', '123', '123'),
(37, 'tin', '1231', '123123123'),
(38, '123123', '123123', '123123123'),
(39, 'tin123', '1231231231', '1231231231213'),
(40, 'tin123', '1231231231', '1231231231213'),
(41, '123', '123123', '123123123'),
(42, '123', '123123', '123123122'),
(43, '123', '123123', '123123123'),
(44, '123', '123123', '123123123'),
(45, '123', '123123', '123123'),
(46, '123', '123123', '123123123'),
(47, '123', '123', '123123'),
(48, 'tinlake1703', 'anhtin123', 'tin');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `student`
--

CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `name` varchar(250) COLLATE utf8mb4_unicode_ci NOT NULL,
  `student_code` varchar(250) COLLATE utf8mb4_unicode_ci NOT NULL,
  `grade` varchar(250) COLLATE utf8mb4_unicode_ci NOT NULL,
  `major` varchar(250) COLLATE utf8mb4_unicode_ci NOT NULL,
  `date` date NOT NULL,
  `image` text COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `student`
--

INSERT INTO `student` (`id`, `name`, `student_code`, `grade`, `major`, `date`, `image`) VALUES
(20, '123213', '123213', '123', '123123213', '2022-04-21', '/DEMO_INTERNET/picture/20.jpeg'),
(21, 'lake', '123123', '123123', '123123123j', '2022-04-14', '/DEMO_INTERNET/picture/21.jpeg');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `account`
--
ALTER TABLE `account`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- AUTO_INCREMENT cho bảng `student`
--
ALTER TABLE `student`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
