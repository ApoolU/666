drop table if exists `bug_info`;
create table `bug_info` (
	bug_info_id	INT	 not null auto_increment,
	bug_discoverer	INT	,
	bug_submitter	INT	,
	bug_handler	INT	,
	bug_title	VARCHAR	not null,
	bug_description	VARCHAR	,
	bug_image	VARCHAR	,
	project_info_id	INT	,
	bug_deadline	DATE	,
	bug_priority	INT	not null,
	bug_handle_status	INT	not null,
	created_time	DATE	,
	primary key (bug_info_id)
);
insert into bug_info (bug_discoverer,bug_submitter,bug_handler,bug_title,bug_description,bug_image,project_info_id,bug_deadline,bug_priority,bug_handle_status,created_time ) values ('1','1','1','艾伦的第一个BUG',null,null,'1',null,'0','0',null );
insert into bug_info (bug_discoverer,bug_submitter,bug_handler,bug_title,bug_description,bug_image,project_info_id,bug_deadline,bug_priority,bug_handle_status,created_time ) values ('2','2','2','三笠的第一个BUG',null,null,'1',null,'0','0',null );
insert into bug_info (bug_discoverer,bug_submitter,bug_handler,bug_title,bug_description,bug_image,project_info_id,bug_deadline,bug_priority,bug_handle_status,created_time ) values ('1','1','1','艾伦的第二个BUG',null,null,'1',null,'0','0',null );
insert into bug_info (bug_discoverer,bug_submitter,bug_handler,bug_title,bug_description,bug_image,project_info_id,bug_deadline,bug_priority,bug_handle_status,created_time ) values ('2','2','2','三笠的第二个BUG',null,null,'1',null,'0','0',null );
