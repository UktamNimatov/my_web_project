use `web_project`;
create table `order_medicine_list` (
`id` integer not null auto_increment,
`order_id` integer not null,
`medicine_id` integer not null,
`medicine_quantity` integer not null,
`medicine_price` double not null,
primary key(`id`),
CONSTRAINT `fk_list_order_id` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`),
CONSTRAINT `fk_list_medicine_id` FOREIGN KEY (`medicine_id`) REFERENCES `medicine` (`id`)
)ENGINE=InnoDB default CHARACTER SET utf8;