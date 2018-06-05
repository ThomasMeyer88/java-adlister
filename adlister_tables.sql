CREATE TABLE users (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(50),
    password VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE ads (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    title VARCHAR (100),
    userid INT UNSIGNED,
    description TEXT,
    PRIMARY KEY (id)
);

ALTER TABLE ads
    add CONSTRAINT
FOREIGN KEY (userid) REFERENCES adlister_db.users(id);

INSERT INTO ads (title, userid, description) values('three ducks', '1', 'you know the deal');

SELECT * FROM users;
SELECT * FROM ads;