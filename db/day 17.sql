SELECT ww,
	   MIN(DECODE(d, 1, dt, NULL)) sun, MIN(DECODE(d, 2, dt, NULL)) mon,
	   MIN(DECODE(d, 3, dt, NULL)) tue, MIN(DECODE(d, 4, dt, NULL)) wed,
	   MIN(DECODE(d, 5, dt, NULL)) thu, MIN(DECODE(d, 6, dt, NULL)) fri,
	   MIN(DECODE(d, 7, dt, NULL)) sat
  FROM (
  			SELECT TO_DATE(:yyyymm, 'YYYYMM') + (LEVEL - 1) - (6 - (7 - TO_CHAR(TO_DATE(:yyyymm, 'YYYYMM'), 'D'))) dt,
				   TO_CHAR(TO_DATE(:yyyymm, 'YYYYMM') + (LEVEL - 1) - (6 - (7 - TO_CHAR(TO_DATE(:yyyymm, 'YYYYMM'), 'D'))), 'D') d,
				   TO_CHAR(TO_DATE(:yyyymm, 'YYYYMM') + (LEVEL - 1) - (6 - (7 - TO_CHAR(TO_DATE(:yyyymm, 'YYYYMM'), 'D'))), 'WW') ww, level
			  FROM dual
			CONNECT BY LEVEL <=   TO_CHAR(LAST_DAY(TO_DATE(:yyyymm, 'YYYYMM')), 'DD')
								+ (7 - TO_CHAR(LAST_DAY(TO_DATE(:yyyymm, 'YYYYMM')), 'D'))
								+ (6 - (7 - TO_CHAR(TO_DATE(:yyyymm, 'YYYYMM'), 'D')))
  		) calendar
 GROUP BY ww
 ORDER BY ww
;

SELECT MIN(DECODE(d, 1, dt, NULL)) sun, MIN(DECODE(d, 2, dt, NULL)) mon,
	   MIN(DECODE(d, 3, dt, NULL)) tue, MIN(DECODE(d, 4, dt, NULL)) wed,
	   MIN(DECODE(d, 5, dt, NULL)) thu, MIN(DECODE(d, 6, dt, NULL)) fri,
	   MIN(DECODE(d, 7, dt, NULL)) sat
  FROM (
  			SELECT DECODE(TO_CHAR(TO_DATE(:yyyymm, 'YYYYMM'), 'D'), 1, TO_DATE(:yyyymm, 'YYYYMM'), NEXT_DAY(LAST_DAY(TO_DATE(:yyyymm, 'YYYYMM') - 1) - 7, 1)) + (LEVEL - 1) dt,
				   TO_CHAR(DECODE(TO_CHAR(TO_DATE(:yyyymm, 'YYYYMM'), 'D'), 1, TO_DATE(:yyyymm, 'YYYYMM'), NEXT_DAY(LAST_DAY(TO_DATE(:yyyymm, 'YYYYMM') - 1) - 7, 1)) + (LEVEL - 1), 'D') d,
				   TO_CHAR(DECODE(TO_CHAR(TO_DATE(:yyyymm, 'YYYYMM'), 'D'), 1, TO_DATE(:yyyymm, 'YYYYMM'), NEXT_DAY(LAST_DAY(TO_DATE(:yyyymm, 'YYYYMM') - 1) - 7, 1)) + (LEVEL - 1), 'IW') iw, level
			  FROM dual
			CONNECT BY LEVEL <= DECODE(TO_CHAR(LAST_DAY(TO_DATE(:yyyymm, 'YYYYMM')), 'D'), 7, LAST_DAY(TO_DATE(:yyyymm, 'YYYYMM')), NEXT_DAY(LAST_DAY(TO_DATE(:yyyymm, 'YYYYMM')), 7))
							  - DECODE(TO_CHAR(TO_DATE(:yyyymm, 'YYYYMM'), 'D'), 1, TO_DATE(:yyyymm, 'YYYYMM'), NEXT_DAY(LAST_DAY(TO_DATE(:yyyymm, 'YYYYMM') - 1) - 7, 1)) + 1
  		) calendar
 GROUP BY DECODE(d, 1, DECODE(iw, 52, 1, 53, 1, iw + 1), iw)
 ORDER BY sat
;

SELECT DECODE(d, 1, DECODE(TO_CHAR(TO_DATE(:yyyymm, 'YYYYMM'), 'MM'), '01', DECODE(iw, 52, 1, 53, 1, iw + 1), iw + 1), DECODE(iw, 52, 1, 53, 1, iw + 1)),
	   DECODE(d, 1, dt, NULL) sun, DECODE(d, 2, dt, NULL) mon,
	   DECODE(d, 3, dt, NULL) tue, DECODE(d, 4, dt, NULL) wed,
	   DECODE(d, 5, dt, NULL) thu, DECODE(d, 6, dt, NULL) fri,
	   DECODE(d, 7, dt, NULL) sat
  FROM (
  			SELECT DECODE(TO_CHAR(TO_DATE(:yyyymm, 'YYYYMM'), 'D'), 1, TO_DATE(:yyyymm, 'YYYYMM'), NEXT_DAY(LAST_DAY(TO_DATE(:yyyymm, 'YYYYMM') - 1) - 7, 1)) + (LEVEL - 1) dt,
				   TO_CHAR(DECODE(TO_CHAR(TO_DATE(:yyyymm, 'YYYYMM'), 'D'), 1, TO_DATE(:yyyymm, 'YYYYMM'), NEXT_DAY(LAST_DAY(TO_DATE(:yyyymm, 'YYYYMM') - 1) - 7, 1)) + (LEVEL - 1), 'D') d,
				   TO_CHAR(DECODE(TO_CHAR(TO_DATE(:yyyymm, 'YYYYMM'), 'D'), 1, TO_DATE(:yyyymm, 'YYYYMM'), NEXT_DAY(LAST_DAY(TO_DATE(:yyyymm, 'YYYYMM') - 1) - 7, 1)) + (LEVEL - 1), 'IW') iw, level
			  FROM dual
			CONNECT BY LEVEL <= DECODE(TO_CHAR(LAST_DAY(TO_DATE(:yyyymm, 'YYYYMM')), 'D'), 7, LAST_DAY(TO_DATE(:yyyymm, 'YYYYMM')), NEXT_DAY(LAST_DAY(TO_DATE(:yyyymm, 'YYYYMM')), 7))
							  - DECODE(TO_CHAR(TO_DATE(:yyyymm, 'YYYYMM'), 'D'), 1, TO_DATE(:yyyymm, 'YYYYMM'), NEXT_DAY(LAST_DAY(TO_DATE(:yyyymm, 'YYYYMM') - 1) - 7, 1)) + 1
  		) calendar
 --GROUP BY DECODE(d, 1, DECODE(TO_CHAR(TO_DATE(:yyyymm, 'YYYYMM'), 'MM'), '01', DECODE(iw, 52, 1, 53, 1, iw + 1), iw + 1), iw)
 ORDER BY sat
;

SELECT TO_DATE(:yyyymmdd1, 'YYYYMMDD') - TO_DATE(:yyyymmdd2, 'YYYYMMDD')
  FROM dual;
  
SELECT 7 - TO_CHAR(LAST_DAY(TO_DATE(:yyyymm, 'YYYYMM')), 'D')
  FROM dual;
  
 
------------------------------------------------------------------------------
 
계층쿼리의 SELECT 쿼리의 실행순서 FROM -> START WITH, CONNECT BY -> WHERE
일반쿼리의 SELECT 쿼리의 실행순서 FROM -> WHERE -> SELECT -> (GROUP BY) -> ORDER BY

계층쿼리에서 조회할 행의 조건을 기술할 수 있는 부분이 2곳 존재
1. WHERE - START WITH, CONNECT BY 에 의해 조회된 행을 대상으로 적용
2. CONNECT BY - 다음 행으로 연결할지, 말지를 결정

SELECT LPAD(' ', (LEVEL - 1) * 4) || deptnm deptnm
  FROM dept_h
 START WITH deptcd = 'dept0'
 CONNECT BY PRIOR deptcd = p_deptcd AND deptnm != '정보기획부'
;

SELECT LPAD(' ', (LEVEL - 1) * 4) || deptnm deptnm
  FROM dept_h
 WHERE deptnm != '정보기획부'
 START WITH deptcd = 'dept0'
 CONNECT BY PRIOR deptcd = p_deptcd
;

------------------------------------------------------------------------------

[ 계층쿼리에서 사용할 수 있는 특수함수 ]

CONNECT_BY_ROOT(col) - 최상위 행의 'col' 컬럼의 값
SYS_CONNECT_BY_PATH(col, 구분자) - 계층의 순회경로를 표현(각 계층을 지나면서 어떤 컬럼을 지나 왔는지)
CONNECT_BY_ISLEAF - 해당 행이 LEAF 노드(1)인지 아닌지(0)를 반환(최 하단 노드인지 아닌지를 구별해서 알려준다)

SELECT deptcd, p_deptcd, LPAD(' ', (LEVEL - 1) * 4) || deptnm deptnm,
	   CONNECT_BY_ROOT(deptnm),
	   LTRIM(SYS_CONNECT_BY_PATH(deptnm, '-'), '-'),
	   CONNECT_BY_ISLEAF
  FROM dept_h
 START WITH deptcd = 'dept0'
 CONNECT BY PRIOR deptcd = p_deptcd
;

SELECT seq, LPAD(' ', (LEVEL - 1)*4) || title title
  FROM board_test
 START WITH parent_seq IS NULL
 CONNECT BY PRIOR seq = parent_seq;

SELECT seq, LPAD(' ', (LEVEL - 1)*4) || title title
  FROM board_test
 START WITH parent_seq IS NULL
 CONNECT BY PRIOR seq = parent_seq
 ORDER BY seq DESC;
 
