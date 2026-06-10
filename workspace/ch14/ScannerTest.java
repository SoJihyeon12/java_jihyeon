package ch14;

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        String input = "Hello 123 3.14 java";
//        String input = "Hello 123";
        Scanner scanner = new Scanner(input);

        // 1. next(): 단어 읽기
        System.out.println("첫번째 토큰: " + scanner.next()); // Hello

        // 2. nextInt(): 정수로 읽기
        System.out.println("두번째 토큰: " + scanner.nextInt()); // 123

        // 3. nextDouble(): 실수로 읽기
        System.out.println("세번째 토큰: " + scanner.nextDouble()); // 3.14

        // 4. hasNext(): 다음 읽을 토큰 존재 여부 확인
        if (scanner.hasNext()) {
            System.out.println("네번째 토큰: " + scanner.next()); // java
        }

        // 5. hasNext(): 다음 읽을 토큰 존재 여부 확인
        if (scanner.hasNext()) {
            System.out.println("다섯번째 토큰: " + scanner.next()); // 실행 안됨
        }
    }
}
