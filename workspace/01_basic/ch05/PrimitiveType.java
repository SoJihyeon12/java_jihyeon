package ch05;

public class PrimitiveType {
    void main(){    // main 메서드 : 자바 프로그램의 시작점
        int age; // 1. 변수 선언
        age = 25; // 2. 변수에 값 할당
        System.out.println(age);
        age = 30; // 변수에 값을 재할당
        System.out.println(age);

        int score = 100; // 3. 변수 선언과 동시에 값 할당
        System.out.println(score);

        byte b = 127;
        System.out.println(b);

        short s = 10000;
        System.out.println(s);

        int num = 1000000000;
        System.out.println(num);

        long bignum = 10000000000L;
        System.out.println(bignum);

        double pi = 3.141592;
        System.out.println(pi);
        // 반지름이 5인 원의 넓이를 계산
        System.out.println(pi * 5 * 5);

        float shortPi = 3.14F;
        System.out.println(shortPi);

        boolean isGood = true;
        System.out.println(isGood);

        boolean isMan = false;
        System.out.println(isMan);

        char grade = 'A';
        System.out.println(grade);

        grade = 'B';
        System.out.println(grade);

        // 문자열 : 2글자 이상의 문자열을 저장
        // 큰따옴표로 문자를 묶어서 표현
        String firstName = "멋쟁이";
        String lastName = "사자처럼";
        System.out.println(firstName);
        System.out.println(lastName);

        // final : 상수 선언
        final double PI = 3.14;

        // 반지름이 5인 원의 넓이를 계산
        System.out.println(PI * 5 * 5);

//        PI = 3.141592; // 상수는 재할당을 할 수 없음
        System.out.println(PI * 4 * 4);
    }
}
