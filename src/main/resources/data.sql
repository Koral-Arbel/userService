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

