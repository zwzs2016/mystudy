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

 Date: 25/06/2021 20:32:00
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
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 41 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of images
-- ----------------------------
INSERT INTO `images` VALUES (1, '/2021/06/21/3f18834e-8e98-4300-b284-c83a6da9e401.jpg', NULL);
INSERT INTO `images` VALUES (2, '/2021/06/21/2df80df8-1b5b-42c2-bd37-04788f59a1c9.jpg', NULL);
INSERT INTO `images` VALUES (3, '/2021/06/21/f9c6a95b-1c71-4044-8237-58dcdb922f6f.jpg', NULL);
INSERT INTO `images` VALUES (4, '/2021/06/21/d6b05dce-5e58-4f3c-a44c-592d11a8348c.jpg', NULL);
INSERT INTO `images` VALUES (5, '/2021/06/21/42a0c0ad-193c-4994-b275-fe9fbf8e147c.jpg', NULL);
INSERT INTO `images` VALUES (6, '/2021/06/21/07ed9134-9c9a-47df-b8e9-d71de3e5bccf.jpg', NULL);
INSERT INTO `images` VALUES (7, '/2021/06/21/6f52f54d-7b99-412f-a8be-0e7fc4744d55.jpg', NULL);
INSERT INTO `images` VALUES (8, '/2021/06/21/e8389bf7-cb6b-40b5-8e5e-76e3fd8cce87.jpg', NULL);
INSERT INTO `images` VALUES (9, '/2021/06/21/d78d6275-dc56-40c3-8170-c3393f2afbd1.jpg', NULL);
INSERT INTO `images` VALUES (10, '/2021/06/21/a0cf156f-8c8a-4bde-9c32-135beee54a0f.jpg', NULL);
INSERT INTO `images` VALUES (11, '/2021/06/21/29450aa6-5727-412e-9f25-382df40d3fe7.jpg', NULL);
INSERT INTO `images` VALUES (12, '/2021/06/21/2a37c85e-00d4-4490-94ca-27c1bea4865d.jpg', NULL);
INSERT INTO `images` VALUES (13, '/2021/06/21/98ad8f77-bf67-4628-8349-6f29614c1088.jpg', NULL);
INSERT INTO `images` VALUES (14, '/2021/06/21/10139947-5179-4939-b4ea-351256e73c9f.jpg', NULL);
INSERT INTO `images` VALUES (15, '/2021/06/21/805b387c-1082-4376-a0b9-3f9d801cb318.jpg', NULL);
INSERT INTO `images` VALUES (16, '/2021/06/21/a466c8b8-d163-4460-b31d-0977f8c32844.jpg', 9);
INSERT INTO `images` VALUES (17, '/2021/06/21/91366e26-d2f7-4a10-a6a9-c306bf77da2b.jpg', 10);
INSERT INTO `images` VALUES (18, '/2021/06/21/73c9d805-c097-4055-8ec4-2075649ef6fa.jpg', 11);
INSERT INTO `images` VALUES (19, '/2021/06/23/2fa8b12c-8e67-4b3d-a8c5-fa5f7dff56d5.jpg', 12);
INSERT INTO `images` VALUES (20, '/2021/06/23/7d4dc0c2-7c70-468e-ac42-d4173584b70f.jpg', 13);
INSERT INTO `images` VALUES (21, '/2021/06/23/c28db648-68f7-4f92-b8c7-d8100df9906c.jpg', 14);
INSERT INTO `images` VALUES (22, '/2021/06/23/6925cd8c-3dec-474c-96eb-b92110d346e0.jpg', NULL);
INSERT INTO `images` VALUES (23, '/2021/06/23/795a39f1-e70c-4f6f-a471-c3b1f0788268.jpg', NULL);
INSERT INTO `images` VALUES (24, '/2021/06/23/5e1eb00a-0a4b-497f-95c9-999587408817.jpg', NULL);
INSERT INTO `images` VALUES (25, '/2021/06/23/7ee49eb2-1add-448c-9439-e56e99591bad.jpg', NULL);
INSERT INTO `images` VALUES (26, '/2021/06/23/1d499f12-fe43-4c1c-a8d0-a45b27a19ea8.jpg', NULL);
INSERT INTO `images` VALUES (27, '/2021/06/23/230f76c3-1d2f-4808-b998-b57b45a0c9ee.jpg', NULL);
INSERT INTO `images` VALUES (28, '/2021/06/23/a8914911-0f80-465b-819d-7c368890602b.jpg', NULL);
INSERT INTO `images` VALUES (29, '/2021/06/23/09303803-df68-4bca-bee0-6934d7d91fcb.jpg', 16);
INSERT INTO `images` VALUES (30, '/2021/06/23/d99e651b-668d-41b8-8936-d60e0f7d1f21.jpg', 17);
INSERT INTO `images` VALUES (31, '/2021/06/23/194c14a3-76af-45e4-a575-a1359c9b19f9.jpg', 18);
INSERT INTO `images` VALUES (32, '/2021/06/23/791a63de-7c8c-44d9-a449-eecd4a6f52f7.jpg', 19);
INSERT INTO `images` VALUES (33, '/2021/06/23/28a74cda-4419-4bab-b7a5-103d792154d2.jpg', 19);
INSERT INTO `images` VALUES (34, '/2021/06/23/90deb38d-5c61-4c88-8870-cb20f3558295.jpg', 19);
INSERT INTO `images` VALUES (35, '/2021/06/23/d2f1cb9d-6bcb-4572-821a-5148d4841c7c.jpg', 20);
INSERT INTO `images` VALUES (36, '/2021/06/23/636d5487-e680-4226-b427-833fa3635cfc.jpg', 20);
INSERT INTO `images` VALUES (37, '/2021/06/23/6dd8d98a-d3fa-485e-9429-8ea1eb51b55c.jpg', 20);
INSERT INTO `images` VALUES (38, '/2021/06/23/bb329612-e002-448a-bd50-a73d92025b38.jpg', NULL);
INSERT INTO `images` VALUES (39, '/2021/06/23/cee08905-dcc9-4059-ade1-a9e5973bb582.jpg', NULL);
INSERT INTO `images` VALUES (40, '/2021/06/23/55a11293-2240-4289-bc5e-20d4ea4aec96.jpg', NULL);

SET FOREIGN_KEY_CHECKS = 1;
