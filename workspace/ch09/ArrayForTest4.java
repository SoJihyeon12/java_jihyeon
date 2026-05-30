package ch09;

import java.util.Scanner;

// 구구단 출력(결과를 배열로 저장 후 출력)
public class ArrayForTest4 {
    public static void main(String[] args){
        System.out.println("단을 입력하세요.");
        Scanner s = new Scanner(System.in); // 사용자가 입력한 데이터를 받을때 사용
        int dan = s.nextInt(); // 입력한 값을 int로 꺼내옴
        System.out.println("입력한 단: " + dan);

        int[] result = new int[9]; // 구구단 결과를 저장할 배열 생성

        // 입력한 단의 모든 결과를 배열에 저장
        for(int i=0; i<result.length; i++){
            result[i] = dan * (i+1); // dan=3 i=0 result[0]=3*1, i=1 result[1]=3*2, i=2 result[2]=3*3 ...
        }

        System.out.println(dan + "단 학습 완료!");

        // 0을 입력할 때까지 무한 반복하도록 작성하세요.
        System.out.println("곱할 숫자를 입력하세요. 0을 입력하면 종료됩니다.");
        int num = s.nextInt();
        while(num > 0 && num < 10){
            System.out.println(dan + " x " + num + " = " + result[num-1]);
            System.out.println("곱할 숫자를 입력하세요. 0을 입력하면 종료됩니다.");
            num = s.nextInt();
        }

        System.out.println("구구단 종료.");
    }
}
