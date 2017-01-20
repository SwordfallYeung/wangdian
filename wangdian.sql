/*
Navicat MySQL Data Transfer

Source Server         : JAVAMySQL
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : wangdian

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2017-01-20 14:44:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for wd_admin
-- ----------------------------
DROP TABLE IF EXISTS `wd_admin`;
CREATE TABLE `wd_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isDel` int(11) DEFAULT NULL,
  `loginCount` int(11) DEFAULT NULL,
  `loginTime` datetime DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wd_admin
-- ----------------------------
INSERT INTO `wd_admin` VALUES ('1', '0', '107', '2017-01-10 15:35:01', '秋殇文月', 'MTIzNDU2\r\n', '0', 'yang');
INSERT INTO `wd_admin` VALUES ('2', '0', '3', '2016-09-16 11:14:31', '小白', 'MTIzNDU2\r\n', '0', 'xiaobai');

-- ----------------------------
-- Table structure for wd_adminlogin
-- ----------------------------
DROP TABLE IF EXISTS `wd_adminlogin`;
CREATE TABLE `wd_adminlogin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adminId` int(11) DEFAULT NULL,
  `loginTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wd_adminlogin
-- ----------------------------
INSERT INTO `wd_adminlogin` VALUES ('1', '1', '2016-09-15 17:16:48');
INSERT INTO `wd_adminlogin` VALUES ('2', '1', '2016-09-15 17:32:18');
INSERT INTO `wd_adminlogin` VALUES ('3', '1', '2016-09-15 17:35:05');
INSERT INTO `wd_adminlogin` VALUES ('4', '1', '2016-09-15 21:20:40');
INSERT INTO `wd_adminlogin` VALUES ('5', '1', '2016-09-15 22:06:45');
INSERT INTO `wd_adminlogin` VALUES ('6', '1', '2016-09-16 01:06:19');
INSERT INTO `wd_adminlogin` VALUES ('7', '2', '2016-09-16 01:32:22');
INSERT INTO `wd_adminlogin` VALUES ('8', '1', '2016-09-16 02:23:30');
INSERT INTO `wd_adminlogin` VALUES ('9', '1', '2016-09-16 03:07:54');
INSERT INTO `wd_adminlogin` VALUES ('10', '1', '2016-09-16 10:58:49');
INSERT INTO `wd_adminlogin` VALUES ('11', '1', '2016-09-16 11:14:11');
INSERT INTO `wd_adminlogin` VALUES ('12', '2', '2016-09-16 11:14:31');
INSERT INTO `wd_adminlogin` VALUES ('13', '1', '2016-09-16 14:43:44');
INSERT INTO `wd_adminlogin` VALUES ('14', '1', '2016-09-16 19:14:47');
INSERT INTO `wd_adminlogin` VALUES ('15', '1', '2016-09-17 00:38:57');
INSERT INTO `wd_adminlogin` VALUES ('16', '1', '2016-09-17 01:11:41');
INSERT INTO `wd_adminlogin` VALUES ('17', '1', '2016-09-17 13:04:18');
INSERT INTO `wd_adminlogin` VALUES ('18', '1', '2016-09-17 15:23:48');
INSERT INTO `wd_adminlogin` VALUES ('19', '1', '2016-09-17 16:18:06');
INSERT INTO `wd_adminlogin` VALUES ('20', '1', '2016-09-17 16:20:27');
INSERT INTO `wd_adminlogin` VALUES ('21', '1', '2016-09-17 16:22:10');
INSERT INTO `wd_adminlogin` VALUES ('22', '1', '2016-09-17 20:00:22');
INSERT INTO `wd_adminlogin` VALUES ('23', '1', '2016-09-17 20:04:02');
INSERT INTO `wd_adminlogin` VALUES ('24', '1', '2016-09-17 20:15:21');
INSERT INTO `wd_adminlogin` VALUES ('25', '1', '2016-09-17 20:18:40');
INSERT INTO `wd_adminlogin` VALUES ('26', '1', '2016-09-17 20:33:25');
INSERT INTO `wd_adminlogin` VALUES ('27', '1', '2016-09-17 20:35:17');
INSERT INTO `wd_adminlogin` VALUES ('28', '1', '2016-09-17 20:40:52');
INSERT INTO `wd_adminlogin` VALUES ('29', '1', '2016-09-17 20:52:05');
INSERT INTO `wd_adminlogin` VALUES ('30', '2', '2016-09-17 20:54:11');
INSERT INTO `wd_adminlogin` VALUES ('31', '1', '2016-09-17 21:01:26');
INSERT INTO `wd_adminlogin` VALUES ('32', '1', '2016-09-17 21:04:36');
INSERT INTO `wd_adminlogin` VALUES ('33', '1', '2016-09-17 21:06:32');
INSERT INTO `wd_adminlogin` VALUES ('34', '1', '2016-09-18 18:23:31');
INSERT INTO `wd_adminlogin` VALUES ('35', '1', '2016-09-18 18:35:12');
INSERT INTO `wd_adminlogin` VALUES ('36', '1', '2016-09-18 18:56:56');
INSERT INTO `wd_adminlogin` VALUES ('37', '1', '2016-09-18 19:00:34');
INSERT INTO `wd_adminlogin` VALUES ('38', '1', '2016-09-18 19:05:05');
INSERT INTO `wd_adminlogin` VALUES ('39', '1', '2016-09-18 19:16:29');
INSERT INTO `wd_adminlogin` VALUES ('40', '1', '2016-09-18 19:19:15');
INSERT INTO `wd_adminlogin` VALUES ('41', '1', '2016-09-18 19:26:19');
INSERT INTO `wd_adminlogin` VALUES ('42', '1', '2016-09-18 22:46:31');
INSERT INTO `wd_adminlogin` VALUES ('43', '1', '2016-09-18 23:35:27');
INSERT INTO `wd_adminlogin` VALUES ('44', '1', '2016-09-19 02:31:23');
INSERT INTO `wd_adminlogin` VALUES ('45', '1', '2016-09-19 03:15:27');
INSERT INTO `wd_adminlogin` VALUES ('46', '1', '2016-09-19 11:44:11');
INSERT INTO `wd_adminlogin` VALUES ('47', '1', '2016-09-19 22:04:44');
INSERT INTO `wd_adminlogin` VALUES ('48', '1', '2016-09-20 02:05:21');
INSERT INTO `wd_adminlogin` VALUES ('49', '1', '2016-09-20 09:32:57');
INSERT INTO `wd_adminlogin` VALUES ('50', '1', '2016-09-20 09:41:01');
INSERT INTO `wd_adminlogin` VALUES ('51', '1', '2016-09-20 12:37:42');
INSERT INTO `wd_adminlogin` VALUES ('52', '1', '2016-09-20 16:58:24');
INSERT INTO `wd_adminlogin` VALUES ('53', '1', '2016-09-20 21:30:36');
INSERT INTO `wd_adminlogin` VALUES ('54', '1', '2016-09-21 01:00:07');
INSERT INTO `wd_adminlogin` VALUES ('55', '1', '2016-09-21 02:31:57');
INSERT INTO `wd_adminlogin` VALUES ('56', '1', '2016-09-21 09:21:34');
INSERT INTO `wd_adminlogin` VALUES ('57', '1', '2016-09-21 09:25:13');
INSERT INTO `wd_adminlogin` VALUES ('58', '1', '2016-09-21 09:50:37');
INSERT INTO `wd_adminlogin` VALUES ('59', '1', '2016-09-21 09:59:22');
INSERT INTO `wd_adminlogin` VALUES ('60', '1', '2016-09-21 10:27:48');
INSERT INTO `wd_adminlogin` VALUES ('61', '1', '2016-09-21 10:33:02');
INSERT INTO `wd_adminlogin` VALUES ('62', '1', '2016-09-21 10:41:15');
INSERT INTO `wd_adminlogin` VALUES ('63', '1', '2016-09-21 10:44:30');
INSERT INTO `wd_adminlogin` VALUES ('64', '1', '2016-09-21 22:28:07');
INSERT INTO `wd_adminlogin` VALUES ('65', '1', '2016-09-22 23:23:15');
INSERT INTO `wd_adminlogin` VALUES ('66', '1', '2016-09-24 11:16:12');
INSERT INTO `wd_adminlogin` VALUES ('67', '1', '2016-09-24 23:11:56');
INSERT INTO `wd_adminlogin` VALUES ('68', '1', '2016-09-25 02:23:20');
INSERT INTO `wd_adminlogin` VALUES ('69', '1', '2016-09-25 02:58:08');
INSERT INTO `wd_adminlogin` VALUES ('70', '1', '2016-10-10 00:11:21');
INSERT INTO `wd_adminlogin` VALUES ('71', '1', '2016-10-10 01:39:40');
INSERT INTO `wd_adminlogin` VALUES ('72', '1', '2016-10-15 13:03:24');
INSERT INTO `wd_adminlogin` VALUES ('73', '1', '2016-10-15 13:27:37');
INSERT INTO `wd_adminlogin` VALUES ('74', '1', '2016-10-15 17:09:03');
INSERT INTO `wd_adminlogin` VALUES ('75', '1', '2016-10-19 00:04:48');
INSERT INTO `wd_adminlogin` VALUES ('76', '1', '2016-10-19 01:29:52');
INSERT INTO `wd_adminlogin` VALUES ('77', '1', '2016-10-19 01:42:19');
INSERT INTO `wd_adminlogin` VALUES ('78', '1', '2016-10-21 16:36:43');
INSERT INTO `wd_adminlogin` VALUES ('79', '1', '2016-10-21 21:59:47');
INSERT INTO `wd_adminlogin` VALUES ('80', '1', '2016-10-24 15:32:42');
INSERT INTO `wd_adminlogin` VALUES ('81', '1', '2016-10-24 15:59:19');
INSERT INTO `wd_adminlogin` VALUES ('82', '1', '2016-10-25 22:37:23');
INSERT INTO `wd_adminlogin` VALUES ('83', '1', '2016-10-30 18:28:46');
INSERT INTO `wd_adminlogin` VALUES ('84', '1', '2016-10-31 10:17:27');
INSERT INTO `wd_adminlogin` VALUES ('85', '1', '2016-11-01 18:20:47');
INSERT INTO `wd_adminlogin` VALUES ('86', '1', '2016-11-01 18:27:15');
INSERT INTO `wd_adminlogin` VALUES ('87', '1', '2016-11-01 18:47:31');
INSERT INTO `wd_adminlogin` VALUES ('88', '1', '2016-11-01 19:03:52');
INSERT INTO `wd_adminlogin` VALUES ('89', '1', '2016-11-03 13:18:04');
INSERT INTO `wd_adminlogin` VALUES ('90', '1', '2016-11-03 13:27:58');
INSERT INTO `wd_adminlogin` VALUES ('91', '1', '2016-11-03 13:34:18');
INSERT INTO `wd_adminlogin` VALUES ('92', '1', '2016-11-04 22:51:32');
INSERT INTO `wd_adminlogin` VALUES ('93', '1', '2016-11-04 23:17:09');
INSERT INTO `wd_adminlogin` VALUES ('94', '1', '2016-11-04 23:32:07');
INSERT INTO `wd_adminlogin` VALUES ('95', '1', '2016-11-04 23:38:48');
INSERT INTO `wd_adminlogin` VALUES ('96', '1', '2016-11-22 16:49:33');
INSERT INTO `wd_adminlogin` VALUES ('97', '1', '2016-11-22 17:15:25');
INSERT INTO `wd_adminlogin` VALUES ('98', '1', '2016-11-22 17:57:51');
INSERT INTO `wd_adminlogin` VALUES ('99', '1', '2016-11-23 23:51:50');
INSERT INTO `wd_adminlogin` VALUES ('100', '1', '2016-11-30 19:10:20');
INSERT INTO `wd_adminlogin` VALUES ('101', '1', '2017-01-08 17:39:28');
INSERT INTO `wd_adminlogin` VALUES ('102', '1', '2017-01-08 18:04:33');
INSERT INTO `wd_adminlogin` VALUES ('103', '1', '2017-01-08 18:35:21');
INSERT INTO `wd_adminlogin` VALUES ('104', '1', '2017-01-08 18:37:32');
INSERT INTO `wd_adminlogin` VALUES ('105', '1', '2017-01-09 16:28:45');
INSERT INTO `wd_adminlogin` VALUES ('106', '1', '2017-01-09 17:24:18');
INSERT INTO `wd_adminlogin` VALUES ('107', '1', '2017-01-09 17:33:46');
INSERT INTO `wd_adminlogin` VALUES ('108', '1', '2017-01-09 18:13:43');
INSERT INTO `wd_adminlogin` VALUES ('109', '1', '2017-01-10 15:35:01');
INSERT INTO `wd_adminlogin` VALUES ('110', '1', '2017-01-10 15:43:12');

-- ----------------------------
-- Table structure for wd_advert
-- ----------------------------
DROP TABLE IF EXISTS `wd_advert`;
CREATE TABLE `wd_advert` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `photo` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `isDel` int(11) DEFAULT NULL,
  `inTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wd_advert
-- ----------------------------
INSERT INTO `wd_advert` VALUES ('1', 'uploads\\/2016091901\\/adds-img1.jpg', 'www.baidu.com', '广告1', '0', '2016-09-19 02:10:52');
INSERT INTO `wd_advert` VALUES ('2', 'uploads\\/2017011015\\/5f53d3ac-bf80-4e64-84bd-bca16631f5d0.png', 'www.baidu.com', '广告2', '0', '2016-09-19 02:29:09');

-- ----------------------------
-- Table structure for wd_contact
-- ----------------------------
DROP TABLE IF EXISTS `wd_contact`;
CREATE TABLE `wd_contact` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `qq` varchar(255) DEFAULT NULL,
  `telePhone` varchar(255) DEFAULT NULL,
  `weiXin` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wd_contact
-- ----------------------------

-- ----------------------------
-- Table structure for wd_firstphoto
-- ----------------------------
DROP TABLE IF EXISTS `wd_firstphoto`;
CREATE TABLE `wd_firstphoto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `inTime` datetime DEFAULT NULL,
  `isDel` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wd_firstphoto
-- ----------------------------
INSERT INTO `wd_firstphoto` VALUES ('1', '2016-09-19 03:16:15', '0', '图片1', 'uploads\\/2016091903\\/homepage-img1.jpg');
INSERT INTO `wd_firstphoto` VALUES ('2', '2016-09-19 03:16:40', '0', '图片2', 'uploads\\/2016091903\\/homepage-img2.jpg');
INSERT INTO `wd_firstphoto` VALUES ('3', '2016-09-19 03:16:57', '0', '图片3', 'uploads\\/2016091903\\/homepage-img1.jpg');
INSERT INTO `wd_firstphoto` VALUES ('4', '2016-09-19 03:17:15', '0', '图片4', 'uploads\\/2016091903\\/homepage-img2.jpg');

-- ----------------------------
-- Table structure for wd_orders
-- ----------------------------
DROP TABLE IF EXISTS `wd_orders`;
CREATE TABLE `wd_orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `firstCost` float NOT NULL,
  `isDel` int(11) DEFAULT NULL,
  `kuaiDiDanHao` varchar(255) DEFAULT NULL,
  `liuYan` varchar(255) DEFAULT NULL,
  `ordersCost` float NOT NULL,
  `profits` float NOT NULL,
  `shopKeeper` varchar(255) DEFAULT NULL,
  `shopOrderId` varchar(255) DEFAULT NULL,
  `shopOrderMan` varchar(255) DEFAULT NULL,
  `shopOrderTime` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `yunFei` float NOT NULL,
  `receiver` varchar(255) DEFAULT NULL,
  `receiverPhone` varchar(255) DEFAULT NULL,
  `zipCode` varchar(255) DEFAULT NULL,
  `isDelFromUser` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wd_orders
-- ----------------------------
INSERT INTO `wd_orders` VALUES ('1', '湖北省武汉市洪山区珞南街道文秀街升升公寓', '100.2', '0', '', null, '120.5', '20.3', 'yang', 'tnbl201610240001', 'yang', '2016-10-24 15:51:34', '0', '13212703452', '0', 'yang', '13212703452', null, '0');
INSERT INTO `wd_orders` VALUES ('2', '13212703452', '100.2', '0', '', null, '120.5', '20.3', 'yang', 'hrwt201610250001', 'yang', '2016-10-25 20:21:46', '0', '13212703452', '0', 'yang', '13212703452', null, '0');
INSERT INTO `wd_orders` VALUES ('3', '湖北省武汉市洪山区珞南街道文秀街升升公寓', '100.2', '0', '', null, '120.5', '20.3', 'yang', 'ieja201610250002', 'yang', '2016-10-25 22:32:36', '0', '13212703452', '0', '小黑', '13212703452', null, '0');
INSERT INTO `wd_orders` VALUES ('4', '湖北省武汉市洪山区珞南街道文秀街升升公寓', '100.2', '0', '12334566699', '湖北省武汉市洪山区珞南街道文秀街升升公寓', '120.5', '20.3', 'yang', 'gwry201611040001', 'yang', '2016-11-04 22:53:15', '3', '13212703452', '0', '小黑', '13212703452', null, '0');
INSERT INTO `wd_orders` VALUES ('5', '北京市东城区东华门街道升升', '150.4', '0', null, '', '200.8', '50.4', 'yang', 'rrde201701080001', 'yang', '2017-01-08 20:50:05', '0', null, '0', '杨剑秋', '13212703452', null, '0');

-- ----------------------------
-- Table structure for wd_shop
-- ----------------------------
DROP TABLE IF EXISTS `wd_shop`;
CREATE TABLE `wd_shop` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstCost` float NOT NULL,
  `isDel` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
  `secondCost` float NOT NULL,
  `shopDescribe` varchar(255) DEFAULT NULL,
  `shopModel` varchar(255) DEFAULT NULL,
  `shopType` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `firstPhoto` varchar(255) DEFAULT NULL,
  `isRecommend` int(11) DEFAULT NULL,
  `inTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wd_shop
-- ----------------------------
INSERT INTO `wd_shop` VALUES ('1', '100.2', '0', '英雄牌自行车', 'BH1306', '120.5', '好自行车', '山地车', '自行车', '1', 'uploads\\/2016102122\\/931863e4.jpg', '1', '2016-09-21 11:17:06');
INSERT INTO `wd_shop` VALUES ('2', '150.4', '0', '英雄zi13232', 'BH1307', '200.8', '好山地车', '山地车', '自行车', '0', 'uploads\\/2016092018\\/flash-sale-img1.jpg', '0', '2016-09-21 11:17:11');
INSERT INTO `wd_shop` VALUES ('3', '12', '0', '222222222222', 'fsdfa sdf', '23', '22222222', 'wwwwwwwwww', '222222222', '0', null, '0', '2016-10-31 10:19:27');

-- ----------------------------
-- Table structure for wd_shopattributes
-- ----------------------------
DROP TABLE IF EXISTS `wd_shopattributes`;
CREATE TABLE `wd_shopattributes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isDel` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `shopId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wd_shopattributes
-- ----------------------------
INSERT INTO `wd_shopattributes` VALUES ('1', '0', '颜色', '1');
INSERT INTO `wd_shopattributes` VALUES ('2', '0', '长度', '1');

-- ----------------------------
-- Table structure for wd_shopattributesvalue
-- ----------------------------
DROP TABLE IF EXISTS `wd_shopattributesvalue`;
CREATE TABLE `wd_shopattributesvalue` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `attributesValue` varchar(255) DEFAULT NULL,
  `isDel` int(11) DEFAULT NULL,
  `shopAttributes_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_4h5vfh7j62x21ek9gmika1oj5` (`shopAttributes_id`),
  CONSTRAINT `FK_4h5vfh7j62x21ek9gmika1oj5` FOREIGN KEY (`shopAttributes_id`) REFERENCES `wd_shopattributes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wd_shopattributesvalue
-- ----------------------------
INSERT INTO `wd_shopattributesvalue` VALUES ('1', '白色', '0', '1');
INSERT INTO `wd_shopattributesvalue` VALUES ('2', '黑色', '0', '1');
INSERT INTO `wd_shopattributesvalue` VALUES ('3', '1', '0', '2');

-- ----------------------------
-- Table structure for wd_shopcart
-- ----------------------------
DROP TABLE IF EXISTS `wd_shopcart`;
CREATE TABLE `wd_shopcart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `allFirstCost` float NOT NULL,
  `allProfits` float NOT NULL,
  `allSecondCost` float NOT NULL,
  `count` int(11) DEFAULT NULL,
  `detail` varchar(255) DEFAULT NULL,
  `firstCost` float NOT NULL,
  `isDel` int(11) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `profits` float NOT NULL,
  `secondCost` float NOT NULL,
  `shopId` int(11) DEFAULT NULL,
  `shopModel` varchar(255) DEFAULT NULL,
  `shopName` varchar(255) DEFAULT NULL,
  `shopNumber` varchar(255) DEFAULT NULL,
  `shopType` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_9oomu75agdbfoo1ax05xdlfgu` (`order_id`),
  CONSTRAINT `FK_9oomu75agdbfoo1ax05xdlfgu` FOREIGN KEY (`order_id`) REFERENCES `wd_orders` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wd_shopcart
-- ----------------------------
INSERT INTO `wd_shopcart` VALUES ('2', '100.2', '20.3', '120.5', '1', '长度：1、颜色：黑色', '100.2', '0', 'uploads\\/2016102122\\/931863e4.jpg', '20.3', '120.5', '1', '山地车', '英雄牌自行车', 'BH1306', '自行车', '2', 'shop', '3', '1');
INSERT INTO `wd_shopcart` VALUES ('4', '100.2', '20.3', '120.5', '1', '长度：1、颜色：黑色', '100.2', '0', 'uploads\\/2016102122\\/931863e4.jpg', '20.3', '120.5', '1', '山地车', '英雄牌自行车', 'BH1306', '自行车', '2', 'shop', '3', '2');
INSERT INTO `wd_shopcart` VALUES ('5', '100.2', '20.3', '120.5', '1', '长度：1、颜色：黑色', '100.2', '0', 'uploads\\/2016102122\\/931863e4.jpg', '20.3', '120.5', '1', '山地车', '英雄牌自行车', 'BH1306', '自行车', '0', 'shop', '3', null);
INSERT INTO `wd_shopcart` VALUES ('7', '100.2', '20.3', '120.5', '1', '长度：1、颜色：黑色', '100.2', '0', 'uploads\\/2016102122\\/931863e4.jpg', '20.3', '120.5', '1', '山地车', '英雄牌自行车', 'BH1306', '自行车', '2', 'shop', '3', '3');
INSERT INTO `wd_shopcart` VALUES ('9', '100.2', '20.3', '120.5', '1', '长度：1、颜色：黑色', '100.2', '0', 'uploads\\/2016102122\\/931863e4.jpg', '20.3', '120.5', '1', '山地车', '英雄牌自行车', 'BH1306', '自行车', '2', 'shop', '3', '4');
INSERT INTO `wd_shopcart` VALUES ('10', '100.2', '20.3', '120.5', '1', '长度：1、颜色：黑色', '100.2', '0', 'uploads\\/2016102122\\/931863e4.jpg', '20.3', '120.5', '1', '山地车', '英雄牌自行车', 'BH1306', '自行车', '1', 'shop', '3', null);
INSERT INTO `wd_shopcart` VALUES ('11', '201.2', '18.8', '220', '2', '', '100.6', '0', 'uploads\\/2016092011\\/flash-sale-img1.jpg', '9.4', '110', '1', '山地车', '英雄自行车', 'BH123456', '自行车', '1', 'shunShop', '3', null);
INSERT INTO `wd_shopcart` VALUES ('13', '150.4', '50.4', '200.8', '1', '', '150.4', '0', 'uploads\\/2016092018\\/flash-sale-img1.jpg', '50.4', '200.8', '2', '山地车', '英雄zi13232', 'BH1307', '自行车', '2', 'shop', '3', '5');
INSERT INTO `wd_shopcart` VALUES ('14', '100.2', '20.3', '120.5', '1', '长度：1、颜色：黑色', '100.2', '0', 'uploads\\/2016102122\\/931863e4.jpg', '20.3', '120.5', '1', '山地车', '英雄牌自行车', 'BH1306', '自行车', '1', 'shop', '3', null);

-- ----------------------------
-- Table structure for wd_shopkeeper
-- ----------------------------
DROP TABLE IF EXISTS `wd_shopkeeper`;
CREATE TABLE `wd_shopkeeper` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `isDel` int(11) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `tellphone` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `zhifubao` varchar(255) DEFAULT NULL,
  `webUrl` varchar(255) DEFAULT NULL,
  `allProfit` float NOT NULL,
  `yiTiXian` float NOT NULL,
  `message` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wd_shopkeeper
-- ----------------------------
INSERT INTO `wd_shopkeeper` VALUES ('1', '2506597416@qq.com', '0', 'qiu', 'MTIzNDU2\r\n', '0', '13212703452', 'yang', '13212703452', 'yang', '20.3', '20.3', 'yang于2016-11-22 17:15:07申请提现0.0元', '13212703452');
INSERT INTO `wd_shopkeeper` VALUES ('2', '2506597416@qq.com', '0', '小秋', 'MTIzNDU2Nzg5\r\n', '0', '13212703452', 'qiu', '13212703452', 'qiu', '0', '0', null, '13212703452');
INSERT INTO `wd_shopkeeper` VALUES ('3', '2506597416@qq.com', '0', 'yang12', 'MTIzNDU2\r\n', '0', null, 'whut', '13212703452', 'whut', '0', '0', '', '13212703452');

-- ----------------------------
-- Table structure for wd_shopkeeperprofit
-- ----------------------------
DROP TABLE IF EXISTS `wd_shopkeeperprofit`;
CREATE TABLE `wd_shopkeeperprofit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isDel` int(11) DEFAULT NULL,
  `money` float NOT NULL,
  `shopKeeper` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `tiXianTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wd_shopkeeperprofit
-- ----------------------------
INSERT INTO `wd_shopkeeperprofit` VALUES ('1', '0', '12', 'yang', '2', '2016-09-21 09:20:41');
INSERT INTO `wd_shopkeeperprofit` VALUES ('2', '1', '5', 'yang', '0', '2016-09-21 09:24:20');
INSERT INTO `wd_shopkeeperprofit` VALUES ('3', '0', '6', 'yang', '1', '2016-09-21 09:24:44');
INSERT INTO `wd_shopkeeperprofit` VALUES ('4', '0', '12', 'yang', '2', '2016-09-21 09:45:34');
INSERT INTO `wd_shopkeeperprofit` VALUES ('5', '0', '2', 'yang', '0', '2016-09-21 10:40:33');
INSERT INTO `wd_shopkeeperprofit` VALUES ('6', '0', '2', 'yang', '0', '2016-09-21 10:44:01');
INSERT INTO `wd_shopkeeperprofit` VALUES ('8', '0', '20.3', 'yang', '1', '2016-11-01 19:03:16');
INSERT INTO `wd_shopkeeperprofit` VALUES ('9', '0', '20.3', 'yang', '1', '2016-11-01 19:07:47');
INSERT INTO `wd_shopkeeperprofit` VALUES ('10', '0', '0', 'yang', '0', '2016-11-22 17:15:07');

-- ----------------------------
-- Table structure for wd_shopphotos
-- ----------------------------
DROP TABLE IF EXISTS `wd_shopphotos`;
CREATE TABLE `wd_shopphotos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shopId` int(11) DEFAULT NULL,
  `urlPath` varchar(255) DEFAULT NULL,
  `isDel` int(11) DEFAULT NULL,
  `photoType` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wd_shopphotos
-- ----------------------------
INSERT INTO `wd_shopphotos` VALUES ('1', '1', 'uploads\\/2016092017\\/adds-img1.jpg', '0', '1');
INSERT INTO `wd_shopphotos` VALUES ('2', '1', 'uploads\\/2016092017\\/adds-img1.jpg', '0', '1');
INSERT INTO `wd_shopphotos` VALUES ('3', '1', 'uploads\\/2016092019\\/adds-img1.jpg', '0', '1');
INSERT INTO `wd_shopphotos` VALUES ('7', '1', 'uploads\\/2016092019\\/adds-img2.jpg', '0', '0');
INSERT INTO `wd_shopphotos` VALUES ('35', '1', 'uploads\\/2016092019\\/adds-img1.jpg', '0', '0');
INSERT INTO `wd_shopphotos` VALUES ('36', '1', 'uploads\\/2016092019\\/adds-img2.jpg', '0', '0');
INSERT INTO `wd_shopphotos` VALUES ('37', '1', 'uploads\\/2016101000\\/ae43f28d.jpg', '1', '1');
INSERT INTO `wd_shopphotos` VALUES ('38', '1', 'uploads\\/2016101000\\/ae43f28d.jpg', '1', '1');
INSERT INTO `wd_shopphotos` VALUES ('39', '3', 'uploads\\/2016103110\\/116b192e-43df-40fd-b622-63918981cf22.png', '0', '1');

-- ----------------------------
-- Table structure for wd_shunshop
-- ----------------------------
DROP TABLE IF EXISTS `wd_shunshop`;
CREATE TABLE `wd_shunshop` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `day` int(11) DEFAULT NULL,
  `firstCost` float NOT NULL,
  `firstPhoto` varchar(255) DEFAULT NULL,
  `hours` int(11) DEFAULT NULL,
  `isDel` int(11) DEFAULT NULL,
  `minutes` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
  `secondCost` float NOT NULL,
  `seconds` int(11) DEFAULT NULL,
  `shopDescribe` varchar(255) DEFAULT NULL,
  `shopModel` varchar(255) DEFAULT NULL,
  `shopType` varchar(255) DEFAULT NULL,
  `startTime` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `thirdCost` float NOT NULL,
  `endTime` datetime DEFAULT NULL,
  `inTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wd_shunshop
-- ----------------------------
INSERT INTO `wd_shunshop` VALUES ('1', '0', '100.6', 'uploads\\/2016092011\\/flash-sale-img1.jpg', '22', '0', '0', '英雄自行车', 'BH123456', '120.8', '0', '好车', '山地车', '自行车', '2016-09-20 01:00:00', '0', '110', '2016-09-20 23:00:00', '2016-10-15 17:33:19');

-- ----------------------------
-- Table structure for wd_shunshopattributes
-- ----------------------------
DROP TABLE IF EXISTS `wd_shunshopattributes`;
CREATE TABLE `wd_shunshopattributes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isDel` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `shopId` int(11) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wd_shunshopattributes
-- ----------------------------

-- ----------------------------
-- Table structure for wd_shunshopattributesvalue
-- ----------------------------
DROP TABLE IF EXISTS `wd_shunshopattributesvalue`;
CREATE TABLE `wd_shunshopattributesvalue` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `attributesValue` varchar(255) DEFAULT NULL,
  `isDel` int(11) DEFAULT NULL,
  `shunshopAttributes_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_75vk1vmlfic0me67wj0tdw1py` (`shunshopAttributes_id`),
  CONSTRAINT `FK_75vk1vmlfic0me67wj0tdw1py` FOREIGN KEY (`shunshopAttributes_id`) REFERENCES `wd_shunshopattributes` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wd_shunshopattributesvalue
-- ----------------------------

-- ----------------------------
-- Table structure for wd_shunshopphotos
-- ----------------------------
DROP TABLE IF EXISTS `wd_shunshopphotos`;
CREATE TABLE `wd_shunshopphotos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isDel` int(11) DEFAULT NULL,
  `photoType` int(11) DEFAULT NULL,
  `shopId` int(11) DEFAULT NULL,
  `urlPath` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wd_shunshopphotos
-- ----------------------------
INSERT INTO `wd_shunshopphotos` VALUES ('1', '0', '0', '1', 'uploads\\/2016092022\\/adds-img2.jpg');
INSERT INTO `wd_shunshopphotos` VALUES ('2', '0', '0', '1', 'uploads\\/2016092022\\/adds-img1.jpg');
INSERT INTO `wd_shunshopphotos` VALUES ('16', '0', '1', '1', 'uploads\\/2016092022\\/adds-img1.jpg');
INSERT INTO `wd_shunshopphotos` VALUES ('17', '0', '1', '1', 'uploads\\/2016092022\\/adds-img1.jpg');
INSERT INTO `wd_shunshopphotos` VALUES ('18', '0', '1', '1', 'uploads\\/2016092022\\/adds-img1.jpg');

-- ----------------------------
-- Table structure for wd_user
-- ----------------------------
DROP TABLE IF EXISTS `wd_user`;
CREATE TABLE `wd_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `isDel` int(11) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `tellphone` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wd_user
-- ----------------------------
INSERT INTO `wd_user` VALUES ('3', '2506597416@qq.com', '0', '小黑', 'MTIzNDU2', '0', '13212703452', 'yang', null);

-- ----------------------------
-- Table structure for wd_useraddress
-- ----------------------------
DROP TABLE IF EXISTS `wd_useraddress`;
CREATE TABLE `wd_useraddress` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adddetail` varchar(255) DEFAULT NULL,
  `area` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `isDel` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `town` varchar(255) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `zipcode` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wd_useraddress
-- ----------------------------
INSERT INTO `wd_useraddress` VALUES ('2', '文秀街升升公寓', '洪山区', '武汉市', '0', '小黑', '13212703452', '湖北省', '珞南街道', '3', null, '1');
INSERT INTO `wd_useraddress` VALUES ('3', '升升', '', '东城区', '0', '杨剑秋', '13212703452', '北京市', '东华门街道', '3', null, '1');

-- ----------------------------
-- Table structure for wd_yuming
-- ----------------------------
DROP TABLE IF EXISTS `wd_yuming`;
CREATE TABLE `wd_yuming` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `yuming` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wd_yuming
-- ----------------------------
INSERT INTO `wd_yuming` VALUES ('1', 'you.com');

-- ----------------------------
-- Table structure for wd_yunfei
-- ----------------------------
DROP TABLE IF EXISTS `wd_yunfei`;
CREATE TABLE `wd_yunfei` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mianYunFei` int(11) DEFAULT NULL,
  `yunFei` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wd_yunfei
-- ----------------------------
INSERT INTO `wd_yunfei` VALUES ('1', '100', '8');
