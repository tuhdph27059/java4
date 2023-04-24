CREATE DATABASE hibernate_demo;

USE hibernate_demo;

CREATE TABLE hibernate_demo.category (
	id BIGINT auto_increment NOT NULL,
	category_code varchar(100) NULL,
	category_name varchar(100) NULL,
	CONSTRAINT category_PK PRIMARY KEY (id)
)

CREATE TABLE hibernate_demo.product (
	id BIGINT auto_increment NOT NULL,
	category_id BIGINT NULL,
	product_code varchar(100) NULL,
	product_name varchar(100) NULL,
	price FLOAT NULL,
	description varchar(100) NULL,
	CONSTRAINT product_PK PRIMARY KEY (id),
	CONSTRAINT product_FK FOREIGN KEY (category_id) REFERENCES hibernate_demo.category(id)
)

INSERT INTO hibernate_demo.category
(id, category_code, category_name)
VALUES(1, 'C01', 'Cate1');
INSERT INTO hibernate_demo.category
(id, category_code, category_name)
VALUES(2, 'C02', 'Cate2');
INSERT INTO hibernate_demo.category
(id, category_code, category_name)
VALUES(3, 'C03', 'Cate3');

INSERT INTO hibernate_demo.product
(id, category_id, product_code, product_name, price, description)
VALUES(1, 1, 'P01', 'product 1', 10.0, 'aaaa');
INSERT INTO hibernate_demo.product
(id, category_id, product_code, product_name, price, description)
VALUES(2, 1, 'P02', 'product 2', 11.0, 'ggg');
INSERT INTO hibernate_demo.product
(id, category_id, product_code, product_name, price, description)
VALUES(3, 2, 'P03', 'product 3', 111.0, 'hfhf');
INSERT INTO hibernate_demo.product
(id, category_id, product_code, product_name, price, description)
VALUES(4, 1, 'P04', 'product 4', 243.0, 'jsnd');
