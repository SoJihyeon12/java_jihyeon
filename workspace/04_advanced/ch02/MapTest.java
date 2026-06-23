package ch02;

import java.util.*;

public class MapTest {
    void main(){
//        Map<String, String> fruits = new HashMap<>();
//        Map<String, String> fruits = new TreeMap<>();
        Map<String, String> fruits = new LinkedHashMap<>();

        fruits.put("월", "바나나");
        fruits.put("화", "사과");
        fruits.put("수", "오렌지");
        fruits.put("목", "파인애플");
        fruits.put("수", "수박");
        fruits.put("금", "aPPlE");

        String fridayFruit = fruits.get("금").toUpperCase();
        System.out.println("금요일에 먹을 과일: " + fridayFruit);

        printFruits(fruits);
    }

    void printFruits(Map<String, String> fruits){
        System.out.println("월요일에 먹을 과일: " + fruits.get("월"));
        System.out.println("수요일에 먹을 과일: " + fruits.get("수"));
        System.out.println("화요일에 먹을 과일: " + fruits.get("화"));

        System.out.println("요일별 모든 과일 출력");
//        for(String key : fruits.keySet()){
//            System.out.println(key + ": " + fruits.get(key));
//        }

        for(Map.Entry<String, String> entry : fruits.entrySet()){
            String key = entry.getKey();
            String fruit = entry.getValue();
            System.out.println(key + ": " + fruit);
        }
    }
}