package ch02.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackTest {
    void main(){
        Stack stack = new Stack();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println(stack.size());

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println(stack.size());
    }
}