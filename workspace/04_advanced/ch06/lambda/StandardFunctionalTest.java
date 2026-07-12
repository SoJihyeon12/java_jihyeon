package ch06.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class StandardFunctionalTest {
    void main(){
        // 입력된 데이터가 지정한 조건을 충족하는지 여부를 판단하는 함수를 만들 때 사용(리턴값은 boolean)
        Predicate<Integer> checkLimit = num -> num <= 100;
        System.out.println(checkLimit.test(120));
        System.out.println(checkLimit.test(90));

        // 입력된 데이터를 단순히 소비하는 함수를 만들 때 사용(리턴값 없음)
//        Consumer<String> writeLog = msg -> System.out.println("로그: " + msg);
        Consumer<String> writeLog = System.out::println; // 메서드 참조 문법
        writeLog.accept("사용자 로그인");
        writeLog.accept("게시글 등록");
        writeLog.accept("로그아웃");

        // 입력된 데이터를 가공하여 다른 형태나 다른 타입으로 변환하는 함수를 만들 때 사용
//        Function<String, Integer> convert = str -> Integer.parseInt(str);
        Function<String, Integer> convert = Integer::parseInt; // 메서드 참조 문법
        System.out.println("문자열을 int로 변환: " + convert.apply("100"));

        // 매개변수 없이 새로운 데이터를 반환하는 함수를 만들 때 사용
//        Supplier<Double> randomVal = () -> Math.random();
        Supplier<Double> randomVal = Math::random; // 메서드 참조 문법
        System.out.println("임의의 수: " + randomVal.get());
        System.out.println("임의의 수: " + randomVal.get());
        System.out.println("임의의 수: " + randomVal.get());

        // int를 전달받아서 1부터 전달받은 값까지의 임의의 정수를 반환하는 함수를 작성하세요.
        Function<Integer, Integer> dice = num -> (int)(Math.random()*num) + 1;

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