drop table if exists `technical_direction_status`;
create table `technical_direction_status` (
	technical_status_id	INT	 not null auto_increment,
	technical_status_description	VARCHAR(255)	not null,
	primary key (technical_status_id)
);
insert into technical_direction_status (technical_status_description ) values ('前端' );
insert into technical_direction_status (technical_status_description ) values ('后端' );
insert into technical_direction_status (technical_status_description ) values ('测试' );
insert into technical_direction_status (technical_status_description ) values ('运维' );
