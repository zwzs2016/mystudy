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

 Date: 25/06/2021 20:32:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mail` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `birthday` datetime NULL DEFAULT NULL,
  `fixedPhone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `unit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `region` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `postcode` int(11) NULL DEFAULT NULL,
  `cameraName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cameraModel` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phoneNum` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `imagesId` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (9, 'cppfto', '123456', '1025444565@qq.com', '张三', '\0', '2021-06-10 00:00:00', '1325465', '武汉', '武汉江夏', '16602771467', 430000, '卡西欧', '16dd', '16602771467', 40);
INSERT INTO `user` VALUES (10, 'ckttp', '123456', '3175974121@qq.com', '李四', '男', '1998-07-17 00:00:00', '12355899', '武汉皇家', '江夏', '马甸社区', 469999, '玛米亚', '22dd', '1234567899', NULL);
INSERT INTO `user` VALUES (12, 'jerry', '123456', '12345678@qq.com', '王五', '女', '2021-06-09 00:00:00', '1588899745', '武汉', '武汉', '武汉', 156548, '哈苏', '16dd', '15466978841', NULL);

SET FOREIGN_KEY_CHECKS = 1;
