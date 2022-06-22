use `web_project`;
create table `receipt_medicine_list` (
`id` integer not null auto_increment,
`receipt_id` integer not null,
`medicine_id` integer not null,
`medicine_quantity` integer not null,
primary key(`id`),
CONSTRAINT `fk_list_receipt_id` FOREIGN KEY (`receipt_id`) REFERENCES `receipt` (`id`),
CONSTRAINT `fk_receipt_medicine_list_medicine_id` FOREIGN KEY (`medicine_id`) REFERENCES `medicine` (`id`)
)ENGINE=InnoDB default CHARACTER SET utf8;