create or replace PROCEDURE getBestNewProduct(
    p_cur1 OUT SYS_REFCURSOR,
    p_cur2 OUT SYS_REFCURSOR 
)
IS
BEGIN
    open p_cur1 for 
        select * from new_pro_view;
    open p_cur2 for
        select * from best_pro_view;
END;




CREATE OR REPLACE PROCEDURE getMember_s(
    p_userid IN member2.userid%TYPE, 
    p_curvar OUT SYS_REFCURSOR
)
IS
BEGIN
    OPEN p_curvar FOR SELECT * FROM member2 WHERE userid=p_userid;
END;


CREATE OR REPLACE PROCEDURE getAddress_s(
    p_dong IN member2.address%TYPE, 
    p_curvar OUT SYS_REFCURSOR
)
IS
BEGIN
    OPEN p_curvar FOR SELECT * FROM address WHERE dong LIKE '%'||p_dong||'%';
END;


