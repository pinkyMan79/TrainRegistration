drop table if exists client;
drop table if exists service_staff;

create table client(

                       id bigserial primary key not null,
                       first_name char(20) not null default 'user',
                       last_name char(20) not null  default 'resu',
                       email char(20) not null default 'user@gmail.com',
                       password char(15) not null default '123456789'

);

create table service_staff(

                              id bigserial primary key not null,
                              first_name char(20) not null default 'user',
                              last_name char(20) not null  default 'resu',
                              email char(20) not null default 'user@gmail.com',
                              password char(15) not null default '123456789',
                              type_of_working char(20) not null,
                              access_token char(15) not null

);
