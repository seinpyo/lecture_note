SELECT * FROM TAB;
SELECT * FROM TABS;

DESC DEPT;
DESC MEMBERLIST; 
DESC RENTLIST; 

SELECT EMPNO||'-'||ENAME AS EMP_INFO FROM EMP 
SELECT EMPNO AS "사원번호", ENAME AS 사원성명 FROM EMP

SELECT SUBJECT, MAKEYEAR AS "출판년도" FROM BOOKLIST;

SELECT SAL*1.1 AS 임금인상안 FROM EMP 

SELECT * FROM RENTLIST;
SELECT SUBJECT AS 도서제목, MAKEYEAR AS 출판년도 FROM BOOKLIST;

INSERT INTO RENTLIST VALUES ('2021/12/15', RENT_SEQ.NEXTVAL, 21, 6, 150);
INSERT INTO RENTLIST VALUES ('2021/12/15', RENT_SEQ.NEXTVAL, 22, 7, 120);
INSERT INTO RENTLIST VALUES ('2021/12/16', RENT_SEQ.NEXTVAL, 23, 8, 180);
INSERT INTO RENTLIST VALUES ('2021/12/16', RENT_SEQ.NEXTVAL, 24, 11, 210);
INSERT INTO RENTLIST VALUES ('2021/12/17', RENT_SEQ.NEXTVAL, 25, 17, 200);
INSERT INTO RENTLIST VALUES ('2021/12/17', RENT_SEQ.NEXTVAL, 26, 15, 200);
INSERT INTO RENTLIST VALUES ('2021/12/17', RENT_SEQ.NEXTVAL, 27, 8, 180);
INSERT INTO RENTLIST VALUES ('2021/12/18', RENT_SEQ.NEXTVAL, 28, 13, 210);
INSERT INTO RENTLIST VALUES ('2021/12/18', RENT_SEQ.NEXTVAL, 29, 14, 230);
INSERT INTO RENTLIST VALUES ('2021/12/18', RENT_SEQ.NEXTVAL, 39, 12, 90);

--14~39 BOOK
--1~3 6~18 MEMBER

SELECT BOOKNUM FROM RENTLIST; 
SELECT DISTINCT BOOKNUM FROM RENTLIST;

SELECT MEMBERNUM FROM RENTLIST; 
SELECT DISTINCT MEMBERNUM FROM RENTLIST;

--입고가격이 20000원 이상인 책 목록
SELECT SUBJECT FROM BOOKLIST WHERE INPRICE>=15000;

--홍으로 시작하는 회원의 모든 회원정보
SELECT * FROM MEMBERLIST WHERE NAME LIKE '홍%';

--1983 이후에 태어난 회원의 모든 회원정보 
SELECT * FROM MEMBERLIST WHERE BIRTH>'1982/12/31';

--사은 포인트(BPOINT)가 250이상이고 1982년 이후 태어난 회원의 모든 회원정보 
SELECT * FROM MEMBERLIST WHERE BPOINT>=250 AND BIRTH>='1982/01/01';

--제작년도가 2016년 이전이거나 입고가격이 12000이하인 책 정보 
SELECT * FROM BOOKLIST WHERE MAKEYEAR<=2016 OR INPRICE<=12000;

--성명이 '이'로 시작하는 회원의 모든 정보 
SELECT * FROM MEMBERLIST WHERE NAME LIKE '이%';

--도서 제목에 '이'가 포함되는 모든 도서 정보 
SELECT * FROM BOOKLIST WHERE SUBJECT LIKE '%이%';

--MEMBERLIST에서 성별이 NULL이 아닌 회원의 이름의 전화 번호 
SELECT * FROM MEMBERLIST WHERE GENDER IS NOT NULL;
SELECT * FROM MEMBERLIST WHERE GENDER IS NULL;
UPDATE MEMBERLIST SET GENDER='M' WHERE GENDER IS NULL;

-- BOOKLIST 에서 도서 제목에 두번쩨 글자가 '여' 인 것의 도서 정보
SELECT * FROM BOOKLIST WHERE SUBJECT LIKE '__여%';

