drop table if exists `bug_handle_status`;
create table `bug_handle_status` (
	handle_status_id	INTEGER PRIMARY KEY AUTOINCREMENT,
	handle_status_description	VARCHAR(255)	not null
);
insert into bug_handle_status (handle_status_description ) values ('待处理' );
insert into bug_handle_status (handle_status_description ) values ('处理中' );
insert into bug_handle_status (handle_status_description ) values ('已解决' );
insert into bug_handle_status (handle_status_description ) values ('已关闭' );
insert into bug_handle_status (handle_status_description ) values ('暂不处理' );
insert into bug_handle_status (handle_status_description ) values ('转为需求' );
