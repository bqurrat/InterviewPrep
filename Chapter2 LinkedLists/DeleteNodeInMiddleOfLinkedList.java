package com.company;

/**
 * Created by qurrat on 5/10/17.
 */
public class DeleteNodeInMiddleOfLinkedList {
    public static Node head;

    public static class Node {
        char data;
        Node next;

        Node(char d) {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        DeleteNodeInMiddleOfLinkedList list = new DeleteNodeInMiddleOfLinkedList();
        list.head = new Node('a');
        list.head.next = new Node('b');
        list.head.next.next = new Node('c');
        list.head.next.next.next = new Node('d');
        list.head.next.next.next.next = new Node('e');



        System.out.println("Linked List beore deleting middle element : \n ");
        list.printList(head);

        list.removeNode(head.next.next);
        System.out.println("Linked List after deleting middle element : \n ");
        list.printList(head);
    }

    public static void removeNode(Node nodeToBeDeleted) {
        /* ALGORITHM:
        1. Copy the value of next node to the node which you want to delete
        2. Delete the next node
         */


        if(nodeToBeDeleted == null || nodeToBeDeleted.next == null) {
            return;
        }

        //Node temp = nodeToBeDeleted;
        nodeToBeDeleted.data = nodeToBeDeleted.next.data;
        nodeToBeDeleted.next = nodeToBeDeleted.next.next;
    }

    public static void printList(DeleteNodeInMiddleOfLinkedList.Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println("\n");
    }


}
