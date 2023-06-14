SELECT * FROM emp;

-- 실습1
SELECT count(*)
FROM emp
WHERE sal >= 8000;

-- 실습2
SELECT count(*)
FROM emp
WHERE hiredate >= to_date('2007-01-01' ,'yyyy-MM-dd');

-- 실습3
SELECT sum(sal)
FROM emp;

-- 실습4 emp 테이블에서 job이 manager인 직원이 sal 합계와 평균을 조회
SELECT SUM(sal), AVG(sal)  
FROM emp
WHERE job = 'MANAGER'
;

-- 실습5 emp 테이블에서 deptno가 20~30 사이인 직원의 ename과 sal 그리고 sal의 평균값을 ename 정렬 기준으로 조회 (null 값은 0으로 출력)
SELECT ename, sal, AVG(COMM) OVER (ORDER BY ename)
FROM emp
WHERE DEPTNO BETWEEN 20 AND 30
;

-- 실습6
SELECT MIN(MAX(sal)), MAX(MAX(sal))  
FROM emp
GROUP BY sal;

-- 실습7


-- 실습8
SELECT department_id, job_id, avg(salary)
FROM employees
WHERE avg(salary) >= 12000
GROUP BY department_id, job_id
ORDER BY 
;