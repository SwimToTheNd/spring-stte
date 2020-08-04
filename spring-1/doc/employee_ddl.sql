create table if not exists employee (
    `id` INT UNSIGNED AUTO_INCREMENT NOT NULL,
    `last_name` VARCHAR(32) NOT NULL,
    `email` VARCHAR(255) DEFAULT NULL,
    `dpet_id` VARCHAR(128) DEFAULT NULL,
    PRIMARY KEY(`id`)
);