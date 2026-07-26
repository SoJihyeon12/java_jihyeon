package ch07;
//커넥션 풀(Connection Pool)을 사용했을 때와 사용하지 않았을 때의 성능(Performance)을 테스트하는 클래스입니다.

public class PerformanceTest {
    public static void main(String[] args){
        ConnectionPoolTest.findAll(); // 게시글 목록을 한 번 조회합니다. 이 코드는 미리 커넥션 풀을 초기화하는 역할도 합니다.

        long start1 = System.currentTimeMillis(); // 첫번째 테스트 시작 시간을 저장합니다. 밀리초(ms) 값이 저장됩니다. long을 사용하는 이유는 시간 값이 매우 크기 때문입니다.
        System.out.println("첫번째 테스트 시작");
        for(int i=1; i<=10; i++){ // 커넥션 풀 없이 게시글 10개 등록
            JdbcPostPreparedTest.insert(2, "커넥션 풀 사용 안함 - " + i, "내용");
        }
        System.out.println("첫번째 테스트 종료");
        long end1 = System.currentTimeMillis(); // 테스트가 끝난 시간을 저장합니다.
        System.out.println("커넥션 풀을 사용하지 않을 경우 소요 시간: " + (end1 - start1) + "ms");

        long start2 = System.currentTimeMillis(); // 두 번째 테스트 시작 시간을 저장합니다.
        System.out.println("두번째 테스트 시작");
        for(int i=1; i<=10; i++){
            ConnectionPoolTest.insert(2, "커넥션 풀 사용함 - " + i, "내용");
        } // Connection Pool을 사용하는 메서드입니다. 새로운 연결을 계속 만드는 것이 아니라 풀에 있는 연결을 빌려서 사용합니다.
        System.out.println("두번째 테스트 종료");
        long end2 = System.currentTimeMillis(); // 두 번째 테스트 종료 시간을 저장합니다.
        System.out.println("커넥션 풀을 사용할 경우 소요 시간: " + (end2 - start2) + "ms");
    }
}
