package com.gua.sf.leetcode;

/**
 * @author 86188
 */
public class BinarySearchTree {
    private TreeNode root;

    public void insert(int value) {
        root = insertNode(root, value);
    }

    private TreeNode insertNode(TreeNode node, int value) {
        if (node == null) {
            return new TreeNode(value);
        }

        if (value < node.val) {
            node.left = insertNode(node.left, value);
        } else if (value > node.val) {
            node.right = insertNode(node.right, value);
        }

        return node;
    }

    public boolean search(int value) {
        return searchNode(root, value);
    }

    private boolean searchNode(TreeNode node, int value) {
        if (node == null) {
            return false;
        }

        if (value == node.val) {
            return true;
        } else if (value < node.val) {
            return searchNode(node.left, value);
        } else {
            return searchNode(node.right, value);
        }
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.left);
        System.out.print(node.val + " ");
        inOrderTraversal(node.right);
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(5);
        bst.insert(2);
        bst.insert(7);
        bst.insert(1);
        bst.insert(3);
        bst.insert(6);
        bst.insert(8);

        bst.inOrderTraversal(); // 输出：1 2 3 5 6 7 8

        System.out.println();
        // 输出：true
        System.out.println(bst.search(3));
        // 输出：false
        System.out.println(bst.search(4));
    }
}

