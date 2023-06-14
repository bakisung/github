-- expression : 컬럼값을 가공을 하거나, 존재하지 않는 새로운 상수값(정해진 값)을 표현
--				연산을 통해 새로운 컬럼을 조회할 수 있다.
--				연산을 하더라도 해당 SQL 조회 결과에만 나올 뿐이고 실제 테이블의 데이터에는 영향을 주지 않는다.
--				SELECT 구문은 데이터의 정보에 영향을 주지 않음.

SELECT  sal, sal+500, sal/5, 500
	FROM emp;

SELECT *
	FROM dept;

-- 날짜에 사칙연산 : 수학적으로 정의가 되어 있지 않음
-- SQL 에서는 날짜데이터 +- 정수 ==> 정수를 일자 취급

--'2023년 4월 13일' + 5 : 2023년 4월 13일로 부터 5일 지난 날짜
--'2023년 4월 13일' - 5 : 2023년 4월 13일로 부터 5일 이전 날짜

--데이터베이스에서 주로 사용하는 데이터 타입 : 문자, 숫자, 날짜

--DESC emp; --> sqlplus에서 사용되는 명령어

/*empno : 숫자
ename : 문자
job : 문자
mgr : 숫자
hiredate : 날짜
sal : 숫자
comm : 숫자
deptno : 숫자*/

SELECT hiredate, hiredate + 5, hiredate - 5
	FROM emp;

-- users 테이블의 컬럼 타입을 확인하고, reg_dt 컬럼 값에 5일 뒤 날짜를 새로운 컬럼으로 표현
-- 조회 컬럼 : userid, reg_dt, reg_dt의 5일 뒤 날짜

SELECT userid, reg_dt, reg_dt + 5
	FROM users;

/*
 * NULL : 아직 모르는 값, 할당되지 않은 값
 * NULL과 숫자타입의 0은 다르다
 * NULL과 문자타입의 공백은 다르다
 * 필요한 경우 NULL값을 다른값으로 치환
 * 
 * NULL의 중요한 특징
 * NULL을 피연산자로 하는 연산의 결과는 항상 NULL
 * ex) NULLL + 500 ==> NULL
 */ 

-- emp 테이블에서 sal 컬럼과 comm 컬럼의 합을 새로운 컬럼으로 표현
-- 조회 컬럼은 empno, ename, sal, comm, sal 컬럼과 comm 컬럼의 합
SELECT empno, ename, sal, comm, sal + comm
	FROM emp;

-- ALIAS : 컬럼이나, expression에 새로운 이름을 부여
-- 적용 방법 : 컬럼, expression [as] 별칭명
SELECT empno AS 사번, ename NAME, sal AS 급여, comm 커미션, sal + comm sal_plus_comm
	FROM emp;





