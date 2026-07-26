-- 각 회원별로 작성한 게시글 개수를 조회
SELECT member_id, count(*) -- 회원 번호(member_id) 조회, COUNT(*):각 그룹의 행 개수를 셉니다.
FROM post -- 게시글 테이블에서 조회
group by member_id; -- member_id가 같은 행끼리 그룹(묶음) 으로 묶습니다. ex)id가 1인 행 5개, id가 2인 행 3개 


-- 각 게시글 별로 댓글수 조회(댓글수로 내림차순 정렬)
select post_id, count(*) as reply_count -- post_id(게시글 아이디)를 조회합니다. COUNT(*):각 게시글의 댓글 수를 셉니다. reply_count는 별칭
from reply -- 댓글 테이블에서 조회
group by post_id -- post_id(게시글 아이디)가 같은 댓글끼리 묶습니다.
order by count(*) desc; -- ORDER BY : 정렬, COUNT(*) : 댓글 개수를 기준으로, DESC : 내림차순(큰 값 → 작은 값)
-- 즉, 각 게시글의 댓글 개수를 구한 뒤, 댓글이 많은 게시글부터 순서대로 보여준다.

-- 회원별로 작성한 게시글의 수, 총 조회수 조회 (게시글 오름차순, 조회수 내림차순 정렬)
select member_id, count(*) as post_count, sum(view_count) as total_views -- 회원 번호(member_id) 조회, COUNT(*) AS post_count(별칭, 게시글 개수): 회원이 작성한 게시글 개수를 셉니다. SUM(view_count) AS total_views:회원이 작성한 게시글들의 조회수를 모두 더합니다.
from post -- 게시글 테이블에서 조회
group by member_id -- 같은 회원이 작성한 게시글끼리 묶습니다.
order by post_count, total_views desc; -- ORDER BY: 정렬, post_count(게시글 개수)는 첫번째 기준이며 asc(오름차순)이 생략됨, total_views는 두번째 기준, 즉 두번째기준이란 첫번째 정렬에서 중복된 값의 데이터가 나오면 두번째 기준을 사용한다는 의미
-- total_views DESC는 총 조회수가 큰 사람부터(내림차순) 정렬


-- 가입 연도별 회원수 조회하기
select date_format(created_at, '%Y') as JOIN_YEAR, COUNT(*) join_count -- DATE_FORMAT(회원가입일, 연도4자리만 가져옴)은 날짜를 원하는 형식으로 바꾸는 함수, JOIN_YEAR(가입연도,별칭), COUNT(*):각 연도별 회원 수를 셉니다. join_count:가입수
from member -- 회원 테이블에서 조회
group by DATE_FORMAT(CREATED_AT, '%Y'); -- DATE_FORMAT(회원가입일, 연도4자리만 가져옴), GROUP BY: 묶기, 즉, 같은 연도끼리 묶습니다.


-- 회원별로 작성한 게시글의 수, 총 조회수 조회 (게시글이 5개 이상인 경우만)
select member_id, count(*) as post_count, sum(view_count) as total_views -- 회원 번호(member_id) 조회, count(*) as post_count:회원별 (게시글 개수, 별칭)를 셉니다, sum(view_count) as total_views:회원이 작성한 게시글 (총조회수, 별칭)를 모두 더합니다.
from post -- 게시글 테이블에서 조회
group by member_id -- 회원별로 게시글을 묶습니다.
having count(*) >= 5 -- 게시글 개수가 5개 이상인 그룹(회원)만 남겨라
order by post_count, total_views desc; -- 남아 있는 회원들을 게시글 개수 오름차순, 게시글 개수가 같으면 총 조회수 내림차순으로 정렬


-- 에러 발생: title이 GROUP BY 기준에 존재하지 않음
SELECT member_id, title, COUNT(*) AS post_count -- member_id(회원 아이디)와 title(게시글 제목)을 조회, (회원별) (게시글 개수, 별칭)를 셉니다.
    FROM post -- 게시글 테이블에서 조회
    GROUP BY member_id; -- 회원별로 게시글을 묶습니다.


-- 해결 방법 1: 집계 함수를 적용하여 단일 결과값으로 보장
SELECT member_id, MAX(title), COUNT(*) AS post_count -- member_id(회원 아이디)를 조회, MAX(): 가장 뒤에 있는 값 반환, MAX(title):title은 문자열이니까 가나다) 순으로 가장 뒤에 있는 값을 반환, 회원별 post_count(게시글 개수, 별칭)를 셉니다.
    FROM post -- 게시글 테이블에서 조회
    GROUP BY member_id; -- 회원별로 게시글을 묶습니다.


-- 해결 방법 2: group_concat을 사용해 여러 개의 title을 하나의 텍스트로 합침
SELECT member_id, GROUP_CONCAT(title separator ',') as concat_title, COUNT(*) AS post_count -- member_id(회원 아이디)를 조회, GROUP_CONCAT(title separator ','): 제목들을 SEPARATOR(구분자) ,로 붙여준다.
    FROM post -- 게시글 테이블에서 조회
    GROUP BY member_id; -- 회원별로 게시글을 묶습니다.


-- 해결 방법 3: 해당 컬럼도 GROUP BY 기준에 추가하여 공동 그룹으로 묶음
SELECT member_id, title, COUNT(*) AS post_count -- member_id(회원 번호)와 제목을 조회, 각 그룹의 post_count(게시글 개수, 별칭)를 셉니다.
    FROM post -- 게시글 테이블에서 조회
    GROUP BY member_id, title; -- 회원번호와 제목이 모두 같은 것끼리 묶습니다.


-- 게시글을 2개 이상 작성한 회원의 id와 게시글 수 조회
-- 에러 발생: 아직 그룹화되지 않은 상태인 WHERE 절에서 집계 함수 COUNT(*)를 사용하려 함
SELECT member_id, COUNT(*) -- member_id(회원 번호)를 조회, COUNT(*): 회원별 게시글 개수
    FROM post -- 게시글 테이블에서 조회
    WHERE COUNT(*) >= 2 -- 행의 개수가 2개 이상인 것만 조회하라.
    GROUP BY member_id; -- 회원별로 게시글을 묶습니다.


