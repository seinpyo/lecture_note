CREATE TABLE MEMBER(
	ID VARCHAR2(20) NOT NULL,
	PWD VARCHAR2(20) NOT NULL,
	NAME VARCHAR2(20) NOT NULL, 
	EMAIL VARCHAR2(40) NOT NULL,
	ZIP_NUM VARCHAR2(10) NOT NULL,
	ADDRESS VARCHAR2(100) NOT NULL,
	PHONE VARCHAR2(20) NOT NULL,
	USEYN CHAR(1) DEFAULT 'y', --휴면 계정 여부
	INDATE DATE DEFAULT SYSDATE, 
	PRIMARY KEY (ID)
)

SELECT * FROM MEMBER;

CREATE TABLE PRODUCT(
	PSEQ NUMBER(5) NOT NULL, 
	NAME VARCHAR2(100) NOT NULL,
	KIND CHAR(1) NOT NULL,
	PRICE1 NUMBER(7), --원가
	PRICE2 NUMBER(7), --판매가
	PRICE3 NUMBER(7), --마진
	CONTENT VARCHAR2(1000),
	IMAGE VARCHAR2(50),
	USEYN CHAR(1) DEFAULT 'y', --상품 판매 유효 여부
	BESTYN CHAR(1) DEFAULT 'y', --베스트 상품 진열 여부
	INDATE DATE DEFAULT SYSDATE,
	PRIMARY KEY (PSEQ)
)

CREATE SEQUENCE PRODUCT_SEQ START WITH 1;

SELECT * FROM PRODUCT;

CREATE TABLE WORKER(
	ID VARCHAR2(20) NOT NULL,
	PWD VARCHAR2(20) NOT NULL,
	NAME VARCHAR2(20) NOT NULL,
	PHONE VARCHAR2(20) NOT NULL,
	PRIMARY KEY(ID)
)

SELECT * FROM WORKER

CREATE TABLE CART (
CSEQ NUMBER(10) PRIMARY KEY, --장바구니 일련번호
ID VARCHAR2(16) REFERENCES MEMBER(ID), --주문자 ID
PSEQ NUMBER(5) REFERENCES PRODUCT(PSEQ), --주문 상품 번호 
QUANTITY NUMBER(5) DEFAULT 1, --주문수량
RESULT CHAR(1) DEFAULT '1', --1:미처리(카트에 담기기만 함), 2:처리(주문완료)
INDATE DATE DEFAULT SYSDATE  
)

CREATE SEQUENCE CART_SEQ START WITH 1;

SELECT * FROM CART


CREATE TABLE ORDERS(
OSEQ NUMBER(10) PRIMARY KEY, --주문번호
ID VARCHAR2(16) REFERENCES MEMBER(ID), 
INDATE DATE DEFAULT SYSDATE
)

CREATE SEQUENCE ORDER_SEQ START WITH 1;

--한번의 주문에 두 개 이상의 상품이 주문될 수 있기 때문에 
--주문번호와 일자가 저장되는 테이블과 주문한 상품의 자세한 정보가 저장되는 테이블을
--따로 나눈다


CREATE TABLE ORDER_DETAIL(
ODSEQ NUMBER(10) PRIMARY KEY,
OSEQ NUMBER(10) REFERENCES ORDERS(OSEQ),
PSEQ NUMBER(5) REFERENCES PRODUCT(PSEQ),
QUANTITY NUMBER(5) DEFAULT 1,
RESULT CHAR(1) DEFAULT '1'
)

CREATE SEQUENCE ORDER_DETAIL_SEQ START WITH 1;

select * from order_detail 

create table address(
zip_num varchar2(7) not null,
sido varchar2(30) not null,
gugun varchar2(30) not null,
dong varchar2(100) not null,
zip_code varchar2(30),
bunji varchar2(30)
)

select * from address 

create table qna (
qseq number(5) primary key,
subject varchar2(300), 
content varchar2(1000),
reply varchar2(1000),
id varchar2(20),
rep char(1) default '1', --답변 1:있음 2:없음
indate date default sysdate
)

create sequence qna_seq start with 1;
select * from qna 

--직원 샘플 데이터
insert into worker values('admin','admin', '관리자', '010-7777-8888');
insert into worker values('scott','tiger', '홍길동', '010-3344-2351');

--회원 샘플 데이터
insert into member(id,pwd, name, zip_num, address, phone, email) values
('one', '1111', '김나리', '12345', '서울시 성동구 성수동1가 1번지 21호', '010-1111-2222', 'abc@abc.com');
insert into member(id,pwd, name, zip_num, address, phone, email) values
('two', '2222', '김길동', '22222', '서울시 송파구 잠실2동 리센츠 아파트 201동 505호', '010-3324-5254', 'asdf@abc.com');

--상품 샘플 데이터

insert into product(pseq, name, kind, price1, price2, price3, content, image) values
(product_seq.nextval, '크로커다일부츠', '2', 40000,50000,10000,'오리지널 크로커다일부츠 입니다', 'w2.jpg');
insert into product(pseq, name, kind, price1, price2, price3, content, image,bestyn) values
(product_seq.nextval, '롱부츠', '2', 40000,50000,10000,'따뜻한 롱부츠 입니다', 'w-28.jpg', 'n');
insert into product(pseq, name, kind, price1, price2, price3, content, image,bestyn) values
(product_seq.nextval, '힐', '1', 10000,12000,2000,'여성전용 힐', 'w-26.jpg', 'n');
insert into product(pseq, name, kind, price1, price2, price3, content, image,bestyn) values
(product_seq.nextval, '슬리퍼', '4', 5000,5500,500,'편안한 슬리퍼 입니다', 'w-25.jpg', 'y');
insert into product(pseq, name, kind, price1, price2, price3, content, image,bestyn) values
(product_seq.nextval, '회색힐', '1', 10000,12000,2000,'여성 전용 힐 입니다', 'w9.jpg', 'n');

insert into product(pseq, name, kind, price1, price2, price3, content, image, bestyn) values
(product_seq.nextval, '여성부츠', '2', 12000,18000,6000,'여성용 부츠입니다', 'w4.jpg', 'n');
insert into product(pseq, name, kind, price1, price2, price3, content, image,bestyn) values
(product_seq.nextval, '핑크샌들', '3', 5000,5500,500,'사계절용 샌들입니다', 'w-10.jpg', 'y');

insert into product(pseq, name, kind, price1, price2, price3, content, image,bestyn) values
(product_seq.nextval, '슬리퍼', '3', 5000,5500,500,'편안한 슬리퍼 입니다', 'w11.jpg', 'y');
insert into product(pseq, name, kind, price1, price2, price3, content, image,bestyn) values
(product_seq.nextval, '스니커즈', '4', 15000,20000,5000,'활동성이 좋은 스니커즈 입니다', 'w1.jpg', 'n');
insert into product(pseq, name, kind, price1, price2, price3, content, image,bestyn) values
(product_seq.nextval, '샌들', '3', 5000,5500,5000,'사계절용 샌들입니다 입니다', 'w-24.jpg', 'n');
insert into product(pseq, name, kind, price1, price2, price3, content, image,bestyn) values
(product_seq.nextval, '스니커즈', '5', 15000,20000,5000,'활동성이 좋은 스니커즈 입니다', 'w-05.jpg', 'n');

update product set bestyn = 'y' where pseq=11;
select * from product

--카트 추가
insert into cart(cseq, id, pseq, quantity) values(cart_seq.nextval,'one',1,1); 
insert into cart(cseq, id, pseq, quantity) values(cart_seq.nextval,'two',2,1); 


--orders와 orders_detail추가 

insert into orders(oseq, id) values (order_seq.nextval, 'one');

select * from orders
select max(oseq) from orders;

insert into order_detail(odseq, oseq, pseq, quantity) values(order_detail_seq.nextval, 1, 1, 1);
insert into order_detail(odseq, oseq, pseq, quantity) values(order_detail_seq.nextval, 1, 2, 2);

select * from order_detail

insert into orders(oseq, id) values(order_seq.nextval, 'two');
insert into order_detail(odseq, oseq, pseq, quantity) values(order_detail_seq.nextval, 2, 4, 3);
insert into order_detail(odseq, oseq, pseq, quantity) values(order_detail_seq.nextval, 2, 5, 2);

insert into orders(oseq, id) values(order_seq.nextval, 'one');
insert into order_detail(odseq, oseq, pseq, quantity) values(order_detail_seq.nextval, 3, 3, 1);
insert into order_detail(odseq, oseq, pseq, quantity) values(order_detail_seq.nextval, 3, 2, 1);


--qna 추가 

insert into qna(qseq, subject, content, id) values(qna_seq.nextval,'배송관련 문의입니다.', '현재 배송 상태와 예상 배송일 답변 부탁드립니다', 'one');
insert into qna(qseq, subject, content, id) values(qna_seq.nextval,'환불관련', '환불 절차 안내 부탁드립니다.', 'one')

insert into qna(qseq, subject, content, id) values(qna_seq.nextval,'사이즈교환하고싶어요','사이즈가 작아요', 'two');
insert into qna(qseq, subject, content, id) values(qna_seq.nextval,'배송', '언제 받을 수 있나요?', 'scott');
insert into qna(qseq, subject, content, id) values(qna_seq.nextval,'불량 교환', '교환 환불 전차를 유선으로 안내 부탁드립니다', 'scott');

select * from order_detail


--cart안의 상품 번호와 사용자 아이디로 상품 이름과 사용자 이름을 함께 조회하는 view 생성
create or replace view cart_view as select c.cseq, c.id, m.name as mname, c.pseq, p.name as pname, c.quantity, p.price2, c.result, c.indate 
from cart c, product p, member m
where c.pseq = p.pseq and c.id = m.id;

select * from cart_view

--orders와 order_detail을 join해 주문번호(oseq)별 상품 조회 
create or replace view order_view as 
select d.odseq, o.oseq, o.indate, o.id, m.name as mname, m.zip_num, m.address, m.phone, d.pseq, p.name as pname,p.price2, d.quantity, d.result
from orders o, order_detail d, product p, member m
where o.oseq = d.oseq and o.id=m.id and d.pseq=p.pseq

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

select * from new_pro_view
select * from qna

--베스트 상품 view
create or replace view best_pro_view
as
select * 
from (select rownum, pseq, name, price2, image from product 
where bestyn='y' order by indate desc)
where rownum <= 4;

select * from best_pro_view

select count(*) from address

update order_detail set result=2 where oseq=21;

select * from order_detail
select * from orders
select max(oseq) as max_oseq from orders