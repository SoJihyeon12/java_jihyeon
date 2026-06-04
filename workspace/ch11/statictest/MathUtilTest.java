package ch11.statictest;

public class MathUtilTest {
    public static void main(String[] args){
//        MathUtil m = new MathUtil();
//        m.PI = 3.14; // 상수이기 때문에 수정은 안됨

        // 반지름 5인 원의 넓이는 xx 입니다.
        double area = MathUtil.PI * 5 * 5;
        System.out.println("반지름 5인 원의 넓이는 " + area + " 입니다.");

        System.out.println("3 + 5 = " + MathUtil.add(3, 5));

//        MathUtil.area();
    }
}
