-- 로컬 호스트 전용 계정 생성
CREATE USER 'user1'@'localhost'
    IDENTIFIED BY '1111';

-- 모든 호스트에서 접속 가능한 계정 생성
CREATE USER 'user2'@'%'
    IDENTIFIED BY '2222';

-- 특정 도메인(또는 호스트명)에서만 접속 가능한 계정 생성
CREATE USER 'board_app'@'board.likelion.net' IDENTIFIED BY '1234';


--db 사용자 조회
select user, host
from mysql.user;


-- 로컬 호스트 전용 계정인 user1의 권한 조회
SHOW GRANTS FOR 'user1'@'localhost';

-- 원격 계정인 board_app의 권한 조회
SHOW GRANTS FOR 'board_app'@'board.likelion.net';


-- 1) 테이블 단위 권한 부여: user1 계정에 member 테이블의 조회(SELECT) 및 삽입(INSERT) 권한 부여
GRANT SELECT, INSERT
    ON member
    TO 'user1'@'localhost';

-- 2) 데이터베이스 단위 권한 부여: user1 계정에 board_db 데이터베이스의 모든 테이블에 대한 조회 권한 부여
GRANT SELECT
    ON board_db.*
    TO 'user1'@'localhost';

-- 3) 애플리케이션 전용 계정에 CRUD 권한 부여 (특정 도메인 접속 계정)
-- board_db 데이터베이스의 모든 테이블에 대해 조회/삽입/수정/삭제 권한 일괄 부여
GRANT SELECT, INSERT, UPDATE, DELETE
    ON board_db.*
    TO 'board_app'@'board.likelion.net';


-- 권한 회수: user1 계정에 member 테이블의 삽입(INSERT) 권한 회수
REVOKE INSERT
    ON member
    FROM 'user1'@'localhost';


-- 개발자용 권한 그룹 생성
CREATE ROLE 'developer';

-- 개발자 그룹에 board_db의 모든 테이블에 대한 CRUD 권한 부여
GRANT SELECT, INSERT, UPDATE, DELETE ON board_db.* TO 'developer';

-- user1에게 개발자 그룹 권한 부여
GRANT 'developer' TO 'user1'@'localhost';

-- user1 로그인 시 developer 권한 그룹이 기본으로 활성화되도록 설정
SET DEFAULT ROLE 'developer' TO 'user1'@'localhost';
