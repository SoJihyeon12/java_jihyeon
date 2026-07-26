package ch07;
// JdbcMemberTest는 다루는 테이블이 member 하나지만, JdbcPostPreparedTest는 다루는 테이블이 post와 member 두개다.
// 또한 JdbcMemberTest는 SQL 인젝션에 취약할 수 있음, JdbcPostPreparedTest는 SQL 인젝션 방지 기능이 되어있다.
// 또한 JdbcPostPreparedTest에서 게시글 등록 ,조회 등의 기능도 더 추가되었다.

import java.sql.*;
import java.util.ResourceBundle;

public class JdbcPostPreparedTest {

//    private static final String DB_URL = "jdbc:mysql://localhost:3306/board_db?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
//    private static final String DB_USER = "user1";
//    private static final String DB_PASSWORD = "1111";

    private static final ResourceBundle bundle = ResourceBundle.getBundle("hikari"); // ResourceBundle이란? 설정 파일(.properties)의 내용을 읽어오는 클래스입니다. bundle 객체에 저장합니다.
    // getBundle("hikari")에서는 .properties 확장자를 쓰지 않습니다. 자바가 자동으로 hikari.properties 파일을 찾습니다.
    private static final String DB_URL = bundle.getString("jdbcUrl"); // 번들에서 url을 찾아 가져온다.
    private static final String DB_USER = bundle.getString("username");
    private static final String DB_PASSWORD = bundle.getString("password");

    public static void main(String[] args){
//        findAll();
//        insert(2, "2번이 등록한 게시글", "안녕하세요. 자바 공부 해요.");
//        findById(10);
//        update(10, "수정된 10번 게시글", "수정했어요");
//        findAll();
//        delete(10);
//
//        deleteAll(2);
//        findAll("자바");

        login("haru@gmail.com", "123"); // 로그인 테스트
        login("haru@gmail.com", "pwd123"); // 로그인 테스트
        login("haru@gmail.com' OR '1' = '1", "sdfsadfasdf"); // 로그인 테스트, sql 인젝션 검사
    }

    // 로그인
    public static void login(String email, String password){
        String sql = "SELECT * FROM member WHERE email = ? AND password = ?";

        Connection conn = null; // 데이터베이스와 연결하는 객체입니다.
        PreparedStatement pstmt = null; // SQL을 실행하는 객체입니다.
        ResultSet rs = null; // 조회 결과를 저장하는 객체입니다.

        try{ // 플랜 A
            // 1. 데이터베이스 연결(Connection 객체 생성)
            // DriverManager는 "데이터베이스에 연결해 주는 관리자"역할을 하는 jdbc가 제공하는 클래스이다.
            // 데이터베이스와 연결(Connection)을 만들어 달라. 반환값은 Connection 객체이다.
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); // (데이터베이스에 접속하기 위한 정보)-> db의 url,user,password
            // jdbc:mysql:// → MySQL을 사용
            //localhost → 내 컴퓨터의 DB
            //3306 → MySQL 기본 포트
            //board_db → 접속할 데이터베이스 이름

            // DriverManager(예전 방식이다.)- 매번 새로운 Connection을 생성합니다.
            // Connection Pool(HikariCP) 방식 - 미리 만들어 둔 Connection을 빌려옵니다. 사용끝나면 커넥션풀에 반납


            // 2. SQL 실행 객체 생성(Statement 객체 생성)
            pstmt = conn.prepareStatement(sql);

            // 3. SQL 실행(SELECT)
            // 4. 결과 수신(ResultSet 객체 생성)
            pstmt.setString(1, email); // 첫 번째 ?에 이메일을 넣음
            pstmt.setString(2, password); // 두 번째 ?에 비밀번호를 넣음
            rs = pstmt.executeQuery();

            if(rs.next()){ // 결과 확인: rs.next()는 조회 결과가 있는지 확인하면서 첫 번째 행으로 이동하는 메서드입니다. 첫번째 행에 데이터가 있으면 로그인 성공, 데이터가 없으면 로그인 실패
                int id = rs.getInt("id"); // 로그인 성공이면 그 조회결과의 id 컬럼 값을 가져옵니다.
                String name = rs.getString("name"); // 조회결과의 이름을 가져옵니다.
                String phone = rs.getString("phone"); // 조회결과의 전화번호를 가져옵니다.

                System.out.println("로그인에 성공했습니다."); // 로그인 성공 출력
                System.out.println("ID: " + id + ", 이메일: " + email + ", 이름: " + name + ", 전화번호: " + phone); // 정보 출력
            }else{ // 로그인 실패하면
                System.out.println("아이디와 패스워드를 확인하세요."); //를 출력합니다.
            }

        }catch(Exception e){ // 플랜 B, catch(Exception e): DB 연결 실패나 SQL 오류가 발생하면 실행됩니다.
            System.out.println("에러 발생: " + e.getMessage()); // 오류 내용을 출력합니다.
            e.printStackTrace(); // 예외(Exception)가 발생했을 때 오류 내용을 자세하게 출력하는 메서드
        }finally{ //성공하든 실패하든 반드시 실행되는 부분
            // 5. 생성된 리소스를 생성의 역순으로 해제
            try{ if(rs != null) rs.close(); } catch (Exception e){ } // ResultSet 객체가 있으면 rs.close():조회 결과(ResultSet)를 닫는 것을 호출한다. 그런데 ResultSet 객체없는 null이라면 rs.close();를 호출할 수 없습니다.
            // try는 close()를 실행하다가 예외가 발생할 수도 있기 때문에 try로 감쌉니다. catch: 예외가 발생해도 아무 처리도 하지 않고 넘어갑니다. 왜냐하면 프로그램이 종료되는 시점에서 자원을 닫는 과정이기 때문에, 닫는 도중 오류가 나더라도 프로그램이 중단될 필요는 없기 때문입니다.
            // (Exception e): 오류가 발생하면 그 오류 정보를 e라는 상자에 담아 줘.
            // 이렇게 try catch문을 각각 따로 작성하는 이유는 rs.close 예외가 발생해도 나머지 pstmt.close();,conn.close();는 계속 실행되도록 하기 위해서이다.
            try{ if(pstmt != null) pstmt.close(); } catch (Exception e){ } // SQL 실행 객체를 닫습니다.
            try{ if(conn != null) conn.close(); } catch (Exception e){ } // 데이터베이스 연결을 닫습니다.
        }
    }

    // 등록(C)
    static void insert(int memberId, String title, String content){
        String sql = "INSERT INTO post (member_id, title, content) VALUES (?, ?, ?)";
        // INSERT INTO member: member 테이블에 새로운 회원을 추가하라.

        Connection conn = null;
        PreparedStatement pstmt = null;

        try{ // 플랜 A
            // 1. 데이터베이스 연결(Connection 객체 생성)
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 2. SQL 실행 객체 생성(Statement 객체 생성)
            pstmt = conn.prepareStatement(sql);

            // 3. SQL 실행
            pstmt.setInt(1, memberId); // 첫 번째 ?에 멤버아이디을 넣음
            pstmt.setString(2, title); // 두 번째 ?에 제목을 넣음
            pstmt.setString(3, content); // 세 번째 ?에 내용을 넣음
            int affectedRows = pstmt.executeUpdate();
            // stmt는 Statement 객체, executeUpdate()는 INSERT, UPDATE, DELETE SQL을 실행하는 메서드입니다.
            // affectedRows: 반환값은 영향을 받은 행(Row)의 개수입니다.

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
    // 메서드 오버로딩(Overloading)을 이용한 코드입니다.
    // 중요한 의미가 있습니다. 이 코드는 매개변수 없이 findAll()을 호출하면, 내부적으로 findAll("")을 대신 호출하도록 만든 것입니다.
    static void findAll(){
        findAll("");
    }

    // 게시글 검색 목록 조회(R)
    static void findAll(String keyword){
        String sql = "SELECT id, title, view_count viewCount, created_at AS createdAt FROM post";

        // 의미있는 검색어가 전달되었을 경우
        // boolean은 참(true) 또는 거짓(false) 만 저장하는 자료형입니다.
        boolean hasKeyword = keyword != null && !keyword.equals(""); // 검색어가 있어야 하고, 검색어가 빈 문자열이 아니어야(!) 함
        if(hasKeyword){ // 검색어가 있을 때만 실행해라.
            sql += " WHERE title LIKE ? OR content LIKE ?"; // +=는 기존 문자열 뒤에 이어 붙인다.
        }

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{ // 플랜 A
            // 1. 데이터베이스 연결(Connection 객체 생성)
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 2. SQL 실행 객체 생성(Statement 객체 생성)
            pstmt = conn.prepareStatement(sql);

            // 3. SQL 실행
            if(hasKeyword){
                pstmt.setString(1, "%" + keyword + "%");
                pstmt.setString(2, "%" + keyword + "%");
            }
            rs = pstmt.executeQuery();

            // 4. 결과 처리(ResultSet 사용)
            while(rs.next()){ // rs에 저장된 실행결과를 한 행씩 읽어와 출력합니다. 이동한 행이 있으면 true, 더 이상 행이 없으면 false를 반환
                int id = rs.getInt("id"); // 데이터 꺼내기, 현재 행의 id 컬럼 값을 가져옵니다.
                String title = rs.getString("title"); // 제목 컬럼 값을 가져옵니다.
                int viewCount = rs.getInt("viewCount"); // 조회수를 가져온다.
                String createdAt = rs.getString("createdAt"); // 작성일을 가져온다.

                System.out.println("ID: " + id + ", 제목: " + title + ", 조회수: " + viewCount + ", 작성일: " + createdAt); // 정보 출력
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
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

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
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

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
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

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
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

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