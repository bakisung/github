SELF-JOIN : 동일한 테이블끼리 조인할때 지칭하는 명칭(별도의 키워드가 아니다);

SELECT 사원번호, 사원이름, 사원의 상사 사원번호, 사원의 상사 이름
FROM emp;

--oracle 방법
SELECT a.empno, a.ename, a.mgr, b.ename
FROM emp a, emp b
WHERE a.mgr = b.empno; 

-- KING의 경우 상사가 없기 때문에 조인에 실패한다.
-- 따라서 총 행의 수는 13건이 조회된다.

--ansi 방법
SELECT e.EMPNO , e.ename, e.mgr, m.ENAME 
FROM emp e JOIN emp m ON e.mgr = m.empno;

-- 사원중 사원의 번호가 7369 ~ 7698인 사원만 대상으로 해당 사원의 사원번호, 이름. 상사의 사원번호, 상사의 이름 조회
--ansi
SELECT e.empno, e.ENAME, e.mgr, m.ENAME 
FROM emp e JOIN emp m ON (e.mgr = m.EMPNO)
WHERE e.empno BETWEEN 7369 AND 7698;
--oracle
SELECT e.empno, e.ename, e.mgr, m.ename
FROM emp e, emp m
WHERE e.mgr = m.empno
AND e.empno BETWEEN 7369 AND 7698;

non-equi-JOIN : 조인 조건이 = 이 아닌 조인

SELECT *
FROM SALGRADE;

SELECT empno, ename, sal, salgrade.grade
FROM emp, SALGRADE
WHERE emp.SAL BETWEEN salgrade.losal AND salgrade.hisal;

SELECT e.empno, e.ename, e.deptno, d.DNAME 
FROM emp e, dept d
WHERE e.DEPTNO = d.DEPTNO ;

SELECT *
FROM emp;
SELECT *
FROM dept;

--실습2
SELECT e.EMPNO, e.ENAME, d.DEPTNO, d.DNAME 
FROM emp e, dept d
WHERE e.DEPTNO = d.DEPTNO
AND empno BETWEEN 7499 AND 7934
AND d.DEPTNO != 20; 

--실습 3
SELECT empno, ename, sal, d.DEPTNO, dname
FROM emp e, dept d
WHERE e.DEPTNO = d.DEPTNO
AND sal BETWEEN 2850 AND 5000
;

--실습4
SELECT empno, ename, sal, e.deptno, dname
FROM emp e, dept d
WHERE e.DEPTNO = d.DEPTNO
AND SAL >= 2850
AND empno >= 7698
ORDER BY empno;

--실습5
SELECT empno, ename, sal, e.deptno, dname
FROM emp e, dept d
WHERE e.DEPTNO = d.DEPTNO
AND e.sal = 3000
AND e.deptno = 20
;

--실습6
SELECT *
FROM prod;
SELECT *
FROM lprod;

SELECT l.lprod_gu, l.lprod_nm, p.PROD_ID, p.PROD_NAME
FROM prod p, lprod l
WHERE p.PROD_LGU = l.LPROD_GU
;

--실습7
select *
FROM buyer;
select *
from prod;

select b.buyer_id, b.buyer_name, p.prod_id, p.prod_name
FROM buyer b, prod p
where b.buyer_id = p.prod_buyer 
;

--실습8
select *
from MEMBER;
select *
FROM cart;
select *
FROM prod;

select m.mem_id, m.mem_name, p.prod_id, p.prod_name, c.cart_qty
FROM MEMBER m, cart c, prod p
where m.mem_id = c.cart_member AND c.cart_prod = p.prod_id
order BY m.mem_id
;

--실습9
select *
FROM customer;
select *
FROM CYCLE;

select cu.cid, cu.cnm, cy.pid, cy.DAY, cy.cnt
from customer cu, CYCLE cy
where cu.cid = cy.cid
AND cu.cnm in ('brown', 'sally')
;

--실습10
select *
FROM customer;
select *
FROM CYCLE;
select *
FROM product;

select cu.cid, cu.cnm, pr.pid, pr.pnm, cy.DAY, cy.cnt
FROM customer cu, CYCLE cy, product pr
where cu.cid = cy.cid
AND cy.pid = pr.pid
AND cu.cnm in ('sally', 'brown')
ORDER BY cy.pid, cu.cnm desc
;

--실습11
select cs.cid, cs.cnm, pr.pid, pr.pnm, sum(cnt)
FROM customer cs, CYCLE cc, product pr
where cs.cid = cc.cid
AND cc.pid = pr.pid
group BY cs.cnm, pr.pid, cs.cid, pr.pnm
;