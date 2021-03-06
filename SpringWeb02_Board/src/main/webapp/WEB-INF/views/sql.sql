


update member2 set pwd='1234' where userid='yoon' 

CREATE TABLE BOARD(
	NUM NUMBER(5) PRIMARY KEY,
	PASS VARCHAR2(30), --게시물 수정 삭제를 위한 비밀번호 
	USERID VARCHAR2(30),
	EMAIL VARCHAR2(30),
	TITLE VARCHAR2(50),
	CONTENT VARCHAR2(1000),
	READCOUNT NUMBER(4) DEFAULT 0, --조회수 
	WRITEDATE DATE DEFAULT SYSDATE --작성일자
	REPLYCNT NUMBER(3) DEFAULT 0,
	IMGFILENAME VARCHAR2(50)
)

CREATE SEQUENCE BOARD_SEQ START WITH 1 INCREMENT BY 1;

CREATE TABLE MEMBER2(
	NAME VARCHAR2(30),
	USERID VARCHAR2(30) PRIMARY KEY,
	PWD VARCHAR2(30),
	EMAIL VARCHAR2(30),
	PHONE VARCHAR2(30),
	ADMIN CHAR(1) DEFAULT 0,
	ZIP_NUM VARCHAR2(10),
	ADDRESS VARCHAR2(100)
);


insert into member2 (name, userid, pwd, email, phone) values('홍길동', 'hong', '1234', 'hong@gmail.com', '010-1111-1111')
select * from member2;

CREATE table REPLY2(
	NUM NUMBER(7) PRIMARY KEY,
	BOARDNUM NUMBER(5),
	USERID VARCHAR2(20),
	WRITEDATE DATE DEFAULT SYSDATE,
	CONTENT VARCHAR2(1000)
);

CREATE SEQUENCE REPLY_SEQ START WITH 1 INCREMENT BY 1;

update member2 set name='홍길서' where userid='hong'
select * from member2

update board set readcount = readcount+1 where num=1
select * from reply2
insert into reply2 (num, boardnum, userid, content) values (reply_seq.nextVal, 166, 'yoon', 'test');