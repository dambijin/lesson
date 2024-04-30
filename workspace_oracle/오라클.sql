-- ���� ������ �ּ�
select * from emp;
select * from dept;
select * from salgrade;

desc emp;


select empno, ename, deptno from emp;

select deprno from emp;
select distinct deptno from emp;
select distinct job from emp;

/*������� �ߺ��Ǵ� ������ �����ϰ� ��ȸ distinct*/
select distinct deptno, job
from 
emp;


/*��Ī*/
/*sql�� �ֵ���ǥ�� Ȭ����ǥ�� ��Ȯ�� �����ؼ� ����ؾ���
select �������� �ֵ���ǥ, �������� Ȧ����ǥ
*/
select 
    sal, sal*12+comm as "new sal" 
from
    emp;
 
select * 
from emp
-- asc ��������
-- desc ��������
order by sal desc;

select *
    from emp
order by deptno asc, sal desc;

select * 
 from emp
order by ename asc;

select distinct job from emp
order by job asc;


-- 92������ Q3 ����1
select empno, ename, mgr, sal, comm, deptno from emp;

-- 92������ Q3 ����2
select empno as "employee_no", 
    ename as "employee_name",
    mgr as "manager", 
    sal as "salary", 
    comm as "commission",
    deptno as "department_no"
from emp;

-- 92������ Q3 ����3
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
where comm = null; -- null �̶� �񱳰� �Ұ�

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

-- Q1 ���̺��� ����Ͽ� ������ ���� ��� �̸�
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
    �̸���  e���� 
    �μ� 30 
    �޿� 1000�̻� 2000���ϰ� "�ƴ�"
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


select ename, length(ename), length('�ѱ�')
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


select '240111-3456789' as ����,
    substr('240111-3456789', 1, 8) as ǥ��,
    rpad(substr('240111-3456789', 1, 8), length('240111-3456789'), '*') as ����    
from dual;

/*
1. ��� �̸��� �տ� �α��ڸ� ���̰� �ϰ� �������� *�� ǥ��
2. ��� �̸� �ձ��� �ϳ��� *�� ǥ��
*/
select ename as ����,
    substr(ename, 1, 2) as Ȯ��,
    rpad(substr(ename, 1, 2), length(ename),'*') as ����1��
from emp dual;

select ename as ����,
    substr(ename, 2) as Ȯ��,
    lpad(substr(ename, 2), length(ename),'*') as ����2��
from emp ;

-- ���� 3 
-- ��� �̸��� �ι�° �۾��� *�� ����ŷ
select ename as ����,
    substr(ename, 2,1) as Ȯ��,
    substr(ename, 1,1) || '*' || substr(ename, 3)
from emp ;

select ename
    , lpad(ename, 1) /* lpad, rpad �־��� �ڸ���ŭ ǥ���ϴµ� ������ �ٸ��۾��� ä���� �� �ִ�. */
    , substr(ename, 1, 1) -- ù��°���� �ѱ��ڸ� �߶���� 
    , substr(ename, 1, 1) || '*' 
    , substr(ename, 3) -- ����° �������ڰ� ������ ������
    , substr(ename, 1, 1) || '*' || substr(ename, 3)
from emp;


-- ���� 4
-- ����� �̸��� �ι�° �۾��� ���̰� ������ *�� ����ŷ
select ename as ����,
    substr(ename, 2, 1) as Ȯ��,
    rpad(substr(ename,2, 1),length(ename)-1, '*') as ����,
    lpad(rpad(substr(ename,2, 1),length(ename)-1, '*'), length(ename), '*') as ����4��
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
        WHEN COMM IS NULL THEN '�ش���׾���'
        WHEN COMM = 0 THEN '�������'
        WHEN COMM > 0 THEN CASE
                            WHEN COMM>1000 THEN '���� ����'
                            ELSE '�й�����'
                            END
    END
FROM EMP;

-- P174 Q2
/*
�� ��� �ٹ��� �� : 21.5
�Ϸ� �ٹ� �ð� : 8�ð�
�Ϸ� �޿� : DAY_PAY(�Ҽ��� �� ��° �ڸ����� ���� TRUNC)
�ñ� : TIME_PAY (�Ҽ��� �ι�° �ڸ����� �ݿø� ROUND)
*/
SELECT EMPNO, ENAME, SAL,
    TRUNC(SAL/(21.5), 2) AS DAY_PAY,
    ROUND(SAL/(21.5*8), 1) AS TIME_PAY
FROM EMP;

/*
P175 Q3
�Ի��� ���� 3������ ���� �� ù ������ ������
�������� �Ǵ� ��¥ ���(R_JOB) : YYYY-MM-DD / ADD_MONTHS, NEXT_DAY
�߰� ������ ���� ����� �߰� ������(COMM) : N/A�� ��� / NVL
*/
SELECT EMPNO, ENAME, HIREDATE
    , TO_CHAR(NEXT_DAY(ADD_MONTHS(HIREDATE, 3),'������'), 'YYYY-MM-DD') AS R_JOB
    , NVL(TO_CHAR(COMM),'N/A') AS COMM
FROM EMP;

SELECT EMPNO, ENAME, HIREDATE
    , TO_CHAR(NEXT_DAY(ADD_MONTHS(HIREDATE, 3),'������'), 'YYYY-MM-DD') AS R_JOB
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


------------------ ������ p 177 ------------------
 select ename from emp;
  
 select sum(sal) from emp;
 
 
 -- ����� ���ٷ� ������ �Ͱ� ���� �ٷ� ������ ���� ���� ����� �� ����.
 select sum(sal), sal from emp; -- ������
 select sum(sal), ename from emp; -- ���� ��
 
 select sum(ename) from emp; -- ename�� ���ڰ� �ƴ϶� ������
 select sum(length(ename)) from emp; -- ��� ����
 
 
 select count(*) from emp; -- emp���� 14���� �ִٴ� ��
 select count(ename) from emp; -- emp�� ename���� 14���� �ִ�
 
 select comm from emp;
 select count(comm) from emp; -- null�� ī������� ���ܵ�
 select * from emp where comm is not null;
 
 select count(*) from emp where comm is not null; -- null�� �ƴ� �͵��� ī��Ʈ, �̰� �� ������ �ڵ�μ��� ���� �ڵ巡(������ �� ���־)
 
 select max(sal), min(sal), max(hiredate), min(hiredate), count(*) from emp; -- �ӱ��� 5000�� ���� ����, 800�� ���� ����
 
 select * from emp where hiredate = max(hiredate); -- where���� ������ �Լ��� ������. (max�� where���� ����)
 
 
 select avg(sal), sum(sal), max(sal), min(sal), count(*) from emp where deptno = 10
 union all
 select avg(sal), sum(sal), max(sal), min(sal), count(*) from emp where deptno = 20
 union all
 select avg(sal), sum(sal), max(sal), min(sal), count(*) from emp where deptno = 30;
 
 
 ------------ group by (distinct�� ����ϴ����� �ٸ��� ��û ���� ���̰� �߿�) p 187 ---------------
 
 -- ���� : group by�� �з����ִ� ��
 -- distinctó�� �ߺ��� ��������
 -- select���� group by �� ���̳� ������ �Լ�(�����Լ�)�� ����� �� �ִ�.
 
 select deptno
 from emp
 group by deptno;
  -- distinct�� ��
 select distinct deptno
 from emp;
 
 
 select deptno, avg(sal), count(*)
 from emp
 group by deptno;
   -- union�� ��
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
 group by job, deptno -- job�� deptno ���� �ٲ㵵 ����� ����
 order by deptno asc; 
 
 
 select deptno, job, count(*)
 from emp
 where deptno in (10, 20) -- �翬�� 30�� �����µ� where�� ���� �۵��ؼ� ������ ������ ��������.
 group by job, deptno 
 order by deptno asc; 
 
  -- from > where > group by > select> order by ������� ���� --
 
 ----------------- having p 190 --------------------------- 
  select deptno, job, avg(sal) 
  from emp 
  group by deptno, job
  having avg(sal) >= 2000
  order by deptno,job;
  
  
  
  -------- �μ��� ��å�� 2�� �̻����� ������ ��� ǥ��
 select job, deptno, count(*) as count
 -- ���⿡ deptno�� ������ order by�� �پ�� job�� �� ����ŭ deptno�� ���� �پ���� �ؾ���
 -- ���� ������ �Ȱ��� group by�� deptno�� select�� deptno�� ���� �������, ���� ������ ��ȣ�� �̸��̶� �°� �پ���
 -- ���ؼ� ����� �����ϴ�.
 from emp
 group by job, deptno
 having count(*) >=2
 -- having�� group by���� ���� ��� ������ �� �ֱ� ���� ����Ѵ�.
 order by count(job);
 
 
  select job, count(*), sum(sal) -- ���⿡ sal�� ������ �Ʒ��� group by job ������ �پ�� ���� ����ŭ ���� �� ���
                                 -- sum�� ���� �������� �Ἥ ���� ���������� ���� job�� ���� ���� ���� ������ �ϸ� �۵� ����
 from emp
 group by job
 having count(*) >=2
 order by count(job);
 
 
 select job, deptno, count(*) as count
 from emp
 where deptno = 20
 group by job, deptno
 having deptno = 20 
 -- having�� ������ �Լ��� �� �� �־ �� ���� ���� ���� �� �ֱ� ��
 -- ��� group by�� ���� ������ ����� �� ����.
 -- �ǹ������� having�� �� �Ⱦ��ٰ� ��
 order by count(job);
 
 
 
 select job, deptno, count(*) as count
 from emp
 where deptno in (20, 30)
 group by job, deptno
 having deptno = 20 
 order by count(job);
  -- where���� ������ ���� group by���� �����ϰ� �ű⿡ having���� 20�� ������ ���̶�
  -- ����� �Ǵµ� ���� ���ߵ��� ���� �� ����, ���ʿ� 20�� ��µǰ� ������ �� ���� ���� �̷��� �� ��
  -- �Ʒ��� ������ �� �ؼ� �����ϰ� �ٲ� ��
 select sal, job, deptno, count(*) as count
 from emp
 where deptno in (20, 30)
 group by job, deptno, sal
 having sal > 1000 
 order by count(job);
 
 
/* having
 group by���� ���� ��� ���͸� ������ �� �ֱ� ���� ���
 where���� ǥ���� �� �ִ� �͵��� ������ where���� ó���ϴ� �� �ΰ� ������.
 ������ ���ٷ� ǥ�õǴ� �Լ�(������, �����Լ�)���� �������� �� �� ����Ѵ�. */
 
 h
 
 ------------- p208 pivot ------------------------
 -- pivot : ��� ���� �ٲٴ� ��, ��鼭 �ѹ��� �� ���� ���� ��
 
 
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
 
  SELECT ENMAE, '�������', *
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
���, �̸�, �μ��� DEPT.DNAME, �޿���� SALGRADE.GRADE
-- �� 14��
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

-- quiz5 ��纸�� ������ ���� ������?
select e1.ename, e1.sal, e2.ename, e2.sal
from emp e1 
join emp e2 on (e1.mgr = e2.empno and e1.sal > e2.sal);

select e1.ename, e1.sal, e2.ename, e2.sal
from emp e1 
join emp e2 on (e1.mgr = e2.empno)
where e1.sal >e2.sal;

-- ���� �� emp e1�� ��� ������ ��������
-- ���ǿ� ���� �ʴ� ��� null�� ä����
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

-- using�� ����Ҷ��� �÷� �տ� ���̺�(�Ǵ� ���̺� ��Ī)�� ������ �ȵȴ�.
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
 
 -- ��������
 select * from emp
 where sal > (select sal from emp
              where ename = 'JONES');
              
              
select * from emp;
-- jones�� ���� job�� ������ ����� ��� ���
select * from emp
where job = (select job from emp
             where ename= 'JONES');
             
select e.empno, e.ename, e.job, e.mgr, e.hiredate, e.sal, e.comm, e.deptno
from emp e, emp m
where e.job = m.job;

-- ��ձ޿����� ���� �޴� 20�� �μ��� ��� ���� ���
select * from emp
where sal > (select avg(sal) from emp)
and deptno = 20;

-- �����ȣ, �̸�, �������ȣ, ����� �����ȣ, �̸�
select *
from emp e1
where mgr = (select empno from emp e2
             where empno = e1.mgr);
             
-- emp ���� �ڱⰡ ���� �μ��� �ּ� �޿��ڸ� ���
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



--1. ���̺��� �����ȣ(empno)�� �����(ename)�� ���
SELECT EMPNO, ENAME
FROM EMP;

--2. �����ȣ�� ���� ���ں��� ���� ���� ������ ���
SELECT *
FROM EMP
ORDER BY EMPNO DESC;

--3. ������ ���� �� 2�ڸ��� �״�� ����ϰ� �������� * ��ȣ�� ǥ��(��� ����: 73**)
SELECT 
RPAD(SUBSTR(EMPNO, 1, 2),LENGTH(EMPNO), '*') AS EMPNO,
ENAME, JOB, MGR, HIREDATE, COMM, DEPTNO
FROM EMP ;

--��� ��ģ��
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

-- 12��
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

-- Ŀ���� �������� ���� ����(���� �����δ� �Ұ���)

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

--values�� Ÿ���� ���� ������
insert into dept_temp (deptno, dname, loc)
values ('a','database', 'seoul');

-- �ִ�ġ�� ��� ���
insert into dept_temp (deptno, dname, loc)
values (500,'database', 'seoul');

-- COLUMN�� �����ϸ� �ڵ�����(������, �Ͻ���) NULL ����
insert into dept_temp (deptno, dname)
values (55,'DB');

-- ��������� NULL�� �Է�
INSERT INTO DEPT_TEMP(DEPTNO, DNAME, LOC)
VALUES (70, 'WEB', NULL); 

INSERT INTO DEPT_TEMP(DEPTNO, DNAME, LOC)
VALUES (80, 'MOBILE', '');
SELECT*FROM DEPT_TEMP;


--�÷��� �������� ������ ��� �÷��� ���ϰ� ��
INSERT INTO DEPT_TEMP
VALUES (60, 'NETWORK', 'BUSAN');
SELECT * FROM DEPT_TEMP;

CREATE TABLE EMP_TEMP
AS SELECT * FROM EMP WHERE 1<>1;
SELECT * FROM EMP_TEMP;

INSERT INTO EMP_TEMP(EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
VALUES (9999, 'ȫ�浿', 'PRESIDENT', NULL, TO_DATE('07/01/2001', 'DD/MM/YYYY'), 5000, 1000, 10);
SELECT *FROM EMP_TEMP;

INSERT INTO EMP_TEMP(EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
VALUES (3111, '��û��', 'PRESIDENT', NULL, SYSDATE, 5000, 1000, 10);
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

--���� 3õ�̻��� ��� ���� ����
SELECT * FROM EMP_TEMP2
WHERE SAL >= 3000;

DELETE EMP_TEMP2
WHERE SAL >= 3000;
SELECT *FROM EMP_TEMP2;

-- ������ 1000������ ����� ���� 1.3% �λ�
SELECT * FROM EMP_TEMP2
WHERE SAL <= 1000;



UPDATE EMP_TEMP2
SET SAL = SAL*1.013
WHERE SAL <= 1000;
SELECT *FROM EMP_TEMP2;

CREATE TABLE DEPT_TCL
AS SELECT * FROM DEPT;

-- 10�� �μ� �����
-- 20�� �μ��� 50�� �μ��� �ٲٱ�
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

-- ������ empno�� index�� ����ϴϱ� plan Ȯ�� ����
select * from emp
where empno = 7900;

create index idx_emp_empno
on emp(empno desc);

-- �Ʒ� �ּ��� ���� hint
-- ������ �ε����� ����ϰ� ����
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
-- alter�� ���߿� ���� ������ �߰��ϴ� ���
-- primary key
alter table table_pk4
add primary key(login_id, login_pwd);
-- ���� �̸� �߰� 
alter table table_pk4
add constraint ���������̸� primary key (login_id, login_pwd);
-- ������ �����
alter table table_pk4
drop constraint ���������̸�;


create table table_pk5 (
    login_id varchar2(20),
    login_pwd varchar2(20),
    tel varchar2(20)
);
alter table table_pk5
modify login_id primary key;

-- �� ���̺� pk�� ������ ���� �� ��� ����
alter table table_pk5
add primary key (login_pwd);
-- �� ���̺� pk�� ������ ���� �� ��� ����
-- �̷� ��� ���� pk���� �� �õ��ؾ� ��.
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
-- �����ϰ� �־ ��������
drop table dept_fk;
-- dept.deptno�� 10�� ���� ������ ����
insert into emp_fk
values(1, '����1', 10);

insert into dept_fk
values(10, 'test_dname', 'test_loc');

insert into emp_fk
values(1, '����1', 10);

select * from dept_fk;
select * from emp_fk;

-- �������̾ ���� �ȵ�
delete dept_fk
where deptno = 10;

insert into dept_fk
values(20, 'test_dname2', 'test_loc2');
-- �����ϰ� �մ°� ��� ���� ���� ����
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

-- ROWNUM�� SELECT���� �����ϰ�,
-- ORDER BY�� SELECT ���Ŀ� ����
-- ORDER BY�� �ٽ� �������� �Ǽ� ������â�̴�.
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
