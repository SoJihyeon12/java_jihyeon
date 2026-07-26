package ch05.single;
// 이 코드는 1부터 10까지의 홀수를 출력하는 클래스입니다.
// 앞에서 본 **멀티스레드의 EvenNum**과 비슷하지만, 이 클래스는 Thread를 상속받거나 Runnable을 구현하지 않은 일반 클래스입니다.
// 단순히 run()이라는 이름의 메서드를 가진 일반 클래스입니다.

public class OddNum {
    public void run(){
        System.out.println("2. 홀수 출력 시작.");
        // 1~10까지 홀수를 출력한다.
        for(int i=1; i<=10; i+=2){
            System.out.println("3. 홀수: " + i);
        }
        System.out.println("4. 홀수 출력 종료.");
    }
}