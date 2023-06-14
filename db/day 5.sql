-- sal를 1000으로 나누었을때의 나머지 ==> mod 함수, 별도의 연산자는 없다.
-- 몫 : quotient, 나머지 : remainder
SELECT ename, TRUNC(sal/1000, 0) quotient, MOD(sal, 1000) remainder
FROM emp
;

-- 날짜 관련 함수
-- sysdate 	: 오라클에서 제공해주는 특수함수
--			1. 인자가 없음
--			2. 오라클이 설치된 서버의 현재 년, 월, 일, 시, 분, 초 정보를 반환해주는 함수

SELECT SYSDATE 
FROM dual;

-- 날짜타입 +- 정수 : 정수를 일자 취급, 정수만큼 미래, 혹은 과거 날짜의 데이트 값을 반환
-- ex : 오늘 날짜에서 하루 더한 미래 날짜 값은?
SELECT sysdate + 1
FROM dual;

-- 현재 날짜에서 3시간 뒤 데이트를 구하면?
SELECT SYSDATE + 0.125 -- 3/24
FROM dual;

-- 1분 : 1/24/60
-- 30분 : 30/24/60
SELECT sysdate + 30/24/60
FROM dual;

-- 데이트 표현하는 방법
-- 1. 데이트 리터럴 : NLS_SESSION_PARAMETER 설정에 따르기 때문에 DBMS 환경마다 다르게 인식될 수 있음
-- 2. TO_DATE : 문자열을 날짜로 변경해주는 함수

-- 실습1
-- 1. 2023년 12월 31일을 date 형으로 표현
-- 2. 2023년 12월 31일을 date 형으로 표현하고 5 일 이전 날짜로
-- 3. 현재 날짜
-- 4. 현재 날짜에서 3일 이전 값
SELECT TO_DATE('2023/12/31', 'yyyy/mm/dd'), TO_DATE('2023/12/31', 'yyyy/mm/dd') - 5, sysdate now, sysdate - 3 now_before  
FROM dual;

-- 문자열 ==> 데이트
-- TO_DATE(날짜 문자열, 날짜 문자열의 패턴);
-- 데이트 ==> 문자열(보여주고 싶은 형식을 지정할 때)
-- TO_CHAR(데이트 값, 표현하고싶은 문자열 패턴)
-- TO_DATE를 더 많이 사용한다.(SYSDATE 리터럴을 사용하면 오류가 발생할 수 있음.)
-- ==> 날짜와 날짜를 비교해야 하기 때문이다.

-- SYSDATE 현재 날짜는 년도4자리-월2자리-일2자리
SELECT 	sysdate now, TO_CHAR(sysdate, 'yyyy-mm-dd') now_format
		,TO_CHAR(sysdate, 'D') 요일인덱스번호
		,TO_CHAR(SYSDATE, 'day') 요일한글표시
		,TO_CHAR(SYSDATE, 'dy') 요일한글표시의앞자리
		,TO_CHAR(SYSDATE, 'iw') "실제 달력에 맞춘 주차"
		,TO_CHAR(SYSDATE, 'ww') -- 1일에서 7일까지가 1주차로 시작되는 주차
		,TO_CHAR(sysdate, 'w') -- 매월 1일 요일을 기준으로 한 주차
from dual;

SELECT 	ename, hiredate, TO_CHAR(hiredate, 'yyyy/mm/dd HH24:MI:SS') h1
		,TO_CHAR(HIREDATE + 1, 'yyyy/mm/dd HH24:MI:SS') h2
		,TO_CHAR(HIREDATE + 1/24, 'yyyy/mm/dd HH24:MI:SS') h3
FROM emp;

-- 실습2 오늘 날짜를 다음과 같은 포맷으로 조회하는 쿼리를 작성하세요.
-- 1. 년-월-일
-- 2. 년-월-일 시간24-분-초
-- 3. 일-월-년

SELECT 	TO_DATE(SYSDATE, 'yyyy-mm-dd') asdf
		,TO_DATE(SYSDATE, 'yyyy-mm-dd HH24-mi-ss') fdsa
		,TO_DATE(SYSDATE, 'dd-mm-yyyy') qwer
FROM dual;

-- 날짜관련 오라클 내장함수
-- 내장함수 : 탑재가 되어있음. 오라클에서 제공해주는 함수(많이 사용하니까, 개발자가 별도로 개발하지 않도록)

-- MONTHS_BETWWN(date1, date2) : 두 날짜 사이의 개월수를 반환(일수가 다르면 소수점으로 계산된다.)
-- ADD_MONTHS(date1, NUMBER) : date1 날짜에 NUMBER 만큼의 개월수를 더하고. 뺀 날짜를 리턴
-- NEXT_DAY(date1, 주간요일(1~7) : date1 이후에 등장하는 첫번째 주간요일의 날짜를 반환
-- LAST_DAY(date1) : date1 날짜가 속한 월의 마지막 날짜를 반환 

-- MONTHS_BETWEEN
SELECT 	ename, TO_CHAR(hiredate, 'yyyy-mm-dd') hiredate,
		MONTHS_BETWEEN(sysdate, hiredate)
FROM emp;

-- ADD_MONTHS
SELECT 	ADD_MONTHS(SYSDATE, 5) aft5,
		ADD_MONTHS(SYSDATE, -5) bef5
FROM dual;

-- NEXT_DAY : 해당 날짜 이후에 등장하는 첫번째 주간요일의 날짜
SELECT NEXT_DAY(SYSDATE, 7)
FROM dual;

-- LAST_DAY : 해당 일자가 속한 월의 마지막 일자를 반환
SELECT LAST_DAY(SYSDATE)
FROM dual;

-- 실습3
-- 파라미터로 YYYYMM형식의 문자열을 받아서 (ex : YYYYMM = 202304) 해당 년월에 해당하는 날자 수를 구해보세요.
SELECT '202304' param, TO_CHAR(LAST_DAY(TO_DATE('202304', 'YYYYMM')), 'DD') DD  
FROM dual;

SELECT :param param, TO_CHAR(LAST_DAY(TO_DATE(:param, 'YYYYMM')), 'DD') DD  
FROM dual;

-- 숫자 포맷팅
-- 6,000,000 <==> 6000000
-- 날짜 => 국가별로 형식이 다르다.
--		한국 : yyyy-mm-dd
--		미국 : mm-dd-yyyy

-- 숫자
--		한국 : 9,000,000.00
--		독일 : 9.000.000,00

-- sal(NUMBER) 컬럼의 값을 문자열 포맷팅 적용
SELECT ename, sal, TO_CHAR(sal, 'L9,999') fm_sal
FROM emp;

SELECT TO_CHAR(0.40, 'FM9990.99')
FROM dual;
-- FM9990,99의 의미
-- 9는 해당 자리의 숫자를 의미하고 값이 없을 경우 소수점 이상은 공백으로, 소수점 이하는 0으로 표시한다.
-- 0은 해당자리의 숫자를 의미하고 값이 없을 경우 0으로 표시하며 숫자의 길이를 고정적으로 표시할때 주로 사용한다.
-- FM은 좌우 9로 치환된 소수점 이상의 공백 및 소수점 이하의 0을 제거한다.

-- FM : 반환값의 앞쪽이나 뒷쪽에 있는 공백을 제거한다.
-- L : 반환 값의 로컬 통화 기호 위치를 지정한다.

-- NULL과 관련된 함수 : NULL 값을 다른값으로 치환하거나, 혹은 강제로 NULL을 만드는것
-- 1. NVL(exprt1, expr2)
--		if(expr1 == null)
--			expr2를 반환
--		else
--			expr1을 반환
SELECT empno, sal, comm, NVL(comm, 0),sal + comm , sal + NVL(comm, 0) 
FROM emp;

-- 2. NVL2(expr1, expr2, expr3)
--		if(expr1 != null)
--			expr2를 반환
--		else
--			expr3을 반환
SELECT empno, sal, comm, NVL2(comm, comm, 0), sal + comm, sal + nvl2(comm, comm, 0) 
FROM emp;

-- 3. NULLIF(expr1, expr2) : NULL을 생성하는 목적
--		if(expr1 == expr2)
--			null을 반환
--		else
--			expr1을 반환
SELECT ename, sal, comm, NULLIF(sal, 3000)
FROM emp;

-- 4. COALESCE(expr1, expr2, ....) : 인자중에 가장 처음으로 null 값이 아닌 값을 갖는 인자를 반환
--		COALESCE(NULL, NULL, 30, NULL, 50) ==> 30
--		if(expr1 != null)
--			expr1을 반환
--		else
--			COALESCE(expr2, ...) ==> 재귀함수개념
SELECT COALESCE(NULL, NULL, 30, NULL, 50)
FROM dual;

-- NULL처리 실습
-- emp 테이블에 한명을 추가(INSERT)
INSERT INTO emp (empno, ename, HIREDATE) VALUES(9999, 'brown', NULL);

-- 조회컬럼 : 	ename, mgr, mgr컬럼 값이 NULL이면 11로 치환한값 - NULL이 아니면 mgr 컬럼값,
--			hiredate, hiredate가 NULL이면 SYSDATE로 표기 - NULL이 아니면 hiredate 컬럼값
SELECT ename, mgr, NVL2(mgr, mgr, 11) mgr2, HIREDATE,NVL2(HIREDATE, HIREDATE, SYSDATE)  
FROM emp;

-- 실습4
-- 위 실습내용에서 mgr 컬럼의 NULL 처리를 nvl2, coalesce를 사용하여 조회하는 쿼리를 작성해주세요.
SELECT empno, ename, mgr, NVL2(mgr, mgr, 111) mgr2, COALESCE(mgr, 111) mgr3
FROM emp;