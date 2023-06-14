[ PL/SQL FUNCTION : java method ]
정해진 작업을 한 다음 결과를 반환하는 PL/SQL block

문법

CREATE [OR REPLACE] FUNCTION 함수명([파라미터]) RETURN 리턴해줄TYPE IS
BEGIN  

END; 
/

RETURN TYPE 을 명시할 때 SIZE 정보는 명시하지 않음
RETURN VARCHAR2(2000) X ==> RETURN VARCHAR2 O

사번을 입력받아서(파라미터) 해당 사원의 이름을 반환하는 함수 getEmpName 생성

CREATE OR REPLACE FUNCTION getEmpName (p_empno emp.empno%TYPE) RETURN VARCHAR2 IS
	v_ename emp.ename%TYPE;
BEGIN
	SELECT ename INTO v_ename
	  FROM emp
	 WHERE empno = p_empno;
	RETURN v_ename;
END;
/

SELECT getEmpName(7369)
  FROM dual;
 
SELECT empno, getEmpName(empno)
  FROM emp;

FUNCTION : getdeptname
파라미터 : 부서번호
리턴값 : 파라미터로 들어온 부서번호의 부서이름

CREATE OR REPLACE FUNCTION getdeptname (p_deptno dept.deptno%TYPE) RETURN VARCHAR2 IS
	v_dname dept.dname%TYPE;
BEGIN
	SELECT dname INTO v_dname
	  FROM dept
	 WHERE deptno = p_deptno;
	RETURN v_dname;
END;
/

SELECT deptno, getdeptname(deptno)
  FROM dept;
 
FUNCTION : fact
파라미터 : 0보다 큰 임의의 정수
리턴값 : 파라미터!(팩토리얼)값 ex) fact(5) ==> 120; 4! = 4 * 3 * 2 * 1

CREATE OR REPLACE FUNCTION fact (p_num IN NUMBER) RETURN NUMBER IS
	n NUMBER := 0;
BEGIN
	IF p_num = 0 THEN
		n := 1;
	ELSE 
		n := p_num * fact(p_num - 1);
	END IF;
	RETURN n;
END;
/

SELECT fact(5) FROM dual;



[ PACKAGE ] : 연관된 PL/SQL 블럭을 관리하는 객체
대표적인 오라클 내장 패키지 : DBMS_OUTPUT

PACKAGE 생성 단계는 2단계로 나누어 생성
1. 선언부			: interface
CREATE OR REPLACE PACKAGE 패키지명 AS
	FUNCTION 함수이름 ([인자]) RETURN 반환타입;
END 패키지명;
/

2. body(구현부) 	: class
CREATE OR REPLACE PACKAGE BODY 바디명 AS
	FUNCTION 함수이름 ([인자]) RETURN 반환타입 IS
		-- 선언부
	BEGIN
		-- 실행부
		RETURN
	END;
END;
/


getEmpName, getDeptName
names 라는 이름의 패키지를 생성하여 등록

1. 패키지 선언부 생성
CREATE OR REPLACE PACKAGE names AS
	FUNCTION getEmpName (p_empno emp.empno%TYPE) RETURN VARCHAR2;
	FUNCTION getDeptName (p_deptno dept.deptno%TYPE) RETURN VARCHAR2;
END names;
/

2. 패키지 바디 생성
CREATE OR REPLACE PACKAGE BODY names AS 
	FUNCTION getEmpName(p_empno emp.empno%TYPE) RETURN VARCHAR2 IS
		v_ename emp.ename%TYPE;
	BEGIN
		SELECT ename INTO v_ename
		  FROM emp
		 WHERE empno = p_empno;
		RETURN v_ename;
	END;

	FUNCTION getDeptName (p_deptno dept.deptno%TYPE) RETURN VARCHAR2 IS
		v_dname dept.dname%TYPE;
	BEGIN
		SELECT dname INTO v_dname
		  FROM dept
		 WHERE deptno = p_deptno;
		RETURN v_dname;
	END;
END;
/

SELECT NAMES.GETEMPNAME(7369) FROM dual;
SELECT NAMES.GETDEPTNAME(30) FROM dual;
	
SELECT names.getempname(7369) FROM dual;


[ TRIGGER ] : 방아쇠
이벤트 핸들러 : 이벤트를 다루는 객체

web : 클릭, 스크롤링, 키입력 등등...
dbms : 특정 테이블에 데이터 신규입력, 기존 데이터 변경, 기존 데이터 삭제

트리거 : 설정한 이벤트에 따라 자동으로 실행되는 PL/SQL 블럭

시나리오 : users 테이블의 pass 컬럼(비밀번호)이 존재
		특정 쿼리에 의해 users 테이블의 pass 컬럼이 변경이 되면
		users_history 테이블에 변경 전 pass 값을 트리거를 통해 저장
	
1. users_history 테이블 생성;
CREATE TABLE users_history AS
	SELECT userid, pass, sysdate reg_dt
	  FROM users
	 WHERE 1 = 2;

SELECT *
  FROM users_history;

2. users 테이블의 변경을 감지하여 실행할 트리거를 생성
감지 항목 : users 테이블의 pass 컬럼이 변경이 되었을 때
감지시 실행 로직 : 변경전 pass 값을 users_history 에 저장

CREATE OR REPLACE TRIGGER make_history
	BEFORE UPDATE OF 컬럼명 ON users
--	BEFORE INSERT OR UPDATE OR DELETE ON users
	FOR EACH ROW
	WHEN (:OLD.userid = 'brown')
	
	BEGIN
		/*
		 * :OLD.컬럼명 ==> 기존값
		 * :NEW.컬럼명 ==> 갱신값
		 */
		IF :OLD.pass != :NEW.pass THEN
			INSERT INTO users_history VALUES (:OLD.userid, :OLD.pass, SYSDATE);
		END IF;
	END;
/

트리거와 무관한 컬럼을 변경할 시 테스트;
UPDATE users SET usernm = 'brown'
 WHERE userid = 'brown';

트리거와 관련된 컬럼을 변경할 시 테스트;
UPDATE users SET pass = '1234'
 WHERE userid = 'brown';

SELECT *
  FROM users_history;
 
SELECT *
  FROM users;


CREATE OR REPLACE TRIGGER chk_emp
	BEFORE INSERT OR UPDATE OF ename, sal OR DELETE ON emp
	
	BEGIN
		CASE
			WHEN INSERTING THEN
				DBMS_OUTPUT.PUT_LINE('Inserting...');
			WHEN UPDATING('sal') THEN
				DBMS_OUTPUT.PUT_LINE('Updating sal...');
			WHEN UPDATING('ename') THEN
				DBMS_OUTPUT.PUT_LINE('Updating ename...');
			WHEN DELETING THEN
				DBMS_OUTPUT.PUT_LINE('Deleting...');
	END;
/


select * FROM emp;
UPDATE emp SET sal = 0 WHERE empno = 7369;
ROLLBACK;

[ 예외 : EXCEPTION, error]
	java : EXCEPTION, error

PL/SQL : PL/SQL 블럭이 실행되는 동안 발생한 에러
예외의 종류
1. 사전 정의 예외
	- java ARTITHMATIC EXCEPTION 
	- 오라클이 사전에 정의한 상황에서 발생하는 예외
	
2. 사용자 정의 예외
	- 변수, 커서처럼 PL/SQL 블록의 선언부에 개발자가 직접 선언한 예외
	  RAISE 키워드를 통해 개발자가 직접 예외를 던진다.
	  
PL/SQL 블록에서 예외가 발생하면
예외가 발생된 지점에서 코드 중단(에러)

단, PL/SQL 블록에서 예외처리 부분이 존재하면 (EXCEPTION 절)
EXCEPTION 절에 기술한 코드가 실행

예외를 포장하기
예외를 잡아 사용자가 정의한 새로운 예외로 던지는 작업;
SELECT ename
FROM emp
WHERE empno = -9999999;
NO_DATA_FOUND ==> emp 테이블에 해당 empno 값을 넣을 수 없는 상태에서 조회가 되지 않았을때

사용자 정의 예외 생성
예외명 EXCEPTION;

DECLARE
	NO_EMP EXCEPTION;
	v_ename emp.ename%TYPE;
BEGIN
	BEGIN
		select ename INTO v_ename
		FROM emp
		WHERE empno = 1111;
	EXCEPTION
		WHEN NO_DATA_FOUND THEN
		RAISE NO_EMP;
	END;
EXCEPTION
	WHEN NO_EMP THEN
		DBMS_OUTPUT.PUT_LINE('NO_EMP');
END;
/