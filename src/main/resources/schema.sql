drop table if exists movie;
drop table if exists favorite;

create table movie (
   id int auto_increment primary key,
   name varchar(64) not null,
   director varchar(64),
   lang varchar(16),
   country varchar(16));

create table favorite (
   id int primary key
);