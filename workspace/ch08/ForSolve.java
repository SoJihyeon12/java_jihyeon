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

        // 1~100 홀수 합계
        sum = 0;
        for(int i= 1; i <= 100; i += 2){
            sum += i;
        }
        System.out.println("1~100 홀수 합계: " + sum);


        // 1~100 짝수 합계
        sum = 0;
        for(int i= 0; i <= 100; i += 2){
            sum += i;
        }
        System.out.println("1~100 짝수 합계: " + sum);

    }
}
