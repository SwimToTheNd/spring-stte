-- 书籍信息表
create table if not exists book (
  `id` INT UNSIGNED AUTO_INCREMENT NOT NULL,
  `isbn` VARCHAR(32) NOT NULL,
  `book_name` VARCHAR(32) NOT NULL,
  `price` double NULL,
  PRIMARY KEY(`id`),
  UNIQUE KEY (isbn)
);