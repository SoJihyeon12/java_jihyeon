package ch02;
// 이 코드는 Map(맵) 자료구조를 배우기 위한 예제
// 지금까지 배운 자료구조를 비교하면 다음과 같습니다.
// List : 순서대로 저장 (0, 1, 2...)
// Set : 중복 없이 저장
// Map : 키(Key)와 값(Value)을 한 쌍으로 저장
// 예를 들어 Map은 사전(Dictionary)처럼 생각하면 쉽습니다.
// 월-> 바나나, 화-> 사과라면 "월"이라는 키(Key) 로 "바나나"라는 값(Value) 을 찾을 수 있습니다.

import java.util.*;

public class MapTest {
    void main(){
//        Map<String, String> fruits = new HashMap<>();
//        Map<String, String> fruits = new TreeMap<>();
        Map<String, String> fruits = new LinkedHashMap<>(); //Map<String, String> 첫번째 String은 Key(키)이고 두번째 String은 Value(값)형태의 데이터를 저장한다는 뜻

        fruits.put("월", "바나나"); // put()은 Map에 Key와 Value를 저장하는 메서드
        fruits.put("화", "사과");
        fruits.put("수", "오렌지"); // 같은 Key 저장, 수
        fruits.put("목", "파인애플");
        fruits.put("수", "수박"); // 같은 Key 저장, 수, 새로운 데이터가 추가되는 것이 아니라 기존 값이 변경됩니다. Map에서는 Key는 중복될 수 없기 때문
        fruits.put("금", "aPPlE");

        String fridayFruit = fruits.get("금").toUpperCase(); // get(): 찾기, 대문자 변환
        System.out.println("금요일에 먹을 과일: " + fridayFruit);

        printFruits(fruits);
    }

    void printFruits(Map<String, String> fruits){
        System.out.println("월요일에 먹을 과일: " + fruits.get("월")); //fruits.get("월")하면 바나나 출력됨
        System.out.println("수요일에 먹을 과일: " + fruits.get("수")); //fruits.get("수")하면 수박 출력됨
        System.out.println("화요일에 먹을 과일: " + fruits.get("화")); //fruits.get("화")하면 사과 출력됨

        System.out.println("요일별 모든 과일 출력");
//        for(String key : fruits.keySet()){
//            System.out.println(key + ": " + fruits.get(key));
//        }

        for(Map.Entry<String, String> entry : fruits.entrySet()){ //entrySet()은 Map 안의 모든 데이터를 Key + Value 쌍으로 가져옵니다.
            String key = entry.getKey(); // Key 얻기
            String fruit = entry.getValue(); // Value 얻기
            System.out.println(key + ": " + fruit); // 출력, 월: 바나나 ~ 최종까지 계속 반복
        }
    }
}