use `web_project`;
CREATE TABLE `order`(
`id` integer not null,
`user_id` integer not null auto_increment,
`status` ENUM('new', 'confirmed', 'completed', 'canceled'),
`ordered_time` timestamp not null,
`confirmed_time` timestamp not null,
`completed_time` timestamp not null,
`canceled_time` timestamp not null,
primary key(`id`),
CONSTRAINT `fk_user_order` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
)ENGINE=InnoDB default CHARACTER SET utf8;