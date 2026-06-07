package ch10;

// 세 과목의 총점과 평균을 계산하는 메서드를 작성하고 이를 출력하는 프로그램을 작성하세요.
public class MethodSolve {
    // int[] 점수 배열을 전달받아서 총점을 계산해서 반환하는 메서드(sum)
    int sum(int[] scores){
        int total = 0;
        for(int score : scores){
            total += score;
        }
        return total; // return의 의미는 total 값을 이 메서드를 호출한 곳으로 돌려주라는 것, 출력은 안함
    }                 // return을 사용하는 이유는 메서드가 계산한 결과를 다른 곳에서 다시 사용하기 위해서이다.

//    for(int score : scores)는 아래와 같다. 반복문이 돌 때마다 score 값이 바뀜
//    for (int i = 0; i < scores.length; i++) {
//        int score = scores[i];          여기서 int score 선언됨
//    }


    // int[] 점수 배열을 전달받아서 평균을 계산해서 반환하는 메서드(avg)
    // 평균은 소수도 표현해야 함
    double avg(int[] scores){
        int total = sum(scores);
        double scoreAvg = (double)total / scores.length;
        return Math.round(scoreAvg*10) / 10.0;
    }

    // int[] 점수 배열을 전달 받아서 총점, 평균을 출력하는 메서드(printScore)
    // 출력 예시:
    // 총점: 217, 평균: 72.33333
    void printScore(int[] scores){
        int total = sum(scores);
        double scoreAvg = avg(scores);
        System.out.println("총점: " + total + ", 평균: " + scoreAvg);
    }

    void main(){
        // haru는 국어, 영어, 수학 점수가 각각 80, 70, 56이다.
        // namu는 국어, 영어, 수학 점수가 각각 90, 77, 80이다.
        // brong이는 국어, 영어, 수학 점수가 각각 100, 99, 88이다.

        // 이 셋의 총점과 평균을 구해서 출력하세요.

        int[] haruScore = {80, 70, 56};
        int[] namuScore = {90, 77, 80};
        int[] brongScore = {100, 99, 88};

        printScore(haruScore);
        printScore(namuScore);
        printScore(brongScore);

        // 최종 출력 결과
        // 총점: 206, 평균: 68.66666
        // 총점: 247, 평균: 82.33333
        // 총점: 287, 평균: 95.66666

        // 전체 총점: 732, 전체 평균: 81.33333

    }
}
