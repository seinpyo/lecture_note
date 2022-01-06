drop table member;

CREATE TABLE MEMBER (
	NAME VARCHAR2(30),
	USERID VARCHAR2(30) NOT NULL,
	PWD VARCHAR2(30),
	EMAIL VARCHAR2(30),
	PHONE VARCHAR2(15),
	ADMIN NUMBER(1) DEFAULT 0, --일반 사용자 0, 관리자 1
	PRIMARY KEY(USERID)
)

INSERT INTO MEMBER VALUES('이소미', 'somi', '1234', 'gmd@naver.com', '010-2345-1234', 0);
INSERT INTO MEMBER VALUES('하상오', 'sang12', '1234', 'h12@naver.com', '010-4321-2362', 0);
INSERT INTO MEMBER VALUES('김은광', 'light', '1234', 'yoon1@naver.com', '010-5209-5653', 0);

select * from member;

UPDATE MEMBER SET ADMIN=1 WHERE USERID='somi';

delete from member where userid='west';