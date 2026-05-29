package ch07;


// 회원 등급에 따른 할인 혜택을 적용하는 예제
// A. 골드 등급: 50% 할인
// B. 실버 등급: 30% 할인
// C. 브론즈 등급: : 10% 할인
// D. 일반 등급: 0% 할인
public class SwitchTest2 {
    public static void main(String[] args) {
        int price = 10000; // 정상가
        char grade = 'B'; // 회원 등급
        int discountRate = 0; // 할인율(%)
        int lastPrice = price; // 할인가

        // if문 사용
        if (grade == 'A') {
            discountRate = 50;
        } else if (grade == 'B') {
            discountRate = 30;
        } else if (grade == 'C') {
            discountRate = 10;
        } else if (grade == 'D') {
            discountRate = 0;
        }

        // switch
        switch (grade) {
            case 'A': // grade == 'A'
                discountRate = 50;
                break;
            case 'B': // grade == 'B'
                discountRate = 30;
                break;
            case 'C': // grade == 'C'
                discountRate = 10;
                break;
            case 'D': // grade == 'D'
                discountRate = 0;
                break;
        }

        lastPrice = (int) (price * (1 - discountRate / 100.0)); // 가격*(1-할인율(소수))= 즉, 지급액

        System.out.println("회원님은 " + grade + "등급이므로 정상가 " + price + "원에서 "
                            + discountRate + "% 할인된 가격 " + lastPrice + "원 입니다.");
    }
}
