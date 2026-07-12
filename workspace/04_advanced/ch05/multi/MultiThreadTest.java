package ch05.multi;

public class MultiThreadTest {
    void main() throws InterruptedException{
        System.out.println("1. main 시작.");

        OddNum odd = new OddNum();
        EvenNum even = new EvenNum();

        odd.start();
        new Thread(even, "짝수 스레드").start();
        // 익명 클래스
        // Runnable 인터페이스를 구현하는 이름 없는 클래스
        new Thread(new Runnable(){
            @Override
            public void run() {
                for(int i=3; i<=10; i+=3){
                    System.out.println("3의 배수: " + i);
                }
            }
        }).start();

//        Thread.sleep(1000*10);
//        odd.join();

        System.out.println("8. main 종료.");
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