create table music_store.user_roles
(
    id int(11) not null auto_increment primary key,
    user_id     int(11)  not null,
    role_id     int(11)  not null
);