package ch05.multi;

/**
 * Thread를 만드는 방법 2번
 * - Runnable을 구현한다.
 * - run 메서드를 구현한다.(독립적인 Thread로 실행할 코드를 작성)
 */
public class EvenNum implements Runnable{
    public void run(){
        System.out.println("5. " + Thread.currentThread().getName() + " 출력 시작.");
        // 1~10까지 짝수를 출력한다.
        for(int i=2; i<=10; i+=2){
            System.out.println("6. 짝수: " + i);
        }
        System.out.println("7. 짝수 출력 종료.");
    }
}