-- 전체 회원의 이름과 가입일 조회
SELECT name, created_at
    FROM member;

-- 전체 회원의 모든 컬럼 조회
SELECT *
    FROM member;

-- 별칭을 사용하여 컬럼명을 가독성 있게 표현
SELECT name, created_at AS 가입일
    FROM member;

-- 게시글을 작성한 모든 회원 ID 조회
SELECT member_id
    FROM post;

-- 게시글을 작성한 회원 ID 목록을 중복 없이 조회
SELECT DISTINCT member_id
    FROM post;



-- 특정 이메일을 사용하는 회원 정보 조회
SELECT id, name
    FROM member
    WHERE email = 'haru@gmail.com';

-- 제목에 '게시글'이라는 단어가 들어간 모든 글 조회
SELECT id, title
    FROM post
    WHERE title LIKE '%게시글%';

-- 이름이 '하'로 시작해서 두글자인 모든 회원 조회
SELECT id, name
    FROM member
    WHERE name LIKE '하_';

-- member_id가 1번, 3번, 5번인 회원이 작성한 게시글만 선별하여 조회
SELECT id, title, member_id
    FROM post
    WHERE member_id IN (1, 3, 5);

-- 2026년 6월 1일부터 2026년 6월 20일 사이에 가입한 회원 조회
SELECT id, name, created_at
    FROM member
    WHERE created_at BETWEEN '2026-06-01' AND '2026-06-20 23:59:59';

-- 전화번호 컬럼 값이 입력되지 않고 비어있는(NULL) 회원 조회
SELECT id, name
    FROM member
    WHERE phone IS NULL;


-- 가장 최근에 가입한 회원 순서로 정렬하여 조회
SELECT id, email, name, created_at
    FROM member
    ORDER BY created_at desc, name asc;
;
-- 다중 컬럼 정렬: 이름 오름차순 정렬 후, 동일한 이름은 가입일 내림차순으로 2차 정렬
SELECT id, name, created_at
    FROM member
    ORDER BY name ASC, created_at DESC;


-- 가장 최근에 작성된 게시글 2개만 조회
SELECT id, title, created_at
    FROM post
    ORDER BY created_at DESC
    LIMIT 2;

-- 페이징 처리: 한 페이지에 2건씩, 2페이지 조회 (3번째~4번째 행)
SELECT id, title, created_at
    FROM post
    ORDER BY created_at DESC
    LIMIT 2, 2;





-- 로그인 체크
select * from member where email = 'haru@gmail.com' and password = '123';
select * from member where email = 'haru@gmail.com' and password = 'pwd123';


-- SQL Injection 기법
select * from member where email = 'haru@gmail.com' or '1' = '1' and password = 'asdfadsf';









