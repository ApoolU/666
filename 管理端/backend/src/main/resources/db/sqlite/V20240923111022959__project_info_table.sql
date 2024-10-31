drop table if exists `project_info`;
create table `project_info` (
	project_info_id	INTEGER PRIMARY KEY AUTOINCREMENT,
	project_name	VARCHAR	not null,
	project_version	VARCHAR	,
	project_leader	VARCHAR	
);
insert into project_info (project_name,project_version,project_leader ) values ('CodeFlying','1.0','1' );
insert into project_info (project_name,project_version,project_leader ) values ('智谱DemoDay','2.0','2' );
