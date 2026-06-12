package ch07;

// 입력한 숫자가 3의 배수일 경우 "3의 배수입니다."를 출력하고
// 입력한 숫자가 3의 배수가 아닐 경우 홀수, 짝수 여부를 출력한다.
public class IfTest {
    public static void main(String[] args) {
        int num =17;

//        if (num % 3 == 0) {
//            System.out.println(num + ": 3의 배수입니다.");
//        }
//        if (num % 3 != 0) {
//            System.out.println(num + ": 3의 배수가 아닙니다.");
//        }
        if (num % 3 == 0) { // 3의 배수일 경우
            // 조건문이 true일 경우 실행되는 블럭
            System.out.println(num + ": 3의 배수입니다.");
        } else if (num % 2 == 0) { // 2의 배수일 경우
            System.out.println(num + ": 짝수 입니다.");
        } else {
            // 조건문이 false일 경우 실행되는 블럭
            System.out.println(num + ": 홀수 입니다.");
        }
    }
}
