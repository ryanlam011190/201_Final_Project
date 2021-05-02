DROP DATABASE if exists finalproject;
CREATE DATABASE finalproject;
USE finalproject;
CREATE TABLE Users (
	ID int PRIMARY KEY NOT NULL auto_increment,
    email varchar(45) DEFAULT NULL,
    username varchar(45) DEFAULT NULL,
    passw varchar(45) DEFAULT NULL
)