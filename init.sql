DROP TABLE IF EXISTS Account CASCADE;
CREATE TABLE bank (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE Account (
    id SERIAL PRIMARY KEY,1
    AccountType VARCHAR(50) NOT NULL,
    Balance DOUBLE PRECISION NOT NULL,
    CustomerID DOUBLE PRECISION NOT NULL
);

CREATE TABLE customer (
    id SERIAL PRIMARY KEY,
    person_name VARCHAR(100) NOT NULL,
    person_id VARCHAR(50) NOT NULL,
    account_id INT REFERENCES account (id) ON DELETE CASCADE
);

INSERT INTO bank (name) VALUES ('Kaspi Bank');

INSERT INTO Account (AccountType, Balance, CustomerID)
VALUES
    ('00157489', 1000.0, 5.0),
    ('00157490', 2000.0, 3.0),
    ('00157491', 5000.0, 4.0),
    ('00157492', 3000.0, 6.0),
    ('00157493', 1500.0, 5.5),
    ('00157494', 7000.0, 4.5);

INSERT INTO customer (person_name, person_id, account_id)
VALUES
    ('Arman', 'C003', 1),
    ('Batyrkhan', 'C002', 2),
    ('Aigerim', 'C004', 3),
    ('Yerbol', 'C005', 4),
    ('Zhanar', 'C006', 5),
    ('Nursultan', 'C007', 6);

