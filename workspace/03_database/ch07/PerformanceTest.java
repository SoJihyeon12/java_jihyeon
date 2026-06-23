package ch07;

public class PerformanceTest {
    public static void main(String[] args){
        ConnectionPoolTest.findAll();

        long start1 = System.currentTimeMillis();
        System.out.println("첫번째 테스트 시작");
        for(int i=1; i<=10; i++){
            JdbcPostPreparedTest.insert(2, "커넥션 풀 사용 안함 - " + i, "내용");
        }
        System.out.println("첫번째 테스트 종료");
        long end1 = System.currentTimeMillis();
        System.out.println("커넥션 풀을 사용하지 않을 경우 소요 시간: " + (end1 - start1) + "ms");

        long start2 = System.currentTimeMillis();
        System.out.println("두번째 테스트 시작");
        for(int i=1; i<=10; i++){
            ConnectionPoolTest.insert(2, "커넥션 풀 사용함 - " + i, "내용");
        }
        System.out.println("두번째 테스트 종료");
        long end2 = System.currentTimeMillis();
        System.out.println("커넥션 풀을 사용할 경우 소요 시간: " + (end2 - start2) + "ms");
    }
}