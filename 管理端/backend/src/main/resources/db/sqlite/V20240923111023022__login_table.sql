drop table if exists `login`;
create table `login` (
	login_id	INTEGER PRIMARY KEY AUTOINCREMENT,
	relevance_id	VARCHAR	,
	password	VARCHAR	,
	user_name	VARCHAR	,
	relevance_table	VARCHAR	,
	phone_number	VARCHAR	,
	wx_open_id	VARCHAR	
);
insert into login (relevance_id,password,user_name,relevance_table,phone_number,wx_open_id ) values ('','$2a$10$bOrRjyHCMT2DUnXoVuFWNO1dSd6Zj/fyjS0TETmcD1ZXlR/BGklc2','admin','','admin','' );
