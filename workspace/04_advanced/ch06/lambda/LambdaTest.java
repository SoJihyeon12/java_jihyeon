package ch06.lambda;

public class LambdaTest {

    // 인터페이스를 직접 구현한 클래스 정의
    void test1(){
        // Inner Class
        class CalculatorImpl implements Calculator{
            @Override
            public int add(int a, int b) {
                return  a + b;
            }
        }
        Calculator cal1 = new CalculatorImpl();
        System.out.println(cal1.add(10, 20));
    }

    // 익명 클래스로 클래스 선언과 동시에 객체를 생성
    void test2(){
        Calculator cal1 = new Calculator() {
            @Override
            public int add(int a, int b) {
                return  a + b;
            }
        };
        System.out.println(cal1.add(30, 40));
    }

    // 람다식 사용
    Calculator test3(){
        int defaultVal = 10;

        Calculator cal1 = (int a, int b) ->  a + b + defaultVal;
        System.out.println(cal1.add(50, 60));
        return cal1;
    }

    void main(){
//        test1();
//        test2();
        Calculator cal = test3();
        System.out.println(cal.add(10, 20));
    }


}