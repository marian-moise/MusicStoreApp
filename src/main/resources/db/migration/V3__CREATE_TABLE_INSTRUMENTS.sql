
CREATE TABLE  music_store.instruments (
  id BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  sku VARCHAR(255) DEFAULT NULL,
  name VARCHAR(255) DEFAULT NULL,
  description VARCHAR(1000) DEFAULT NULL,
  unit_price DECIMAL(13,2) DEFAULT NULL,
  image_url VARCHAR(255) DEFAULT NULL
)
