package ch05.single;

public class SingleThreadTest {
    void main(){
        System.out.println("1. main 시작.");

        OddNum odd = new OddNum();
        EvenNum even = new EvenNum();

        odd.run();
        even.run();

        System.out.println("8. main 종료.");
    }
}