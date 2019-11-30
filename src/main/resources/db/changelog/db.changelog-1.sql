-- liquibase formatted sql

-- changeset fabio.heller:1.0 dbms:mysql


create table address(
id bigint not null auto_increment,
zip_code varchar(9) null,
street varchar(255) null,
number int null,
district varchar(255) null,
city varchar(255) null,
country varchar(255) null,
constraint address_pk
primary key (id)
);

-- changeset fabio.heller:1.1 dbms:mysql

create table company(
id bigint not null auto_increment,
name varchar(100) not null,
document varchar(17) not null,
vacancies integer not null,
site varchar(255) not null,
address_id bigint null,
constraint company_pk
primary key (id)
);

-- changeset fabio.heller:1.2 dbms:mysql

create table user(
id bigint not null auto_increment,
name varchar(255) not null,
document varchar(14) not null,
age int not null,
login varchar(255) not null,
password varchar(255) not null,
salary decimal(19,2) null,
company_id bigint null,
address_id bigint null,
constraint user_pk
primary key (id)
);
