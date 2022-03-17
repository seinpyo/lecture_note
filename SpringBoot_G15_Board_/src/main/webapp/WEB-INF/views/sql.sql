
select * from MEMBER2
select * from board

insert into reply2 (num, boardnum, userid, content) 
		values(reply_seq.nextval, 167, 'joo', '1234')
		
		select count(*) from reply2 where boardnum = 167