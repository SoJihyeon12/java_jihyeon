SELECT * FROM post; -- 게시글 테이블의 모든 데이터 조회

SELECT * FROM MEMBER; -- 회원 테이블의 모든 데이터 조회


-- 2번 회원 탈퇴시 게시글 삭제 옵션을 선택한 경우


start transaction; -- 트랜잭션은 여러 SQL 문을 하나의 묶음으로 처리하는 것, 트랜젝션을 시작한다는 뜻


-- 2번 회원의 게시글 먼저 삭제
DELETE FROM post WHERE member_id =2;


-- 2번 회원 삭제
DELETE FROM member WHERE id =2;


-- 정상 완료시 DB에 반영
commit;


-- 오류 발생시 원래 상태로 복구
rollback;


SELECT @@transaction_isolation; -- @@: MySQL의 시스템 변수(System Variable)를 의미, transaction_isolation: 트랜잭션 격리 수준, 트랜잭션끼리 서로의 작업을 어느 정도까지 볼 수 있는지를 결정하는 설정
-- 이 SQL은 현재 세션(Session)에 설정된 트랜잭션 격리 수준(Transaction Isolation Level)을 조회하는 명령어. 즉, 현재 트랜잭션 격리 수준을 조회한다.
-- 세션: 이 사용자는 누구인지 서버가 기억하는 메모장