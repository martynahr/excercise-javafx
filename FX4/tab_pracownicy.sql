create database tabeleFX;
use tabeleFX;
create table employee (
id_employee Integer NOT NULL PRIMARY KEY auto_increment,
firstName_employee varchar(15) not null,
lastName_employee varchar(25) not null,
gross_salary varchar(20) not null);

insert into employee values (null, 'admin', 'admin123', '2000');
insert into employee values (null, 'Bartosz', 'Kowalski', '3000');
insert into employee values (null, 'Kamil', 'Nowak', '4000');
insert into employee values (null, 'Marcel', 'Kaczynski', '5000');
insert into employee values (null, 'Martyna', 'Hra', '6000');

create table login (
    users varchar(15) not null,
    pass varchar(15) not null,
    role varchar(15) not null
);
drop table Login;
insert into login values ('admin', 'admin', 'admin');
insert into login values ('user', 'user', 'user');

select *from employee;


create table log (id int, login varchar(20), pass varchar(20));
insert into log (id,login,pass) values 
(1,'log1', 'pass1'),
(2,'log2', 'pass2'),
(3,'log3', 'pass3')
;
select * from log;