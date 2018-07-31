/*
 Navicat Premium Data Transfer

 Source Server         : test
 Source Server Type    : MySQL
 Source Server Version : 50640
 Source Host           : 123.206.32.30
 Source Database       : neuer

 Target Server Type    : MySQL
 Target Server Version : 50640
 File Encoding         : utf-8

 Date: 07/17/2018 19:26:29 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `address`
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `qid` int(11) DEFAULT NULL,
  `branch` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `status` varchar(24) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `qid` (`qid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `address`
-- ----------------------------
BEGIN;
INSERT INTO `address` VALUES ('1', '1', '实训中心', '沈阳市和平区东北大学', '15940471397', '123.425144', '41.771072', '正在营业'), ('2', '1', '艺术中心', '多才艺术中心', '15940471393', '123.40297', '41.73612', '正在营业'), ('3', '1', '恒大名都', '恒大名都', '15940471397', '123.39534', '41.6866', '已删除'), ('4', '1', 'e2 3 ', '北京市东城区Apple官方(王府井店)', '111', '116.418135', '39.921419', '已删除'), ('7', '1', '浑南校区1', '沈阳市浑南区东北大学(浑南校区)', '13940210309', '123.430886', '41.658761', '正在营业');
COMMIT;

-- ----------------------------
--  Table structure for `coupon`
-- ----------------------------
DROP TABLE IF EXISTS `coupon`;
CREATE TABLE `coupon` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `qid` int(11) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `money` int(11) DEFAULT NULL,
  `total` int(11) DEFAULT NULL,
  `get` int(11) DEFAULT NULL,
  `deadline` date DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `coupon`
-- ----------------------------
BEGIN;
INSERT INTO `coupon` VALUES ('2', '1', 'Python', '888', '200', '60', '2018-07-31'), ('3', '1', 'C/C++', '111111', '390', '160', '2018-06-29');
COMMIT;

-- ----------------------------
--  Table structure for `couponrecord`
-- ----------------------------
DROP TABLE IF EXISTS `couponrecord`;
CREATE TABLE `couponrecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) DEFAULT NULL,
  `openid` varchar(255) DEFAULT NULL,
  `gettime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `enterprise`
-- ----------------------------
DROP TABLE IF EXISTS `enterprise`;
CREATE TABLE `enterprise` (
  `qid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `videopath` varchar(255) DEFAULT NULL,
  `introduction` varchar(255) DEFAULT NULL,
  `jczs` text,
  PRIMARY KEY (`qid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `enterprise`
-- ----------------------------
BEGIN;
INSERT INTO `enterprise` VALUES ('1', '东软睿道', 'duck.mp4', '沈阳东软睿道教育服务有限公司（简称东软睿道）由东软创办，基于东软的产业发展与人才培养实践，提供更加符合IT行业发展需求的人才培养体系和方法学，精准提升大学生和大学后的就业、创业技能，为新经济时代的转型发展提供高质量规模化的人才供给。', '<p><img src=\"/upload/20180717-1531790491213054201.png\" title=\"20180717-1531790491213054201.png\" alt=\"MV.png\"/>123</p><p><img src=\"http://www.zyrc.tech/uploads/1/shenyangpark1.jpg\"/><img src=\"http://www.zyrc.tech/uploads/1/shenyangpark2.jpg\"/><img src=\"http://www.zyrc.tech/uploads/1/shenyangpark3.jpg\"/><img src=\"http://www.zyrc.tech/uploads/1/shenyangpark4.jpg\"/></p><p><img src=\"/upload/20180716-1531706113674081421.gif\" title=\"20180716-1531706113674081421.gif\" alt=\"猫和老鼠.gif\"/></p>');
COMMIT;

-- ----------------------------
--  Table structure for `freelisten`
-- ----------------------------
DROP TABLE IF EXISTS `freelisten`;
CREATE TABLE `freelisten` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `imgurl` varchar(255) DEFAULT NULL,
  `fdesc` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `qid` int(11) DEFAULT NULL,
  `branchid` int(11) DEFAULT NULL,
  `pubtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `freelisten`
-- ----------------------------
BEGIN;
INSERT INTO `freelisten` VALUES ('1', 'JAVA免费试听课大咔讲师', 'banner1.jpg', '<p><img src=\"upload/java1.jpg\"/><img title=\"20180716-1531726662366086238.jpg\" alt=\"QQ20180613113020.jpg\" src=\"/upload/20180716-1531726662366086238.jpg\"/></p>', '进行中', '1', '7', '2018-06-11 10:53:43'), ('2', '测试2', '1531723770959cats.gif', '<p>1234567890</p>', '进行中', '1', '1', '2018-06-12 10:53:46'), ('3', 'PHP免费试听课', 'banner3.jpg', '<img src=\"upload/java3.jpg\"/>', '进行中', '1', '1', '2018-06-13 10:53:50'), ('4', 'PHP免费试听课', 'banner4.jpg', '<img src=\"upload/java4.jpg\"/>', '进行中', '1', '1', '2018-06-13 10:53:50'), ('5', 'PHP免费试听课', 'banner1.jpg', '<img src=\"upload/java1.jpg\"/>', '进行中', '1', '1', '2018-06-13 10:53:50'), ('6', 'PHP免费试听课', 'banner2.jpg', '<img src=\"upload/java2.jpg\"/>', '进行中', '1', '1', '2018-06-13 10:53:50'), ('7', 'PHP免费试听课', 'banner3.jpg', '<img src=\"upload/java3.jpg\"/>', '进行中', '1', '1', '2018-06-13 10:53:50'), ('8', 'PHP免费试听课', 'banner4.jpg', '<img src=\"upload/java4.jpg\"/>', '进行中', '1', '1', '2018-06-13 10:53:50'), ('9', 'PHP免费试听课', 'banner1.jpg', '<img src=\"upload/java1.jpg\"/>', '进行中', '1', '1', '2018-06-13 10:53:50'), ('10', 'PHP免费试听课', 'banner2.jpg', '<img src=\"upload/java2.jpg\"/>', '进行中', '1', '1', '2018-06-13 10:53:50'), ('11', 'PHP免费试听课', 'banner3.jpg', '<img src=\"upload/java3.jpg\"/>', '进行中', '1', '1', '2018-06-13 10:53:50'), ('12', 'PHP免费试听课', 'banner4.jpg', '<img src=\"upload/java4.jpg\"/>', '进行中', '1', '1', '2018-06-13 10:53:50'), ('13', 'PHP免费试听课', 'banner1.jpg', '<img src=\"upload/java1.jpg\"/>', '进行中', '1', '1', '2018-06-13 10:53:50'), ('14', 'PHP免费试听课', 'banner2.jpg', '<img src=\"upload/java2.jpg\"/>', '进行中', '1', '1', '2018-06-13 10:53:50'), ('15', 'PHP免费试听课15', 'banner3.jpg', '<img src=\"upload/java3.jpg\"/>', '进行中', '1', '1', '2018-07-12 10:18:32'), ('16', 'PHP免费试听课16', 'banner4.jpg', '<img src=\"upload/java4.jpg\"/>', '进行中', '1', '1', '2018-07-12 10:18:32'), ('17', 'PHP免费试听课17', 'banner1.jpg', '<img src=\"upload/java1.jpg\"/>', '进行中', '1', '1', '2018-07-12 10:18:32'), ('18', 'PHP免费试听课18', 'banner2.jpg', '<img src=\"upload/java2.jpg\"/>', '进行中', '1', '1', '2018-07-12 10:18:32'), ('19', 'PHP免费试听课19', 'banner3.jpg', '<img src=\"upload/java3.jpg\"/>', '进行中', '1', '1', '2018-07-12 10:18:32'), ('20', 'PHP免费试听课20', 'banner4.jpg', '<img src=\"upload/java4.jpg\"/>', '进行中', '1', '1', '2018-07-12 10:18:32'), ('21', 'JAVA免费试听课21', 'banner1.jpg', '<img src=\"upload/java1.jpg\"/>', '进行中', '1', '1', '2018-07-12 10:19:34'), ('22', 'JAVA免费试听课22', 'banner2.jpg', '<img src=\"upload/java2.jpg\"/>', '进行中', '1', '1', '2018-07-12 10:19:34'), ('23', 'JAVA免费试听课23', 'banner3.jpg', '<img src=\"upload/java3.jpg\"/>', '进行中', '1', '1', '2018-07-12 10:19:34'), ('24', 'JAVA免费试听课24', 'banner4.jpg', '<img src=\"upload/java4.jpg\"/>', '进行中', '1', '1', '2018-07-12 10:19:34'), ('25', 'JAVA免费试听课25', 'banner1.jpg', '<img src=\"upload/java1.jpg\"/>', '进行中', '1', '1', '2018-07-12 10:19:34'), ('26', 'JAVA免费试听课26', 'banner2.jpg', '<img src=\"upload/java2.jpg\"/>', '进行中', '1', '1', '2018-07-12 10:19:34'), ('27', 'JAVA免费试听课27', 'banner3.jpg', '<img src=\"upload/java3.jpg\"/>', '进行中', '1', '1', '2018-07-12 10:19:34'), ('28', 'JAVA免费试听课28', 'banner4.jpg', '<img src=\"upload/java4.jpg\"/>', '进行中', '1', '1', '2018-07-12 10:19:34'), ('29', 'JAVA免费试听课29', 'banner1.jpg', '<img src=\"upload/java1.jpg\"/>', '进行中', '1', '1', '2018-07-12 10:19:34'), ('30', 'JAVA免费试听课30', 'banner2.jpg', '<img src=\"upload/java2.jpg\"/>', '进行中', '1', '1', '2018-07-12 10:19:34'), ('31', '大数据免费试听课31', 'banner3.jpg', '<img src=\"upload/java3.jpg\"/>', '进行中', '1', '2', '2018-07-12 10:21:15'), ('32', '大数据免费试听课32', 'banner4.jpg', '<img src=\"upload/java4.jpg\"/>', '进行中', '1', '2', '2018-07-12 10:21:15'), ('33', '大数据免费试听课33', 'banner1.jpg', '<img src=\"upload/java1.jpg\"/>', '进行中', '1', '2', '2018-07-12 10:21:15'), ('34', '大数据免费试听课34', 'banner2.jpg', '<img src=\"upload/java2.jpg\"/>', '进行中', '1', '2', '2018-07-12 10:21:15'), ('35', '大数据免费试听课35', 'banner3.jpg', '<img src=\"upload/java3.jpg\"/>', '进行中', '1', '2', '2018-07-12 10:21:15'), ('36', '大数据免费试听课36', 'banner4.jpg', '<img src=\"upload/java4.jpg\"/>', '进行中', '1', '2', '2018-07-12 10:21:15'), ('37', '大数据免费试听课37', 'banner1.jpg', '<img src=\"upload/java1.jpg\"/>', '进行中', '1', '2', '2018-07-12 10:21:15'), ('38', '大数据免费试听课38', 'banner2.jpg', '<img src=\"upload/java2.jpg\"/>', '进行中', '1', '2', '2018-07-12 10:21:15'), ('39', '大数据免费试听课39', 'banner3.jpg', '<img src=\"upload/java3.jpg\"/>', '进行中', '1', '2', '2018-07-12 10:21:15'), ('40', '大数据免费试听课40', 'banner4.jpg', '<img src=\"upload/java4.jpg\"/>', '进行中', '1', '2', '2018-07-12 10:21:15'), ('41', 'Golang免费试听课41', 'banner1.jpg', '<img src=\"upload/java1.jpg\"/>', '进行中', '1', '3', '2018-07-12 10:22:14'), ('42', 'Golang免费试听课42', 'banner2.jpg', '<img src=\"upload/java2.jpg\"/>', '进行中', '1', '3', '2018-07-12 10:22:14'), ('43', 'Golang免费试听课43', 'banner3.jpg', '<img src=\"upload/java3.jpg\"/>', '进行中', '1', '3', '2018-07-12 10:22:14'), ('44', 'Golang免费试听课44', 'banner4.jpg', '<img src=\"upload/java4.jpg\"/>', '进行中', '1', '3', '2018-07-12 10:22:14'), ('45', 'Golang免费试听课45', 'banner1.jpg', '<img src=\"upload/java1.jpg\"/>', '进行中', '1', '3', '2018-07-12 10:22:14'), ('46', 'Golang免费试听课46', 'banner2.jpg', '<img src=\"upload/java2.jpg\"/>', '进行中', '1', '3', '2018-07-12 10:22:14'), ('47', 'Golang免费试听课47', 'banner3.jpg', '<img src=\"upload/java3.jpg\"/>', '进行中', '1', '3', '2018-07-12 10:22:14'), ('48', 'Golang免费试听课48', 'banner4.jpg', '<img src=\"upload/java4.jpg\"/>', '进行中', '1', '3', '2018-07-12 10:22:14'), ('49', 'Golang免费试听课49', 'banner1.jpg', '<img src=\"upload/java1.jpg\"/>', '进行中', '1', '3', '2018-07-12 10:22:14'), ('50', 'Golang免费试听课50', 'banner2.jpg', '<img src=\"upload/java2.jpg\"/>', '进行中', '1', '3', '2018-07-12 10:22:14');
COMMIT;

-- ----------------------------
--  Table structure for `freelistenbook`
-- ----------------------------
DROP TABLE IF EXISTS `freelistenbook`;
CREATE TABLE `freelistenbook` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fid` int(11) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `booktime` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `comment` varchar(3000) DEFAULT NULL,
  `openid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `freelistenbook`
-- ----------------------------
BEGIN;
INSERT INTO `freelistenbook` VALUES ('7', '2', '费园园', '15940471397', '2018-05-26 17:54:50', '待处理', '嘻嘻嘻', null), ('8', '1', '哈哈', '123456789', '2018-05-26 17:55:33', '已处理', '弟弟', null), ('9', '1', '哈哈', '123456789', '2018-05-26 17:55:35', '待处理', '弟弟', null), ('10', '1', '信息', '111', '2018-05-26 17:58:17', '待处理', '玩儿玩儿', null), ('11', '3', '', '', '2018-06-15 09:53:39', '待处理', '', 'null'), ('12', '3', '费园园', '1940471397', '2018-06-15 11:39:18', '待处理', '上午课', 'oC9yV5KjYiv_zu6qJ0pm_WlN4LEk'), ('13', '3', '谢谢', '123', '2018-06-15 12:00:02', '待处理', '谁是', 'null'), ('14', '3', '谢谢', '123', '2018-06-15 12:00:28', '待处理', '谁是', 'null'), ('15', '3', '谢谢', '123', '2018-06-15 12:00:30', '待处理', '谁是', 'null'), ('16', '3', '', '', '2018-06-15 14:05:03', '待处理', '', 'oC9yV5IbgeaLrGfM8tSLSO8Jmj0c'), ('17', '3', '', '', '2018-06-15 14:12:20', '待处理', '', 'oC9yV5IbgeaLrGfM8tSLSO8Jmj0c'), ('18', '3', '', '', '2018-06-15 14:31:52', '待处理', '', 'oC9yV5IbgeaLrGfM8tSLSO8Jmj0c'), ('19', '3', '', '', '2018-06-15 14:31:53', '待处理', '', 'oC9yV5IbgeaLrGfM8tSLSO8Jmj0c'), ('20', '3', '', '', '2018-06-15 15:14:09', '已处理', '', 'oC9yV5KjYiv_zu6qJ0pm_WlN4LEk'), ('21', '3', 'xx', '123', '2018-06-19 12:59:15', '已处理', 'xx', 'oC9yV5KjYiv_zu6qJ0pm_WlN4LEk'), ('22', '3', '费园园', '15940471397', '2018-06-21 18:54:26', '已处理', '明天上午', 'oC9yV5KjYiv_zu6qJ0pm_WlN4LEk'), ('23', '3', '', '', '2018-06-22 13:29:45', '待处理', '', 'oC9yV5KjYiv_zu6qJ0pm_WlN4LEk');
COMMIT;

-- ----------------------------
--  Table structure for `lesson`
-- ----------------------------
DROP TABLE IF EXISTS `lesson`;
CREATE TABLE `lesson` (
  `lid` int(11) NOT NULL AUTO_INCREMENT,
  `lname` varchar(255) DEFAULT NULL,
  `imgurl` varchar(255) DEFAULT NULL,
  `lprice` double DEFAULT NULL,
  `ldesc` text,
  `category` varchar(255) DEFAULT NULL,
  `qid` int(11) DEFAULT NULL,
  `pubtime` datetime DEFAULT NULL,
  `status` varchar(24) DEFAULT NULL,
  PRIMARY KEY (`lid`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `lesson`
-- ----------------------------
BEGIN;
INSERT INTO `lesson` VALUES ('1', 'Java学习指南——网站开发', 'java1.jpg', '1', '<p><img src=\"upload/java1.jpg\"/></p>', 'JAVA', '1', '2018-07-15 20:47:36', '进行中'), ('2', 'Java快速入门', 'java2.jpg', '1', '<img src=\"upload/java2.jpg\"/>', 'JAVA', '1', '2018-07-15 20:47:39', '进行中'), ('4', 'Java学习指南——基础篇', 'java3.jpg', '1', '<img src=\"upload/java3.jpg\"/>', 'JAVA', '1', '2018-07-15 20:47:41', '进行中'), ('6', 'Java学习指南——高级语法', 'java4.jpg', '1', '<img src=\"upload/java4.jpg\"/>', 'JAVA', '1', '2018-07-15 20:47:43', '进行中'), ('10', 'Java学习指南——网页基础', 'java5.jpg', '1', '<img src=\"upload/java5.jpg\"/>', 'JAVA', '1', '2018-07-15 20:47:45', '进行中'), ('66', 'TensorFlow实用课程——深度学习大讲堂', 'ai1.jpg', '1', '<p><img src=\"upload/ai1.jpg\"/></p>', 'C++', '1', '2018-07-15 19:55:59', '进行中'), ('67', 'Python——机器学习实战', 'ai2.jpg', '1', '<img src=\"upload/ai2.jpg\"/>', 'Python', '1', '2018-07-15 20:47:11', '进行中'), ('68', 'C/C++学习指南——Qt界面篇', 'c1.jpg', '1', '<img src=\"upload/c1.jpg\"/>', 'C++', '1', '2018-07-15 20:47:17', '进行中'), ('69', 'C/C++学习指南——快速语法', 'c2.jpg', '1', '<img src=\"upload/c2.jpg\"/>', 'C++', '1', '2018-07-15 20:47:19', '进行中'), ('70', 'C/C++学习指南——应用篇', 'c3.jpg', '1', '<img src=\"upload/c3.jpg\"/>', 'C++', '1', '2018-07-15 20:47:24', '进行中'), ('71', 'HTML5、CSS3网站实战项目', 'html1.jpg', '1', '<img src=\"upload/html1.jpg\"/>', 'HTML5', '1', '2018-07-15 20:47:27', '进行中'), ('72', 'Web前端开发', 'html2.jpg', '1', '<img src=\"upload/html2.jpg\"/>', 'HTML5', '1', '2018-07-15 20:47:31', '进行中'), ('73', 'Java学习指南——网站开发', 'java1.jpg', '1', '<img src=\"upload/java1.jpg\"/>', 'JAVA', '1', '2018-07-15 20:47:36', '进行中'), ('74', 'Java快速入门', 'java2.jpg', '1', '<img src=\"upload/java2.jpg\"/>', 'JAVA', '1', '2018-07-15 20:47:39', '进行中'), ('75', 'Java学习指南——基础篇', 'java3.jpg', '1', '<img src=\"upload/java3.jpg\"/>', 'JAVA', '1', '2018-07-15 20:47:41', '进行中'), ('76', 'Java学习指南——高级语法', 'java4.jpg', '1', '<img src=\"upload/java4.jpg\"/>', 'JAVA', '1', '2018-07-15 20:47:43', '进行中'), ('77', 'Java学习指南——网页基础', 'java5.jpg', '1', '<img src=\"upload/java5.jpg\"/>', 'JAVA', '1', '2018-07-15 20:47:45', '进行中'), ('81', 'JavaScript网站实战项目', 'js1.jpg', '1', '<img src=\"upload/js1.jpg\"/>', 'HTML5', '1', '2018-07-15 20:47:47', '进行中'), ('82', '实用主义——学Python爬虫', 'py1.png', '1', '<img src=\"upload/py1.png\"/>', 'Python', '1', '2018-07-15 20:47:52', '进行中'), ('83', 'Python数据分析——深度学习实战', 'py2.jpg', '1', '<img src=\"upload/py2.jpg\"/>', 'Python', '1', '2018-07-15 20:47:54', '进行中'), ('84', '实用主义——学Python脚本', 'py3.png', '1', '<img src=\"upload/py3.png\"/>', 'Python', '1', '2018-07-15 20:47:56', '进行中'), ('85', 'Python进阶系列——科学计算库Numpy', 'py5.jpg', '1', '<img src=\"upload/py5.jpg\"/>', 'Python', '1', '2018-07-15 20:48:30', '进行中'), ('86', '从零到一——Python网页爬虫攻略', 'py7.jpg', '1', '<img src=\"upload/py7.jpg\"/>', 'Python', '1', '2018-07-15 20:48:32', '进行中'), ('89', 'Golang学习指南1', 'go1.jpg', '1', '<img src=\"upload/go1.jpg\"/>', 'Golang', '1', '2018-07-16 09:19:21', '进行中'), ('90', 'Golang学习指南2', 'go2.jpg', '1', '<img src=\"upload/go2.jpg\"/>', 'Golang', '1', '2018-07-16 09:19:21', '进行中'), ('91', 'Golang学习指南3', 'go3.jpg', '1', '<img src=\"upload/go3.jpg\"/>', 'Golang', '1', '2018-07-16 09:19:21', '进行中'), ('92', 'Golang学习指南4', 'go4.jpg', '1', '<img src=\"upload/go4.jpg\"/>', 'Golang', '1', '2018-07-16 09:19:21', '进行中');
COMMIT;

-- ----------------------------
--  Table structure for `lessonbranch`
-- ----------------------------
DROP TABLE IF EXISTS `lessonbranch`;
CREATE TABLE `lessonbranch` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lid` int(11) DEFAULT NULL,
  `branchid` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=108 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `lessonbranch`
-- ----------------------------
BEGIN;
INSERT INTO `lessonbranch` VALUES ('2', '67', '1'), ('3', '68', '1'), ('4', '69', '1'), ('5', '70', '1'), ('6', '71', '1'), ('7', '72', '1'), ('8', '73', '1'), ('9', '74', '1'), ('10', '75', '1'), ('11', '76', '2'), ('12', '77', '2'), ('13', '78', '2'), ('14', '79', '2'), ('15', '80', '2'), ('16', '81', '2'), ('17', '82', '2'), ('18', '83', '2'), ('19', '84', '2'), ('20', '85', '2'), ('21', '86', '2'), ('24', '89', '3'), ('25', '90', '3'), ('26', '91', '3'), ('27', '92', '3'), ('95', '66', '1'), ('96', '66', '7'), ('98', '2', '1'), ('99', '4', '1'), ('100', '6', '1'), ('101', '10', '1'), ('105', '1', '1'), ('106', '1', '2'), ('107', '1', '7');
COMMIT;

-- ----------------------------
--  Table structure for `message`
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `mtitle` varchar(255) DEFAULT NULL,
  `mtime` datetime DEFAULT NULL,
  `qid` int(11) DEFAULT NULL,
  `branchid` int(11) DEFAULT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `message`
-- ----------------------------
BEGIN;
INSERT INTO `message` VALUES ('2', '无阅读不生活', '2018-06-19 15:49:56', '1', '2'), ('3', '无阅读不生活3', '2018-06-19 15:49:56', '1', '2'), ('4', '欲买桂花同载酒', '2018-07-13 23:10:03', '1', '1'), ('5', '寄言全盛红颜子，', '2018-07-15 19:15:45', '1', '1'), ('6', '我是一个粉刷匠，编码能力强', '2018-07-16 23:22:33', '1', '2'), ('7', '看看今天的心情', '2018-07-16 23:28:09', '1', '1');
COMMIT;

-- ----------------------------
--  Table structure for `messageimg`
-- ----------------------------
DROP TABLE IF EXISTS `messageimg`;
CREATE TABLE `messageimg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mid` int(11) DEFAULT NULL,
  `imgurl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `messageimg`
-- ----------------------------
BEGIN;
INSERT INTO `messageimg` VALUES ('5', '2', '3.jpg'), ('6', '2', '1.jpg'), ('7', '3', '1.jpg'), ('8', '5', '2.jpg'), ('9', '6', '153175456051699a628f40ddbf18b3952797796b53a17.jpg'), ('10', '7', '1531754895782d0130505d31a274a7d5cfe7965689e26.jpg');
COMMIT;

-- ----------------------------
--  Table structure for `messagelike`
-- ----------------------------
DROP TABLE IF EXISTS `messagelike`;
CREATE TABLE `messagelike` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mid` int(11) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `stime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `messagelike`
-- ----------------------------
BEGIN;
INSERT INTO `messagelike` VALUES ('7', '2', '费园园', '2018-06-21 19:00:12'), ('8', '3', '费园园', '2018-06-21 19:00:12');
COMMIT;

-- ----------------------------
--  Table structure for `messagereply`
-- ----------------------------
DROP TABLE IF EXISTS `messagereply`;
CREATE TABLE `messagereply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mid` int(11) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `stime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `messagereply`
-- ----------------------------
BEGIN;
INSERT INTO `messagereply` VALUES ('1', '2', '哈哈', '费园园', '2018-06-21 18:27:26'), ('2', '3', '哈哈', '费园园', '2018-06-21 18:27:26'), ('7', '2', '我也不是很清楚', '费园园', '2018-07-12 14:56:31');
COMMIT;

-- ----------------------------
--  Table structure for `refund`
-- ----------------------------
DROP TABLE IF EXISTS `refund`;
CREATE TABLE `refund` (
  `oid` int(11) NOT NULL,
  `refundreason` varchar(3000) DEFAULT NULL,
  `refundtime` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `refund`
-- ----------------------------
BEGIN;
INSERT INTO `refund` VALUES ('43', '', '2018-05-26 12:28:10', null), ('44', '', '2018-05-26 12:29:26', null), ('45', '', '2018-05-26 12:32:20', null), ('46', '做', '2018-05-26 12:40:15', null), ('50', '111', '2018-05-26 14:22:38', '待处理'), ('54', '', '2018-05-26 14:21:51', '待处理'), ('55', '', '2018-05-26 14:20:43', '待处理'), ('63', '', '2018-06-15 11:33:18', '待处理'), ('69', '', '2018-06-19 14:38:27', '待处理'), ('70', '', '2018-06-19 14:37:24', '已处理'), ('71', '', '2018-06-19 16:53:55', '已处理'), ('72', '', '2018-06-21 18:56:55', '已处理');
COMMIT;

-- ----------------------------
--  Table structure for `sorder`
-- ----------------------------
DROP TABLE IF EXISTS `sorder`;
CREATE TABLE `sorder` (
  `oid` int(11) NOT NULL AUTO_INCREMENT,
  `lid` int(11) DEFAULT NULL,
  `openid` varchar(1000) DEFAULT NULL,
  `total` double DEFAULT NULL,
  `cid` varchar(11) DEFAULT NULL,
  `actual` double DEFAULT NULL,
  `status` char(255) DEFAULT NULL,
  `ordertime` datetime DEFAULT NULL,
  `qid` int(11) DEFAULT NULL,
  `transactionid` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `branchid` int(10) DEFAULT NULL,
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `sorder`
-- ----------------------------
BEGIN;
INSERT INTO `sorder` VALUES ('43', '1', 'oC9yV5HNntbgqDyPEg2J0YSY8dC8', '5', null, '5', '已退款', '2018-05-26 12:27:24', '1', '4200000116201805263247934519', null, null, '1'), ('44', '1', 'oC9yV5HNntbgqDyPEg2J0YSY8dC8', '5', null, '5', '已退款', '2018-05-26 12:27:43', '1', '4200000110201805261060715976', null, null, '1'), ('45', '1', 'oC9yV5HNntbgqDyPEg2J0YSY8dC8', '5', null, '5', '已退款', '2018-05-26 12:31:02', '1', '4200000130201805260683103431', null, null, '1'), ('46', '1', 'oC9yV5HNntbgqDyPEg2J0YSY8dC8', '5', null, '5', '已退款', '2018-05-26 12:39:42', '1', '4200000109201805266997780435', null, null, '1'), ('47', '1', 'oC9yV5HNntbgqDyPEg2J0YSY8dC8', '0.01', null, '0.01', '待付款', '2018-05-26 13:57:41', '1', null, null, null, '1'), ('48', '1', 'oC9yV5HNntbgqDyPEg2J0YSY8dC8', '0.01', null, '0.01', '待付款', '2018-05-26 14:03:30', '1', null, null, null, '1'), ('49', '1', 'oC9yV5HNntbgqDyPEg2J0YSY8dC8', '0.01', null, '0.01', '已核销', '2018-05-26 14:04:54', '1', '4200000110201805264729572488', null, null, '1'), ('50', '2', 'oC9yV5HNntbgqDyPEg2J0YSY8dC8', '0.02', null, '0.02', '退款中', '2018-05-26 14:05:22', '1', '4200000130201805266329195070', null, null, '1'), ('51', '1', 'oC9yV5HNntbgqDyPEg2J0YSY8dC8', '0.01', null, '0.01', '待付款', '2018-05-26 14:10:43', '1', null, null, null, '1'), ('52', '2', 'oC9yV5HNntbgqDyPEg2J0YSY8dC8', '0.02', null, '0.02', '待付款', '2018-05-26 14:10:50', '1', null, null, null, '1'), ('53', '4', 'oC9yV5HNntbgqDyPEg2J0YSY8dC8', '0.03', null, '0.03', '待付款', '2018-05-26 14:11:35', '1', null, null, null, '1'), ('54', '2', 'oC9yV5HNntbgqDyPEg2J0YSY8dC8', '0.02', null, '0.02', '退款中', '2018-05-26 14:19:35', '1', '4200000110201805263169394125', null, null, '1'), ('55', '4', 'oC9yV5HNntbgqDyPEg2J0YSY8dC8', '0.03', null, '0.03', '退款中', '2018-05-26 14:20:15', '1', '4200000138201805262717162733', null, null, '1'), ('56', '1', 'oC9yV5HNntbgqDyPEg2J0YSY8dC8', '0.01', null, '0.01', '已核销', '2018-06-07 16:46:55', '1', '4200000124201806070328955434', '费园园', '15940471397', '1'), ('57', '1', 'oC9yV5HNntbgqDyPEg2J0YSY8dC8', '0.02', null, '0.02', '已付款', '2018-06-07 17:36:42', '1', '4200000126201806078388299831', '哈哈', '123', '1'), ('58', '1', 'oC9yV5HNntbgqDyPEg2J0YSY8dC8', '100', null, '100', '待付款', '2018-06-07 18:38:05', '1', null, '', '', '1'), ('59', '2', 'oC9yV5HNntbgqDyPEg2J0YSY8dC8', '0.02', null, '0.02', '待付款', '2018-06-07 18:39:49', '1', null, '', '', '1'), ('64', '1', 'oC9yV5KjYiv_zu6qJ0pm_WlN4LEk', '0.01', null, '0.01', '待付款', '2018-06-15 11:31:18', '1', '4200000137201806155057560390', '费园园', '', '1'), ('65', '1', 'oC9yV5HNntbgqDyPEg2J0YSY8dC8', '0.01', null, '0.01', '待付款', '2018-06-15 14:03:47', '1', null, '', '', '1'), ('66', '1', 'oC9yV5HNntbgqDyPEg2J0YSY8dC8', '-99.98', null, '-99.98', '待付款', '2018-06-15 14:51:50', '1', null, '', '', '1'), ('68', '1', 'oC9yV5KjYiv_zu6qJ0pm_WlN4LEk', '0.01', null, '0.01', '已付款', '2018-06-19 13:03:49', '1', null, 'www', '123', '1'), ('70', '6', 'oC9yV5KjYiv_zu6qJ0pm_WlN4LEk', '0.01', null, '0.01', '退款中', '2018-06-19 14:36:52', '1', '4200000136201806193206770784', '给', '', '1'), ('71', '6', 'oC9yV5KjYiv_zu6qJ0pm_WlN4LEk', '0.01', null, '0.01', '已使用', '2018-06-19 16:53:29', '1', '4200000118201806199959334942', '费园', '', '1'), ('73', '10', 'oC9yV5KjYiv_zu6qJ0pm_WlN4LEk', '0.01', null, '0.01', '已退款', '2018-06-22 09:10:34', '1', null, '费园园', '15940471397', '1'), ('74', '1', 'oC9yV5KjYiv_zu6qJ0pm_WlN4LEk', '1', null, '1', '已退款', '2018-07-16 22:21:37', '1', null, '崔志远', '13940210308', '1'), ('79', '66', 'oC9yV5HNntbgqDyPEg2J0YSY8dC8', '1', null, '1', '待付款', '2018-07-17 00:28:21', null, null, 'lala', '12312123', '2'), ('80', '66', 'oC9yV5HNntbgqDyPEg2J0YSY8dC8', '2', null, '2', '待付款', '2018-07-17 08:54:27', null, null, '啥', '1231323', '1'), ('81', '6', 'oC9yV5HNntbgqDyPEg2J0YSY8dC8', '2', null, '2', '待付款', '2018-07-17 08:58:09', null, null, 'dfs', '123123', '1'), ('82', '2', 'oC9yV5HNntbgqDyPEg2J0YSY8dC8', '2', null, '2', '待付款', '2018-07-17 09:06:14', null, null, '魏翔', '13312321323', '1'), ('83', '2', 'oC9yV5HNntbgqDyPEg2J0YSY8dC8', '2', null, '2', '待付款', '2018-07-17 09:09:06', null, null, '出错', '132123', '1');
COMMIT;

-- ----------------------------
--  Table structure for `swiper`
-- ----------------------------
DROP TABLE IF EXISTS `swiper`;
CREATE TABLE `swiper` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `qid` int(11) DEFAULT NULL,
  `imgurl` varchar(255) DEFAULT NULL,
  `category` char(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `swiper`
-- ----------------------------
BEGIN;
INSERT INTO `swiper` VALUES ('1', '1', '1531706038166ç«åèé¼ .gif', 'A'), ('2', '1', 'banner2.jpg', 'A'), ('3', '1', 'banner3.jpg', 'A'), ('4', '1', 'banner4.jpg', 'A');
COMMIT;

-- ----------------------------
--  Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `tname` varchar(255) DEFAULT NULL,
  `tphoto` varchar(255) DEFAULT NULL,
  `introduction` varchar(255) DEFAULT NULL,
  `qid` int(11) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `teacher`
-- ----------------------------
BEGIN;
INSERT INTO `teacher` VALUES ('1', '费园园', '15317908332063.png', '主要从事HTML5、Java开源领域及Android移动开发，在东软集团担任过6年的软件工程师，2年半的HTML5、JAVA培训讲师，承担过东北大学，北交大等重点高校培训项目。', '1'), ('2', '陈伟', 'teacher2.jpg', '有30多年的软件项目开发经验，有10多年的教学经验，熟悉.NET、C#、F#、C语言、Java等编程语言等，擅长C#、Java语言课程。为Microsoft、Intel、AutoDisk、南京大学、东北大学等学校和企业授过课。', '1'), ('3', '宋波', 'teacher3.jpg', ' 12年开发经验，2年教学经验,精通JAVA、C、C++、C#、PHP等多种编程语言，熟悉ios，android移动平台APP开发，语言功底扎实浑厚，精通数据结构和算法，积累多套软件开发框架。', '1');
COMMIT;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(255) NOT NULL,
  `userpassword` varchar(255) NOT NULL,
  `qid` int(11) DEFAULT NULL,
  `jurisdiction` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('adminadmin', 'admin', null, '超级管理员', '1'), ('feiyy', '123456', '1', '管理员', '5'), ('zhaojy', '123456', '19', '管理员', '6');
COMMIT;

-- ----------------------------
--  Table structure for `userlist`
-- ----------------------------
DROP TABLE IF EXISTS `userlist`;
CREATE TABLE `userlist` (
  `uid` int(20) NOT NULL AUTO_INCREMENT,
  `uname` varchar(255) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `openid` varchar(30) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `userlist`
-- ----------------------------
BEGIN;
INSERT INTO `userlist` VALUES ('1', '费园园', '130202020202', 'oC9yV5HNntbgqDyPEg2J0YSY8dC8');
COMMIT;

-- ----------------------------
--  Table structure for `weixin`
-- ----------------------------
DROP TABLE IF EXISTS `weixin`;
CREATE TABLE `weixin` (
  `qid` int(11) NOT NULL,
  `appid` varchar(255) DEFAULT NULL,
  `appsecret` varchar(255) DEFAULT NULL,
  `partner` varchar(255) DEFAULT NULL,
  `partnerkey` varchar(255) DEFAULT NULL,
  `weixinpaycallback` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`qid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Procedure structure for `looppc`
-- ----------------------------
DROP PROCEDURE IF EXISTS `looppc`;
delimiter ;;
CREATE DEFINER=`root`@`%` PROCEDURE `looppc`( )
BEGIN
	DECLARE
		i INT;
	
	SET i = 13;
	REPEAT
			INSERT INTO lesson ( lname, imgurl, lprice, category, qid, pubtime, STATUS )
		VALUES
			( '体验课:万圣节抽符' + i, 'lesson' + i + '.jpg', 0.01, 'Golang', 1, now( ), '进行中' );
		
		SET i = i + 1;
		UNTIL i >= 20 
	END REPEAT;

END
 ;;
delimiter ;

-- ----------------------------
--  Procedure structure for `test_insert`
-- ----------------------------
DROP PROCEDURE IF EXISTS `test_insert`;
delimiter ;;
CREATE DEFINER=`root`@`%` PROCEDURE `test_insert`()
BEGIN 

DECLARE i INT DEFAULT 1;

WHILE i<5
DO 
	
 update freelisten set imgurl=CONCAT('banner',i,'.jpg') where id=i+48;
	SET i=i+1;
  
END WHILE ; 
commit; 

END
 ;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
