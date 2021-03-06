SELECT SUM(RENTPRICE) AS "대여가격 합계" FROM BOOKLIST;
SELECT SUM(RENTPRICE) AS "대여가격 합계" FROM BOOKLIST WHERE INPRICE>=12000

SELECT COUNT(*) AS "회원수" FROM MEMBERLIST; 
SELECT COUNT(*) AS "회원수" FROM MEMBERLIST WHERE BPOINT >= 150;

SELECT ROUND(AVG(INPRICE), 0) FROM BOOKLIST;

SELECT MAX(INPRICE) AS "MAX", MIN(INPRICE) AS "MIN" FROM BOOKLIST;

SELECT VARIANCE(SALARY), STDDEV(SALARY) FROM EMPLOYEES;

SELECT COUNT(*) FROM RENTLIST;

SELECT BOOKNUM,COUNT(*) FROM RENTLIST GROUP BY BOOKNUM;

SELECT * FROM RENTLIST;
SELECT RENT_DATE, ROUND(AVG(DISCOUNT)) FROM RENTLIST GROUP BY RENT_DATE ORDER BY RENT_DATE DESC;
SELECT RENT_DATE, COUNT(*) AS "대여건수" FROM RENTLIST GROUP BY RENT_DATE ORDER BY RENT_DATE DESC;

--부서별 임금 평균
SELECT DEPARTMENT_ID, ROUND(AVG(SALARY),0) FROM EMPLOYEES 
GROUP BY DEPARTMENT_ID ORDER BY DEPARTMENT_ID; 

SELECT * FROM KOR_LOAN_STATUS

--PERIOD 를 그룹으로 대출잔액 합계
SELECT PERIOD, REGION, SUM(LOAN_JAN_AMT) FROM KOR_LOAN_STATUS
GROUP BY PERIOD, REGION ORDER BY PERIOD;

SELECT RENT_DATE AS "날짜", ROUND(AVG(DISCOUNT),1) AS "할인평균" FROM RENTLIST
GROUP BY RENT_DATE HAVING AVG(DISCOUNT)<180;






















