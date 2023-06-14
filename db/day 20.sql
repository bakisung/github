지금까지 배운 변수 선언
변수명 변수타입
변수명 참조타입(ex - dept.deptno%TYPE)
==> 스칼라 변수, 변수 하나에 하나의 값만 할당 가능

java에서 변수 하나에 여러개의 값을 넣을 수 있는 자료형
배열, List, MAP, SET ...

변수 ==> 컬럼의 값
컬럼의 값 ==> 행, 행 전체를 담을 수 있는 변수

복합변수
1. 특정 테이블의 행의 모든 컬럼을 담을 수 있는 참조변수 - 테이블명%ROWTYPE
2. RECORD TYPE - 사용자 정의 타입
	행의 정보를 담을 수 있는것은 ROWTYPE 과 동일, 사용자가 원하는 컬럼에 대해서만 정의
3. TABLE TYPE - 복수개의 행을 담을 수 있는 타입

컬럼		==>		행		==> 복수행
단일변수	==>		MAP		==> List

%ROWTYPE
선언 - 변수명 테이블명%ROWTYPE;
컬럼 접근방법 - 변수명.컬럼명

dept 테이블의 10번 부서 정보(3가지 컬럼)을 %ROWTYPE 으로 받아 화면에 출력 익명 블럭으로 작성

DECLARE - 상수, 변수를 선언, 선언이 필요 없을 경우 생략가능
		- java와 다르게 지역변수를 선언할 수 없음
BEGIN - 로직을 서술하는 부분

select * FROM dept;

DECLARE
	v_dept_row dept%ROWTYPE;
BEGIN
	select * INTO v_dept_row
	FROM dept
	WHERE deptno = 10;
	DBMS_OUTPUT.PUT_LINE('dname : ' || v_dept_row.dname || ', deptno : ' || v_dept_row.deptno || ', loc : ' || v_dept_row.loc);
END;
/

RECORD TYPE
java에서 클래스를 인스턴스로 생성 하려면
1. class 생성()
2. 1번에서 생성한 class를 활용하여 NEW 연산자를 통해 INSTANCE 를 생성(붕어빵)

TYPE 선언 방법
TYPE 타입 이름(CLASS 이름 짓기) IS RECORD (
	컬럼명1 타입명1,
	컬럼명2 타입명2, ...
);
	변수명 변수타입;
	변수명 타입이름;

dept테이블의 10번 부서의 부서번호, 부서이름을 RECORD TYPE 으로 생성된 변수에 값을 담아서 출력
(dept의 모든 컬럼을 조회하는것이 아니라, 일부 컬럼만 조회)

DECLARE
	TYPE dept_rec_type IS RECORD (
		deptno dept.deptno%TYPE,
		dname dept.dname%TYPE
	);
		v_dept_rec dept_rec_type;
BEGIN
	select deptno, dname INTO v_dept_rec
	FROM dept
	WHERE deptno = 10;
	DBMS_OUTPUT.PUT_LINE('deptno : ' || v_dept_rec.deptno || ', dname : ' || v_dept_rec.dname);
END;
/

emp 테이블에서 사원번호, 사원이름, 사원부서, 업무를 RECORD TYPE 을 통해 조회하는 익명 PL/SQL 블럭을 작성하세요.('SMITH' 사원의);
select * FROM dept;
select * FROM emp;
DECLARE
	TYPE emp_rec_type IS RECORD (
		empno emp.empno%TYPE,
		ename emp.ename%TYPE,
		deptno emp.deptno%TYPE,
		job emp.job%TYPE
	);
		v_emp_rec emp_rec_type;
BEGIN
	select empno, ename, deptno, job INTO v_emp_rec
	FROM emp
	WHERE empno = 7369;
	DBMS_OUTPUT.PUT_LINE('empno : ' || v_emp_rec.empno || ', ename : ' || v_emp_rec.ename || ', deptno : ' || v_emp_rec.deptno || ', job : ' || v_emp_rec.job);
END;
/

TABLE TYPE : 여러건의 행을 저장할 수 있는 타입

TABLE TYPE 선언
TYPE 테이블 타입 이름 IS TABLE OF 행의 타입(ROWTYPE OR RECORD TYPE) INDEX BY BINARY_INTEGER 
테이블 타입의 인덱스는 1부터 시작한다.

DECLARE 
	TYPE dept_tab_type IS TABLE OF dept%ROWTYPE INDEX BY BINARY_INTEGER;
	dept_tab dept_tab_type;
BEGIN 
	select * BULK COLLECT INTO dept_tab
	FROM dept;
	DBMS_OUTPUT.PUT_LINE('deptno : ' || dept_tab(1).deptno);
END;
/

[ 조건 제어 ]

IF 구문
IF CONDITION THEN
	실행할 문장
ELSIF CONDITION THEN
	실행할 문장
ELSE 
	실행할 문장
END IF;

DECLARE 
	p NUMBER := 2;
BEGIN
	IF p = 1 THEN
		DBMS_OUTPUT.PUT_LINE('p=1');
	ELSIF p = 2 THEN
		DBMS_OUTPUT.PUT_LINE('p=2');
	ELSE 
		DBMS_OUTPUT.PUT_LINE('ELSE');
	END IF;
END;
/

[ FOR LOOP ]

문법
FOR 인덱스변수 IN [reverse] 시작값..종료값 LOOP
	반복실행할 문장;
END LOOP;
/

1 ~ 5 까지 출력

DECLARE
BEGIN
	FOR i IN 1..5 LOOP
		DBMS_OUTPUT.PUT_LINE(i);
	END LOOP;
END;
/

구구단 출력(1 * 2 = 2)

DECLARE
BEGIN 
	FOR i IN 2..9 LOOP
		FOR j IN 1..9 LOOP
			DBMS_OUTPUT.PUT_LINE(i || '*' || j || '=' || i * j);
		END LOOP;
	END LOOP;
END;
/

[ WHILE ]

문법
	WHILE 조건 LOOP 
		반복할 문장;
	END LOOP
	

1 ~ 5 출력;
DECLARE
	i NUMBER := 0;
BEGIN
	WHILE i < 5 LOOP
		DBMS_OUTPUT.PUT_LINE(i + 1);
		i := i + 1;
	END LOOP;
END;
/

[ LOOP ]

문법
LOOP 
	반복 실행할 문장; - 위 아래 위치 상관 없다
	EXIT WHEN 탈출조건;
	반복 실행할 문장; - 위 아래 위치 상관 없다
END LOOP

1 ~ 5 출력;
DECLARE
	i NUMBER := 0;
BEGIN
	LOOP 
	DBMS_OUTPUT.PUT_LINE(i);
	i := i + 1;
		EXIT WHEN i > 5;
	END LOOP;
END;
/

[ CURSOR ]

CURSOR : SELECT 문이 실행되는 메모리 상의 공간
		다량의 데이터를 변수에 담게되면 메모리 낭비가 심해져 프로그램이 정상동작을 못할 수 있다.
		한 번에 모든 데이터를 인출하지 않고, 개발자가 직접 인출 단계를 제어 함으로써 변수에 모든 데이터를
		담지 않고도 개발하는 것이 가능
		
CURSOR 의 종류
묵시적 커서 : 커서 이름을 별도로 지정하지 않을 경우 ==> oracle 이 알아서 처리 해준다.
명시적 커서 : 커서를 명시적 이름과 함께 선언하고, 개발자가 해당 커서를 직접 제어 가능하다.

명시적 CURSOR 사용 방법
1. 커서 선언 (DECLARE)
	CURSOR 커서이름 IS
		SELECT 쿼리;
2. 커서 열기
	OPEN 커서이름;
3. FETCH (인출)
	FETCH 커서이름 INTO 변수;
4. 커서 닫기
	CLOSE 커서이름;

속성
1. 커서명%FOUND : 해당 SQL 문에 의해 반환된 총 행수가 1개 이상일 경우 TRUE 반환
2. 커서명%NOTFOUND : 해당 SQL 문에 의해 반환된 총 행수가 없을 경우 TRUE 반환
3. 커서명%ROWCOUNT : 해당 SQL 문에 의해 반환된 총 행수

dept 테이블의 모든 행에 대해 부서번호, 부서이름을 CURSOR 를 통해 데이터를 다루는 실습;

DECLARE
	CURSOR dept_cur IS 
		select deptno, dname
		FROM dept;
	v_deptno dept.deptno%TYPE;
	v_dname dept.dname%TYPE;
BEGIN
	OPEN dept_cur;

	LOOP 
		FETCH dept_cur INTO v_deptno, v_dname;
		EXIT WHEN dept_cur%NOTFOUND;
		DBMS_OUTPUT.PUT_LINE(v_deptno || ', ' || v_dname);
	END LOOP;	
	CLOSE dept_cur;
END;


CURSOR 의 경우 반복문과 사용되는 일이 많기 때문에 PL/SQL 에서는 FOR LOOP와
함께 사용하는 문법을 지원한다.

문법
	FOR 레코드명 IN 커서명 LOOP
		반복 실행 할 문장;
	END LOOP;

OPEN, FETCH, CLOSE : 2 ~ 4단계 ==> FOR LOOP 문에서 자동으로 실행

DECLARE
	CURSOR dept_cur IS 
		SELECT deptno, dname
		FROM dept;
BEGIN
	FOR dept_row IN dept_cur LOOP
		DBMS_OUTPUT.PUT_LINE(dept_row.deptno || ', ' || dept_row.dname);
	END LOOP;
END;
/


emp 테이블에서 특정 부서에 속하는 사원의 사번과 이름을 출력하는 로직을
파라미터가 있는 커서를 활용하여 작성해주세요.;

DECLARE
	CURSOR emp_cur (p_deptno dept.deptno%TYPE) IS
		select empno, ename
		FROM emp
		WHERE deptno = p_deptno;
BEGIN
	FOR emp_row IN emp_cur(10) LOOP
		DBMS_OUTPUT.PUT_LINE(emp_row.empno || ', ' || emp_row.ename);
	END LOOP;
END;
/


[ 인라인 커서 ]
FOR LOOP 기술시 커서를 직접 기술

BEGIN
	FOR dept_row IN (SELECT deptno, dname FROM dept) LOOP
		DBMS_OUTPUT.PUT_LINE(dept_row.deptno || ', ' || dept_row.dname);
	END LOOP;
END;


















