CREATE DATABASE small_db;
CREATE TABLE "products" (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(500)
);
