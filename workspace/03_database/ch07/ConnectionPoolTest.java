package ch07;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionPoolTest { // Connection Pool을 이용해서 데이터베이스를 테스트하는 클래스
    //Connection Pool(커넥션 풀)은 데이터베이스 연결(Connection)을 미리 여러 개 만들어 놓고 필요할 때 빌려 쓰고 다시 반납하는 방식
    //Connection Pool(커넥션 풀)은 DB 연결을 재사용하는 창고
    //Spring Boot에서는 보통 HikariCP라는 Connection Pool을 기본으로 사용합니다.
    //왜 필요한가?
    //자바에서 데이터베이스를 사용할 때마다 DB에 연결(Connection 생성) SQL 실행 연결 종료(Connection 닫기)를 반복하면 DB 연결을 만드는 작업이 시간이 많이 걸립니다.
    //그래서 커넥션 풀을 사용함.

    private static DataSource dataSource; //데이터베이스 연결(Connection)을 만들어주는 객체, 미리 만들어 놓은 Connection을 관리, 필요하면 하나 꺼내 쓰고, 다 쓰면 다시 반납합니다.
    //private 현재 클래스 안에서만 사용할 수 있다는 뜻
    //static: 프로그램이 시작될 때 한 번만 생성됩니다. 즉, ConnectionPoolTest 객체를 여러 개 만들어도 dataSource는 하나만 존재합니다.
    //첫 번째 DataSource → 자료형(Type)
    //두 번째 dataSource → 변수 이름(Variable Name)

    static { // static 블록 : 이 부분은 프로그램이 시작되자마자 딱 한 번 실행됩니다.
        HikariConfig config = new HikariConfig("/hikari.properties"); // 설정파일 읽기: hikari.properties 파일의 설정을 읽고 config 객체를 만듦
        dataSource = new HikariDataSource(config); // config 설정을 이용해서 HikariDataSource 객체(Connection Pool을 관리하는 객체)를 생성하고, 그 객체를 dataSource 변수에 저장한다.
    }

    public static void main(String[] args){ //자바 프로그램을 시작해서 데이터베이스(CRUD)를 테스트하는 가장 먼저 실행되는 메인 메서드, 여기서는 CRUD를 하나씩 테스트합니다.
        findAll(); // 모든 게시글 조회
        insert(2, "2번이 등록한 게시글", "안녕하세요. 자바 공부 해요."); // 게시글 등록입니다.
        findById(10); // 10번 게시글 조회
        update(10, "수정된 10번 게시글", "수정했어요"); // 10번 게시글 수정
        findAll(); // 수정이 제대로 되었는지 확인하기 위해 다시 조회합니다.
        delete(10); // 10번 게시글 삭제

        deleteAll(2); // 회원번호가 2인 사람이 작성한 게시글을 모두 삭제합니다.
        findAll("자바"); // 제목이나 내용에 '자바'가 들어간 게시글만 조회합니다.

        login("haru@gmail.com", "123"); // 아이디와 비밀번호가 맞는지 로그인 테스트합니다.
        login("haru@gmail.com", "pwd123"); // 비밀번호를 바꿔서 로그인 테스트
        login("haru@gmail.com' OR '1' = '1", "sdfsadfasdf"); // 이건 SQL 인젝션 공격이 되는지 테스트하는 코드입니다. 하지만 PreparedStatement를 사용해서 입력값이 문자열처리되어 공격이 성공하지 않습니다.

        // 메인 메서드 마지막에 풀을 명시적으로 종료, 이 코드는 Connection Pool(HikariDataSource)을 종료하는 코드
        if(dataSource != null){ // dataSource가 비어 있지 않으면 실행하라는 뜻입니다.
            ((HikariDataSource)dataSource).close(); // (HikariDataSource)dataSource는 형변환하는 것이다.
            // 현재 변수는 private static DataSource dataSource이다. 즉, 자료형이 DataSource 입니다.
            // 하지만 실제 저장된 객체는 dataSource = new HikariDataSource(config)이므로 HikariDataSource 객체이다.
            // 왜 형변환을 할까? dataSource의 타입은 DataSource이므로 dataSource.close();를 호출할 수 없습니다.
            // 왜냐하면 DataSource 인터페이스에는 close() 메서드가 없기 때문입니다.
            // 하지만 실제 객체는 HikariDataSource이므로 HikariDataSource의 close()를 사용할 수 있습니다.
            // 그래서 (HikariDataSource)dataSource로 형변환합니다.

            // .close(): Connection Pool을 종료하라. 더 이상 Connection을 빌려줄 수 없게 됩니다. 보통 프로그램이 종료될 때 실행, 자원 낭비되지 않게 메모리와 DB 연결을 깔끔하게 해제할 수 있습니다.
        }
    }

    // 로그인
    public static void login(String email, String password){ // login() : 로그인 메서드, String email, String password : 사용자가 입력한 이메일과 비밀번호를 받는 매개변수
        String sql = "SELECT * FROM member WHERE email = ? AND password = ?"; // ?는 아직 값이 정해지지 않은 자리(자리표시자, Placeholder) 입니다. 나중에 자바에서 값을 넣습니다.

        // 여기서는 앞으로 사용할 객체를 미리 준비합니다.
        Connection conn = null; // 데이터베이스와 연결하는 객체입니다.
        PreparedStatement pstmt = null; // SQL을 실행하는 객체입니다.
        ResultSet rs = null; // 조회 결과를 저장하는 객체입니다.

        try{ // 플랜 A, try문에서는 여기서는 정상적으로 실행되는 코드(플랜 A)를 작성합니다. 예외가 발생하면 catch로 이동합니다
            // 1. 데이터베이스 연결(Connection 객체 생성)
            conn = dataSource.getConnection(); // Connection Pool(=dataSource)에서 Connection 하나를 가져(빌려)옵니다.

            // 2. SQL 실행 객체 생성(Statement 객체 생성), PreparedStatement는 자바에서 SQL을 데이터베이스에 안전하게 전달하고 실행하는 객체입니다. SQL을 실행해 주는 도구라고 생각하자.
            pstmt = conn.prepareStatement(sql); // 조금 전에 만든 SQL을 실행할 준비를 합니다. 아직 실행은 안 합니다.

            // 3. SQL 실행(SELECT)
            // 4. 결과 수신(ResultSet 객체 생성)
            pstmt.setString(1, email); // ?에 값 넣기
            pstmt.setString(2, password); // ?에 값 넣기
            rs = pstmt.executeQuery(); // 드디어 SQL을 실행합니다. SELECT문이므로 executeQuery():데이터를 조회(검색)해서 결과(ResultSet)를 반환하는 메서드를 사용한다. 실행결과는 ResultSet에 저장됩니다.

            if(rs.next()){ // 결과 확인: rs.next()는 조회 결과가 있는지 확인하면서 첫 번째 행으로 이동하는 메서드입니다. 첫번째 행에 데이터가 있으면 로그인 성공, 데이터가 없으면 로그인 실패
                int id = rs.getInt("id"); // 로그인 성공이면 그 조회결과의 id 컬럼 값을 가져옵니다.
                String name = rs.getString("name"); // 조회결과의 이름을 가져옵니다.
                String phone = rs.getString("phone"); // 조회결과의 전화번호를 가져옵니다.

                System.out.println("로그인에 성공했습니다."); // 로그인 성공 출력
                System.out.println("ID: " + id + ", 이메일: " + email + ", 이름: " + name + ", 전화번호: " + phone); //정보출력
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
            try{ if(pstmt != null) pstmt.close(); } catch (Exception e){ }
            try{ if(conn != null) conn.close(); } catch (Exception e){ }
        }
    }

    // 등록(C), 이 메서드는 게시글을 데이터베이스에 등록(INSERT) 하는 메서드
    static void insert(int memberId, String title, String content){ // 회원번호, 게시글 제목, 게시글 내용을 등록한다.
        String sql = "INSERT INTO post (member_id, title, content) VALUES (?, ?, ?)"; // 실제로 실행될 SQL입니다. ?는 값이 들어갈 자리(매개변수 자리)

        // 두 객체를 담을 변수를 미리 만들어 둡니다.
        Connection conn = null; // 데이터베이스와 연결하는 객체, 처음에는 아직 객체가 없으므로 null로 초기화합니다.
        PreparedStatement pstmt = null; // SQL을 실행하는 객체, 처음에는 아직 객체가 없으므로 null로 초기화합니다.

        // try{의 의미는 "이 안의 코드를 실행해 보고, 오류가 나면 catch로 가."이다.
        try{ // 플랜 A
            // 1. 데이터베이스 연결(Connection 객체 생성)
            conn = dataSource.getConnection(); // DB 연결, 여기서 dataSource는 HikariCP(Connection Pool)를 가리킵니다. getConnection()를 호출하면 Connection Pool에서 Connection 하나를 빌려옵니다.

            // 2. SQL 실행 객체 생성(Statement 객체 생성)
            pstmt = conn.prepareStatement(sql); // PreparedStatement라는 sql 실행 객체 생성

            // 3. SQL 실행
            pstmt.setInt(1, memberId); // ?에 값 넣기, 저위에 sql문에서 VALUES (?, ?, ?) 첫번째 ?에 memberid를 넣는다.
            pstmt.setString(2, title); // ?에 값 넣기, 저위에 sql문에서 VALUES (?, ?, ?) 두번째 ?에 title를 넣는다.
            pstmt.setString(3, content); // ?에 값 넣기, 저위에 sql문에서 VALUES (?, ?, ?) 세번째 ?에 content를 넣는다.
            int affectedRows = pstmt.executeUpdate(); // executeUpdate()는 INSERT, UPDATE, DELETE를 실행하는 메서드입니다. 반환값은 int이다. 즉, 몇 개의 행이 영향을 받았는지 알려줍니다.
            // affectedRows: SQL 실행 후 영향을 받은(변경된) 행(Row)의 개수를 저장하는 변수, 게시글 1개가 등록되면 affectedRows는 1이 된다.

//            System.out.println("게시글 등록 완료: " + affectedRows + "건 반영됨.");

        }catch(Exception e){ // 플랜 B, 실행 중 오류가 발생하면 여기로 옵니다.
            System.out.println("에러 발생: " + e.getMessage()); // 오류가 발생하면, 오류 메시지를 출력하고
            e.printStackTrace(); // 오류가 발생한 위치와 원인까지 자세히 출력합니다.
        }finally{ // finally는 오류가 발생하든 안 하든 반드시 실행되는 블록입니다.
            // 5. 생성된 리소스를 생성의 역순으로 해제
            try{ if(pstmt != null) pstmt.close(); } catch (Exception e){ } // SQL 실행 객체를 닫습니다.
            try{ if(conn != null) conn.close(); } catch (Exception e){ } // Connection을 닫습니다. 여기서 HikariCP를 사용하고 있으므로 conn.close();는 실제로 Connection을 Connection Pool에 반납하는 것입니다.
        }
    }

    // 모든 게시글 목록 조회(R)
    static void findAll(){
        findAll("");
    } // 검색어를 빈 문자열("")로 전달해서 전체 게시글을 조회하라. findAll()은 매개변수가 없는 메서드이지만 실제로는 findAll(""); 메서드를 호출한다.

    // 게시글 검색 목록 조회(R)
    static void findAll(String keyword){ // 이 메서드는 검색어(keyword)를 받아 게시글을 조회하는 메서드
        String sql = "SELECT id, title, view_count viewCount, created_at AS createdAt FROM post"; //처음에는 모든 게시글을 조회하는 SQL입니다. as는 별칭

        // 의미있는 검색어가 전달되었을 경우
        boolean hasKeyword = keyword != null && !keyword.equals(""); //검색어가 있는 상태인지 확인합니다. & 빈 문자열이 아닌지 확인합니다. equals()는 두 문자열(String)의 내용이 같은지 비교하는 메서드, 문자열은 equals()로 비교함
        if(hasKeyword){ // 둘 다 만족하면 hasKeyword는 true가 됨. 그런데 위에서 findAll(""); 메서드, 즉, 검색어가 없는 메서드를 호출하므로 hasKeyword는 항상 FALSE가 됨
            sql += " WHERE title LIKE ? OR content LIKE ?"; // 검색어가 있다면 기존 SQL에 WHERE title LIKE ? OR content LIKE ?을 붙인다.
        }

        Connection conn = null; // DB 연결, Connection Pool에서 Connection을 하나 빌립니다.
        PreparedStatement pstmt = null; // PreparedStatement 생성, 현재 만들어진 SQL을 실행할 준비를 합니다.
        ResultSet rs = null; // 조회(SELECT) 결과를 저장할 ResultSet 객체를 선언하고, 아직 객체가 없으므로 null로 초기화하는 코드입니다.

        try{ // 플랜 A
            // 1. 데이터베이스 연결(Connection 객체 생성)
            conn = dataSource.getConnection();

            // 2. SQL 실행 객체 생성(Statement 객체 생성)
            pstmt = conn.prepareStatement(sql);

            // 3. SQL 실행
            if(hasKeyword){ // hasKeyword가 true일 때(검색어가 있을때)만 실행됩니다. 검색어가 있을 때만 ?에 값을 넣습니다.
                pstmt.setString(1, "%" + keyword + "%"); // 첫 번째 ?에 값을 넣습니다. 첫 번째 ?는 title LIKE ?부분, 즉, title LIKE '%검색어%' 가 실행됨
                pstmt.setString(2, "%" + keyword + "%"); // 두 번째 ?에도 값을 넣습니다. 두 번째 ?는 content LIKE ? 부분, 즉, content LIKE '%검색어%' 가 실행됨
            }
            rs = pstmt.executeQuery(); // 이제 SQL을 실제로 실행합니다. executeQuery()는 SELECT 문을 실행하는 메서드입니다. 실행 결과는 ResultSet 객체인 rs에 저장됩니다.

            // 4. 결과 처리(ResultSet 사용)
            while(rs.next()){ // rs에 저장된 실행결과를 한 행씩 읽어와 출력합니다. 이동한 행이 있으면 true, 더 이상 행이 없으면 false를 반환
                int id = rs.getInt("id"); // 데이터 꺼내기, 현재 행의 id 컬럼 값을 가져옵니다.
                String title = rs.getString("title"); // 현재 행의 title 값을 가져옵니다.
                int viewCount = rs.getInt("viewCount"); // 조회수를 가져옵니다.
                String createdAt = rs.getString("createdAt"); // 작성일을 가져옵니다.

                System.out.println("ID: " + id + ", 제목: " + title + ", 조회수: " + viewCount + ", 작성일: " + createdAt); // 가져온 정보 출력
            }

        }catch(Exception e){ // 플랜 B, try 블록에서 예외가 발생하면 실행됩니다.
            System.out.println("에러 발생: " + e.getMessage()); // 오류 메시지를 출력하고,
            e.printStackTrace(); // e.printStackTrace()로 오류가 발생한 위치와 원인을 자세히 출력합니다.
        }finally{ // finally는 성공하든 실패하든 반드시 실행되는 블록
            // 5. 생성된 리소스를 생성의 역순으로 해제
            try{ if(rs != null) rs.close(); } catch (Exception e){ } // 조회 결과를 담고 있던 ResultSet을 닫습니다.
            try{ if(pstmt != null) pstmt.close(); } catch (Exception e){ } // SQL 실행 객체를 닫습니다.
            try{ if(conn != null) conn.close(); } catch (Exception e){ } // 데이터베이스 연결을 닫습니다. 여기서 HikariCP(Connection Pool)를 사용하고 있으므로 conn.close()는 실제로 연결을 끊는 것이 아니라 Connection Pool에 반납하는 것입니다.
        }
    }

    // 한건 조회(R)
    static void findById(int id){ // 게시글 번호(id)를 이용해서 게시글 한 개만 조회하는 기능(Read)
        String sql = "SELECT id, title, content, view_count viewCount, created_at AS createdAt FROM post WHERE id = ?"; // WHERE id = ?는 게시글 번호가 ?인 게시글만 조회

        Connection conn = null; // 데이터베이스와 연결하는 객체 선언
        PreparedStatement pstmt = null; // SQL 실행하는 객체 선언
        ResultSet rs = null; // 조회 결과 저장하는 객체 선언

        try{ // 플랜 A
            // 1. 데이터베이스 연결(Connection 객체 생성)
            conn = dataSource.getConnection(); // DB 연결, Connection Pool(HikariCP)에서 Connection 하나를 가져옵니다.

            // 2. SQL 실행 객체 생성(Statement 객체 생성)
            pstmt = conn.prepareStatement(sql); // 작성한 SQL을 실행할 준비를 합니다. 아직 실행은 하지 않습니다.

            // 3. SQL 실행
            pstmt.setInt(1, id); // ?에 id라는 값 넣기, SQL은 WHERE id = ?였는데 여기에 parameterIndex는 PreparedStatement에서 ?가 몇 번째인지 나타내는 번호 그니까 첫번째 ?라는 의미
            rs = pstmt.executeQuery(); // 이제 SQL을 실제로 실행합니다. executeQuery()는 SELECT 문을 실행하는 메서드입니다. 실행 결과는 ResultSet 객체인 rs에 저장됩니다.

            // 4. 결과 처리(ResultSet 사용)
            while(rs.next()){ // 다음 행으로 이동
                String title = rs.getString("title"); //컬럼 값 가져오기, title 컬럼을 가져온다.
                String content = rs.getString("content");// 내용을 가져옵니다.
                int viewCount = rs.getInt("viewCount"); //조회수를 가져옵니다.
                String createdAt = rs.getString("createdAt"); //작성일을 가져옵니다.

                System.out.println("ID: " + id + ", 제목: " + title + ", 내용: " + content + ", 조회수: " + viewCount + ", 작성일: " + createdAt); // 정보 출력
            }

        }catch(Exception e){ // 플랜 B, 예외가 발생하면 실행됩니다.
            System.out.println("에러 발생: " + e.getMessage()); // 오류 메시지를 출력합니다.
            e.printStackTrace(); // e.printStackTrace()로 오류가 발생한 위치와 원인을 자세히 출력합니다.
        }finally{ // 성공하든 실패하든 반드시 실행됩니다.
            // 5. 생성된 리소스를 생성의 역순으로 해제
            try{ if(rs != null) rs.close(); } catch (Exception e){ } // 조회 결과 닫기
            try{ if(pstmt != null) pstmt.close(); } catch (Exception e){ } // SQL 실행 객체 닫기
            try{ if(conn != null) conn.close(); } catch (Exception e){ } // Connection Pool에 Connection 반납
        }
    }

    // 수정(U)
    static void update(int id, String title, String content){ // 게시글을 수정(Update)하는 기능, id 게시글의 제목과 내용을 수정
        String sql = "UPDATE post SET title = ?, content = ? WHERE id = ?"; // ?는 나중에 자바에서 값을 넣습니다.

        Connection conn = null; // 데이터베이스와 연결하는 객체 선언
        PreparedStatement pstmt = null; // sql 실행하는 객체 선언
        // 조회가 아니므로 ResultSet은 필요하지 않습니다.

        try{ // 플랜 A
            // 1. 데이터베이스 연결(Connection 객체 생성)
            conn = dataSource.getConnection();

            // 2. SQL 실행 객체 생성(Statement 객체 생성)
            pstmt = conn.prepareStatement(sql); // 작성한 SQL을 실행할 준비를 합니다. 아직 실행은 하지 않습니다.

            // 3. SQL 실행
            pstmt.setString(1, title); // 첫 번째 ?에 제목을 넣습니다.
            pstmt.setString(2, content); // 두 번째 ?에 내용을 넣습니다.
            pstmt.setInt(3, id); // 세 번째 ?에 게시글 번호를 넣습니다.
            int affectedRows = pstmt.executeUpdate(); // executeUpdate()는 INSERT, UPDATE, DELETE를 실행하는 메서드입니다. 실행이 끝나면 영향받은 행의 개수를 반환합니다.

            System.out.println("게시글 수정 완료: " + affectedRows + "건 반영됨."); // 실행이 끝나면 영향받은 행의 개수를 반환합니다.

        }catch(Exception e){ // 플랜 B, 예외가 발생하면 실행됩니다.
            System.out.println("에러 발생: " + e.getMessage()); // 오류 메시지를 출력합니다.
            e.printStackTrace(); // e.printStackTrace()로 오류가 발생한 위치와 원인을 자세히 출력합니다.
        }finally{ // 성공하든 실패하든 반드시 실행됩니다.
            // 5. 생성된 리소스를 생성의 역순으로 해제
            try{ if(pstmt != null) pstmt.close(); } catch (Exception e){ } // PreparedStatement를 닫습니다.
            try{ if(conn != null) conn.close(); } catch (Exception e){ } // Connection을 닫습니다. conn.close()는 실제 연결을 끊는 것이 아니라 Connection Pool(HikariCP)에 Connection을 반납하는 동작입니다.
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