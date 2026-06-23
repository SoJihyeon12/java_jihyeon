package ch02.list;

public class MyArrayTest {
    void main(){
        // 10개의 요소를 담을 수 있는 MyArray 객체를 생성한다.
//        MyList arr = new MyArray();
        MyList<String> arr = new MyArray<>(5);

        // MyArray에 "데이터-0" 부터 "데이터-4"까지의 문자열을 담는다.(append())
        for(int i=0; i<500; i++){
            arr.add("DaTa-" + i);
        }

        // MyArray에 담긴 모든 요소를 출력한다. [데이터-0, 데이터-1, 데이터-2, 데이터-3, 데이터-4]
        System.out.println(arr);

        // MyArray의 0번째 요소를 출력한다.(getElem()) 데이터-0
        System.out.println(((String)arr.get(0)).toLowerCase());
        // MyArray의 3번째 요소를 출력한다.(getElem()) 데이터-3
        System.out.println(arr.get(3).toUpperCase());

        // index 2를 삭제한다.(delete()) 데이터-2
        arr.remove(2);

        // MyArray에 담긴 모든 요소를 출력한다. [데이터-0, 데이터-1, 데이터-3, 데이터-4]
        System.out.println(arr);

        // index 2에 데이터-5를 삽입한다.(append())
        arr.add(2, "데이터-5");

        // MyArray에 담긴 모든 요소를 출력한다. [데이터-0, 데이터-1, 데이터-5, 데이터-3, 데이터-4]
        System.out.println(arr);

        // 마지막 위치에 데이터-6을 추가한다.(append())
        arr.add("데이터-6");

        // MyArray에 담긴 모든 요소를 출력한다. [데이터-0, 데이터-1, 데이터-5, 데이터-3, 데이터-4, 데이터-6]
        System.out.println(arr);

        // MyArray에 담긴 요소의 갯수를 출력한다. 6
        System.out.println("갯수: " + arr.size());
    }
}