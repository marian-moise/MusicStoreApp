create table music_store.password_reset
(
    pass_id int(11) not null auto_increment primary key,
    token    varchar(50)  not null
);