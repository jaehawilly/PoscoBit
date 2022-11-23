-- 64)
insert into sample(aa, bb) values(1, 2);
insert into sample(aa, bb) values(3, 4);
insert into sample(aa, bb) values(5, 6);
select * from sample;



-- 63) group by ~~별로, 조건 : having
drop table tableA;
CREATE TABLE tableA (
	dept	varchar(10),
    salary 	int
);
-- 부서별로
insert into tableA values('개발', 800);
insert into tableA values('행정', 200);
insert into tableA values('영업', 400);
insert into tableA values('개발', 500);
insert into tableA values('행정', 300);
select dept, sum(salary) 
from tableA
group by dept;
-- 급여가 300 이상인 직원들의 그룹별 정보를 얻는다
select dept, sum(salary)
from tableA
where salary>=300 -- select를 제한
group by dept;

select dept, sum(salary)
from tableA
group by dept
having sum(salary)>450;

select dept, sum(salary)
from tableA
where salary>=300 -- select를 제한
group by dept
having sum(salary)>1000; -- 그룹핑된 결과 제한







-- 62)
drop table tableA;
CREATE TABLE tableA (
	no		int,
    name	VARCHAR(20),
    salary 	int
);
insert into tableA values(10, ' 호랑이 ', 1000);
insert into tableA values(20, ' 호랑이 ', 2000);
insert into tableA values(30, ' 호랑이 ', 3000);
select case no
	when 10 then 'test1'
    when 20 then 'test2'
    when 30 then 'test3'
    end as 급여
from tableA;
select case no
	when 10 then salary*1.1
    when 20 then salary*1.2
    when 30 then salary*1.3
    end as 급여
from tableA;





-- 61)
drop table tableA;
CREATE TABLE tableA (
	no		int,
    name	VARCHAR(20)
);
insert into tableA values(null, ' 호랑이 ');
insert into tableA values(1, null);
select * from tableA;

select 100 + no, name from tableA;
select 100 + ifnull(no, 0), ifnull(name, '익명') from tableA;



-- 60)
select 10+20 from dual; -- 30
select 10+'20' from dual; -- 30
select '10'+20 from dual; -- 30
select '10'+'20' from dual; -- 30
select 'ti'+'ger' from dual; -- 0
select 'ti' || 'ger' from dual; -- 0



-- 59)
select round(1234.4) from dual;
select round(1234.5) from dual; -- 반올림
select round(1234.5678, 2) from dual; -- 반올림 자릿수
select round(1234, -1) from dual; -- 일의자릿수 반올림
select round(1235, -1) from dual; -- 일의자릿수 반올림

select truncate(1234.5678, 1) from dual; -- truncate는 사사오입X, 무조건 내림
select truncate(1234.5578, 1) from dual;
select truncate(1234, -1) from dual;
select truncate(1235, -1) from dual;

select ceil(3.14) from dual; -- 올림 -- 4
select floor(3.14) from dual; -- 내림 --3
select ceil(-3.14) from dual; -- 올림 -- -3
select floor(-3.14) from dual; -- 내림 -- -4

-- mod(15/2) >> X
select floor(15/2), mod(15,2) from dual; -- 몫, 나머지

select sysdate() from dual;




-- 59)
drop table tableA;
CREATE TABLE tableA (
	no		int,
    tel		VARCHAR(20)
);
insert into tableA values(1, ' 호랑이 ');
insert into tableA values(2, '호 랑 이');
insert into tableA values(3, '_호랑이_');
insert into tableA values(3, '호_랑_이');
-- 양쪽에 있는 특정 문자를 제거할때 사용(디폴트는 space)
select trim(tel) from tableA;
select trim('_' from tel) from tableA;
select ltrim(tel) from tableA;
select rtrim(tel) from tableA;






-- 58)
drop table tableA;
CREATE TABLE tableA (
	no		int,
    tel		VARCHAR(20)
);
insert into tableA values(1, '800606-1109244');
insert into tableA values(1, '800607-1109244');
insert into tableA values(1, '800608-1109244');
select * from tableA;

select rpad('800606-', 14, '*') from tableA;
select rpad(substr(tel, 1, 7), 14, '*') from tableA;
select lpad(tel, 10, ' ') from tableA;
select concat(no, ':') from tableA;
select concat(no, tel) from tableA;
select concat(no, concat(':', tel)) from tableA;
select concat(no, ':', tel) from tableA; -- mysql에서만 적용됨




-- 57) replace
drop table tableA;
CREATE TABLE tableA (
	no		int,
    tel		VARCHAR(20)
);
insert into tableA values(1, '호랑이-만세');
insert into tableA values(1, '만세-호랑이');
insert into tableA values(1, '만-호랑이-세');
select * from tableA;

select replace(tel, '호랑이', '코끼리') from tableA;
select replace(tel, '-', '') from tableA;




-- 56) substr
drop table tableA;
CREATE TABLE tableA (
	no		int,
    tel		VARCHAR(20)
);
insert into tableA values(1, '02)123-3455');
insert into tableA values(1, '051)123-3455');
insert into tableA values(1, '0321)123-3455');

select substr(tel, 5, 3), substr(tel, 9) from tableA;
-- 이런저런 조건으로 영화 제목을 출력하세요.
-- 단, 제목이 길 경우에는 앞의 4자리까지만 출력하세요
select instr(tel, '호랑이') from tableA;

select substr(tel, 1, instr(tel, ')')-1) from tableA;



-- 55)
drop table tableA;
CREATE TABLE tableA (
	id	INT NOT NULL AUTO_INCREMENT,
    name	VARCHAR(10),
    no		int,
    salary	int,
    PRIMARY KEY (id));
insert into tableA values(null, 'tiger1', 10, 100);
insert into tableA values(null, 'Tiger2', 20, 200);
insert into tableA values(null, 'tigeR3', 20, 200);
insert into tableA values(null, 'tiger4', 20, 200);
insert into tableA values(null, 'lion4', 20, 200);
select * from tableA;
select upper(name) from tableA; -- 대문자로 출력
select lower(name) from tableA; -- 소문자로 출력
-- select initcap(name) from tableA; -- mysql에서는 지원안됨(첫글자만 대문자)

select * from tableA
where upper(name) = 'TIGER1';

select * from tableA
where upper(name) like 'TIGER%';

select length(name) from tableA;
select * from tableA
where length(name)>3;




-- 54) 
-- union : 합집합(중복제거)
-- union all : 합집합(중복허용)
-- intersect : 교집합
-- minus : 차집합
drop table tableA;
CREATE TABLE tableA (
	id	INT NOT NULL AUTO_INCREMENT,
    name	VARCHAR(10),
    no		int,
    salary	int,
    PRIMARY KEY (id));
insert into tableA values(null, '일길동', 10, 100);
insert into tableA values(null, '이길동', 20, 200);
drop table tableB;
CREATE TABLE tableB (
	id	INT NOT NULL AUTO_INCREMENT,
    name	VARCHAR(10),
    no		int,
    salary	int,
    PRIMARY KEY (id));
insert into tableB values(null, '이길동', 30, 300);
insert into tableB values(null, '삼길동', 40, 400);

select * from tableA
where salary < 150
union
select * from tableB
where salary > 350;

select * from tableA
union all
select * from tableB;

-- 
select * from tableA							-- 일길동, 이길동
where name not in(select name from tableB);		-- (이길동, 삼길동)






-- 53)
/*
<학생테이블>				<과목테이블>					<점수테이블>
학번(sno) : PK			과목번호(cno) : PK			학번(sno) : FK
이름(name)				과목이름(name)				과목번호(cno) : FK
학과(major)											점수(result)
*/
drop table tableA;
CREATE TABLE tableA ( -- 학생테이블
    sno		int,
    name 	VARCHAR(20),
    major	VARCHAR(20)
);
drop table tableB;
CREATE TABLE tableB ( -- 과목테이블
    cno		int,
    name 	VARCHAR(20)
);
drop table tableC;
CREATE TABLE tableC ( -- 점수테이블
    sno		int,
    cno		int,
    result 	int
);
insert into tableA values(1000, '홍길동', '컴공');
insert into tableA values(1001, '이순신', '디자인');
insert into tableA values(1002, '강감찬', '컴공');
insert into tableA values(1003, '안중근', '디자인');

insert into tableB values(10, '국어');
insert into tableB values(11, '영어');
insert into tableB values(12, '수학');

insert into tableC values(1000, 10, 91);
insert into tableC values(1000, 11, 92);
insert into tableC values(1000, 12, 93);
insert into tableC values(1001, 10, 94);
insert into tableC values(1001, 11, 95);
insert into tableC values(1001, 12, 96);

select * from tableA;
select * from tableB;
select * from tableC;

select t1.name, t2.name, t3.result
from tableA t1, tableB t2, tableC t3
where t1.sno=t3.sno
and t2.cno=t3.cno;

select *
	from tableA t1
	join tableC t3 on(t1.sno = t3.sno)
	join tableB t2 on(t2.cno = t3.cno);

select *
	from tableA t1
	join tableC t3 on(t1.sno = t3.sno)
	join tableB t2 on(t2.cno = t3.cno)
where major = '컴공';

select t1.name, t2.name, t3.result
from tableA t1, tableB t2, tableC t3
where t1.sno=t3.sno
    and t2.cno=t3.cno
	and major = '컴공';



-- 52)
-- 1형식 : 안시 조인
select * from tableA t1
	join tableB t2
    on t1.no=t2.no;
-- 2형식 : 일반 조인
select * from tableA t1, tableB t2
where t1.no=t2.no;
-- 3형식 : 자연 조인
select * from tableA
	natural join tableB;
-- 4형식 : using 조인
select * from tableA
	join tableB using(no);





-- 51) 외부 조인
drop table tableA;
CREATE TABLE tableA (
    id		int,
    name 	VARCHAR(10)
);
drop table tableB;
CREATE TABLE tableB (
    id		int,
    age 	int
);
insert into tableA values(1, 'tiger01');
insert into tableA values(2, 'tiger02');
insert into tableA values(3, 'tiger03');
insert into tableA values(4, 'tiger04');
insert into tableA values(5, 'tiger05');

insert into tableB values(3, 30);
insert into tableB values(4, 40);
insert into tableB values(5, 50);
insert into tableB values(6, 60);
insert into tableB values(7, 70);

select * from tableA t1, tableB t2
where t1.id = t2.id;

select * from tableA t1
	left join tableB t2
    on t1.id=t2.id;
    
select * from tableA t1
	right join tableB t2
    on t1.id=t2.id;






-- 50) 세미조인
-- 메뉴 테이블
drop table menu;
CREATE TABLE menu (
    foodnum	int,
    name VARCHAR(10)
);
insert into menu values(1, '짜장');
insert into menu values(2, '우동');
insert into menu values(3, '냉면');
insert into menu values(4, '탕슉');
insert into menu values(5, '양장');
select * from menu;
-- 판매 테이블
drop table sell;
CREATE TABLE sell (
    no		int,	-- 판매번호
    count 	int,	-- 판매수량
    foodNum	int 	-- 판매된 음식번호
);
insert into sell values(1, 2, 1);
insert into sell values(2, 3, 2);
insert into sell values(3, 4, 2);
insert into sell values(4, 2, 2);
insert into sell values(5, 2, 1);

-- 1. 판매가 된 제품 번호가 몇번인가?
select s.foodNum from sell s;

-- 2. 
select name from menu m
-- where m.foodNum=1 or m.foodNum=2;
-- where m.foodNum in(1, 2);
-- where m.foodNum in(1, 2, 2, 2, 1);
where m.foodNum in(select s.foodNum from sell s);

-- 3. 세미 조인
-- 실행속도가 더 빠르다
select * from menu m
where exists(
	select * from sell s
    where m.foodNum = s.foodNum
);

-- 3. 안티 조인(세미 조인에 not을 붙인 개념)
select * from menu m
where not exists(
	select * from sell s
    where m.foodNum = s.foodNum
);




-- 49)
drop table tableA;
CREATE TABLE tableA (
	id_a	INT NOT NULL AUTO_INCREMENT,
    name	VARCHAR(10),	-- 학생 이름
    PRIMARY KEY (id_a));
insert into tableA values(null, '홍길동');
insert into tableA values(null, '이순신');
insert into tableA values(null, '안중근');
insert into tableA values(null, '임꺽정');
insert into tableA values(null, '김서방');
insert into tableA values(null, '이순신');
insert into tableA values(null, '김서방');
insert into tableA values(null, '강감찬');
insert into tableA values(null, '이순신');
select * from tableA;

-- 동명이인 찾기
select count(*) from tableA t1, tableA t2;
select distinct( t1.name ) from tableA t1, tableA t2
where t1.id_a != t2.id_a
and t1.name=t2.name;



-- ex48) 셀프 조인
drop table tableA;
CREATE TABLE tableA (
	id_a	INT NOT NULL AUTO_INCREMENT,
    name	VARCHAR(10),	-- 학생 이름
    no		int,
    mgr		int,			-- 사수 번호
    salary	int,			
    PRIMARY KEY (id_a));
insert into tableA values(null, '홍길동', 1000, null, 100);
insert into tableA values(null, '이순신', 1001, 1000, 100);
insert into tableA values(null, '안중근', 1002, 1001, 100);
insert into tableA values(null, '임꺽정', 1003, 1002, 100);

-- 1) 반드시 별칭이 있어야 한다
select * from tableA t1, tableA t2;
-- 2) 
select * from tableA t1, tableA t2
where t1.no=t2.mgr;
-- 3)
select t1.name `이름`, t2.name `사수` from tableA t1, tableA t2
where t1.mgr=t2.no;




-- ex47) 비등가조인
-- 사원 정보
drop table tableA;
CREATE TABLE tableA (
	id_a	INT NOT NULL AUTO_INCREMENT,
    name	VARCHAR(10),
    eno		int,
    salary	int,
    PRIMARY KEY (id_a));
insert into tableA values(null, '홍길동', 20, 50);
insert into tableA values(null, '이순신', 10, 150);
insert into tableA values(null, '안중근', 30, 250);
insert into tableA values(null, '임꺽정', 20, 350);
insert into tableA values(null, '김서방', 20, 170);
insert into tableA values(null, '강감찬', 20, 370);

drop table tableB;
CREATE TABLE tableB (
	id_b		INT NOT NULL AUTO_INCREMENT,
    grade		VARCHAR(10),
    losalary 	int,
    hisalary 	int,
    PRIMARY KEY (id_b));
insert into tableB values(null, 'A', 300, 9999);
insert into tableB values(null, 'B', 200, 299);
insert into tableB values(null, 'C', 100, 199);
insert into tableB values(null, 'D', 0, 99);
select * from tableB;
-- 1
select name, grade from tableA t1
	inner join tableB t2
    on t1.salary >= t2.losalary
		and t1.salary <= t2.hisalary;
-- 2
select name, grade from tableA t1
	inner join tableB t2
    on salary between t2.losalary and t2.hisalary;
-- 3
select name, grade from tableA t1, tableB t2
where salary between t2.losalary and t2.hisalary;
-- 4
select name, grade from tableA t1, tableB t2
where salary between t2.losalary and t2.hisalary
and grade='A';




-- ex44)
-- 학생 테이블
drop table tableA;
CREATE TABLE tableA (
	id_a	INT NOT NULL AUTO_INCREMENT,
    eno		int,		 -- 학번
    name	VARCHAR(10), -- 학생이름
    major	VARCHAR(10), -- 전공 학과명
    year	int,		 -- 학년
    PRIMARY KEY (id_a));
insert into tableA values(null, 1000, '홍길동', '국어', 1);
insert into tableA values(null, 1001, '이순신', '화학', 1);
insert into tableA values(null, 1002, '안중근', '화학', 2);
insert into tableA values(null, 1003, '임꺽정', '국어', 2);
insert into tableA values(null, 1004, '강감찬', '화학', 1);
select * from tableA;

-- 시험점수 테이블
drop table tableB;
CREATE TABLE tableB (
	id_b	INT NOT NULL AUTO_INCREMENT,
    eno		VARCHAR(10), -- 학번
    cno		int,		 -- 시험 과목 번호
    result	int,		 -- 점수
    PRIMARY KEY (id_b));
insert into tableB values(null, 1000, 10, 59);
insert into tableB values(null, 1000, 20, 34);
insert into tableB values(null, 1001, 10, 80);
insert into tableB values(null, 1001, 20, 79);
insert into tableB values(null, 1001, 30, 33);
insert into tableB values(null, 1002, 10, 59);
insert into tableB values(null, 1003, 10, 59);
insert into tableB values(null, 1004, 10, 59);
select * from tableB;

-- 화학과 1학년 학생들의 점수를 검색하세요
select * from tableA t1
inner join tableB t2
on t1.eno=t2.eno
where t1.major='화학' and t1.year=1;

-- ex45) 자연조인 : 양쪽 테이블에 컬럼명이 동일한 것이 1개있다는 전제
select * from tableA
	natural join tableB
where year = 1;

-- ex46) using join : 컬럼명이 2개 이상일때
select * from tableA
	join tableB using(eno)
where year = 1;





-- ex43)
drop table tableA;
CREATE TABLE tableA (
	id		INT NOT NULL AUTO_INCREMENT,
    pno 	int,
	name 	VARCHAR(10),
    PRIMARY KEY (id));
insert into tableA values(null, 100, '홍길동');
insert into tableA values(null, 101, '이순신');
insert into tableA values(null, 102, '안중근');
insert into tableA values(null, 103, '임꺽정');
insert into tableA values(null, 104, '강감찬');
select * from tableA;

drop table tableB;
CREATE TABLE tableB (
	id		INT NOT NULL AUTO_INCREMENT,
    name	VARCHAR(10), -- 과목명
    num		int,		 -- 학점
    pno		int,		 -- 담당 교수 번호
    PRIMARY KEY (id));
insert into tableB values(null, '국어', 4, 103);
insert into tableB values(null, '영어', 3, 104);
insert into tableB values(null, '수학', 2, 102);
insert into tableB values(null, '사회', 1, 101);
insert into tableB values(null, '체육', 2, 103);
insert into tableB values(null, '생물', 2, 102);
select * from tableB;
-- 모대학에서 2학점인 과목을 검색하고, 이 과목을 강의하는 교수이름을 출력하세요
select t1.name, t2.name from tableA t1
inner join tableB t2
on t1.pno = t2.pno
where num=2;




-- ex39) 교차조인(cross join): 데카르트 곱, 카테시안 곱
drop table tableA;
CREATE TABLE tableA (
	id		INT NOT NULL AUTO_INCREMENT,
    name 	VARCHAR(16), -- 이름
    no		int,		 -- 사번
	salary 	int,		 -- 급여
    PRIMARY KEY (id));
insert into tableA values(null, '홍길동', 20, 1000);
insert into tableA values(null, '이순신', 10, 2000);
insert into tableA values(null, '안중근', 30, 3000);
insert into tableA values(null, '임꺽정', 20, 4000);
select * from tableA;

drop table tableB;
CREATE TABLE tableB (
	id		INT NOT NULL AUTO_INCREMENT,
    no		int,
	job 	VARCHAR(16),
    PRIMARY KEY (id));
insert into tableB values(null, 10, '장군');
insert into tableB values(null, 20, '의적');
insert into tableB values(null, 30, '의사');
select * from tableB;
-- 교차조인(일반적인 조인 방식)
select * from tableA, tableB;
-- 명시적인 안시 조인 방법
select * from tableA CROSS JOIN tableB;

-- 내부조인(외부조인이 아닌 것)
-- 사용을 잘못하고 있는 문장이다(항상 조건을 달아줘야 한다)
select * from tableA INNER JOIN tableB;

-- 내부조인, 등가조인( != 비등가조인 )
select *
from tableA 
INNER JOIN tableB
on tableA.no = tableB.no; -- 조인 조건

select tableA.name, tableB.job 
from tableA 
INNER JOIN tableB
on tableA.no = tableB.no;

-- 급여가 3000이상인 사람의 직업은 무엇인가?
select *
from tableA 
	INNER JOIN tableB
	on tableA.no = tableB.no -- 조인 조건
where salary >= 3000;		 -- 필터 조건(검색 조건)

-- 일반조인
select * from tableA, tableB
where tableA.no = tableB.no 
and salary >= 3000;


-- ex40) 별칭사용(리네임)
select * from tableA t1, tableB t2
where t1.no = t2.no
and t1.salary >= 3000;
-- and salary >= 3000;

-- 컬럼명이 중복되면 별칭은 반드시 명시해야한다.
select name, t1.no, t2.id from tableA t1, tableB t2
where t1.no = t2.no
and t1.salary >= 3000;
-- and salary >= 3000;

-- ex41) 문장을 잘못 사용하고 있다.
select * from tableA
	cross join tableB
    on tableA.no = tableB.no;

-- on 조건이 빠져있다
select * from tableA
	inner join tableB
    -- on ......
where tableA.no = tableB.no;

-- ex41) 이순신의 직업은 무엇입니까?
-- 등가조인을 이용한 방법
select name, job from tableA t1, tableB t2
where t1.no = t2.no
and t1.name='이순신';

select no from tableA where name = '이순신';

-- 서브쿼리를 이용한 방법
select job 
from tableB
where no = (
	select no 
    from tableA 
    where name = '이순신'
);




-- ex38) mysql : 관계형 데이터베이스
-- 테이블과 테이블의 관계
-- 연동시키는 과정을 조인이라고 한다.

-- 교차조인, 내부조인, 등가조인(비등가조인)
-- 자연조인, Using 조인, 셀프조인, 세미조인(안티조인)
-- 외부조인, 안시조인, 일반조인



-- ex37) 통계함수 : min, max, avg, sum, count >> 통계
-- 분산(variance), 표준편차(stddev)
drop table table13;
CREATE TABLE table13 (
	id		INT NOT NULL AUTO_INCREMENT,
    eno		int,		 -- 부서 번호
    name 	VARCHAR(16), -- 부서 소속 이름
	salary 	int,		 -- 급여
    PRIMARY KEY (id));
insert into table13 values(null, 10, '호랑이1', 100);
insert into table13 values(null, 20, '호랑이2', 200);
insert into table13 values(null, 30, '호랑이3', 300);
insert into table13 values(null, 40, '호랑이4', 400);
insert into table13 values(null, 10, '호랑이5', 500);
-- variance : 분산, stddev : 표준편차
select sum(salary), avg(salary), min(salary), max(salary),
	variance(salary), stddev(salary)
from table13;
-- 급여가 가장 많은 직원의 이름은 무엇인가?
select name from table13 
where salary = (
	select max(salary)
    from table13
);



-- example question)
-- 문제 : 컴공과에서 제일 낮은 점수를 받은 학생보다 성적이 낮은 학생들을 출력하세요.
/*
컴공 40
컴공 20 >> 제일 낮은 학생
컴공 50
중국 80
중국 70
중국 10 >>> 결과
일어 40
일어 5  >>> 결과
*/


-- ex)
drop table table12;
CREATE TABLE table12 (
	id		INT NOT NULL AUTO_INCREMENT,
    eno		int,		 -- 부서 번호
    name 	VARCHAR(16), -- 부서 소속 이름
	salary 	int,		 -- 급여
    PRIMARY KEY (id));
insert into table12 values(null, 10, '호랑이1', 100);
insert into table12 values(null, 20, '호랑이2', 200);
insert into table12 values(null, 30, '호랑이3', 300);
insert into table12 values(null, 40, '호랑이4', 400);
insert into table12 values(null, 10, '호랑이5', 500);
insert into table12 values(null, 20, '호랑이6', 600);
insert into table12 values(null, 30, '호랑이7', 700);
insert into table12 values(null, 10, '호랑이8', 800);
insert into table12 values(null, 20, '호랑이9', 350);
insert into table12 values(null, 30, '호랑이10', 999);
select * from table12;
-- 20번 부서의 급여를 모두 검색한다.
select * from table12
where eno=20;
-- 20번 부서의 최고 급여는 얼마인가? 600
select max(salary) from table12
where eno=20;
-- 20번 부서의 최고 급여를 받는 사람의 이름은 무엇인가? (서브쿼리)
select name from table12
where salary = (
	select max(salary) 
    from table12
	where eno=20
);
-- 20번 부서의 최고 급여를 받는 사람보다 적은 급여를 받는 사람의 이름은 무엇인가? (서브쿼리)
select name from table12
where salary < (
	select max(salary) 
    from table12
	where eno=20
);
select * from table12
where salary < any(
	select salary 
    from table12
	where eno=20 -- 200, 600, 350(이 중 최댓값보다 작은 것)
);
select * from table12
where salary < any(
	select salary 
    from table12
	where eno=20 -- 200, 600, 350(이 중 최댓값보다 작은 것)
) and eno != 20;





-- ex36) all, any
-- 개발 부서에서 최고월급을 받는 사람보다 낮은 월급을 받는 직원.
-- 개발 부서에서 최고월급을 받는 사람보다 높은 월급을 받는 직원.
-- 개발 부서에서 최저월급을 받는 사람보다 높은 월급을 받는 직원.
-- 개발 부서에서 최저월급을 받는 사람보다 낮은 월급을 받는 직원.
drop table table11;
CREATE TABLE table11 (
	id		INT NOT NULL AUTO_INCREMENT,
    name 	VARCHAR(16), -- 부서 소속 이름
    dept 	VARCHAR(16), -- 부서 이름
	salary 	int,		 -- 급여
    PRIMARY KEY (id));
insert into table11 values(null, '호랑이1', '경영', 100);
insert into table11 values(null, '호랑이2', '개발', 150);
insert into table11 values(null, '호랑이3', '영업', 300);
insert into table11 values(null, '호랑이4', '개발', 700);
insert into table11 values(null, '호랑이5', '영업', 500);
insert into table11 values(null, '호랑이6', '경영', 350);

/*
select *
from table11
where salary > any(300, 200, 250);
-- where salary > 200; 로 번역됨(min값)

where salary > all(300, 200, 250);
-- where salary > 300; 로 변역됨(max값)

where salary < any(300, 200, 250);
-- where salary < 300; 로 번역됨(max값)

where salary < all(300, 200, 250);
-- where salary < 200; 로 변역됨(min값)
*/




-- ex34)
drop table table10;
CREATE TABLE table10 (
	id		INT NOT NULL AUTO_INCREMENT,
    name 	VARCHAR(16), -- 부서 소속 이름
    dept 	VARCHAR(16), -- 부서 이름
	salary 	int,		 -- 급여
    PRIMARY KEY (id));
insert into table10 values(null, '호랑이1', '경영', 100);
insert into table10 values(null, '호랑이2', '개발', 150);
insert into table10 values(null, '호랑이3', '영업', 300);
insert into table10 values(null, '호랑이4', '개발', 700);
insert into table10 values(null, '호랑이5', '영업', 500);
insert into table10 values(null, '호랑이6', '경영', 350);

select * 
from table10 
where salary>=200 and salary<=600;
select * 
from table10 
where salary between 200 and 600;
-- where 학점 between 4.0 and 4.5;
-- 밑의 코드를 선호

-- ex35) in
select * 
from table10 
where dept='개발' or dept='경영';
select * 
from table10 
where dept in ('개발', '경영');



-- ex33)
drop table table09;
CREATE TABLE table09 (
	id		INT NOT NULL AUTO_INCREMENT,
    name 	VARCHAR(16), -- 부서 소속 이름
	grade 	int,
    PRIMARY KEY (id));
insert into table09 values(null, '김유신', 1);
insert into table09 values(null, '이순신', 1);
insert into table09 values(null, '김서', 2);
insert into table09 values(null, '남궁옥분', 3);
insert into table09 values(null, '홍길동', 1);
insert into table09 values(null, '김국', 1);
-- 1학년 중에서 김씨 성을 가진 사람을 출력하세요
select name from table09 where name like '김%' and grade=1;
-- 1학년 중에서 김씨는 몇명인가?
select count(name) from table09 where name like '김%' and grade=1;
-- 성과 이름이 2글자(외자 이름)인 사람은?
select * from table09 where name like '__';
-- 성과 이름이 3글자가 아닌 사람은?
select * from table09 where name not like '___';




-- ex32) like
drop table table08;
CREATE TABLE table08 (
	id		INT NOT NULL AUTO_INCREMENT,
    name 	VARCHAR(16), -- 부서 소속 이름
	salary 	int,		 -- 급여
    PRIMARY KEY (id));
insert into table08 values(null, '스타벅스', 100);
insert into table08 values(null, '올스타노래방', 150);
insert into table08 values(null, '강남만두', 300);
insert into table08 values(null, '스타일미용실', 700);
insert into table08 values(null, '닭다리스타', 500);
insert into table08 values(null, '짬뽕천국', 350);
select * from table08
where name like '스타%'; -- 스타벅스, 스타일미용실

select * from table08
where name like '%스타'; -- 닭다리스타

select * from table08
where name like '%스타%'; -- 스타벅스, 올스타노래방, 스타일미용실, 닭다리스타

select count(name) from table08
where name like '스타%'; -- 2






-- ex31) and, or
drop table table07;
CREATE TABLE table07 (
	id		INT NOT NULL AUTO_INCREMENT,
    name 	VARCHAR(16), -- 부서 소속 이름
    dept 	VARCHAR(16), -- 부서 이름
	salary 	int,		 -- 급여
    PRIMARY KEY (id));
insert into table07 values(null, '호랑이1', '경영', 100);
insert into table07 values(null, '호랑이2', '개발', 150);
insert into table07 values(null, '호랑이3', '영업', 300);
insert into table07 values(null, '호랑이4', '개발', 700);
insert into table07 values(null, '호랑이5', '영업', 500);
insert into table07 values(null, '호랑이6', '경영', 350);
insert into table07 values(null, '호랑이7', '개발', 250);
insert into table07 values(null, '호랑이8', '영업', 450);
insert into table07 values(null, '호랑이9', '개발', 550);
select * from table07;
-- 영업부서에서 급여가 350 이상인 직원 명단을 출력하세요.
select * 
from table07 
where dept='영업' and salary>=350;

select * 
from table07 
where dept='영업' or salary<150;

select * 
from table07 
where salary>=140 and salary<=350;

select * 
from table07 
where salary<160 and salary>600;




-- ex30)
drop table table06;
CREATE TABLE table06 (
	id		INT NOT NULL AUTO_INCREMENT,
    name 	VARCHAR(16),
    kor 	int,
	eng 	int,
	mat 	int,
    PRIMARY KEY (id));
insert into table06 values(null, '호랑이1', 66, 100, 80);
insert into table06 values(null, '호랑이2', 80, 70, 92);
insert into table06 values(null, '호랑이3', 98, 30, 76);
insert into table06 values(null, '호랑이4', 77, 80, 67);
insert into table06 values(null, '호랑이5', 75, 50, 99);
select name, kor + eng + mat as total
from table06
order by total desc;

-- ex31) (=, !=, >, >=, <, <=)
-- 국어점수가 80점 이상인 회원을 모두 조회하세요.
select name from table06 where kor>=80;

-- 평균 점수가 80점 이상인 회원을 모두 조회하세요.
select * from table06 where (kor+eng+mat)/3 >= 80;
select name, (kor+eng+mat)/3 as total from table06 where (kor+eng+mat)/3 >= 80;

-- select에서 정의된 별칭은 where에서 사용할 수 없다.
-- 참고 : 테이블 이름을 별칭으로 정의할 수 있는데 이때 만든 별칭은 where에서 사용할 수 있다.
-- 될 것 같은데 안되는 쿼리문
-- select name, (kor+eng+mat)/3 as total from table06 where total >= 80;



-- ex29)
drop table table05;
CREATE TABLE table05 (
	id		INT NOT NULL AUTO_INCREMENT,
    name 	VARCHAR(16), -- 부서 소속 이름
    dept 	VARCHAR(16), -- 부서 이름
	salary 	int,		 -- 급여
    PRIMARY KEY (id));
insert into table05 values(null, '호랑이1', '경영', 100);
insert into table05 values(null, '호랑이2', '개발', 150);
insert into table05 values(null, '호랑이3', '영업', 300);
insert into table05 values(null, '호랑이4', '개발', 700);
insert into table05 values(null, '호랑이5', '영업', 500);
insert into table05 values(null, '호랑이6', '경영', 350);
insert into table05 values(null, '호랑이7', '개발', 250);
insert into table05 values(null, '호랑이8', '영업', 450);
insert into table05 values(null, '호랑이9', '개발', 550);

-- 부서별로 순차정렬해서 나타내고, 급여를 역순정렬해서 출력하세요.
select * from table05 order by dept, salary desc;

-- oo별로~~( 나라별로, 부서별로, 성별로, 지역별로, 학과별로)
-- 1. order by(단순 검색) 2. group by(통계자료를 뽑고 싶을때)



-- ex28)
drop table table04;
CREATE TABLE table04 (
	id			INT NOT NULL AUTO_INCREMENT,
    country 	VARCHAR(16),
    gold 		int,
	silver 		int,
    PRIMARY KEY (id));
insert into table04 values(null, '한국', 10, 10);
insert into table04 values(null, '중국', 4, 8);
insert into table04 values(null, '일본', 2, 9);
insert into table04 values(null, '미국', 7, 7);
insert into table04 values(null, '독일', 7, 3);
-- 오름차순, 순차정렬(asc 생략 가능)
-- table 자체를 수정하는 것이 아니다
select * from table04 order by gold;
select * from table04 order by gold asc;
-- 내림차순 정렬(큰 값부터)
select * from table04 order by gold desc, silver desc;



-- ex27) 중복 제거된 목록 조회
drop table table03;
CREATE TABLE table03 (
	id			INT NOT NULL AUTO_INCREMENT,
    name 		VARCHAR(16),
    country 	VARCHAR(16),
    PRIMARY KEY (id));
insert into table03 values(null, '호랑이1', '한국');
insert into table03 values(null, '호랑이2', '중국');
insert into table03 values(null, '호랑이3', '중국');
insert into table03 values(null, '호랑이4', '한국');
insert into table03 values(null, '호랑이5', '일본');
insert into table03 values(null, '호랑이4', '한국');
insert into table03 values(null, '호랑이5', '일본');
insert into table03 values(null, '호랑이5', null);
select * from table03;
select distinct(name) from table03;
select count(distinct(country)) from table03;

-- ex26) 학점을 100점대로 환산
drop table table02;
CREATE TABLE table02 (
	id		INT NOT NULL AUTO_INCREMENT,
    name 	VARCHAR(16),
    result 	float,
    PRIMARY KEY (id));
insert into table02 values(null, '호랑이1', 4.5); -- 100
insert into table02 values(null, '호랑이2', 3.7); -- ??
insert into table02 values(null, '호랑이3', 2.7);
insert into table02 values(null, '호랑이4', 4.2);
insert into table02 values(null, '호랑이5', 4.1);
select * from table02;
select result `학점`, 100 * result / 4.5 `100점대환산` from table02;
-- 4.5 : 100 = x : y
-- 100 * x = 4.5 * y
-- 100 * x / 4.5 = y


-- ex24)
drop table table01;
CREATE TABLE table01 (
	id	INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(16),
    salary INT,
    bonus INT,
    PRIMARY KEY (id));
insert into table01 values(null, '호랑이1', 100, 10);
insert into table01 values(null, '호랑이2', 200, null);
insert into table01 values(null, '호랑이3', 300, 40);
insert into table01 values(null, '호랑이4', 400, 30);
insert into table01 values(null, '호랑이5', 500, null);
select * from table01;

select count(*) from table01 where bonus is null;

select salary * 12 + bonus as 연봉 from table01;
select salary * 12 + ifnull(bonus, 0) as 연봉 from table01;

-- 25) null인 필드를 0으로 수정(갱신)
update table01 set bonus=0 where bonus is null;
select * from table01;


-- ex23) null 검색
select * from table01;
insert into table01 values(null, '호랑이', 20, null);
-- 문장이 성립안된다.
select * from table01 where salary=null;
-- 이렇게 is null, is not null를 써야 한다.
select * from table01 where salary is null;
select * from table01 where salary is not null;

select name `급여를 받는 직원`
from table01 
where salary is not null;

-- ex22) 단순 산술식을 사용하거나 날짜를 표현할때(dual=빈 공간 임의의 db)
select 3*5 as 곱셈 from dual;
select sysdate() 날짜 from dual;
select 9+2, 9-2, 9*2, 9/2, 9%2 오칙연산 from dual;


-- ex21) 필드 연결이 필요한 경우
select * from table01;
select concat(name, salary) as 이름급여 from table01;
select concat(name, '님의 급여는 ', salary, '입니다') as 이름급여 from table01;


-- ex20) 컬럼명(필드명)을 별명(별칭)을 붙여서 사용할 수 있다. as(생략가능)
select 
    name as 이름, 
    salary * 0.1 as 보너스, 
    salary + salary*0.1 as 실수령액
from table01;

select 
    name 이름, 
    salary * 0.1 보너스, 
    salary + salary*0.1 실수령액
from table01;

-- 공백이 있는 경우 `(백쿼트)를 써야한다
select 
    name `이   름`,
	salary `연  봉`
from table01;


-- ex19) 산술식 사용 가능
select * from table01;
select 
	id, name, age, salary, salary,
    salary * 0.1, salary + salary*0.1
from table01;
-- 일반적으로 윗문장보다 아랫문장을 권장


-- ex18)선택적으로 필드 선택 가능
select * from table01;
select id from table01;
select id, salary from table01;


-- ex17)
select * from city limit 0, 3;
select * from city limit 3;
select * from city limit 2, 3;

-- ex16) sakila db test
select * from city;
select count(*) from city;

-- ex15) row 개수를 얻는다
select count(*) from table01;


-- ex14)
-- 방법1) 묵시적 방법(Field명을 명시하지 않았기 때문 : 모든 Field값을 채워야함)
insert into table01 values(null, '호랑이', 20, 3000);

-- 방법2) 명시적 방법(Field 개수와 순서에 관계없다)
insert into table01(name, id) values('호랑이', null);


-- ex13) CRUD(Delete)
delete from table01 where name='소나무';
delete from table01;

-- ex12) CRU(Update)D
-- update table01 set age=99;
-- id == 2(X), id = 2(O)
update table01 set age=88 where id=2;
update table01 set name='안중근' where age=88;
update table01 set name='소나무', age=77 where id=1;

-- ex11) CR(Read)UD
-- *(모든) : 와일드카드
select * from table01;

-- ex10) C(Create)RUD
insert into table01 values(null, '홍길동', 20, 3000);


-- ex9) 테이블 컬럼(Field) 확인
desc table01;

-- ex8) 테이블 삭제
drop table table01; 

-- ex7) 테이블 조회
show tables;

-- ex6) 테이블 생성
/*
CREATE TABLE table01 (
	id	INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(45) NULL,
    age INT NULL,
    salary INT NULL,
    PRIMARY KEY (id));
*/

-- ex5) db 삭제
drop database db02;

-- ex4) db 조회
show databases;

-- ex3) db 생성
create database db02;

-- ex2) 실행키 : Ctrl+Enter, Ctrl+Shift+Enter

-- ex1) 주석 : --, /* */
/* 주석 */