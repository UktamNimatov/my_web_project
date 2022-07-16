use web_project;
drop table if exists `request_receipt`;
create table `request_receipt` (
`illness_description` text, 
`user_id` integer not null,
`status` enum ('new', 'responsed'),
`ordered_time` timestamp not null,
`responsed_time` timestamp,
CONSTRAINT `fk_request_receipt_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
)ENGINE=InnoDB default CHARACTER SET utf8;
