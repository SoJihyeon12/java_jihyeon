package ch14;

import java.util.Arrays;

class ResizableArray{
    private String[] elements;
    private int size;

    // 초기 용량을 전달해서 객체를 생성
    public ResizableArray(int initialCapacity){
        elements = new String[initialCapacity];
        size = 0;
    }

    // 배열의 마지막에 해당 요소를 추가한다.
    public void add(String elem){
        // 배열이 다 찼으면 2배 크기로 증가
        if(size == elements.length){
            // 배열 늘리기(기존 크기의 2배)
            String[] tempList = new String[elements.length * 2];
            for(int i=0; i<elements.length; i++){
                tempList[i] = elements[i];
            }
            elements = tempList;
        }
        elements[size] = elem;
        size++;
    }

    public String get(int index){
        return elements[index];
    }

    public String toString(){
        return Arrays.toString(elements);
    }
}

public class ArrayTest {
    public static void main(String[] args){
        // 배열 생성
        ResizableArray list = new ResizableArray(2);

        // 배열에 데이터 추가
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");
        list.add("Orange");
        list.add("Orange");

        System.out.println("인덱스 1의 요소: " + list.get(1));

        System.out.println(list);
    }
}
