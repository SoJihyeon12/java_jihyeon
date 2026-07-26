package ch05.multi;
// 이 코드는 스레드(Thread)에서 실행할 작업을 정의한 클래스
// EvenNum의 역할은 1부터 10까지의 짝수를 출력하는 것입니다.

/**
 * Thread를 만드는 방법 2번
 * - Runnable을 구현한다.
 * - run 메서드를 구현한다.(독립적인 Thread로 실행할 코드를 작성)
 */
public class EvenNum implements Runnable{ // Runnable이란? 이 클래스는 스레드에서 실행할 작업을 가지고 있습니다.라는 뜻의 인터페이스
    public void run(){ // run()은 스레드가 실행할 작업을 작성하는 메서드입니다.
        System.out.println("5. " + Thread.currentThread().getName() + " 출력 시작."); // Thread.currentThread(): 현재 실행 중인 스레드 객체를 가져옵니다. 예를 들어 Thread-0같이..
        // 1부터 10까지의 짝수만 출력하기 위한 반복문입니다.
        for(int i=2; i<=10; i+=2){
            System.out.println("6. 짝수: " + i);
        }
        System.out.println("7. 짝수 출력 종료.");
    }
}