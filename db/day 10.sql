-- 실습1
SELECT b.buy_date, b.buy_prod, p.prod_id, p.prod_name, b.buy_qty
  FROM buyprod b, prod p
 WHERE b.buy_prod(+) = p.prod_id
   AND b.buy_date(+) = '2005/01/25'
;

-- 실습2
SELECT NVL(b.buy_date, '2005/01/25'), b.buy_prod, p.prod_id, p.prod_name, b.buy_qty
  FROM buyprod b, prod p
 WHERE b.buy_prod(+) = p.prod_id
   AND b.buy_date(+) = '2005/01/25'
;

-- 실습3
SELECT NVL(b.buy_date, '2005/01/25') buy_date, b.buy_prod, p.prod_id, p.prod_name, NVL(b.buy_qty, 0) buy_qty
  FROM buyprod b, prod p
 WHERE b.buy_prod(+) = p.prod_id
   AND b.buy_date(+) = '2005/01/25'
;

-- 실습4
SELECT p.pid, p.pnm, NVL(c.cid, 1) cid, NVL(c."DAY", 0) day, NVL(c.cnt, 0) cnt
  FROM CYCLE c, product p 
 WHERE c.pid(+) = p.pid
   AND c.cid(+) = 1
;

-- 실습5
SELECT p.pid, p.pnm, NVL(c.cid, 1) cid, NVL(cs.cnm, 'brown') cnm, NVL(c."DAY", 0) day, NVL(c.cnt, 0) cnt 
  FROM CYCLE c, product p, customer cs
 WHERE c.pid(+) = p.pid 
   AND c.cid = cs.cid(+)
   AND c.cid(+) = 1
;


SUBQUERY : SQL 내부에서 사용된 SQL (Main 쿼리에서 사용된 쿼리)
사용위치에 따른 분류
1. SELECT 절 : scalar(단일의) subquery
2. FROM 절 : IN-LINE-VIEW
3. WHERE 절 : subquery

반환하는 행, 컬럼 수에 따른 분류
1. 단일행, 단일 컬럼
2. 단일행, 복수 컬럼
3. 복수행, 단일 컬럼
4. 복수행, 복수 컬럼

서브쿼리에서 메인쿼리의 컬럼을 사용유무에 따른 분류
1. 서브쿼리에서 메인쿼리의 컬럼 사용 : corelated subquery ==> 상호 연관 서브쿼리
		==> 서브쿼리 단독으로 실행하는 것이 불가능
2. 서브쿼리에서 메인쿼리의 컬럼 미사용 : non(un) corelated subquery ==> 비상호 연관 서브쿼리
		==> 서브쿼리 단독으로 실행하는 것이 가능
		

SMITH 사원이 속한 부서에 속하는 사원들은 누가 있을까?

2번의 쿼리가 필요
1. SMITH가 속한 부서의 번호를 확인하는 쿼리
2. 1번에서 확인한 부서번호로 해당 부서에 속하는 사원들을 조회하는 쿼리

1.
SELECT deptno
  FROM emp
 WHERE ename = 'SMITH';

2.
SELECT *
  FROM emp
 WHERE deptno = 20;

SMITH가 현재 상황에서 속한 부서는 20번인데
나중에 30번 부서로 부서전배가 이뤄지면
2번에서 작성한 쿼리가 수정이 되야한다.
WHERE deptno = 20; ==> WHERE deptno = 30;

우리가 원하는 것은 고정된 부서번호로 사원 정보를 조회하는것이 아니라
SMITH가 속한 부서를 통해 데이터를 조회 ==> SMITH가 속한 부서가 바뀌더라도
쿼리를 수정하지 않도록 하는 것

위에서 작성한 두개의 쿼리를 하나로 합칠 수 있다
==> SMITH의 부서번호가 변경 되더라도 우리가 원하는 데이터 셋을 쿼리 수정 없이 조회할 수 있다
==> 코드 변경이 필요 없다 ==> 유지보수가 편하다

SELECT deptno
  FROM emp
 WHERE ename = 'SMITH';	-- ==> 20이라는 값
 
SELECT *
  FROM emp
 WHERE deptno = (SELECT deptno
				   FROM emp
				  WHERE ename = 'SMITH'); -- 괄호 안쪽이 서브쿼리(단독으로 실행 가능하여 비상호)
				  
스칼라 서브쿼리 : SELECT 절에서 사용된 서브쿼리
* 제약사항 : 반드시 서브쿼리가 하나의 행, 하나의 컬럼을 반환해야 된다.

스칼라 서브쿼리가 다중행 복수컬럼을 리턴하는 경우(X)
SELECT empno, ename, (SELECT deptno, dname FROM dept)
  FROM emp;

스칼라 서브쿼리가 단일행 복수컬럼을 리턴하는 경우(X)
SELECT empno, ename, (SELECT deptno, dname FROM dept WHERE deptno = 10)
  FROM emp;
 
스칼라 서브쿼리가 단일행, 단일컬럼을 리턴하는 겨우
SELECT empno, ename, (SELECT deptno FROM dept WHERE deptno = 10) deptno
  FROM emp;
 
메인쿼리의 컬럼을 사용하는 스칼라 서브쿼리
SELECT empno, ename, deptno,
		(SELECT dname FROM dept WHERE dept.deptno = emp.deptno) dname
  FROM emp
;

IN-LINE VIEW ==> paging 처리할 때 사용해봄

SUBQUERY : WHERE 절에서 사용 된 subquery

SMITH가 속한 부서에 속하는 사원들 조회
WHERE 절에서 서브쿼리 사용시 주의점

연산자와, 서브쿼리의 반환 행수 주의
 = 연산자를 사용시 서브쿼리에서 여러개 행(값)을 리턴하면 논리적으로 맞지가 않다
 IN 연산자를 사용시 서브쿼리에서 리턴하는 여러개의 행(값)과 비교가 가능
 
SMITH 20, ALLEN 30
SELECT *
  FROM emp
 WHERE deptno = (SELECT deptno
 				   FROM emp
 				  WHERE ename IN ('SMITH', 'ALLEN'));
 				  
SELECT *
  FROM emp
 WHERE deptno IN (SELECT deptno
 				   FROM emp
 				  WHERE ename IN ('SMITH', 'ALLEN'));
 				  
-- 실습1
SELECT *
  FROM emp
 WHERE sal > (SELECT ROUND(AVG(sal), 2) avg_sal 
  			    FROM emp)
;

-- 예제1
사원이 속한 부서의 급여 평균보다 높은 급여를 받는 사원 정보를 조회
SELECT *
  FROM emp a
 WHERE sal > (SELECT AVG(sal)
			    FROM emp b
			   WHERE a.deptno = b.deptno);
				-- 실습1과의 차이점은 서브쿼리가 메인쿼리의 테이블을 참조하는 건지 아닌지 차이

  