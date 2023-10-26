DROP TABLE IF EXISTS user;

CREATE TABLE user(
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(100) NOT NULL DEFAULT '',
    last_name VARCHAR(100) NOT NULL DEFAULT '',
    email VARCHAR(100) NOT NULL DEFAULT '',
    age int(3) NOT NULL,
    address VARCHAR(100) NOT NULL DEFAULT '',
    join_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    registered BIT NOT NULL DEFAULT 0,
    PRIMARY KEY (id)
);

INSERT INTO user (first_name, last_name, email, age, address, registered)
VALUES ('Koral', 'Arbel', 'korali1995@gmail.com', 30, 'Israel', 1);

INSERT INTO user (first_name, last_name, email, age, address, registered)
VALUES ('Yarin', 'Arbel', 'Yarin@gmail.com', 25, 'Israel', 1);

