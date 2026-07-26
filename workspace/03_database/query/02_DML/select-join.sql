-- 모든 게시글의 모든 컬럼 조회
SELECT * FROM post; -- select:조회, *: 모든 컬럼, from post: 게시글 테이블에서 조회


-- 모든 게시글의 member_id, title, view count 컬럼 조회
select id, member_id, title, view_count from post; -- id 번호표, 회원아이디, 제목, 조회수, from post: 게시글 테이블에서 조회

-- INNER JOIN
-- 모든 게시글의 id, member_id, title, view_count, 작성자 번호, 작성자이름, 작성자이메일 컬럼 조회
select post.id, member_id, title, view_count, member.id, member.name, member.email
from post -- from post: 게시글 테이블에서 조회
inner join member on post.member_id = member.id; -- member 테이블을 연결합니다. on(다음조건을 만족할 때 연결해라.),post.member_id = member.id: 게시글의 member_id와 회원의 id가 같은 행끼리 연결해라.


-- 모든 게시글의 id, member_id, title, view_count, 작성자이름, 작성자이메일 컬럼 조회(alias 사용)
select p.id, p.member_id, p.title, p.view_count, m.name, m.email -- p.id: 게시글의 번호표, p.member_id: 게시글의 회원아이디, 게시글의 제목, 게시글의 조회수, 회원이름, 회원 이메일
from post p -- from post: 게시글 테이블에서 조회
inner join member as m on p.member_id = m.id; -- inner join member as m: 회원 테이블을 연결하라 이때 회원테이블을 m이라고 부르겠다. ON p.member_id = m.id: 게시글의 작성자 번호(member_id)와 회원의 번호(id)가 같은 데이터를 연결하라.


-- 모든 댓글 조회
select * from reply; -- reply: 댓글

-- 모든 댓글의 id, content, member_id, post_id 조회
select id, content, member_id, post_id from reply; -- 번호표, 내용, 회원번호, 게시글번호 조회


-- 모든 댓글의 id, content, member_id, post_id, 작성자이름, 게시글제목 조회
select reply.id, reply.content, reply.member_id, reply.post_id, member.name, post.title
from reply -- 댓글 테이블에서 조회
inner join member on reply.member_id = member.id -- 댓글의 작성자 번호(reply.member_id)와 회원 번호(member.id)를 함께 조회하기 위해 회원테이블과 댓글테이블을 연결한다.
inner join post on reply.post_id = post.id; -- 댓글의 게시글 번호(reply.post_id)와 게시글 번호(post.id)가 같은 데이터를 기준으로 게시글 테이블과 댓글 테이블을 연결한다.


-- 게시글 기준으로 정렬
select post.title 게시글, reply.content 댓글, member.name 댓글작성자 -- post.title 게시글 은 post.title AS 게시글과 같음, 게시글 제목과 댓글내용, 회원이름을 조회한다.
from reply -- 댓글 테이블에서 조회
inner join member on reply.member_id = member.id -- 댓글의 작성자 번호(reply.member_id)와 회원 번호(member.id)를 함께 조회하기 위해 회원테이블과 댓글테이블을 연결한다.
inner join post on reply.post_id = post.id -- 댓글의 게시글 번호(reply.post_id)와 게시글 번호(post.id)가 같은 데이터를 기준으로 게시글 테이블과 댓글 테이블을 연결한다.
order by post.id desc, reply.id; -- 게시글 번호(post.id)를 기준으로 내림차순으로 정렬하고, 게시글 번호가 같은 경우에는 댓글 번호(reply.id)를 기준으로 오름차순(asc 생략가능해서 안쓴듯)으로 정렬한다.


-- LEFT OUTER JOIN
-- 모든 게시글의 id, member_id, title, view_count, 작성자이름, 작성자이메일 컬럼 조회(alias 사용)
select p.id, p.member_id, p.title, p.view_count, m.name, m.email -- 게시글 아이디, 게시글 회원아이디, 게시글 제목, 게시글 조회수, 회원이름, 회원이메일 조회한다.
from post p -- post(게시글) 테이블에 p라는 별칭(Alias)을 붙여 사용한다
left join member as m on p.member_id = m.id; -- left join member as m: member 테이블을 m이라는 이름으로 사용하면서 왼쪽 외부 조인한다. 게시글 테이블의 회원아이디와 회원 테이블의 번호표(id)가 같은 데이터를 연결한다.
-- LEFT JOIN(왼쪽 외부 조인)이란? 왼쪽 테이블의 모든 데이터를 먼저 가져오고, 오른쪽 테이블에 일치하는 데이터가 있으면 함께 붙여서 조회하는 조인입니다.

-- 전체 회원 목록과 각 회원이 작성한 게시글 수를 조회하세요.(게시글을 작성하지 않은 회원도 포함되어야 함)
-- 전체 회원 목록 조회
select * from member; -- 회원 테이블에서 전체 조회
-- 필요한 컬럼만 추출
select m.id, m.name, count(p.id) post_count -- 회원아이디, 회원 이름, 게시글 테이블의 게시글 번호(id)가 몇 개인지 세고 post_count라는 별칭을 붙인다.
from member m -- 멤버 테이블에서 조회, 이때 멤버를 m이라고 칭하겠다.
left join post p on m.id = p.member_id -- post 테이블을 p라는 별칭으로 사용하여 왼쪽 외부 조인하고, 회원 번호(m.id)와 게시글 작성자 번호(p.member_id)가 같은 데이터를 연결한다.
group by m.id, m.name; -- 회원 번호(m.id)와 회원 이름(m.name)을 기준으로 데이터를 그룹(묶음)으로 만든다는 뜻


-- RIGHT OUTER JOIN
-- 모든 게시글의 id, member_id, title, view_count, 작성자이름, 작성자이메일 컬럼 조회(alias 사용)
select p.id, p.member_id, p.title, p.view_count, m.name, m.email -- 게시글 아이디, 게시글의 회원아이디, 게시글제목, 게시글의 조회수, 회원이름, 회원이메일 조회하기
from post p -- post(게시글) 테이블에 p라는 별칭(Alias)을 붙여 사용한다
RIGHT join member as m on p.member_id = m.id; -- member 테이블을 m이라는 별칭으로 사용하여 오른쪽 외부 조인하고, 게시글 작성자번호(p.member_id)와 회원 번호(m.id)가 같은 데이터를 연결한다.


-- 모든 게시글의 id, member_id, title, view_count, 작성자이름, 작성자이메일 컬럼 조회(alias 사용)
select p.id, p.member_id, p.title, p.view_count, m.name, m.email
from member m -- 멤버 테이블에서 조회, 이때 멤버를 m이라고 칭하겠다.
left join post as p on p.member_id = m.id; -- post 테이블을 p라는 별칭으로 사용하여 왼쪽 외부 조인하고, 게시글의 작성자 번호(p.member_id)와 회원 번호(m.id)가 같은 데이터를 연결한다.


-- FULL OUTER JOIN(MySQL은 지원하지 않으므로 UNION으로 대체 가능)
select m.id as member_id, m.name, p.title -- m.id(회원아이디)를 member_id로 칭하겠다. 회원이름, 게시글 제목 조회
from member m -- 멤버 테이블에서 조회, 이때 멤버를 m이라고 칭하겠다.
left join post p on m.id = p.member_id -- post 테이블을 p라는 별칭으로 사용하여 왼쪽 외부 조인하고, 회원 번호(m.id)와 게시글 작성자 번호(p.member_id)가 같은 데이터를 연결한다.
union -- 첫 번째 SELECT의 결과와 두 번째 SELECT의 결과를 하나로 합친다.
select m.id as member_id, m.name, p.title -- 회원아이디를 member_id로 칭한다. 회원이름, 게시글제목을 조회한다.
from member m -- 멤버 테이블에서 조회, 이때 멤버를 m이라고 칭하겠다.
right join post p on m.id = p.member_id; -- post 테이블을 p라는 별칭으로 사용하여 오른쪽 외부 조인하고, 회원 번호(m.id)와 게시글 작성자 번호(p.member_id)가 같은 데이터를 연결한다.



-- SELF JOIN
-- 회원명과 추천인명을 조회
select m1.name 회원명, m1.recommender_id, ifnull(m2.name, '-') 추천인명 -- 회원 이름을 조회하고 컬럼명을 '회원명'으로 표시한다. m1은 회원 테이블의 첫 번째 별칭이라는 뜻, m1.recommender_id:회원 테이블의 추천인의 회원 번호를 조회한다. ifnull(m2.name, '-') 추천인명: 추천인 이름(m2.name)이 있으면 그 이름을 출력하고, 없으면 '-'를 출력한다.
from member m1 -- 회원 테이블에서 조회, m1으로 칭하겠다.
left join member m2 on m1.recommender_id = m2.id; -- 모든 회원명과 추천인명을 조회, member 테이블을 m2라는 별칭으로 사용하여 왼쪽 외부 조인하고, 회원의 추천인 번호(m1.recommender_id)와 추천인의 회원 번호(m2.id)가 같은 데이터를 연결한다.
-- inner join member m2 on m1.recommender_id = m2.id; -- 추천인이 있는 회원명과 추천인명을 조회

















