package com.company;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by qurrat on 5/20/17.
 */
public class StackSort {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(3);
        stack.push(1);
        stack.push(2);
        stack.push(4);
        stack.push(7);
        stack.push(0);
        System.out.println(Arrays.toString(stack.toArray()));

        sortStack(stack);

    }

    public static Stack<Integer> sortStack(Stack<Integer> originalStack) {
        Stack<Integer> resulantStack = new Stack<Integer>();
        while ( !originalStack.isEmpty() ) {
            int item = originalStack.pop();

            while ( !resulantStack.isEmpty() && (item < resulantStack.peek()) ) {
                originalStack.push(resulantStack.pop());
            }
            resulantStack.push(item);
        }
        System.out.println(Arrays.toString(resulantStack.toArray()));

        return resulantStack;
    }
}
