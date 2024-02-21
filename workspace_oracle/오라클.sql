-- 줄의 끝까지 주석
select * from emp;
select * from dept;
select * from salgrade;

desc emp;


select empno, ename, deptno from emp;

select deprno from emp;
select distinct deptno from emp;
select distinct job from emp;

/*결과에서 중복되는 내용을 제외하고 조회 distinct*/
select distinct deptno, job
from 
emp;


/*별칭*/
/*sql은 쌍따옴표랑 홑따옴표를 정확히 구분해서 사용해야함
select 다음에는 쌍따옴표, 나머지는 홀따옴표
*/
select 
    sal, sal*12+comm as "new sal" 
from
    emp;
 
select * 
from emp
-- asc 오름차순
-- desc 내림차순
order by sal desc;

select *
    from emp
order by deptno asc, sal desc;

select * 
 from emp
order by ename asc;

select distinct job from emp
order by job asc;


-- 92페이지 Q3 조건1
select empno, ename, mgr, sal, comm, deptno from emp;

-- 92페이지 Q3 조건2
select empno as "employee_no", 
    ename as "employee_name",
    mgr as "manager", 
    sal as "salary", 
    comm as "commission",
    deptno as "department_no"
from emp;

-- 92페이지 Q3 조건3
select * from emp
order by deptno desc, ename asc;

select * from emp
where deptno != 30;


select * from emp
where job = 'CLERK' and deptno='30';

select * from emp
where job = 'CLERK' and (deptno='30' or deptno = '20');

select * from emp
where job = 'CLERK'
order by ename;

select * from emp
where not sal <> 3000;

select * from emp
where job in('MANAGER', 'SALESMAN', 'CLERK');

select * from emp
where job not in('MANAGER', 'SALESMAN', 'CLERK');

select * from emp
where sal >=2000
and sal <=3000;


select * from emp
where sal not between 2000 and 3000;

select * from emp
where ename not like 'S%';

select * from emp
where ename like '\%' escape '\';

select * from emp
where comm = null; -- null 이라서 비교가 불가

select * from emp
where comm is null;

select * from emp
where comm is not null;


select empno, ename, sal, deptno
from emp
where deptno =10
union all
select sal, ename, empno, deptno
from emp
where deptno=20;

select * from emp
where sal = 3000 and deptno =20;

select * from emp
where comm < 1000 or comm is null
order by comm desc;


select empno, ename, sal, deptno
from emp
where deptno =10
union all
select sal, ename, empno, deptno
from emp
where deptno=20
order by deptno, ename;

-- Q1 테이블을 사용하여 다음과 같이 사원 이름
select * from emp
where ename like '%S';

-- Q2 
select *
from emp
where deptno = 30 
and job = 'SALESMAN';

-- Q3
select empno, ename , job, sal, deptno
from emp
where deptno = 20 
and sal > 2000
union all
select empno, ename , job, sal, deptno
 from emp
where deptno =30
and sal > 2000;

select empno, ename , job, sal, deptno
from emp
intersect
select empno, ename , job, sal, deptno
from emp
where (deptno =30 or deptno=20)
and sal > 2000;

select empno, ename , job, sal, deptno
from emp
where (deptno = 20 or deptno = 30)
and sal > 2000;

-- Q4
select * from emp
where (sal<2000 or sal>3000);


-- Q5
/*
    이름에  e포함 
    부서 30 
    급여 1000이상 2000이하가 "아닌"
*/
select ename, empno, sal, deptno
from emp
where ename like '%E%'
and deptno = 30
and sal not between 1000 and 2000;

-- Q6
select * from emp
where (job = 'MANAGER' or job = 'CLERK')
and comm is null
and mgr is not null
and ename not like '_L%';

SELECT ENAME, UPPER(ENAME), LOWER(ENAME), INITCAP(ENAME)
FROM EMP;

SELECT * FROM EMP
WHERE ENAME LIKE '%Am%';


select ename, length(ename), length('한글')
from emp
where length(ename) >= 5;

SELECT JOB, SUBSTR(JOB,1,2),SUBSTR(JOB, 3,2), SUBSTR(JOB, 5)
FROM EMP;

select job
from emp;

select job, replace(job, 'E', '*')
from emp;

select 'Oracle',
    LPAD('Oracle', 10, '#'),
    RPAD('Oracle', 10, '*')
from dual;


select '240111-3456789' as 원본,
    substr('240111-3456789', 1, 8) as 표시,
    rpad(substr('240111-3456789', 1, 8), length('240111-3456789'), '*') as 최종    
from dual;

/*
1. 사원 이름을 앞에 두글자만 보이게 하고 나머지는 *로 표시
2. 사원 이름 앞글자 하나만 *로 표시
*/
select ename as 원본,
    substr(ename, 1, 2) as 확인,
    rpad(substr(ename, 1, 2), length(ename),'*') as 문제1번
from emp dual;

select ename as 원본,
    substr(ename, 2) as 확인,
    lpad(substr(ename, 2), length(ename),'*') as 문제2번
from emp ;

-- 문제 3 
-- 사원 이름의 두번째 글씨만 *로 마스킹
select ename as 원본,
    substr(ename, 2,1) as 확인,
    substr(ename, 1,1) || '*' || substr(ename, 3)
from emp ;

select ename
    , lpad(ename, 1) /* lpad, rpad 주어진 자리만큼 표시하는데 남으면 다른글씨로 채워줄 수 있다. */
    , substr(ename, 1, 1) -- 첫번째부터 한글자만 잘라오기 
    , substr(ename, 1, 1) || '*' 
    , substr(ename, 3) -- 세번째 전달인자가 없으면 끝까지
    , substr(ename, 1, 1) || '*' || substr(ename, 3)
from emp;


-- 문제 4
-- 사원의 이름을 두번째 글씨만 보이고 나머지 *로 마스킹
select ename as 원본,
    substr(ename, 2, 1) as 확인,
    rpad(substr(ename,2, 1),length(ename)-1, '*') as 과정,
    lpad(rpad(substr(ename,2, 1),length(ename)-1, '*'), length(ename), '*') as 문제4번
from emp;


select round(4.4)
     , round(4.5)
     , round(1234, -2)
     , round(3.14, 1)
from dual;

select
      trunc(3.14)
    , trunc(-3.14)
from dual;

select
      ceil(3.14)
    , ceil(-3.14)
from dual;

select
      floor(3.14)
    , floor(-3.14)
from dual;

SELECT
MOD(10, 4)
FROM DUAL;

SELECT
    SYSDATE
FROM DUAL;

SELECT
    TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS')
FROM DUAL;



SELECT
ENAME,
    TO_CHAR(HIREDATE, 'YYYY-MM-DD HH24:MI:SS')
FROM EMP;

SELECT
    TO_CHAR(SYSDATE +20, 'YYYY-MM-DD HH24:MI:SS')
FROM DUAL;

SELECT
    TO_CHAR(ADD_MONTHS(SYSDATE, 1)
    , 'YYYY-MM-DD HH24:MI:SS')
FROM DUAL;

SELECT EMPNO, ENAME, HIREDATE,
ADD_MONTHS(HIREDATE, 120) AS WORK10YEAR
FROM EMP;

SELECT ENAME, HIREDATE, 
ADD_MONTHS(HIREDATE, 38*12),
SYSDATE
FROM EMP
WHERE ADD_MONTHS(HIREDATE, 38*12) > SYSDATE;


SELECT
TO_DATE('18-07-14', 'DD-MM-YY')
FROM DUAL;

SELECT
    ENAME, HIREDATE
FROM EMP
WHERE HIREDATE > TO_DATE('1981/06/01', 'YYYY/MM/DD');


SELECT 
    TO_DATE('2024/05/03', 'YYYY/MM/DD') - SYSDATE
FROM DUAL;

SELECT 
    ENAME, SAL, COMM, NVL(COMM, 0), SAL+COMM, SAL+NVL(COMM, 0)
FROM EMP;

SELECT * FROM EMP
WHERE COMM != 0;

SELECT EMPNO, ENAME, COMM,
    NVL2(COMM, 'O', 'X'),
    NVL2(COMM, SAL*12+COMM, SAL*12) AS ANNSAL
FROM EMP;

SELECT EMPNO, ENAME, JOB, SAL, 
DECODE(JOB,
    'MANAGER', SAL*1.1,
    'SALESMAN', SAL*1.05,
    'ANALYST', SAL,
    SAL*1.03) AS UPSAL
FROM EMP;
    
    
SELECT
    ENAME, JOB, SAL,
    CASE JOB
      WHEN 'MANAGER' THEN SAL*1.1
      WHEN 'SALESMAN' THEN SAL*1.05
      WHEN 'ANALYST' THEN SAL
      ELSE SAL*1.03
END AS UPSAL
FROM EMP;


SELECT
    ENAME, JOB, SAL,
    CASE
        WHEN COMM IS NULL THEN '해당사항없음'
        WHEN COMM = 0 THEN '수당없음'
        WHEN COMM > 0 THEN CASE
                            WHEN COMM>1000 THEN '많이 받음'
                            ELSE '분발하자'
                            END
    END
FROM EMP;

-- P174 Q2
/*
월 평균 근무일 수 : 21.5
하루 근무 시간 : 8시간
하루 급여 : DAY_PAY(소수점 세 번째 자리에서 버림 TRUNC)
시급 : TIME_PAY (소수점 두번째 자리에서 반올림 ROUND)
*/
SELECT EMPNO, ENAME, SAL,
    TRUNC(SAL/(21.5), 2) AS DAY_PAY,
    ROUND(SAL/(21.5*8), 1) AS TIME_PAY
FROM EMP;

/*
P175 Q3
입사일 기준 3개월이 지난 후 첫 월요일 정직원
정직원이 되는 날짜 출력(R_JOB) : YYYY-MM-DD / ADD_MONTHS, NEXT_DAY
추가 수당이 없는 사원의 추가 수당은(COMM) : N/A로 출력 / NVL
*/
SELECT EMPNO, ENAME, HIREDATE
    , TO_CHAR(NEXT_DAY(ADD_MONTHS(HIREDATE, 3),'월요일'), 'YYYY-MM-DD') AS R_JOB
    , NVL(TO_CHAR(COMM),'N/A') AS COMM
FROM EMP;

SELECT EMPNO, ENAME, HIREDATE
    , TO_CHAR(NEXT_DAY(ADD_MONTHS(HIREDATE, 3),'월요일'), 'YYYY-MM-DD') AS R_JOB
    , CASE
        WHEN COMM IS NULL THEN 'N/A'
        ELSE ''||COMM
    END AS COMM
FROM EMP;

/*
P175 Q4
*/
SELECT MGR,
    CASE 
        WHEN MGR IS NULL THEN '0000'
        WHEN SUBSTR(MGR,1 ,2)=75 THEN '5555'
        WHEN SUBSTR(MGR,1 ,2)=76 THEN '6666'
        WHEN SUBSTR(MGR,1 ,2)=77 THEN '7777'
        WHEN SUBSTR(MGR,1 ,2)=78 THEN '8888'
        ELSE TO_CHAR(MGR)
    END AS CHG_MGR
FROM EMP;
        

/*
P174 Q1
*/
SELECT EMPNO, ENAME
    , RPAD(SUBSTR(EMPNO, 1, 2),LENGTH(EMPNO), '*') AS MASKING_EMPNO
    , RPAD(SUBSTR(ENAME, 1, 1),LENGTH(ENAME), '*') AS MASKING_ENAME
FROM EMP
WHERE LENGTH(ENAME)>=5 AND LENGTH(ENAME)<6;


------------------ 다중행 p 177 ------------------
 select ename from emp;
  
 select sum(sal) from emp;
 
 
 -- 결과가 한줄로 나오는 것과 여러 줄로 나오는 것은 같이 사용할 수 없다.
 select sum(sal), sal from emp; -- 오류남
 select sum(sal), ename from emp; -- 오류 남
 
 select sum(ename) from emp; -- ename은 숫자가 아니라서 오류남
 select sum(length(ename)) from emp; -- 요건 가능
 
 
 select count(*) from emp; -- emp에는 14줄이 있다는 뜻
 select count(ename) from emp; -- emp의 ename에는 14줄이 있다
 
 select comm from emp;
 select count(comm) from emp; -- null은 카운딩에서 제외됨
 select * from emp where comm is not null;
 
 select count(*) from emp where comm is not null; -- null이 아닌 것들의 카운트, 이게 더 길지만 코드로서는 좋은 코드래(설명이 잘 들어가있어서)
 
 select max(sal), min(sal), max(hiredate), min(hiredate), count(*) from emp; -- 임금이 5000이 제일 높고, 800이 제일 낮다
 
 select * from emp where hiredate = max(hiredate); -- where에서 다중행 함수를 못쓴다. (max를 where에서 못씀)
 
 
 select avg(sal), sum(sal), max(sal), min(sal), count(*) from emp where deptno = 10
 union all
 select avg(sal), sum(sal), max(sal), min(sal), count(*) from emp where deptno = 20
 union all
 select avg(sal), sum(sal), max(sal), min(sal), count(*) from emp where deptno = 30;
 
 
 ------------ group by (distinct와 비슷하다지만 다르게 엄청 자주 쓰이고 중요) p 187 ---------------
 
 -- 주의 : group by는 분류해주는 것
 -- distinct처럼 중복을 제거해줌
 -- select에는 group by 한 것이나 다중행 함수(집계함수)만 사용할 수 있다.
 
 select deptno
 from emp
 group by deptno;
  -- distinct랑 비교
 select distinct deptno
 from emp;
 
 
 select deptno, avg(sal), count(*)
 from emp
 group by deptno;
   -- union과 비교
 select avg(sal)from emp where deptno = 10
 union all
 select avg(sal) from emp where deptno = 20
 union all
 select avg(sal) from emp where deptno = 30;
 
 
 select deptno, job, count(*)
 from emp
 group by deptno, job
 order by deptno asc;
 
  select deptno, job, count(*)
 from emp
 group by job, deptno -- job과 deptno 순서 바꿔도 결과는 같음
 order by deptno asc; 
 
 
 select deptno, job, count(*)
 from emp
 where deptno in (10, 20) -- 당연히 30은 빠지는데 where가 먼저 작동해서 무엇을 빼낼지 가려낸다.
 group by job, deptno 
 order by deptno asc; 
 
  -- from > where > group by > select> order by 순서대로 적용 --
 
 ----------------- having p 190 --------------------------- 
  select deptno, job, avg(sal) 
  from emp 
  group by deptno, job
  having avg(sal) >= 2000
  order by deptno,job;
  
  
  
  -------- 부서별 직책이 2명 이상으로 구성된 결과 표시
 select job, deptno, count(*) as count
 -- 여기에 deptno를 쓰려면 order by로 줄어든 job의 행 수만큼 deptno도 같이 줄어들기라도 해야함
 -- 따라서 쓰려면 똑같이 group by에 deptno와 select에 deptno를 같이 써줘야함, 둘은 연관된 번호와 이름이라 맞게 줄어들고
 -- 합해서 출력이 가능하다.
 from emp
 group by job, deptno
 having count(*) >=2
 -- having은 group by절이 사용된 경우 조건을 더 주기 위해 사용한다.
 order by count(job);
 
 
  select job, count(*), sum(sal) -- 여기에 sal을 적으면 아레에 group by job 때문에 줄어든 행의 수만큼 줄일 수 없어서
                                 -- sum과 같은 다중행을 써서 같이 묶어줌으로 인해 job과 같은 행의 수를 가지게 하면 작동 가능
 from emp
 group by job
 having count(*) >=2
 order by count(job);
 
 
 select job, deptno, count(*) as count
 from emp
 where deptno = 20
 group by job, deptno
 having deptno = 20 
 -- having은 다중행 함수가 들어갈 수 있어서 더 많은 것을 넣을 수 있긴 함
 -- 대신 group by를 쓰지 않으면 사용할 수 없다.
 -- 실무에서는 having을 잘 안쓴다고 함
 order by count(job);
 
 
 
 select job, deptno, count(*) as count
 from emp
 where deptno in (20, 30)
 group by job, deptno
 having deptno = 20 
 order by count(job);
  -- where에서 가져온 것을 group by에서 정렬하고 거기에 having으로 20만 빼내는 것이라
  -- 출력은 되는데 완전 쓰잘데기 없이 쓴 것임, 애초에 20만 출력되게 했으면 될 것을 굳이 이렇게 쓴 것
  -- 아래는 수정을 좀 해서 쓸만하게 바꾼 것
 select sal, job, deptno, count(*) as count
 from emp
 where deptno in (20, 30)
 group by job, deptno, sal
 having sal > 1000 
 order by count(job);
 
 
/* having
 group by절이 사용된 경우 필터링 조건을 더 주기 위해 사용
 where에서 표현할 수 있는 것들은 가급적 where에서 처리하는 게 싸게 먹힌다.
 보통은 한줄로 표시되는 함수(다중행, 집계함수)들을 조건으로 줄 때 사용한다. */
 
 h
 
 ------------- p208 pivot ------------------------
 -- pivot : 행과 열을 바꾸는 것, 살면서 한번은 쓸 일이 있을 것
 
 
 --Q1
 SELECT DEPTNO,TRUNC(AVG(SAL)), MAX(SAL), MIN(SAL), COUNT(*) AS CNT
 FROM EMP
 group by deptno;
 
SELECT* FROM EMP, DEPT
ORDER BY EMPNO;

SELECT EMP.ENAME
FROM EMP, DEPT
ORDER BY EMPNO;
 
 SELECT DEPTNO
 FROM EMP E, DEPT D
 WHERE E.DEPTNO = D.DEPTNO
 ORDER BY E.EMPNO;
 
  SELECT ENMAE, '사원정보', *
 FROM EMP E, DEPT D
 WHERE E.DEPTNO = D.DEPTNO
 ORDER BY E.EMPNO;
 
 
 SELECT
    ENAME, EMP.*
FROM EMP;


SELECT ENAME, E.*, D.*
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
ORDER BY E.EMPNO;

SELECT * FROM SALGRADE;

SELECT E.ENAME, E.SAL, S.GRADE
FROM EMP E, SALGRADE S
WHERE 
    E.SAL >= S.LOSAL
    AND E.SAL <= HISAL;
    
SELECT *
FROM SALGRADE;
    
SELECT DEPTNO, JOB, SAL
FROM EMP;

SELECT DEPTNO, JOB, AVG(SAL)
FROM EMP
GROUP BY DEPTNO, JOB;

SELECT DEPTNO, JOB, AVG(SAL)
FROM EMP;

SELECT
    E1.EMPNO, E1.ENAME, E1.MGR,
    E2.EMPNO, E2.ENAME, E2.MGR
FROM EMP E1, EMP E2
WHERE E1.MGR = E2.EMPNO;
    
    
SELECT
    E1.EMPNO, E1.ENAME, E1.MGR,
    E2.EMPNO, E2.ENAME, E2.MGR
FROM EMP E1, EMP E2
WHERE E1.MGR = E2.EMPNO
AND E1.ENAME = 'SCOTT';
    
SELECT
    E1.EMPNO, E1.ENAME, E1.MGR,
    E2.EMPNO, E2.ENAME, E2.MGR
FROM EMP E1, EMP E2
WHERE E1.MGR = E2.EMPNO
AND E1.MGR = E2.EMPNO(+);

/*
QUIZ2
사번, 이름, 부서명 DEPT.DNAME, 급여등급 SALGRADE.GRADE
-- 총 14줄
*/

SELECT E.EMPNO, E.ENAME, D.DNAME, S.GRADE
FROM EMP E, DEPT D, SALGRADE S
WHERE E.DEPTNO = D.DEPTNO
AND E.SAL >= S.LOSAL 
AND E.SAL <= S.HISAL;

SELECT *
FROM DEPT;

SELECT *
FROM EMP;


select 
    deptno
from emp e, dept d
where e.deptno = d.deptno;

select 
    deptno
from emp e join dept d using (deptno);

select
    e.deptno
from emp e join dept d on (e.deptno = d.deptno);

select *
from emp e join salgrade s on (e.sal >= s.losal and e.sal <= s.hisal);

-- quiz3
select e.empno, e.ename, d.dname, s.grade
from emp e 
join dept d on (e.deptno = d.deptno)
join salgrade s on (e.sal >= s.losal and e.sal <= s.hisal);

-- quiz4
select e1.empno, e1.ename, e1.mgr, e2.ename emgr, d.loc
from emp e1 
join emp e2 on (e1.mgr = e2.empno)
join dept d on (e2.deptno = d.deptno);

select e1.empno, e1.ename, e1.mgr, e2.ename, dept.loc 
from emp e1
join emp e2 on (e1.mgr = e2.empno)
join dept on (dept.deptno = e2.deptno);

-- quiz5 상사보다 월급이 많은 직원은?
select e1.ename, e1.sal, e2.ename, e2.sal
from emp e1 
join emp e2 on (e1.mgr = e2.empno and e1.sal > e2.sal);

select e1.ename, e1.sal, e2.ename, e2.sal
from emp e1 
join emp e2 on (e1.mgr = e2.empno)
where e1.sal >e2.sal;

-- 왼쪽 즉 emp e1의 모든 내용을 보존해줌
-- 조건에 맞지 않는 경우 null로 채워줌
select 
    e1.ename, e1.sal, e2.ename, e2.sal
from emp e1
    left outer join emp e2 on (e1.mgr = e2.empno);
    
select 
    e1.ename, e1.sal, e2.ename, e2.sal
from emp e1
    right outer join emp e2 on (e1.mgr = e2.empno);
    
 -- p239 q1
 select e.deptno, dname, empno, ename, sal
 from emp e, dept d
 where e.deptno=d.deptno
 and e.sal > 2000
 order by deptno;
 
select e.deptno, dname, empno, ename, sal
 from emp e join dept d on (e.deptno=d.deptno  and e.sal > 2000 )
 order by deptno;

-- using을 사용할때는 컬럼 앞에 테이블(또는 테이블 별칭)을 적으면 안된다.
select 
    deptno, dept.dname, emp.empno, emp.ename, emp.sal
from emp join dept using (deptno)
where 
    emp.sal > 2000
order by deptno;

 -- p239 q2
select e.deptno, d.dname, trunc(avg(e.sal)), max(e.sal), min(e.sal), count(*)
from emp e, dept d
where e.deptno = d.deptno
group by e.deptno, d.dname; 

select e.deptno, d.dname, trunc(avg(e.sal)), max(e.sal), min(e.sal), count(*)
from emp e join dept d on (e.deptno = d.deptno)
group by e.deptno, d.dname; 

 -- p239 q3
 select d.deptno, dname, empno, ename, job, sal
 from emp e, dept d
 where e.deptno(+)= d.deptno
 order by deptno, dname;
 
 select d.deptno, dname, empno, ename, job, sal
 from emp e right outer join dept d on (e.deptno(+)= d.deptno)
 order by deptno, dname;
 
 -- 서브쿼리
 select * from emp
 where sal > (select sal from emp
              where ename = 'JONES');
              
              
select * from emp;
-- jones와 같은 job을 가지는 사원을 모두 출력
select * from emp
where job = (select job from emp
             where ename= 'JONES');
             
select e.empno, e.ename, e.job, e.mgr, e.hiredate, e.sal, e.comm, e.deptno
from emp e, emp m
where e.job = m.job;

-- 평균급여보다 많이 받는 20번 부서의 사원 정보 출력
select * from emp
where sal > (select avg(sal) from emp)
and deptno = 20;

-- 사원번호, 이름, 상사사원번호, 상사의 사원번호, 이름
select *
from emp e1
where mgr = (select empno from emp e2
             where empno = e1.mgr);
             
-- emp 에서 자기가 속한 부서의 최소 급여자만 출력
select deptno, min(sal)
from emp
group by deptno;

select * from emp
where deptno = 30
and sal = 950;

select * from emp e1
where sal = (select min(sal)
             from emp
             where deptno = e1.deptno)
;

SELECT * FROM EMP
WHERE SAL IN (SELECT MAX(SAL) FROM EMP
              GROUP BY DEPTNO);

SELECT * FROM EMP
WHERE
(DEPTNO, SAL) IN (SELECT DEPTNO, MAX(SAL) FROM EMP
                  GROUP BY DEPTNO);

WITH E10 AS (
        SELECT * 
        FROM EMP
        WHERE DEPTNO = 10
) 
SELECT 
*
FROM E10;



--1. 테이블의 사원번호(empno)와 사원명(ename)만 출력
SELECT EMPNO, ENAME
FROM EMP;

--2. 사원번호가 높은 숫자부터 낮은 숫자 순서로 출력
SELECT *
FROM EMP
ORDER BY EMPNO DESC;

--3. 보안을 위해 앞 2자리는 그대로 출력하고 나머지는 * 기호로 표시(출력 예시: 73**)
SELECT 
RPAD(SUBSTR(EMPNO, 1, 2),LENGTH(EMPNO), '*') AS EMPNO,
ENAME, JOB, MGR, HIREDATE, COMM, DEPTNO
FROM EMP ;

--모두 합친것
SELECT RPAD(SUBSTR(EMPNO, 1, 2),LENGTH(EMPNO), '*') AS EMPNO, ENAME
FROM EMP
ORDER BY EMPNO DESC;

select *
from dept;

-- q1
select job, empno, ename, sal, deptno, dname 
from emp join dept using (deptno)
where job = (select job
        from emp 
        where ename = 'ALLEN')
order by sal desc, ename;
        
-- q2
select e.empno, e.ename, d.dname, e.hiredate, d.loc, e.sal, s.grade
from emp e, dept d, salgrade s
where 
    e.deptno = d.deptno
    and e.sal >= s.losal
    and e.sal <= s.hisal
    and e.sal > (select avg(sal) from emp)
order by e.sal desc, e.empno;

--q3
select job from emp
where deptno = 30
group by job;
/*
SALESMAN
MANAGER
*/

select * from emp
where deptno = 10
and job not in (select job from emp
            where deptno = 30);


select EMPNO, ENAME, SAL, GRADE
FROM EMP JOIN SALGRADE ON (SAL >= LOSAL AND SAL <= HISAL)
WHERE SAL > (SELECT max(sal)
             from emp 
             where job = 'SALESMAN');

-- 12장
-- create
create table emp_ddl(
    empno number(4),
    ename varchar(10),
    job varchar(9),
    mgr number(4),
    hiredate date,
    sal number(7,2),
    comm number(7,2),
    deptno number(2)
);

desc emp_ddl;
select * from emp_ddl;

create table dept_ddl
as select * from dept;

desc dept_ddl;

create table emp_ddl_30
as select * from emp 
where deptno = 30;

select * from emp_ddl_30;

create table empdept_ddl
as select
    empno, ename, job, mgr, hiredate, sal, comm,
    d.deptno, dname, loc
    from emp e, dept d
    where 1 <> 1;
select * from empdept_ddl;


create table emp_alter
as select * from emp;

select * from emp_alter;

alter table emp_alter
add hp varchar2(20);

select * from emp_alter;

alter table emp_alter
rename column hp to tel;

select * from emp_alter;

alter table emp_alter
modify empno number(5);

-- 커지는 방향으로 수정 가능(작은 값으로는 불가능)

alter table emp_alter
modify empno number(5);

alter table emp_alter
drop column tel;

rename emp_alter to emp_rename;
select * from emp_alter;
select * from emp_rename;

truncate table emp_rename;
select * from emp_rename;

drop table emp_rename;


create table dept_temp
as select * from dept;
select * from dept_temp;

insert into dept_temp (deptno, dname, loc)
values (50,'database', 'seoul');
select * from dept_temp;

--values의 타입이 맞지 않을때
insert into dept_temp (deptno, dname, loc)
values ('a','database', 'seoul');

-- 최대치를 벗어난 경우
insert into dept_temp (deptno, dname, loc)
values (500,'database', 'seoul');

-- COLUMN을 생략하면 자동으로(묵시적, 암시적) NULL 삽입
insert into dept_temp (deptno, dname)
values (55,'DB');

-- 명시적으로 NULL을 입력
INSERT INTO DEPT_TEMP(DEPTNO, DNAME, LOC)
VALUES (70, 'WEB', NULL); 

INSERT INTO DEPT_TEMP(DEPTNO, DNAME, LOC)
VALUES (80, 'MOBILE', '');
SELECT*FROM DEPT_TEMP;


--컬럼을 지정하지 않으면 모든 컬럼을 뜻하게 됨
INSERT INTO DEPT_TEMP
VALUES (60, 'NETWORK', 'BUSAN');
SELECT * FROM DEPT_TEMP;

CREATE TABLE EMP_TEMP
AS SELECT * FROM EMP WHERE 1<>1;
SELECT * FROM EMP_TEMP;

INSERT INTO EMP_TEMP(EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
VALUES (9999, '홍길동', 'PRESIDENT', NULL, TO_DATE('07/01/2001', 'DD/MM/YYYY'), 5000, 1000, 10);
SELECT *FROM EMP_TEMP;

INSERT INTO EMP_TEMP(EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
VALUES (3111, '심청이', 'PRESIDENT', NULL, SYSDATE, 5000, 1000, 10);
SELECT *FROM EMP_TEMP;

INSERT INTO EMP_TEMP
SELECT * FROM EMP WHERE DEPTNO = 10;
SELECT * FROM EMP_TEMP;

create table dept_temp2
as select*from dept;

UPDATE DEPT_TEMP2
SET LOC = 'SEOUL';
SELECT * FROM DEPT_TEMP2;
ROLLBACK;

UPDATE DEPT_TEMP2
SET DNAME = 'DATABASE',
LOC = 'SEOUL'
WHERE DEPTNO = 40;
SELECT * FROM DEPT_TEMP2;

SELECT * FROM DEPT_TEMP2
WHERE DEPTNO = 40;

create table EMP_TEMP2
as select*from EMP;

SELECT * FROM EMP_TEMP2;

SELECT * FROM EMP_TEMP2
WHERE JOB = 'MANAGER';

DELETE FROM EMP_TEMP2
WHERE JOB = 'MANAGER';

SELECT * FROM EMP_TEMP2;

--연봉 3천이상인 사원 정보 삭제
SELECT * FROM EMP_TEMP2
WHERE SAL >= 3000;

DELETE EMP_TEMP2
WHERE SAL >= 3000;
SELECT *FROM EMP_TEMP2;

-- 연봉이 1000이하인 사원의 연봉 1.3% 인상
SELECT * FROM EMP_TEMP2
WHERE SAL <= 1000;



UPDATE EMP_TEMP2
SET SAL = SAL*1.013
WHERE SAL <= 1000;
SELECT *FROM EMP_TEMP2;

CREATE TABLE DEPT_TCL
AS SELECT * FROM DEPT;

-- 10번 부서 지우기
-- 20번 부서는 50번 부서로 바꾸기
DELETE DEPT_TCL
WHERE DEPTNO =10;

UPDATE DEPT_TCL
SET DEPTNO = 50
WHERE DEPTNO = 20 ;

ROLLBACK;

SELECT * FROM DEPT_TCL;

update dept_tcl
set dname = 'human2'
where deptno = 40;

commit;

SELECT * FROM DICT;

SELECT * FROM DICTIONARY;

SELECT * FROM USER_TABLES;

select * from user_indexes;

create index idx_emp_sal 
on emp(sal);

create index idx_emp_sal_desc on emp(sal desc);

drop index idx_emp_sal_desc;

select * from emp
order by sal;

select * from emp
where sal > 2000;

-- 다행히 empno는 index를 사용하니까 plan 확인 가능
select * from emp
where empno = 7900;

create index idx_emp_empno
on emp(empno desc);

-- 아래 주석은 강제 hint
-- 강제로 인덱스를 사용하게 지정
select /*+ index(e idx_emp_sal)*/
* 
from emp e
where sal = 3000;

select max(empno)+1 from emp;

insert into emp (empno)
values(select max(empno)+1 from emp);

drop sequence seq_dept;
create sequence seq_dept
start with 10000
increment by 10
maxvalue 10020
minvalue 0
cycle
cache 2;

select * from user_sequences;

select seq_dept.currval from dual;

select seq_dept.nextval from dual;

-- tb_user
-- user_id, user_name
create table tb_user (
    user_id number not null,
    user_name varchar2(30)  
);
select * from tb_user;

drop sequence seq_tb_user;
create sequence seq_tb_user;

insert into tb_user(user_id, user_name)
values(seq_tb_user.nextval, 'name3');
select* from tb_user;


create table table_pk (
    login_id varchar2(20) primary key,
    login_pwd varchar2(20) not null,
    tel varchar2(20)
);

desc table_pk;

delete tb_user
where user_id = 3;

insert into table_pk(login_id, login_pwd, tel)
values(null, 'pwd01', '010-1234-5678');

create table table_pk2 (
    login_id varchar2(20),
    login_pwd varchar2(20),
    tel varchar2(20),
    primary key(login_id, login_pwd)
);

insert into table_pk2
values('test01', 'pw01', '010-yyyy');

insert into table_pk2
values('test01', 'pw02', '010-yyyy');

select * from table_pk2;


create table table_pk3 (
    login_id varchar2(20),
    login_pwd varchar2(20),
    tel varchar2(20)
);

alter table table_pk3
add constraint abcd primary key(login_id, login_pwd);

drop table table_pk4;
create table table_pk4 (
    login_id varchar2(20),
    login_pwd varchar2(20),
    tel varchar2(20)
);
-- alter로 나중에 제약 조건을 추가하는 방법
-- primary key
alter table table_pk4
add primary key(login_id, login_pwd);
-- 관리 이름 추가 
alter table table_pk4
add constraint 제약조건이름 primary key (login_id, login_pwd);
-- 제약을 지우기
alter table table_pk4
drop constraint 제약조건이름;


create table table_pk5 (
    login_id varchar2(20),
    login_pwd varchar2(20),
    tel varchar2(20)
);
alter table table_pk5
modify login_id primary key;

-- 한 테이블에 pk가 여러개 있을 수 없어서 실패
alter table table_pk5
add primary key (login_pwd);
-- 한 테이블에 pk가 여러개 있을 수 없어서 실패
-- 이런 경우 기존 pk삭제 후 시도해야 함.
alter table table_pk5
add primary key (login_id, login_pwd);

select * from table_pk5;

create table dept_fk(
    deptno number(2) primary key,
    dname varchar(14),
    loc varchar(13)
);
create table emp_fk(
    empno number(4),
    ename varchar2(10),
    deptno number(2) references dept_fk(deptno)
);
-- 참조하고 있어서 안지워짐
drop table dept_fk;
-- dept.deptno에 10이 없기 때문에 실패
insert into emp_fk
values(1, '부하1', 10);

insert into dept_fk
values(10, 'test_dname', 'test_loc');

insert into emp_fk
values(1, '부하1', 10);

select * from dept_fk;
select * from emp_fk;

-- 참조중이어서 삭제 안됨
delete dept_fk
where deptno = 10;

insert into dept_fk
values(20, 'test_dname2', 'test_loc2');
-- 참조하고 잇는게 없어서 삭제 수정 가능
delete dept_fk
where deptno=20;

update dept_fk
set deptno = 30
where deptno = 10;

create table emp_fk2(
    empno number(4),
    ename varchar2(10),
    deptno number(2),
    foreign key (deptno) references  dept_fk(deptrno)
);

create table emp_fk3(
    empno number(4),
    ename varchar2(10),
    deptno number(2)
);

alter table emp_fk3
add foreign key (deptno) references  dept_fk(deptrno);

-- ROWNUM은 SELECT에서 동작하고,
-- ORDER BY는 SELECT 이후에 동작
-- ORDER BY로 다시 재정렬이 되서 엉망진창이다.
SELECT 
    ROWNUM, EMP.*
FROM EMP
ORDER BY ENAME;


SELECT *
FROM(
    SELECT ROWNUM RNUM, TEMP1.* 
    FROM(
        SELECT * FROM EMP
        ORDER BY ENAME
    ) TEMP1
)
WHERE RNUM >= 5 AND RNUM <= 7;

select * from emp;
