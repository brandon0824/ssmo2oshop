USE o2o;
CREATE TABLE `tb_area` (
	`area_id` INT ( 2 ) NOT NULL AUTO_INCREMENT,
	`area_name` VARCHAR ( 200 ) NOT NULL,
	`priority` INT ( 2 ) NOT NULL,
	`create_time` datetime DEFAULT NULL,
	`last_edit_time` datetime DEFAULT NULL,
	PRIMARY KEY ( `area_id` ),
	UNIQUE KEY `UK_AREA` ( `area_name` ) 
) ENGINE = INNODB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8;



CREATE TABLE `tb_person_info` (
	`user_id` INT ( 10 ) NOT NULL auto_increment,
	`name` VARCHAR ( 32 ) DEFAULT NULL,
	`profile_img` VARCHAR ( 1024 ) DEFAULT NULL,
	`email` VARCHAR ( 2 ) DEFAULT NULL,
	`gender` VARCHAR ( 2 ) DEFAULT NULL,
	`enable_status` INT ( 2 ) NOT NULL DEFAULT '0' COMMENT '0:禁止使用商城，1:允许使用商城',
	`user_type` INT ( 2 ) NOT NULL DEFAULT '1' COMMENT '1:顾客 2:店家 3:超级管理员',
	`create_time` datetime DEFAULT NULL,
	`last_edit_time` datetime DEFAULT NULL,
	PRIMARY KEY ( `user_id` ) 
) ENGINE = INNODB Auto_increment = 1 DEFAULT CHARSET = utf8;



CREATE TABLE `tb_wechat_auth` (
	`wechat_auth_id` INT ( 10 ) NOT NULL auto_increment,
	`user_id` INT ( 10 ) NOT NULL,
	`open_id` VARCHAR ( 1024 ) NOT NULL,
	`create_time` datetime DEFAULT NULL,
	PRIMARY KEY ( `wechat_auth_id` ),
	CONSTRAINT `fk_wechatauth_profile` FOREIGN KEY ( `user_id` ) REFERENCES `tb_person_info` ( `user_id` ) 
) ENGINE = INNODB auto_increment = 1 DEFAULT CHARSET = utf8;



CREATE TABLE `tb_local_auth` (
	`local_auth_id` INT ( 10 ) NOT NULL auto_increment,
	`user_id` INT ( 10 ) NOT NULL,
	`username` VARCHAR ( 128 ) NOT NULL,
	`password` VARCHAR ( 128 ) NOT NULL,
	`create_time` datetime DEFAULT NULL,
	`last_edit_time` datetime DEFAULT NULL,
	PRIMARY KEY ( `local_auth_id` ),
	UNIQUE KEY `uk_local_profile` ( `username` ),
	CONSTRAINT `fk_localauth_profile` FOREIGN KEY ( `user_id` ) REFERENCES `tb_person_info` ( `user_id` ) 
) ENGINE = INNODB auto_increment = 1 DEFAULT CHARSET = utf8;



ALTER TABLE tb_wechat_auth ADD UNIQUE INDEX ( open_id )



CREATE TABLE `tb_head_line` (
	`line_id` INT ( 100 ) NOT NULL auto_increment,
	`line_name` VARCHAR ( 1000 ) DEFAULT NULL,
	`line_link` VARCHAR ( 2000 ) NOT NULL,
	`line_img` VARCHAR ( 2000 ) NOT NULL,
	`priority` INT ( 2 ) DEFAULT NULL,
	`enable_status` INT ( 2 ) NOT NULL DEFAULT '0',
	`create_time` datetime DEFAULT NULL,
	`last_edit_time` datetime DEFAULT NULL,
PRIMARY KEY ( `line_id` ) 
) ENGINE = INNODB auto_increment = 1 DEFAULT CHARSET = utf8



CREATE TABLE `tb_shop_category` (
	`shop_category_id` INT ( 11 ) NOT NULL auto_increment,
	`shop_category_name` VARCHAR ( 100 ) NOT NULL DEFAULT '',
	`shop_category_desc` VARCHAR ( 1000 ) DEFAULT '',
	`shop_category_img` VARCHAR ( 2000 ) DEFAULT NULL,
	`priority` INT ( 2 ) NOT NULL DEFAULT '0',
	`create_time` datetime DEFAULT NULL,
	`last_edit_time` datetime DEFAULT NULL,
	`parent_id` INT ( 11 ) DEFAULT NULL,
	PRIMARY KEY ( `shop_category_id` ),
	CONSTRAINT `fk_shop_category_self` FOREIGN KEY ( `parent_id` ) REFERENCES `tb_shop_category` ( `shop_category_id` ) 
) ENGINE = INNODB auto_increment = 1 DEFAULT CHARSET = utf8;



CREATE TABLE `tb_shop` (
  `shop_id` int(10) NOT NULL AUTO_INCREMENT,
  `owner_id` int(10) NOT NULL COMMENT '店铺创建人',
  `area_id` int(5) DEFAULT NULL,
  `shop_category_id` int(11) DEFAULT NULL,
  `shop_name` varchar(256) NOT NULL,
  `shop_desc` varchar(1024) DEFAULT NULL,
  `shop_addr` varchar(200) DEFAULT NULL,
  `phone` varchar(128) DEFAULT NULL,
  `shop_img` varchar(1024) DEFAULT NULL,
  `priority` int(3) DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `last_edit_time` datetime DEFAULT NULL,
  `enable_status` int(2) NOT NULL DEFAULT '0',
  `advice` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`shop_id`),
  CONSTRAINT `fk_shop_area` FOREIGN KEY (`area_id`) REFERENCES `tb_area` (`area_id`),
  CONSTRAINT `fk_shop_profile` FOREIGN KEY (`owner_id`) REFERENCES `tb_person_info` (`user_id`),
  CONSTRAINT `fk_shop_shopcate` FOREIGN KEY (`shop_category_id`) REFERENCES `tb_shop_category` (`shop_category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;



CREATE TABLE `tb_product_category` (
  `product_category_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_category_name` varchar(100) NOT NULL,
  `priority` int(2) DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `shop_id` int(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`product_category_id`),
  CONSTRAINT `fk_procate_shop` FOREIGN KEY (`shop_id`) REFERENCES `tb_shop` (`shop_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;



CREATE TABLE `tb_product` (
  `product_id` int(100) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(100) NOT NULL,
  `product_desc` varchar(2000) DEFAULT NULL,
  `img_addr` varchar(2000) DEFAULT '',
  `normal_price` varchar(100) DEFAULT NULL,
  `promotion_price` varchar(100) DEFAULT NULL,
  `priority` int(2) NOT NULL DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `last_edit_time` datetime DEFAULT NULL,
  `enable_status` int(2) NOT NULL DEFAULT '0',
  `product_category_id` int(11) DEFAULT NULL,
  `shop_id` int(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`product_id`),
  CONSTRAINT `fk_product_procate`  FOREIGN KEY (`product_category_id`) REFERENCES `tb_product_category` (`product_category_id`),
  CONSTRAINT `fk_product_shop` FOREIGN KEY (`shop_id`) REFERENCES `tb_shop` (`shop_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;



CREATE TABLE `tb_product_img` (
  `product_img_id` int(20) NOT NULL AUTO_INCREMENT,
  `img_addr` varchar(2000) NOT NULL,
  `img_desc` varchar(2000) DEFAULT NULL,
  `priority` int(2) DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `product_id` int(20) DEFAULT NULL,
  PRIMARY KEY (`product_img_id`),
  CONSTRAINT `fk_proimg_product` FOREIGN KEY (`product_id`) REFERENCES `tb_product` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;




