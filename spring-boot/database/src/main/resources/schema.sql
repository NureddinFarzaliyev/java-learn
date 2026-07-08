DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS authors;

DROP SEQUENCE IF EXISTS authors_id_seq;
DROP SEQUENCE IF EXISTS books_id_seq;


CREATE SEQUENCE authors_id_seq INCREMENT 1 MINVALUE 1 CACHE 1;
CREATE SEQUENCE books_id_seq INCREMENT 1 MINVALUE 1 CACHE 1;

CREATE TABLE authors (
  id bigint DEFAULT nextval('authors_id_seq') NOT NULL,
  name text,
  age integer,
  CONSTRAINT authors_pkey PRIMARY KEY (id)
);

CREATE TABLE books (
  id bigint DEFAULT nextval('books_id_seq') NOT NULL,
  title text,
  author_id bigint,
  CONSTRAINT books_pkey PRIMARY KEY (id),
  CONSTRAINT fk_author FOREIGN KEY (author_id) REFERENCES authors(id)
);
