/*
Navicat MySQL Data Transfer

Source Server         : mycon
Source Server Version : 80029
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 80029
File Encoding         : 65001

Date: 2023-01-17 09:54:32
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int NOT NULL AUTO_INCREMENT,
  `gname` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_unicode_ci DEFAULT NULL,
  `gprice` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO goods VALUES ('1', '号商品', '100');
INSERT INTO goods VALUES ('2', 'aaa', '23');
INSERT INTO goods VALUES ('3', '3', '33');
INSERT INTO goods VALUES ('4', '4', '44');
INSERT INTO goods VALUES ('5', '花生101', '101');
INSERT INTO goods VALUES ('6', '花生102', '102');
INSERT INTO goods VALUES ('7', '花生103', '103');
INSERT INTO goods VALUES ('8', '花生104', '104');
INSERT INTO goods VALUES ('9', '花生105', '105');
