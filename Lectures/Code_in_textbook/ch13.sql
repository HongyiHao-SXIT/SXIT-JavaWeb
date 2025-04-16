/*
Navicat MySQL Data Transfer

Source Server         : mycon
Source Server Version : 80029
Source Host           : localhost:3306
Source Database       : ch13

Target Server Type    : MYSQL
Target Server Version : 80029
File Encoding         : 65001

Date: 2023-01-19 15:46:55
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `ausertable`
-- ----------------------------
DROP TABLE IF EXISTS `ausertable`;
CREATE TABLE `ausertable` (
  `id` int NOT NULL AUTO_INCREMENT,
  `aname` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_unicode_ci NOT NULL,
  `apwd` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of ausertable
-- ----------------------------
INSERT INTO ausertable VALUES ('1', 'admin', 'admin');

-- ----------------------------
-- Table structure for `busertable`
-- ----------------------------
DROP TABLE IF EXISTS `busertable`;
CREATE TABLE `busertable` (
  `id` int NOT NULL AUTO_INCREMENT,
  `bemail` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_unicode_ci NOT NULL,
  `bpwd` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of busertable
-- ----------------------------
INSERT INTO busertable VALUES ('1', 'chenheng@126.com', '78f8a7ae700c91db09facb05a675432b');
INSERT INTO busertable VALUES ('2', 'chenheng@163.com', '78f8a7ae700c91db09facb05a675432b');
INSERT INTO busertable VALUES ('3', '123@126.com', '45da70bfee747eeeae4163b2bb524ce8');

-- ----------------------------
-- Table structure for `carttable`
-- ----------------------------
DROP TABLE IF EXISTS `carttable`;
CREATE TABLE `carttable` (
  `id` int NOT NULL AUTO_INCREMENT,
  `busertable_id` int NOT NULL,
  `goodstable_id` int NOT NULL,
  `shoppingnum` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `bid` (`busertable_id`),
  KEY `gno` (`goodstable_id`),
  CONSTRAINT `bid` FOREIGN KEY (`busertable_id`) REFERENCES `busertable` (`id`),
  CONSTRAINT `gno` FOREIGN KEY (`goodstable_id`) REFERENCES `goodstable` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of carttable
-- ----------------------------

-- ----------------------------
-- Table structure for `focustable`
-- ----------------------------
DROP TABLE IF EXISTS `focustable`;
CREATE TABLE `focustable` (
  `id` int NOT NULL AUTO_INCREMENT,
  `goodstable_id` int NOT NULL,
  `busertable_id` int NOT NULL,
  `focustime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `gno1` (`goodstable_id`),
  KEY `bid1` (`busertable_id`),
  CONSTRAINT `bid1` FOREIGN KEY (`busertable_id`) REFERENCES `busertable` (`id`),
  CONSTRAINT `gno1` FOREIGN KEY (`goodstable_id`) REFERENCES `goodstable` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of focustable
-- ----------------------------
INSERT INTO focustable VALUES ('1', '10', '1', '2022-12-13 09:25:36');
INSERT INTO focustable VALUES ('2', '12', '1', '2023-01-19 06:20:48');
INSERT INTO focustable VALUES ('3', '9', '1', '2023-01-19 06:20:59');

-- ----------------------------
-- Table structure for `goodstable`
-- ----------------------------
DROP TABLE IF EXISTS `goodstable`;
CREATE TABLE `goodstable` (
  `id` int NOT NULL AUTO_INCREMENT,
  `gname` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_unicode_ci DEFAULT NULL,
  `goprice` double DEFAULT NULL,
  `grprice` double DEFAULT NULL,
  `gstore` int DEFAULT NULL,
  `gpicture` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_unicode_ci DEFAULT NULL,
  `goodstype_id` int DEFAULT NULL,
  `isshow` tinyint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `typeid` (`goodstype_id`),
  CONSTRAINT `typeid` FOREIGN KEY (`goodstype_id`) REFERENCES `goodstype` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of goodstable
-- ----------------------------
INSERT INTO goodstable VALUES ('1', '苹果', '10', '8', '1000', '1016740838.jpg', '2', '1');
INSERT INTO goodstable VALUES ('2', '鲜花88', '20', '10', '3000', '5148538886.jpg', '5', '1');
INSERT INTO goodstable VALUES ('3', '鲜花99', '40', '30', '300', '7177403942.jpg', '5', '1');
INSERT INTO goodstable VALUES ('4', '苹果', '20', '16', '5995', '4883469910.jpg', '1', '0');
INSERT INTO goodstable VALUES ('5', '化妆品1', '20', '16', '20000', '7577995059.jpg', '6', '0');
INSERT INTO goodstable VALUES ('7', '化妆品66', '700', '500', '8000', '7221275299.jpg', '6', '0');
INSERT INTO goodstable VALUES ('8', '鲜花999', '80', '60', '5000', '5375449964.jpg', '5', '0');
INSERT INTO goodstable VALUES ('9', '微波炉88', '500', '400', '2962', '7448750635.jpg', '3', '0');
INSERT INTO goodstable VALUES ('10', '服装88', '800', '700', '39990', '3311730361.jpg', '1', '0');
INSERT INTO goodstable VALUES ('11', '鲜花1111', '40', '27', '4000', '6427191988.jpg', '5', '1');
INSERT INTO goodstable VALUES ('12', '鲜花2222', '40', '16', '3000', '9020898346.png', '5', '1');

-- ----------------------------
-- Table structure for `goodstype`
-- ----------------------------
DROP TABLE IF EXISTS `goodstype`;
CREATE TABLE `goodstype` (
  `id` int NOT NULL AUTO_INCREMENT,
  `typename` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of goodstype
-- ----------------------------
INSERT INTO goodstype VALUES ('1', '服装');
INSERT INTO goodstype VALUES ('2', '水果');
INSERT INTO goodstype VALUES ('3', '家电');
INSERT INTO goodstype VALUES ('4', '文具');
INSERT INTO goodstype VALUES ('5', '鲜花');
INSERT INTO goodstype VALUES ('6', '化妆品');
INSERT INTO goodstype VALUES ('7', '孕婴');
INSERT INTO goodstype VALUES ('9', '电子');

-- ----------------------------
-- Table structure for `orderbasetable`
-- ----------------------------
DROP TABLE IF EXISTS `orderbasetable`;
CREATE TABLE `orderbasetable` (
  `id` int NOT NULL AUTO_INCREMENT,
  `busertable_id` int NOT NULL,
  `amount` double NOT NULL,
  `status` tinyint NOT NULL,
  `orderdate` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `bid2` (`busertable_id`),
  CONSTRAINT `bid2` FOREIGN KEY (`busertable_id`) REFERENCES `busertable` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of orderbasetable
-- ----------------------------
INSERT INTO orderbasetable VALUES ('1', '1', '4000', '1', '2022-12-13 08:37:09');
INSERT INTO orderbasetable VALUES ('2', '1', '3200', '0', '2022-12-13 09:26:40');
INSERT INTO orderbasetable VALUES ('3', '1', '5000', '1', '2022-02-02 10:34:03');
INSERT INTO orderbasetable VALUES ('4', '1', '8000', '1', '2022-03-11 14:38:33');
INSERT INTO orderbasetable VALUES ('5', '1', '1000', '1', '2022-12-09 14:39:04');
INSERT INTO orderbasetable VALUES ('6', '1', '6000', '1', '2020-07-31 14:39:21');
INSERT INTO orderbasetable VALUES ('7', '1', '5000', '1', '2022-06-15 14:39:41');
INSERT INTO orderbasetable VALUES ('8', '1', '4000', '1', '2022-07-15 14:40:00');
INSERT INTO orderbasetable VALUES ('12', '1', '4000', '0', '2022-12-15 18:58:06');
INSERT INTO orderbasetable VALUES ('13', '1', '7080', '1', '2023-01-19 15:43:32');
INSERT INTO orderbasetable VALUES ('14', '1', '4000', '1', '2023-01-19 15:45:54');

-- ----------------------------
-- Table structure for `orderdetail`
-- ----------------------------
DROP TABLE IF EXISTS `orderdetail`;
CREATE TABLE `orderdetail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `orderbasetable_id` int NOT NULL,
  `goodstable_id` int NOT NULL,
  `shoppingnum` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `odsn` (`orderbasetable_id`),
  KEY `gno3` (`goodstable_id`),
  CONSTRAINT `gno3` FOREIGN KEY (`goodstable_id`) REFERENCES `goodstable` (`id`),
  CONSTRAINT `odsn` FOREIGN KEY (`orderbasetable_id`) REFERENCES `orderbasetable` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of orderdetail
-- ----------------------------
INSERT INTO orderdetail VALUES ('1', '1', '9', '10');
INSERT INTO orderdetail VALUES ('2', '2', '9', '8');
INSERT INTO orderdetail VALUES ('3', '3', '1', '20');
INSERT INTO orderdetail VALUES ('4', '5', '2', '30');
INSERT INTO orderdetail VALUES ('5', '4', '3', '10');
INSERT INTO orderdetail VALUES ('6', '5', '4', '4');
INSERT INTO orderdetail VALUES ('7', '6', '5', '4');
INSERT INTO orderdetail VALUES ('8', '4', '10', '5');
INSERT INTO orderdetail VALUES ('9', '7', '8', '3');
INSERT INTO orderdetail VALUES ('10', '8', '7', '5');
INSERT INTO orderdetail VALUES ('11', '12', '9', '10');
INSERT INTO orderdetail VALUES ('12', '13', '10', '10');
INSERT INTO orderdetail VALUES ('13', '13', '4', '5');
INSERT INTO orderdetail VALUES ('15', '14', '9', '10');
