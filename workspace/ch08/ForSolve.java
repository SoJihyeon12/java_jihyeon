package ch08;

import org.w3c.dom.ls.LSOutput;

public class ForSolve {
    public static void main(String[] args){
        int sum = 0;

        // 1~100 합계
        for (int i = 1; i <= 100; i++){
            sum += i;
        }
        System.out.println("1~100 합계: " + sum);

//        for문의 실행 순서는 다음과 같습니다.
//
//        1. 초기식 실행 → i = 1
//        2. 조건식 검사 → i <= 100
//        3. 본문 실행 → sum += i
//        4. 증감식 실행 → i++
//        5. 다시 조건식 검사 → i <= 100
//        6. 반복
//
//        만약 i가 101이 되면 i <= 100 조건에 맞지 않아서 바로 for문 종료



        // 1~100 홀수 합계
        sum = 0;
        for(int i= 1; i <= 100; i += 2){
            sum += i;
        }
        System.out.println("1~100 홀수 합계: " + sum);


        // 1~100 짝수 합계
        sum = 0;
        for(int i= 0; i <= 100; i += 2){ //0은 짝수이다.
            sum += i;
        }
        System.out.println("1~100 짝수 합계: " + sum);

    }
}
