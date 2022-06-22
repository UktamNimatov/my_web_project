use `web_project`;
CREATE TABLE `medicine_stock`(
`medicine_id` integer not null,
`medicine_quantity` integer not null,
CONSTRAINT `fk_stock_medicine_id` FOREIGN KEY (`medicine_id`) REFERENCES `medicine` (`id`)
)ENGINE=InnoDB default CHARACTER SET utf8;