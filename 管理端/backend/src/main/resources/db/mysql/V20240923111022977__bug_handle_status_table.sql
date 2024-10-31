drop table if exists `bug_handle_status`;
create table `bug_handle_status` (
	handle_status_id	INT	 not null auto_increment,
	handle_status_description	VARCHAR(255)	not null,
	primary key (handle_status_id)
);
insert into bug_handle_status (handle_status_description ) values ('待处理' );
insert into bug_handle_status (handle_status_description ) values ('处理中' );
insert into bug_handle_status (handle_status_description ) values ('已解决' );
insert into bug_handle_status (handle_status_description ) values ('已关闭' );
insert into bug_handle_status (handle_status_description ) values ('暂不处理' );
insert into bug_handle_status (handle_status_description ) values ('转为需求' );
