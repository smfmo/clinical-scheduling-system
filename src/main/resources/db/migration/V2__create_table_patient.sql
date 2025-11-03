CREATE TABLE patient(
    id uuid PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    telephone VARCHAR(20),
    date_birthday DATE,
    email VARCHAR(155) NOT NULL UNIQUE
);

