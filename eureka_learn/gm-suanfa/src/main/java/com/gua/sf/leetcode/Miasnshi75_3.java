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


    /**
     * 1448. 统计二叉树中好节点的数目
     * 给你一棵根为 root 的二叉树，请你返回二叉树中好节点的数目。
     * <p>
     * 「好节点」X 定义为：从根到该节点 X 所经过的节点中，没有任何节点的值大于 X 的值。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：root = [3,1,4,3,null,1,5]
     * 输出：4
     * 解释：图中蓝色节点为好节点。
     * 根节点 (3) 永远是个好节点。
     * 节点 4 -> (3,4) 是路径中的最大值。
     * 节点 5 -> (3,4,5) 是路径中的最大值。
     * 节点 3 -> (3,1,3) 是路径中的最大值。
     * 示例 2：
     * <p>
     * <p>
     * <p>
     * 输入：root = [3,3,null,4,2]
     * 输出：3
     * 解释：节点 2 -> (3, 3, 2) 不是好节点，因为 "3" 比它大。
     * 示例 3：
     * <p>
     * 输入：root = [1]
     * 输出：1
     * 解释：根节点是好节点。
     */

    public int goodNodes(TreeNode root) {
        /**
         * 分析：采用递归算法
         * 1.递归方法
         * 2.用max记录最大值
         * 3.用sum记录好节点数量
         * 4.当前节点的好节点数量=当前节点是否是好节点+左子节点的好节点数量+右子节点的好节点数量
         */
        return getNodes(root, root.val);

    }

    public int getNodes(TreeNode treeNode, int max) {
        if (treeNode == null) {
            return 0;
        }
        int sum = 0;
        int val = treeNode.val;
        if (val >= max) {
            sum++;
            max = val;
        }
        sum = sum + getNodes(treeNode.left, max);
        sum = sum + getNodes(treeNode.right, max);
        return sum;
    }

    /**
     * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
     * <p>
     * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
     * 输出：3
     * 解释：和等于 8 的路径有 3 条，如图所示。
     * 示例 2：
     * <p>
     * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
     * 输出：3
     */
    public int pathSum(TreeNode root, int targetSum) {

        /**
         * 分析
         * 1.采用递归
         * 2.第一个递归方法把树分解成一个个以当前节点为根的树，并返回当前树的路径数目
         * 3.第二个递归方法，求当前节点为根的树的路径树木
         */


        return asRootTreeSum(root, Long.valueOf(targetSum));
    }

    public int asRootTreeSum(TreeNode treeNode, Long targetSum) {
        if (treeNode == null) {
            return 0;
        }
        int sum;
        sum = asRootTreeGetPathSum(treeNode, targetSum, 0L);
        sum += asRootTreeSum(treeNode.left, targetSum);
        sum += asRootTreeSum(treeNode.right, targetSum);
        return sum;
    }

    public int asRootTreeGetPathSum(TreeNode treeNode, Long targetSum, Long beforeSum) {
        if (treeNode == null) {
            return 0;
        }
        int nowRootTreeSum = 0;
        Long now = beforeSum + treeNode.val;
        if (now.equals(targetSum)) {
            nowRootTreeSum++;
        }
        nowRootTreeSum += asRootTreeGetPathSum(treeNode.left, targetSum, now);
        nowRootTreeSum += asRootTreeGetPathSum(treeNode.right, targetSum, now);
        return nowRootTreeSum;
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


        Integer[] goodNodesArray = {3, 1, 4, 3, null, 1, 5};
        TreeNode goodNodesTreeNode = m.arrayToTreeNode(goodNodesArray);
        int goodNodesResult = m.goodNodes(goodNodesTreeNode);
        Assert.isTrue(4 == goodNodesResult, "算法错误");


//        [1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000]
//                                                   2147483647
//        0
        Integer[] pathSumArray = {8, 8, 8};
        int pathSumTarget = 8;
        TreeNode pathSumTreeNode = m.arrayToTreeNode(pathSumArray);
        int pathSumResult = m.pathSum(pathSumTreeNode, pathSumTarget);
        Assert.isTrue(3 == pathSumResult, "算法错误");
    }
}
