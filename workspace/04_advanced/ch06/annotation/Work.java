package ch06.annotation;
// 이 코드는 TimeProcessor가 실행할 작업(Work)을 정의한 클래스입니다.
// 각 메서드에 @MeasureTime 애노테이션을 붙여 놓았기 때문에, TimeProcessor가 이 메서드들을 찾아 실행 시간을 측정할 수 있습니다.
// 왜 ArrayList와 Vector를 비교할까? 두 클래스 모두 리스트 이지만 차이가 있습니다.

//ArrayList
//동기화(X)
//빠름
//멀티스레드에서는 직접 동기화가 필요할 수 있음

//Vector
//동기화(O)
//여러 스레드가 동시에 접근해도 안전
//동기화 때문에 ArrayList보다 약간 느릴 수 있음

//그래서 실행 시간을 비교하기 위해 두 메서드를 만든 것입니다.

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Work { // Work라는 클래스를 생성합니다. 이 클래스는 여러 작업(task)을 모아 놓은 클래스입니다.
    @MeasureTime(taskName="ArrayList 사용") // 이 메서드의 실행 시간을 측정하세요. 작업 이름은 "ArrayList 사용"입니다. 라는 의미
    public void task1(){
        System.out.println("task1 실행");
        List<String> list = new ArrayList<>(); //List 선언, 이 코드는 인터페이스를 이용해서 객체를 생성한 것입니다.
        for(int i=0; i<10000; i++){ // 0부터 9999까지 10000번 반복
            list.add("데이터-" + i); // 문자열을 리스트에 추가합니다.
        }
    }

    @MeasureTime
    public void task2(){ // 이번에도 위에 @MeasureTime이 붙어 있습니다. 하지만 taskName="..."이 없습니다. 이유 찾아봐
        System.out.println("task2 실행");
        List<String> list = new Vector<>(); // Vector 생성
        for(int i=0; i<10000; i++){ // 10000개의 데이터를 추가합니다.
            list.add("데이터-" + i);
        }
    }
}