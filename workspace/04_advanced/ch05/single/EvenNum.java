package ch05.single;
// 이 코드는 1부터 10까지의 짝수를 출력하는 클래스입니다.
// 앞에서 본 **멀티스레드의 EvenNum**과 비슷하지만, 이 클래스는 Thread를 상속받거나 Runnable을 구현하지 않은 일반 클래스입니다.
// 단순히 run()이라는 이름의 메서드를 가진 일반 클래스입니다.

public class EvenNum {
    public void run(){
        System.out.println("5. 짝수 출력 시작.");
        // 1~10까지 짝수를 출력한다.
        for(int i=2; i<=10; i+=2){
            System.out.println("6. 짝수: " + i);
        }
        System.out.println("7. 짝수 출력 종료.");
    }
}