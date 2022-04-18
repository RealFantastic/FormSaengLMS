CREATE TABLE test1 (
    col1  NUMBER(2),
    col2  VARCHAR2(9),
    col3  VARCHAR2(15),
    col4  NUMBER(5, 2)
);

SELECT
    table_name
FROM
    user_tables;



--컬럼명 없이 제약조건 생성
--제약사항의 이름을 지정하지 않는 경우 SYS_xxxxxxx와 같은 이름의 제약사항으로 생성된다.

CREATE TABLE dept01 (
    deptno  NUMBER PRIMARY KEY,
    dname   VARCHAR2(14),
    loc     VARCHAR2(13)
);

CREATE TABLE emp01 (
    empno   NUMBER PRIMARY KEY,
    ename   VARCHAR2(20) NOT NULL,
    jab     VARCHAR2(9) UNIQUE,
    deptno  NUMBER(2)
        REFERENCES dept01 ( deptno )
);
--    user_constraines 테이블에서 확인
SELECT
    constraint_name,
    constraint_type,
    table_name,
    r_constraint_name
FROM
    user_constraints
WHERE
    table_name = 'EMP01';
    
    
    
--    컬럼명 추가해서 제약조건 생성
--    자료형 다음에 [CONSTRAINTS 제약조건명 제약조건]의 순으로 추가한다.
CREATE TABLE emp02( empno NUMBER constraints emp02_empno_pk primary key,
ename varchar2(20) CONstraints emp02_ename_nn not null,
jap varchar2(9) constraints emp02_jab_uk unique,
deptno number(2 ) constraints emp02_deptno _pk references dept ( deptno ) );

--USER_CONSTRAINTS 테이블에서 확인
SELECT
    constraint_name,
    constraint_type,
    table_name,
    r_constraint_name
FROM
    user_constraints
WHERE
    table_name = 'enp02';