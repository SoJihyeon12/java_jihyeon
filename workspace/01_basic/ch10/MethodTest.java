package ch10;

public class MethodTest {


    // 10과 100의 합계를 출력하는 메서드
    void add(){ // void는 실행화면에 출력만 하고 값을 반환하지 않는다
        int n1 = 10; // 출력만 하거나 작업만 할 때 void 사용
        int n2 = 100;
        int sum = n1 + n2;
        System.out.println(n1 + " + " + n2 + " = " + sum);
    }

    // 전달되는 인자와 100의 합계를 출력하는 메서드
    void add100(int n1){ // n1: 매개변수
        int n2 = 100;
        int sum = n1 + n2;
        System.out.println(n1 + " + " + n2 + " = " + sum);
    }

    // 전달되는 인자 두개의 합계를 출력하는 메서드
    void printSum(int n1, int n2){
        int sum = n1 + n2;
        System.out.println(n1 + " + " + n2 + " = " + sum);
    }

    // 전달되는 인자 두개의 합계를 반환하는 메서드
    int getSum(int n1, int n2){
        int sum = n1 + n2;
        return sum; // 값을 돌려줘야 할때 return 사용 → int, double, String 등을 이용함
    }

    void main(){
        add();
        add();

        add100(20); // Arguments (인자, 인수)
        add100(30);

        printSum(40, 50);
        printSum(60, 70);

        int result = getSum(70, 80);
        System.out.println(result);
    }
}
