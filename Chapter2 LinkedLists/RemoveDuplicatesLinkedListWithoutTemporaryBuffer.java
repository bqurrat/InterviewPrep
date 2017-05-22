package com.company;

/**
 * Created by qulain on 5/10/2017.
 */


/* Write code to remove duplicates from an unsorted linked list without using any temporary bufer */
public class RemoveDuplicatesLinkedListWithoutTemporaryBuffer {
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
        RemoveDuplicatesLinkedListWithoutTemporaryBuffer list = new RemoveDuplicatesLinkedListWithoutTemporaryBuffer();
        list.head = new Node(10);
        list.head.next = new Node(12);
        list.head.next.next = new Node(11);
        list.head.next.next.next = new Node(11);
        list.head.next.next.next.next = new Node(12);
        list.head.next.next.next.next.next = new Node(11);
        list.head.next.next.next.next.next.next = new Node(13);

        System.out.println("Linked List before removing duplicates : \n ");
        list.printList(head);

        list.remove_duplicates(head);
        list.printList(head);
    }

    public static void remove_duplicates(Node head) {
       /*ALGORITHM:
        Variant: tail is pointing to node till elements are unique
        check the element at tail.next and check if it exist in previous nodes
        If it exist then, point tail.next to it next element and tail.next to null
        If it does not exist: increment tail
        */

        Node tail = head;
        while (tail.next != null) {
            if(isPresent(head, tail, tail.next.data)) {
               tail.next = tail.next.next;
            } else {
                tail = tail.next;
            }
        }
    }

    public static boolean isPresent(Node head, Node tail, int data) {
        Node temp = head;
        while(temp != tail.next) {
            if ( temp.data == data ) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println("\n");
    }


}



