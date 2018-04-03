DROP DATABASE db1;

CREATE DATABASE db1;

USE db1;

CREATE TABLE IF NOT EXISTS t_order_0 (
  order_id INT NOT NULL,
  user_id  INT NOT NULL,
  PRIMARY KEY (order_id)
);

CREATE TABLE IF NOT EXISTS t_order_1 (
  order_id INT NOT NULL,
  user_id  INT NOT NULL,
  PRIMARY KEY (order_id)
);

CREATE TABLE IF NOT EXISTS t_order_item_0 (
  item_id  INT NOT NULL,
  order_id INT NOT NULL,
  user_id  INT NOT NULL,
  PRIMARY KEY (item_id)
);

CREATE TABLE IF NOT EXISTS t_order_item_1 (
  item_id  INT NOT NULL,
  order_id INT NOT NULL,
  user_id  INT NOT NULL,
  PRIMARY KEY (item_id)
);

INSERT INTO t_order_0 (order_id, user_id) VALUES (21002, 2);
INSERT INTO t_order_0 (order_id, user_id) VALUES (21004, 2);
INSERT INTO t_order_0 (order_id, user_id) VALUES (21006, 4);
INSERT INTO t_order_0 (order_id, user_id) VALUES (21008, 4);

INSERT INTO t_order_1 (order_id, user_id) VALUES (22001, 1);
INSERT INTO t_order_1 (order_id, user_id) VALUES (22003, 1);
INSERT INTO t_order_1 (order_id, user_id) VALUES (22005, 3);
INSERT INTO t_order_1 (order_id, user_id) VALUES (22007, 3);
