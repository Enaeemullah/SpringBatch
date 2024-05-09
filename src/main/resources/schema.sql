CREATE TABLE IF NOT EXISTS products (
    product_id VARCHAR(100) PRIMARY KEY,
    title VARCHAR(200),
    description VARCHAR(200),
    price VARCHAR(10),
    discount VARCHAR(10),
    discounted_price VARCHAR(10)
);

CREATE TABLE IF NOT EXISTS customers (
    customer_id VARCHAR(100) PRIMARY KEY,
    name VARCHAR(200),
    email VARCHAR(200),
    address VARCHAR(100)
);
