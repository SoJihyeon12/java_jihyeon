package ch08;

import java.util.Scanner;

// 구구단 출력
public class ForTest4 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in); // 사용자가 입력한 데이터를 받을때 사용
        int dan = s.nextInt(); // 입력한 값을 int로 받아와서 dan 변수에 대입함
        System.out.println("입력한 값: " + dan);

//                                                                              new : 새로운 객체 생성
//                                                                              Scanner(...) : Scanner 객체 생성
//                                                                              System.in : 키보드 입력을 의미

        for(int i=1; i <= 9; i++){
            System.out.println(dan + " x " + i + " = " + (dan*i));
        }

    }
}
