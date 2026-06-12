package ch14;

import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(2); // 초기 용량 2로 설정

        // 1. add(): 데이터 추가 및 자동 확장 테스트
        list.add("Apple");
        list.add("Banana");
        System.out.println("기존 크기: " + list.size());

        list.add("Orange"); // 3번째 요소 추가 시 자동으로 크기 확장
        System.out.println("확장 후 크기: " + list.size());
        System.out.println("리스트 내용: " + list);

        // 2. get(): 특정 인덱스 요소 가져오기
        System.out.println("1번 인덱스 요소: " + list.get(1)); // Banana

        // 3. remove(): 특정 인덱스 요소 삭제
        String removed = list.remove(1); // Banana 삭제
        System.out.println("삭제된 요소: " + removed);
        System.out.println("삭제 후 내용: " + list);
        System.out.println("최종 크기: " + list.size()); // 2
    }
}
