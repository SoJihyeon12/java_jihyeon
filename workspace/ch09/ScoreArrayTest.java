package ch09;

// 국어, 영어, 수학 점수를 이용해서 총점과 평균을 계산
public class ScoreArrayTest {
    public static void main(String[] args){
          // 1. 배열 선언, 생성, 초기화를 각각
//        int[] haruScore; // 1-1. 배열 선언 (int형 배열)
//        haruScore = new int[3]; // 1-2. 배열 생성(개수 지정), new를 통해 12byte의 메모리(힙) 할당하고 그 주소반환, int타입 배열3개를 새로 만들어라.

          // 2. 배열 선언과 생성을 동시에
//        int[] haruScore = new int[3]; // 2-1. 선언과 생성
//
//        haruScore[0] = 100; // 1-3, 2-2. 배열 요소에 값 할당(index, 방번호를 이용해서 배열에 접근)
//        haruScore[1] = 90;
//        haruScore[2] = 85;

         // 3. 배열 선언, 생성, 초기화를 동시에
//        int[] haruScore = new int[]{100, 90, 85};
        int[] haruScore = {100, 90,85};

        System.out.println("국어: " + haruScore[0]); // 100 (방번호, 인덱스)
        System.out.println("영어: " + haruScore[1]);
        System.out.println("수학: " + haruScore[2]);

        int sum = haruScore[0] + haruScore[1] + haruScore[2]; // 총점
        double avg = sum / 3.0; // 평균, 3.0으로 해서 double로 형변환 계산, 91.6666
//        avg = Math.round(avg); //소수 첫째자리 반올림, 92
//        avg = Math.round(avg * 10) / 10.0; //소수 둘째자리 반올림, 91.7, math.round괄호계산하면916.66 /10하면 91.7
                                            //math.round도 정수형이라 계산시 10.0으로 double형만들어서 소수만들기
//        avg = Math.round(avg * 100) / 100.0; //소수 세째자리 반올림, 91.67

        System.out.println("총점 : " + sum);
        System.out.println("평균 : " + avg);
    }
}
