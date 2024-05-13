CREATE TABLE users
(
    id       LONG        NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(68) NOT NULL,
    enabled  BOOLEAN     NOT NULL
);
