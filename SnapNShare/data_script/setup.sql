create database snapnshare;

use snapnshare;

CREATE TABLE `snapnshare`.`user` (
  `username` VARCHAR(256) NOT NULL,
  `friends` VARCHAR(1024) NULL,
  PRIMARY KEY (`username`));
  
CREATE TABLE `snapnshare`.`photos` (
  `imagename` VARCHAR(256) NOT NULL,
  `postedby` VARCHAR(256) NULL,
  `comment` VARCHAR(1024) NULL,
  `url` VARCHAR(256) NULL,
  `posttime` DATETIME NULL,
  PRIMARY KEY (`imagename`));