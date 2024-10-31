drop table if exists `user_info`;
create table `user_info` (
	user_info_id	INT	 not null auto_increment,
	user_name	VARCHAR	not null,
	phone_number	VARCHAR	,
	technical_direction	INT	not null,
	primary key (user_info_id)
);
insert into user_info (user_name,phone_number,technical_direction ) values ('艾伦','12345678901','1' );
insert into user_info (user_name,phone_number,technical_direction ) values ('三笠','10987654321','2' );
