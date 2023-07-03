package com.gua.sf.leetcode;

import org.springframework.util.Assert;

import java.util.*;

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

    public TreeNode constractTreeNode(int val) {
        return new TreeNode(val);
    }

    /**
     * 计算二叉树节点数量
     *
     * @param treeNode
     * @return
     */
    int countBinaryTreeNodeNodes = 0;

    public int countBinaryTreeNodeNodes(TreeNode root) {
        countBinaryTreeNodeNodes++;
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left != null || right != null) {
            countBinaryTreeNodeNodes(left);
            countBinaryTreeNodeNodes(right);
        }
        return countBinaryTreeNodeNodes;
    }

    /**
     * 二叉树转换成list
     *
     * @param treeNode
     * @return
     */
    public Integer[] binaryTreeToArray(TreeNode treeNode) {
        if (treeNode == null) {
            return new Integer[]{};
        }
        int treeNodeSize = countBinaryTreeNodeNodes(treeNode);
        Integer[] array = new Integer[treeNodeSize];
        binaryTreeToArray(array, treeNode, 0);
        return array;
    }

    public void binaryTreeToArray(Integer[] array, TreeNode treeNode, int index) {
        if (treeNode != null) {
            array[index] = treeNode.val;
        } else {
            array[index] = null;
        }
        TreeNode left = treeNode.left;
        TreeNode right = treeNode.right;
        if (left != null || right != null) {
            binaryTreeToArray(array, left, 2 * index + 1);
            binaryTreeToArray(array, right, 2 * index + 2);
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


    /**
     * 1372. 二叉树中的最长交错路径
     * 给你一棵以 root 为根的二叉树，二叉树中的交错路径定义如下：
     * <p>
     * 选择二叉树中 任意 节点和一个方向（左或者右）。
     * 如果前进方向为右，那么移动到当前节点的的右子节点，否则移动到它的左子节点。
     * 改变前进方向：左变右或者右变左。
     * 重复第二步和第三步，直到你在树中无法继续移动。
     * 交错路径的长度定义为：访问过的节点数目 - 1（单个节点的路径长度为 0 ）。
     * <p>
     * 请你返回给定树中最长 交错路径 的长度。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1]
     * 输出：3
     * 解释：蓝色节点为树中最长交错路径（右 -> 左 -> 右）。
     * 示例 2：
     * <p>
     * <p>
     * <p>
     * 输入：root = [1,1,1,null,1,null,null,1,1,null,1]
     * 输出：4
     * 解释：蓝色节点为树中最长交错路径（左 -> 右 -> 左 -> 右）。
     * 示例 3：
     * <p>
     * 输入：root = [1]
     * 输出：0
     */

    public int maxPath = 0;

    public int longestZigZag(TreeNode root) {
        /**
         *分析：
         * 1.递归
         * 2.首先把树分解成一个个以当前节点为根的树
         * 3.然后判断每棵树的最大交错长度。
         * 4.如何计算每棵树的最大交错长度。
         * 5.设置一个全局变量maxPath，用来记录最大交错路径
         * 6.设置一个标记flag，用来标记向左还是向右。如果当前节点不为空，则maxPath++;
         *
         *
         * 但是，双递归，如果树的节点太多，就会比较慢
         */
        getSonTreeNode(root);
        return maxPath;
    }

    public void getSonTreeNode(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        beginCountRootTreeNodePath(treeNode);
        getSonTreeNode(treeNode.left);
        getSonTreeNode(treeNode.right);
    }

    public void beginCountRootTreeNodePath(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        countSonTreeNodePath(treeNode.left, true, 0);
        countSonTreeNodePath(treeNode.right, false, 0);
    }


    public void countSonTreeNodePath(TreeNode treeNode, boolean flag, int pathCount) {
        if (treeNode == null) {
            return;
        } else {
            pathCount++;
            maxPath = maxPath > pathCount ? maxPath : pathCount;
        }
        if (flag) {
            countSonTreeNodePath(treeNode.right, false, pathCount);
        } else {
            countSonTreeNodePath(treeNode.left, true, pathCount);
        }

    }


    public int longestZigZag2(TreeNode root) {
        /**
         *分析：
         * 1.递归
         * 4.如何计算每棵树的最大交错长度。
         * 5.设置一个全局变量maxPath，用来记录最大交错路径
         * 6.设置一个标记flag，用来标记向左还是向右。
         * 5.在当前节点，就判断子节点是否为空，在当前节点就计算路径，在子节点计算最大交错长度；如何子节点不能交错，要重新计算长度
         *
         *
         * 但是，双递归，如果树的节点太多，就会比较慢.所以只能采用单递归
         */

        if (root == null) {
            return maxPath;
        }
        countSonTreePath(root, true, 0);
        countSonTreePath(root, false, 0);
        return maxPath;
    }

    public void countSonTreePath(TreeNode treeNode, boolean flag, int len) {
        maxPath = maxPath > len ? maxPath : len;

        TreeNode left = treeNode.left;
        TreeNode right = treeNode.right;
        if (flag) {
            if (right != null) {
                countSonTreePath(right, false, len + 1);
            }
            if (left != null) {
                countSonTreePath(left, true, 1);
            }
        } else {
            if (left != null) {
                countSonTreePath(left, true, len + 1);
            }
            if (right != null) {
                countSonTreePath(right, false, 1);
            }
        }
    }

    /**
     * 236. 二叉树的最近公共祖先
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     * <p>
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
     * 输出：3
     * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
     * 示例 2：
     * <p>
     * <p>
     * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
     * 输出：5
     * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
     * 示例 3：
     * <p>
     * 输入：root = [1,2], p = 1, q = 2
     * 输出：1
     * <p>
     * <p>
     * 提示：
     * <p>
     * 树中节点数目在范围 [2, 105] 内。
     * -109 <= Node.val <= 109
     * 所有 Node.val 互不相同 。
     * p != q
     * p 和 q 均存在于给定的二叉树中。
     */

    Map<Integer, TreeNode> parentMap = new HashMap<>();
    Set<Integer> visitedSet = new HashSet<>();

    public void dfsFunction(TreeNode treeNode) {
        TreeNode left = treeNode.left;
        if (left != null) {
            parentMap.put(left.val, treeNode);
            dfsFunction(left);
        }
        TreeNode right = treeNode.right;
        if (right != null) {
            parentMap.put(right.val, treeNode);
            dfsFunction(right);
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfsFunction(root);
        while (p != null) {
            visitedSet.add(p.val);
            p = parentMap.get(p.val);
        }
        while (q != null) {
            if (visitedSet.contains(q.val)) {
                return q;
            }
            q = parentMap.get(q.val);
        }
        return null;
    }

    /**
     * 199. 二叉树的右视图
     * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * <p>
     * <p>
     * 输入: [1,2,3,null,5,null,4]
     * 输出: [1,3,4]
     * 示例 2:
     * <p>
     * 输入: [1,null,3]
     * 输出: [1,3]
     * 示例 3:
     * <p>
     * 输入: []
     * 输出: []
     * <p>
     * <p>
     * 提示:
     * <p>
     * 二叉树的节点个数的范围是 [0,100]
     * -100 <= Node.val <= 100
     */

//    public List<Integer> rightSideView(TreeNode root) {
//        /**
//         * 分析：
//         * 1.递归
//         * 2.遍历树的右边节点，并存入list
//         */
//        List<Integer> list = new ArrayList<>();
//        fillRightNodeValToList(root, list);
//        return list;
//    }
//
//    public void fillRightNodeValToList(TreeNode treeNode, List<Integer> list) {
//        if (treeNode == null) {
//            return;
//        }
//        list.add(treeNode.val);
//        fillRightNodeValToList(treeNode.right, list);
//    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        fillRightNodeValToList(root, 0, res); // 从根节点开始访问，根节点深度是0
        return res;
    }

    private void fillRightNodeValToList(TreeNode root, int depth, List<Integer> res) {
        if (root == null) {
            return;
        }
        // 先访问 当前节点，再递归地访问 右子树 和 左子树。
        if (depth == res.size()) {   // 如果当前节点所在深度还没有出现在res里，说明在该深度下当前节点是第一个被访问的节点，因此将当前节点加入res中。
            res.add(root.val);
        }
        depth++;
        fillRightNodeValToList(root.right, depth, res);
        fillRightNodeValToList(root.left, depth, res);
    }

    /**
     * 1161. 最大层内元素和
     * 给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
     * <p>
     * 请返回层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。
     * <p>
     * 示例 1：
     * 输入：root = [1,7,0,7,-8,null,null]
     * 输出：2
     * 解释：
     * 第 1 层各元素之和为 1，
     * 第 2 层各元素之和为 7 + 0 = 7，
     * 第 3 层各元素之和为 7 + -8 = -1，
     * 所以我们返回第 2 层的层号，它的层内元素之和最大。
     * <p>
     * 示例 2：
     * 输入：root = [989,null,10250,98693,-89388,null,null,null,-32127]
     * 输出：2
     * <p>
     * 提示：
     * <p>
     * 树中的节点数在 [1, 104]范围内
     * -105 <= Node.val <= 105
     */

    public List<Integer> levelSumList = new ArrayList<>();

    public int maxLevelSum(TreeNode root) {
        /**
         方法一：深度优先搜索
         我们可以采用深度优先搜索来遍历这棵二叉树，递归的同时记录当前的层号。

         相比哈希表，这里我们采用效率更高的动态数组来维护每一层的元素之和，如果当前层号达到了数组的长度，则将节点元素添加到数组末尾，否则更新对应层号的元素之和。

         然后遍历数组，找到元素之和最大，且层号最小的元素。
         */
        int maxValSumLevel = 0;
        sumNowLevelTreeNodeVal(root, 0);
        for (int i = 0; i < levelSumList.size(); i++) {
            if (levelSumList.get(i) > levelSumList.get(maxValSumLevel)) {
                maxValSumLevel = i;
            }
        }
        return maxValSumLevel + 1;
    }

    public void sumNowLevelTreeNodeVal(TreeNode treeNode, int level) {
        if (treeNode == null) {
            return;
        }
        if (level == levelSumList.size()) {
            levelSumList.add(treeNode.val);
        } else {
            levelSumList.set(level, levelSumList.get(level) + treeNode.val);
        }
        sumNowLevelTreeNodeVal(treeNode.left, level + 1);
        sumNowLevelTreeNodeVal(treeNode.right, level + 1);
    }

    /**
     * 700. 二叉搜索树中的搜索
     * 给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
     * <p>
     * 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。
     * <p>
     * 示例 1:
     * 输入：root = [4,2,7,1,3], val = 2
     * 输出：[2,1,3]
     * <p>
     * 示例 2:
     * 输入：root = [4,2,7,1,3], val = 5
     * 输出：[]
     * 提示：
     * <p>
     * 数中节点数在 [1, 5000] 范围内
     * 1 <= Node.val <= 107
     * root 是二叉搜索树
     * 1 <= val <= 107
     */

    public TreeNode searchBSTTreeNode = null;

    public TreeNode searchBST(TreeNode root, int val) {

        /**
         * 分析
         * 1.递归
         * 2.如果节点值等于val,返回当前节点
         */
        searchEqualValTreeNode(root, val);
        return searchBSTTreeNode;
    }

    public void searchEqualValTreeNode(TreeNode treeNode, int val) {
        if (treeNode == null) {
            return;
        }
        if (val == treeNode.val) {
            searchBSTTreeNode = treeNode;
        }
        searchEqualValTreeNode(treeNode.left, val);
        searchEqualValTreeNode(treeNode.right, val);
    }

    /**
     * 450. 删除二叉搜索树中的节点
     * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
     * 一般来说，删除节点可分为两个步骤：
     * 首先找到需要删除的节点；
     * 如果找到了，删除它。
     * <p>
     * 示例 1:
     * 输入：root = [5,3,6,2,4,null,7], key = 3
     * 输出：[5,4,6,2,null,null,7]
     * 解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
     * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
     * 另一个正确答案是 [5,2,6,null,4,null,7]。
     * <p>
     * 示例 2:
     * 输入: root = [5,3,6,2,4,null,7], key = 0
     * 输出: [5,3,6,2,4,null,7]
     * 解释: 二叉树不包含值为 0 的节点
     * <p>
     * 示例 3:
     * 输入: root = [], key = 0
     * 输出: []
     * <p>
     * 提示:
     * <p>
     * 节点数的范围 [0, 104].
     * -105 <= Node.val <= 105
     * 节点值唯一
     * root 是合法的二叉搜索树
     * -105 <= key <= 105
     * <p>
     * 进阶： 要求算法时间复杂度为 O(h)，h 为树的高度。
     */

    public TreeNode deleteNode(TreeNode root, int key) {
        /**
         * 分析
         * 二叉搜索树的小的节点在左，大节点在右。
         * 所以，先要搞清楚二叉排序树是如何构造的:先从根节点开始，每一个值先和根节点比较，然后形成最新的叶子节点。
         * insert方法动态构造每一个新节点
         * 首先构造根节点，然后每一个节点和根节点进行比较，小于根节点，继续和左子节点比较；大于根节点，继续和右子节点比较；直到最后成为一个叶子节点
         * 1.递归，深度优先
         * 3.判断，如果当前节点是要删除的节点。如果当前节点有左子节点，当前节点父节点指向当前节点；然后判断当前节点是否有右节点，如果右，根据右节点的大小，来决定右节点的位置
         * 4.递归遍历
         * （1）找到要删除的节点。
         * （2）父节点指向左子节点
         * （3）左子节点指向右子节点
         * 4.分析多种情况，
         * （1）要删除的节点是root节点
         * （2）要删除的节点是叶子节点
         * （3）要删除的节点只有左节点
         * （4）要删除的节点只有右节点
         * （5）要删除的节点既有左节点，也有右节点
         */


        return root;
    }

    public void findDeleteTreeNode(TreeNode parentTreeNode, boolean parentLeftFlag, TreeNode treeNode, int key) {
        if (treeNode == null) {
            return;
        }
        if (treeNode.val == key) {

            if (treeNode.left == null && treeNode.right == null) {

                if (parentLeftFlag) {
                    parentTreeNode.left = null;
                } else {
                    parentTreeNode.right = null;
                }
            }

            if(treeNode.left!=null&&treeNode.right!=null){

            }
            if(treeNode.left!=null&&treeNode.right==null){
                if (parentLeftFlag) {
                    parentTreeNode.left = treeNode.left;
                } else {
                    parentTreeNode.right = treeNode.left;
                }
            }
        }
        findDeleteTreeNode(treeNode, true, treeNode.left, key);
        findDeleteTreeNode(treeNode, false, treeNode.right, key);
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

        Integer[] pathSumArray = {8, 8, 8};
        int pathSumTarget = 8;
        TreeNode pathSumTreeNode = m.arrayToTreeNode(pathSumArray);
        int pathSumResult = m.pathSum(pathSumTreeNode, pathSumTarget);
        Assert.isTrue(3 == pathSumResult, "算法错误");

        Integer[] longestZigZagArray = {1, 1, 1, null, 1, null, null, 1, 1, null, 1};
        TreeNode longestZigZagTreeNode = m.arrayToTreeNode(longestZigZagArray);
        int longestZigZagResult = m.longestZigZag(longestZigZagTreeNode);
        Assert.isTrue(4 == longestZigZagResult, "算法错误");


        Assert.isTrue(4 == m.longestZigZag2(m.arrayToBinaryTree(longestZigZagArray)), "算法错误");


        Integer[] lowestCommonAncestorArray = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        TreeNode lowestCommonAncestorTreeNode = m.arrayToTreeNode(lowestCommonAncestorArray);
        TreeNode p = m.constractTreeNode(5);
        TreeNode q = m.constractTreeNode(4);
        TreeNode lowestCommonAncestorResult = m.lowestCommonAncestor(lowestCommonAncestorTreeNode, p, q);
        Assert.isTrue(p.val == lowestCommonAncestorResult.val, "算法错误");


        Integer[] rightSideViewArray = {1, 2, 3, null, 5, null, 4};
        TreeNode rightSideViewArrayTreeNode = m.arrayToBinaryTree(rightSideViewArray);
        List<Integer> rightSideViewResult = m.rightSideView(rightSideViewArrayTreeNode);
        List<Integer> rightSideViewAssert = new ArrayList<>();
        rightSideViewAssert.add(1);
        rightSideViewAssert.add(3);
        rightSideViewAssert.add(4);
        Assert.isTrue(rightSideViewAssert.equals(rightSideViewResult), "算法错误");

        Integer[] maxLevelSumArray = {1, 7, 0, 7, -8, null, null};
        TreeNode maxLevelSumArrayTreeNode = m.arrayToBinaryTree(maxLevelSumArray);
        int maxLevelSumResult = m.maxLevelSum(maxLevelSumArrayTreeNode);
        Assert.isTrue(2 == maxLevelSumResult, "算法错误");


        Integer[] searchBSTArray = {4, 2, 7, 1, 3};
        TreeNode searchBSTArrayTreeNode = m.arrayToBinaryTree(searchBSTArray);
        TreeNode searchBSTResult = m.searchBST(searchBSTArrayTreeNode, 2);
        Integer[] searchBSTResultArray = m.binaryTreeToArray(searchBSTResult);
        Integer[] searchBSTAssertResultArray = {2, 1, 3};
        Assert.isTrue(Arrays.equals(searchBSTResultArray, searchBSTAssertResultArray), "算法错误");
    }
}
