/*
Navicat MySQL Data Transfer

Source Server         : quick4j
Source Server Version : 50024
Source Host           : localhost:3306
Source Database       : quick4j

Target Server Type    : MYSQL
Target Server Version : 50024
File Encoding         : 65001

Date: 2017-07-08 12:16:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(11) unsigned NOT NULL auto_increment COMMENT '菜单编号',
  `mname` varchar(255) default NULL COMMENT '菜单项名称',
  `murl` varchar(255) default NULL COMMENT '菜单项访问地址',
  `pid` int(11) unsigned zerofill default NULL COMMENT '上级菜单项ID',
  `iconcode` varchar(255) default NULL COMMENT '菜单项图标',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '系统管理', '/rest/menu1', '00000000000', 'icon-rocket');
INSERT INTO `menu` VALUES ('2', '用户管理', '/rest/menu2', '00000000001', 'icon-rocket');
INSERT INTO `menu` VALUES ('3', '角色管理', '/rest/menu3', '00000000001', 'icon-rocket');
INSERT INTO `menu` VALUES ('4', '菜单管理', '/rest/menu4', '00000000001', 'icon-rocket');
INSERT INTO `menu` VALUES ('5', '权限管理', '/rest/menu5', '00000000001', 'icon-rocket');
INSERT INTO `menu` VALUES ('6', '业务管理', '/rest/menu6', '00000000000', 'icon-rocket');
INSERT INTO `menu` VALUES ('7', '业务1', '/rest/menu7', '00000000006', 'icon-rocket');
INSERT INTO `menu` VALUES ('8', '业务2', '/rest/menu8', '00000000006', 'icon-rocket');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` bigint(20) unsigned NOT NULL auto_increment COMMENT '权限id',
  `permission_name` varchar(32) default NULL COMMENT '权限名',
  `permission_sign` varchar(128) default NULL COMMENT '权限标识,程序中判断使用,如"user:create"',
  `description` varchar(256) default NULL COMMENT '权限描述,UI界面显示使用',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='权限表';

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', '用户新增', 'user:create', null);
INSERT INTO `permission` VALUES ('2', '用户修改', 'user:update', null);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) unsigned NOT NULL auto_increment COMMENT '角色id',
  `role_name` varchar(32) default NULL COMMENT '角色名',
  `role_sign` varchar(128) default NULL COMMENT '角色标识,程序中判断使用,如"admin"',
  `description` varchar(256) default NULL COMMENT '角色描述,UI界面显示使用',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='角色表';

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'admin', 'admin', '管理员');
INSERT INTO `role` VALUES ('2', 'normal', 'normal', '注册用户');
INSERT INTO `role` VALUES ('3', 'licensed', 'licensed', '许可用户');
INSERT INTO `role` VALUES ('4', 'blocked', 'blocked', '封存用户');

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `id` bigint(20) unsigned NOT NULL auto_increment COMMENT '主键ID',
  `role_id` int(11) default NULL COMMENT '角色ID',
  `menu_id` int(11) default NULL COMMENT '菜单ID',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES ('1', '2', '1');
INSERT INTO `role_menu` VALUES ('2', '2', '2');
INSERT INTO `role_menu` VALUES ('3', '2', '3');
INSERT INTO `role_menu` VALUES ('4', '2', '4');
INSERT INTO `role_menu` VALUES ('5', '2', '5');
INSERT INTO `role_menu` VALUES ('6', '1', '6');
INSERT INTO `role_menu` VALUES ('7', '1', '7');
INSERT INTO `role_menu` VALUES ('8', '1', '8');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` bigint(20) unsigned NOT NULL auto_increment COMMENT '表id',
  `role_id` bigint(20) unsigned default NULL COMMENT '角色id',
  `permission_id` bigint(20) unsigned default NULL COMMENT '权限id',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='角色与权限关联表';

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('1', '2', '1');
INSERT INTO `role_permission` VALUES ('2', '2', '2');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) unsigned NOT NULL auto_increment COMMENT '用户id',
  `username` varchar(50) default NULL COMMENT '用户名',
  `password` char(64) default NULL COMMENT '密码',
  `state` varchar(32) default NULL COMMENT '状态',
  `create_time` datetime default NULL COMMENT '创建时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'starzou', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', null, '2014-07-17 12:59:08');
INSERT INTO `user` VALUES ('3', 'zhan123456', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '1', '2017-06-26 10:47:39');
INSERT INTO `user` VALUES ('4', 'z111', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '1', '2017-06-26 10:56:00');
INSERT INTO `user` VALUES ('5', 'z112', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '1', '2017-06-26 12:23:08');
INSERT INTO `user` VALUES ('6', 'z113', '9fa4e7b3ec12070572bcce41ef489029f4c8a656f9bff542c128498c1960d0fc', '1', '2017-06-26 12:33:08');
INSERT INTO `user` VALUES ('7', 'zhan111', 'bcb15f821479b4d5772bd0ca866c00ad5f926e3580720659cc80d39c9d09802a', '1', '2017-06-27 17:31:26');
INSERT INTO `user` VALUES ('8', 'z118', '9fa4e7b3ec12070572bcce41ef489029f4c8a656f9bff542c128498c1960d0fc', '1', '2017-06-28 09:28:28');
INSERT INTO `user` VALUES ('9', 'z118', 'bcb15f821479b4d5772bd0ca866c00ad5f926e3580720659cc80d39c9d09802a', '1', '2017-06-28 09:51:49');
INSERT INTO `user` VALUES ('10', 'zhan111', 'bcb15f821479b4d5772bd0ca866c00ad5f926e3580720659cc80d39c9d09802a', '1', '2017-06-28 11:24:26');
INSERT INTO `user` VALUES ('11', 'zzzz', '2d6ccd34ad7af363159ed4bbe18c0e43c681f606877d9ffc96b62200720d7291', '1', '2017-06-28 13:43:18');
INSERT INTO `user` VALUES ('12', '詹飞', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '1', '2017-06-29 08:58:16');
INSERT INTO `user` VALUES ('13', 'wushan', 'a4affcd33b2d6bef4120b6b67f7c421af3a3a13b3653279e07b551649c924a75', '1', '2017-06-29 16:29:40');
INSERT INTO `user` VALUES ('14', 'zhan222', 'bcb15f821479b4d5772bd0ca866c00ad5f926e3580720659cc80d39c9d09802a', null, '2017-07-03 10:02:26');
INSERT INTO `user` VALUES ('15', 'starzou0', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', null, '2017-07-03 10:02:27');
INSERT INTO `user` VALUES ('16', 'starzou1', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', null, '2017-07-03 10:02:27');
INSERT INTO `user` VALUES ('17', 'starzou2', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', null, '2017-07-03 10:02:27');
INSERT INTO `user` VALUES ('18', 'starzou3', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', null, '2017-07-03 10:02:27');
INSERT INTO `user` VALUES ('19', 'starzou4', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', null, '2017-07-03 10:02:27');
INSERT INTO `user` VALUES ('20', 'starzou5', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', null, '2017-07-03 10:02:27');
INSERT INTO `user` VALUES ('21', 'starzou6', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', null, '2017-07-03 10:02:27');
INSERT INTO `user` VALUES ('22', 'starzou7', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', null, '2017-07-03 10:02:27');
INSERT INTO `user` VALUES ('23', 'starzou8', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', null, '2017-07-03 10:02:27');
INSERT INTO `user` VALUES ('24', 'starzou9', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', null, '2017-07-03 10:02:27');
INSERT INTO `user` VALUES ('25', 'zhan333', 'bcb15f821479b4d5772bd0ca866c00ad5f926e3580720659cc80d39c9d09802a', null, '2017-07-03 10:27:26');
INSERT INTO `user` VALUES ('26', 'starzou1110', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', null, '2017-07-03 10:27:27');
INSERT INTO `user` VALUES ('27', 'starzou1111', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', null, '2017-07-03 10:27:27');
INSERT INTO `user` VALUES ('28', 'starzou1112', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', null, '2017-07-03 10:27:27');
INSERT INTO `user` VALUES ('29', 'starzou1113', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', null, '2017-07-03 10:27:27');
INSERT INTO `user` VALUES ('30', 'starzou1114', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', null, '2017-07-03 10:27:27');
INSERT INTO `user` VALUES ('31', 'starzou1115', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', null, '2017-07-03 10:27:27');
INSERT INTO `user` VALUES ('32', 'starzou1116', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', null, '2017-07-03 10:27:27');
INSERT INTO `user` VALUES ('33', 'starzou1117', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', null, '2017-07-03 10:27:27');
INSERT INTO `user` VALUES ('34', 'starzou1118', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', null, '2017-07-03 10:27:27');
INSERT INTO `user` VALUES ('35', 'starzou1119', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', null, '2017-07-03 10:27:27');
INSERT INTO `user` VALUES ('36', 'starzou1111111111111111', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '1', '2017-07-04 14:12:50');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` bigint(20) unsigned NOT NULL auto_increment COMMENT '表id',
  `user_id` bigint(20) unsigned default NULL COMMENT '用户id',
  `role_id` bigint(20) unsigned default NULL COMMENT '角色id',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='用户与角色关联表';

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '1');
INSERT INTO `user_role` VALUES ('2', '1', '2');
