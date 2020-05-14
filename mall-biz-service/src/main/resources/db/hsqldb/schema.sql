DROP TABLE tbl_product IF EXISTS;

CREATE TABLE tbl_product (
  code VARCHAR(10) PRIMARY KEY,
  name VARCHAR(80),
  description VARCHAR(80)
);
CREATE INDEX tbl_product_name ON tbl_product (name);

