CREATE DATABASE IF NOT EXISTS single_mall_db;
#GRANT ALL PRIVILEGES ON single_mall_db.* TO root@'%' with grant option;

USE single_mall_db;

CREATE TABLE IF NOT EXISTS tbl_product (
  code VARCHAR(10),
  name VARCHAR(80),
  description VARCHAR(80),
  PRIMARY KEY (`code`),
  INDEX(`name`)
) engine=InnoDB;



CREATE TABLE IF NOT EXISTS tbl_order (
  pk INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  creationTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modifiedTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  code VARCHAR(255),
  totalPrice DECIMAL(10,2),
  INDEX(`code`)
) engine=InnoDB;
