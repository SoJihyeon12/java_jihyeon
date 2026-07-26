-- 로컬 호스트 전용 계정 생성,            
CREATE USER 'user1'@'localhost' -- MySQL에 새로운 사용자(user1)를 생성하고, 비밀번호를 1111로 설정, localhost(현재 컴퓨터)에서 접속할 수 있는 user1이라는 사용자를 만들고 비밀번호를 1111로 설정한다
    IDENTIFIED BY '1111'; -- IDENTIFIED BY: 비밀번호를 설정한다. @: 어디에서 접속할 수 있는지

-- 모든 호스트에서 접속 가능한 계정 생성
CREATE USER 'user2'@'%' -- @: 어디에서 접속할 수 있는지, %: 어떤 컴퓨터에서든 접속 가능, 즉, 어느 컴퓨터에서 접속하든 user2 계정으로 로그인할 수 있다.
    IDENTIFIED BY '2222'; -- 비밀번호를 2222로 설정한다.

-- 특정 도메인(또는 호스트명)에서만 접속 가능한 계정 생성
CREATE USER 'board_app'@'board.likelion.net' IDENTIFIED BY '1234'; -- board.likelion.net 서버에서만 접속할 수 있는 board_app 사용자를 생성하고, 비밀번호를 1234로 설정하는 명령입니다.


--db 사용자 조회
select user, host -- 호스트(host)란 데이터베이스(DB) 서버가 실행되고 있는 컴퓨터나 장치의 주소, 사용자와 호스트 컬럼을 조회한다.
from mysql.user; -- MySQL 시스템 데이터베이스(mysql)에 있는 user 테이블에서 조회한다.


-- 로컬 호스트 전용 계정인 user1의 권한 조회
SHOW GRANTS FOR 'user1'@'localhost'; -- SHOW: 보여준다. GRANTS: 권한(Privileges), localhost에서 접속하는 user1 사용자에 대한 권한을 보여준다.

-- 원격 계정인 board_app의 권한 조회
SHOW GRANTS FOR 'board_app'@'board.likelion.net'; -- board.likelion.net 호스트에서 접속하는 board_app 사용자의 권한을 조회한다.


-- 1) 테이블 단위 권한 부여: user1 계정에 member 테이블의 조회(SELECT) 및 삽입(INSERT) 권한 부여, 
GRANT SELECT, insert -- GRANT : 권한을 부여한다. 데이터를 조회할 수 있는 권한, 데이터를 추가할 수 있는 권한
    ON member -- ON: 어떤 대상(테이블 또는 데이터베이스)에 대한 권한인지 지정한다.
    TO 'user1'@'localhost'; -- TO: 누구에게 권한을 줄 것인지 지정한다. localhost에서 접속하는 user1 사용자에게 권한을 부여한다.

-- 2) 데이터베이스 단위 권한 부여: user1 계정에 board_db 데이터베이스의 모든 테이블에 대한 조회 권한 부여
GRANT select -- GRANT : 권한을 부여한다.
    ON board_db.* -- ON: 어느 데이터베이스 또는 테이블에 대한 권한인지 지정한다. board_db : 데이터베이스 이름, * : 모든 테이블, 즉, board_db 데이터베이스 안에 있는 모든 테이블을 의미합니다.
    TO 'user1'@'localhost'; -- localhost에서 접속하는 user1 사용자에게 권한을 부여한다.

-- 3) 애플리케이션 전용 계정에 CRUD 권한 부여 (특정 도메인 접속 계정)
-- board_db 데이터베이스의 모든 테이블에 대해 조회/삽입/수정/삭제 권한 일괄 부여
GRANT SELECT, INSERT, UPDATE, delete -- GRANT : 권한을 부여한다. 조회, 데이터추가, 수정, 삭제 권한을 부여함
    ON board_db.* -- board_db.*: board_db 데이터베이스 안의 모든 테이블을 의미합니다.
    TO 'board_app'@'board.likelion.net'; -- board.likelion.net에서 접속하는 board_app 사용자에게 권한을 부여함


-- 권한 회수: user1 계정에 member 테이블의 삽입(INSERT) 권한 회수
REVOKE insert -- REVOKE: 권한을 회수(삭제)한다.
    ON member -- ON: 어느 테이블(또는 데이터베이스)에 대한 권한인지 지정한다. 즉, member 테이블에 대한 권한만 회수합니다.
    FROM 'user1'@'localhost'; -- localhost에서 접속하는 user1 사용자에게서 권한을 회수한다.


-- 개발자용 권한 그룹 생성
CREATE ROLE 'developer'; -- developer라는 이름의 역할(Role)을 생성하는 명령

-- 개발자 그룹에 board_db의 모든 테이블에 대한 CRUD 권한 부여
GRANT SELECT, INSERT, UPDATE, DELETE ON board_db.* TO 'developer'; -- developer 역할(Role)에게 board_db 데이터베이스의 모든 테이블에 대한 조회, 추가, 수정, 삭제 권한을 부여하는 명령

-- user1에게 개발자 그룹 권한 부여
GRANT 'developer' TO 'user1'@'localhost'; -- user1 사용자에게 developer 역할(Role)을 부여하는 명령

-- user1 로그인 시 developer 권한 그룹이 기본으로 활성화되도록 설정
SET DEFAULT ROLE 'developer' TO 'user1'@'localhost'; -- SET: 설정한다. DEFAULT ROLE: 기본 역할(Role)을 설정, 즉, user1 사용자가 로그인할 때 developer 역할(Role)이 자동으로 활성화되도록 기본 역할을 설정
