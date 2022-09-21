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

insert into product(name, quantity, price, type, provider) values ('Iphone 8' , 1000, 3000, 'Celular', 'Apple');
insert into product(name, quantity, price, type, provider) values ('Iphone 14', 1000, 13000, 'Celular', 'Apple');
insert into product(name, quantity, price, type, provider) values ('Macbook', 1000, 23000, 'Notebook', 'Apple');
insert into product(name, quantity, price, type, provider) values ('Ipod', 1000, 500, 'Fone de ouvido', 'Apple');
insert into product(name, quantity, price, type, provider) values ('Galaxy 22S', 1000, 4000, 'Celular', 'Samsung');
insert into product(name, quantity, price, type, provider) values ('Notebook Sansung', 1000, 8000, 'Notebook', 'Samsung');

select * from product;
