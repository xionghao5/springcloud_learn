package com.gua.sf.leetcode;

import org.springframework.util.Assert;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 面试必考精华版，75 题覆盖全量考点
 */
public class Miasnshi75_3 {


    /**
     * Definition for a binary tree node.
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public TreeNode arrayToBinaryTree(Integer[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        return arrayToTreeNode(array, 0);
    }

    public TreeNode arrayToTreeNode(Integer[] array, int index) {
        if (index >= array.length || array[index] == null) {
            return null;
        }
        TreeNode treeNode = new TreeNode(array[index]);
        treeNode.left = arrayToTreeNode(array, 2 * index + 1);
        treeNode.right = arrayToTreeNode(array, 2 * index + 2);
        return treeNode;
    }

    /**
     * 数组转化为二叉树
     *
     * @param array
     * @return
     */
    public TreeNode arrayToTreeNode(Integer[] array) {
        if (array.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isLeft = true;
        for (int i = 1; i < array.length; i++) {
            TreeNode node = queue.peek();
            if (isLeft) {
                if (array[i] != null) {
                    node.left = new TreeNode(array[i]);
                    queue.offer(node.left);
                }
                isLeft = false;
            } else {
                if (array[i] != null) {
                    node.right = new TreeNode(array[i]);
                    queue.offer(node.right);
                }
                queue.poll();
                isLeft = true;
            }
        }
        return root;
    }

    public void printBinaryTreeToArray(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.print(treeNode.val + " ");
        printBinaryTreeToArray(treeNode.left);
        printBinaryTreeToArray(treeNode.right);
    }


    /**
     * 104. 二叉树的最大深度
     * 给定一个二叉树，找出其最大深度。
     * <p>
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     * <p>
     * 说明: 叶子节点是指没有子节点的节点。
     * <p>
     * 示例：
     * 给定二叉树 [3,9,20,null,null,15,7]，
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回它的最大深度 3 。
     */

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rigthDepth = maxDepth(root.right);
        int maxDepth = leftDepth > rigthDepth ? leftDepth : rigthDepth;
        return maxDepth + 1;
    }

    public static void main(String[] args) {

        Integer[] array = {3, 9, 20, null, null, 15, 7};
        Miasnshi75_3 m = new Miasnshi75_3();
        TreeNode treeNode = m.arrayToTreeNode(array);
        TreeNode diguiTreeNode = m.arrayToTreeNode(array);
        m.printBinaryTreeToArray(treeNode);
        m.printBinaryTreeToArray(diguiTreeNode);
        int maxDepth = m.maxDepth(treeNode);

        Assert.isTrue(3 == maxDepth, "每个数的出现次数不是独一无二的");

    }
}
