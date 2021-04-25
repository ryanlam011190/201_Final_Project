CREATE TABLE Users (
	ID int(3) PRIMARY KEY NOT NULL auto_increment,
    email varchar(20) DEFAULT NULL,
    username varchar(20) DEFAULT NULL,
    passw varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE Favorites (
	ID int(3) PRIMARY KEY NOT NULL auto_increment,
    ticker VARCHAR(20) DEFAULT NULL,
    price varchar(20) DEFAULT NULL,
    company VARCHAR(20) DEFAULT NULL,
    profit VARCHAR(20) DEFAULT NULL
);