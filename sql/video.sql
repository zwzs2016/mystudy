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

 Date: 01/07/2021 17:48:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `imgurl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `categoryId` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of video
-- ----------------------------
INSERT INTO `video` VALUES (1, '拿相机的姿势', '0/0.jpg', 24);
INSERT INTO `video` VALUES (2, '手表拍摄', '0/1.jpg', 24);
INSERT INTO `video` VALUES (3, '单反', '0/2.jpg', 24);
INSERT INTO `video` VALUES (4, '夜晚', '0/3.jpg', 24);
INSERT INTO `video` VALUES (5, '摄影', '0/4.jpg', 24);
INSERT INTO `video` VALUES (6, '小吴哥', '0/5.jpg', 24);

SET FOREIGN_KEY_CHECKS = 1;
