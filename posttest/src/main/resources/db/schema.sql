CREATE TABLE lottery (
    ticketId INTEGER AUTO_INCREMENT PRIMARY KEY,
    ticket VARCHAR(6) NOT NULL,
    price INTEGER NOT NULL,
    amount INTEGER NOT NULL
);

CREATE TABLE user_ticket (
    userId INTEGER NOT NULL,
    ticket VARCHAR(6),
    amount INTEGER,
    FOREIGN KEY (userId) REFERENCES user_account(userId),
    FOREIGN KEY (ticket) REFERENCES lottery(ticketId)

);

CREATE TABLE user_account (
    userId INTEGER AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(30) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(255) NOT NULL
);