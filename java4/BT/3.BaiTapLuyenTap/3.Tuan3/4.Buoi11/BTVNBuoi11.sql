CREATE DATABASE BTVNBuoi11;

USE BTVNBuoi11;

CREATE TABLE BTVNBuoi11.sinh_vien (
	ma varchar(100) NOT NULL,
	ten varchar(100) NULL,
	tuoi BIGINT NULL,
	dia_chi varchar(100) NULL,
	gioi_tinh BIT NULL,
	CONSTRAINT sinh_vien_PK PRIMARY KEY (ma)
)