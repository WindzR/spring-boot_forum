create table posts (
    id serial primary key,
    name varchar(2000),
    description text,
    created timestamp without time zone not null default now()
);

create table authors (
    id serial primary key,
    name varchar(200)
);

create table comments (
    id serial primary key,
    comment text,
    created timestamp without time zone not null default now(),
    author_id int NOT NULL REFERENCES authors(id)
);

CREATE TABLE IF NOT EXISTS post_comments (
    id serial primary key,
    post_id INT REFERENCES posts(id),
    comment_id INT REFERENCES comments(id)
);