/*
Navicat MySQL Data Transfer

Source Server         : LOCAL
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : myblog

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2016-05-31 23:30:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tbblogarticles
-- ----------------------------
DROP TABLE IF EXISTS `tbblogarticles`;
CREATE TABLE `tbblogarticles` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`title`  varchar(225) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`content`  longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`userid`  int(11) NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=6

;

-- ----------------------------
-- Records of tbblogarticles
-- ----------------------------
BEGIN;
INSERT INTO `tbblogarticles` VALUES ('1', '这个是博客测试标题1', '博客内容测试1', null), ('2', '这个是博客测试标题2', '博客内容测试2', null), ('3', '这个是博客测试标题3', '博客内容测试3', null), ('4', '这个是博客测试标题4', '博客内容测试4', null), ('5', '这个是博客测试标题5', '博客内容测试5', null);
COMMIT;

-- ----------------------------
-- Table structure for tbop01t
-- ----------------------------
DROP TABLE IF EXISTS `tbop01t`;
CREATE TABLE `tbop01t` (
`id`  int(11) NULL DEFAULT NULL ,
`title`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`content`  longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`updatedatetime`  datetime NULL DEFAULT NULL ,
`createdatetime`  datetime NULL DEFAULT NULL ,
`userid`  int(11) NULL DEFAULT NULL 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of tbop01t
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for tbuser
-- ----------------------------
DROP TABLE IF EXISTS `tbuser`;
CREATE TABLE `tbuser` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`username`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`password`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=2

;

-- ----------------------------
-- Records of tbuser
-- ----------------------------
BEGIN;
INSERT INTO `tbuser` VALUES ('1', 'yang', '1234');
COMMIT;

-- ----------------------------
-- Auto increment value for tbblogarticles
-- ----------------------------
ALTER TABLE `tbblogarticles` AUTO_INCREMENT=6;

-- ----------------------------
-- Auto increment value for tbuser
-- ----------------------------
ALTER TABLE `tbuser` AUTO_INCREMENT=2;
