-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 25, 2020 at 03:36 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `chat`
--

-- --------------------------------------------------------

--
-- Table structure for table `conversation`
--

CREATE TABLE `conversation` (
  `id_con` int(11) NOT NULL,
  `id_from` int(11) NOT NULL,
  `id_to` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `conversation`
--

INSERT INTO `conversation` (`id_con`, `id_from`, `id_to`) VALUES
(21, 2, 1),
(51, 5, 1),
(61, 6, 1),
(65, 6, 5),
(67, 6, 7),
(71, 7, 1),
(81, 8, 1),
(85, 8, 5),
(100, 9, 10),
(122, 11, 12),
(141, 14, 1);

-- --------------------------------------------------------

--
-- Table structure for table `message`
--

CREATE TABLE `message` (
  `id_msg` int(11) NOT NULL,
  `body_msg` text NOT NULL,
  `date_send` datetime NOT NULL,
  `id_user_from` int(11) NOT NULL,
  `id_con` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `message`
--

INSERT INTO `message` (`id_msg`, `body_msg`, `date_send`, `id_user_from`, `id_con`) VALUES
(65, 'Hello ban le van chien', '2020-12-25 10:35:31', 6, 61),
(66, 'chào lại bạn admin', '2020-12-25 10:35:54', 1, 61),
(67, 'hello Lê văn chiến', '2020-12-25 10:38:22', 5, 51),
(68, 'hi', '2020-12-25 10:50:05', 1, 61),
(69, 'Hello nguyenthia', '2020-12-25 14:20:02', 8, 85),
(70, 'Xin chào bạn huy', '2020-12-25 14:20:14', 5, 85),
(71, 'khoẻ không', '2020-12-25 14:20:31', 5, 85),
(72, 'Vẫn bình thường', '2020-12-25 14:20:41', 8, 85),
(73, 'Hello nguyenthia', '2020-12-25 14:21:53', 6, 65),
(74, 'from admin', '2020-12-25 14:22:13', 6, 65),
(75, 'Xin chao admin from nguyen thi a', '2020-12-25 14:25:15', 5, 65),
(76, 'xin chao nguyen thi a from admin', '2020-12-25 14:25:32', 6, 65),
(77, 'khoẻ không ban êy', '2020-12-25 14:25:48', 6, 65),
(78, 'Mình bình thường nhé', '2020-12-25 14:26:06', 5, 65),
(79, 'khoẻ không ban êy', '2020-12-25 14:26:13', 6, 65),
(80, 'chào chiến', '2020-12-25 14:26:28', 6, 61),
(81, 'chào admin', '2020-12-25 14:26:42', 1, 61),
(82, 'hallo', '2020-12-25 15:14:39', 1, 51),
(83, 'hi lai', '2020-12-25 15:14:48', 5, 51),
(84, 'Hello chien', '2020-12-25 15:15:39', 6, 61),
(85, 'test', '2020-12-25 15:16:32', 8, 81),
(86, 'test offlline', '2020-12-25 15:22:27', 8, 81),
(87, 'hello', '2020-12-25 17:18:04', 1, 61),
(88, 'Chào bạn chiến, thi a đây', '2020-12-25 17:38:22', 5, 51),
(89, 'Hello thi a', '2020-12-25 17:38:40', 1, 51),
(90, 'Có quen đâu', '2020-12-25 17:38:54', 1, 51),
(91, 'chao bạn trần văn huy', '2020-12-25 17:41:10', 6, 67),
(92, 'chao chien', '2020-12-25 17:42:18', 7, 71),
(93, 'hello a, from chien', '2020-12-25 19:47:04', 1, 51),
(94, 'hello chien, from a', '2020-12-25 19:47:18', 5, 51),
(95, 'hello', '2020-12-25 19:49:37', 2, 21),
(96, 'hi again', '2020-12-25 19:49:46', 1, 21),
(97, 'Chao ce', '2020-12-25 20:48:55', 9, 100),
(98, 'Hello admin3', '2020-12-25 20:55:34', 11, 122),
(99, 'Hello laij', '2020-12-25 20:55:44', 12, 122),
(100, 'hello chien', '2020-12-25 20:59:40', 14, 141),
(101, 'aaaa', '2020-12-25 20:59:47', 1, 141),
(102, 'bbbb', '2020-12-25 20:59:50', 1, 141);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` text NOT NULL,
  `fullname` text NOT NULL,
  `password` varchar(20) NOT NULL,
  `description` text DEFAULT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `fullname`, `password`, `description`, `status`) VALUES
(1, 'Chien123', 'Le chien', '123', 'Handsome boyy', 0),
(2, 'Chien456', 'Le Van', '456', 'Handsome', 0),
(3, 'ABC', 'Cao quang', '123', '', 0),
(4, 'nguyenvana', 'nguyen van a', '123', '1111', 0),
(5, 'nguyenthia', 'nguyen thi a', '123', NULL, 0),
(6, 'admin', 'Nguyen Admin', '123', 'thích thì nhích', 0),
(7, 'tranvana', 'Trần Văn A', '123', 'Nhà khảo cổ, sống tại hà nội', 0),
(8, 'duongvanhuy', 'Dương Văn Huy', '123', 'Lập trình viên, thích màu hường', 0),
(9, 'lethibe', 'Lê Thị Bê', '123', 'Yêu đời', 0),
(10, 'lethic', 'Lê Thị Cê', '123', 'Chán đời', 0),
(11, 'admin2', 'admin2', '123', 'admin2', 0),
(12, 'admin3', 'admin3', '123', 'admin3', 0),
(13, 'admin4', 'admin4', '123', 'admin4', 0),
(14, 'admin5', 'admin5', '123', 'admin5', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `conversation`
--
ALTER TABLE `conversation`
  ADD PRIMARY KEY (`id_con`);

--
-- Indexes for table `message`
--
ALTER TABLE `message`
  ADD PRIMARY KEY (`id_msg`),
  ADD KEY `id_con` (`id_con`),
  ADD KEY `id_user_from` (`id_user_from`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`) USING HASH;

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `conversation`
--
ALTER TABLE `conversation`
  MODIFY `id_con` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=142;

--
-- AUTO_INCREMENT for table `message`
--
ALTER TABLE `message`
  MODIFY `id_msg` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=103;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `message`
--
ALTER TABLE `message`
  ADD CONSTRAINT `message_ibfk_1` FOREIGN KEY (`id_con`) REFERENCES `conversation` (`id_con`),
  ADD CONSTRAINT `message_ibfk_2` FOREIGN KEY (`id_user_from`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
