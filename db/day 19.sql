[ WINDOWING ] - 파티션 내의 행들을 세부적으로 선별하는 범위를 기술

UNBOUNDED PRECEDING - 현재 행을 기준으로 선행(이전)하는 모든 행들
CURRENT ROW - 현재 행
UNBOUNDED FOLLOWING - 현재 행을 기준으로 이후 모든 행들

RANGE UNBOUNDED PRECEDING : 현재 행을 기준으로해서 파티션 내의 첫번째 행까지 범위를 지정한다.
ROWS BETWEEN 1 PRECEDING AND 1 FOLLOWING : 현재 행을 기준으로 파티션내 앞뒤 한건씩을 범위로 지정
RANGE BETWEEN CURRENT ROW AND UNBOUNDED FOLLOWING : 같은 파티션내 현재행부터 마지막행까지를 범위로 지정

;

SELECT empno, ename, sal,
	   SUM(sal) OVER (ORDER BY sal ROWS BETWEEN 1 PRECEDING AND 1 FOLLOWING) c_sum,
	   SUM(sal) OVER (ORDER BY sal ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW) c_sum2
  FROM emp;
 
-- 윈도우함수 실습1
SELECT empno, ename, deptno, sal,
	   SUM(sal) OVER (PARTITION BY deptno
	   				  ORDER BY deptno, sal
	   				  ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW) c_sum
  FROM emp;
 
-- 윈도우함수 실습2
SELECT empno, ename, deptno, sal,
	   SUM(sal) OVER (ORDER BY sal ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW) c_sum1,
	   SUM(sal) OVER (ORDER BY sal RANGE BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW) c_sum2,
	   SUM(sal) OVER (ORDER BY sal) c_sum3
  FROM emp;
 
WINDOWING - 기본 설정값이 존재 ==> RANGE UNBOUNDED PRECEDING
						   ==> RANGE BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW
						   

PL/SQL - Procedual LANGUAGE / SQL
PL/SQL 프로그램의 종류는 크게 Procedual, FUNCTION, TRIGGER 로 나뉘어진다.
PL/SQL 이란 - SQL 언어에 절차적 문법을 추가한 oracle 의 언어
SQL 은 집합적이지만 실생활에서 발생하는 요구사항을 처리하기 위해서는 절차적 처리가 필요할 때가 있음

PL/SQL 블록의 기본구조
DECLARE - 상수, 변수를 선언, 선언이 필요 없을 경우 생략가능
		- java와 다르게 지역변수를 선언할 수 없음
BEGIN - 로직을 서술하는 부분
EXCEPTION - 예외 발생시 예외 처리 기술(생략가능)

화면 출력기능을 활성화 하는 설정(oracle 접속 후 최초 1회만 실행하면 접속종료시 까지 유지)
SET SERVEROUTPUT ON;	-- sqlplus, sqldeveloper
	   
-----------------------------------------------------------------

간단한 PL/SQL 익명(이름이 없는) 블럭
dept 테이블에서 10번 부서의 deptno, dname 두개의 컬럼 값을 조회해서 변수에 담아
화면 출력

java 변수 선언 - 변수타입 변수명 = 10;
PL/SQL 변수 선언 - 변수명 변수타입 := 10;

DECLARE
	deptno NUMBER(2);
	dname VARCHAR2(14);
BEGIN
	SELECT deptno, dname INTO deptno, dname
	  FROM dept
	 WHERE deptno = 10;
	
	DBMS_OUTPUT.PUT_LINE('deptno : ' || deptno || ', dname : ' || dname);
END;
/	-- PL/SQL의 쿼리가 실질적으로 끝난다는 것을 알려주는 역할
-- PL/SQL 블록 내에서는 한문장이 종료될때마가 세미콜론(;)을 사용하여 한문장이 끝났다는것을 명시

-----------------------------------------------------------------------

변수 참조 타입
	deptno NUMBER(2) ==> deptno dept.deptno%TYPE;
	테이블의 컬럼 타입 변경이 생겨도 PL/SQL 코드는 수정할 필요가 없어진다.

DECLARE
	deptno dept.deptno%TYPE;
	dname dept.dname%TYPE;
BEGIN
	SELECT deptno, dname INTO deptno, dname
	  FROM dept
	 WHERE deptno = 10;
	
	DBMS_OUTPUT.PUT_LINE('deptno : ' || deptno || ', dname : ' || dname);
END;
/

---------------------------------------------------------------------

[ printdept 라는 이름의 프로시져 생성 ]

인자 - 없음
로직 - dept테이블에서 10번부서의 부서이름과, 부서 위치를 로그로 출력

VIEW 와 비교
1. VIEW 생성
2. SELECT *
     FROM 생성한 뷰;

프로시져 절차
1. 프로시져 생성 (CREATE OR REPLACE ....)
2. 프로시져 실행 (EXEC 프로시져명)

CREATE OR REPLACE PROCEDURE printdept IS
	-- 선언부
	dname dept.dname%TYPE;
	loc dept.loc%TYPE;
BEGIN
	SELECT dname, loc INTO dname, loc
	  FROM dept
	 WHERE deptno = 10;
	DBMS_OUTPUT.PUT_LINE('dname : ' || dname || ', loc : ' || loc);
END;
/

프로시져 실행 - EXEC 프로시져 이름; -- sqlplus, sqldeveloper

EXEC printdept;

BEGIN
	printdept;
END;

------------------------------------------------------------

[ printdept 프로시져를 수정 ]

JAVA 메서드 - public String 함수명(인자타입 인자명1, 인자타입2 인자명, ...)
PL/SQL 인자 선언 - 프로시져명(인자명1 IN 인자타입1, 인자명2 IN 인자타입2, ...)
		인자명은 - p_ 접두어를 주로 사용
		변수명은 - v_ 접두어를 주로 사용
		
1. 인자를 받게끔 수정( X ==> 부서번호를 인자로 받는다. )
2. 받은 인자에 해당하는 부서이름과, 위치 정보를 화면에 출력하도록 수정

CREATE OR REPLACE PROCEDURE printdept(p_deptno IN dept.deptno%TYPE) IS
	-- 선언부
	v_dname dept.dname%TYPE;
	v_loc dept.loc%TYPE;
BEGIN
	SELECT dname, loc INTO v_dname, v_loc
	  FROM dept
	 WHERE deptno = p_deptno;
	DBMS_OUTPUT.PUT_LINE('dname : ' || v_dname || ', loc : ' || v_loc);
END;
/

BEGIN
	printdept(20);
END;


-- PL/SQL 실습1
CREATE OR REPLACE PROCEDURE printemp (p_empno IN emp.empno%TYPE) IS
	v_ename emp.ename%TYPE;
	v_dname dept.dname%TYPE;
BEGIN
	SELECT ename, dname INTO v_ename, v_dname
	  FROM emp, dept
	 WHERE emp.deptno = dept.deptno
	   AND empno = p_empno;
	DBMS_OUTPUT.PUT_LINE('ename : ' || v_ename || ', dname : ' || v_dname); 
END;
/

BEGIN
	printemp(7369);
END;

-- PL/SQL 실습2
CREATE OR REPLACE PROCEDURE registdept_test
(
	p_deptno IN dept.deptno%TYPE,
	p_dname IN dept.dname%TYPE,
	p_loc IN dept.loc%TYPE
) IS
BEGIN
	INSERT INTO dept_test VALUES (p_deptno, p_dname, p_loc);
END;

BEGIN
	registdept_test(99, 'dw', 'daejeon');
END;

SELECT *
  FROM dept_test;

-- PL/SQL 실습3
CREATE OR REPLACE PROCEDURE UPDATEdept_test
(
	p_deptno IN dept.deptno%TYPE,
	p_dname IN dept.dname%TYPE,
	p_loc IN dept.loc%TYPE
) IS
BEGIN
	UPDATE dept_test SET deptno = p_deptno, dname = p_dname, loc = p_loc
	 WHERE deptno = p_deptno;
	COMMIT;
END;

BEGIN
	UPDATEdept_test(99, 'dw_m', 'daejeon');
END;

SELECT *
  FROM dept_test;
