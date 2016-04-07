CREATE DATABASE currency;

GRANT ALL ON currency.* TO currencyuser@'%' IDENTIFIED BY 'pcurrencyuser';
GRANT ALL ON currency.* TO currencyuser@localhost IDENTIFIED BY 'pcurrencyuser';

USE currency;

CREATE TABLE country (
	id SMALLINT UNSIGNED not null AUTO_INCREMENT,
	country char(255),
	PRIMARY KEY (id)
);

CREATE TABLE users (
  name char(255),
  password char(255) not null,
  email char(255),
  dob datetime,
  street char(255),
  zipcode char(255),
  city char(255),
  country SMALLINT UNSIGNED not null,
  PRIMARY KEY(name),
  FOREIGN KEY (country) REFERENCES country(id) ON DELETE CASCADE
);
CREATE INDEX users_name ON users(name);

CREATE TABLE historical (
  id SMALLINT UNSIGNED not null AUTO_INCREMENT,
  name char(255),
  currency char(3) not null,
  currencyValue double not null,
  dateCurrency datetime not null,
  dateQuery timestamp DEFAULT CURRENT_TIMESTAMP,
  	PRIMARY KEY (id),
  	FOREIGN KEY (name) REFERENCES users(name) ON DELETE CASCADE
);

