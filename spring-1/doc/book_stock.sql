-- 书籍库存表
create table if not exists book_stock (
  `id`    INT UNSIGNED AUTO_INCREMENT NOT NULL,
  `isbn`  VARCHAR(32)                 NOT NULL,
  `stock` int                         NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY (isbn)
);