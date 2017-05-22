package com.company;

/**
 * Created by qulain on 5/16/2017.
 */
public class ThreeStacksInSingleArraySolutionOne {
    int stackCapacity = 5;
    int[] arr = new int[stackCapacity * 3];
    int[] stackPointer = {0,0,0};

    void push(int stackNumber, int value) {
        if ( isFull(stackNumber) ) {
            System.out.println("Stack is Full and cannot add " +value+ " in "+stackNumber);
        } else {
            int index = stackNumber * stackCapacity + stackPointer[stackNumber];
            stackPointer[stackNumber]++;
            arr[index] = value;
            System.out.println("Value added in stack " + stackNumber + ": " + arr[index]);
        }
    }

    int pop(int stackNumber) {
        if(isEmpty(stackNumber)) {
            System.out.println("Stack is Empty");
            return -1;
        }

        int index = stackNumber * stackCapacity + stackPointer[stackNumber] - 1;
        stackPointer[stackNumber]--;
        int value = arr[index];
        System.out.println("VALUE popped from  stack "+stackNumber+ ": " +value);
        return value;
    }

    int peek(int stackNumber) {
	if(isEmpty(stackNumber)) {
            System.out.println("Stack is Empty");
            return -1;
        }
        int index = stackCapacity * stackNumber + stackPointer[stackNumber] - 1;
        System.out.println("Top value on stack is: "+arr[index]);
        return arr[index];
    }

    boolean isEmpty(int stackNumber) {
        if ( stackPointer[stackNumber] == 0 ) {
            return true;
        }
        return false;
    }

    boolean isFull(int stackNumber) {
        if ( stackPointer[stackNumber] >= stackCapacity) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ThreeStacksInSingleArraySolutionOne test1 = new ThreeStacksInSingleArraySolutionOne();
        test1.push(0,0);
        test1.push(0,1);
        test1.push(0,2);
        test1.push(0,3);
        test1.push(0,4);
        test1.push(0,5);
        test1.pop(0);
        test1.peek(0);

        test1.pop(1);
        test1.push(1,0);
        test1.push(1,2);
        test1.push(1,3);
        test1.pop(1);
        test1.peek(1);

        test1.push(2,0);
        test1.push(2,1);
        test1.pop(2);
        test1.peek(2);

    }

}
