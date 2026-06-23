package ch02;

import java.util.*;

public class CollectionTest {
    void main(){
//        String[] fruits = new String[5];
//        fruits[0] = "바나나";
//        fruits[1] = "사과";
//        fruits[2] = "오렌지";
//        fruits[3] = "파인애플";
//        fruits[4] = "수박";

        // List
        // 중복 O
        // 순서 O

        //바나나
        //사과
        //오렌지
        //파인애플
        //수박
        //사과
//        List<String> fruits = new ArrayList<>();
//        List<String> fruits = new LinkedList<>();
//        List<String> fruits = new Vector<>();

        // Set
        // 데이터 중복 X

        //수박
        //오렌지
        //사과
        //바나나
        //파인애플

        // 저장한 순서 X
//        Set<String> fruits = new HashSet<>();

        //바나나
        //사과
        //수박
        //오렌지
        //파인애플

        // 정렬 O
//        Set<String> fruits = new TreeSet<>();

        //바나나
        //사과
        //오렌지
        //파인애플
        //수박

        // 저장한 순서 O
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

    void printFruits(Collection<String> fruits){
        for(String fruit : fruits){
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