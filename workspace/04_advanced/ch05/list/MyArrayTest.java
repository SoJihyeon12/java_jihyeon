package ch05.list;
// 이 코드는 여러 개의 스레드(Thread)가 동시에 MyArray를 사용할 때 정상적으로 동작하는지 테스트하는 코드입니다.
// 핵심은 멀티스레드 환경에서 MyArray가 안전한지 확인하는 것입니다.

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class MyArrayTest { // MyArray를 테스트하기 위한 클래스입니다.
    void main(){
        MyList<String> arr = new MyArray<>(); // String만 저장할 수 있는 MyArray 객체를 생성합니다.
//        List<String> arr = new ArrayList<>(); // 멀티스레드 환경에서 스레드 동기화 문제가 발생할수 있지만 빠름
//        List<String> arr = new Vector<>(); // 스레드에 안전하게 설게 되어있지만 MyArray보다 느림
//        List<String> arr = new CopyOnWriteArrayList<>(); // 읽기가 매우 많고 수정이 적은 환경에서 자주 사용하는 리스트입니다. 데이터를 수정할 때마다 내부 배열을 복사해서 사용합니다.

        String str = ""; // 빈 문자열을 저장한 변수입니다. 하지만 이 코드에서는 사용되지 않습니다. 이거 없어도 프로그램은 동일하게 동작합니다.
        new Thread(new Runnable() { // 새로운 스레드를 생성합니다. Runnable 안의 run() 메서드가 실행됩니다.
            @Override
            public void run() { // 스레드가 시작되면 실행되는 메서드입니다.
                for(int i=0; i<100000; i++){ // 0부터 99,999까지 반복합니다. 총 100,000번 반복입니다.
                    arr.add("데이터 - " + i); // 데이터 추가
                }
                System.out.println(Thread.currentThread().getName() + ": " + arr.size()); // Thread.currentThread(): 현재 실행 중인 스레드를 가져옵니다. getName(): 스레드 이름을 반환합니다. ex) Thread-0
            }
        }).start(); // start()는 스레드(Thread)를 시작하는 메서드, 새로운 작업을 실행해! 라는 명령

        new Thread(new Runnable() { // 두 번째 스레드
            @Override
            public void run() {
                for(int i=0; i<100000; i++){ // 역시 10000번 반복
                    arr.add("데이터 - " + i);
//                    if(arr.size() > 0){ // remove를 하기 전에 안전하게 사이즈 먼저 체크, 예를 들어 리스트가 비어 있는데 arr.remove(0); 을 하면 삭제할 데이터가 없어서 예외가 발생하니까 데이터가 있는지 확인한다.
//                        arr.remove(0);
//                    }
                }
                System.out.println(Thread.currentThread().getName() + ": " + arr.size()); // Thread.currentThread(): 현재 실행 중인 스레드를 가져옵니다. getName(): 스레드 이름을 반환합니다. ex) Thread-0
            }
        }).start(); // start()는 스레드(Thread)를 시작하는 메서드, 새로운 작업을 실행해! 라는 명령

    }
}