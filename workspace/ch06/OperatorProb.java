package ch06;

// 완성본은 ch06.OperatorSolve.java로 작성하세요.
public class OperatorProb {
    public static void main(String[] args) {
        System.out.println("=== [실습 1] 정수와 실수의 산술 연산 ===");
        int a = 10;
        int b = 3;

        // [문제 1-1] 변수 a를 b로 나눈 결과를 '소수점 아래까지 정확히' 구하여 출력하세요.
        // 힌트: 정수끼리 나누면 소수점이 버려집니다. 형변환(Casting)을 활용하세요.
        double divResult = a / (double) b; // 또는 (double)a/b 이 부분을 수정하세요.
        System.out.println("10 / 3 결과 (실수): " + divResult); // 3.3333333333333335

        // [문제 1-2] 변수 a를 b로 나눈 '나머지'를 구하여 출력하세요.
        int modResult = a % b; // 이 부분을 수정하세요.
        System.out.println("10을 3으로 나눈 나머지: " + modResult);

        System.out.println("\n=== [실습 2] 삼항 연산자와 비교 연산자 ===");
        int number = 15;

        // [문제 2] 변수 number가 '짝수'인지 '홀수'인지 판별하여 결과를 문자열로 반환하고 출력하세요.
        // 힌트: 2로 나눈 나머지가 0이면 '짝수', 아니면 '홀수'입니다. 삼항 연산자(조건식 ? 참 : 거짓)를 사용하세요.
        String evenOrOdd = (number % 2 == 0) ? "짝수" : "홀수"; // 이 부분을 수정하세요.
        System.out.println(number + "은/는 " + evenOrOdd + "입니다."); // 15은/는 홀수입니다.

        System.out.println("\n=== [실습 3] 논리 연산자를 활용한 윤년 판별 ===");
        int year = 2024;

        // [문제 3] 변수 year에 담긴 연도가 '윤년'인지 판별하여 true 또는 false를 반환하고 출력하세요.
        // 윤년의 조건:
        // 1) 연도가 4로 나누어 떨어지면서, 100으로 나누어 떨어지지 않아야 함.
        // 2) 또는, 연도가 400으로 나누어 떨어지면 윤년임.
        // 힌트: 4로 나누어 떨어진다 -> 'year % 4 == 0'
        // AND 연산자 '&&', OR 연산자 '||'를 복합적으로 사용하세요.
        boolean isLeapYear = ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0); // 이 부분을 수정하세요.
        System.out.println(year + "년은 윤년인가요? " + isLeapYear); // 2024년은 윤년인가요? true
    }
}

