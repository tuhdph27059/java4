CREATE DATABASE BTVNBuoi9;

USE BTVNBuoi9;

CREATE TABLE BTVNBuoi9.giang_vien (
	id BIGINT auto_increment NOT NULL,
	ma varchar(100) NULL,
	ten varchar(100) NULL,
	tuoi BIGINT NULL,
	gioi_tinh BIT NULL,
	dia_chi varchar(100) NULL,
	CONSTRAINT giang_vien_PK PRIMARY KEY (id)
)

CREATE TABLE BTVNBuoi9.tai_khoan (
	username varchar(100) NOT NULL,
	password varchar(100) NULL,
	CONSTRAINT tai_khoan_PK PRIMARY KEY (username)
)