package ch05.virtual;
// 이 코드는 Runnable 인터페이스를 구현하여 새로운 스레드를 만드는 두 번째 방법을 보여주는 예제
// 이 EvenNum 클래스의 역할은 새로운 스레드에서 1부터 10까지의 짝수를 출력하는 것입니다.

/**
 * Thread를 만드는 방법 2번
 * - Runnable을 구현한다.
 * - run 메서드를 구현한다.(독립적인 Thread로 실행할 코드를 작성)
 */
public class EvenNum implements Runnable{ // Runnable 인터페이스가 요구하는 메서드를 반드시 만들어야 한다. implements는 인터페이스를 구현한다는 뜻입니다.
    public void run(){ // run()에는 새로운 스레드가 실행할 작업을 작성합니다.
        System.out.println("5. " + Thread.currentThread().getName() + " 출력 시작.");
        // 1~10까지 짝수를 출력한다.
        for(int i=2; i<=10; i+=2){
            System.out.println("6. 짝수: " + i);
        }
        System.out.println("7. 짝수 출력 종료.");
    }
}