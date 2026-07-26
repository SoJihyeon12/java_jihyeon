package ch05.virtual;
// 이 코드는 가상 스레드(Virtual Thread) 에서 실행할 홀수 출력 작업을 정의한 클래스입니다.
// 앞에서 배운 OddNum extends Thread와 이름은 같지만, 이번에는 Thread를 상속하지 않고 Runnable을 구현했다는 점이 가장 큰 차이입니다.

// 이건 잘못된 주석이라네 ai가
/**
 * Thread를 만드는 방법 1번
 * - Thread를 상속 받는다.
 * - run 메서드를 오버라이딩 한다.(독립적인 Thread로 실행할 코드를 작성)
 */

// ai가 이 주석을 쓰래
/**
 * Thread를 만드는 방법 2번
 * - Runnable을 구현한다.
 * - run 메서드를 구현한다.
 */
public class OddNum implements Runnable{ // Runnable이란? 스레드가 실행할 작업 을 정의하는 인터페이스입니다. 즉, OddNum은 스레드 자체가 아니라 작업(Task) 입니다. 러너블은 무엇을 할 것인지만 정의하고 실제로 실행하는 것은 스레드다.
    public void run(){ // 새로운 스레드가 실행할 작업
        System.out.println("2. " + Thread.currentThread().getName() + " 출력 시작."); // Thread.currentThread(): 현재 실행 중인 스레드 객체를 가져옵니다. getName(): 현재 스레드의 이름을 가져옵니다.
        // 1~10까지 홀수를 출력한다.
        for(int i=1; i<=10; i+=2){
            System.out.println("3. 홀수: " + i);
        }
        System.out.println("4. 홀수 출력 종료.");
    }
}