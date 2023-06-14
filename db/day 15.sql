[ GROUP FUNCTION 응용, 확장 ];
SELECT deptno, SUM(sal)
  FROM emp
 GROUP BY deptno
UNION
SELECT NULL, SUM(sal)
  FROM emp
 ORDER BY deptno DESC NULLS LAST;
 

ROLLUP - 1. GROUP BY 의 확장 구문
		 2. 정해진 규칙으로 서브 그룹을 생성하고 생성된 서브 그룹을 하나의 집합으로 반환
		 3. GROUP BY ROLLUP(col1, col2, ...)
		 4. ROLLUP 절에 기술된 컬럼을 오른쪽에서부터 하나씩 제거해 가며 서브그룹을 생성
		 	ROLLUP 의 경우 방향성이 있기 때문에 컬럼 기술 순서가 다르면 다른 결과가 나온다.
		 	
예시 - GROUP BY ROLLUP (deptno)
1. GROUP BY deptno ==> 부서번호별 총계
2. GROUP BY ''	==> 전체 총계

예시 - GROUP BY ROLLUP (job, deptno)
1. GROUP BY job, deptno ==> 담당업무, 부서번호별 총계
2. GROUP BY job		==> 담당업무별 총계
3. GROUP BY ''		==> 전체 총계

SELECT job, deptno, SUM(sal + NVL(comm, 0)) sal
  FROM emp
 GROUP BY ROLLUP (job, deptno);

* ROLLUP 절에 N개의 컬럼을 기술 했을 때 SUBGROUP 의 개수는 N + 1 개의 서브 그룹이 생성
 

GROUPING 함수
GROUPING(column) 

job 컬럼이 소계 계산으로 사용되어 NULL 값이 나온 것인지, 정말 컬럼의 값이 NULL 인 행들이
GROUP BY 된 것인지 알려면 GROUPING 함수를 사용해야 정확한 값을 할 수 있다.

SELECT NVL(job, '총계'), deptno, SUM(sal + NVL(comm, 0)) sal, GROUPING(job), GROUPING(deptno)
  FROM emp
 GROUP BY ROLLUP (job, deptno);
 
GROUPING(column) - 0, 1
0 - 컬럼이 소계 계산에 사용 되지 않았다. (GROUP BY 컬럼으로 사용됨)
1 - 컬럼이 소계 계산에 사용 되었다.

SELECT DECODE(GROUPING(job), 1, '총계', job) job, deptno, 
	   GROUPING(job), GROUPING(deptno), SUM(sal + NVL(comm, 0)) sal
  FROM emp
 GROUP BY ROLLUP (job, deptno);

-- 실습1
SELECT DECODE(GROUPING(job), 1, '총', job) job,
	   DECODE(GROUPING(deptno), 1, DECODE(GROUPING(job), 1, '계', '소계'), deptno) deptno,  
	   GROUPING(job), GROUPING(deptno), SUM(sal + NVL(comm, 0)) sal
  FROM emp
 GROUP BY ROLLUP (job, deptno);

SELECT DECODE(GROUPING(job), 1, '총', job) job,
	   DECODE(GROUPING(job) + GROUPING(deptno), 2, '계', 1, '소계', TO_CHAR(deptno)) deptno,  
	   GROUPING(job), GROUPING(deptno), SUM(sal + NVL(comm, 0)) sal
  FROM emp
 GROUP BY ROLLUP (job, deptno);

SELECT CASE
			WHEN GROUPING(job) = 1 THEN '총'
			WHEN GROUPING(job) = 0 THEN job
		END job,
	   CASE 
		    WHEN GROUPING(job) = 1 AND GROUPING(deptno) = 1 THEN '계'
		    WHEN GROUPING(job) = 0 AND GROUPING(deptno) = 1 THEN '소계'
		    WHEN GROUPING(job) = 0 AND GROUPING(deptno) = 0 THEN TO_CHAR(deptno)
		END deptno,
	   GROUPING(job), GROUPING(deptno), SUM(sal + NVL(comm, 0)) sal
  FROM emp
 GROUP BY ROLLUP (job, deptno);

-- 실습2
SELECT deptno, job, SUM(sal + NVL(comm, 0)) sal
  FROM emp
 GROUP BY ROLLUP (deptno, job);

-- 실습3
SELECT dname, job, SUM(sal + NVL(comm, 0)) sal
  FROM emp e, dept d
 WHERE e.deptno = d.deptno
 GROUP BY ROLLUP (dname, job)
 ORDER BY dname, job DESC;

-----------------------------------------------------------------------------------------

확장된 GROUP BY 
1. ROLLUP - 컬럼 기술에 방향성이 존재
	GROUP BY ROLLUP (job, deptno) != GROUP BY ROLLUP (deptno, job)
	GROUP BY job, deptno			 GROUP BY deptno, job
	GROUP BY job					 GROUP BY deptno
	GROUP BY ''						 GROUP BY ''
	단점 - 개발자가 필요가 없는 서브그룹을 임의로 제거할 수 없다.
	
2. GROUPING SETS - 필요한 서브그룹을 임의로 지정하는 형태
	==> 복수의 GROUP BY 를 하나도 합쳐서 결과를 돌려주는 형태
	GROUP BY GROUPING SETS (col1, col2)
	
	GROUP BY col1
	UNION ALL
	GROUP BY col2
	
	GROUP BY GROUPING SETS (col2, col1)
	
	GROUP BY col2
	UNION ALL
	GROUP BY col1
	
	GROUPING SETS 의 경우 ROLLUP 과는 다르게 컬럼 나열순서가 데이터 자체에 영향을 미치지 않는다.
	
	복수 컬럼으로 GROUP BY 
	GROUP BY col1, col2
	UNION ALL 
	GROUP BY col1
	==> GROUPING SETS ((col1, col2), col1)
	
GROUPING SETS 실습

SELECT job, deptno, SUM(sal + NVL(comm, 0)) sal
  FROM emp
 GROUP BY GROUPING SETS (job, deptno);

위 쿼리를 UNION ALL 로 풀어 쓰기

SELECT job, NULL, SUM(sal + NVL(comm, 0)) sal
  FROM emp
 GROUP BY job
 
 UNION ALL
 
SELECT NULL, deptno, SUM(sal + NVL(comm, 0)) sal
  FROM emp
 GROUP BY deptno;
 
3. CUBE
GROUP BY 절을 확장한 구문
CUBE 절에 나열한 모든 가능한 조합으로 서브그룹을 생성
GROUP BY CUBE (job, deptno)

GROUP BY job, deptno
GROUP BY job
GROUP BY 	  deptno
GROUP BY ''

SELECT job, deptno, GROUPING(job), GROUPING(deptno), SUM(sal + NVL(comm, 0)) sal
  FROM emp
 GROUP BY CUBE (job, deptno);

SELECT job, SUM(sal + NVL(comm, 0)) sal
  FROM emp
 GROUP BY ROLLUP (job);

CUBE 의 경우 기술한 컬럼으로 모든 가능한 조합으로 서브그룹을 생성한다.
가능한 서브그룹은 2^기술한컬럼개수
기술한 컬럼이 3개만 넘어도 생성되는 서브그룹의 개수가 8개가 넘기 때문에 실제 필요하지 않은 서브그룹이 
포함될 가능성이 높다 ==> ROLLUP, GROUPING SETS 보다 활용성이 떨어진다.

GROUP BY ROLLUP (job, deptno, mgr)
GROUP BY CUBE   (job, deptno, mgr)
