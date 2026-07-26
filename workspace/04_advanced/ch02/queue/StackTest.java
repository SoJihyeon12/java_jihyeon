package ch02.queue;
// 스택(Stack) 을 사용하는 예제
// Queue(큐) → FIFO (First In, First Out) : 먼저 들어온 것이 먼저 나감
// Stack(스택) → LIFO (Last In, First Out) : 나중에 들어온 것이 먼저 나감

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackTest {
    void main(){
        Stack stack = new Stack(); // 새로운 Stack 객체를 만듭니다. 처음에는 아무것도 없습니다.

        stack.push(10); // push()는 스택의 맨 위(Top)에 데이터를 넣는다. 10
        stack.push(20); // 20이 맨 위에 올라갑니다.
        stack.push(30); // 30이 맨 위에 올라갑니다.
        stack.push(40); // 40이 맨 위에 올라갑니다.

        System.out.println(stack.size()); //크기 출력, 4

        System.out.println(stack.pop()); // pop()은 맨 위의 데이터를 꺼내면서 삭제하는 메서드, 40 꺼낸다.
        System.out.println(stack.pop()); // 30 꺼낸다.
        System.out.println(stack.pop()); // 20 꺼낸다.

        System.out.println(stack.size()); // 크기 출력, 1
    }
}