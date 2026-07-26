-- 1번 댓글 삭제
select * from reply where id = 1; -- select:(실제 뜻은 '선택하다'이지만)조회하다, 확인하다로 사용, reply(댓글) 테이블에서 id가 1인 데이터를 조회(확인)한다.
DELETE FROM reply 
    WHERE id = 1; -- reply(댓글) 테이블에서 id가 1인 댓글을 삭제하라.

-- 2번 게시글 삭제 (댓글 테이블 생성 시 ON DELETE CASCADE 제약 조건을 지정했으므로, 게시글 삭제 시 관련된 하위 댓글 데이터도 함께 자동 삭제됨)
select * from reply where id = 2; -- reply 테이블에서 id가 2인 데이터를 조회(확인)한다.
DELETE FROM post
    WHERE id = 2; -- 게시글 2번을 삭제합니다. 그런데 reply(댓글) 테이블 생성할 때 ON DELETE CASCADE를 지정했으므로 부모(게시글)가 삭제되면 자식(댓글)도 같이 삭제되어 게시글과 관련 댓글도 자동 삭제됨

-- 1번 회원 삭제 (게시글 테이블 생성 시 ON DELETE SET NULL 제약 조건을 지정했으므로, 회원 삭제시 관련된 하위 게시글 데이터의 FK 값이 NULL이 됨)
select * from member where id = 1; -- member(회원) 테이블에서 id가 1인 데이터를 조회(확인)한다.
DELETE FROM member
    WHERE id = 1; -- 회원 1번을 삭제합니다. 그런데 post(게시글) 테이블 생성 시 ON DELETE SET NULL을 지정함. 즉, 부모(회원, member)가 삭제되면 외래키(post.member_id,게시글 작성자의 회원 번호)만 null(공백)로 바꿔서 게시글(자식)은 그대로 남아있음 