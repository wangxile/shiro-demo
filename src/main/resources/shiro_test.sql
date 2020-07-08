/*
Navicat MySQL Data Transfer

Source Server         : saas
Source Server Version : 80013
Source Host           : 10.10.76.151:3306
Source Database       : shiro_test

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2020-05-29 14:07:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  `permission` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'howie', '123456', 'user', 'normal');
INSERT INTO `user` VALUES ('2', 'swit', '123456789', 'admin', 'vip');
INSERT INTO `user` VALUES ('3', 'kobe', '112233', 'user', 'normal');
