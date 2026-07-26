package ch06.lambda;
// 이 코드는 자바에서 기본으로 제공하는 함수형 인터페이스(Standard Functional Interface) 를 사용하는 예제입니다.
// 앞에서 직접 만든 Calculator, Dice 인터페이스 대신, 자바가 미리 만들어 놓은 함수형 인터페이스를 사용하는 방법을 보여줍니다.

// 코드에서 사용된 ::는 메서드 참조입니다.
// 메서드 참조는 기존 메서드를 그대로 호출하는 람다식을 더 간결하게 표현하는 문법입니다.

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class StandardFunctionalTest {
    void main(){
        // 입력된 데이터가 지정한 조건을 충족하는지 여부를 판단하는 함수를 만들 때 사용(리턴값은 boolean)
        Predicate<Integer> checkLimit = num -> num <= 100; // Predicate란? "조건을 검사해서 true 또는 false를 반환하는 함수"
        System.out.println(checkLimit.test(120));
        System.out.println(checkLimit.test(90));

        // 입력된 데이터를 단순히 소비하는 함수를 만들 때 사용(리턴값 없음)
//        Consumer<String> writeLog = msg -> System.out.println("로그: " + msg);
        Consumer<String> writeLog = System.out::println; // 메서드 참조 문법, Consumer란? 입력받은 데이터를 사용만 하고 반환값은 없는 함수
        writeLog.accept("사용자 로그인");
        writeLog.accept("게시글 등록");
        writeLog.accept("로그아웃");

        // 입력된 데이터를 가공하여 다른 형태나 다른 타입으로 변환하는 함수를 만들 때 사용
//        Function<String, Integer> convert = str -> Integer.parseInt(str);
        Function<String, Integer> convert = Integer::parseInt; // 메서드 참조 문법, Function이란? 입력을 받아 다른 형태로 변환하는 함수
        System.out.println("문자열을 int로 변환: " + convert.apply("100"));

        // 매개변수 없이 새로운 데이터를 반환하는 함수를 만들 때 사용
//        Supplier<Double> randomVal = () -> Math.random();
        Supplier<Double> randomVal = Math::random; // 메서드 참조 문법, Supplier란? 입력 없이 값을 만들어 반환하는 함수
        System.out.println("임의의 수: " + randomVal.get());
        System.out.println("임의의 수: " + randomVal.get());
        System.out.println("임의의 수: " + randomVal.get());

        // 주사위 만들기(입력을 6으로 하면 1~6까지 자동으로 정수 반환)
        // int를 전달받아서 1부터 전달받은 값까지의 임의의 정수를 반환하는 함수를 작성하세요.
        Function<Integer, Integer> dice = num -> (int)(Math.random()*num) + 1;

        // 아래 주석 처리된 코드는 직접 만든 함수형 인터페이스를 사용한 예입니다.
        // 지금은 Function<Integer,Integer>만으로 같은 기능을 구현할 수 있으므로 Dice 인터페이스가 없어도 됩니다.
//        Dice dice = new Dice() {
//            @Override
//            public int apply(int num) {
//                return (int)(Math.random()*num) + 1;
//            }
//        };

        System.out.println(dice.apply(6)); // 1 ~ 6
        System.out.println(dice.apply(4)); // 1 ~ 4

        // 메서드 참조를 이용해서 String을 입력받아서 글자수를 반환하는 함수를 작성하세요.
//        Function<String, Integer> strLength = str -> str.length();
        Function<String, Integer> strLength = String::length;
        System.out.println("글자수: " + strLength.apply("hello")); // 5
        System.out.println("글자수: " + strLength.apply("spring framework")); // 16
    }
}