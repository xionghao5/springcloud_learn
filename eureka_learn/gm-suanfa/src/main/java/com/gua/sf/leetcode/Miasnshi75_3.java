package com.gua.sf.leetcode;

import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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


    /**
     * 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
     * <p>
     * <p>
     * <p>
     * 举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。
     * <p>
     * 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
     * <p>
     * 如果给定的两个根结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
     * 输出：true
     * 示例 2：
     * <p>
     * <p>
     * <p>
     * 输入：root1 = [1,2,3], root2 = [1,3,2]
     * 输出：false
     *
     * @param root1
     * @param root2
     * @return
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        /**
         * 1.采用递归
         * 2.用list顺序存储叶子节点的值
         * 3.然后比较2个list是否相同
         */
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        getLeafListFromTree(list1, root1);
        getLeafListFromTree(list2, root2);
        return list1.equals(list2);
    }

    public void getLeafListFromTree(List<Integer> list, TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        if (treeNode.left == null && treeNode.right == null) {
            list.add(treeNode.val);
        }
        getLeafListFromTree(list, treeNode.left);
        getLeafListFromTree(list, treeNode.right);
    }

    public static void main(String[] args) {

        Integer[] array = {3, 9, 20, null, null, 15, 7};
        Miasnshi75_3 m = new Miasnshi75_3();
        TreeNode treeNode = m.arrayToTreeNode(array);
        TreeNode diguiTreeNode = m.arrayToTreeNode(array);
        m.printBinaryTreeToArray(treeNode);
        m.printBinaryTreeToArray(diguiTreeNode);
        int maxDepth = m.maxDepth(treeNode);

        Assert.isTrue(3 == maxDepth, "算法错误");


        Integer[] leafSimilarArray1 = {3, 5, 1, 6, 2, 9, 8, null, null, 7, 4};
        Integer[] leafSimilarArray2 = {3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8};
        TreeNode leafSimilarTreeNode1 = m.arrayToTreeNode(leafSimilarArray1);
        TreeNode leafSimilarTreeNode2 = m.arrayToTreeNode(leafSimilarArray2);
        Assert.isTrue(m.leafSimilar(leafSimilarTreeNode1, leafSimilarTreeNode2), "算法错误");
    }
}
