-- 账户表
create table if not exists account (
  `id` INT UNSIGNED AUTO_INCREMENT NOT NULL,
  `user_name` VARCHAR(32) NOT NULL,
  `balance` decimal(15,2) DEFAULT NULL,
  PRIMARY KEY(`id`)
);