package ch05.multi;
//이 프로그램은 3개의 작업을 각각 다른 스레드에서 동시에 실행하는 예제입니다.
// 이 코드는 여러 개의 스레드를 동시에 실행하는 예제입니다.
//1. 홀수 출력 스레드 (OddNum)
//2. 짝수 출력 스레드 (EvenNum)
//3. 3의 배수 출력 스레드 (익명 클래스)

public class MultiThreadTest { // 멀티스레드를 테스트하기 위한 클래스입니다.
    void main() throws InterruptedException{ // throws InterruptedException은 sleep()이나 join() 같은 메서드에서 발생할 수 있는 예외를 처리하기 위해 작성한 것입니다.
        System.out.println("1. main 시작.");

        OddNum odd = new OddNum(); // OddNum 객체 생성
        EvenNum even = new EvenNum(); // EvenNum 객체 생성

        odd.start(); // 홀수 스레드 시작
        new Thread(even, "짝수 스레드").start(); // 짝수 스레드 시작
        // 익명 클래스
        // Runnable 인터페이스를 구현하는 이름 없는 클래스, 익명 클래스, 이 부분은 이름이 없는 Runnable 클래스를 만드는 코드입니다.
        new Thread(new Runnable(){
            @Override
            public void run() { // 새로운 스레드가 시작되면 실행되는 메서드입니다.
                for(int i=3; i<=10; i+=3){ //3의 배수를 출력함
                    System.out.println("3의 배수: " + i);
                }
            }
        }).start(); // 익명 Runnable을 실행하는 새로운 스레드를 시작합니다.

//        Thread.sleep(1000*10); //메인 스레드가 10초동안 잠시 멈춘다.
//        odd.join(); // OddNum 스레드가 끝날 때까지 main 스레드는 기다려라.

        System.out.println("8. main 종료.");
    }
}


//이 코드는 실제 Java Thread 클래스의 동작 원리를 이해하기 쉽게 단순화한 예시입니다.
/*
class Thread{
    Runnable task; // Runnable 객체를 저장하는 변수입니다.
    Thread(){ } // Runnable 없이 Thread를 생성하는 경우입니다.
    Thread(Runnable r){ // Runnable을 전달받으면(아래)
        task = r; // 로 저장합니다.
    }
    public void start(){ // 실제로는 운영체제(OS)에 새로운 스레드를 생성해 달라고 요청하는 복잡한 작업을 수행합니다. 이해돕기위해 간단히 표시한 것
        // OS로부터 스레드를 할당받고...
        // 스케쥴러에 스레드를 등록하고...
        // 어쩌고 저쩌고....

        if (task == null) { // Thread를 상속받은 클래스라면 자신의 run()을 실행합니다.
            run();
        }else{ // task가 있는 경우 Runnable을 전달받았다면 그 Runnable의 run()을 실행합니다.
            task.run();
        }
    }
    public void run(){
        System.out.println("Thread의 run 실행.");
    }
}
*/