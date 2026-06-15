-- 회원 이름과 이메일을 결합해서 조회
SELECT name, email, CONCAT(name, '(', email, ')') as member_info
FROM member;


-- 각 회원의 이메일 바이트 크기 조회
select email, LENGTH('hello'), LENGTH('안녕하세요'), LENGTH(email) as email_length
from member;


-- 게시글 본문 중 '안녕하세요'가 있는 내용을 찾아서 Hi로 수정
select content, replace(content  , '안녕하세요', 'Hi') as replaced_content
from post
where content like '%안녕하세요%';


-- 게시글 본문의 첫 10글자만 미리보기로 가져오기
-- 잘린 뒷부분은 ...으로 표시하세요.
select title, concat(substring(title, 1, 10), '...') as preview
from post;


-- 이메일을 소문자/대문자로 조회
select email, LOWER(email) as email_lower, UPPER(email) as email_upper
from member;


-- 이메일 앞뒤 공백 제거
select email, TRIM(email) as trimmed_email
from member;


-- 현재 날짜와 시간을 조회
select NOW() as current_datetime;


-- 게시글 작성일을 "연 월 일 요일 시 분 초" 형식으로 조회
select id, title, created_at, DATE_FORMAT(created_at, '%Y년 %m월 %d일 %a %H시 %i분 %s초') as write_date
from post;


-- 현재 날짜만 조회
select CURDATE() as curr_date;


-- 오늘 작성된 게시글만 조회
select id, title, created_at
from post
where created_at >= CURDATE();


-- 최근 7일 이내에 가입한 회원 조회**
select id, name, created_at, curdate(), date_sub(curdate(), interval 7 day) as before_7days
from member
where created_at >= date_sub(curdate(), interval 7 day);


-- 가입한 지 1개월이 지난 회원 조회**
select *, date_sub(CURDATE(), interval 1 month) as before_1month
from member
where created_at < date_sub(CURDATE(), interval 1 month);



-- 가입한 지 35일 12시간이 지난 회원 조회
SELECT *, DATE_SUB(CURDATE(), INTERVAL '35 12' DAY_HOUR) AS before_1month
FROM MEMBER
WHERE created_at < DATE_SUB(CURDATE(), INTERVAL '35 12' DAY_HOUR);


-- 각 회원의 가입 경과일수를 조회
select name, created_at, datediff(CURDATE(), created_at) as days_since_join
from member;


-- 모든 회원수 조회
select count(*)
from member;

-- 모든 게시글 수 조회
select count(*)
from post;



-- id=3인 회원의 모든 게시글의 총 게시글 수 조회
select member_id, count(*) as total_count
from post
where member_id=3;


-- id=3인 회원의 모든 게시글의 조회수 조회
select member_id, view_count
from post
where member_id=3;


-- id=3인 회원의 모든 게시글의 총 조회수
select member_id, count(*) as total_counts, sum(view_count) as total_views, avg(view_count) as avg_views
	, min(view_count) as min_views, max(view_count) as max_views
-- , title
from post
where member_id = 3;


-- 전화번호가 NULL인 회원은 '미등록'으로 표시하여 조회
SELECT name, ifnull(phone, '미등록') as phone
    FROM member;

-- 전화번호가 NULL이면 이메일을, 이메일도 NULL이면 '연락처 없음'으로 조회
select name, IFNULL(phone, IFNULL(email, '연락처 없음')) as contact
from member;
select name, coalesce(phone, email, '연락처 없음') as contact
from member;
select name, IF(phone is null, if(email is null, '연락처 없음', email), phone) as phone_status
from member;


-- 전화번호 등록 여부에 따라서 상태를 다르게 표시
select name, if(phone is null, '연락처 없음', '연락처 있음') as phone_status
from member;

-- 가입 연도가 1년이 넘었으면 '우수 회원', 1달이 넘었으면 '일반 회원', 그러지 않으면 '신규 회원'을 출력
select name, 
	   created_at,
	   case
	   	   when created_at < date_sub(now(), interval 1 year) then '우수 회원'
	   	   when created_at < date_sub(now(), interval 1 month) then '일반 회원'
	   	   else '신규 회원'
	   end as member_grade
from member;





