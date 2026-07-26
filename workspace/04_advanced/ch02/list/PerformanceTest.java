package ch02.list;
// 이 코드는 MyArray와 MyLinkedList의 성능(속도)을 비교하기 위한 테스트 프로그램입니다.

public class PerformanceTest { // PerformanceTest는 성능(Performance)을 테스트하는 클래스
    void main(){
        int times = 100000; // times는 데이터를 몇 번 추가할 것인지를 의미한다. 10000번 추가

//        MyArray list = new MyArray(times); // 배열 기반 리스트 생성
        MyLinkedList list = new MyLinkedList(); // 노드 기반 리스트 생성

        long start = System.currentTimeMillis(); //현재 시간을 밀리초(ms) 단위로 저장합니다.
//        addFirst(list, times); // 데이터 추가, 100000개를 맨 앞에 추가
        addLast(list, times); // 데이터 추가, 100000개를 맨 뒤에 추가
        System.out.println("저장된 수: " + list.size()); // 저장된 개수 출력 ,저장된 수: 100000 출력
        long end = System.currentTimeMillis(); // 종료 시간 저장
        System.out.println("MyLinkedList addFirst 소요 시간: " + (end-start) + "ms"); // 걸린 시간 출력
    }

    // list를 이용해서 맨 앞에 times 만큼의 데이터를 추가한다.
    void addFirst(MyList list, int times){
        for(int i=0; i<times; i++){
            list.add(0, "데이터-" + i);
        }
    }

    // list를 이용해서 맨 뒤에 times 만큼의 데이터를 추가한다.
    void addLast(MyList list, int times){ // 이 메서드는 list.add()를 times번 반복 호출하여 "데이터-0"부터 "데이터-(times-1)"까지의 데이터를 리스트의 마지막에 차례대로 저장하는 역할을 합니다.
        for(int i=0; i<times; i++){
            list.add("데이터-" + i);
        }
    }
}