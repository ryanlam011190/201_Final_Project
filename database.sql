DROP database if exists FinalProject;
CREATE DATABASE FinalProject;
USE FinalProject;
CREATE TABLE Users (
	ID INT(11) primary key not null auto_increment,
    username varchar(45) not null,
    passw varchar(45) not null,
    usc_email varchar(45) not null,
    fname varchar(45) not null,
    lname varchar(45) not null
);
INSERT INTO Users(username, passw, usc_email, fname, lname) VALUES('rhlam', '123456', 'rhlam@usc.edu', 'ryan', 'lam');