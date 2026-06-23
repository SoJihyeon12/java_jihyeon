package ch02.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
    void main(){
        Queue queue = new LinkedList();

        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);

        System.out.println(queue.size());

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

        System.out.println(queue.size());
    }
}