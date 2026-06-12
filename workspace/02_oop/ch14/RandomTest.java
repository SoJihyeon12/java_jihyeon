package ch14;

import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
//        Random random = new Random(); // 실행 결과가 매번 달라짐
    Random random = new Random(12345); // 실행 결과가 항상 같음

        // 1. nextInt(): 무작위 정수 반환
        System.out.println(random.nextInt());
        System.out.println(random.nextInt());

        // 2. nextInt(bound): 0 이상 bound 미만의 무작위 정수 반환
        System.out.println(random.nextInt(10)); // 0 ~ 9
        System.out.println(random.nextInt(10)); // 0 ~ 9
        System.out.println(random.nextInt(6) + 1); // 1 ~ 6

        // 3. nextDouble(): 0.0 이상 1.0 미만의 무작위 실수 반환
        System.out.println(random.nextDouble());
        System.out.println(random.nextDouble());

        // 4. nextBoolean(): 무작위 boolean 반환
        System.out.println(random.nextBoolean());
        System.out.println(random.nextBoolean());
    }
}