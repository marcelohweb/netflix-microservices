CREATE DATABASE IF NOT EXISTS db_netflix_app;

USE db_netflix_app;

--
-- Category table
--

CREATE TABLE category (
  id CHAR(36) NOT NULL,
  name VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

--
-- Movie table
--

CREATE TABLE movie (
  id CHAR(36) NOT NULL,
  title VARCHAR(50) NOT NULL,
  category_id VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_movie_category FOREIGN KEY (category_id) REFERENCES category(id)
);
