package com.company;

/**
 * Implement an algorithm to  nd the nth to last element of a singly linked list.
 * Created by qurrat on 5/11/17.
 */
public class FindNthElementFromLast {
    public static Node head;

    public static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }



    public static void main(String[] args) {
        FindNthElementFromLast list = new FindNthElementFromLast();
        list.head = new FindNthElementFromLast.Node(10);
        list.head.next = new FindNthElementFromLast.Node(20);
        list.head.next.next = new FindNthElementFromLast.Node(30);
        list.head.next.next.next = new FindNthElementFromLast.Node(40);
        list.head.next.next.next.next = new FindNthElementFromLast.Node(50);



        System.out.println("Linked List : \n ");
        list.printList(head);
        System.out.println(findNthFromLast(head, 10));
        System.out.println(findNthFromLast(head, 5));
        System.out.println(findNthFromLast(head, 4));
        System.out.println(findNthFromLast(head, 3));
        System.out.println(findNthFromLast(head, 2));
        System.out.println(findNthFromLast(head, 1));
        System.out.println(findNthFromLast(head, 0));
    }



    public static int findNthFromLast(FindNthElementFromLast.Node head, int nth) {
        /*
        ALGORITHM:
        1. count the number of nodes in linkedlist
        2. calculate the position of nth to last element: sizeOfLinkedList - (n + 1)
        3. Loop through linkedlist till that position of node
        4. Get value in that node
         */

        if(head == null || nth < 1) {
            System.out.print("Node does not exist");
            return 0;
        }
        Node temp = head;
        int numberOfNodes = 0;
        while(head != null) {
            head = head.next;
            ++numberOfNodes;
        }

        if(nth > numberOfNodes) {
            System.out.println("Not possible because size of linked list is smaller than nth");
            return 0;
        }
        int positionOfNthNode = numberOfNodes - nth + 1;

        if (positionOfNthNode == 1) {
            return temp.data;
        } else {
            for (int i = 1; i < positionOfNthNode; ++i) {
                temp = temp.next;
                //System.out.println(temp.data);
            }
        }
        return temp.data;
    }

    public static void printList(FindNthElementFromLast.Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println("\n");
    }



}
