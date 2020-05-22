/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.0.10-root-root
 Source Server Type    : MySQL
 Source Server Version : 50640
 Source Host           : 192.168.0.10:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50640
 File Encoding         : 65001

 Date: 22/05/2020 15:45:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for m_b_p_user 对应 com.lc.pojo.MBPUser
-- ----------------------------
DROP TABLE IF EXISTS `m_b_p_user`;
CREATE TABLE `m_b_p_user`  (
  `id` bigint(20) NOT NULL COMMENT '主鍵ID',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `age` int(11) NULL DEFAULT NULL COMMENT '年齡',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `version` int(255) NULL DEFAULT 0 COMMENT '乐观锁',
  `deleted` int(255) NULL DEFAULT 0 COMMENT '逻辑删除',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of m_b_p_user
-- ----------------------------
INSERT INTO `m_b_p_user` VALUES (1263667861894451201, '关注公众号：ahviplc', 20, '110@qq.com', 0, 0, '2020-05-22 11:07:51', '2020-05-22 11:11:20');

SET FOREIGN_KEY_CHECKS = 1;
