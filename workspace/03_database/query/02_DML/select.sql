-- 전체 회원의 이름과 가입일 조회
SELECT name, created_at
    FROM member; -- 회원 테이블에서 조회

-- 전체 회원의 모든 컬럼 조회
SELECT *
    FROM member; -- 회원 테이블에서 조회

-- 별칭을 사용하여 컬럼명을 가독성 있게 표현
SELECT name, created_at AS 가입일 -- 회원이름과 회원가입일을 조회, 회원가입일은 가입일로 별칭 선언
    FROM member; -- 회원 테이블에서 조회

-- 게시글을 작성한 모든 회원 ID 조회
SELECT member_id
    FROM post; -- 게시글 테이블에서 조회

-- 게시글을 작성한 회원 ID 목록을 중복 없이 조회
SELECT DISTINCT member_id -- DISTINCT: 중복된 값을 제거하고 한 번만 조회할 때 사용
    FROM post; -- 게시글 테이블에서 조회



-- 특정 이메일을 사용하는 회원 정보 조회
SELECT id, name -- 번호표와 이름
    FROM member -- 회원 테이블에서 조회
    WHERE email = 'haru@gmail.com'; -- 조건: 특정한 이메일 사용해야 함

-- 제목에 '게시글'이라는 단어가 들어간 모든 글 조회
SELECT id, title
    FROM post
    WHERE title LIKE '%게시글%';

-- 이름이 '하'로 시작해서 두글자인 모든 회원 조회
SELECT id, name
    FROM member
    WHERE name LIKE '하_'; -- LIKE: 특정한 문자열 패턴과 일치하는 데이터를 찾는다. '하_': 하 + 아무 문자 1개

-- member_id가 1번, 3번, 5번인 회원이 작성한 게시글만 선별하여 조회
SELECT id, title, member_id
    FROM post
    WHERE member_id IN (1, 3, 5); -- 회원 번호(member_id)가 1 또는 3 또는 5인 행만 조회한다.

-- 2026년 6월 1일부터 2026년 6월 20일 사이에 가입한 회원 조회
SELECT id, name, created_at
    FROM member
    WHERE created_at BETWEEN '2026-06-01' AND '2026-06-20 23:59:59'; -- BETWEEN A AND B: A 이상이고 B 이하인 값을 조회합니다. created_at은 데이터가 생성된 날짜와 시간을 저장하는 컬럼이라 '2026-06-01'은 2026-06-01 00:00:00로 처리

-- 전화번호 컬럼 값이 입력되지 않고 비어있는(NULL) 회원 조회
SELECT id, name
    FROM member
    WHERE phone IS NULL;


-- 가장 최근에 가입한 회원 순서로 정렬하여 조회
SELECT id, email, name, created_at
    FROM member
    ORDER BY created_at desc, name asc; -- 조회 결과를 생성일(created_at) 기준으로 내림차순 정렬하고, 생성일이 같으면 이름(name)을 오름차순으로 정렬하는 의미입니다.
;
-- 다중 컬럼 정렬: 이름 오름차순 정렬 후, 동일한 이름은 가입일 내림차순으로 2차 정렬
SELECT id, name, created_at
    FROM member
    ORDER BY name ASC, created_at DESC; -- 이름(name)을 먼저 오름차순으로 정렬하고, 이름이 같으면 생성일(created_at)을 내림차순으로 정렬


-- 가장 최근에 작성된 게시글 2개만 조회
SELECT id, title, created_at
    FROM post
    ORDER BY created_at desc -- 생성일(created_at)을 기준으로 최신 날짜부터 정렬한다.
    LIMIT 2; -- 정렬된 결과에서 처음 2개의 행만 가져온다. 즉, 가장 위의 2개 데이터만 조회한다.

-- 페이징 처리: 한 페이지에 2건씩, 2페이지 조회 (3번째~4번째 행)
SELECT id, title, created_at
    FROM post
    ORDER BY created_at desc -- 생성일(created_at)을 기준으로 최신 날짜부터 정렬한다.
    LIMIT 2, 2; -- 조회 결과에서 처음 2개 행은 제외하고, 그다음 2개 행만 가져온다.





-- 로그인 체크
select * from member where email = 'haru@gmail.com' and password = '123'; -- 이메일이 haru@gmail.com이고 비밀번호가 123인 회원의 모든 정보를 조회한다.
select * from member where email = 'haru@gmail.com' and password = 'pwd123'; -- 이메일이 haru@gmail.com이고 비밀번호가 pwd123인 회원의 모든 정보를 조회한다.


-- SQL Injection 기법(입력값에 SQL 코드를 넣어 데이터베이스를 속이는 공격)
select * from member where email = 'haru@gmail.com' or '1' = '1' and password = 'asdfadsf'; -- 이메일이 haru@gmail.com이거나, '1'='1'(항상 참)이고 비밀번호가 asdfadsf인 회원을 조회한다.









