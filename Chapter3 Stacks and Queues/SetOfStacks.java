package com.company;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by qurrat on 5/18/17.
 */
public class SetOfStacks {
    public static int capacity = 3;
    public LinkedList<Stack<Integer>> ll = new LinkedList<Stack<Integer>>();

    public void push(int v) {
        /* if linkedlist is empty  or capacity at that index is full
                create a stack and push the element on that
                add that stack to linkedList
           Else : get last element(stack) in linkedlist and push value on that
         */
        if ( ll.isEmpty() || ll.getLast().size() >= capacity ) {
            Stack<Integer> stack = new Stack<Integer>();
            stack.push(v);
            ll.add(stack);
        } else {
            ll.getLast().push(v);
        }
    }

    public int pop(){
        /*
        Throw exception if linkedlist is empty
        get last index of linkedlist and pop from that stack

        Also check if stack in last index becomes empty after removing then remove that stack  from linkedlist
         */
        if ( ll.isEmpty() ) {
            throw new IllegalStateException("LinkedList is empty");
        }

        int item =  ll.getLast().pop();
        if(ll.getLast().isEmpty()) {
            ll.removeLast();
        }
        return item;
    }

    public int popAt(int stackNumber) {
        /*
        1. check boundary conditions and throw exception if any of the condition meets
            a. if linkedlist is empty
            b. stackNumber < 0
            c. stackNumber > linkedList size

        2. Get stack at that index(stackNumber) and pop the element from that
        3. above pop operation will leave a space on linkedlist.. move all the element one step to maintain stacks with maximum capacity
        4. if last stack becomes empty : remove that stack
        5. return value obtained in step 2
         */

        if ( ll.isEmpty() ) {
            throw new IllegalStateException("LisnkedList i sempty");
        }

        if ( stackNumber < 0 || stackNumber > ll.size() ) {
            throw  new IllegalStateException("This stackNumber is not available");
        }

        int v = ll.get(stackNumber).pop();
        for ( int i = stackNumber; i < ll.size() - 1; ++i ) {
            Stack<Integer> current = ll.get(stackNumber);
            Stack<Integer> next = ll.get(stackNumber + 1);
            current.push(next.remove(0));
        }

        if ( ll.getLast().isEmpty() ) {
            ll.removeLast();
        }

        return v;
    }

    public void printStacks() {
        for ( Stack<Integer> stack: ll ) {
            for ( int item: stack) {
                System.out.print(item + " ");
            }
        }
        System.out.println("\n");
    }


    public static void main(String args[]) {
        SetOfStacks setOfStacks = new SetOfStacks();
        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3);
        setOfStacks.push(4);
        setOfStacks.push(5);
        setOfStacks.push(6);
        setOfStacks.push(7);
        setOfStacks.push(8);
        setOfStacks.push(9);
        setOfStacks.printStacks();

        setOfStacks.pop();
        setOfStacks.pop();
        setOfStacks.pop();
        setOfStacks.printStacks();

        setOfStacks.popAt(0);
        setOfStacks.popAt(1);
        setOfStacks.printStacks();

    }
}
