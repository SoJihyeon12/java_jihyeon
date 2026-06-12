package ch07;

public class IfSolve {

    public static void main(String[] args) {

        int score = 85;

        if (score >= 90 && score <= 100) { // 90~100
            System.out.println("A");

        } else if (score >= 80) { // 80 ~ 89
            System.out.println("B");

        } else if (score >= 70) { // 70 ~ 79
            System.out.println("C");

        } else if (score >= 60) { // 60 ~ 69
            System.out.println("D");

        } else if (score >= 0) { // 0 ~ 59
            System.out.println("F");

        } else {
            System.out.println("올바르지 않은 점수입니다.");
        }
    }
}