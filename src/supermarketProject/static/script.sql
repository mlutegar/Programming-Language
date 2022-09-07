create database if not exists supermarket;

use supermarket;

create table if not exists product(
    id int primary key auto_increment,
    name varchar(150) not null unique,
    quantity int not null,
    price float not null,
    type varchar(150) not null,
    provider varchar(150) not null,
    register TIMESTAMP not null default CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

select * from product;
