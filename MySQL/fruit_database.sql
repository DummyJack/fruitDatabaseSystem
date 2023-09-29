-- 創建資料庫
create database `fruit_database`;

use `fruit_database`;

-- 創建 user table
create table `t_user`(
    `id` int AUTO_INCREMENT not null primary key,
    `username` varchar(20),
    `password` varchar(20)
);

-- 創建 fruit table
create table `fruit`(
	`fruit_id` varchar(13) not null primary key,
    `fruit_name` varchar(45),
    `fruit_supplier_name` varchar(45),
    `quantity` int,
    `unit` varchar(2),
    `prime_cost` float,
    `current_price` float,
    `location` varchar(45),
    `date_of_input` date,
    `start_promotion_date` date,
    `disposal_date` date
);

-- 創建 member table
create table `member`(
	`member_id` varchar(10) not null PRIMARY KEY, 
    `member_name` varchar(45),
    `phone` varchar(45),
    `smartphone` varchar(45),
    `email` varchar(256),
    `joinLine` varchar(2),
    `address` varchar(45),
    `age` int,
    `photo` blob,
    `discount` float,
    constraint member check(email REGEXP '^[a-zA-Z0-9][a-zA-Z0-9._+-]*[a-zA-Z0-9_-]@[a-zA-Z0-9][a-zA-Z0-9._-]*[a-zA-Z0-9]+..[a-zA-Z]{2,4}$')
);

-- 創建 supplier table
create table `supplier`(
	`supplier_id` int AUTO_INCREMENT not null primary key,
    `supplier_name` varchar(45),
    `supplier_phone` varchar(45),
    `supplier_email` varchar(256),
    `supplier_address` varchar(45),
    `responsible_person` varchar(45),
    constraint supplier check(supplier_email REGEXP '^[a-zA-Z0-9][a-zA-Z0-9._+-]*[a-zA-Z0-9_-]@[a-zA-Z0-9][a-zA-Z0-9._-]*[a-zA-Z0-9]+..[a-zA-Z]{2,4}$')
);

-- 創建 trade table
create table `trade`(
	`trade_fruit_id` varchar(13),
    `trade_member_id` varchar(10),
	`trade_fruit_name` varchar(45),
    `trade_fruit_supplier_name` varchar(45),
    `purchase_quantity` int,
    `sell_price` float,
    `total_price` float,
    `discount_price` float,
    `transaction_date` date,
    `estimated_delivery_date` date,
    `actual_delivery_date` date,
    PRIMARY KEY(`trade_fruit_id`, `trade_member_id`),
    Foreign Key (trade_fruit_id) REFERENCES `fruit`(`fruit_id`) on delete cascade on update cascade,
    Foreign Key (trade_member_id) REFERENCES `member`(`member_id`) on delete cascade on update cascade
);