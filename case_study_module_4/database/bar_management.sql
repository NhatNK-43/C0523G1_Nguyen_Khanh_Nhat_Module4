create database bar_management;
use bar_management;

create table positions(
	id int primary key,
    name varchar(50) not null
);

create table employee(
	id int primary key auto_increment,
    name varchar(50) not null,
    date_of_birth date not null,
    gender bit(1) not null,
    id_card varchar(50) not null unique,
    phone_number varchar(50) not null unique,
    address varchar(50),
    position_id int,
    salary double not null,
    user_name varchar(50) not null unique,
    `password` varchar(50) not null,
    is_delete bit(1) default 0,
    foreign key (position_id) references positions(id)
);

create table customer_type(
	id int primary key,
    name varchar(50)
);

create table customer(
	id int primary key auto_increment,
    name varchar(50) not null,
    date_of_birth date not null,
    gender bit(1) not null,
    id_card varchar(50) not null,
    phone_number varchar(50) not null,
    address varchar(50),
	customer_type_id int,
	is_delete bit(1) default 0,
    foreign key (customer_type_id) references customer_type(id)
);

create table table_type(
	id int primary key,
    name varchar(50) not null,
    surcharge double
);

create table table_status(
	id int primary key,
    name varchar(50) not null
);

create table table_bar(
	id int primary key auto_increment,
    name varchar(50) not null,
    table_type_id int,
    table_status_id int,
    is_delete bit(1) default 0,
    foreign key (table_type_id) references table_type(id),
    foreign key (table_status_id) references table_status(id)
);

create  table commodity_type(
	id int primary key,
	name varchar(50) not null
);

create table commodity_unit(
	id int primary key,
    name varchar(50)
);

create table commodity(
	id int primary key auto_increment,
    name varchar(50) not null,
    commodity_unit_id int not null,
    price double not null,
    commodity_type_id int,
    is_delete bit(1) default 0,
    foreign key (commodity_type_id) references commodity_type(id),
    foreign key (commodity_unit_id) references commodity_unit(id)
);

create table orders(
	id int primary key auto_increment,
	table_bar_id int not null,
    customer_id int not null,
    employee_id int not null,
    order_datetime datetime not null,
    foreign key (table_bar_id) references table_bar(id),
    foreign key (customer_id) references customer(id),
    foreign key (employee_id) references employee(id)
);

create table order_details(
	id int primary key auto_increment,
    commodity_id int not null,
    order_id int not null,
    mount double,
    foreign key (commodity_id) references commodity(id),
    foreign key (order_id) references orders(id)
);


create table pay(
	id int primary key auto_increment,
    table_bar_id int not null,
    total_payment double not null,
    foreign key (table_bar_id) references table_bar(id)
);
ALTER USER "root"@"localhost" IDENTIFIED BY "123456";