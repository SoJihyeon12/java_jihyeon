package ch11.capsule.ex01;

// 시험 결과를 관리하는 클래스
// 캡슐화를 통해서 불필요한 sum 호출을 막음
public class Score {
    int kor;
    int eng;
    int math;

    // 총점을 계산해서 반환하는 메서드
    private int sum(){
        return kor + eng + math;
    }

    // 평균을 계산해서 반환하는 메서드(소수 셋째자리에서 반올림)
    double avg(){
     //   int sum = kor + eng + math;
        double result = Math.round(100 * sum() / 3.0) / 100.0;
        return result;
    }

}
