/*
 Navicat Premium Data Transfer

 Source Server         : zw
 Source Server Type    : MySQL
 Source Server Version : 50624
 Source Host           : localhost:3306
 Source Schema         : cppfoto

 Target Server Type    : MySQL
 Target Server Version : 50624
 File Encoding         : 65001

 Date: 25/06/2021 20:31:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `createDate` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `likeCount` int(11) NULL DEFAULT 0,
  `collectionNum` int(11) NULL DEFAULT 0,
  `categoryId` int(11) NULL DEFAULT NULL,
  `imagesNum` int(11) NULL DEFAULT 1,
  `userId` int(11) NULL DEFAULT NULL,
  `source` int(11) NULL DEFAULT NULL,
  `status` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES (9, 'asdqwe', 'asdadqwe', '2021-06-22 18:30:56', 0, 0, 1, 1, 9, 1, NULL);
INSERT INTO `article` VALUES (10, 'asdjio', 'asdadwqa看看', '2021-06-25 15:38:58', 3, 0, 2, 1, 9, 1, NULL);
INSERT INTO `article` VALUES (11, '大苏打', '大苏打青蛙的青蛙', '2021-06-25 16:00:11', 1, 1, 8, 1, 9, 2, NULL);
INSERT INTO `article` VALUES (12, 'jkhjbj', 'ljkhkjg', '2021-06-23 10:37:33', 0, 0, 1, 1, 9, 1, NULL);
INSERT INTO `article` VALUES (13, 'sdaweqs', 'sadqweascd', '2021-06-23 10:43:36', 0, 0, 2, 1, 9, 2, NULL);
INSERT INTO `article` VALUES (14, 'asdqweq', 'asdqwsadasda', '2021-06-23 10:43:15', 0, 0, 1, 1, 9, 2, NULL);
INSERT INTO `article` VALUES (15, 'kljljklads', 'asdwewerftrgtgrr', '2021-06-23 11:57:38', 0, 0, 1, 1, 9, 1, NULL);
INSERT INTO `article` VALUES (16, '阿斯达萨阿', '阿斯达的', '2021-06-23 15:03:13', 0, 0, 1, 1, 9, 1, NULL);
INSERT INTO `article` VALUES (17, 'asdasd', 'asdqweasd', '2021-06-23 16:34:42', 0, 0, 2, 1, 9, 2, NULL);
INSERT INTO `article` VALUES (18, 'kjgjyhfg', 'adsada', '2021-06-23 16:55:38', 0, 0, 1, 1, 9, 2, NULL);
INSERT INTO `article` VALUES (19, 'ASDA', 'ASDQWEQWEASD', '2021-06-23 17:34:39', 0, 0, 14, 1, 9, 1, NULL);
INSERT INTO `article` VALUES (20, 'hgjuyjuyju', 'asdwqrwqdsfsf', '2021-06-25 11:18:23', 1, 0, 9, 3, 9, 1, NULL);

SET FOREIGN_KEY_CHECKS = 1;
