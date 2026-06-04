package ch11.capsule.ex01;

public class ScoreTest {
    public static void main(String[] args){
        Score haru = new Score();
        haru.kor = 100;
        haru.eng = 90;
        haru.math = 85;
//        int haruSum = haru.sum();
//        System.out.println("하루의 총점: " + haruSum);

        double haruAvg = haru.avg();

        System.out.println("하루의 평균: " + haruAvg);
    }
}
