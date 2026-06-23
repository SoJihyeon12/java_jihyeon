-- 가장 오래된 회원의 가입일
select min(created_at) FROM MEMBER;


-- 회원 정보 조회
select * from member;


-- 가장 오래전에 가입한 회원의 정보 조회(하드코딩)
select *
from member
where created_at = '2025-05-10 12:13:45';



-- 가장 오래전에 가입한 회원의 정보 조회
select *
from member
where created_at = (select min(created_at) FROM member);


-- 게시글을 하나라도 작성한 회원의 id 추출
select distinct member_id from post where member_id is not null;


-- id가 1, 2인 회원 조회
select *
from member
where id in (1, 2);


-- 게시글을 하나라도 작성한 회원의 정보 조회
select *
from member
where id in (select distinct member_id from post where member_id is not null);



-- 게시글 조회(id, title)
select id, title from post;


-- 1번 게시글의 댓글 수 조회
select count(*) from reply where post_id = 1;


-- 각 게시글과 함께 해당 게시글의 댓글 수 조회(서브 쿼리)
select id, title, (select count(*) from reply where post_id = post.id) as reply_count
from post;


-- 각 게시글과 함께 해당 게시글의 댓글 수 조회(조인)
select p.id, p.title, count(r.id)
from post p
left join reply r on p.id = r.post_id
group by p.id, p.title;


-- 게시글을 하나라도 작성한 회원의 id 추출
select distinct member_id from post where member_id is not null;



-- 게시글을 한 건이라도 작성한 회원의 게시글 수 조회
select member_id, count(*) as cnt
from post
where member_id is not null
group by member_id;


-- 게시글을 한 건이라도 작성한 회원의 평균 게시글 수 조회
select avg(cnt)
from (
	select member_id, count(*) as cnt
	from post
	where member_id is not null
	group by member_id
) as sub;


-- 게시글을 한 건이라도 작성한 회원의 평균 게시글 수보다 많은 글을 작성한 회원의 게시글 수 조회
select member_id, count(*) as post_count
from post
where member_id is not null
group by member_id
having count(*) > (
	select avg(cnt)
	from (
		select member_id, count(*) as cnt
		from post
		where member_id is not null
		group by member_id
	) as sub
);


select 1 from post where member_id = 6;




