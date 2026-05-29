package ch09;

import java.util.Scanner;

// 구구단 출력(결과를 배열로 저장 후 출력)
public class ArrayForTest4 {
    public static void main(String[] args){
        System.out.println("단을 입력하세요.");
        Scanner s = new Scanner(System.in); // 입력기 만들기
        int dan = s.nextInt(); // 실제 숫자 입력받기, 입력받은 값을 int형 변수에 대입
        System.out.println("입력한 단: " + dan);

        int[] result = new int[9]; //new int[9]의 9는 요소의 개수(길이)

        for(int i=0; i < result.length; i++){
            result[i] = dan * (i+1); // dan=3, i=0, result[0]=3*1=3, i=1 result[1]=3*2=6, i=2 result[2]=3*3=9
        }                            //즉, 구구단 결과를 전부 계산해서 result 배열[인덱스, 방번호]에 저장

        System.out.println(dan + "단 학습 완료!");

        // 0을 입력할 때까지 무한 반복하도록 작성하세요. 0입력하면 프로그램 종료라는 의미
        System.out.println("곱할 숫자를 입력하세요. 0을 입력하면 종료됩니다.");
        int num = s.nextInt();
        while(num != 0){
            System.out.println(dan + " x " + num + " = " + result[num-1]); // [num-1]은 인덱스, 방번호를 의미
            System.out.println("곱할 숫자를 입력하세요. 0을 입력하면 종료됩니다.");
            num = s.nextInt();
        }

        System.out.println("구구단 종료.");
    }
}
