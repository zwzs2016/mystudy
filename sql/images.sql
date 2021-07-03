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

 Date: 03/07/2021 17:50:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for images
-- ----------------------------
DROP TABLE IF EXISTS `images`;
CREATE TABLE `images`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `imgurl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `articleId` int(11) NULL DEFAULT NULL,
  `videoId` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of images
-- ----------------------------
INSERT INTO `images` VALUES (1, '0/0.jpg', NULL, 1);
INSERT INTO `images` VALUES (2, '0/1.jpg', NULL, 2);
INSERT INTO `images` VALUES (3, '0/2.jpg', NULL, 3);
INSERT INTO `images` VALUES (4, '0/3.jpg', NULL, 4);
INSERT INTO `images` VALUES (5, '0/4.jpg', NULL, 5);
INSERT INTO `images` VALUES (6, '0/5.jpg', NULL, 6);
INSERT INTO `images` VALUES (7, '3/0.jpg', NULL, 7);
INSERT INTO `images` VALUES (8, '3/1.jpg', NULL, 8);
INSERT INTO `images` VALUES (9, '3/2.jpg', NULL, 9);
INSERT INTO `images` VALUES (10, '3/3.jpg', NULL, 10);

SET FOREIGN_KEY_CHECKS = 1;
