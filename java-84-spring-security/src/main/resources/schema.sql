drop table if exists car;
create table car
(
    id    bigint auto_increment primary key,
    brand varchar(255),
    color varchar(255)
);

drop table if exists user_access;
create table user_access
(
    id            bigint auto_increment primary key,
    user_login    varchar(255),
    user_password varchar(255),
    user_role     varchar(255),
    full_name     varchar(255)
);
