package ch09;

// 국어, 영어, 수학 점수를 이용해서 총점과 평균을 계산
public class ScoreArrayTest {
    public static void main(String[] args){
//        // 1. 배열 선언, 생성, 초기화를 각각
//        int[] haruScore; // 1-1. 배열 선언
//        haruScore = new int[3]; // 1-2. 배열 생성(개수 지정), 12byte의 메모리(힙) 할당하고 그 주소를 반환
//
//        // 2. 배열 선언과 생성을 동시에
//        int[] haruScore = new int[3]; // 2-1. 선언과 생성
//
//        haruScore[0] = 100; // 1-3, 2-2. 배열 요소에 값 할당(index를 이용해서 배열에 접근)
//        haruScore[1] = 90;
//        haruScore[2] = 85;

        // 3. 배열 선언, 생성, 초기화를 동시에
//        int[] haruScore = new int[]{100, 90, 85};
        int[] haruScore = {100, 90, 85};

        System.out.println("국어: " + haruScore[0]); // 100
        System.out.println("영어: " + haruScore[1]); // 90
        System.out.println("수학: " + haruScore[2]); // 85

        int sum = haruScore[0] + haruScore[1] + haruScore[2]; // 총점
        double avg = sum / 3.0; // 평균, 91.66666

        System.out.println("총점: " + sum);
        System.out.println("평균: " + avg);
    }
}
