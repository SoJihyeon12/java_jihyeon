package ch06;

public class OperatorTest {
    static void main() {
        int num1 = 5;
        int num2 = 28;
        int num3, num5;
        double num4; //double 선언은 num4의 계산값을 소수점까지 나오게 하기 위함

        num3 = num2 * num1;
        num4 = num2 / num1;
        num4 = num2 / (double) num1; // (double)은 num4를 소수점이 나오도록 계산하기 위함
        num5 = num2 % num1;

        System.out.println("28 * 5 = " + num3);
        System.out.println("28 / 5 = " + num4);
        System.out.println("28 % 5 = " + num5);

        System.out.println("++5 = " + ++num1);  // 6  이 코드가 끝나고 num1에 6이 저장됨
        System.out.println("6++ = " + num1++);  // 6  ++자체가 값 증가 + 저장(대입) 기능을 포함한 연산자
        System.out.println("num1 = " + num1);   // 7 마지막의 num1 값 7을 불러옴

        int a = 3;
        boolean b = (++a + 10) >= 14 && (2 + 3 * ++a) >= 10; // 괄호 = 연산 우선순위 표시, 앞++a는 4 뒤++a는 5
        System.out.println(b); // true
        System.out.println(a); // 5

    }
}
