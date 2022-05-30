use `web_project`;
create table `receipt` (
`id` integer not null auto_increment,
`doctor_user_id` integer not null,
`client_user_id` integer not null,
`medicine_id` integer not null,
`medicine_quantity` integer not null,
`usage` text not null,
primary key(`id`),
CONSTRAINT `fk_receipt_doctor_id` FOREIGN KEY (`doctor_user_id`) REFERENCES `user` (`id`),
CONSTRAINT `fk_receipt_client_id` FOREIGN KEY (`client_user_id`) REFERENCES `user` (`id`),
CONSTRAINT `fk_receipt_medicine_id` FOREIGN KEY (`medicine_id`) REFERENCES `medicine` (`id`)
)ENGINE=InnoDB default CHARACTER SET utf8;