-- 모든 컬럼의 값을 순서대로 입력하여 데이터 삽입 (auto_increment는 NULL, default는 DEFAULT 키워드 사용)
INSERT INTO member -- INSERT(삽입하다) INTO(안으로): 새로운 데이터를 추가할 때 사용하는 명령어, 회원 데이터 삽입
  VALUES (NULL, 'haru@gmail.com', 'pwd123', '하루', '01011112222', DEFAULT); -- 항목별로 id, email, password, name, phone,	 created_at
INSERT INTO member -- 회원 데이터 삽입
  VALUES (NULL, 'haru2@gmail.com', 'pwd123', '하루2', NULL, '2026-05-10 12:13:45'); -- 항목별로 id, email, password, name, phone,	 created_at


-- 특정 필수 컬럼에만 값을 입력하여 데이터 삽입
INSERT INTO member (email, password, name) -- 회원의 email, password, name 데이터 삽입
    VALUES ('namu@gmail.com', 'pwd789', '나무');

-- 다중 회원 데이터 일괄 삽입 (네트워크 트래픽을 낮추고 고속으로 대용량 데이터를 넣을 때 활용)
INSERT INTO member (email, password, name, phone) values -- values: 여러 명 한 번에 삽입, 회원의 email, password, name, phone 데이터 삽입
    ('harong@gmail.com', 'pwd012', '하롱이', '01022223333'), -- INSERT를 두번해서 두명치 데이터 넣으면 DB와 두번 통신한다.
    ('yong@gmail.com', 'pwd456', '용쌤', '0103334444'); -- VALUES (),() 처럼 데이터 (여러개) 해서 넣으면 DB와 한번만 통신하므로 더 빠르고 대량 데이터 입력에 많이 사용됨

-- 게시글 데이터 삽입
INSERT INTO post (member_id, title, content) -- 게시글의 member_id(회원 아이디), title(게시글 제목), content(게시글 내용) 데이터 삽입
VALUES (1, '첫 번째 게시글', '안녕하세요. 반갑습니다.');

INSERT INTO post (member_id, title, content)
VALUES (2, '질문 있습니다', '데이터베이스 기초에 대한 질문입니다.');

INSERT INTO post (member_id, title, content)
VALUES (1, '두 번째 게시글', '오늘 날씨가 아주 좋습니다.');

INSERT INTO post (member_id, title, content)
VALUES (2, 'MySQL 설치 오류 해결방법', '설치 중 Configurator 단계에서 오류가 날 때 대처법 공유합니다.');

INSERT INTO post (member_id, title, content)
VALUES (3, '자기 소개', '안녕하세요 하롱이입니다.');

-- 댓글 데이터 삽입
INSERT INTO reply (post_id, member_id, content) -- 댓글의 post_id(게시글 아이디), member_id(회원 아이디), content(게시글 내용) 데이터 삽입
VALUES (1, 2, '환영합니다!');

INSERT INTO reply (post_id, member_id, content)
VALUES (1, 3, '반가워요~');

INSERT INTO reply (post_id, member_id, content)
VALUES (2, 1, '어떤 부분이 궁금하신가요?');

INSERT INTO reply (post_id, member_id, content)
VALUES (4, 3, '정말 유용한 정보네요. 감사합니다!');

INSERT INTO reply (post_id, member_id, content)
VALUES (4, 1, '저도 이 방법으로 해결했습니다.');