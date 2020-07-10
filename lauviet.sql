-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 10, 2020 at 05:51 AM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.2.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `shop1`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `address` varchar(50) NOT NULL,
  `quyen` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`user_id`, `user_name`, `password`, `email`, `phone`, `address`, `quyen`) VALUES
(3, 'Duc', '123', 'mrduc@gmail.com', '0363146409', 'Tay Ninh', 'khachhang'),
(4, 'Cong', '123', 'cong@gmail.com', '123345677', 'diachi', 'admin'),
(7, 'admin', '123456', 'admin@gmail.com', '0986820780', 'HoChiMinh', 'admin'),
(8, 'qw', 'qw', 'fffj@gmail.com', '22455', 'ddh', 'khachhang');

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE `bill` (
  `id` int(11) NOT NULL,
  `id_customer` int(11) NOT NULL,
  `date_order` date NOT NULL DEFAULT current_timestamp(),
  `total` float NOT NULL,
  `note` text DEFAULT NULL,
  `status` varchar(20) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `bill`
--

INSERT INTO `bill` (`id`, `id_customer`, `date_order`, `total`, `note`, `status`) VALUES
(65, 4, '2020-05-25', 550000, NULL, 'chua giao'),
(66, 4, '2020-05-25', 1540000, NULL, 'chua giao'),
(67, 4, '2020-05-26', 2550000, NULL, 'chua giao'),
(75, 8, '2020-07-07', 560000, NULL, 'chua giao'),
(76, 8, '2020-07-08', 840000, NULL, 'chua giao'),
(77, 8, '2020-07-08', 600000, NULL, 'chua giao'),
(78, 8, '2020-07-08', 200000, NULL, 'chua giao'),
(79, 8, '2020-07-08', 200000, NULL, 'chua giao'),
(80, 8, '2020-07-08', 460000, NULL, 'chua giao'),
(81, 8, '2020-07-08', 280000, NULL, 'chua giao'),
(82, 8, '2020-07-08', 460000, NULL, 'chua giao'),
(83, 8, '2020-07-08', 280000, NULL, 'chua giao'),
(84, 8, '2020-07-08', 200000, NULL, 'chua giao'),
(85, 8, '2020-07-08', 800000, NULL, 'chua giao'),
(86, 8, '2020-07-08', 400000, NULL, 'chua giao'),
(87, 8, '2020-07-08', 580000, NULL, 'chua giao'),
(88, 8, '2020-07-08', 600000, NULL, 'chua giao'),
(89, 8, '2020-07-08', 880000, NULL, 'chua giao'),
(90, 8, '2020-07-08', 560000, NULL, 'chua giao'),
(91, 8, '2020-07-08', 560000, NULL, 'chua giao'),
(92, 8, '2020-07-08', 280000, NULL, 'chua giao'),
(93, 8, '2020-07-08', 200000, NULL, 'chua giao'),
(94, 8, '2020-07-09', 840000, NULL, 'chua giao'),
(95, 8, '2020-07-09', 280000, NULL, 'chua giao'),
(96, 8, '2020-07-09', 280000, NULL, 'chua giao'),
(97, 8, '2020-07-09', 840000, NULL, 'chua giao'),
(98, 8, '2020-07-09', 560000, NULL, 'chua giao'),
(99, 8, '2020-07-09', 280000, NULL, 'chua giao'),
(100, 8, '2020-07-09', 280000, NULL, 'chua giao'),
(101, 8, '2020-07-09', 280000, NULL, 'chua giao'),
(102, 8, '2020-07-09', 280000, NULL, 'chua giao'),
(103, 8, '2020-07-09', 1120000, NULL, 'chua giao'),
(104, 8, '2020-07-09', 1400000, NULL, 'chua giao'),
(105, 8, '2020-07-09', 280000, NULL, 'chua giao'),
(106, 8, '2020-07-09', 560000, NULL, 'chua giao'),
(107, 8, '2020-07-09', 200000, NULL, 'chua giao'),
(108, 8, '2020-07-09', 200000, NULL, 'chua giao'),
(109, 8, '2020-07-09', 560000, NULL, 'chua giao'),
(110, 8, '2020-07-09', 280000, NULL, 'chua giao'),
(111, 8, '2020-07-09', 200000, NULL, 'chua giao'),
(112, 8, '2020-07-09', 280000, NULL, 'chua giao'),
(113, 8, '2020-07-09', 280000, NULL, 'chua giao'),
(114, 8, '2020-07-09', 280000, NULL, 'chua giao'),
(115, 8, '2020-07-09', 280000, NULL, 'chua giao'),
(116, 8, '2020-07-09', 280000, NULL, 'chua giao'),
(117, 8, '2020-07-09', 400000, NULL, 'chua giao'),
(118, 8, '2020-07-09', 280000, NULL, 'chua giao'),
(119, 8, '2020-07-09', 200000, NULL, 'chua giao'),
(120, 8, '2020-07-09', 400000, NULL, 'chua giao'),
(121, 8, '2020-07-09', 560000, NULL, 'chua giao'),
(122, 8, '2020-07-09', 280000, NULL, 'chua giao'),
(123, 8, '2020-07-09', 180000, NULL, 'chua giao'),
(124, 8, '2020-07-09', 200000, NULL, 'chua giao'),
(125, 8, '2020-07-09', 280000, NULL, 'chua giao'),
(126, 8, '2020-07-09', 280000, NULL, 'chua giao'),
(127, 8, '2020-07-09', 280000, NULL, 'chua giao'),
(128, 8, '2020-07-09', 280000, NULL, 'chua giao'),
(129, 8, '2020-07-09', 280000, NULL, 'chua giao'),
(130, 8, '2020-07-09', 280000, NULL, 'chua giao'),
(135, 8, '2020-07-09', 380000, NULL, 'chua giao'),
(136, 8, '2020-07-10', 280000, NULL, 'chua giao'),
(137, 8, '2020-07-10', 180000, NULL, 'chua giao'),
(138, 8, '2020-07-10', 220000, NULL, 'chua giao');

-- --------------------------------------------------------

--
-- Table structure for table `bill_detail`
--

CREATE TABLE `bill_detail` (
  `id` int(11) NOT NULL,
  `id_bill` int(11) NOT NULL,
  `id_product` int(11) NOT NULL,
  `quantity` float DEFAULT 0,
  `price` float NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `bill_detail`
--

INSERT INTO `bill_detail` (`id`, `id_bill`, `id_product`, `quantity`, `price`) VALUES
(33, 65, 28, 2, 110000),
(35, 66, 109, 2, 200000),
(36, 67, 109, 2, 200000),
(37, 67, 28, 1, 550000),
(49, 75, 38, 2, 560000),
(50, 76, 38, 3, 840000),
(51, 77, 109, 3, 600000),
(52, 78, 109, 1, 200000),
(53, 79, 109, 1, 200000),
(54, 80, 38, 1, 280000),
(55, 80, 36, 1, 180000),
(56, 81, 38, 1, 280000),
(57, 82, 38, 1, 280000),
(58, 82, 36, 1, 180000),
(59, 83, 38, 1, 280000),
(60, 84, 109, 1, 200000),
(61, 85, 109, 4, 800000),
(62, 86, 109, 2, 400000),
(63, 87, 109, 2, 400000),
(64, 87, 36, 1, 180000),
(65, 88, 109, 3, 600000),
(66, 89, 109, 3, 600000),
(67, 89, 38, 1, 280000),
(68, 90, 38, 2, 560000),
(69, 91, 38, 2, 560000),
(70, 92, 38, 1, 280000),
(71, 93, 109, 1, 200000),
(72, 94, 38, 3, 840000),
(73, 95, 38, 1, 280000),
(74, 96, 38, 1, 280000),
(75, 97, 38, 3, 840000),
(76, 98, 38, 2, 560000),
(77, 99, 38, 1, 280000),
(78, 100, 38, 1, 280000),
(79, 101, 38, 1, 280000),
(80, 102, 38, 1, 280000),
(81, 103, 38, 4, 1120000),
(82, 104, 38, 5, 1400000),
(83, 105, 37, 1, 280000),
(84, 106, 37, 1, 280000),
(85, 106, 38, 1, 280000),
(86, 107, 109, 1, 200000),
(87, 108, 109, 1, 200000),
(88, 109, 38, 2, 560000),
(89, 110, 38, 1, 280000),
(90, 111, 109, 1, 200000),
(91, 112, 38, 1, 280000),
(92, 113, 38, 1, 280000),
(93, 114, 38, 1, 280000),
(94, 115, 38, 1, 280000),
(95, 116, 38, 1, 280000),
(96, 117, 109, 2, 400000),
(97, 118, 38, 1, 280000),
(98, 119, 1, 1, 200000),
(99, 120, 109, 2, 400000),
(100, 121, 38, 2, 560000),
(101, 122, 38, 1, 280000),
(102, 123, 36, 1, 180000),
(103, 124, 109, 1, 200000),
(104, 125, 38, 1, 280000),
(105, 126, 38, 1, 280000),
(106, 127, 38, 1, 280000),
(107, 128, 38, 1, 280000),
(108, 129, 38, 1, 280000),
(109, 130, 38, 1, 280000),
(114, 135, 109, 1, 200000),
(115, 135, 36, 1, 180000),
(116, 136, 37, 1, 280000),
(117, 137, 36, 1, 180000),
(118, 138, 2, 1, 200000),
(119, 138, 18, 1, 20000);

-- --------------------------------------------------------

--
-- Table structure for table `comment`
--

CREATE TABLE `comment` (
  `id_comment` int(11) NOT NULL,
  `id_product` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `content` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `comment`
--

INSERT INTO `comment` (`id_comment`, `id_product`, `user_id`, `content`) VALUES
(6, 37, 8, 'fghy'),
(71, 109, 8, 'hjhgf'),
(72, 38, 8, 'jhe'),
(73, 109, 8, 'yyyj'),
(74, 109, 8, '.v'),
(75, 38, 8, 'fdh'),
(76, 38, 8, 'ba'),
(77, 109, 8, '');

-- --------------------------------------------------------

--
-- Table structure for table `images`
--

CREATE TABLE `images` (
  `id` int(11) NOT NULL,
  `link` varchar(255) NOT NULL,
  `id_product` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `images`
--

INSERT INTO `images` (`id`, `link`, `id_product`) VALUES
(1, 'http://dichvucuoihoilychi.com/uploads/products/183652422_lau.png', 1),
(2, 'http://dichvucuoihoilychi.com/uploads/products/831786036_10.png', 2),
(3, 'http://dichvucuoihoilychi.com/uploads/products/152239061_7.png', 3),
(4, 'http://dichvucuoihoilychi.com/uploads/products/162492062_3.png', 4),
(5, 'http://dichvucuoihoilychi.com/uploads/products/1959345216_11.png', 5),
(6, 'http://dichvucuoihoilychi.com/uploads/products/87321842_9.png', 6),
(7, 'http://dichvucuoihoilychi.com/uploads/products/735104274_2.png', 7),
(8, 'https://www.habibi.com.vn/wp-content/uploads/12385135_969803746398775_841069975_n.jpg', 8),
(9, 'https://cdn.daotaobeptruong.vn/wp-content/uploads/2018/04/cach-lam-lau-ech.jpg', 9),
(10, 'https://cdn.daotaobeptruong.vn/wp-content/uploads/2017/10/mon-lau-ga-ot-hiem.jpg', 10),
(11, 'https://img.lovepik.com/photo/50119/3396.jpg_wh860.jpg', 11),
(12, 'https://gofood.vn/uploads/Anh/ba-chi-bo-my-02.jpg', 12),
(13, 'https://media.doisongphapluat.com/500/2018/5/15/be%20hap%20dspl4.jpg', 13),
(14, 'https://thucpham29.com/media/news/160_duoi_bo_ham_toi.jpg', 14),
(15, 'https://img.lovepik.com/photo/50106/0022.jpg_wh860.jpg', 15),
(16, 'https://img.lovepik.com/photo/50086/0841.jpg_wh860.jpg', 16),
(17, 'https://media.ex-cdn.com/EXP/media.tintucvietnam.vn/files/f1/2019/05/01/sach-bo-la-gi-va-sach-bo-o-bo-phan-nao-bb-baaadCUR4n.jpg?v=1556674214133', 17),
(18, 'https://lacdavang.com/wp-content/uploads/2017/11/tra-vai-13a.jpg', 18),
(19, 'https://img.lovepik.com/photo/50130/4917.jpg_wh860.jpg', 19),
(20, 'https://minhducgreen.com/wp-content/uploads/2020/03/cach-lam-sinh-to-rau-ma.jpg', 20),
(21, 'https://megaby.files.wordpress.com/2015/07/bia-bernard-celebration-500ml.jpg', 21),
(22, 'https://product.hstatic.net/1000282430/product/beer-passion-fruit-wheat-ale-330ml_59da2fdc47944fdcb99e9ad51951ac76_large.jpg', 22),
(23, 'https://thegioibianhapkhau.files.wordpress.com/2014/10/183_635430223958235367.jpg?w=219&h=299', 23),
(24, 'https://salt.tikicdn.com/cache/w390/ts/product/b0/58/12/1729a1ade54ad6be954b316df112f3d8.jpg', 24),
(25, 'https://sieuthiruouvang.com.vn/wp-content/uploads/2019/05/bia-Budweiser-Chai-Nhom-330ml-My-600x600.jpg', 25),
(26, 'https://www.foodpanda.vn/wp-content/uploads/2018/11/cach-nau-lau-hai-san-8.jpg', 26),
(28, 'https://miro.medium.com/max/645/0*aEBF9-n-RqvXEaWR.jpg', 28),
(29, 'https://giacngo.vn/UserImages/2020/03/17/11/raumuong.jpg', 29),
(30, 'https://img.lovepik.com/photo/50055/0944.jpg_wh860.jpg', 30),
(31, 'https://nld.mediacdn.vn/2017/1421121693bongsung-1510495869157.jpg', 31),
(32, 'https://lh3.googleusercontent.com/proxy/o7C5leFjH_E9lqIMB0HSGTLxzkEW09zLuCmWRvm88z9uo9HcQMmN7-3RJGrMSjy3ZgeaJk6zyx7lGJKSzX4OwPZeXtozuACh82d3_Vq1vLZfSTH2l7t9mUjb', 32),
(33, 'https://d3kg1kmrau77q0.cloudfront.net/food/309/c47a__rau-dang.jpg', 33),
(34, 'https://www.habibi.com.vn/wp-content/uploads/IMG_0073.jpg', 34),
(35, 'https://www.habibi.com.vn/wp-content/uploads/12521047_1370486846301546_1176713830_n.jpg', 35),
(36, 'https://www.habibi.com.vn/wp-content/uploads/2-thit-bo-nhung-giam-ngon.jpg', 36),
(37, 'https://www.habibi.com.vn/wp-content/uploads/tuyet-chieu-cuc-doc-cho-cach-lam-lau-ga-bong-ruou-tro-nen-quyen-ru-kho-luong.jpg', 37),
(38, 'https://www.habibi.com.vn/wp-content/uploads/lau-trung-hoa-co-gi-ngon_2688223041.jpg', 38),
(109, 'https://www.hoidaubepaau.com/wp-content/uploads/2015/12/lau-thai-hai-san.jpg', 109);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `id_type` int(11) DEFAULT NULL,
  `price` float DEFAULT 0,
  `color` varchar(255) DEFAULT NULL,
  `material` varchar(1000) DEFAULT NULL COMMENT 'chất liệu',
  `description` text NOT NULL,
  `new` tinyint(4) NOT NULL DEFAULT 0,
  `inCollection` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `name`, `id_type`, `price`, `color`, `material`, `description`, `new`, `inCollection`) VALUES
(1, 'Lẩu thập cẩm- Mì vàng', 1, 200000, '1', 'Thịt cá , tôm', 'Lẩu thập cẩm là món ăn được yêu thích với hương vị chua chua, cay cay quyến rũ. Vào thời tiết se lạnh hay những ngày mưa, món ăn này lại được người người, nhà nhà ưa thích hơn cả. ', 0, 0),
(2, 'Lẩu cua ghẹ', 1, 200000, '1', 'Cua , Ghẹ', 'Lẩu cua ghẹ có màu vàng ươm, mang vị ngọt thanh đặc trưng của ghẹ tươi rất quyến rũ và hấp dẫn. Ăn kèm với các loại rau xanh và bún tươi tuyệt ngon. Khi thưởng thức bạn sẽ được cảm nhận trọn vẹn vị ngọt của nước dùng thấm đẫm nơi đầu lưỡi và chất dinh dưỡng cao. ', 1, 0),
(3, 'Lẩu nắm', 1, 180000, '1', 'Tôm sú , rau', 'Lẩu nắm măng cay là sự kết hợp tuyệt vời giữa thịt tôm đồng thơm ngon bổ dưỡng và măng chua đậm vị ,Với hương vị thơm ngon, đặc biệt, giá trị dinh dưỡng cao. Rất phù hợp cho một buổi tối ấm cúng cùng gia đình.', 1, 0),
(4, 'Lẩu tôm sú Thái Lan', 1, 220000, '1', 'Tôm , mực', 'Lẩu tôm sú Thái Lan là sự kết hợp hài hòa giữa hải sản cùng vị chua chua, cay cay đặc trưng của xứ sở chùa Vàng thì Lẩu tôm Thái Lan là sự chọn thích hợp nhất. Với nguyên liệu chính là tôm ngon đặc biệt có lớp vỏ săn chắc và thịt cho vị thơm, mềm ngọt khi chín tới, giàu dinh dưỡng mà không kém phần thanh ngọt.', 1, 0),
(5, 'Lẩu cá tằm', 1, 300000, '1', 'Thịt ba chỉ , cá', 'Đây là một trong những loại lẩu được người Việt nam ưa chuộng bởi phù hợp khẩu vị chung và rất giàu dinh dưỡng. Các món lẩu Nhật Bản nổi tiếng tại Việt Nam phần lớn là Shabu Shabu. ', 0, 0),
(6, 'Lẩu cá Bốp-', 1, 190000, '1', 'Cá Bốp , măng chua', 'Món ngon lẩu các bóp măng chua có mùi thơm đặc trưng của nước dùng lẩu phảng phất, hòa vào thịt cá bóp dai và ngọt, món này cáng thơm ngon hơn với nhiều mùi vị rất hấp dẫn.', 1, 1),
(7, 'Lẩu cá thác lác', 1, 220000, '1', 'Cá thác lác , bún tươi', 'Lẩu cá thác lác khổ qua vị thanh đạm, tính lành là món ăn lý tưởng cho cả mùa lạnh và mùa nóng. Lẩu cá thác lác thơm bùi vị cá cùng với vị đăng đắng của khổ qua tươi xanh là món ăn rất giàu dinh dưỡng, vô cùng tốt cho sức khỏe..', 0, 0),
(8, 'Lẩu cá lăng', 1, 190000, '1', 'Cá lăng , tôm', 'Lẩu cá lăng là món ăn rất được yêu thích bởi hương đậm đà và cách nấu lẩu cá lăng khá đơn giản, dễ thực hiện kể cả với người mới học nấu ăn.Với hương vị thơm ngon, đặc biệt, giá trị dinh dưỡng cao. Rất phù hợp cho một buổi tối ấm cúng cùng gia đình', 0, 1),
(9, 'Lẩu ếch măng cay', 1, 150000, '1', 'Ếch ', 'Lẩu ếch măng cay là sự kết hợp tuyệt vời giữa thịt ếch đồng thơm ngon bổ dưỡng và măng chua đậm vị.Với hương vị thơm ngon, đặc biệt, giá trị dinh dưỡng cao.', 1, 0),
(10, 'Lẩu gà', 1, 149000, '1', 'Thịt gà', 'Lẩu gà vừa có vị chua nhẹ, cay cay, the the, lại thêm mùi tàu, hành hoa, là vị ngọt thơm của gà, hàm lượng dinh dưỡng cực kỳ cao giúp cho lẩu gà bỗng rượu trở thành món ăn tuyệt ngon trong những ngày trời lạnh.', 0, 0),
(11, 'Tôm', 2, 200000, '1', 'Tôm', ' Tôm là nguồn thức ăn giàu protein cho con người, trong đó có nhiều loại là thủy hải sản có giá trị thương mại rất cao.', 0, 1),
(12, 'Bò ba chỉ', 2, 180000, '1', 'Thịt ba chỉ', 'Thịt ba chỉ bò Mỹ với giá trị dinh dưỡng cao, ngậy béo khi nướng đi cùng với nước sốt chấm và sốt ướp đặc biệt sẽ mang đến cho gia đình bạn một bữa tiệc nướng ngày tại nhà.', 0, 0),
(13, 'Thịt bê', 2, 180000, '1', 'Thịt bê', 'Thịt bê là loại thịt bò được lấy từ con bê hay bò tơ. Thịt bê có nhiều chất dinh dưỡng tốt cho sức khỏe, thịt loại có thớ nhỏ sẽ mềm, thớ to và được chế biến thành nhiều món ăn ngon đặc biệt là món lẩu, món bê thui ở Việt Nam.', 1, 0),
(14, 'Đuôi bò', 2, 170000, '1', 'Đuôi bò', 'Món đuôi bò là sở trường của rất nhiều đấng mày râu. Có món đuôi bò nhâm nhi vào ngày cuối tuần rét mướt thật là thích thú.', 0, 0),
(15, 'Bắp bò', 2, 220000, '1', 'Bắp bò', 'Thịt bò, nhất là bắp bò rất giàu axit amoniac, cao hơn cả so với bất kì loại thực phẩm nào khác, có tác dụng làm tăng cơ bắp, đặc biệt là tăng cường sức khỏe cơ thể.', 0, 1),
(16, 'Gân bò', 2, 2000000, '1', 'Gân bò', 'Gân bò giòn dai rất giàu vitamin, không chỉ mang đến cho bạn những món ăn ngon miệng, bổ dưỡng mà còn bổ sung collagen cần thiết cho cơ thể.', 0, 0),
(17, 'Sách bò', 2, 190000, '1', 'Sách bò', 'Sách Bò bổ trung ích khí, giải độc, dưỡng tỳ, dưỡng vị, sách bò vị cam, tính bình hòa, quy kinh lạc tỳ, vị, có công hiệu kiện tỳ ích khí, dưỡng huyết.', 1, 0),
(18, 'Trà vải dưa hấu', 3, 20000, '1', 'Quả vải và dưa hấu', 'Quả vải và dưa hấu rồi, ngoài việc nhâm nhi vải và dưa hấu tươi, bạn hoàn toàn có thể dùng loại quả này để tạo ra một món đồ uống ngọt dịu tươi mát giải khát mùa hè đấy.', 1, 0),
(19, 'Nước chanh', 3, 20000, '1', 'Chanh', 'Một món đồ uống xưa như quả đất rồi, nhưng chẳng khi nào thiếu trong danh sách các loại nước uống mùa hè giải khát phải không.một quả chanh và vài viên đá là bạn đã ngay lập tức lấy lại sức lực trước cái nắng nóng đổ lửa này rồi.', 1, 1),
(20, 'Sinh tố rau má', 3, 20000, '1', 'Rau má', 'Rau má là thức uống giải nhiệt chắc hẳn ai cũng đã rõ, mùa hè đến uống một cốc sinh tố rau má vừa giải tỏa cơn khát, vừa điều hòa cơ thể từ bên trong thì còn gì tuyệt bằng nữa nhỉ.', 1, 0),
(21, 'Bia Speedway Stout', 3, 550000, '1', 'Mạch nha , Hoa Bia', 'Speedway Stout của AleSmith Brewing Company được đánh giá là một trong những loại bia ngon nhất hiện nay. Sản phẩm thuộc dòng bia đen được ưa chuộng. Với nguồn gốc từ Mỹ nên đảm bảo chất lượng. ', 0, 0),
(22, 'Bia Passionfruit', 3, 600000, '1', 'Mạch nha , Hoa Bia', 'Dù không được tiết lộ công thức sản xuất nhưng chất lượng của bia Passionfruit của Cigar City Brewing được đánh giá cao. Không chỉ có màu sắc đẹp với ánh hồng nhẹ nhàng mà bia Passionfruit của Cigar City Brewing có hương vị khá mới mẻ của nhiều loại trái cây thơm ngon, đảm bảo an toàn khác nhau.', 1, 1),
(23, 'Bia Hopslam', 3, 55000, '1', 'Mạch nha , Hoa Bia', 'Bia Hopslam của Bells Brewery được làm từ những hoa bia đặc biệt cho nên hương vị khá độc đáo. Nguyên liệu làm bia Hopslam của Bells Brewery còn có lúa mạch cùng mật ong đặc nguyên chất.', 0, 0),
(24, 'Bia Corona Extra', 3, 55000, '1', 'Mạch nha , Hoa Bia', 'Bia Corona chính hãng có nguồn gốc từ Mexico với độ cồn phổ biến <5 %. Bia mang lại cảm giác sảng khoái khi thưởng thức. Bia Corona Extra  có thể uống trực tiếp hoặc dùng để pha chế để gia tăng hương vị.', 0, 0),
(25, 'Bia Budweiser', 3, 40000, '1', 'Mạch nha , Hoa Bia', ' Bia Budweiser công thức lên men tự nhiên với nguyên liệu từ hoa bia cùng mạch nha chất lượng. Bia được nấu và ủ trong thùng gỗ sồi để đảm bảo hương vị thơm ngon nhất. Sản phẩm được đóng lon, chai tiện dụng.', 1, 0),
(26, 'Rau lẩu', 4, 20000, '1', 'Rau', 'Đồ ăn dùng làm món lẩu là: thịt, cá, lươn, rau, nấm, hải sản… Ở nhiều nơi, món lẩu thường được ăn vào mùa đông nhằm mục đích giữ thức ăn nóng sốt. Rau là thứ không thể thiếu trong nồi lẩu.', 0, 0),
(27, 'Nấm kim châm', 4, 35000, '1', 'Nắm', 'Nấm kim châm là một loài nấm màu trắng được sử dụng trong ẩm thực các nước châu Á như Nhật Bản, Trung Hoa, bán đảo Triều Tiên. Đây là giống trồng của Flammulina velutipes.', 0, 0),
(28, 'Hoa chuối', 4, 20000, '1', 'Hoa chuối', 'Hoa chuối cũng được xem là 1 loại rau khi ăn lẩu. Hoa chuối bóc bỏ các lớp bẹ già, thái mỏng, ngâm nước muối cho trắng giòn không còn vị chát, nhúng lẩu ăn rất ngon.', 0, 0),
(29, 'Rau muống', 4, 15000, '1', 'Rau muống', 'Thông dụng và phổ biến nhất, dễ mua và dễ tìm - Rau muống góp mặt hầu hết trong các nồi lẩu khác nhau chứ không riêng gì lẩu Thái.', 0, 0),
(30, 'Cải thảo', 4, 30000, '1', 'Cải thảo', 'Cải thảo là loại rau gắn liền với món kim chi. Loại rau này có vị nhạt hơn so với các loại rau khác nhưng lại có nhiều tác dụng với sức khỏe, đặc biệt trong cải thảo có chứa nhiều chất chứa ung thư..', 0, 0),
(31, 'Hoa súng', 4, 30000, '1', 'Hoa súng', 'Nghe có vẻ lạ nhưng cọng cây hoa súng tước vỏ, bẻ khúc nhúng lẩu ăn rất giòn và ngon. Người dân miền Tây Nam Bộ thường sử dụng cọng cây hoa súng như 1 loại rau ăn ghém.', 0, 0),
(32, 'Cải xoong', 4, 15000, '1', 'Cải xoong', 'Rau cải xoong đặc biệt tốt cho phụ nữ bởi nó chứa chất phòng chống ung thư cổ tử cung và ung thư vú. Cải xoong dai, giòn có tác dụng khai vị, kích thích hệ tiêu hóa nên cũng thường được dùng khi nhúng lẩu Thái..', 0, 0),
(33, 'Rau đắng', 4, 15000, '1', 'Rau đắng', ' Loại rau này phổ biến ở vùng đồng bằng sông Cửu Long, vốn nổi tiếng là 1 loại rau có cực kỳ nhiều tác dụng tốt cho sức khỏe như: chữa viêm gan vàng da, nóng trong người, nổi mề đay, nâng cao trí nhớ, cải thiện hoạt động trí tuệ... và rất nhiều các tác dụng khác.', 0, 0),
(34, 'Lẩu đuôi bò', 1, 250000, '1', 'Bò , rau', ' Đuôi bò là phần tập hợp tương đối nhiều chất xương, tủy, gân, da.. thịt. Đây là phần gần như là ngon nhất của Bò, Một nồi lẩu đuôi bò nghi ngút khói rất thích hợp cho các đấng mày râu ngồi “nhâm nhi” vào những ngày cuối tuần hay những ngày rét mướt.', 0, 0),
(35, 'Lẩu riêu cua', 1, 240000, '1', 'Cua , bắp bò', 'Riêu cua thơm lừng, chua dịu nhờ sấu/me và giấm bỗng, màu đỏ của cà chua, vàng của đậu rán và gạch cua thêm màu xanh mướt của rau sống và rau xanh ăn kèm khiến cho nồi lẩu riêu cua bắp bò sườn sụn trở nên cực kỳ hấp dẫn.', 1, 0),
(36, 'Bê nhúng dấm', 1, 180000, '1', 'Bê , rau', 'Món ăn đặc sản của Đà Nẵng, với thịt bê mềm và ngọt được chọn lựa kỹ lưỡng, nước dùng đặc trưng được ninh từ xương bò thật kỹ, thêm nếm đúng gia vị cùng dừa tươi, sả, dứa, gừng, hành, ớt, với chút dấm gạo mang đến vị thanh thanh dịu ngọt.', 0, 0),
(37, 'Lẩu gà bỗng rượu', 1, 280000, '1', 'Gà , thịt', 'Lẩu gà bỗng rượu vừa có vị chua nhẹ, cay cay, the the, lại thêm mùi tàu, hành hoa, là vị ngọt thơm của gà, hàm lượng dinh dưỡng cực kỳ cao ngon trong những ngày trời lạnh.', 0, 0),
(38, 'Lẩu Thái hải sản', 1, 280000, '1', 'Tôm , mực', 'Lẩu Thái hải sản mang một hương vị khác biệt không lẫn với bất kỳ món lẩu nào khác bởi vị nước lẩu chua chua cay cay, với hương thơm của riềng, xả nhúng kèm với các loại rau và hải sản tươi sống.', 1, 0),
(109, 'Lẩu thái', 1, 200000, '1', 'Thịt bò , tôm', 'Lẩu Thái là món ăn được yêu thích với hương vị chua chua, cay cay quyến rũ. Vào thời tiết se lạnh hay những ngày mưa, món ăn này lại được người người, nhà nhà ưa thích hơn cả. ', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `product_type`
--

CREATE TABLE `product_type` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `image` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product_type`
--

INSERT INTO `product_type` (`id`, `name`, `image`) VALUES
(1, 'Lẩu', 'https://scripee.com/wp-content/uploads/2019/05/cach-trinh-bay-lau-hai-san-4.jpg'),
(2, 'Thức Ăn Thêm', 'https://cdn.jamja.vn/blog/wp-content/uploads/2017/10/lau-thap-cam-gom-nhung-gi6.jpg'),
(3, 'Nước Uống', 'https://toplist.vn/images/800px/bia-up-nguoc-go-vap-upside-down-308976.jpg'),
(4, 'Rau Thêm', 'https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQrU7-HmNAnPBeIVsO7Uk5fPx2UDQY1x2dznXhPmaN8qSIwUqG7&usqp=CAU');

-- --------------------------------------------------------

--
-- Table structure for table `ratings`
--

CREATE TABLE `ratings` (
  `id_ratings` int(11) NOT NULL,
  `id_product` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `star` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ratings`
--

INSERT INTO `ratings` (`id_ratings`, `id_product`, `user_id`, `star`) VALUES
(1, 37, 8, 5),
(2, 37, 8, 5),
(3, 37, 8, 3),
(4, 37, 8, 3),
(5, 37, 8, 3),
(6, 37, 8, 3),
(7, 37, 8, 3),
(8, 37, 8, 3),
(9, 37, 8, 3),
(10, 37, 8, 3),
(23, 109, 8, 5),
(25, 109, 8, 4);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `user_name` (`user_name`);

--
-- Indexes for table `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`id`),
  ADD KEY `f1` (`id_customer`);

--
-- Indexes for table `bill_detail`
--
ALTER TABLE `bill_detail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `f2` (`id_bill`),
  ADD KEY `f3` (`id_product`);

--
-- Indexes for table `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`id_comment`),
  ADD KEY `fk_account_comments` (`user_id`),
  ADD KEY `fk_product_comments` (`id_product`);

--
-- Indexes for table `images`
--
ALTER TABLE `images`
  ADD PRIMARY KEY (`id`),
  ADD KEY `f5` (`id_product`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `f4` (`id_type`);

--
-- Indexes for table `product_type`
--
ALTER TABLE `product_type`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ratings`
--
ALTER TABLE `ratings`
  ADD PRIMARY KEY (`id_ratings`),
  ADD KEY `fk_account_ratings` (`user_id`),
  ADD KEY `fk_product_ratings` (`id_product`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `bill`
--
ALTER TABLE `bill`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=139;

--
-- AUTO_INCREMENT for table `bill_detail`
--
ALTER TABLE `bill_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=120;

--
-- AUTO_INCREMENT for table `comment`
--
ALTER TABLE `comment`
  MODIFY `id_comment` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=78;

--
-- AUTO_INCREMENT for table `images`
--
ALTER TABLE `images`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=167;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=111;

--
-- AUTO_INCREMENT for table `product_type`
--
ALTER TABLE `product_type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `ratings`
--
ALTER TABLE `ratings`
  MODIFY `id_ratings` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bill`
--
ALTER TABLE `bill`
  ADD CONSTRAINT `fk_account_bill` FOREIGN KEY (`id_customer`) REFERENCES `account` (`user_id`);

--
-- Constraints for table `bill_detail`
--
ALTER TABLE `bill_detail`
  ADD CONSTRAINT `f2` FOREIGN KEY (`id_bill`) REFERENCES `bill` (`id`),
  ADD CONSTRAINT `f3` FOREIGN KEY (`id_product`) REFERENCES `product` (`id`);

--
-- Constraints for table `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `fk_account_comments` FOREIGN KEY (`user_id`) REFERENCES `account` (`user_id`),
  ADD CONSTRAINT `fk_product_comments` FOREIGN KEY (`id_product`) REFERENCES `product` (`id`);

--
-- Constraints for table `images`
--
ALTER TABLE `images`
  ADD CONSTRAINT `f5` FOREIGN KEY (`id_product`) REFERENCES `product` (`id`);

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `f4` FOREIGN KEY (`id_type`) REFERENCES `product_type` (`id`);

--
-- Constraints for table `ratings`
--
ALTER TABLE `ratings`
  ADD CONSTRAINT `fk_account_ratings` FOREIGN KEY (`user_id`) REFERENCES `account` (`user_id`),
  ADD CONSTRAINT `fk_product_ratings` FOREIGN KEY (`id_product`) REFERENCES `product` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
