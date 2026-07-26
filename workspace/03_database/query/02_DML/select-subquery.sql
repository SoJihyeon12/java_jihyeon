-- 가장 오래된 회원의 가입일
select min(created_at) FROM MEMBER; -- 회원 테이블에서 created_at 값 중 가장 작은(가장 이른(빠른)) 날짜와 시간을 조회한다.


-- 회원 정보 조회
select * from member; -- 회원 테이블에서 모든 정보 조회


-- 가장 오래전에 가입한 회원의 정보 조회(하드코딩)
select * -- 회원 테이블에서 모든 정보 조회
from member
where created_at = '2025-05-10 12:13:45'; -- 단, 회원가입시점이 '2025-05-10 12:13:45'이어야 함



-- 가장 오래전에 가입한 회원의 정보 조회
select * -- 회원 테이블에서 모든 정보 조회
from member
where created_at = (select min(created_at) FROM member); -- (서브쿼리문): 회원 테이블에서 가장 오래된 가입 날짜를 구한다. 가장 오래전에 가입한 회원만 조회됩니다.
-- 이것은 서브쿼리이다. 서브쿼리의 조건은 "괄호 안에 SELECT문이 있는 것"

-- 게시글을 하나라도 작성한 회원의 id 추출
select distinct member_id from post where member_id is not null; -- distinct: 중복된 값을 하나만 남기고 제거한다. 즉, 게시글 테이블에서 member_id가 있는(= NULL이 아닌) 회원 번호를 중복 없이 조회한다.


-- id가 1, 2인 회원 조회
select * -- 모든 컬럼(정보)을 조회한다.
from member -- 회원(member) 테이블에서 조회한다.
where id in (1, 2); -- IN: 괄호 안에 있는 여러 값 중 하나와 일치하는지 확인한다. 즉, id가 1이거나 2이면 조회한다.


-- 게시글을 하나라도 작성한 회원의 정보 조회
select * -- 모든 컬럼(정보)을 조회한다.
from member -- 회원(member) 테이블에서 조회한다.
where id in (select distinct member_id from post where member_id is not null); -- 이 부분은 서브쿼리(Subquery)와 IN 연산자를 함께 사용한 조건, 즉, 회원 번호(id)가 게시글을 작성한 회원 번호 목록에 포함된 회원만 조회한다.



-- 게시글 조회(id, title)
select id, title from post; -- 게시글 테이블의 번호표, 제목 조회


-- 1번 게시글의 댓글 수 조회
select count(*) from reply where post_id = 1; -- 게시글 번호(post_id)가 1인 게시글의 댓글 개수를 조회하는 쿼리


-- 각 게시글과 함께 해당 게시글의 댓글 수 조회(서브 쿼리)
select id, title, (select count(*) from reply where post_id = post.id) as reply_count -- ():댓글의 post_id와 현재 조회 중인 게시글의 id가 같은 댓글만 세라. 즉, 현재 게시글에 달린 댓글의 개수를 구한다.reply_count로 칭한다.
from post; -- 게시글 테이블에서 조회


-- 각 게시글과 함께 해당 게시글의 댓글 수 조회(조인)
select p.id, p.title, count(r.id) -- 게시글 번호, 게시글 제목, COUNT(r.id): 댓글 번호의 개수를 센다. 즉, 각 게시글에 달린 댓글의 개수를 센다.
from post p -- 게시글 테이블에서 조회 별칭 p
left join reply r on p.id = r.post_id -- 댓글 테이블을 r이라는 별칭으로 왼쪽 외부 조인한다, 게시글 번호(p.id)와 댓글의 게시글 번호(r.post_id)가 같으면 연결한다.
group by p.id, p.title; -- 게시글 번호와 제목별로 그룹을 만든다.


-- 게시글을 하나라도 작성한 회원의 id 추출
select distinct member_id from post where member_id is not null; -- DISTINCT: 중복된 값을 제거하고 하나만 조회한다. 게시글 테이블에서 member_id가 있는(= NULL이 아닌) 게시글의 작성자 번호를 중복없이 조회한다.



-- 게시글을 한 건이라도 작성한 회원의 게시글 수 조회
select member_id, count(*) as cnt -- 회원 번호를 조회, COUNT(*):각 회원이 작성한 게시글의 개수를 센다. 이때 게시글 개수를 cnt라는 별칭으로 선언
from post -- 게시글 테이블에서 조회
where member_id is not null -- 작성자가 있는 게시글만 조회한다.
group by member_id; -- 회원 번호별로 그룹을 만든다.


-- 게시글을 한 건이라도 작성한 회원의 평균 게시글 수 조회, 먼저 회원별 게시글 작성 개수(cnt)를 구한 뒤, 그 개수들의 평균을 계산하는 쿼리이다.
select avg(cnt) -- cnt 값들의 평균을 계산한다.
from (
	select member_id, count(*) as cnt -- 회원아이디를 조회한다. 회원마다 게시글을 몇 개 작성했는지 계산합니다.
	from post -- 게시글 테이블에서 조회합니다.
	where member_id is not null -- 작성자가 없는 게시글(NULL)은 제외합니다.
	group by member_id -- 회원 번호별로 그룹을 만듭니다.
) as sub;
-- FROM ( ... ) AS sub는 괄호 안의 조회 결과를 하나의 임시 테이블(sub)처럼 사용한다는 뜻


-- 게시글을 한 건이라도 작성한 회원의 평균 게시글 수보다 많은 글을 작성한 회원의 게시글 수 조회(서브쿼리 사용함)
select member_id, count(*) as post_count -- 회원 번호와 게시글 개수를 조회한다.
from post -- 게시글 테이블에서 조회합니다.
where member_id is not null -- 작성자가 없는 게시글은 제외합니다.
group by member_id -- 회원 번호별로 그룹을 만듭니다.
having count(*) > ( -- HAVING COUNT(*) > (...): 게시글 개수가 평균보다 큰 그룹만 남긴다.
	select avg(cnt) -- 회원별 게시글 개수(cnt)의 평균을 구한다.
	from (                       -- FROM ( ... ): 괄호 안의 조회 결과를 하나의 임시 테이블처럼 사용한다.
		select member_id, count(*) as cnt -- 회원 번호를 조회, COUNT(*):각 회원이 작성한 게시글의 개수를 센다. 이때 게시글 개수를 cnt라는 별칭으로 선언
		from post -- 게시글 테이블에서 조회합니다.
		where member_id is not null -- 작성자가 없는 게시글(NULL)은 제외합니다.
		group by member_id -- 회원 번호별로 그룹을 만듭니다.
	) as sub -- sub는 임시 테이블의 이름(별칭) 입니다.
);


select 1 from post where member_id = 6; -- 게시글 테이블에 회원 번호가 6인 게시글이 존재하는지 확인하는 쿼리이다.




