--Drop tables if they exist
--DROP TABLE IF EXISTS lottery CASCADE;
--DROP TABLE IF EXISTS user_ticket CASCADE;
--DROP TABLE IF EXISTS user_account CASCADE;

--Create tables
CREATE TABLE lottery (
    ticketId SERIAL PRIMARY KEY,
    ticket VARCHAR(6) UNIQUE NOT NULL,
    price INTEGER NOT NULL,
    amount INTEGER NOT NULL
);

CREATE TABLE user_account (
    userId SERIAL PRIMARY KEY,
    user_name VARCHAR(30) UNIQUE NOT NULL,
    user_password VARCHAR(255) NOT NULL,
    user_role VARCHAR(255) NOT NULL
);

CREATE TABLE user_ticket (
    userId INTEGER,
    ticketId INTEGER,
    ticket VARCHAR(6),
    amount INTEGER,
    FOREIGN KEY (userId) REFERENCES user_account(userId),
    FOREIGN KEY (ticketId) REFERENCES lottery(ticketId),
    FOREIGN KEY (ticket) REFERENCES lottery(ticket)
);

--Initial data
INSERT INTO lottery(ticket, price, amount)
VALUES
    ('000001', 80, 1),
    ('000002', 80, 1);

INSERT INTO user_account (user_name, user_password, user_role)
VALUES
    ('admin', 'password', 'ADMIN'),
    ('member', 'password', 'MEMBER');