/*
 Navicat Premium Data Transfer

 Source Server         : zw
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : cppfoto

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 04/07/2021 21:07:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pay` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `categoryId` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of video
-- ----------------------------
INSERT INTO `video` VALUES (1, '拿相机的姿势', NULL, NULL, 24);
INSERT INTO `video` VALUES (2, '手表拍摄', NULL, NULL, 24);
INSERT INTO `video` VALUES (3, '单反', NULL, NULL, 24);
INSERT INTO `video` VALUES (4, '夜晚', NULL, NULL, 24);
INSERT INTO `video` VALUES (5, '摄影', NULL, NULL, 24);
INSERT INTO `video` VALUES (6, '小吴哥', NULL, NULL, 24);
INSERT INTO `video` VALUES (7, '魔幻光影-暮秋后期', '<p>作者简介：<br>昵称：马舍雨<br>真名：马舒<br>职业：亮室文化传播有限公司教学部主任<br>微博：腾讯微博16765826<br>星座：射手座<br>爱好：摄影<br>座右铭：舍得<br>获奖：<br>2013年俄罗斯贝雷加国际摄影展获得银奖；<br>2013年首届希腊4地巡回国际摄影艺术展获得金奖；<br>2013年全国华盖创意摄影大赛获得一等奖；<br>2013年中国“伯奇杯”创意摄影大赛图虫赛区一等奖，总决赛优秀奖。</p>', '10', 27);
INSERT INTO `video` VALUES (8, '魔幻光影-生机后期', '<p>作者简介：<br>昵称：马舍雨<br>真名：马舒<br>职业：亮室文化传播有限公司教学部主任<br>微博：腾讯微博16765826<br>星座：射手座<br>爱好：摄影<br>座右铭：舍得<br>获奖：<br>2013年俄罗斯贝雷加国际摄影展获得银奖；<br>2013年首届希腊4地巡回国际摄影艺术展获得金奖；<br>2013年全国华盖创意摄影大赛获得一等奖；<br>2013年中国“伯奇杯”创意摄影大赛图虫赛区一等奖，总决赛优秀奖。</p>', '10', 27);
INSERT INTO `video` VALUES (9, '魔幻光影-坚实后期', '<p>作者简介：<br>昵称：马舍雨<br>真名：马舒<br>职业：亮室文化传播有限公司教学部主任<br>微博：腾讯微博16765826<br>星座：射手座<br>爱好：摄影<br>座右铭：舍得<br>获奖：<br>2013年俄罗斯贝雷加国际摄影展获得银奖；<br>2013年首届希腊4地巡回国际摄影艺术展获得金奖；<br>2013年全国华盖创意摄影大赛获得一等奖；<br>2013年中国“伯奇杯”创意摄影大赛图虫赛区一等奖，总决赛优秀奖。</p>', '10', 27);
INSERT INTO `video` VALUES (10, '魔幻光影-薄纱后期', '<p>作者简介：<br>昵称：马舍雨<br>真名：马舒<br>职业：亮室文化传播有限公司教学部主任<br>微博：腾讯微博16765826<br>星座：射手座<br>爱好：摄影<br>座右铭：舍得<br>获奖：<br>2013年俄罗斯贝雷加国际摄影展获得银奖；<br>2013年首届希腊4地巡回国际摄影艺术展获得金奖；<br>2013年全国华盖创意摄影大赛获得一等奖；<br>2013年中国“伯奇杯”创意摄影大赛图虫赛区一等奖，总决赛优秀奖。</p>', '10', 27);

SET FOREIGN_KEY_CHECKS = 1;
