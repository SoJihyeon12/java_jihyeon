package ch09;

public class ArrayMemory {
    public static void main(String[] args){
        int age = 25; // 기본 타입
        int[] scores = new int[3]; // 참조 타입

        scores[0] = 90;

        System.out.println(age);
        System.out.println(scores); // 아직 값을 안넣은 상태라 주소값을 나타냄
        System.out.println(scores[0]);
    }
}
