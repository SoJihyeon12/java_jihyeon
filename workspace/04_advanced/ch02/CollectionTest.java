package ch02;
// 이 코드는 자바 컬렉션(Collection Framework) 을 배우기 위한 예제입니다.
// 이 예제의 목적은 List, Set, Collection의 차이와 공통점을 이해하는 것입니다.

import java.util.*;

public class CollectionTest {
    void main(){
//        String[] fruits = new String[5]; // 배열 5개만들고 과일 그 안에 넣음
//        fruits[0] = "바나나";
//        fruits[1] = "사과";
//        fruits[2] = "오렌지";
//        fruits[3] = "파인애플";
//        fruits[4] = "수박";

        // List는
        // 중복가능 O
        // 저장한 순서 유지 가능 O

        //바나나
        //사과
        //오렌지
        //파인애플
        //수박
        //사과
//        List<String> fruits = new ArrayList<>();
//        List<String> fruits = new LinkedList<>();
//        List<String> fruits = new Vector<>();

        // Set은
        // 데이터 중복 X, 즉, 같은 데이터를 두 번 저장할 수 없다.

        //수박
        //오렌지
        //사과
        //바나나
        //파인애플

        // HashSet 특징: 저장한 순서 유지 안함, 중복 제거
//        Set<String> fruits = new HashSet<>();

        //바나나
        //사과
        //수박
        //오렌지
        //파인애플

        // TreeSet 특징: 자동 정렬 O, 중복 제거
//        Set<String> fruits = new TreeSet<>();

        //바나나
        //사과
        //오렌지
        //파인애플
        //수박

        // LinkedHashSet: 저장한 순서 듀지 O, 중복 제거
        Set<String> fruits = new LinkedHashSet<>();

        fruits.add("바나나");
        fruits.add("사과");
        fruits.add("오렌지");
        fruits.add("파인애플");
        fruits.add("수박");
        fruits.add("사과");

        printFruits(fruits);
    }

    // 전달받은 과일목록을 출력한다.
//    void printFruits(String[] fruits){
//        for(String fruit : fruits){
//            System.out.println(fruit);
//        }
//    }

    void printFruits(Collection<String> fruits){ // Collection<String>을 사용하는 것이 핵심, 왜냐하면 Collection을 사용하면 ArrayList, LinkedList, Vector, HashSet, TreeSet, LinkedHashSet를 모두 받을 수 있기 때문
        for(String fruit : fruits){ // 컬렉션 안에 있는 데이터를 하나씩 꺼내라는 것입니다.
            System.out.println(fruit);
        }
    }

//    void printFruits(List<String> fruits){
//        for(String fruit : fruits){
//            System.out.println(fruit);
//        }
//    }
//
//    void printFruits(Set<String> fruits){
//        for(String fruit : fruits){
//            System.out.println(fruit);
//        }
//    }

//    void printFruits(ArrayList<String> fruits){
//        for(String fruit : fruits){
//            System.out.println(fruit);
//        }
//    }

//    void printFruits(LinkedList<String> fruits){
//        for(String fruit : fruits){
//            System.out.println(fruit);
//        }
//    }
//
//    void printFruits(Vector<String> fruits){
//        for(String fruit : fruits){
//            System.out.println(fruit);
//        }
//    }
//
//    void printFruits(HashSet<String> fruits){
//        for(String fruit : fruits){
//            System.out.println(fruit);
//        }
//    }
//
//    void printFruits(TreeSet<String> fruits){
//        for(String fruit : fruits){
//            System.out.println(fruit);
//        }
//    }
}