-- liquibase formatted sql

-- changeset fabio.heller:3.0 dbms:mysql
CREATE TABLE treinamento.role
(
    id bigint auto_increment,
    name varchar(255) not null,
    constraint role_pk
        primary key (id)
);

-- changeset thiago.oliveira:1.4 dbms:mysql

INSERT INTO role (name)
    values('ADMIN');
INSERT INTO role (name)
    values('CLIENT');

-- changeset thiago.oliveira:1.5 dbms:mysql

CREATE TABLE user_role
(
    id bigint not null auto_increment,
    user_id bigint,
    role_id bigint,
    constraint user_role_pk
		primary key (id),
    constraint user_role_user_fk
		foreign key (user_id) references treinamento.user (id),
    constraint user_role_role_fk
		foreign key (role_id) references treinamento.role (id)
);

ALTER TABLE user
    CHANGE login username VARCHAR(255) NOT NULL;

-- changeset thiago.oliveira:3.1 dbms:mysql
insert into user_role (user_id, role_id)
    values ((select max(id) from user), (select min(id) from role));

