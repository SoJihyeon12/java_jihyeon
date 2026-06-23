-- 모든 게시글의 모든 컬럼 조회
SELECT * FROM post;


-- 모든 게시글의 member_id, title, view count 컬럼 조회
select id, member_id, title, view_count from post;

-- INNER JOIN
-- 모든 게시글의 id, member_id, title, view_count, 작성자이름, 작성자이메일 컬럼 조회
select post.id, member_id, title, view_count, member.id, member.name, member.email
from post
inner join member on post.member_id = member.id;


-- 모든 게시글의 id, member_id, title, view_count, 작성자이름, 작성자이메일 컬럼 조회(alias 사용)
select p.id, p.member_id, p.title, p.view_count, m.name, m.email
from post p
inner join member as m on p.member_id = m.id;


-- 모든 댓글 조회
select * from reply;

-- 모든 댓글의 id, content, member_id, post_id 조회
select id, content, member_id, post_id from reply;


-- 모든 댓글의 id, content, member_id, post_id, 작성자이름, 게시글제목 조회
select reply.id, reply.content, reply.member_id, reply.post_id, member.name, post.title
from reply
inner join member on reply.member_id = member.id
inner join post on reply.post_id = post.id;


-- 게시글 기준으로 정렬
select post.title 게시글, reply.content 댓글, member.name 댓글작성자
from reply
inner join member on reply.member_id = member.id
inner join post on reply.post_id = post.id
order by post.id desc, reply.id;


-- LEFT OUTER JOIN
-- 모든 게시글의 id, member_id, title, view_count, 작성자이름, 작성자이메일 컬럼 조회(alias 사용)
select p.id, p.member_id, p.title, p.view_count, m.name, m.email
from post p
left join member as m on p.member_id = m.id;


-- 전체 회원 목록과 각 회원이 작성한 게시글 수를 조회하세요.(게시글을 작성하지 않은 회원도 포함되어야 함)
-- 전체 회원 목록 조회
select * from member;
-- 필요한 컬럼만 추출
select m.id, m.name, count(p.id) post_count
from member m
left join post p on m.id = p.member_id
group by m.id, m.name;


-- RIGHT OUTER JOIN
-- 모든 게시글의 id, member_id, title, view_count, 작성자이름, 작성자이메일 컬럼 조회(alias 사용)
select p.id, p.member_id, p.title, p.view_count, m.name, m.email
from post p
RIGHT join member as m on p.member_id = m.id;


-- 모든 게시글의 id, member_id, title, view_count, 작성자이름, 작성자이메일 컬럼 조회(alias 사용)
select p.id, p.member_id, p.title, p.view_count, m.name, m.email
from member m
left join post as p on p.member_id = m.id;


-- FULL OUTER JOIN(MySQL은 지원하지 않으므로 UNION으로 대체 가능)
select m.id as member_id, m.name, p.title
from member m
left join post p on m.id = p.member_id
union 
select m.id as member_id, m.name, p.title
from member m
right join post p on m.id = p.member_id;



-- SELF JOIN
-- 회원명과 추천인명을 조회
select m1.name 회원명, m1.recommender_id, ifnull(m2.name, '-') 추천인명 
from member m1
left join member m2 on m1.recommender_id = m2.id; -- 모든 회원명과 추천인명을 조회
-- inner join member m2 on m1.recommender_id = m2.id; -- 추천인이 있는 회원명과 추천인명을 조회

















