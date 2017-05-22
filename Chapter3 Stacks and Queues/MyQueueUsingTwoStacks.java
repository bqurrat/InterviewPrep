package com.company;

import java.util.Stack;

/**
 * Created by qulain on 5/19/2017.
 */
public class MyQueueUsingTwoStacks {
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();

    public static void main(String[] args) {
        MyQueueUsingTwoStacks queue = new MyQueueUsingTwoStacks();
        queue.enque(1);
        queue.enque(2);
        queue.enque(3);
        queue.enque(4);
        queue.enque(5);
        queue.peek();
        System.out.println("Size of stack: "+queue.size());
        int val1 = queue.deque();
        System.out.println(val1);
        System.out.println("Size of stack: "+queue.size());

        queue.enque(6);
        System.out.println("Size of stack: "+queue.size());
        int val2 = queue.peek();
        System.out.println(val2);
        System.out.println("Size of stack: "+queue.size());

    }

    public void enque(int val) {
        if(s2.isEmpty()) {
            s1.push(val);
            System.out.println("Value pushed on stack1 is: "+val);
        } else {
            while(!s2.isEmpty()) {
                s1.push(s2.pop());
            }
            s1.push(val);
            System.out.println("Value peeked: "+val);
        }
    }

    public int deque() {
        if(!s2.isEmpty()) {
            return s2.pop();
        } else {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    public int peek() {

        if(!s2.isEmpty()) {
            return s2.peek();
        } else {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    public int size() {
        return s1.size() + s2.size();
    }
}
