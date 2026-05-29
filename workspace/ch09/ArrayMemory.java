package ch09;

public class ArrayMemory {
    public static void main(String[] args){
        int age = 25; // 기본 타입
        int[] scores = new int[3]; // 참조 타입, []안의 숫자는 요소의 개수,길이를 의미

        scores[0] = 90; // 여기서 []안의 숫자는 방번호, 인덱스 번호를 의미

        System.out.println(age);
        System.out.println(scores);
        System.out.println(scores[0]);
    }
}
