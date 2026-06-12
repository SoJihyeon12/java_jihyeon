package ch08;

// 1부터 지정한 수까지의 합계를 구하시오.
public class WhileTest {
    public static void main(String[] args) {
        // 명령행 매개변수
        // java ch08.WhileTest 10 20
        // args[0] -> 10
        // args[1] -> 20
        int num = Integer.parseInt(args[0]); // String을 int로 변환, 0번째 배열의 문자열을 int로 변환한다
        int i = 1; // 1, 2, 3, 4, ... num
        int sum = 0;

//        // 반복문 없이 구현
//        sum = sum + i; // 0 + 1
//        System.out.println("i: " + i + ", sum: "+ sum); // i: 1, sum: 1
//        i++; // 2
//
//        sum = sum + i; // 1 + 2
//        System.out.println("i: " + i + ", sum: "+ sum); // i: 2, sum: 3
//        i++; // 3
//
//        sum += i; // sum = sum + i; 1 + 2 + 3
//        System.out.println("i: " + i + ", sum: "+ sum); // i: 3, sum: 6
//        i++; // 4
//
//        sum += i; // 1 + 2 + 3 + 4
//        System.out.println("i: " + i + ", sum: "+ sum); // i: 4, sum: 10
//        i++; // 5
//
//        sum += i; // 1 + 2 + 3 + 4 + 5
//        System.out.println("i: " + i + ", sum: "+ sum); // i: 5, sum: 15
//        i++; // 6

        while(i <= num){ // 조건문, i가 0번째 배열값이 될때까지 돌린다.
            sum += i;
            System.out.println("i: " + i + ", sum: " + sum);
            i++; // 1 증식
        }

        System.out.println("1부터 " + num + "까지의 합계: " + sum);
    }
}
