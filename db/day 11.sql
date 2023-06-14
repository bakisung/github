-- 실습2
SELECT *
  FROM emp
 WHERE deptno IN (SELECT deptno
				    FROM emp
				   WHERE ename IN ('SMITH', 'WARD'));	 

[ NULL 과 IN, NULL과 NOT IN ]
** IN, NOT IN 이용시 NULL 값의 존재 유무에 따라 원하지 않는 결과가 나올 수 있다.

WHERE mgr IN (7902, null)
==> mgr = 7902 OR mgr = NULL
==> mgr값이 7902 이거나 mgr 값이 null인 데이터
SELECT *
  FROM emp
 WHERE mgr IN (7902, null);

WHERE mgr NOT IN (7902, null)
==> NOT (mgr = 7902 OR mgr = null)
==> mgr != 7902 AND mgr != NULL
SELECT *
  FROM emp
 WHERE NOT (mgr = 7902 OR mgr = null);

[ pairwise, non-pairwise ]
한 행의 컬럼 값을 하나씩 비교하는 것 : non-pairwise
한 행의 복수 컬럼을 비교하는 것 : pairwise(다중컬럼 서브쿼리 라고도 한다.)

SELECT *
  FROM emp
 WHERE job IN ('MANAGER', 'CLERK');
 
SELECT *
  FROM emp
 WHERE (mgr, deptno) IN (SELECT mgr, deptno
 						   FROM emp
 						  WHERE empno IN (7499, 7782));
 
SELECT *
  FROM emp
 WHERE mgr IN (SELECT mgr
 			     FROM emp
 			    WHERE empno IN (7499, 7782))
   AND deptno IN (SELECT deptno
	 			    FROM emp
	 			   WHERE empno IN (7499, 7782));
 
-- 실습3
INSERT INTO dept VALUES (99, 'dw', 'daejeon');
SELECT *
  FROM dept
 WHERE deptno NOT IN (SELECT deptno
  						FROM emp
  					   WHERE deptno IS NOT NULL)
;

SELECT *
  FROM dept
 WHERE deptno NOT IN (SELECT deptno
  						FROM emp
  				   	   GROUP BY deptno
  				   	  HAVING deptno IS NOT NULL)
;

-- 실습4
SELECT *
  FROM product
 WHERE pid NOT IN (SELECT pid
					 FROM CYCLE
					WHERE cid = 1)		
;

-- 실습5
SELECT *
  FROM CYCLE
 WHERE pid IN (
				SELECT pid
				  FROM CYCLE
				 WHERE cid = 2
 				)
   AND cid = 1;
  
  
EXISTS 연산자 : 서브쿼리에서 반환하는 행이 존재하는지 체크하는 연산자
				서브쿼리에서 반환하는 행이 하나라도 존재하면 TRUE
				서브쿼리에서 반환하는 행이 존재하지 않으면 FALSE
특이점 : 1. WHERE 절에서 사용
	   2. MAIN 테이블의 컬럼이 항으로 사용되지 않음
	   3. 비상호연관 서브쿼리, 상호연관 서브쿼리 둘 다 사용 가능하지만 주로 상호연관 서브쿼리[확인자] 와 사용된다.
	   4. 서브쿼리의 컬럼값은 중요하지 않다. ==> 서브쿼리의 행이 존재하는지만 체크
	   									 그래서 관습적으로 SELECT 'X' 를 주로 사용

형태 : EXISTS (서브쿼리)

1. 아래쿼리에서 서브쿼리는 단독으로 실행 가능??
SELECT *
  FROM emp
 WHERE EXISTS (SELECT 'X' FROM dual);

일반적으로 EXISTS 연산자는 상호연관 서브쿼리에서 실행된다.
2. WHERE m.empno = e.mgr 조건을 만족하는 사원만 조회
==> 매니저(상사) 정보가 존재하는 사원 조회(13건)

SELECT *
  FROM emp e
 WHERE mgr IN (SELECT empno
 				 FROM emp m);
 				
SELECT *
  FROM emp e
 WHERE EXISTS (SELECT 'X'
 				 FROM emp m
 				WHERE e.mgr = m.empno);
 ==> 서브쿼리가 [확인자]로 사용되었다.
 	 비상호연관의 경우 서브쿼리가 먼저 실행될 수도 있다.
 	 ==> 서브쿼리가 [제공자]로 사용되었다.
 			
-- 매니저가 존재하는 사원 정보 조회, 단 서브쿼리를 사용하지 않고
SELECT *
  FROM emp
 WHERE mgr IS NOT NULL;

SELECT *
  FROM emp
 WHERE empno IN (SELECT mgr
 				   FROM emp
 				  WHERE mgr IS NOT NULL);

SELECT empno, ename, mgr, (SELECT ename FROM emp WHERE emp.empno = e.mgr) ename
  FROM emp e;
 
전체사원의 정보를 조회, 조인 없이 해당 사원이 속한 부서의 부서이름을 가져오기
SELECT empno, ename, deptno, (SELECT dname FROM dept WHERE deptno = emp.deptno) dname
  FROM emp;

-- 제품ID가 100 혹은 400이면서 cid = 1인 시음주기를 갖는 제품정보를 조회하세요.
SELECT *
  FROM product
 WHERE EXISTS (
 				SELECT 'X'
 				  FROM CYCLE
 				 WHERE cid = 1
 				   AND product.pid IN (100, 400)
 				)
;

EXISTS : 조건에 해당하는 ROW의 존재 유무와 체크 후 더 이상 수행하지 않음.
		 메인 쿼리의 결과값을 서브쿼리에 대입하여 조건 비교 후 결과를 출력한다.( 메인쿼리 -> EXISTS 쿼리 )
IN : 조건에 해당하는 ROW의 컬럼을 비교하여 체크한다.
	 서브쿼리의 결과값을 메인쿼리에 대입하여 조건 비교 후 결과를 출력한다.( IN쿼리 -> 메인쿼리 )

	 
집합연산
sql에서 데이터를 확장하는 방법
가로 확장(컬럼을 확장) : JOIN
세로 확장(행을 확장) : 집합연산
					집합연산을 하기 위해서는 연산에 참여하는 두개의 SQL(집합)이 동일한 컬럼 개수와 타입을 가져야한다.

수학시간에 배운 집합의 개념과 동일
집합의 특징 1. 순서가 없다
		 2. 요소의 중복이 없다
SQL에서 제공하는 집합 연산자
합집합 : UNION / UNION ALL
		두개의 집합을 하나로 합칠 때, 두 집합에 속하는 요소는 한 번만 표현된다
		{1, 2, 3,} U {1, 4, 5} ==> {1, 1, 2, 3, 4, 5} ==> {1, 2, 3, 4, 5}
UNION 과 UNION ALL 의 차이
UNION : 수학의 집합 연산과 동일
		위의 집합과 아래 집합에서 중복되는 데이터를 한 번 제거
		중복되는 데이터를 찾아야 함 ==> 연산이 필요, 속도가 느림
UNION ALL : 합집합의 정의와 다르게 중복을 허용
			위의 집합과 아래 집합의 행을 붙이는 행위만 실시
			중복을 찾는 과정이 없기 때문에 속도면에서 빠르다
			==> 개발자가 두 집합의 중복이 없다는 것을 알고 있으면 UNION 보다는 UNION ALL 을 사용하는게 좋다.
			
교집합 : INTERSECT 
		두개의 집합에서 서로 중복되는 요소만 별도의 집합으로 생성
		{1, 2, 3} 교집합 {1, 4, 5} ==> {1, 1} ==> {1}
		
차집합 : MINUS
		앞에 선언된 집합의 요소중 뒤에 선언된 집합의 요소를 제거하고 남은 요소로 새로운 집합을 생성
		{1, 2, 3} 차집합 {1, 4, 5} ==> {2, 3}

교환법칙 : 항의 위치를 수정해도 결과가 동일한 연산
		a + b, b + a
** 차집합의 경우 교환법칙이 성립되지 않음

UNION 연산자
집합연산을 하려는 두개의 컬럼의 수가 동일하고 중복을 허용하지 않는다.

SELECT empno, ename
  FROM emp
 WHERE empno IN (7566, 7698)

 UNION
 
SELECT empno, ename
  FROM emp
 WHERE empno IN (7566, 7698); 
 
UNION ALL : 중복을 허용한다. 위의 집합과 아래 집합을 단순히 합친다.

SELECT empno, ename
  FROM emp
 WHERE empno IN (7566, 7698)

 UNION ALL
 
SELECT empno, ename
  FROM emp
 WHERE empno IN (7566, 7698);
 
INTERSECT : 교집합, 두 집합에서 공통된 부분만 새로운 집합으로 생성;

SELECT empno, ename
  FROM emp
 WHERE empno IN (7369, 7566, 7499)

INTERSECT
 
SELECT empno, ename
  FROM emp
 WHERE empno IN (7566, 7698);

MINUS : 차집합 한 쪽 집합에서 다른쪽 집합을 뺀 것;

SELECT empno, ename
  FROM emp
 WHERE empno IN (7369, 7566, 7499)
 
 MINUS
 
SELECT empno, ename
  FROM emp
 WHERE empno IN (7566, 7698);

집합연산의 특징
1. 컬럼명이 동일하지 않아도 됨
   단, 조회 결과는 첫번째 집합의 컬럼을 따른다.
   
SELECT empno test, ename
  FROM emp
 WHERE empno IN (7566, 7698)

 UNION ALL
 
SELECT mgr, ename
  FROM emp
 WHERE empno IN (7566, 7698); 

2. 정렬이 필요한 경우 마지막 집합 뒤에다가 기술하면 된다.
3. UNION ALL 을 제외한 경우 중복제거 작업이 들어간다.
 
SELECT empno, ename
  FROM emp
 WHERE empno IN (7369, 7566, 7499)
 
 MINUS
 
SELECT empno, ename
  FROM emp
 WHERE empno IN (7566, 7698)
 ORDER BY empno;	-- ORDER BY는 마지막에 써준다.
 
SELECT 'test', 'test2'
  FROM dual
UNION
SELECT 'test3', 'test4'
  FROM dual;
 
WITH temp AS (
		SELECT emp.deptno edeptno, dept.deptno ddeptno
		  FROM emp, dept
	)
SELECT *
  FROM temp;
 
 SELECT *
 FROM dept;

SELECT *
FROM prod;
