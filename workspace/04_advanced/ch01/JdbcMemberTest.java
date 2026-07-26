package ch01;
// 이 코드는 JDBC(Java Database Connectivity)를 이용해서 MySQL의 member 테이블을 관리하는 프로그램입니다.
// 쉽게 말하면 자바로 회원을 조회, 등록, 수정, 삭제하고 로그인까지 하는 예제

//이 예제는 JDBC의 기본 흐름을 익히기 위한 코드입니다.
//
//1. DB 연결(Connection 생성)
//2. SQL 실행 객체(Statement 생성)
//3. SQL 실행(executeQuery, executeUpdate)
//4. 조회 결과는 ResultSet에서 읽기
//5. 오류는 try-catch로 처리
//6. DB 연결은 반드시 닫기(close 또는 try-with-resources)
//7. 여러 SQL을 하나의 작업으로 처리할 때는 commit()과 rollback()으로 트랜잭션을 관리하기

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcMemberTest {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/board_db?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
    private static final String DB_USER = "user1";
    private static final String DB_PASSWORD = "1111";

    public static void main(String[] args){
        selectAllMembers(); // 회원 목록 조회

        // insertMember에서 Exception 처리의 주체를 상위 메서드로 전가 했으므로 이곳에서 try-catch로 처리함
        try{
            insertMember("haru" + (int)(Math.random() * 1000) + "@gmail.com", "1234", "뉴하루", "010-2222-3333", 2); // 회원 등록, (int)(Math.random() * 1000)는 0 이상 1000 미만의 숫자가 됩니다. 매번 다른 이메일 만드는 것
        }catch(IllegalArgumentException e){ // 메서드에 잘못된 값(인수, argument)을 전달했을 때 발생하는 예외, 메서드에 넘긴 값이 올바르지 않습니다 라는 뜻
            System.out.println(e.getMessage()); // 예외(오류) 객체에 저장된 오류 메시지를 가져오는 메서드
            insertMember("haru" + (int)(Math.random() * 1000) + "@gmail.com", "1234", "뉴하루"
                    , "010-2222-3333".replace("-", ""), 2); // 회원 등록
        }

        updateMember(3, "3333", "3번회원", "01033333333");
        deleteMember(1);
        selectAllMembers(); // 회원 목록 조회

        try {
            login("haru@gmail.com", "    ");
        } catch (LoginFailException e) { // 로그인 실패를 나타내기 위해 개발자가 직접 만든 예외 클래스, 사용자 정의 예외(Custom Exception)
            System.out.println(e.getMessage());
        }
//        login("haru@gmail.com", "pwd123");
//        login("haru@gmail.com' OR '1' = '1", "sdfsadfasdf");
    }

    // 로그인
    public static void login(String email, String password) throws LoginFailException { // throws는 "예외 처리를 내가 하지 않고, 나를 호출한 메서드에게 넘기겠다."는 의미, // 로그인 실패를 나타내기 위해 개발자가 직접 만든 예외 클래스, 사용자 정의 예외(Custom Exception)

        if(email == null || email.isBlank() || password == null || password.isBlank()){ // 이 조건은 다음 중 하나라도 참이면 실행됨, 이메일이나 비밀번호가 제대로 입력되지 않았는지 검사하는 코드
            throw new LoginFailException("email과 password를 확인하세요."); // throw new LoginFailException();는 LoginFailException이라는 예외를 발생시키는 코드, 그런데 login() 메서드 안에서는 이 예외를 try-catch로 처리하지 않았습니다. 그래서 메서드 선언부에 throw LoginFailException 적은 것
        }

        String sql = "SELECT * FROM member WHERE email = '"+email+"' AND password = '"+password+"'";
        System.out.println("로그인 쿼리: " + sql);

        try(Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement stmt = conn.createStatement(); // conn.createStatement(): SQL을 실행할 수 있는 Statement를 하나 만들어 줘 라는 의미, 생성된 Statement 객체를 stmt라는 변수에 저장
            ResultSet rs = stmt.executeQuery(sql)){ // 플랜 A, SQL을 실행해서 조회된 결과(테이블)를 rs에 저장한다

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
            e.printStackTrace(); // 오류가 무엇인지, 어디에서 발생했는지 모두 출력해라라는 뜻
        }
    }

    // 회원 목록 조회
    public static void selectAllMembers(){
        try(Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM member")){ // 플랜 A
            while(rs.next()){
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String name = rs.getString("name");
                String phone = rs.getString("phone");

                System.out.println("ID: " + id + ", 이메일: " + email + ", 이름: " + name + ", 전화번호: " + phone);
            }
        }catch(Exception e){ // 플랜 B
            System.out.println("에러 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // 회원 등록
    public static void insertMember(String email, String password
            , String name, String phone, int recommenderId) throws IllegalArgumentException {

        if(phone.length() > 11){ // 전화번호 길이가 11 보다 크면
            throw new IllegalArgumentException("phone은 11자 이내여야 합니다.");
        }

        try(Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement stmt = conn.createStatement()){ // 플랜 A

            // 3. SQL 실행
            int affectedRows = stmt.executeUpdate("INSERT INTO member (email, password, name, phone, recommender_id) VALUES \n" +
                    "    ('"+email+"', '"+password+"', '"+name+"', '"+phone+"', "+recommenderId+")"); //<- VALUES() 실제 넣을 데이터

            System.out.println("회원 등록 완료: " + affectedRows + "건 반영됨.");
        }catch(Exception e){ // 플랜 B
            System.out.println("에러 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // 회원 수정
    public static void updateMember(int id, String password, String name, String phone){
        try(Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement stmt = conn.createStatement()){ // 플랜 A

            // 3. SQL 실행
            int affectedRows = stmt.executeUpdate(
                    "UPDATE member SET password = '"+password+"', name = '"+name+"', phone = '"+phone+"' WHERE id = " + id);

            System.out.println("회원 수정 완료: " + affectedRows + "건 반영됨.");

        }catch(Exception e){ // 플랜 B
            System.out.println("에러 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // 회원 삭제(회원의 게시글도 같이 삭제)
    public static void deleteMember(int id){
        Connection conn = null;
        Statement stmt = null;

        try{ // 플랜 A
            // 1. 데이터베이스 연결(Connection 객체 생성)
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 2. SQL 실행 객체 생성(Statement 객체 생성)
            stmt = conn.createStatement();

            // 트랙잭션 제어를 위해 자동 커밋 중지
            conn.setAutoCommit(false);

            // 3. SQL 실행
            int affectedRows = stmt.executeUpdate("DELETE FROM post WHERE member_id=" + id);
            System.out.println("회원의 모든 게시글 삭제 완료: " + affectedRows + "건 반영됨.");

            // 10초 동안 휴식
            Thread.sleep(1000 * 10);

            affectedRows = stmt.executeUpdate("DELETE FROM member WHERE id=" + id);
            System.out.println("회원 삭제 완료: " + affectedRows + "건 반영됨.");

            // 성공
            conn.commit();
        }catch(Exception e){ // 플랜 B
            System.out.println("에러 발생: " + e.getMessage());
            try{ if(conn != null) conn.rollback(); } catch (Exception e2){ }
            e.printStackTrace();
        }finally{
            // 5. 생성된 리소스를 생성의 역순으로 해제
            try{ if(stmt != null) stmt.close(); } catch (Exception e){ }
            try{ if(conn != null) conn.close(); } catch (Exception e){ }
        }
    }

}