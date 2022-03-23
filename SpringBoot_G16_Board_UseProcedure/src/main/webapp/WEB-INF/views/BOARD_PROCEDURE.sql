CREATE OR REPLACE PROCEDURE getMember(
    p_userid IN MEMBER.USERID%TYPE,
    p_curvar OUT SYS_REFCURSOR 
)
IS
    RESULT_CUR SYS_REFCURSOR; 
BEGIN
    OPEN RESULT_CUR FOR SELECT * FROM MEMBER WHERE USERID=p_userid;
    p_curvar := RESULT_CUR;
END;

EXEC getMember()


create or replace PROCEDURE selectBoard(
    p_startNum IN NUMBER,
    p_endNum IN NUMBER,
    p_curvar OUT SYS_REFCURSOR 
)
IS  
    temp_cur SYS_REFCURSOR; 
    vs_num NUMBER;         
    vs_rownum NUMBER;       
    vs_cnt NUMBER;          
BEGIN
    OPEN temp_cur FOR 
        SELECT * FROM (
        SELECT * FROM (
        SELECT b.num, ROWNUM AS rn FROM ((SELECT * FROM board ORDER BY num desc) b)
        )WHERE rn>=p_startNum) WHERE rn <= p_endNum ;
    LOOP
        FETCH temp_cur INTO vs_num, vs_rownum;
        EXIT WHEN temp_cur %NOTFOUND;
        SELECT COUNT(*) INTO vs_cnt FROM REPLY2 WHERE boardnum = vs_num;
        UPDATE BOARD SET REPLYCNT = vs_cnt WHERE NUM = vs_num;
    END LOOP;
    COMMIT;
    
    OPEN p_curvar FOR
        SELECT * FROM (
        SELECT * FROM (
        SELECT b.*, ROWNUM AS rn FROM ((SELECT * FROM BOARD ORDER BY NUM DESC) b)
        ) WHERE rn>=p_startNum ) WHERE rn <= p_endNum ;
END;

create or replace PROCEDURE getAllCount(
    P_CNT OUT NUMBER 
)
IS
    V_CNT NUMBER; 
BEGIN
    SELECT COUNT(*) INTO V_CNT FROM BOARD;
    P_CNT := V_CNT;
END;


create or replace PROCEDURE insertMember(
    p_userid IN member2.userid%type,
    p_pwd IN member2.pwd%type,
    p_name IN member2.name%type,
    p_email IN member2.email%type,
    p_phone IN member2.phone%type
)
IS
BEGIN
    insert into member2(userid, pwd, name, email, phone)
    values (p_userid, p_pwd, p_name, p_email, p_phone);
    commit;
END;


create or replace PROCEDURE updateMember(
    p_userid IN member2.userid%type,
    p_pwd IN member2.pwd%type,
    p_name IN member2.name%type,
    p_email IN member2.email%type,
    p_phone IN member2.phone%type
)
IS
BEGIN
    update member2 set pwd=p_pwd, name=p_name,
    email=p_email, phone=p_phone where userid=p_userid;
    commit;
END;


create or replace PROCEDURE plusReadCount(
    p_num IN board.num%type
)
IS
BEGIN
    update board set readcount = readcount+1 where num=p_num;
    commit;
END;


create or replace PROCEDURE boardView(
    p_num IN board.num%type,
    p_boardcur OUT SYS_REFCURSOR,
    p_replycur OUT SYS_REFCURSOR 
)
IS
BEGIN
    open p_boardcur for 
        select * from board where num=p_num order by num desc;
    open p_replycur for
        select * from reply2 where boardnum=p_num order by num desc;
END;

select * from reply2;

create or replace PROCEDURE insertReply(
    p_boardnum IN reply2.boardnum%type,
    p_userid IN reply2.userid%type,
    p_content IN reply2.content%type
)
IS
BEGIN
    INSERT into reply2 (num, boardnum, userid, content) 
    values (reply_seq.nextval, p_boardnum, p_userid, p_content);
    commit;
END;

create or replace PROCEDURE deleteReply(
    p_num IN reply2.num%type
)
IS
BEGIN
    delete from reply2 where num=p_num;
    commit;
END;

create or replace PROCEDURE getBoard(
    p_num IN board.num%type,
    p_cur OUT SYS_REFCURSOR
)
IS
BEGIN
    open p_cur for 
        select * from board where num=p_num order by num desc;
END;



create or replace PROCEDURE updateBoard(
    p_num IN board.num%type,
    p_userid IN board.userid%type,
    p_pass IN board.pass%type,
    p_email IN board.email%type,
    p_title IN board.title%type,
    p_content IN board.content%type,
    p_imgfilename IN board.imgfilename%type
)
IS
BEGIN
    update board set pass=p_pass, userid=p_userid, email=p_email, 
    title=p_title, content=p_content, imgfilename=p_imgfilename
    where num=p_num;
END;


create or replace PROCEDURE removeBoard(
    p_num IN board.num%type
)
IS
BEGIN
    delete from board where num=p_num;
    commit;
END;


create or replace PROCEDURE insertBoard(
    p_userid IN board.userid%type,
    p_pass IN board.pass%type,
    p_email IN board.email%type,
    p_title IN board.title%type,
    p_content IN board.content%type,
    p_imgfilename IN board.imgfilename%type
)
IS
BEGIN
    insert into board (num, pass, userid, email, title, content, imgfilename)
    values (board_seq.nextval, p_pass, p_userid, p_email, p_title, 
    p_content, p_imgfilename);
END;















