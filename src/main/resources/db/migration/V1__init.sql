create table if not exists students(id bigserial primary key, name varchar(255), score int);

insert into students(name, score) values ('Bob', 10), ('Mike', 20), ('Niki', 25);