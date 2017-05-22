package com.company;

import apple.laf.JRSUIUtils;

/**
 * Created by qurrat on 5/22/17.
 */
public class SortedArrayToTree {
    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            data = val;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        printPreOrder(createMinimalBST(arr));
    }

    public static void printPreOrder(TreeNode n) {
        if ( n == null ) {
            return;
        }

        System.out.println(n.data);
        printPreOrder(n.left);
        printPreOrder(n.right);
    }

    public static TreeNode createMinimalBST(int arr[]) {
        if ( arr == null ) {
            return null;
        }
        return createBST(arr, 0, arr.length - 1);
    }

    public static TreeNode createBST(int[] arr, int start, int end) {
        if ( end < start ) {
            return null;
        }

        int mid = start + ( end - start ) / 2;
        TreeNode n = new TreeNode(arr[mid]);

        n.left = createBST(arr, start, mid - 1);
        n.right = createBST(arr, mid + 1, end);

        return n;

    }
}
