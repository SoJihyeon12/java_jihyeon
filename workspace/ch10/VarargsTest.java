package ch10;

public class VarargsTest {

//    // int 2개의 합계를 출력하는 메서드
//    void sum(int n1, int n2){
//        System.out.println("2. sum2 메서드 시작.");
//        int result = n1 + n2;
//        System.out.println("3. " + n1 + " + " + n2 + " = " + result);
//        System.out.println("4. sum2 메서드 종료.");
//    }
//
//    // int 3개의 합계를 출력하는 메서드
//    void sum(int n1, int n2, int n3){
//        System.out.println("5. sum3 메서드 시작.");
//        int result = n1 + n2 + n3;
//        System.out.println("6. " + n1 + " + " + n2 + " + " + n3 + " = " + result);
//        System.out.println("7. sum3 메서드 종료.");
//    }
//    // int 4개의 합계를 출력하는 메서드
//    void sum(int n1, int n2, int n3, int n4){
//        System.out.println("8. sum4 메서드 시작.");
//        int result = n1 + n2 + n3 + n4;
//        System.out.println("9. " + n1 + " + " + n2 + " + " + n3 + " + " + n4 + " = " + result);
//        System.out.println("10. sum4 메서드 종료.");
//    }

    // int n개의 합계를 출력하는 메서드
    void sum(int... nums){// 가변 인자
        int result = 0;
        for(int num : nums){
            result += num;
        }
        System.out.println("합계: " + result);
    }


    void main(){
        System.out.println("1. main 메서드 시작.");
        sum(10,20);
        sum(10, 20, 30);
        sum(10, 20, 30, 40);
        sum(10, 20, 30, 40, 50);
        sum(10, 20, 30, 40, 50, 60);
        sum(10, 20, 30, 40, 50, 60, 70);
        sum(10, 20, 30, 40, 54354, 45343, 54339, 45648);
        System.out.println("11. main 메서드 종료");
    }
}
