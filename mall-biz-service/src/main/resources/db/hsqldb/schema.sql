DROP TABLE tbl_product IF EXISTS;
CREATE TABLE tbl_product (
  code VARCHAR(10) PRIMARY KEY,
  name VARCHAR(80),
  description VARCHAR(80)
);
CREATE INDEX tbl_product_name ON tbl_product (name);



DROP TABLE tbl_order IF EXISTS;
CREATE TABLE tbl_order (
  pk INTEGER IDENTITY PRIMARY KEY,
  creationTime TIMESTAMP,
  modifiedTime TIMESTAMP,
  code VARCHAR(255),
  totalPrice DECIMAL(10,2),
  owner VARCHAR(255)
);
CREATE INDEX tbl_order_code ON tbl_order (code);