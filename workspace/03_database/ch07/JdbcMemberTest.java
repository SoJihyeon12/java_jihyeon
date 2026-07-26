package ch07;
// 이 코드는 JDBC를 이용해 회원(Member) 테이블의 CRUD와 로그인 기능을 구현한 예제입니다.
// 앞에서 배운 ConnectionPoolTest와 가장 큰 차이점은 PreparedStatement 대신 Statement를 사용하고, Connection Pool(HikariCP) 대신 DriverManager로 직접 DB에 연결한다는 점입니다.
// statement는 SQL을 실행하는 객체이고, PreparedStatement는 Statement를 개선한 버전으로, ?를 사용해 값을 안전하게 전달할 수 있어(sql 인젝션 방지) 실무에서는 대부분 커넥션풀테스트 클래스의 PreparedStatement를 사용합니다.
//DB(Database) = 데이터를 저장하는 창고
//SQL = 그 창고를 다루는 언어
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcMemberTest {

    // DB 정보, 데이터베이스 접속 정보를 저장합니다.
    // DB_URL : MySQL 서버 주소와 사용할 데이터베이스(board_db)
    //DB_USER : 로그인 계정
    //DB_PASSWORD : 비밀번호
    //final이 붙었으므로 한 번 정해진 값은 변경할 수 없습니다.
    private static final String DB_URL = "jdbc:mysql://localhost:3306/board_db?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
    private static final String DB_USER = "user1";
    private static final String DB_PASSWORD = "1111";

    public static void main(String[] args){ // 프로그램을 실행하면 가장 먼저 실행되는 메서드입니다. 여기서는 CRUD 기능을 테스트합니다.
//        selectAllMembers(); // 회원 목록 조회
//        insertMember("haru" + (int)(Math.random() * 1000) + "@gmail.com", "1234", "뉴하루", "01022221111", 2); // 회원 등록
//        updateMember(3, "3333", "3번회원", "01033333333"); // 수정
        deleteMember(1); // 1번 회원을 삭제합니다.
//        selectAllMembers(); // 회원 목록 조회

//        login("haru@gmail.com", "123"); // 로그인 테스트
//        login("haru@gmail.com", "pwd123"); // 로그인 테스트
//        login("haru@gmail.com' OR '1' = '1", "sdfsadfasdf"); // 로그인 테스트
    }

    // 로그인
    public static void login(String email, String password){ // 로그인 기능입니다.
        String sql = "SELECT * FROM member WHERE email = '"+email+"' AND password = '"+password+"'"; // 사용자가 입력한 값을 SQL 문자열에 직접 붙입니다. 이러면 sql 인젝션의 발생 가능성이 있다.
        System.out.println("로그인 쿼리: " + sql);// sql 변수에 저장되어 있는 내용을 "로그인 쿼리: " 문자열 뒤에 이어 붙입니다.

        // 여기서는 앞으로 사용할 객체를 미리 준비합니다.
        Connection conn = null; // 데이터베이스와 연결하는 객체입니다.
        Statement stmt = null; // SQL을 실행하는 객체입니다.
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
            stmt = conn.createStatement();

            // 3. SQL 실행(SELECT)
            // 4. 결과 수신(ResultSet 객체 생성)
            rs = stmt.executeQuery(sql);

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
            try{ if(stmt != null) stmt.close(); } catch (Exception e){ }
            try{ if(conn != null) conn.close(); } catch (Exception e){ }
        }
    }

    // 회원 목록 조회
    public static void selectAllMembers(){
        Connection conn = null; // 데이터베이스와 연결하는 객체 선언
        Statement stmt = null; // SQL을 실행하는 객체입니다.
        ResultSet rs = null;
        // 조회가 아니므로 ResultSet은 필요하지 않습니다.

        try{ // 플랜 A
            // 1. 데이터베이스 연결(Connection 객체 생성)
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 2. SQL 실행 객체 생성(Statement 객체 생성)
            stmt = conn.createStatement();

            // 3. SQL 실행(SELECT)
            // 4. 결과 수신(ResultSet 객체 생성)
            rs = stmt.executeQuery("SELECT * FROM member");
            // Statement 객체(stmt)를 이용해 SELECT * FROM member SQL을 실행하고, 조회된 회원 정보를 ResultSet 객체(rs)에 저장하는 코드입니다.
            // executeQuery(): SELECT 문을 실행해!라는 의미

            while(rs.next()){ // rs에 저장된 실행결과를 한 행씩 읽어와 출력합니다. 이동한 행이 있으면 true, 더 이상 행이 없으면 false를 반환
                int id = rs.getInt("id"); // 데이터 꺼내기, 현재 행의 id 컬럼 값을 가져옵니다.
                String email = rs.getString("email"); // 이메일 데이터 가져오기
                String name = rs.getString("name"); // 이름 데이터 가져오기
                String phone = rs.getString("phone"); // 전화번호 데이터 가져오기

                System.out.println("ID: " + id + ", 이메일: " + email + ", 이름: " + name + ", 전화번호: " + phone); // 정보 출력
            }

        }catch(Exception e){ // 플랜 B, try 블록에서 예외가 발생하면 실행됩니다.
            System.out.println("에러 발생: " + e.getMessage()); // 오류 메시지를 출력하고,
            e.printStackTrace(); // e.printStackTrace()로 오류가 발생한 위치와 원인을 자세히 출력합니다.
        }finally{ // finally는 성공하든 실패하든 반드시 실행되는 블록
            // 5. 생성된 리소스를 생성의 역순으로 해제
            try{ if(rs != null) rs.close(); } catch (Exception e){ } // 조회 결과를 담고 있던 ResultSet을 닫습니다.
            try{ if(stmt != null) stmt.close(); } catch (Exception e){ } // SQL 실행 객체를 닫습니다.
            try{ if(conn != null) conn.close(); } catch (Exception e){ } // 데이터베이스 연결을 닫습니다.
        }
    }

    // 회원 등록
    public static void insertMember(String email, String password, String name, String phone, int recommenderId){ // recommenderId: 추천한 회원의 ID(회원 번호)를 저장하는 변수나 매개변수
        Connection conn = null;
        Statement stmt = null;

        try{ // 플랜 A
            // 1. 데이터베이스 연결(Connection 객체 생성)
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 2. SQL 실행 객체 생성(Statement 객체 생성)
            stmt = conn.createStatement();

            // 3. SQL 실행
            int affectedRows = stmt.executeUpdate("INSERT INTO member (email, password, name, phone, recommender_id) VALUES \n" +
                    "    ('"+email+"', '"+password+"', '"+name+"', '"+phone+"', "+recommenderId+")");
            // stmt는 Statement 객체, executeUpdate()는 INSERT, UPDATE, DELETE SQL을 실행하는 메서드입니다.
            // affectedRows: 반환값은 영향을 받은 행(Row)의 개수입니다.
            // INSERT INTO member: member 테이블에 새로운 회원을 추가하라.
            // 왜 recommenderId만 작은따옴표가 없을까? 문자열은 작은따옴표를 붙이고, 숫자는 작은따옴표를 붙이지 않습니다.
            // 이 코드는 Statement로 문자열을 직접 이어 붙이고 있습니다. 이런 방식은 SQL 인젝션(SQL Injection) 공격에 취약합니다. 그래서 잘 사용 안함

            System.out.println("회원 등록 완료: " + affectedRows + "건 반영됨.");

        }catch(Exception e){ // 플랜 B, 예외가 발생하면 실행됩니다.
            System.out.println("에러 발생: " + e.getMessage()); // 오류 메시지를 출력합니다.
            e.printStackTrace(); // e.printStackTrace()로 오류가 발생한 위치와 원인을 자세히 출력합니다.
        }finally{ // 성공하든 실패하든 반드시 실행됩니다.
            // 5. 생성된 리소스를 생성의 역순으로 해제
            try{ if(stmt != null) stmt.close(); } catch (Exception e){ } // SQL 실행 객체 닫기
            try{ if(conn != null) conn.close(); } catch (Exception e){ } // Connection을 닫습니다.
        }
    }

    // 회원 수정
    public static void updateMember(int id, String password, String name, String phone){
        Connection conn = null;
        Statement stmt = null;

        try{ // 플랜 A
            // 1. 데이터베이스 연결(Connection 객체 생성)
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 2. SQL 실행 객체 생성(Statement 객체 생성)
            stmt = conn.createStatement();

            // 3. SQL 실행
            int affectedRows = stmt.executeUpdate(
                    "UPDATE member SET password = '"+password+"', name = '"+name+"', phone = '"+phone+"' WHERE id = " + id);

            System.out.println("회원 수정 완료: " + affectedRows + "건 반영됨.");

        }catch(Exception e){ // 플랜 B
            System.out.println("에러 발생: " + e.getMessage());
            e.printStackTrace();
        }finally{
            // 5. 생성된 리소스를 생성의 역순으로 해제
            try{ if(stmt != null) stmt.close(); } catch (Exception e){ }
            try{ if(conn != null) conn.close(); } catch (Exception e){ }
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
            // Auto Commit이란? SQL을 실행할 때마다 자동으로 데이터베이스에 저장(Commit)하는 기능
            // setAutoCommit(false): 자동으로 COMMIT하지 마, 수동으로 커밋할게
            // 자동 저장(Auto Commit)을 끄고, 여러 SQL을 하나의 트랜잭션으로 묶어서 commit()이나 rollback()을 직접 제어할 수 있도록 설정하는 코드입니다.

            // 3. SQL 실행
            int affectedRows = stmt.executeUpdate("DELETE FROM post WHERE member_id=" + id);
            System.out.println("회원의 모든 게시글 삭제 완료: " + affectedRows + "건 반영됨.");

            // 10초 동안 휴식, 현재 실행 중인 프로그램(스레드)을 일정 시간 동안 멈추는 코드
            Thread.sleep(1000 * 10);
            // sleep()의 단위는 밀리초(ms), 1000ms = 1초, 10000ms = 10초

            affectedRows = stmt.executeUpdate("DELETE FROM member WHERE id=" + id);
            System.out.println("회원 삭제 완료: " + affectedRows + "건 반영됨.");

            // 성공
            conn.commit(); // 지금까지 실행한 SQL들을 모두 데이터베이스에 최종 저장해라.
        }catch(Exception e){ // 플랜 B, try 안에서 오류가 발생하면 여기로 와라.
            System.out.println("에러 발생: " + e.getMessage());
            try{ if(conn != null) conn.rollback(); } catch (Exception e2){ } // rollback()의 의미는 지금까지 실행한 SQL을 모두 취소하고 원래 상태로 되돌려라.
            //if(conn != null)을 확인하는 이유는 db연결이 실패해서 null이면 rollback을 호출할 수 없도록하려고
            // 왜 Exception e2를 쓰지? 이미 바깥에서 catch(Exception e)를 사용하고 잇기 때문에 같은이름 사용 불가
            e.printStackTrace(); // 오류를 자세하게 출력
        }finally{ // 오류가 있든 없든 반드시 실행되는 블록
            // 5. 생성된 리소스를 생성의 역순으로 해제
            try{ if(stmt != null) stmt.close(); } catch (Exception e){ } // SQL 실행 객체를 닫습니다.
            try{ if(conn != null) conn.close(); } catch (Exception e){ } // Connection을 닫습니다.
            // conn.close는 Connection Pool을 사용하지 않는 경우이기 때문에 실제로 db연결이 종료된다.
        }
    }

}