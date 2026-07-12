package ch05.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class MyArrayTest {
    void main(){
        MyList<String> arr = new MyArray<>();
//        List<String> arr = new ArrayList<>(); // 멀티스레드 환경에서 스레드 동기화 문제가 발생할수 있지만 빠름
//        List<String> arr = new Vector<>(); // 스레드에 안전하게 설게 되어있지만 느림
//        List<String> arr = new CopyOnWriteArrayList<>();

        String str = "";
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<100000; i++){
                    arr.add("데이터 - " + i);
                }
                System.out.println(Thread.currentThread().getName() + ": " + arr.size());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<100000; i++){
                    arr.add("데이터 - " + i);
//                    if(arr.size() > 0){ // remove를 하기 전에 안전하게 사이즈 먼저 체크
//                        arr.remove(0);
//                    }
                }
                System.out.println(Thread.currentThread().getName() + ": " + arr.size());
            }
        }).start();

    }
}