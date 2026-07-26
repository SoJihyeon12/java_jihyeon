package ch05.single;
// 이 코드는 싱글 스레드(Single Thread)로 프로그램을 실행하는 예제입니다.
// 모든 작업을 메인(main) 스레드 하나가 순서대로 실행합니다.
// SingleThreadTest → 한 개의 스레드가 순서대로 실행
// MultiThreadTest → 여러 개의 스레드가 동시에 실행

public class SingleThreadTest {
    void main(){
        System.out.println("1. main 시작.");

        // 객체 2개 생성
        OddNum odd = new OddNum();
        EvenNum even = new EvenNum();

        odd.run();
        even.run();

        System.out.println("8. main 종료.");
    }
}