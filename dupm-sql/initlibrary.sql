CREATE DATABASE library;

CREATE TABLE IF NOT EXISTS person
(
    person_id INTEGER PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    name      VARCHAR(50) UNIQUE NOT NULL,
    birthday  VARCHAR(4) NOT NULL
);

CREATE TABLE IF NOT EXISTS book
(
    book_id      INTEGER PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    person_id    INTEGER,
    book_name    VARCHAR(50) NOT NULL,
    author_name  VARCHAR(50) NOT NULL,
    release_date VARCHAR(4) NOT NULL,
    FOREIGN KEY (person_id) REFERENCES person (person_id) ON DELETE SET NULL
);

INSERT INTO person (name, birthday)
VALUES ('Name1', '1991'),
       ('Name2', '1983'),
       ('Name3', '1991'),
       ('Name4', '1988'),
       ('Name5', '1992'),
       ('Name6', '1959');


INSERT INTO book (book_name, person_id, author_name, release_date)
VALUES ('book1', 1, 'author1', '1991'),
       ('book2', 1, 'author2', '1992'),
       ('book3', 3, 'author3', '1993'),
       ('book4', 2, 'author4', '1994');

DROP DATABASE IF EXISTS library;

DROP TABLE book;
DROP TABLE person CASCADE;