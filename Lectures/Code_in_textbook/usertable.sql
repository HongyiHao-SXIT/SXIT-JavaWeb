/*
Navicat MySQL Data Transfer

Source Server         : mycon
Source Server Version : 80029
Source Host           : localhost:3306
Source Database       : springtest

Target Server Type    : MYSQL
Target Server Version : 80029
File Encoding         : 65001

Date: 2023-01-20 16:53:33
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `usertable`
-- ----------------------------
DROP TABLE IF EXISTS `usertable`;
CREATE TABLE `usertable` (
  `uname` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `upwd` varchar(100) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`uname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of usertable
-- ----------------------------
INSERT INTO usertable VALUES ('111', '111');
INSERT INTO usertable VALUES ('chenheng1', '111');
INSERT INTO usertable VALUES ('chenheng2', '222');
INSERT INTO usertable VALUES ('chenheng3', '333');
INSERT INTO usertable VALUES ('chenheng4', '444');
