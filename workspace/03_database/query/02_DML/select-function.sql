-- 회원 이름과 이메일을 결합해서 조회
SELECT name, email, CONCAT(name, '(', email, ')') as member_info -- SELECT : 조회하다, CONCAT (Concatenate) : 이어 붙이다. CONCAT(name, '(', email, ')') -> 홍길동(abc@gmail.com), AS : ~라는 이름으로
FROM member; -- 회원의 이름과 이메일을 하나의 문자열로 합쳐서 출력합니다. 이 문자열 데이터는 member_info라는 항목을 새로 생성하여 귀속됨


-- 각 회원의 이메일 바이트 크기 조회
select email, LENGTH('hello'), LENGTH('안녕하세요'), LENGTH(email) as email_length -- SELECT: 조회한다, LENGTH('hello'): 'hello'라는 문자열의 byte 길이 구하는 함수, LENGTH('안녕하세요')도 마찬가지로 문자열의 바이트 수(길이) 반환
from member; -- LENGTH(email) as email_length: 문자열의 바이트 길이가 아닌 각 회원의 이메일 값을 가져와서 길이를 계산합니다. 이때 결과를 LENGTH(email)처럼 하지말고 AS email_length, AS : ~라는 이름으로, email_length라는 이믈으로 출력됨
-- from member: 회원 테이블에서

-- 게시글 본문 중 '안녕하세요'가 있는 내용을 찾아서 Hi로 수정
select content, replace(content  , '안녕하세요', 'Hi') as replaced_content -- SELECT: 조회한다, REPLACE: 교체하다. content: 게시글 내용, replace(content, '안녕하세요', 'Hi')-> '안녕하세요' 부분을 'Hi'로 바꿈,데이터는 실제로 변경되지 않음
from post -- from post: 게시글 테이블에서
where content like '%안녕하세요%'; -- WHERE: 데이터가 어디에 있다는 조건을 건다. ~에 있는 데이터를(조회한다), where content: 게시글 내용에, LIKE: 문자열(패턴을) 검색, 즉, 게시글 내용에 '안녕하세요'가 들어 있는 모든 게시글을 찾음


-- 게시글 본문의 첫 10글자만 미리보기로 가져오기
-- 잘린 뒷부분은 ...으로 표시하세요.
select title, concat(substring(title, 1, 10), '...') as preview -- SELECT: 조회한다, CONCAT (Concatenate) : 이어 붙이다. substring(title, 1, 10): 게시글 제목의 첫번째글자부터 10글자만 가져오기,'...'을 붙인다.
from post; -- as: alias, 별칭, 즉, as preview: 미리보기라는 별칭의 항목의 데이터로 출력, -- from post: 게시글 테이블에서


-- 이메일을 소문자/대문자로 조회
select email, LOWER(email) as email_lower, UPPER(email) as email_upper -- SELECT: 조회한다, LOWER()소문자로 바꾼다,as email_lower라는 별칭으로, UPPER()대문자로 바꾼다.as email_upper라는 별칭으로
from member; -- from member: 회원 테이블에서


-- 이메일 앞뒤 공백 제거
select email, TRIM(email) as trimmed_email -- SELECT: 조회한다, TRIM:잘라내다=앞뒤 공백 제거, as trimmed_email한 별칭으로
from member; -- from member: 회원 테이블에서


-- 현재 날짜와 시간을 조회
select NOW() as current_datetime; -- NOW(): 2026-07-23 20:30:15처럼 날짜+시간 모두 가져옵니다.


-- 게시글 작성일을 "연 월 일 요일 시 분 초" 형식으로 조회
select id, title, created_at, DATE_FORMAT(created_at, '%Y년 %m월 %d일 %a %H시 %i분 %s초') as write_date -- id:번호표, title: 게시글 제목 created_at : 회원가입 시간 DATE_FORMAT():날짜 형식 변경
from post; -- from post: 게시글 테이블에서


-- 현재 날짜만 조회
select CURDATE() as curr_date; -- CURDATE(): Current Date, 현재 날짜. curr_date라는 별칭으로


-- 오늘 작성된 게시글만 조회
select id, title, created_at
from post -- from post: 게시글 테이블에서
where created_at >= CURDATE(); -- created_at : 회원가입 시간, CURDATE(): 오늘이 2026-07-23이라면 2026-07-23 자정(밤12시) 이후 작성된 글만 조회


-- 최근 7일 이내에 가입한 회원 조회**
select id, name, created_at, curdate(), date_sub(curdate(), interval 7 day) as before_7days -- created_at : 회원가입 시간, curdate(): 현재날짜(시각:자정), SUB = Subtract(빼다), DATE_SUB = 날짜에서 빼기, INTERVAL(간격) : 뺄 기간
from member -- date_sub(curdate(), interval 7 day): 오늘날짜에서 7일을 뺀다. 즉, 최근 7일간(이내)의 데이터 조회, -- from member: 회원 테이블에서
where created_at >= date_sub(curdate(), interval 7 day); -- WHERE : 조건을 건다, created_at: 회원가입 시간, DATE_SUB = 날짜에서 빼기, 최근 7일 이내 가입한 회원 데이터를 조회


-- 가입한 지 1개월이 지난 회원 조회**
select *, date_sub(CURDATE(), interval 1 month) as before_1month -- *: member 테이블의 모든 컬럼을 조회, date_sub(CURDATE(), interval 1 month): 오늘 날짜에서 1개월을 뺀 날짜의 데이터 조회, before_1month라는 별칭으로
from member -- member 테이블에서 조회
where created_at < date_sub(CURDATE(), interval 1 month); -- WHERE : 조건을 건다, created_at: 회원가입 시간, DATE_SUB = 날짜에서 빼기, 가입한지 1개월이 지난 회원 데이터를 조회



-- 가입한 지 35일 12시간이 지난 회원 조회
SELECT *, DATE_SUB(CURDATE(), INTERVAL '35 12' DAY_HOUR) AS before_1month -- *: member 테이블의 모든 컬럼을 조회, DATE_SUB = 날짜에서 빼기, INTERVAL(간격), '35 12' DAY_HOUR: 35일(DAY), 12시간(HOUR), before_1month 별칭
FROM member -- member(회원) 테이블에서 조회
WHERE created_at < DATE_SUB(CURDATE(), INTERVAL '35 12' DAY_HOUR); -- WHERE : 조건을 건다, 회원가입한 지 35일 12시간이 지난 회원 조회


-- 각 회원의 가입 경과일수를 조회
select name, created_at, datediff(CURDATE(), created_at) as days_since_join -- created_at: 회원가입 시간, DIFF(Difference), datediff:날짜차이, datediff(CURDATE(), created_at): 현재날짜와 회원가입일 날짜차이
from member; -- days_since_join :join(가입일로부터) 며칠인지, 


-- 모든 회원수 조회
select count(*) -- COUNT: 개수세기, *: 모든
from member; -- member(회원) 테이블에서 조회

-- 모든 게시글 수 조회
select count(*) -- COUNT: 행(Row)의 개수세기, *: 모든
from post; -- 게시글 테이블에서 조회



-- id=3인 회원의 모든 게시글의 총 게시글 수 조회
select member_id, count(*) as total_count -- 회원 번호(member_id)를 조회, 모든 게시글 수 조회, total_count라는 별칭으로
from post -- 게시글 테이블에서 조회
where member_id=3; -- (조건) 회원 번호가 3인 게시글만 선택한다.


-- id=3인 회원의 모든 게시글의 조회수 조회
select member_id, view_count -- 회원 번호(member_id), view_count: 조회수
from post -- 게시글 테이블에서 조회
where member_id=3; -- (조건) 회원 번호가 3인 게시글만 선택한다.


-- id=3인 회원의 모든 게시글의 총 조회수
select member_id, -- 회원 번호를 조회한다.
count(*) as total_counts, -- 모든 행의 개수를 셉니다.(조건은 아래 where에), total_counts라는 별칭으로
sum(view_count) as total_views, -- 모든 값(조회수)을 더하는 함수, 별칭
avg(view_count) as avg_views, -- 모든 값(조회수)의 평균을 구하는 함수, 별칭
min(view_count) as min_views, -- 모든 값(조회수)의 최솟값을 구하는 함수, 별칭
max(view_count) as max_views -- 모든 값(조회수)의 최댓값을 구하는 함수, 별칭
-- , title
from post -- 게시글 테이블에서 조회
where member_id = 3; -- (조건) 회원 번호가 3인 게시글만 선택한다.


-- 전화번호가 NULL인 회원은 '미등록'으로 표시하여 조회
SELECT name, ifnull(phone, '미등록') as phone -- 회원의 이름(name) 을 조회합니다. ifnull(값, 대체값): 값이 NULL이면 대체값을 출력하고, NULL이 아니면 원래 값을 출력한다.
    FROM member; -- member(회원) 테이블에서 조회

-- 전화번호가 NULL이면 이메일을, 이메일도 NULL이면 '연락처 없음'으로 조회, contact는 연락이라는 별칭, phone_status는 폰 상태라는 별칭
select name, IFNULL(phone, IFNULL(email, '연락처 없음')) as contact -- 회원의 이름(name) 을 조회합니다. 안쪽 ifnull부터 해석하면 email이 있으면 → email 출력, email이 NULL이면 → "연락처 없음", 바깥ifnull: phone이 있으면 → phone 출력, phone이 NULL이면 → 위에서 계산한 결과(email 또는 연락처 없음)를 출력 
from member; -- member(회원) 테이블에서 조회
select name, coalesce(phone, email, '연락처 없음') as contact -- phone이 있으면 phone, 없으면 email, email도 없으면 "연락처 없음"을 출력합니다. 위에 ifnull 결과와 같음
from member; -- member(회원) 테이블에서 조회
select name, IF(phone is null, if(email is null, '연락처 없음', email), phone) as phone_status -- email이 NULL이면 → "연락처 없음", email이 있으면 → email 출력, phone이 NULL이면 email출력, phone이 null이 아니면 phone 출력 위의 coalesce 결과와 같음
from member; -- member(회원) 테이블에서 조회


-- 전화번호 등록 여부에 따라서 상태를 다르게 표시
select name, if(phone is null, '연락처 없음', '연락처 있음') as phone_status -- 회원의 이름(name) 을 조회합니다. phone이 NULL이면 → "연락처 없음", phone이 NULL이 아니면 → "연락처 있음" 출력,
from member; -- member(회원) 테이블에서 조회

-- 가입 연도가 1년이 넘었으면 '우수 회원', 1달이 넘었으면 '일반 회원', 그러지 않으면 '신규 회원'을 출력
select name, -- 회원의 이름(name)과 회원가입일을 조회합니다.
	   created_at,
	   case -- CASE는 조건에 따라 다른 값을 출력하는 조건문, if-else와 비슷
	   	   when created_at < date_sub(now(), interval 1 year) then '우수 회원' -- NOW():현재 날짜와 시간을 가져옵니다. date_sub(NOW(), INTERVAL 1 YEAR):현재 날짜에서 1년을 뺀 날짜, 즉, 가입한 지 1년 이상이면 '우수회원'출력
	   	   when created_at < date_sub(now(), interval 1 month) then '일반 회원' -- 가입한 지 1개월 이상이면 '일반회원'출력
	   	   else '신규 회원' -- 위 조건에 모두 해당하지 않으면 가입한 지 1개월 미만이므로 '신규 회원' 출력
	   end as member_grade -- CASE의 결과 컬럼 이름을 member_grade(회원등급)라는 별칭으로 표시
from member; -- member(회원) 테이블에서 조회





