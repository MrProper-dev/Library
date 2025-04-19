CREATE TABLE publishers (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    address TEXT NOT NULL
);

CREATE TABLE authors(
	id SERIAL PRIMARY KEY,
	full_name VARCHAR(200) NOT NULL,
	birth_year INTEGER NOT NULL,
	country VARCHAR(170) NOT NULL
);


CREATE TABLE readers (
	id SERIAL PRIMARY KEY,
	full_name VARCHAR(200) NOT NULL,
	passport_number VARCHAR(100) NOT NULL,
	phone VARCHAR(100) NOT NULL
);

CREATE TABLE books (
	id SERIAL PRIMARY KEY,
	title VARCHAR(250) NOT NULL,
	author_id INTEGER REFERENCES authors(id) NOT NULL,
	publication_year INTEGER NOT NULL,
	genre VARCHAR(160) NOT NULL,
	publisher_id INTEGER REFERENCES publishers(id) NOT NULL,
	description TEXT NOT NULL,
	image VARCHAR(255),
	loan_status BOOLEAN NOT NULL DEFAULT true,
	added_date DATE NOT NULL
);

CREATE TABLE loans (
	id SERIAL PRIMARY KEY,
	book_id INTEGER REFERENCES books(id) NOT NULL,
	reader_id INTEGER REFERENCES readers(id) NOT NULL,
	loan_date DATE NOT NULL,
	return_date DATE NOT NULL	
);
