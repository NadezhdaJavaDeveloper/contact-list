CREATE SCHEMA IF NOT EXISTS contact_list;
CREATE TABLE IF NOT EXISTS contact_list.contacts (
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone INTEGER NOT NULL
);
