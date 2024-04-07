
DROP DATABASE IF EXISTS fwdb;
CREATE DATABASE `fwdb` ;

USE `fwdb`;

/*Table structure for table `food` */

CREATE TABLE `food` (
  `fid` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(50) DEFAULT NULL,
  `expiration` date DEFAULT NULL,
  `price` decimal(8,0) DEFAULT NULL,
  `inventory` int(11) DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `ftid` int(11) DEFAULT NULL,
  `is_donate` int(11) DEFAULT '0',
  `store_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `food` */

insert  into `food`(`fid`,`fname`,`expiration`,`price`,`inventory`,`discount`,`ftid`,`is_donate`,`store_id`) values (1,'beaf','2024-04-09','12',7,1,5,1,1);
insert  into `food`(`fid`,`fname`,`expiration`,`price`,`inventory`,`discount`,`ftid`,`is_donate`,`store_id`) values (2,'coco','2024-04-20','19',9,0.7,3,0,1);
insert  into `food`(`fid`,`fname`,`expiration`,`price`,`inventory`,`discount`,`ftid`,`is_donate`,`store_id`) values (3,'fish','2024-04-13','5',10,1,5,0,2);
insert  into `food`(`fid`,`fname`,`expiration`,`price`,`inventory`,`discount`,`ftid`,`is_donate`,`store_id`) values (4,'rice','2024-04-13','6',10,1,2,0,2);


/*Table structure for table `food_type` */

CREATE TABLE `food_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `food_type` */

insert  into `food_type`(`id`,`name`) values (1,'drink');
insert  into `food_type`(`id`,`name`) values (2,'bread');
insert  into `food_type`(`id`,`name`) values (3,'fruit');
insert  into `food_type`(`id`,`name`) values (4,'snack');
insert  into `food_type`(`id`,`name`) values (5,'meat');
insert  into `food_type`(`id`,`name`) values (6,'vegetables');

/*Table structure for table `orders` */

CREATE TABLE `orders` (
  `oid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `fid` int(11) DEFAULT NULL,
  `money` decimal(8,2) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  PRIMARY KEY (`oid`)
)ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `orders` */

insert  into `orders`(`oid`,`uid`,`fid`,`money`,`num`) values (2,3,1,NULL,1);
insert  into `orders`(`oid`,`uid`,`fid`,`money`,`num`) values (3,3,1,NULL,1);
insert  into `orders`(`oid`,`uid`,`fid`,`money`,`num`) values (4,1,2,'19.00',1);
insert  into `orders`(`oid`,`uid`,`fid`,`money`,`num`) values (5,1,2,'19.00',1);
insert  into `orders`(`oid`,`uid`,`fid`,`money`,`num`) values (6,1,2,'26.60',2);
insert  into `orders`(`oid`,`uid`,`fid`,`money`,`num`) values (7,3,1,NULL,1);

/*Table structure for table `store` */



CREATE TABLE `store` (

  `store_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'No',

  `store_name` varchar(50) DEFAULT NULL COMMENT 'name',

  `city` varchar(50) DEFAULT NULL COMMENT 'city',

  `uid` int(11) DEFAULT NULL COMMENT 'Retailer id',

  PRIMARY KEY (`store_id`)

) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;



/*Data for the table `store` */



insert  into `store`(`store_id`,`store_name`,`city`,`uid`) values (1,'Store 1','Ottawa',2);

insert  into `store`(`store_id`,`store_name`,`city`,`uid`) values (2,'Store 2','Toronto',4);

/*Table structure for table `subscribe` */

CREATE TABLE `subscribe` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `fid` int(11) DEFAULT NULL,
  `create_time` date DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `subscribe` */

/*Table structure for table `user` */

CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `user_type` varchar(20) DEFAULT NULL,
  `last_login` datetime DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `user` */


insert  into `user`(`uid`,`name`,`email`,`password`,`user_type`,`last_login`) values (1,'consumer','consumer@163.com','123','consumer','2024-04-07 14:16:01');

insert  into `user`(`uid`,`name`,`email`,`password`,`user_type`,`last_login`) values (2,'retailer','retailer@111.com','123','retailer','2024-04-07 14:09:15');

insert  into `user`(`uid`,`name`,`email`,`password`,`user_type`,`last_login`) values (3,'org','org@11.com','123','organization','2024-04-07 14:07:53');

insert  into `user`(`uid`,`name`,`email`,`password`,`user_type`,`last_login`) values (4,'ddd','ccc@11.com','123','retailer','2024-04-07 14:09:49');
