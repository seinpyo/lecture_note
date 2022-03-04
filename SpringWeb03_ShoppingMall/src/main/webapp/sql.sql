
select * from address


CREATE TABLE CART (
CSEQ NUMBER(10) PRIMARY KEY, --장바구니 일련번호
ID VARCHAR2(16) REFERENCES MEMBER2(USERID), --주문자 ID
PSEQ NUMBER(5) REFERENCES PRODUCT(PSEQ), --주문 상품 번호 
QUANTITY NUMBER(5) DEFAULT 1, --주문수량
RESULT CHAR(1) DEFAULT '1', --1:미처리(카트에 담기기만 함), 2:처리(주문완료)
INDATE DATE DEFAULT SYSDATE  
)


CREATE SEQUENCE CART_SEQ START WITH 1;

CREATE SEQUENCE ORDER_SEQ START WITH 1;

CREATE TABLE ORDER_DETAIL(
ODSEQ NUMBER(10) PRIMARY KEY,
OSEQ NUMBER(10) REFERENCES ORDERS(OSEQ),
PSEQ NUMBER(5) REFERENCES PRODUCT(PSEQ),
QUANTITY NUMBER(5) DEFAULT 1,
RESULT CHAR(1) DEFAULT '1'
)

CREATE SEQUENCE ORDER_DETAIL_SEQ START WITH 1;


create table address(
zip_num varchar2(7) not null,
sido varchar2(30) not null,
gugun varchar2(30) not null,
dong varchar2(100) not null,
zip_code varchar2(30),
bunji varchar2(30)
)




CREATE TABLE ORDERS(
OSEQ NUMBER(10) PRIMARY KEY, --주문번호
ID VARCHAR2(16) REFERENCES MEMBER2(UserID), 
INDATE DATE DEFAULT SYSDATE
)

select * from qna

create table qna (
qseq number(5) primary key,
subject varchar2(300), 
content varchar2(1000),
reply varchar2(1000),
id varchar2(20),
rep char(1) default '1', --답변 1:있음 2:없음
indate date default sysdate
);

create sequence qna_seq start with 1;

create or replace view cart_view as select c.cseq, c.id, m.name as mname, c.pseq, p.name as pname, c.quantity, p.price2, c.result, c.indate 
from cart c, product p, member2 m
where c.pseq = p.pseq and c.id = m.userid;

select * from cart_view

--orders와 order_detail을 join해 주문번호(oseq)별 상품 조회 
create or replace view order_view as 
select d.odseq, o.oseq, o.indate, o.id, m.name as mname, m.zip_num, m.address, m.phone, d.pseq, p.name as pname,p.price2, d.quantity, d.result
from orders o, order_detail d, product p, member2 m
where o.oseq = d.oseq and o.id=m.userid and d.pseq=p.pseq

select * from orders;
select * from order_view;
select * from cart_view;

--신상품 view (가장 최근에 업로드 된 4개만 출력)
create or replace view new_pro_view
as select * from 
(select rownum, pseq, name, price2, image
from product
where useyn = 'y'
order by indate desc)
where rownum <= 4;

select * from best_pro_view
select * from qna

--베스트 상품 view
create or replace view best_pro_view
as
select * 
from (select rownum, pseq, name, price2, image from product 
where bestyn='y' order by indate desc)
where rownum <= 4;