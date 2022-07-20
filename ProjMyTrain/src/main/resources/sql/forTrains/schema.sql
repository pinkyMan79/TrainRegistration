drop table if exists fast_train;
drop table if exists ordinary_train;
drop table if exists test_train;
drop table if exists times_table;

create table fast_train(

                           id bigserial primary key unique not null ,
                           time_arrval time not null,
                           time_departure time not null

);

create table ordinary_train(

                               id bigserial primary key unique not null ,
                               time_arrval time not null,
                               time_departure time not null

);

create table test_train(

                           id bigserial primary key unique not null ,
                           time_arrval time not null,
                           time_departure time not null

);

create table times_table(

                            id bigserial primary key unique not null,
                            time_arrival time not null,
                            date_of_departure date not null,
                            time_departure time not null,
                            type_of_train char(20) not null

);


alter table fast_train add passage_id bigint;
alter table fast_train add foreign key (passage_id) references times_table(id);

alter table ordinary_train add passage_id bigint;
alter table ordinary_train add foreign key (passage_id) references times_table(id);

