package com.company;

/**
 * Created by qulain on 5/12/2017.
 */


public class AddTwoLinkedLists {

    static Node head1, head2;

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static Node addTwoLinkedLists(Node head1, Node head2) {
        /*
        ALGORITHM:

        1. Create a resultant list and move the tail pointer whenever add a node
        2. Loop the linkedLists while anyone exists
        3. calculate the sum of two nodes: If node does not exist in any of the linkedlist-> add zero for that node
               if sum of two nodes > 10, carry = 1 : else carry = 0;
        4. create a temporary node with data = sum and append it it to resultant list
        5. increment pointers of linkedlist1 and linkedlist2 (if they are not null)
        */

        Node resultantList = null;
        Node tail = null;
        int sum,carry = 0;

         //loop will continue if any of the list exists
        while( (head1 != null) || (head2 != null) ) {

            int dataFrom1stLinkedList = head1 != null? head1.data : 0;
            int dataFrom2stLinkedList = head2 != null ? head2.data : 0;

             //Get sum of two nodes and update carry value for next calculation
            int sumOfTwoNodes = dataFrom1stLinkedList + dataFrom2stLinkedList + carry;
            carry = sumOfTwoNodes >= 10 ? 1: 0;
            sum = sumOfTwoNodes % 10;

            if ( head1 != null ) {
                head1 = head1.next;
            }

            if ( head2 != null ) {
                head2 = head2.next;
            }

            // create a new node and append it in resultant list
            Node temp = new Node(sum);
            // if its a first element in list
            if (resultantList == null ) {
                resultantList = temp;
                tail = temp;
            } else  {
                tail.next = temp;
            }
            tail = temp;

        }
        if (carry == 1) {
            Node temp = new Node(carry);
            if (resultantList == null ) {
                resultantList = temp;
                tail = temp;
            } else  {
                tail.next = temp;
            }
            tail = temp;
        }

        return resultantList;
    }
  

    /* Utility function to print a linked list */
    void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        AddTwoLinkedLists testCase1 = new AddTwoLinkedLists();
        AddTwoLinkedLists testCase2 = new AddTwoLinkedLists();
        AddTwoLinkedLists testCase3 = new AddTwoLinkedLists();

        // creating first list for testCase 1
        testCase1.head1 = new Node(7);
        testCase1.head1.next = new Node(5);
        testCase1.head1.next.next = new Node(9);
        testCase1.head1.next.next.next = new Node(4);
        testCase1.head1.next.next.next.next = new Node(6);
        System.out.print("First List is ");
        testCase1.printList(testCase1.head1);

        // creating seconnd list
        testCase1.head2 = new Node(8);
        testCase1.head2.next = new Node(4);
        System.out.print("Second List is ");
        testCase1.printList(testCase1.head2);

        // add the two lists and see the result
        Node rs1 = testCase1.addTwoLinkedLists(head1, head2);
        System.out.print("Resultant List is ");
        testCase1.printList(rs1);
        System.out.println("\n");

        // creating first list for testCase 1
        testCase2.head1 = new Node(5);
        testCase2.head1.next = new Node(6);
        testCase2.head1.next.next = new Node(3);
        System.out.print("First List is ");
        testCase2.printList(testCase2.head1);

        // creating seconnd list
        testCase2.head2 = new Node(8);
        testCase2.head2.next = new Node(4);
        testCase2.head2.next.next = new Node(2);
        System.out.print("Second List is ");
        testCase2.printList(testCase2.head2);


        // add the two lists and see the result
        Node rs2 = testCase1.addTwoLinkedLists(head1, head2);
        System.out.print("Resultant List is ");
        testCase1.printList(rs2);
        System.out.println("\n");

        // creating first list for testCase 1
        testCase3.head1 = new Node(5);
        testCase3.head1.next = new Node(6);
        testCase3.head1.next.next = new Node(8);
        System.out.print("First List is ");
        testCase1.printList(testCase3.head1);

        // creating seconnd list
        testCase3.head2 = new Node(8);
        testCase3.head2.next = new Node(4);
        testCase3.head2.next.next = new Node(8);
        System.out.print("Second List is ");
        testCase1.printList(testCase3.head2);

        // add the two lists and see the result
        Node rs3 = testCase3.addTwoLinkedLists(head1, head2);
        System.out.print("Resultant List is ");
        testCase1.printList(rs3);
    }
}


