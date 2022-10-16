create table if not exists books(id bigserial primary key, title varchar(255), price int);

insert into books(title, price) values ('Bob', 10), ('Mike', 20), ('Niki', 25);