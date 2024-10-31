drop table if exists `bug_priority_status`;
create table `bug_priority_status` (
	priority_status_id	INTEGER PRIMARY KEY AUTOINCREMENT,
	priority_status_description	VARCHAR(255)	not null
);
insert into bug_priority_status (priority_status_description ) values ('P0' );
insert into bug_priority_status (priority_status_description ) values ('P1' );
insert into bug_priority_status (priority_status_description ) values ('P2' );
insert into bug_priority_status (priority_status_description ) values ('P3' );
insert into bug_priority_status (priority_status_description ) values ('P4' );
