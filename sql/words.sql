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

 Date: 25/06/2021 20:32:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for words
-- ----------------------------
DROP TABLE IF EXISTS `words`;
CREATE TABLE `words`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `contents` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `articleId` int(11) NULL DEFAULT NULL,
  `createDate` datetime NULL DEFAULT NULL,
  `userId` int(11) NULL DEFAULT NULL,
  `status` int(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '留言表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of words
-- ----------------------------
INSERT INTO `words` VALUES (3, 'dasadsa', 10, '2021-06-25 07:01:40', 9, NULL);
INSERT INTO `words` VALUES (4, 'asdasdqweq', 10, '2021-06-25 07:03:17', 9, NULL);
INSERT INTO `words` VALUES (5, 'dasdadad', 11, '2021-06-25 07:39:25', 9, NULL);
INSERT INTO `words` VALUES (6, 'ascasdqwe', 11, '2021-06-25 07:39:36', 9, NULL);

SET FOREIGN_KEY_CHECKS = 1;
