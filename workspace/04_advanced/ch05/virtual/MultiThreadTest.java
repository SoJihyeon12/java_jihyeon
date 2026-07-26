package ch05.virtual;
// 이 코드는 가상 스레드(Virtual Thread)를 사용하여 여러 작업을 동시에 실행하는 예제입니다.
// 기존의 new Thread(...).start() 대신 **Thread.ofVirtual().start(...)**를 사용한 것이 가장 큰 차이입니다.
// 기존 스레드(Java Thread)는 운영체제(OS) Thread와 와 거의 1:1로 연결됩니다. 그래서 많이 만들면 메모리 사용량이 커지고 생성 비용도 높습니다.
// 반면 가상 스레드는 매우 가볍습니다. 수만 개, 수십만 개도 생성할 수 있습니다. 입출력(IO)이 많은 프로그램에서 특히 효율적입니다.

public class MultiThreadTest { // MultiThreadTest는 가상 스레드를 테스트하는 클래스입니다.
    void main() throws InterruptedException{ // InterruptedException은 join() 같은 메서드에서 발생할 수 있는 예외를 처리하기 위해 작성했습니다.
        System.out.println("1. main 시작.");

        // 객체 2개 생성
        OddNum odd = new OddNum();
        EvenNum even = new EvenNum();

//        odd.start(); // 이 코드는 플랫폼 스레드(Platform Thread) 를 사용하는 기존 방식입니다. odd.start() → Thread를 상속한 클래스 실행
//        new Thread(even, "짝수 스레드").start(); // new Thread(even).start() → Runnable 실행

        // 가상 스레드 생성
        Thread oddThread = Thread.ofVirtual().start(odd); // Thread.ofVirtual(): "가상 스레드를 만들 준비를 한다.", start(odd): odd의 run()을 가상 스레드에서 실행합니다.
        Thread evenThread = Thread.ofVirtual().start(even); // Thread.ofVirtual(): "가상 스레드를 만들 준비를 한다.", start(even): even의 run()을 가상 스레드에서 실행합니다.

        // 익명 클래스
        // 이름 없는 Runnable 객체를 만들어 가상 스레드에서 실행합니다.
        // Runnable 인터페이스를 구현하는 이름 없는 클래스
        Thread t3 = Thread.ofVirtual().start(new Runnable(){
            @Override
            public void run() {
                for(int i=3; i<=10; i+=3){ //3의 배수 출력
                    System.out.println("3의 배수: " + i);
                }
            }
        });

//        Thread.sleep(1000*1); // 메인 스레드가 1초동안 잠시 멈춘다. 가상 스레드는 계속 실행됩니다.
        oddThread.join(); // 이 스레드가 끝날 때까지 기다려라 라는 의미
        evenThread.join(); // 짝수 출력이 끝날 때까지 기다립니다.
        t3.join(); // 3의 배수 출력이 끝날 때까지 기다립니다.

        System.out.println("8. main 종료.");// 세 개의 가상 스레드가 모두 종료된 후에 출력
    }
}

/*
class Thread{
    Runnable task;
    Thread(){ }
    Thread(Runnable r){
        task = r;
    }
    public void start(){
        // OS로부터 스레드를 할당받고...
        // 스케쥴러에 스레드를 등록하고...
        // 어쩌고 저쩌고....

        if (task == null) {
            run();
        }else{
            task.run();
        }
    }
    public void run(){
        System.out.println("Thread의 run 실행.");
    }
}
*/