package ch14;

public class MathTest {
    public static void main(String[] args) {
        // 1. abs(): 절대값 계산
        System.out.println(Math.abs(-10)); // 10

        // 2. max(), min(): 최댓값, 최솟값 비교
        System.out.println(Math.max(10, 20)); // 20
        System.out.println(Math.min(10, 20)); // 10

        // 3. round(), ceil(), floor(): 반올림, 올림, 내림
        System.out.println(Math.round(5.6)); // 6
        System.out.println(Math.ceil(5.1)); // 6.0
        System.out.println(Math.floor(5.9)); // 5.0

        // 4. random(): 0.0 이상 1.0 미만 난수 생성
        System.out.println(Math.random());

        // 5. pow(), sqrt(): 거듭제곱, 제곱근
        System.out.println(Math.pow(2, 3)); // 8.0
        System.out.println(Math.sqrt(16)); // 4.0

        // 7. 소수 둘째자리에서 반올림
        System.out.println(Math.round(89.6781*10)/10.0);

        // 8. 무작위의 주사위 숫자 추출
        System.out.println((int)(Math.random()*6) + 1);

        System.out.println(Math.PI);
    }
}




