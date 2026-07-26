package ch02.list;
// 이 코드는 직접 만든 MyArray 클래스가 제대로 동작하는지 테스트하는 프로그램

public class MyArrayTest {
    void main(){
        // 10개의 요소를 담을 수 있는 MyArray 객체를 생성한다.
//        MyList arr = new MyArray();
        MyList<String> arr = new MyArray<>(5); // new MyArray<>(5): 5개의 데이터를 저장할 수 있는 MyArray를 만든다.
        // arr 변수의 자료형은 MyList<String>이다. 즉, MyArray 객체를 MyList 타입으로 사용하겠다.라는 의미

        // MyArray에 "데이터-0" 부터 "데이터-4"까지의 문자열을 담는다.(append())
        // 데이터 5개 생성
        for(int i=0; i<5; i++){
            arr.add("DaTa-" + i);
        }

        // MyArray에 담긴 모든 요소를 출력한다. [데이터-0, 데이터-1, 데이터-2, 데이터-3, 데이터-4]
        System.out.println(arr); // System.out.println(arr); 코드가 실행되면 자바는 자동으로 arr.toString();를 호출해서 [데이터-0, 데이터-1, 데이터-2, 데이터-3, 데이터-4]가 출력됨

        // MyArray의 인덱스 0번째 요소를 출력한다.(getElem()) 데이터-0
        System.out.println(((String)arr.get(0)).toLowerCase()); // arr.get(0)-> DaTa-0, (String)형변환, toLowerCase()(소문자 변경)->data-0
        // MyArray의 인덱스 3번째 요소를 출력한다.(getElem()) 데이터-3
        System.out.println(arr.get(3).toUpperCase()); // toUpperCase()(대문자 변경)->DATA-3

        // index 2를 삭제한다.(delete()) 데이터-2
        arr.remove(2); // 인덱스 2에 있던 값은 뒤에 있는 데이터가 한 칸씩 앞으로 이동하면서 삭제된다.

        // MyArray에 담긴 모든 요소를 출력한다. [데이터-0, 데이터-1, 데이터-3, 데이터-4]
        System.out.println(arr);

        // index 2에 데이터-5를 삽입한다.(append())
        arr.add(2, "데이터-5"); // 인덱스 2,3에 있던 데이터3, 데이터4가 인덱스 3,4로 가고 비어있는 인덱스2에 데이터5가 온다.

        // MyArray에 담긴 모든 요소를 출력한다. [데이터-0, 데이터-1, 데이터-5, 데이터-3, 데이터-4]
        System.out.println(arr);

        // 마지막 위치에 데이터-6을 추가한다.(append())
        arr.add("데이터-6"); // 이 메서드는 add(count, "데이터-6");를 호출한다. 즉, 맨 뒤에 추가됩니다.

        // MyArray에 담긴 모든 요소를 출력한다. [데이터-0, 데이터-1, 데이터-5, 데이터-3, 데이터-4, 데이터-6]
        System.out.println(arr);

        // MyArray에 담긴 요소의 갯수를 출력한다. 6
        System.out.println("갯수: " + arr.size()); // size()는 return count;를 수행한다. 즉, 현재 저장된 데이터 개수를 출력합니다.
    }
}