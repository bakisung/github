SELECT deptno
  FROM emp
 GROUP BY deptno;
 
SELECT DISTINCT deptno
  FROM emp;
  
[ 계층형 쿼리 ]

계층형 쿼리?
 - 한 테이블에 담겨 있는 여러 레코드들이 서로 상하 관계(부모, 자식) 관계를 이루며 존재할 때, 이 관계에 따라 레코드를
   hirearchical(상하위) 한 구조로 가져올 때 사용되는 SQL을 의미한다.
 - 쉽게 생각하면 조직도, 메일함, 문서함 등을 예로 들 수 있다.
 
이러한 구조의 테이블을 상하위 구조의 일목요연한 레코드로 SELECT 할 때 사용하는것이 오라클의 
START WITH ~ CONNECT BY 구문이다.

START WITH 
 - 계층 질의의 루트(부모행)로 사용될 행을 지정한다.
 - 서브 쿼리를 사용할 수도 있다.
 - START WITH 구문에서는 어떤 레코드를 최상위 레코드로 잡을지 지정한다.

CONNECT BY 
 - 이 절을 이용하여 계층 질의에서 상위계층(부모행)과 하위계층(자식행)의 관계를 규정할 수 있다.
 - PRIOR 연산자와 함께 사용하여 계층구조로 표현할 수 있다.
   지정된 최상위 루트 ROW 와 연관된 레코드(부모 혹은 자식)를 어떻게 전개해 나갈 것인가?
   상위(부모) 방향으로, 하위(자식) 방향으로?
   방향은 'PRIOR'가 어디에 지정되어 있냐에 따라 달라지는데, PRIOR 가 없는 곳에서 PRIOR 가 있는 곳으로 전개된다.
 - CONNECT BY PRIOR 자식컬럼 = 부모컬럼 : 부모에서 자식으로 트리 구성(Top Down)
 - CONNECT BY PRIOR 부모컬럼 = 자식컬럼 : 자식에서 부모로 트리 구성(Bottom Up)
 - CONNECT BY NOCYCLE PRIOR : NOCYCLE 파라미터를 이용하여 무한 루프 방지

LEVEL Pseudocolumn
 - LEVEL 은 계층구조 쿼리에서 수행 결과의 DEPTH 를 표현하는 의사컬럼이다.
 - 의사컬럼이란, '가짜 컬럼'을 의미한다. 즉, 테이블 생성 시에 DBA나 생성자가 별도로 정의한 컬럼이 아니다.
   단순하게 레코드들이 최상의 레코드로부터 몇 단계 깊이에 있는지를 참고하는 용도로만 사용된다.

;

SELECT *
FROM users;

SELECT LPAD(' ', 4)
  FROM dual;

SELECT LPAD(' ', (LEVEL - 1)*4) || ename ename, level
  FROM emp
 START WITH ename = 'KING'
CONNECT BY PRIOR empno = mgr;

-- 계층형쿼리 실습1
SELECT LPAD(' ', (LEVEL - 1)*5) || deptnm deptnm
  FROM dept_h
 START WITH deptnm = 'XX회사'
 CONNECT BY PRIOR deptcd = p_deptcd;

SELECT *
  FROM h_sum;
 
-- 계층형쿼리 실습2
SELECT LPAD(' ', (LEVEL - 1)*4) || s_id s_id, value
  FROM h_sum
 START WITH s_id = '0'
 CONNECT BY PRIOR s_id = ps_id;

CONNECT BY 의 실행 순서는 다음과 같다.
1. START WITH 절
2. CONNECT BY 절
3. WHERE 절 

SELECT LPAD(' ', (LEVEL - 1)*5) || deptnm deptnm
  FROM dept_h
 START WITH deptnm = 'XX회사'
 CONNECT BY PRIOR deptcd = p_deptcd AND deptnm != '정보기획부';

SELECT LPAD(' ', (LEVEL - 1)*5) || deptnm deptnm
  FROM dept_h
 WHERE deptnm != '정보기획부'
 START WITH deptnm = 'XX회사'
 CONNECT BY PRIOR deptcd = p_deptcd;
 

iw : 월요일을 기준으로 한 주차
ww : 일요일을 기준으로 한 주차

[ 2023년 5월의 달력 구하기 ];
SELECT  TO_DATE(:yyyymm, 'YYYYMM') + (LEVEL - 1) dt
	   ,TO_CHAR(TO_DATE(:yyyymm, 'YYYYMM') + (LEVEL - 1), 'D') d
	   ,TO_CHAR(TO_DATE(:yyyymm, 'YYYYMM') + (LEVEL - 1), 'WW') ww
	   ,LEVEL 
  FROM dual
 CONNECT BY LEVEL <= TO_CHAR(LAST_DAY(TO_DATE(:yyyymm, 'YYYYMM')), 'DD');


SELECT  deptno
	  , decode(job, 'SALESMAN', sal, null)
	  , decode(job, 'MANAGER', sal, null)
	  , decode(job, 'CLERK', sal, null)
	  , decode(job, 'PRESIDENT', sal, null)
	  , decode(job, 'ANALYST', sal, null)
  FROM emp
 ORDER BY deptno;
 
SELECT DISTINCT job
 FROM emp;

SELECT --iw,
       DECODE(d, 1, dt) sun, DECODE(d, 2, dt) mon,
       DECODE(d, 3, dt) tue, DECODE(d, 4, dt) wed,
       DECODE(d, 5, dt) thu, DECODE(d, 6, dt) fri,
       DECODE(d, 7, dt) sat
FROM
(SELECT TO_DATE('201905', 'YYYYMM') + (level - 1) dt,
       TO_CHAR(TO_DATE('201905', 'YYYYMM') + (level - 1), 'D') d,
       TO_CHAR(TO_DATE('201905', 'YYYYMM') + (level - 1), 'IW') iw
       
FROM dual
CONNECT BY LEVEL <= TO_CHAR(LAST_DAY(TO_DATE('201905', 'YYYYMM')), 'DD'))
GROUP BY decode();