
ALTER TABLE BOOKLIST RENAME COLUMN SUBJECT TO TITLE

ALTER TABLE BOOKLIST RENAME COLUMN TITLE TO SUBJECT

ALTER TABLE MEMBERLIST RENAME COLUMN MEMBERNAME TO NAME

ALTER TABLE RENTLIST RENAME COLUMN RENT_DATE TO RENTDATE

ALTER TABLE RENTLIST RENAME COLUMN IDX TO NUMSEQ

ALTER TABLE RENTLIST RENAME COLUMN NUMSEQ TO NUM;

ALTER TABLE BOOKLIST RENAME COLUMN BOOKNUM TO NUM;

ALTER TABLE MEMBERLIST RENAME COLUMN MEMBERNUM TO NUM;

SELECT * FROM BOOKLIST
SELECT * FROM MEMBERLIST
SELECT * FROM RENTLIST

SELECT NAME FROM MEMBERLIST

ALTER TABLE MEMBERLIST MODIFY NAME VARCHAR2(50)

ALTER TABLE BOOKLIST MODIFY NUM VARCHAR2(5)

ALTER TABLE BOOKLIST ADD GRADE VARCHAR2(15)

ALTER TABLE MEMBERLIST ADD GENDER VARCHAR2(3)

ALTER TABLE MEMBERLIST ADD AGE NUMBER(2)

SELECT * FROM BOOKLIST

ALTER TABLE MEMEBERLIST DROP COLUMN GENDER

ALTER TABLE BOOKLIST DROP COLUMN GRADE

ALTER TABLE MEMBERLIST DROP COLUMN AGE

SELECT * FROM MEMBERLIST

ALTER TABLE RENTLIST DROP CONSTRAINT RENT_PK

ALTER TABLE RENTLIST DROP CONSTRAINT RENT_FK1

ALTER TABLE RENTLIST DROP CONSTRAINT RENT_FK2

ALTER TABLE BOOKLIST MODIFY NUM VARCHAR2(5)

ALTER TABLE MEMBERLIST MODIFY NUM VARCHAR2(5)

ALTER TABLE RENTLIST MODIFY BOOKNUM VARCHAR2(5)

ALTER TABLE BOOKLIST MODIFY NUM NUMBER(5)

ALTER TABLE MEMBERLIST MODIFY NUM NUMBER(5)

ALTER TABLE RENTLIST MODIFY BOOKNUM NUMBER(5)


ALTER TABLE MEMBERLIST ADD CONSTRAINT CHECK_GENDER CHECK(GENDER IN('F','M'))

ALTER TABLE MEMBERLIST ADD CONSTRAINT CHECK_AGE CHECK(AGE<=120);

ALTER TABLE RENTLIST ADD CONSTRAINT RENT_PK PRIMARY KEY (NUM)

ALTER TABLE RENTLIST ADD CONSTRAINT FK1 FOREIGN KEY (NUM) REFERENCES BOOKLIST(NUM)

ALTER TABLE RENTLIST ADD CONSTRAINT FK2 FOREIGN KEY (NUM) REFERENCES MEMBERLIST(NUM)



CREATE TABLE ORDERS1(
	ORDER_ID NUMBER(12,0),
	ORDER_DATE DATE,
	ORDER_MODE VARCHAR2(8),
	ORDER_TOTAL NUMBER(8,2) DEFAULT 0,
	ORDER_STATUS NUMBER(2,0),
	CUSTOMER_ID NUMBER(6,0),
	SALES_REP_ID NUMBER(6,0),
	PROMOTION_ID NUMBER(6,0),
	CONSTRAINT ORDER_PK PRIMARY KEY (ORDER_ID),
	CONSTRAINT MODE_CHECK CHECK(ORDER_MODE IN('DIRECT','ONLINE'))
)

SELECT * FROM ORDERS1


ALTER TABLE ORDERS1 RENAME COLUMN CUSTOMER_ID TO CUSTOMER_NUMBER

ALTER TABLE ORDERS1 ADD CONSTRAINT PROMOTION_ID_CHECK CHECK(PROMOTION_ID BETWEEN 10000 AND 99999)

CREATE TABLE ORDERS2 AS SELECT * FROM ORDERS1

SELECT * FROM ORDERS2



















