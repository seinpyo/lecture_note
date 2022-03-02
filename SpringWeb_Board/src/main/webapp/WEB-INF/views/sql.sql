select * from member

create table member(
	id varchar2(30),
	pwd varchar2(30),
	name varchar2(30),
	phone varchar2(30),
	email varchar2(30), 
	zip_num varchar2(30),
	useyn varchar2(3),
	address varchar2(100)
)

alter table member modify phone null;

