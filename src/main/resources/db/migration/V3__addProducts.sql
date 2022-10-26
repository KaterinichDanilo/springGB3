create table if not exists products(id bigserial primary key, title varchar(255), price int);

insert into products(title, price) values ('milk', 10), ('bread', 5), ('potato', 8), ('carrot', 9), ('apple', 10);