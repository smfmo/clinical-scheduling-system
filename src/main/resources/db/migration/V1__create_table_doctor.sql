CREATE TABLE doctor (
    id uuid PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    telephone VARCHAR(20),
    date_birthday DATE,
    crm VARCHAR(20) NOT NULL UNIQUE,
    specialty VARCHAR(50) NOT NULL
);