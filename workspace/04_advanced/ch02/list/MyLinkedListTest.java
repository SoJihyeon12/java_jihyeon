package ch02.list;

public class MyLinkedListTest {
    void main(){
        // MyLinkedList 객체를 생성한다.
        MyList arr = new MyLinkedList();

        // MyLinkedList에 "데이터-0" 부터 "데이터-4"까지의 문자열을 담는다.(appendTo())
        for(int i=0; i<5; i++){
            System.out.println(i);
            arr.add("데이터-" + i);
        }

        // MyLinkedList에 담긴 모든 요소를 출력한다. [데이터-0, 데이터-1, 데이터-2, 데이터-3, 데이터-4]
        System.out.println(arr);

        // MyLinkedList의 0번째 요소를 출력한다.(get()) 데이터-0
        System.out.println(arr.get(0));
        // MyLinkedList의 3번째 요소를 출력한다.(get()) 데이터-3
        System.out.println(arr.get(3));

        // index 2를 삭제한다.(remove()) 데이터-2
        arr.remove(2);

        // MyLinkedList에 담긴 모든 요소를 출력한다. [데이터-0, 데이터-1, 데이터-3, 데이터-4]
        System.out.println(arr);

        // index 2에 데이터-5를 삽입한다.(appendTo())
        arr.add(2, "데이터-5");

        // MyLinkedList에 담긴 모든 요소를 출력한다. [데이터-0, 데이터-1, 데이터-5, 데이터데-3, 데이터-4]
        System.out.println(arr);

        // 맨 앞에 데이터-6을 추가한다.(appendTo())
        arr.add(0, "데이터-6");
//        arr.addFirst("데이터-6");

        // MyLinkedList에 담긴 모든 요소를 출력한다. [데이터-0, 데이터-1, 데이터-5, 데이터-3, 데이터-4, 데이터-6]
        System.out.println(arr);

        // MyLinkedList에 담긴 요소의 갯수를 출력한다. 6
        System.out.println("갯수: " + arr.size());
    }
}