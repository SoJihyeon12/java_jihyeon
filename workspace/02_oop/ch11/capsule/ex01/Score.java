package ch11.capsule.ex01;

// 시험 결과를 관리하는 클래스
// 캡슐화를 통해서 불필요한 sum 호출을 막음
// 캡슐화란 데이터와 메서드를 하나로 묶고, private 등을 이용해 데이터를 외부로부터 보호하는 객체지향의 특징
public class Score {
    int kor;
    int eng;
    int math;

    // 총점을 계산해서 반환하는 메서드
    private int sum(){
        return kor + eng + math;
    } //이게 sum 캡슐화, 그러나 kor, eng, math는 캡슐화 안된 상태
                                                    // 캡슐화하려면 private kor, private eng, private math이어야 함

    // 평균을 계산해서 반환하는 메서드(소수 셋째자리에서 반올림)
    double avg(){
     //   int sum = kor + eng + math;
        double result = Math.round(100 * sum() / 3.0) / 100.0;
        return result;
    }

}
