SELECT * FROM MEMBER

CREATE TABLE BOARD(
	NUM NUMBER(5) PRIMARY KEY,
	PASS VARCHAR2(30), --게시물 수정 삭제를 위한 비밀번호 
	USERID VARCHAR2(30),
	EMAIL VARCHAR2(30),
	TITLE VARCHAR2(50),
	CONTENT VARCHAR2(1000),
	READCOUNT NUMBER(4) DEFAULT 0, --조회수 
	WRITEDATE DATE DEFAULT SYSDATE --작성일자
)

CREATE SEQUENCE BOARD_SEQ START WITH 1 INCREMENT BY 1;
drop table board;
drop SEQUENCE BOARD_SEQ;

INSERT INTO BOARD(NUM, USERID, EMAIL, PASS, TITLE, CONTENT)
VALUES(BOARD_SEQ.NEXTVAL, 'SOMI', 'SOMI@NAVER.COM', '1234', '공지사항', '공지사항입니다.');
INSERT INTO BOARD(NUM, USERID, EMAIL, PASS, TITLE, CONTENT)
VALUES(BOARD_SEQ.NEXTVAL, 'sang12', 'sang12@NAVER.COM', '1234', '안녕하세요', '반갑습니다.');
INSERT INTO BOARD(NUM, USERID, EMAIL, PASS, TITLE, CONTENT)
VALUES(BOARD_SEQ.NEXTVAL, 'kim123', 'kim123@NAVER.COM', '1234', '배고파요', '오늘 점심은 김밥입니다.');
INSERT INTO BOARD(NUM, USERID, EMAIL, PASS, TITLE, CONTENT)
VALUES(BOARD_SEQ.NEXTVAL, 'moon', 'moon@NAVER.COM', '1234', '게시판 개설', '게시판 개설 축하합니다.');
INSERT INTO BOARD(NUM, USERID, EMAIL, PASS, TITLE, CONTENT)
VALUES(BOARD_SEQ.NEXTVAL, 'you', 'you@NAVER.COM', '1234', '어서오세요', '환영합니다.');
INSERT INTO BOARD(NUM, USERID, EMAIL, PASS, TITLE, CONTENT)
VALUES(BOARD_SEQ.NEXTVAL, 'jin', 'jindalrae@NAVER.COM', '1234', '진달래 헬스장', '계나리 주무관입니다.');
INSERT INTO BOARD(NUM, USERID, EMAIL, PASS, TITLE, CONTENT)
VALUES(BOARD_SEQ.NEXTVAL, 'south', 'south@NAVER.COM', '12345', '홍길동씨', '저는 홍길남입니다.');
INSERT INTO BOARD(NUM, USERID, EMAIL, PASS, TITLE, CONTENT)
VALUES(BOARD_SEQ.NEXTVAL, 'you', 'you@NAVER.COM', '1234', '자유게시판', '자유로운 게시판입니다.');
INSERT INTO BOARD(NUM, USERID, EMAIL, PASS, TITLE, CONTENT)
VALUES(BOARD_SEQ.NEXTVAL, 'moon', 'moon@NAVER.COM', '1234', '감기 조심하세요', '날씨가 많이 춥습니다.');
INSERT INTO BOARD(NUM, USERID, EMAIL, PASS, TITLE, CONTENT)
VALUES(BOARD_SEQ.NEXTVAL, 'you', 'you@NAVER.COM', '1234', '마라탕', '맛있습니다.');

SELECT * FROM BOARD

update board set READCOUNT=READCOUNT+1 where num=1;

create table reply (
	num number(7) primary key, --댓글순번
	boardnum number(5), 
	userid varchar2(20),
	writedate date default sysdate,
	content varchar2(1000)
)

create sequence reply_seq start with 1 increment by 1;

select * from reply
select count(*) from board;
select rownum, num, title, content from board order by num desc; 
--rownum, *는 사용 불가 
--서브쿼리로 단순화 가능 -> 
select rownum, sub.* from (select * from board order by num desc) sub;  

select * from 
(select rownum as rn, sub.* from (select * from board order by num desc) sub)  
where rn>=11 and rn<20; 


select * from 
(select * from 
(select rownum as rn, sub.* from (select * from board order by num desc) sub)  
where rn>=11)
where rn<=20;

alter table board add replycnt number(3) default 0;

alter table board add imgfilename varchar2(50);







