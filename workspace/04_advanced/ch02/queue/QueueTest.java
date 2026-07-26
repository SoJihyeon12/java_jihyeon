package ch02.queue;
// 이 코드는 자바에서 제공하는 Queue(큐) 자료구조를 사용하는 예제입니다.
// 큐(Queue)는 먼저 들어온 데이터가 먼저 나가는 자료구조(FIFO: First In, First Out) 입니다.

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
    void main(){
        Queue queue = new LinkedList(); // Queue queue는 인터페이스 타입, 오른쪽 new LinkedList()는 실제 객체 생성

        queue.offer(10); // 첫 번째 데이터 추가, offer()는 큐의 맨 뒤에 데이터를 넣는다는 뜻
        queue.offer(20); // 두 번째 데이터 맨뒤에 추가
        queue.offer(30); // 세 번째 데이터 맨뒤에 추가
        queue.offer(40); // 네 번째 데이터 맨뒤에 추가

        System.out.println(queue.size()); // 크기 출력, 4

        System.out.println(queue.poll()); // poll()은 맨 앞의 데이터를 꺼내면서 삭제하는 메서드, 10을 꺼냅니다.
        System.out.println(queue.poll()); // 20 꺼낸다.
        System.out.println(queue.poll()); // 30 꺼낸다.

        System.out.println(queue.size()); // 1 출력
    }
}