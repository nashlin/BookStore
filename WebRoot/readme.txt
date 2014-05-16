create database bookstore;
use bookstore;
create table category(
id varchar(40) primary key,
name varchar(40) not null unique,
description varchar(200) not null
);

use bookstore;
create table book(
id varchar(40) primary key,
name varchar(40) not null unique,
author varchar(40) not null,
price varchar(40) not null,
image varchar(40) not null,
description varchar(200) not null,
category_id varchar(40),
constraint category_id_fk foreign key (category_id) references category(id)
);

use bookstore;
create table user(
id varchar(40) primary key,
username varchar(40) not null,
password varchar(40) not null,
cellphone varchar(40),
address varchar(40),
email varchar(40) not null
);

use bookstore;
create table orders(
	id varchar(40) primary key,
	date datetime not null,
	totalprice float(10,2) not null,
	status int not null,
	user_id varchar(40) not null,
	constraint user_id_fk foreign key (user_id) references user(id) 
);


use bookstore;
create table orderitem(
	id varchar(40) primary key,
	num int not null,
	price float(10,2) not null,
	book_id varchar(40) not null,
	orders_id varchar(40) not null,
	constraint book_id_fk foreign key (book_id) references book(id),
	constraint orders_id_fk foreign key (orders_id) references orders(id)
);