--DDL create

CREATE TABLE booklist(
	booknum varchar2(5) NOT NULL,
	subject varchar2(30),
	makeyear number(4) DEFAULT 2021, --작성하지 않았을 시 기본값 2021
	inprice number(6) DEFAULT 0,
	rentprice number(6) DEFAULT 0, 
	--number(4)는 4bit가 아닌 4자리 숫자를 의미
	constraint booknum_pk primary key(booknum)
	--마지막 필드 작성 후 ',' 쓰지 않음
)

SELECT * FROM booklist;

DROP TABLE booklist;

CREATE TABLE MEMMBERLIST(
	memberNum varchar2(5) NOT NULL,
	memberName varchar2(12) NOT NULL,
	Phone varchar2(13) NOT NULL ,
	Birth DATE, 
	Bpoint NUMBER(6) DEFAULT 0,
	joinDate DATE DEFAULT sysdate,
	CONSTRAINT memberNum_pk PRIMARY KEY(memberNum)
)

SELECT * FROM MEMMBERLIST;

ALTER TABLE MEMMBERLIST ALTER COLUMN memberNum NUMBER(5);

Drop Table MEMMBERLIST;

CREATE TABLE MEMBERLIST(
	memberNum NUMBER(6) NOT NULL,
	memberName varchar2(12) NOT NULL,
	Phone varchar2(13) NOT NULL ,
	Birth DATE, 
	Bpoint NUMBER(6) DEFAULT 0,
	joinDate DATE DEFAULT sysdate,
	CONSTRAINT memberNum_pk PRIMARY KEY(memberNum)
)

SELECT * FROM MEMBERLIST;

CREATE TABLE booklist(
	booknum varchar2(5) NOT NULL,
	subject varchar2(30),
	makeyear number(4) DEFAULT 2021,
	inprice number(6) DEFAULT 0,
	rentprice number(6) DEFAULT 0, 
	constraint booknum_pk primary key(booknum)
)

CREATE TABLE RENTLIST(
	RENT_DATE DATE DEFAULT SYSDATE,
	IDX NUMBER(5) NOT NULL, --해당 일자의 대여 순번
	BOOKNUM varchar2(5) NOT NULL,
	MEMBERNUM NUMBER(6) NOT NULL,
	DISCOUNT NUMBER(4),
	CONSTRAINT RENT_PK PRIMARY KEY (RENT_DATE, IDX), --복합 기본키
	CONSTRAINT RENT_FK1 FOREIGN KEY (BOOKNUM) REFERENCES BOOKLIST(BOOKNUM),
	-- RENTLIST의 BOOKNUM은 BOOKLIST 테이블의 BOOKNUM을 참조한다.
	CONSTRAINT RENT_FK2 FOREIGN KEY (MEMBERNUM) REFERENCES MEMBERLIST(MEMBERNUM)
)

SELECT * FROM RENTLIST;










