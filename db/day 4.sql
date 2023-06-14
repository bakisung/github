-- ROWNUM : SELECT 순서대로 행 번호를 부여해주는 가상 컬럼
-- 특징 : WHERE 절에서 사용가능
--	*** 사용할 수 있는 형태가 정해져 있음 ***
--		WHERE ROWNUM = 1;				ROWNUM이 1일 때
--		WHERE ROWNUM <= N;				ROWNUM이 N보다 작거나 같은 경우, 작은 경우
--		WHERE ROWNUM BETWEEN 1 AND N;	ROWNUM이 1보다 크거나 같고 N보다 작거나 같은 경우
--				==> ROWNUM은 1부터 순차적으로 읽는 환경에서만 사용이 가능
--	***** 안되는 경우 *****
--		WHERE ROWNUM = 2;
--		WHERE ROWNUM >= 2;
-- ROWNUM 사용 용도 : 페이징 처리
-- 페이징 처리 : 네이버 카페에서 게시글 리스트를 한 화면에 제한적인 갯수로 조회(100개)
--				카페에 전체 게시글 수는 굉장히 많음 ==> 한 화면에 못 보여줌
--				1.웹 브라우저가 버벅임,	2. 사용자의 사용성이 굉장히 불편
--				==> 한 페이지당 건수를 정해놓고 해당 건수만큼만 조회해서 화면에 보여준다.

-- WHERE 절에서 사용할 수 있는 형태
SELECT empno, ename
FROM emp
WHERE rownum = 1
;

SELECT rownum, empno, ename
FROM emp
WHERE rownum <= 10
;

-- WHERE 절에서 사용할 수 없는 형태
SELECT rownum, empno, ename
FROM emp
WHERE rownum >= 10
;

-- ROWNUM 과 ORDER BY
-- SELECT SQL의 실행 순서 : FROM => WHERE => SELECT => ORDER BY

SELECT rownum, empno, ename
FROM emp
ORDER BY ename
;
-- SELECT 에서 ROWNUM이 먼저 적용된 상태에서 DODER BY가 실행되면서 뒤죽박죽

-- ROWNUM의 결과를 정렬 이후에 반영하고 싶은 경우 ==> IN-LINE VIEW 사용
-- VIEW : SQL - DBMS에 저장되어있는 SQL
-- IN-LINE : 직접 기술했다, 어딘가 저장을 한게 아니라 그 자리에 직접 기술

SELECT sal
FROM(
		SELECT empno, ename
		FROM emp
	)
;

-- SELECT 절에 * 만 단독으로 사용하지 않고 콤마를 통해 다른 임의 컬럼이나 expression을 표기한 경우
-- * 앞에 어떤 테이블(뷰)에서 온것인지 한정자(테이블 이름, view 이름)를 붙여줘야 한다.

-- table, view 별칭 : table이나 view에도 SELECT 절의 컬럼처럼 별칭을 부여할 수 있다.
--					단, SELECT 절처럼 AS 키워드는 사용하지 않는다.
--					ex : FROM EMP e
--						FROM (SELECT empno, ename)
--								FROM emp
--								ORDER BY eanme) v_emp;

SELECT emp.*
FROM emp
;

SELECT rownum, a.*
FROM (SELECT empno, ename
		FROM emp
		ORDER BY ename) a;
-- ==> 실행순서 : 바깥 from => 안쪽 from => 안쪽 select => 안쪽 order by => 바깥쪽 select
-- ==> ()를 FROM 절이라고 생각하고 사용(SELECT 구문을 하나의 테이블로 생각하고 사용)
-- 요구사항 : 1페이지당 10건의 사원 리스트가 보여야된다.
-- 1page : 1~10
-- 2page : 11~20
-- 3page : 21~30
--	.
--	.
--	.
-- n page : 10(n-1)+1 ~ 10n	
-- ==> pageSize * (n-1) + 1 ~ pageSize * n
	
-- 페이징 처리 쿼리 1page
SELECT rownum, a.*
FROM (SELECT empno, ename
		FROM EMP
		ORDER BY ename) a
WHERE ROWNUM BETWEEN 1 AND 10;

-- 페이징 처리 쿼리 2page
SELECT rownum, a.*
FROM (SELECT empno, ename
		FROM EMP
		ORDER BY ename) a
WHERE ROWNUM BETWEEN 11 AND 20;
-- rownum의 특성으로 1번부터 읽지 않는 형태이기 때문에 정상적으로 동작하지 않는다
-- rownum의 값으로 별칭을 통해 새로운 컬럼으로 만들고 해당 SELECT sql을 in-line view로 만들어서
-- 외부에서 rownum에 부여한 별칭을 통해 페이지 처리를 한다.
SELECT *
FROM (
		SELECT rownum rn, a.*
		FROM (
			SELECT empno, ename
			FROM emp
			ORDER BY ename) a
	)
WHERE rn BETWEEN 11 AND 20
;

-- SQL 바인딩 변수 : java 변수
-- 페이지 번호 : page
-- 페이지 사이즈 : pageSize
-- SQL 바인딩 변수 표기 ==> :변수명 ==> :page, :pageSize

-- 바인딩 변수 적용 (:page-1) * :pageSize + 1 ~ :page * :pageSize
SELECT *
FROM (
		SELECT rownum rn, a.*
		FROM (
			SELECT empno, ename
			FROM emp
			ORDER BY ename) a;
	)
WHERE rn BETWEEN (:page-1) * :pageSize + 1 and :page * :pageSize



-- FUNCTION : 입력을 받아들여 특정 로직을 수행 후 결과 값을 반환하는 객체
-- 오라클에서의 함수 구분 : 입력되는 행의 수에 따라
-- 1. Single row function
--		하나의 행이 입력돼서 결과로 하나의 행이 나온다.
-- 2. Multi row function
--		여러개의 행이 입력되어 결과로 하나의 행이 나온다.

-- dual 테이블 : oracle의 sys계정에 존재하는 하나의 행, 하나의 컬럼(dummy)을 갖는 테이블.
--				누구나 사용할 수 있도록 권한이 개방됨.
-- dual 테이블 용도
-- 1. 함수 실행(테스트)
-- 2. 시퀀스 실행
-- 3. merge 구문
-- 4. 데이터 복제***
-- 5. LENGTH 함수 테스트

SELECT LENGTH('test')
FROM dual;

SELECT LENGTH(ename), ename
FROM emp

-- 문자열 관련 함수
SELECT CONCAT('Hello', concat(',', ' World!!')) concat  -- Hello , World ==> Hello, World
		, substr('Hello, world', 1, 5) substr
		, substr('Hello, world', 8, 12) substr2
		, LENGTH('Hello, World') LENGTH
		, INSTR('Hello, World', 'o') instr1
		, INSTR('Hello, World', 'o', 2) instr2 
		, INSTR('Hello, World', 'o', 1, 2) instr3
		, LPAD('Hello, World', 15, '@') lpad
		, RPAD('Hello, Wolrd', 17, '!' ) rpad
		, REPLACE('Hello, Wolrd', 'o', 'a') REPLACE
		, TRIM('     Hello, World  ') trim
		, TRIM('H' FROM 'Hello, World') trim2 -- 가장 자리에 있는 H만 제거해준다.
		, lower('Hello, World') lower 
		, upper('Hello, World') upper
		, initcap('hello, world') initcap1
		, initcap('hello,world') initcap2
		, initcap('helloworld') initcap3
		, initcap('hello-world') initcap4
		, initcap('hello world') initcap5
FROM dual;

-- 함수는 WHERE 절에서도 사용 가능
-- emp 테이블에서 사원 이름이 smith인 사람을 조회하세요.
SELECT *
FROM emp
WHERE ename = upper('smith')
;

SELECT *
FROM emp
WHERE lower(ename) = 'smith';

-- 위 두개의 쿼리중에서 하지 말아야 할 형태
-- 두번째 쿼리는 14번을 실행해봐야 소문자로 바뀌고 나서 비교를 함
--		==> 좌변을 가공하는 형태 (좌변 - 테이블 컬럼을 의미)
-- 첫번째 쿼리는 고정된 'smith' 한번만 적용하면 찾을 수 있음.

-- 오라클 숫자 관련 함수
-- ROUND(숫자, 반올림 기준자리) : 반올림 함수
-- TRUNC(숫자, 내림 기준자리) : 내림 함수
-- MOD(피제수, 제수) : 나머지 값을 구하는 함수

SELECT	 ROUND(105.43, 1) round1
		,ROUND(105.55, 1) round2
		,ROUND(105.55, 0) round3
		,ROUND(105.55) round4 
		,ROUND(105.55, -1) round4 
FROM dual;

SELECT 	TRUNC(105.54, 1) trunc1
		,TRUNC(105.55, 1) trunc2 
		,TRUNC(105.55, 0) trunc3 
		,TRUNC(105.55, -1) trunc4 
FROM dual;