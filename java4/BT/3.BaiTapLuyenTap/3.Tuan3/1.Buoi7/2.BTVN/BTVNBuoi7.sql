CREATE DATABASE BTVNBuoi7;

USE BTVNBuoi7;

CREATE TABLE BTVNBuoi7.giang_vien (
	mssv varchar(100) NOT NULL,
	ten varchar(100) NULL,
	tuoi BIGINT NULL,
	gioi_tinh BIT NULL,
	que_quan varchar(100) NULL,
	CONSTRAINT giang_vien_PK PRIMARY KEY (mssv)
)