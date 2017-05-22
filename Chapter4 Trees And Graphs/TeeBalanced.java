package com.company;

import apple.laf.JRSUIUtils;

/**
 * Created by qurrat on 5/21/17.
 */
public class TeeBalanced {

    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int v) {
            data = v;
            left = null;
            right = null;
        }

        public static void printPreOrder(TreeNode root) {
            if ( root != null ) {
                System.out.println(root.data + " ");
                printPreOrder(root.left);
                printPreOrder(root.right);
            }
        }
    }

    public static boolean isBalancedTree(TreeNode root) {
        if ( maxHeight(root) - minHeight(root) <= 1 ) {
            return true;
        }
        return false;
    }

    public static int maxHeight(TreeNode root) {
        if ( root == null ) {
            return 0;
        }
        return 1 + Math.max(maxHeight(root.left), maxHeight(root.right));
    }

    public static int minHeight(TreeNode root) {
        if ( root == null ) {
            return 0;
        }
        return 1 + Math.min(minHeight(root.left), minHeight(root.right));
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(50);

        TreeNode t1l = new TreeNode(30);
        TreeNode t1r = new TreeNode(80);

        TreeNode t1ll = new TreeNode(10);
        TreeNode t1lr = new TreeNode(20);

        TreeNode t1rl = new TreeNode(60);

        t1.left = t1l;
        t1.right = t1r;

        t1l.left = t1ll;
        t1l.right = t1lr;

        t1r.left = t1rl;

        TreeNode.printPreOrder(t1);
        boolean res = isBalancedTree(t1);
        System.out.println((res) ? "Tree is balanced" : "Tree is not balanced");
    }

}
