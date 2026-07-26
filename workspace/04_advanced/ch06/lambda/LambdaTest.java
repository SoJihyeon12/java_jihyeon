package ch06.lambda;
// 이 코드는 같은 기능(두 수를 더하기)을 세 가지 방법으로 구현한 예제입니다.
//1. 내부 클래스(Inner Class) : test1()
//2. 익명 클래스(Anonymous Class) : test2()
//3. 람다식(Lambda Expression) : test3()
// main() → test3() 실행
//람다식이 왜 만들어졌는지 이해하기 좋은 예제입니다.

// 내부 클래스, 코드 길이 가장 김, 클래스를 직접 만들어 구현
// 익명 클래스, 코드 길이 중간, 이름 없는 클래스를 즉석에서 생성
// 람다식, 코드 길이 가장 짧음, 함수형 인터페이스를 간결하게 구현

public class LambdaTest {

    // 인터페이스를 직접 구현한 클래스 정의, 첫번째 방법
    void test1(){
        // Inner Class
        class CalculatorImpl implements Calculator{ // 내부 클래스 선언, Calculator 인터페이스를 구현하는 클래스를 메서드 안에서 만들었습니다. 이것을 내부 클래스(Local Inner Class) 라고 합니다.
            @Override
            public int add(int a, int b) { // add() 구현
                return  a + b;
            }
        }
        // 객체 생성
        Calculator cal1 = new CalculatorImpl();
        System.out.println(cal1.add(10, 20));
    }

    // 익명 클래스로 클래스 선언과 동시에 객체를 생성, 두번째 방법
    // 이번에는 클래스를 따로 만들지 않습니다.
    void test2(){
        Calculator cal1 = new Calculator() { // 이 부분은 이름 없는 클래스(Anonymous Class)
            @Override
            public int add(int a, int b) {
                return  a + b;
            }
        };
        System.out.println(cal1.add(30, 40));
    }

    // 람다식 사용, 세번째 방법
    Calculator test3(){
        int defaultVal = 10; // 지역 변수 하나를 만듭니다.

        Calculator cal1 = (int a, int b) ->  a + b + defaultVal; // 람다식은 익명 클래스를 더 간단하게 표현한 문법입니다. defaultVal을 사용할 수 있는 이유: 이 지역 변수는 람다식 안에서도 사용할 수 있습니다. 가능한 이유는 defaultVal이 변경되지 않는 값이기 때문입니다.
        System.out.println(cal1.add(50, 60)); // 자바에서는 람다식 안에서 사용하는 지역 변수는 final이거나 사실상 final(effectively final) 이어야 합니다.
        return cal1; // 람다식을 반환합니다.
    }

    void main(){
//        test1();
//        test2();
        Calculator cal = test3();
        System.out.println(cal.add(10, 20));
    }


}