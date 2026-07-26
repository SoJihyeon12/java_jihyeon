-- PRIMARY KEY(기본키) :  각 행(데이터)을 유일하게 구분하는 번호
-- Foreign Key, FK(외래키) : 외래키는 다른 테이블의 기본키를 참조(연결)하는 컬럼(세로 항목(열))입니다.

-- member (회원 테이블) 생성
-- TABLE(테이블) : 행과 열로 구성된 2차원 표 구조로 데이터를 저장하는 가장 기본적인 객체
CREATE TABLE member (
    id INT AUTO_INCREMENT PRIMARY KEY, -- id : 번호표, AUTO_INCREMENT : 1, 2, 3... 자동 증가, PRIMARY KEY : 기본키(회원을 구별하는 유일한 값)
    email VARCHAR(100) NOT NULL UNIQUE, -- VARCHAR(100) : 최대 100글자, NOT NULL : 반드시 입력, UNIQUE : 중복 불가
    password VARCHAR(255) NOT NULL, -- 최대 255자, NOT NULL : 반드시 입력
    name VARCHAR(50) NOT NULL, -- 최대 50자, NOT NULL : 반드시 입력
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP -- created_at : 회원가입 시간, DATETIME : 날짜와 시간을 저장하는 자료형, TIMESTAMP(시간도장) : 날짜와 시간을 저장
);

-- post (게시글 테이블) 생성
CREATE TABLE post (
    id INT AUTO_INCREMENT PRIMARY KEY, -- id : 번호표, AUTO_INCREMENT : 1, 2, 3... 자동 증가, PRIMARY KEY : 기본키(회원을 구별하는 유일한 값)
    member_id INT, -- member_id: 게시글 작성자의 회원번호, INT(정수형)
    title VARCHAR(200) NOT NULL, -- title: 게시글 제목, VARCHAR(200) : 최대 200글자, NOT NULL : 반드시 입력
    content TEXT NOT NULL, -- content : 게시글 내용, TEXT : 긴 글(약 6만자)을 저장할 수 있음.
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP, -- created_at : 회원가입 시간, DATETIME : 날짜와 시간을 저장하는 자료형, TIMESTAMP(시간도장) : 날짜와 시간을 저장
    FOREIGN KEY (member_id) REFERENCES member(id) ON DELETE SET null -- FOREIGN KEY(member_id): member_id 컬럼을 외래키로 지정, 즉, member_id는 다른 테이블과 연결되는 컬럼
    -- REFERENCES member(id):  member 테이블의 id를 참조(REFERENCES)한다. 회원과 게시글이 연결됨.
);

-- reply (댓글 테이블) 생성
CREATE TABLE reply (
    id INT AUTO_INCREMENT PRIMARY KEY, -- id : 번호표, AUTO_INCREMENT : 1, 2, 3... 자동 증가, PRIMARY KEY : 기본키(회원을 구별하는 유일한 값)
    post_id INT NOT NULL, -- post의 id, 어느 게시글의 댓글인지 저장, NOT NULL : 반드시 입력
    member_id INT NOT NULL, -- member의 id, 누가 작성했는지 저장, NOT NULL : 반드시 입력
    content TEXT NOT NULL, -- content : 게시글 내용, TEXT : 긴 글(약 6만자)을 저장할 수 있음.
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP, -- created_at : 회원가입 시간, DATETIME : 날짜와 시간을 저장하는 자료형, TIMESTAMP(시간도장) : 날짜와 시간을 저장
    FOREIGN KEY (post_id) REFERENCES post(id) ON DELETE CASCADE, -- post_id는 외래키(연결), 무슨 외래키?-> post 테이블의 id를 참조하는 외래키, 해당 게시글(post id)이 삭제되면 이 데이터(그 게시글의 댓글들)를 함께(cascade) 삭제
    FOREIGN KEY (member_id) REFERENCES member(id) ON DELETE cascade -- member_id는 외래키(연결), 무슨 외래키?-> member 테이블의 id를 참조하는 외래키, 해당 회원(member id)이 삭제되면 이 데이터(그 회원의 댓글들)를 함께(cascade) 삭제
);

-- member 테이블에 phone 컬럼(가변 문자열, 최대 20자) 추가
ALTER TABLE member ADD phone VARCHAR(20); -- ALTER TABLE: 이미 있는 테이블을 수정, 무슨 테이블을 수정?->member 테이블을 수정, ADD:추가하다, phone이라는 이름의 컬럼(세로 항목(열))을 추가하고, 최대 20자의 문자열을 저장

-- member 테이블의 phone 컬럼 데이터타입을 VARCHAR(30)으로 수정하고 필수값(NOT NULL)으로 설정
ALTER TABLE member MODIFY phone VARCHAR(30) NOT NULL; -- ALTER TABLE: 이미 있는 테이블을 수정, 무슨 테이블을 수정?->member 테이블을 수정, MODIFY: 이미 있는 컬럼을 수정하는 것, 어떤 컬럼을 수정?->phone 컬럼을 수정
-- VARCHAR(30): 최대 30자의 문자열을 저장하도록 변경, NOT NULL: 이 컬럼에는 반드시 값이 있어야 한다.

-- member 테이블의 phone 컬럼을 삭제
ALTER TABLE member DROP COLUMN phone; -- ALTER TABLE: 이미 있는 테이블을 수정, 무슨 테이블을 수정?->member 테이블을 수정, DROP COLUMN phone: phone 컬럼을 없앱니다.

-- reply 테이블 삭제 (삭제 시 테이블 구조와 저장된 모든 데이터가 영구적으로 소멸되므로 주의 필요)
DROP TABLE reply; -- reply 테이블 자체를 삭제합니다.

-- reply 테이블의 모든 데이터를 비우고 처음 생성된 상태로 초기화 (DROP과 달리 구조는 남기며, DELETE보다 연산 속도가 매우 빠름)
TRUNCATE TABLE reply; -- TRUNCATE: 테이블 안의 모든 데이터를 비운다, 즉, 표 구조는 그대로 두고 안에 있는 데이터만 전부 삭제, 어떤 테이블의 데이터를 삭제?-> reply 테이블의 데이터를 삭제한다.






