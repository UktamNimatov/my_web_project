USE `web_project`;
drop table if exists `user`;
CREATE TABLE `user`(
`id` INTEGER NOT NULL auto_increment,
`login` VARCHAR(255) NOT NULL,
`password` VARCHAR(255) NOT NULL,
`first_name` VARCHAR(255) NOT NULL,
`last_name` VARCHAR(255) NOT NULL,
`email` VARCHAR(255) NOT NULL,
`role` ENUM('guest', 'client', 'pharmacist', 'doctor'),
primary key(`id`)
)ENGINE=INNODB DEFAULT CHARACTER SET utf8;