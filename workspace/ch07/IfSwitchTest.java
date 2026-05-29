package ch07;

// 나이에 따른 입장료 할인을 계산하는 프로그램을 작성하세요.
// 7세 이하: 영유아 100% 할인
// 8 ~ 13: 어린이 50% 할인
// 14~ 19: 청소년 30% 할인
// 65세 이상: 70% 할인
public class IfSwitchTest {
    public static void main(String[] args) {
        int age = 165;

        int price = 20000;
        double discountRate = 0.0; // 할인율(30% 할인의 경우 0.3)
        int lastPrice = price;

        // 요금을 계산하세요.
        // if문 사용
        if (age <= 7) { // 0 ~ 7
            discountRate = 1.0;
        } else if (age <= 13) { // 8 ~ 13
            discountRate = 0.5;
        } else if (age <= 19) {  // 14 ~ 19
            discountRate = 0.3;
        } else if (age >= 65) { // 65 ~
            discountRate = 0.7;
        } else { // 20 ~ 64
            discountRate = 0;
        }


        lastPrice = (int) (price * (1- discountRate)); // 20000원 * (1-할인율, 즉 납부율)

        System.out.println("나이가 " + age + "세 이므로 할인율 " + discountRate*100 + "%가 적용되어 요금은 "
                            +lastPrice+"원 입니다.");
    }
}
