SELECT FLOOR(123.1234) FROM DUAL; 

SELECT GREATEST(23,15,26,64,54,17,23), LEAST(23,15,26,64,54,17,23) FROM DUAL;

SELECT INSERT ('나는 버스를 타고 갑니다',4,3,'기차를') FROM DUAL;

SELECT CONCAT('ABCD', 'EFG', 'HIJK') FROM DUAL;

--SELECT 'ABCD'||'EFG'||'HIJK' FROM DUAL;

SELECT REPLACE('나는 버스를 타고 값니다', '버스를', '기차를') FROM DUAL;

SELECT INSTR('나는 버스를 타고 갑니다', '버스를') FROM DUAL;

SELECT LEFT('나는 버스를 타고 갑니다', 5) AS LEFTFUNCION, RIGHT('나는 버스를 타고 갑니다', 5) AS RIGHTFUNCTION 
FROM DUAL;

SELECT MID('나는 버스를 타고 갑니다', 8, 2) FROM DUAL;

SELECT DATE_ADD(NOW(), INTERVAL 2 DAY), DATE_ADD(NOW(), INTERVAL 3 MONTH) FROM DUAL;

SELECT DATE_SUB(NOW(), INTERVAL 1 MONTH) FROM DUAL;

SELECT DATE_FORMAT(NOW(), '%Y-%M-%D') FROM DUAL;
SELECT STR_TO_DATE('20211227', '%Y-%M-%D') FROM DUAL;





