CREATE DATABASE spring_boot_demo DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

USE spring_boot_demo;

CREATE TABLE roncoo_user (
id INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
name VARCHAR(255) DEFAULT NULL COMMENT '用户名',
create_time DATETIME DEFAULT NULL COMMENT '创建时间',
PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='用户表';