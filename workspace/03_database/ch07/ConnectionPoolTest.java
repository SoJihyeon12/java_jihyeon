package ch07;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionPoolTest {

    private static DataSource dataSource;

    static {
        HikariConfig config = new HikariConfig("/hikari.properties");
        dataSource = new HikariDataSource(config);
    }

    public static void main(String[] args){
        findAll();
        insert(2, "2번이 등록한 게시글", "안녕하세요. 자바 공부 해요.");
        findById(10);
        update(10, "수정된 10번 게시글", "수정했어요");
        findAll();
        delete(10);

        deleteAll(2);
        findAll("자바");

        login("haru@gmail.com", "123");
        login("haru@gmail.com", "pwd123");
        login("haru@gmail.com' OR '1' = '1", "sdfsadfasdf");

        // 메인 메서드 마지막에 풀을 명시적으로 종료
        if(dataSource != null){
            ((HikariDataSource)dataSource).close();
        }
    }

    // 로그인
    public static void login(String email, String password){
        String sql = "SELECT * FROM member WHERE email = ? AND password = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{ // 플랜 A
            // 1. 데이터베이스 연결(Connection 객체 생성)
            conn = dataSource.getConnection();

            // 2. SQL 실행 객체 생성(Statement 객체 생성)
            pstmt = conn.prepareStatement(sql);

            // 3. SQL 실행(SELECT)
            // 4. 결과 수신(ResultSet 객체 생성)
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();

            if(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String phone = rs.getString("phone");

                System.out.println("로그인에 성공했습니다.");
                System.out.println("ID: " + id + ", 이메일: " + email + ", 이름: " + name + ", 전화번호: " + phone);
            }else{
                System.out.println("아이디와 패스워드를 확인하세요.");
            }

        }catch(Exception e){ // 플랜 B
            System.out.println("에러 발생: " + e.getMessage());
            e.printStackTrace();
        }finally{
            // 5. 생성된 리소스를 생성의 역순으로 해제
            try{ if(rs != null) rs.close(); } catch (Exception e){ }
            try{ if(pstmt != null) pstmt.close(); } catch (Exception e){ }
            try{ if(conn != null) conn.close(); } catch (Exception e){ }
        }
    }

    // 등록(C)
    static void insert(int memberId, String title, String content){
        String sql = "INSERT INTO post (member_id, title, content) VALUES (?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try{ // 플랜 A
            // 1. 데이터베이스 연결(Connection 객체 생성)
            conn = dataSource.getConnection();

            // 2. SQL 실행 객체 생성(Statement 객체 생성)
            pstmt = conn.prepareStatement(sql);

            // 3. SQL 실행
            pstmt.setInt(1, memberId);
            pstmt.setString(2, title);
            pstmt.setString(3, content);
            int affectedRows = pstmt.executeUpdate();

//            System.out.println("게시글 등록 완료: " + affectedRows + "건 반영됨.");

        }catch(Exception e){ // 플랜 B
            System.out.println("에러 발생: " + e.getMessage());
            e.printStackTrace();
        }finally{
            // 5. 생성된 리소스를 생성의 역순으로 해제
            try{ if(pstmt != null) pstmt.close(); } catch (Exception e){ }
            try{ if(conn != null) conn.close(); } catch (Exception e){ }
        }
    }

    // 모든 게시글 목록 조회(R)
    static void findAll(){
        findAll("");
    }

    // 게시글 검색 목록 조회(R)
    static void findAll(String keyword){
        String sql = "SELECT id, title, view_count viewCount, created_at AS createdAt FROM post";

        // 의미있는 검색어가 전달되었을 경우
        boolean hasKeyword = keyword != null && !keyword.equals("");
        if(hasKeyword){
            sql += " WHERE title LIKE ? OR content LIKE ?";
        }

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{ // 플랜 A
            // 1. 데이터베이스 연결(Connection 객체 생성)
            conn = dataSource.getConnection();

            // 2. SQL 실행 객체 생성(Statement 객체 생성)
            pstmt = conn.prepareStatement(sql);

            // 3. SQL 실행
            if(hasKeyword){
                pstmt.setString(1, "%" + keyword + "%");
                pstmt.setString(2, "%" + keyword + "%");
            }
            rs = pstmt.executeQuery();

            // 4. 결과 처리(ResultSet 사용)
            while(rs.next()){
                int id = rs.getInt("id");
                String title = rs.getString("title");
                int viewCount = rs.getInt("viewCount");
                String createdAt = rs.getString("createdAt");

                System.out.println("ID: " + id + ", 제목: " + title + ", 조회수: " + viewCount + ", 작성일: " + createdAt);
            }

        }catch(Exception e){ // 플랜 B
            System.out.println("에러 발생: " + e.getMessage());
            e.printStackTrace();
        }finally{
            // 5. 생성된 리소스를 생성의 역순으로 해제
            try{ if(rs != null) rs.close(); } catch (Exception e){ }
            try{ if(pstmt != null) pstmt.close(); } catch (Exception e){ }
            try{ if(conn != null) conn.close(); } catch (Exception e){ }
        }
    }

    // 한건 조회(R)
    static void findById(int id){
        String sql = "SELECT id, title, content, view_count viewCount, created_at AS createdAt FROM post WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{ // 플랜 A
            // 1. 데이터베이스 연결(Connection 객체 생성)
            conn = dataSource.getConnection();

            // 2. SQL 실행 객체 생성(Statement 객체 생성)
            pstmt = conn.prepareStatement(sql);

            // 3. SQL 실행
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            // 4. 결과 처리(ResultSet 사용)
            while(rs.next()){
                String title = rs.getString("title");
                String content = rs.getString("content");
                int viewCount = rs.getInt("viewCount");
                String createdAt = rs.getString("createdAt");

                System.out.println("ID: " + id + ", 제목: " + title + ", 내용: " + content + ", 조회수: " + viewCount + ", 작성일: " + createdAt);
            }

        }catch(Exception e){ // 플랜 B
            System.out.println("에러 발생: " + e.getMessage());
            e.printStackTrace();
        }finally{
            // 5. 생성된 리소스를 생성의 역순으로 해제
            try{ if(rs != null) rs.close(); } catch (Exception e){ }
            try{ if(pstmt != null) pstmt.close(); } catch (Exception e){ }
            try{ if(conn != null) conn.close(); } catch (Exception e){ }
        }
    }

    // 수정(U)
    static void update(int id, String title, String content){
        String sql = "UPDATE post SET title = ?, content = ? WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try{ // 플랜 A
            // 1. 데이터베이스 연결(Connection 객체 생성)
            conn = dataSource.getConnection();

            // 2. SQL 실행 객체 생성(Statement 객체 생성)
            pstmt = conn.prepareStatement(sql);

            // 3. SQL 실행
            pstmt.setString(1, title);
            pstmt.setString(2, content);
            pstmt.setInt(3, id);
            int affectedRows = pstmt.executeUpdate();

            System.out.println("게시글 수정 완료: " + affectedRows + "건 반영됨.");

        }catch(Exception e){ // 플랜 B
            System.out.println("에러 발생: " + e.getMessage());
            e.printStackTrace();
        }finally{
            // 5. 생성된 리소스를 생성의 역순으로 해제
            try{ if(pstmt != null) pstmt.close(); } catch (Exception e){ }
            try{ if(conn != null) conn.close(); } catch (Exception e){ }
        }
    }

    // 지정한 id의 게시글 삭제(D)
    static void delete(int id){
        String sql = "DELETE FROM post WHERE id=?";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try{ // 플랜 A
            // 1. 데이터베이스 연결(Connection 객체 생성)
            conn = dataSource.getConnection();

            // 2. SQL 실행 객체 생성(Statement 객체 생성)
            pstmt = conn.prepareStatement(sql);

            // 3. SQL 실행
            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();

            System.out.println(id + "번 게시글 삭제 완료: " + affectedRows + "건 반영됨.");

        }catch(Exception e){ // 플랜 B
            System.out.println("에러 발생: " + e.getMessage());
            e.printStackTrace();
        }finally{
            // 5. 생성된 리소스를 생성의 역순으로 해제
            try{ if(pstmt != null) pstmt.close(); } catch (Exception e){ }
            try{ if(conn != null) conn.close(); } catch (Exception e){ }
        }
    }

    // 지정한 회원의 모든 게시글 삭제(D)
    static void deleteAll(int memberId){
        String sql = "DELETE FROM post WHERE member_id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try{ // 플랜 A
            // 1. 데이터베이스 연결(Connection 객체 생성)
            conn = dataSource.getConnection();

            // 2. SQL 실행 객체 생성(Statement 객체 생성)
            pstmt = conn.prepareStatement(sql);

            // 3. SQL 실행
            pstmt.setInt(1, memberId);
            int affectedRows = pstmt.executeUpdate();

            System.out.println(memberId + "번 회원의 모든 게시글 삭제 완료: " + affectedRows + "건 반영됨.");

        }catch(Exception e){ // 플랜 B
            System.out.println("에러 발생: " + e.getMessage());
            e.printStackTrace();
        }finally{
            // 5. 생성된 리소스를 생성의 역순으로 해제
            try{ if(pstmt != null) pstmt.close(); } catch (Exception e){ }
            try{ if(conn != null) conn.close(); } catch (Exception e){ }
        }
    }

}