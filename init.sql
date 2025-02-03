CREATE TABLE Account (
    AccountID SERIAL PRIMARY KEY,
    AccountType VARCHAR(50) NOT NULL,
    Balance DECIMAL(15,2) NOT NULL,
    CustomerID INT NOT NULL
);
