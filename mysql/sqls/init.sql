-- init.sql
USE test;

CREATE TABLE IF NOT EXISTS member (
    id_num INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(200) NOT NULL,
    password VARCHAR(300) NOT NULL,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS token_store (
    to_num INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    refresh TEXT NOT NULL,
    expiration VARCHAR(100) NOT NULL
);

INSERT INTO MEMBER (username, password, name) VALUES ('test', '1234', '12313');