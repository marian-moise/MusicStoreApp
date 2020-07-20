CREATE TABLE music_store.users (
    id INT(5) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username     VARCHAR(30)  NOT NULL,
    password VARCHAR(30)  NOT NULL,
    firstName  VARCHAR(30)  NOT NULL,
    lastName  VARCHAR(30)  NOT NULL,
    email    VARCHAR(30)  NOT NULL,
    phone VARCHAR(30)  NOT NULL,
    enabled BOOLEAN,
    UNIQUE (username, email)
);