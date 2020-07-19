create table music_store.users
(
    id int(5) not null auto_increment primary key,
    username     varchar(30)  not null,
    password varchar(30)  not null,
    firstName  varchar(30)  not null,
    lastName  varchar(30)  not null,
    email    varchar(255) not null,
    phone varchar(30)  not null,
    enabled boolean
);