package ch02.list;

public class PerformanceTest {
    void main(){
        int times = 100000;

//        MyArray list = new MyArray(times);
        MyLinkedList list = new MyLinkedList();

        long start = System.currentTimeMillis();
//        addFirst(list, times);
        addLast(list, times);
        System.out.println("저장된 수: " + list.size());
        long end = System.currentTimeMillis();
        System.out.println("MyLinkedList addFirst 소요 시간: " + (end-start) + "ms");
    }

    // list를 이용해서 맨 앞에 times 만큼의 데이터를 추가한다.
    void addFirst(MyList list, int times){
        for(int i=0; i<times; i++){
            list.add(0, "데이터-" + i);
        }
    }

    // list를 이용해서 맨 뒤에 times 만큼의 데이터를 추가한다.
    void addLast(MyList list, int times){
        for(int i=0; i<times; i++){
            list.add("데이터-" + i);
        }
    }
}