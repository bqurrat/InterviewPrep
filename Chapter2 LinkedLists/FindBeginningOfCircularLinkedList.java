package com.company;

/**
 * Created by qurrat on 5/12/17.
 */
public class FindBeginningOfCircularLinkedList {
    public static Node head;
    public static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static Node findBeginning(Node head) {
        /*
        ALGORITHM:
        Step 1: Create two pointers. One will move one step, other will move tw steps
        Step 2: if two pointers meet at a point, break (meeting means list is circular)
        Step 3: Move n1 to head and n2 will be at the same point
        Step 4: loop both pointers and break where they meet (that will be starting point of circular linkedList)
         */

        Node n1 = head;
        Node n2 = head;

        while (n2.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;

            if ( n1 == n2 ) {
                break;
            }
        }

        if (n2.next == null) {
            return null;
        }

        n1 = head;
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }

        return n2;
    }

    public static void main(String[] args) {
        FindBeginningOfCircularLinkedList list = new FindBeginningOfCircularLinkedList();

        list.head = new Node(50);
        list.head.next = new Node(20);
        list.head.next.next = new Node(15);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(10);

        printList(head);

        // Creating a loop for testing
        head.next.next.next.next.next = head.next.next;
        //findBeginning(head);
        if(findBeginning(head)!= null) {
            System.out.println("Starting point of circular list is "+findBeginning(head).data);
        } else {
            System.out.println("List is not circular");
        }

    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println("\n");
    }
}
