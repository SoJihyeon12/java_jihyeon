package ch09;

// 국어, 영어, 수학 점수를 이용해서 총점과 평균을 계산
public class ScoreTest {
    public static void main(String[] args){
        int kor = 100; // 국어 점수
        int eng = 90; // 영어 점수
        int math = 85; // 수학 점수

        int sum = kor + eng + math; // 총점
        double avg = sum / 3.0; // 평균, 3.0으로 해서 double로 형변환 계산, 91.6666
//        avg = Math.round(avg); //소수 첫째자리 반올림, 92
//        avg = Math.round(avg * 10) / 10.0; //소수 둘째자리 반올림, 91.7, math.round괄호계산하면916.66 /10하면 91.7
                                            //math.round도 정수형이라 계산시 10.0으로 double형만들어서 소수만들기
        avg = Math.round(avg * 100) / 100.0; //소수 세째자리 반올림, 91.67

        System.out.println("총점 : " + sum);
        System.out.println("평균 : " + avg);
    }
}
