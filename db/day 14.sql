테이블을 조회하면 기본적으로 정렬이 안되어 있음(집합);

emp 테이블에서 empno = 7698인 데이터를 조회
EXPLAIN PLAN FOR
SELECT *
  FROM emp
 WHERE empno = 7698;
 
SELECT *
  FROM TABLE(dbms_xplan.display);
  
--------------------------------------------------------------------------
| Id  | Operation         | Name | Rows  | Bytes | Cost (%CPU)| Time     |
--------------------------------------------------------------------------
|   0 | SELECT STATEMENT  |      |     1 |    87 |     3   (0)| 00:00:01 |
|*  1 |  TABLE ACCESS FULL| EMP  |     1 |    87 |     3   (0)| 00:00:01 |
--------------------------------------------------------------------------

ALTER TABLE emp DROP CONSTRAINT SYS_C006997;

제약조건 삭제 (DROP)
ALTER TABLE emp_test DROP CONSTRAINT pk_emp_test;

제약조건 추가 (ADD)
ALTER TABLE emp ADD CONSTRAINT pk_emp PRIMARY KEY (empno);

EXPLAIN PLAN FOR
SELECT *
  FROM emp
 WHERE empno = 7698;
 
SELECT *
  FROM TABLE(dbms_xplan.display);
 
--------------------------------------------------------------------------------------
| Id  | Operation                   | Name   | Rows  | Bytes | Cost (%CPU)| Time     |
--------------------------------------------------------------------------------------
|   0 | SELECT STATEMENT            |        |     1 |    87 |     1   (0)| 00:00:01 |
|   1 |  TABLE ACCESS BY INDEX ROWID| EMP    |     1 |    87 |     1   (0)| 00:00:01 |
|*  2 |   INDEX UNIQUE SCAN         | PK_EMP |     1 |       |     0   (0)| 00:00:01 |
--------------------------------------------------------------------------------------

emp 테이블에 PRIMARY KEY 제약조건을 생성하고 나서 변경된 점
 * 오라클 입장에서 데이터를 조회할 때 사용할 수 있는 전략이 하나 더 생김
 1. TABLE FULL SCAN
 2. pk_emp 인덱스를 이용하여 사용자가 원하는 행을 빠르게 찾아가서 필요한 컬럼들은 인덱스에 저장된 ROWID를 이용하여
 	테이블의 행으로 바로 접근

 
EXPLAIN PLAN FOR
SELECT empno
  FROM emp
 WHERE empno = 7698;
 
SELECT *
  FROM TABLE(dbms_xplan.display); -- 테이블에 접근하는 부분이 빠짐
  
----------------------------------------------------------------------------
| Id  | Operation         | Name   | Rows  | Bytes | Cost (%CPU)| Time     |
----------------------------------------------------------------------------
|   0 | SELECT STATEMENT  |        |     1 |    13 |     0   (0)| 00:00:01 |
|*  1 |  INDEX UNIQUE SCAN| PK_EMP |     1 |    13 |     0   (0)| 00:00:01 |
----------------------------------------------------------------------------

empno 컬럼의 인덱스를  UNIQUE 인덱스가 아닌 일반 인덱스(중복이 가능한)로 생성한 경우
ALTER TABLE emp DROP CONSTRAINT pk_emp;

NON-UNIQUE 인덱스 생성(중복 가능)
 UNIQUE 인덱스 명명규칙 - IDX_U_테이블명_01;
 NON-UNIQUE 인덱스 명명규칙 - IDX_NU_테이블명_01;
 
CREATE [UNIQUE] INDEX 인덱스명 ON 테이블명 (인덱스로 구성할 컬럼);

CREATE INDEX idx_nu_emp_01 ON emp (empno);

EXPLAIN PLAN FOR
SELECT *
  FROM emp
 WHERE empno = 7698;
 
SELECT *
  FROM TABLE(dbms_xplan.display);

---------------------------------------------------------------------------------------------
| Id  | Operation                   | Name          | Rows  | Bytes | Cost (%CPU)| Time     |
---------------------------------------------------------------------------------------------
|   0 | SELECT STATEMENT            |               |     1 |    87 |     2   (0)| 00:00:01 |
|   1 |  TABLE ACCESS BY INDEX ROWID| EMP           |     1 |    87 |     2   (0)| 00:00:01 |
|*  2 |   INDEX RANGE SCAN          | IDX_NU_EMP_01 |     1 |       |     1   (0)| 00:00:01 |
---------------------------------------------------------------------------------------------


---------------------------------------------------------------------------------------------

DCL - DATA Controll LANGUAGE ==> 시스템 권한 또는 객체 권한을 부여 / 회수

권한부여
GRANT 권한명 | 롤명 TO 사용자;

권한회수
REVOKE 권한명 | 롤명 FROM 사용자;

SELECT *
  FROM dictionary;

CATEGORY(접두어)
USER_ ==> 해당 사용자가 소유한 객체 관련 조회
ALL_ ==> 해당 사용자가 소유한 객체 + 권한을 부여받은 객체 조회
DBA_ ==> 데이터베이스에 설치된 모든 객체(DBA 권한이 있는 사용자만 가능 - system)
v$ ==> 성능, 모니터링 관련된 특수 VIEW 

SELECT *
  FROM user_tables;
  
SELECT *
  FROM all_tables;
  
SELECT *
  FROM dba_tables;
  
--------------------------------------------------------------------------------------------

SQL 응용 - DML (SELECT, UPDATE, INSERT, MERGE)

1. Multiple INSERT ==> 많이 사용하는 편은 아님
한 번의 INSERT 구문을 통해서 여러 테이블에 데이터를 입력

실 사용 예 - 1. 실제 사용할 테이블과 별개로 보조 테이블에도 동일한 데이터 쌓기
		   2. 데이터의 수평분할 (*)
		   주문 테이블
		   2022년 데이터 ==> TB_ORDER_2022
		   2023년 데이터 ==> TB_ORDER_2023
		   ==> 오라클 PARTITION 을 통해 더 효과적으로 관리 가능(정식버전에만 있음)
		   하나의 테이블안에 데이터값에 따라 저장하는 물리공간이 나뉘어져 있음
		   ==> 개발자 입장에서는 데이터를 입력하면 데이터 값에 따라 물리적인 공간을 오라클이 알아서 나눠서 저장

Multiple INSERT 종류
1. unconditional INSERT : 조건과 관계없이 하나의 데이터를 여러 테이블 입력
2. conditional ALL INSERT : 조건을 만족하는 모든 테이블에 입력
3. conditional FIRST INSERT : 조건을 만족하는 첫번째 테이블에 입력

--------------------------------------------------------------------------------------------

1. emp_test, emp_test2 테이블 삭제
2. emp 테이블의 empno 컬럼이랑 ename 컬럼만 갖고 emp_test, emp_test2 를 생성.
   단, 데이터를 복사하지 않음.

DROP TABLE emp_test;
DROP TABLE emp_test2;

CREATE TABLE emp_test AS 
SELECT empno, ename
  FROM emp
 WHERE 1 != 1;
   
CREATE TABLE emp_test2 AS 
SELECT empno, ename
  FROM emp
 WHERE 1 != 1;

SELECT *
  FROM emp_test2;

--------------------------------------------------------------------------------------------

[ unconditional INSERT ]

SELECT 9999 empno, 'brown' ename FROM dual
UNION ALL
SELECT 9998 empno, 'sally' ename FROM dual;

위 두개의 행을 emp_test, emp_test2 에 동시 입력, 하나의 INSERT 구문 사용

INSERT ALL
	INTO emp_test VALUES (empno, ename)
	INTO emp_test2 (empno) VALUES (empno)	-- 첫번째 empno 는 데이터를 입력할 테이블의 컬럼 이름
											-- 두번째 empno 는 넣을 값.
SELECT 9999 empno, 'brown' ename FROM dual
UNION ALL
SELECT 9998 empno, 'sally' ename FROM dual;	

SELECT *
 FROM emp_test2;
 
--------------------------------------------------------------------------------------------

[ conditional INSERT ]

ROLLBACK; -- 비교하기 위해 롤백

조건 분기 문법 : CASE WHEN THEN END 
조건 분기 함수 : DECODE

INSERT ALL
	WHEN empno >= 9999 THEN
		INTO emp_test VALUES (empno, ename)
	WHEN empno >= 9998 THEN
		INTO emp_test2 VALUES (empno, ename)
	ELSE
		INTO emp_test2 (empno) VALUES (empno)
SELECT 9999 empno, 'brown' ename FROM dual
UNION ALL
SELECT 9998 empno, 'sally' ename FROM dual;

SELECT *
  FROM emp_test2;
  
--------------------------------------------------------------------------------------------
 
[ conditional FIRST INSERT ]

ROLLBACK;

ALL ==> 3건의 데이터가 입력됨, FIRST ==> ?

INSERT FIRST
	WHEN empno >= 9999 THEN
		INTO emp_test VALUES (empno, ename)
	WHEN empno >= 9998 THEN
		INTO emp_test2 VALUES (empno, ename)
	ELSE
		INTO emp_test2 (empno) VALUES (empno)
SELECT 9999 empno, 'brown' ename FROM dual
UNION ALL
SELECT 9998 empno, 'sally' ename FROM dual
UNION ALL
SELECT 9997 empno, 'moon' ename FROM dual;

SELECT *
  FROM emp_test;
  
SELECT *
  FROM emp_test2;
  
 ROLLBACK;
 
--------------------------------------------------------------------------------------------

MERGE 
1. 사용자로부터 받은 값을 가지고 테이블에 저장 OR 수정하고 싶은데
   입력받은 값이 테이블에 존재하면 수정을 하고 싶고,
   입력받은 값이 테이블에 존재하지 않으면 신규 입력을 하고 싶을 때
   
2. 테이블의 데이터를 이용하여 다른 테이블의 데이터를 업데이트 OR INSERT 하고 싶을 때
	일반 UPDATE 구문에서는 비효율이 존재
	ALLEN 의 JOB 과 DEPTNO 를 SMITH 사원과 동일하게 업데이트 하시오.
	UPDATE emp SET job = (SELECT job FROM emp WHERE ename = 'SMITH'),
				   deptno = (SELECT deptno FROM emp WHERE ename = 'SMITH')
	 WHERE ename = 'ALLEN';
	 
   ex - empno 9999, ename 'brown'
   	emp 테이블에 동일한 empno 가 있으면 ename 을 업데이트 하고 싶고
   	emp 테이블에 동일한 empno 가 없으면 신규 입력
   	
위의 경우를 MERGE 구문을 사용하지 않는다면
1.1 해당 데이터가 존재하는지 확인하는 SELECT 구문을 실행
1.2 1번 쿼리가 조회 결과가 있으면
 1.2.1 UPDATE
1.3 1번 쿼리가 조회 결과가 없으면
 1.3.1 INSERT

1.
SELECT *
  FROM emp
 WHERE empno = 9999;

2. 
UPDATE emp SET ename = 'brown'
 WHERE empno = 9999;

3.
INSERT INTO emp (empno, ename) VALUES (9999, 'brown');


[문법]
MERGE INTO 테이블명(덮어쓰거나, 신규로 입력할 테이블) alias 
USING (테이블명 | VIEW | inline-VIEW) alias
   ON (두 테이블간 데이터 존재 여부를 확인할 조건)
 WHEN MATCHED THEN
 	UPDATE SET 컬럼1 = 값1,
 			   컬럼2 = 값2
 WHEN NOT MATCHED THEN
 	INSERT (컬럼1, 컬럼2, ...) VALUES (값1, 값2, ...);
 
7369 사원의 데이터를 emp_test로 복사 (empno, ename)

INSERT INTO emp_test
SELECT empno, ename
  FROM emp
 WHERE empno = 7369;

SELECT *
  FROM emp_test;

SELECT *
  FROM emp;

emp - 16 건, emp_test 2건 (7369, 9999 ==> emp 테이블에도 존재)
emp 테이블을 이용하여 emp_test 에 
동일한 empno 값이 있으면 emp_test.ename 업데이트
동일한 empno 값이 없으면 emp 테이블의 데이터를 신규 입력

MERGE INTO emp_test a
USING emp b
   ON (a.empno = b.empno)
 WHEN MATCHED THEN
 	UPDATE SET a.ename = b.ename || '_m'
 WHEN NOT MATCHED THEN
 	INSERT (a.empno, a.ename) VALUES (b.empno, b.ename);

*** MERGE 에서 많이 사용하는 형태 ***
사용자로부터 받은 데이터를 emp_test 테이블에 동일한데이터 존재 유무에 따른 MERGE
시나리오 : 사용자 입력 empno = 9999, ename = 'brown'

MERGE INTO emp_test a
USING dual
ON (a.empno = :empno)
WHEN MATCHED THEN
	UPDATE SET ename = :ename
WHEN NOT MATCHED THEN
	INSERT VALUES (:empno, :ename);

SELECT *
FROM emp_test;

--------------------------------------------------------------------------------------------

-- 실습1
dept_test 테이블을 dept 테이블과 동일하게 생성 단, 10, 20번 부서 데이터만 복제
dept 테이블을 이용하여 dept_test 테이블에 데이터를 MERGE 
* 머지 조건 - 부서번호가 같은 데이터
동일한 부서가 있을때 - 기존 loc 컬럼의 값 + _m 으로 업데이트
동일한 부서가 없을때 : 신규 데이터 입력;

CREATE TABLE dept_test AS
SELECT *
FROM dept
where deptno IN (10, 20);

select *
FROM dept_test;

MERGE INTO dept_test a
USING dept b
ON (a.deptno = b.deptno)
WHEN MATCHED THEN
	UPDATE SET a.loc = b.loc || '_m'
WHEN NOT MATCHED THEN
	INSERT VALUES (b.deptno, b.dname, b.loc);
	
select *
FROM dept_test;

-- 실습2
사용자 입력받은 값을 이용한 MERGE
사용자 입력 - deptno 99, dname 'dw', loc 'daejeon'
dept_test 테이블에 사용자가 입력한 deptno 값과
동일한 데이터가 있을 경우 ==> 사용자가 입력한 dname, loc 값으로 두개 컬럼 업데이트
동일한 데이터가 없을 경우 ==> 사용자가 입력한 deptno, dname, loc 값으로 데이터 등록

DROP TABLE dept_test;

CREATE TABLE dept_test AS
SELECT *
FROM dept
where deptno IN (10, 20);

select * FROM dept_test;

MERGE INTO dept_test a
USING dual
ON (a.deptno = :deptno)
WHEN MATCHED THEN
	UPDATE SET a.dname = :dname, a.loc = :loc
WHEN NOT MATCHED THEN
	INSERT VALUES (:deptno, :dname, :loc);
	
select * FROM dept_test;