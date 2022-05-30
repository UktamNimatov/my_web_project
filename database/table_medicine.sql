use `web_project`;
drop table if exists `medicine`;
CREATE TABLE `medicine` (
`id` INTEGER NOT NULL auto_increment,
`title` VARCHAR(255) NOT NULL,
`price` double NOT NULL,
`description` text NOT NULL,
`withPrescription` boolean NOT NULL,
primary key(`id`)
)ENGINE=InnoDB DEFAULT CHARACTER SET utf8;