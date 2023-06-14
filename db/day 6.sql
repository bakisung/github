-- 실습5
-- users테이블에서 userid가 brown이 아닌 회원의 userid, usernm, reg_dt, reg_dt가 없다면 오늘 날짜로
-- 변경하여 조회해주세요.
SELECT userid, usernm, reg_dt, nvl(reg_dt, SYSDATE) n_reg_dt
FROM users
WHERE userid != 'brown'
;

-- SQL 조건문
CASE
	WHEN 조건문(참 거짓을 판단할 수 있는 문장) THEN 반환값
	WHEN 조건문(참 거짓을 판단할 수 있는 문장) THEN 반환값2
	WHEN 조건문(참 거짓을 판단할 수 있는 문장) THEN 반환값3
	ELSE 모든 when절을 만족시키지 못할때 반환할 기본값
END

-- emp 테이블에 저장된 job 컬럼의 값을 기준으로 급여(sal)를 인상시키려고 한다.
-- sal컬럼과 함께 인상된 sal 컬럼의 값을 비교하고 싶은 상황
-- 급여 인상 기준
-- job이 salesman : sal * 1.05
-- job이 manager : sal * 1.1
-- job이 president : sal * 1.2
-- 나머지 기타 직군은 sal로 유지

SELECT ename, job, DEPTNO, sal, DECODE(job, 'SALESMAN', sal * 1.05, 
											'MANAGER', DECODE(DEPTNO, 30, sal * 1.3, sal * 1.1),
											'PRESIDENT', sal * 1.2,
											sal) inc_sal
FROM emp
ORDER BY DEPTNO;

--	CASE
--		WHEN job = 'SALESMAN' THEN sal * 1.05
--		WHEN job = 'MANAGER' THEN
--								CASE
--									WHEN deptno = 30 THEN sal * 1.3
--									ELSE sal * 1.1
--								END
--		WHEN job = 'PRESIDENT' THEN sal * 1.2
--		ELSE sal
--	END inc_sal
--FROM emp
--ORDER BY DEPTNO;
-- 위의 case문 중첩 구문을 decode 중첩 구문으로 바꿔주세요.

-- 실습7 입사년도를 조회하여 올해 건강검진 대상인지 아닌지 조회하는것
SELECT empno, ename, hiredate, TO_CHAR(HIREDATE, 'yyyy') birth_year,
	CASE
		WHEN MOD(TO_CHAR(HIREDATE, 'yyyy'), 2) = 1 THEN '건강검진 대상자'
	ELSE '건강검진 비 대상자'
	END CONTACT_TO_DOCTOR
FROM emp
ORDER BY empno;
--SELECT :param param, TO_CHAR(LAST_DAY(TO_DATE(:param, 'YYYYMM')), 'DD') DD  
--FROM dual;

SELECT *
FROM emp;

SELECT EMPNO, ENAME,
	CASE
		WHEN DEPTNO = '20' THEN 'RESEARCH'
		WHEN DEPTNO = '30' THEN 'SALES'
		WHEN DEPTNO = '10' THEN 'ACCOUNTING'
		ELSE 'DW'
	END DNAME
FROM emp
ORDER BY empno
;

-- DECODE : 조건에 따라 반환 값이 달라지는 함수
--			==> 비교, JAVA (if), SQL - case와 비슷
--			단, 비교연산이 ( = )만 가능하다
--			CASE의 WHEN절에 기술할 수 있는 코드는 참 거짓 판단을 할 수 있는 코드면 가능
--			ex : sal > 1000
--			이것과 다르게 DECODE 함수에서는 sal = 1000, sal = 2000

-- DECODE는 가변인자(인자의 갯수가 정해지지 않음, 상황에 따라 늘어날 수도 있다)를 갖는 함수
-- DECODE는 연산자가 제한된다. equals ( = ) 연산만 가능.  CASE 절은 다른 연산자 사용 가능.
-- 문법 : DECODE(기준값[col | expression],
--				비교값1, 반환값1,
--				비교값2, 반환값2,
--				비교값3, 반환값3, ...
--				옵션[기준값이 비교값중에 일치하는 값이 없을때 기본적으로 반환할 값])

-- ==> java
-- if(기준값 == 비교값1)
--		반환값1 반환
-- else if(기준값 == 비교값2)
--		반환값2 반환
-- else if(기준값 == 비교값3)
--		반환값3 반환
-- else
--		마지막 인자가 있을 경우 마지막 인자를 반환하고
--		마지막 인자가 없을 경우 null을 반환

-- 위의 실습6을 DECODE로
SELECT empno, ename, DECODE(deptno, 10, 'ACCOUNTING', 
									20, 'RESEARCH', 
									30, 'SALES', 
									'DW') dname
FROM emp
ORDER BY empno;

-- 그룹함수 : 여러개의 행을 입력으로 받아서 하나의 행으로 결과를 리턴하는 함수
-- SUM : 합계
-- COUNT : 행의 수
-- AVG : 평균
-- MAX : 그룹에서 가장 큰 값
-- MIN : 그룹에서 가장 작은 값

-- 사용방법
--SELECT 행들을 묶을 기준1, 행드르을 묶을 기준2, 그룹함수...
--FROM 테이블
--[WHERE]
--GROUP BY 행들을 묶을 기준1, 행들을 묶을 기준2

--1. 부서번호별 sal 컬럼의 합
--==> 부서번호가 같은 행들을 하나의 행으로 만든다.
--2. 부서번호별 가장 큰 급여를 받는사람 급여액수
--3. 부서번호별 가장 작은 급여를 받는사람 급여액수
--4. 부서번호별 급여 평균액수
--5. 부서번호별 급여가 존재하는 사람의 수(sal 컬럼이 null이 아닌 행의 수)
--								* : 그 그룹의 행수
SELECT deptno, sum(sal), max(sal), MIN(sal), AVG(sal) 
FROM emp
WHERE DEPTNO IS NOT null
GROUP BY DEPTNO; -- 부서번호 별로

-- 그룹함수의 특징
-- 1. null 값을 무시
-- 30번 부서의 사원 6명중 2명은 comm 값이 NULL
SELECT ename, deptno
FROM emp;

SELECT deptno, sum(comm)
FROM emp
GROUP BY deptno;

-- 2. GROUP BY를 적용 여러행을 하나의 행으로 묶게되면 SELECT 절에 기술할 수 있는 컬럼이 제한됨
-- ==> SELECT 절에 기술되는 일반 컬럼들은(그룹 함수를 적용하지 않은) 반드시 GROUP BY 절에 기술 되어야 한다.
--		* 단 그룹핑에 영향을 주지않는 고정된 상수, 함수는 기술하는것이 가능하다.
SELECT DEPTNO, ENAME, sum(sal)
FROM emp
GROUP BY DEPTNO, ENAME 

-- 3. 일반 함수를 where 절에서 사용하는게 가능
-- WHERE UPPER(ename) = 'SMITH';
-- 그룹함수의 경우 WHERE 절에서 사용하는게 불가능
-- 하지만 HAVING 절에 기술하여 동일한 결과를 나타낼 수 있다.

-- 부서번호별로 SUM(sal) 값이 9000보다 큰 행들만 조회하고 싶은 경우
SELECT DEPTNO, SUM(sal) 
FROM emp
GROUP BY DEPTNO
HAVING sum(sal) > 9000
;