CREATE TABLE users
(
    id       bigint AUTO_INCREMENT NOT NULL PRIMARY KEY,
    username varchar(255) NOT NULL UNIQUE
);

CREATE TABLE todo_items
(
    id bigint AUTO_INCREMENT NOT NULL PRIMARY KEY,
    title varchar(100),
    description text,
    completed bool default 0,
    user_id bigint,
    CONSTRAINT `fk_todo_item_user` FOREIGN KEY (user_id) REFERENCES users(id)
)
