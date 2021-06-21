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

 Date: 21/06/2021 20:34:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `directory` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, '提问', '嘚瑟一下');
INSERT INTO `category` VALUES (2, '萌宠', '嘚瑟一下');
INSERT INTO `category` VALUES (3, '禽兽', '嘚瑟一下');
INSERT INTO `category` VALUES (4, '消息', '嘚瑟一下');
INSERT INTO `category` VALUES (5, '景儿', '嘚瑟一下');
INSERT INTO `category` VALUES (6, '乡下', '嘚瑟一下');
INSERT INTO `category` VALUES (7, '男人', '嘚瑟一下');
INSERT INTO `category` VALUES (8, '女人', '嘚瑟一下');
INSERT INTO `category` VALUES (9, '娃娃', '嘚瑟一下');
INSERT INTO `category` VALUES (10, '家当', '嘚瑟一下');
INSERT INTO `category` VALUES (11, '说说', '嘚瑟一下');
INSERT INTO `category` VALUES (12, '嘚瑟', '嘚瑟一下');
INSERT INTO `category` VALUES (13, '吃货', '嘚瑟一下');
INSERT INTO `category` VALUES (14, '花儿', '嘚瑟一下');

SET FOREIGN_KEY_CHECKS = 1;
