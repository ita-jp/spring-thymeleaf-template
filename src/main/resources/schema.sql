CREATE TABLE users
(
    id       BIGINT      NOT NULL PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(68) NOT NULL,
    enabled  BOOLEAN     NOT NULL
);

CREATE TABLE authorities
(
    user_id   BIGINT      NOT NULL,
    authority VARCHAR(50) nOT NULL,
    CONSTRAINT fk_authorities_users FOREIGN KEY (user_id) REFERENCES users (id)
);
CREATE UNIQUE INDEX ix_auth_username ON authorities (user_id, authority);

CREATE TABLE books
(
    id          BIGINT      NOT NULL PRIMARY KEY AUTO_INCREMENT,
    title       VARCHAR(50) NOT NULL,
    author      VARCHAR(50) NOT NULL
);

CREATE TABLE physical_copies (
    id          BIGINT      NOT NULL PRIMARY KEY AUTO_INCREMENT,
    book_id     BIGINT      NOT NULL,
    location    VARCHAR(50) NOT NULL,
    CONSTRAINT fk_physical_copies_books FOREIGN KEY (book_id) REFERENCES books (id)
);
