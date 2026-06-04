package ch11.statictest;

public class MathUtil {
    // 상수
    final static double PI = 3.14159; // static 필드
    int r = 5; // 인스턴스 필드

    // 원의 반지름을 구한다.
    static void area(){
        // static 메서드에서는 static 필드나 static 메서드만 사용 가능
//        System.out.println(PI * r * r);
    }

    // 메서드 내부에서 인스턴스 필드나 인스턴스 메서드를 사용하지 않을 경우에 static을 붙이면 된다.
    static int add(int n1, int n2){
        return n1 + n2;
    }
}