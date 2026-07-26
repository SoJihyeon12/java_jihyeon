package ch05.multi;
// 이 코드는 Thread를 상속받아 새로운 스레드를 만드는 첫 번째 방법을 보여주는 예제입니다.
// 이 OddNum 클래스의 역할은 새로운 스레드에서 1부터 10까지의 홀수를 출력하는 것입니다.

/**
 * Thread를 만드는 방법 1번
 * - Thread를 상속 받는다.
 * - run 메서드를 오버라이딩 한다.(독립적인 Thread로 실행할 코드를 작성)
 */
public class OddNum extends Thread{ // OddNum 클래스가 Thread 클래스를 상속받았습니다.
    OddNum(){ // 생성자는 객체를 만들 때 자동으로 실행됩니다.
        super("홀수 스레드"); // super()는 부모 클래스(Thread)의 생성자를 호출하는 코드입니다. super("홀수 스레드");: 이 스레드의 이름을 "홀수 스레드"로 지정하겠다.라는 의미
    }

    public void run(){ // run()은 새로운 스레드가 실행할 작업을 작성하는 메서드입니다. hread 클래스에도 run()이 있지만, 여기서는 오버라이드(재정의) 했습니다. 즉, 부모의 run() 대신 OddNum의 run()이 실행됩니다.
        System.out.println("2. " + Thread.currentThread().getName() + " 출력 시작."); // Thread.currentThread(): 현재 실행 중인 스레드 객체를 가져옵니다. 현재 스레드 이름 출력
        // 1~10까지 홀수를 출력한다.
        for(int i=1; i<=10; i+=2){
            System.out.println("3. 홀수: " + i);
        }
        System.out.println("4. 홀수 출력 종료.");
    }
}