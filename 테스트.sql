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



--�÷��� ���� �������� ����
--��������� �̸��� �������� �ʴ� ��� SYS_xxxxxxx�� ���� �̸��� ����������� �����ȴ�.

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
--    user_constraines ���̺��� Ȯ��
SELECT
    constraint_name,
    constraint_type,
    table_name,
    r_constraint_name
FROM
    user_constraints
WHERE
    table_name = 'EMP01';
    
    
    
--    �÷��� �߰��ؼ� �������� ����
--    �ڷ��� ������ [CONSTRAINTS �������Ǹ� ��������]�� ������ �߰��Ѵ�.
CREATE TABLE emp02( empno NUMBER constraints emp02_empno_pk primary key,
ename varchar2(20) CONstraints emp02_ename_nn not null,
jap varchar2(9) constraints emp02_jab_uk unique,
deptno number(2 ) constraints emp02_deptno _pk references dept ( deptno ) );

--USER_CONSTRAINTS ���̺��� Ȯ��
SELECT
    constraint_name,
    constraint_type,
    table_name,
    r_constraint_name
FROM
    user_constraints
WHERE
    table_name = 'enp02';