
create table bbs(
	id number(3),
	writer varchar2(30),
	title varchar2(30),
	content varchar2(1000)
);

create sequence bbs_seq start with 1;

insert into bbs values(bbs_seq.nextVal, 'Gildong', '반갑습니다', '반갑습니다 여러분');
insert into bbs values(bbs_seq.nextVal, 'Gilnam', '안녕하세요', '안녕하세요 여러분');
insert into bbs values(bbs_seq.nextVal, 'Gilbook', '어서오세요', '어서오세요 여러분');

select * from bbs
select * from bbs