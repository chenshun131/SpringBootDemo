DROP DATABASE db0;

CREATE DATABASE db0;

USE db0;

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

INSERT INTO t_order_0 (order_id, user_id) VALUES (11002, 2);
INSERT INTO t_order_0 (order_id, user_id) VALUES (11004, 2);
INSERT INTO t_order_0 (order_id, user_id) VALUES (11006, 4);
INSERT INTO t_order_0 (order_id, user_id) VALUES (11008, 4);

INSERT INTO t_order_1 (order_id, user_id) VALUES (12001, 1);
INSERT INTO t_order_1 (order_id, user_id) VALUES (12003, 1);
INSERT INTO t_order_1 (order_id, user_id) VALUES (12005, 3);
INSERT INTO t_order_1 (order_id, user_id) VALUES (12007, 3);
