CREATE  TABLE IF NOT EXISTS mg_products
(
    product_id varchar(100) primary key,
    title varchar(200),
    description varchar(200),
    price varchar(10),
    discount varchar(10),
    discounted_price varchar(10)
);


CREATE  TABLE IF NOT EXISTS mg_customers
(
    user_id varchar(100) primary key,
    title varchar(200),
    professional varchar(200),
    age varchar(10)
);