package com.gua.sf.leetcode;

import org.springframework.util.Assert;

import java.util.*;

public class Mianshi75_2 {

    /**
     * 1207. 独一无二的出现次数
     * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
     * <p>
     * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：arr = [1,2,2,1,1,3]
     * 输出：true
     * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
     * 示例 2：
     * <p>
     * 输入：arr = [1,2]
     * 输出：false
     */

    public boolean uniqueOccurrences(int[] arr) {
        /**
         0.使用HashMap记录元素的出现次数
         1.使用hashSet存储元素次数
         2.比较HashSet的length和元素次数的length
         3.相同说明没有重复元素，返回true;不相同返回false
         */
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            if (map.get(i) == null) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }
        for (Integer integer : map.values()) {
            set.add(integer);
        }

        return set.size() == map.values().size();

    }

    /**
     * 1657. 确定两个字符串是否接近
     * 如果可以使用以下操作从一个字符串得到另一个字符串，则认为两个字符串 接近 ：
     * <p>
     * 操作 1：交换任意两个 现有 字符。
     * 例如，abcde -> aecdb
     * 操作 2：将一个 现有 字符的每次出现转换为另一个 现有 字符，并对另一个字符执行相同的操作。
     * 例如，aacabb -> bbcbaa（所有 a 转化为 b ，而所有的 b 转换为 a ）
     * 你可以根据需要对任意一个字符串多次使用这两种操作。
     * <p>
     * 给你两个字符串，word1 和 word2 。如果 word1 和 word2 接近 ，就返回 true ；否则，返回 false 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：word1 = "abc", word2 = "bca"
     * 输出：true
     * 解释：2 次操作从 word1 获得 word2 。
     * 执行操作 1："abc" -> "acb"
     * 执行操作 1："acb" -> "bca"
     * 示例 2：
     * <p>
     * 输入：word1 = "a", word2 = "aa"
     * 输出：false
     * 解释：不管执行多少次操作，都无法从 word1 得到 word2 ，反之亦然。
     * 示例 3：
     * <p>
     * 输入：word1 = "cabbba", word2 = "abbccc"
     * 输出：true
     * 解释：3 次操作从 word1 获得 word2 。
     * 执行操作 1："cabbba" -> "caabbb"
     * 执行操作 2："caabbb" -> "baaccc"
     * 执行操作 2："baaccc" -> "abbccc"
     * 示例 4：
     * <p>
     * 输入：word1 = "cabbba", word2 = "aabbss"
     * 输出：false
     * 解释：不管执行多少次操作，都无法从 word1 得到 word2 ，反之亦然。
     */

    public boolean closeStrings(String word1, String word2) {

        /**
         * 分析
         * 1.如果2个字符串长度不同，那么不行
         * 2.如果字符串的数量数组不相等，不行
         * 3.如果2字符串的元素经过去重后排序，仍不相等，那么不行
         *
         * 算法
         * 0.比较2个字符串的大小
         * 1.用HashMap记录2个字符串的元素次数，排序后比较元素次数是否相同
         * 2.用HashSet去重,用Arrays排序,用Arrays比较,判断字符串去重排序后是否相等
         */
        if (word1.length() != word2.length()) {
            return false;
        }

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();

        fillMapAndSet(word1, map1, set1);
        fillMapAndSet(word2, map2, set2);

        Object[] count1 = map1.values().toArray();
        Object[] count2 = map2.values().toArray();
        Arrays.sort(count1);
        Arrays.sort(count2);
        if (!Arrays.equals(count1, count2)) {
            return false;
        }

        Object[] chars1 = set1.toArray();
        Object[] chars2 = set2.toArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        if (!Arrays.equals(chars1, chars2)) {
            return false;
        }
        return true;
    }

    private void fillMapAndSet(String word2, HashMap<Character, Integer> map2, HashSet<Character> set2) {
        for (int i = 0; i < word2.length(); i++) {
            char e = word2.charAt(i);
            set2.add(e);

            if (map2.get(e) == null) {
                map2.put(e, 1);
            } else {
                map2.put(e, map2.get(e) + 1);
            }
        }
    }

    /**
     * 2352. 相等行列对
     * 给你一个下标从 0 开始、大小为 n x n 的整数矩阵 grid ，返回满足 Ri 行和 Cj 列相等的行列对 (Ri, Cj) 的数目。
     * <p>
     * 如果行和列以相同的顺序包含相同的元素（即相等的数组），则认为二者是相等的。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：grid = [[3,2,1],[1,7,6],[2,7,7]]
     * 输出：1
     * 解释：存在一对相等行列对：
     * - (第 2 行，第 1 列)：[2,7,7]
     * 示例 2：
     * <p>
     * <p>
     * <p>
     * 输入：grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
     * 输出：3
     * 解释：存在三对相等行列对：
     * - (第 0 行，第 0 列)：[3,1,2,2]
     * - (第 2 行, 第 2 列)：[2,4,2,2]
     * - (第 3 行, 第 2 列)：[2,4,2,2]
     */

    public int equalPairs(int[][] grid) {
        /**
         * 1.遍历二维数组的行，转化为String存储在HashMap中,并且在转化为String时，间隔加上”,"。这样确保每个数字独立
         * 2.遍历二维数组的列，若HashMap中含有列，则行列相同数count+HashMap的key对应的次数value;
         * 3.返回count++
         */
        int count = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int[] ints : grid) {
            StringBuilder sb = new StringBuilder();
            for (int i : ints) {
                sb.append(i).append(",");
            }
            String s = sb.toString();
            if (map.get(s) == null) {
                map.put(s, 1);
            } else {
                map.put(s, map.get(s) + 1);
            }
        }
        int length = grid.length;
        for (int i = 0; i < length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < length; j++) {
                sb.append(grid[j][i]).append(",");
            }
            String o = sb.toString();
            if (map.keySet().contains(o)) {
                count += map.get(o);
            }
        }
        return count;
    }

    /**
     * 2390. 从字符串中移除星号
     * 给你一个包含若干星号 * 的字符串 s 。
     * <p>
     * 在一步操作中，你可以：
     * <p>
     * 选中 s 中的一个星号。
     * 移除星号 左侧 最近的那个 非星号 字符，并移除该星号自身。
     * 返回移除 所有 星号之后的字符串。
     * <p>
     * 注意：
     * <p>
     * 生成的输入保证总是可以执行题面中描述的操作。
     * 可以证明结果字符串是唯一的。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "leet**cod*e"
     * 输出："lecoe"
     * 解释：从左到右执行移除操作：
     * - 距离第 1 个星号最近的字符是 "leet**cod*e" 中的 't' ，s 变为 "lee*cod*e" 。
     * - 距离第 2 个星号最近的字符是 "lee*cod*e" 中的 'e' ，s 变为 "lecod*e" 。
     * - 距离第 3 个星号最近的字符是 "lecod*e" 中的 'd' ，s 变为 "lecoe" 。
     * 不存在其他星号，返回 "lecoe" 。
     * 示例 2：
     * <p>
     * 输入：s = "erase*****"
     * 输出：""
     * 解释：整个字符串都会被移除，所以返回空字符串。
     */

    public String removeStars(String s) {
        /**
         * 分析
         * 1.和四则运算算法类似，用栈这个数据结构可以简化算法
         * 2.把字符串分成当个字符逐次入栈，遇到*，则弹出一个字符，*就是消除
         * 3.返回栈中剩余的字符串
         * 算法
         * 1.初始化一个栈
         * 2.遍历字符串入栈，遇到*，弹栈
         * 3.栈中剩余的元素,遍历存入list,list反转（栈是倒序的），然后遍历组成字符串。返回字符串。
         */
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        if (stack.isEmpty()) {
            return "";
        }
        List<Character> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        Collections.reverse(list);
        StringBuilder sb = new StringBuilder();
        for (Character character : list) {
            sb.append(character);
        }
        return sb.toString();
    }

    /**
     * 649. Dota2 参议院
     * Dota2 的世界里有两个阵营：Radiant（天辉）和 Dire（夜魇）
     * <p>
     * Dota2 参议院由来自两派的参议员组成。现在参议院希望对一个 Dota2 游戏里的改变作出决定。他们以一个基于轮为过程的投票进行。在每一轮中，每一位参议员都可以行使两项权利中的 一 项：
     * <p>
     * 禁止一名参议员的权利：参议员可以让另一位参议员在这一轮和随后的几轮中丧失 所有的权利 。
     * 宣布胜利：如果参议员发现有权利投票的参议员都是 同一个阵营的 ，他可以宣布胜利并决定在游戏中的有关变化。
     * 给你一个字符串 senate 代表每个参议员的阵营。字母 'R' 和 'D'分别代表了 Radiant（天辉）和 Dire（夜魇）。然后，如果有 n 个参议员，给定字符串的大小将是 n。
     * <p>
     * 以轮为基础的过程从给定顺序的第一个参议员开始到最后一个参议员结束。这一过程将持续到投票结束。所有失去权利的参议员将在过程中被跳过。
     * <p>
     * 假设每一位参议员都足够聪明，会为自己的政党做出最好的策略，你需要预测哪一方最终会宣布胜利并在 Dota2 游戏中决定改变。输出应该是 "Radiant" 或 "Dire" 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：senate = "RD"
     * 输出："Radiant"
     * 解释：
     * 第 1 轮时，第一个参议员来自 Radiant 阵营，他可以使用第一项权利让第二个参议员失去所有权利。
     * 这一轮中，第二个参议员将会被跳过，因为他的权利被禁止了。
     * 第 2 轮时，第一个参议员可以宣布胜利，因为他是唯一一个有投票权的人。
     * 示例 2：
     * <p>
     * 输入：senate = "RDD"
     * 输出："Dire"
     * 解释：
     * 第 1 轮时，第一个来自 Radiant 阵营的参议员可以使用第一项权利禁止第二个参议员的权利。
     * 这一轮中，第二个来自 Dire 阵营的参议员会将被跳过，因为他的权利被禁止了。
     * 这一轮中，第三个来自 Dire 阵营的参议员可以使用他的第一项权利禁止第一个参议员的权利。
     * 因此在第二轮只剩下第三个参议员拥有投票的权利,于是他可以宣布胜利
     */
    public String predictPartyVictory(String senate) {
        /**
         * 分析
         * 1.行使禁止权力，淘汰对方参议员
         * 2.贪心+队列
         * 3.贪心：优先淘汰对方还没有行使权力的参议员
         * 4.队列：用队列存储两方参议员的投票顺序。投完票后下一轮的顺序为当前顺序+字符串的长度.
         * 5.最后判断队列哪个队列不为空，即为胜利方
         */
        Queue<Integer> rIndexQueue = new LinkedList<>();
        Queue<Integer> dIndexQueue = new LinkedList<>();
        int length = senate.length();
        for (int i = 0; i < length; i++) {
            if (senate.charAt(i) == 'R') {
                rIndexQueue.offer(i);
            } else {
                dIndexQueue.offer(i);
            }
        }
        while (!rIndexQueue.isEmpty() && !dIndexQueue.isEmpty()) {
            Integer rIndex = rIndexQueue.poll();
            Integer dIndex = dIndexQueue.poll();
            if (rIndex < dIndex) {
                rIndexQueue.offer(rIndex + length);
            } else {
                dIndexQueue.offer(dIndex + length);
            }
        }
        if (!rIndexQueue.isEmpty()) {
            return "Radiant";
        } else {
            return "Dire";
        }
    }

    /**
     * 735. 行星碰撞
     * 给定一个整数数组 asteroids，表示在同一行的行星。
     * <p>
     * 对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。
     * <p>
     * 找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：asteroids = [5,10,-5]
     * 输出：[5,10]
     * 解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。
     * 示例 2：
     * <p>
     * 输入：asteroids = [8,-8]
     * 输出：[]
     * 解释：8 和 -8 碰撞后，两者都发生爆炸。
     * 示例 3：
     * <p>
     * 输入：asteroids = [10,2,-5]
     * 输出：[10]
     * 解释：2 和 -5 发生碰撞后剩下 -5 。10 和 -5 发生碰撞后剩下 10 。
     */

    public int[] asteroidCollision(int[] asteroids) {
        /**
         * 1用栈作为数据结构
         * 2.每个元素入栈时，先判断栈是否为空，为空，直接入栈。
         *   不为空，判断正负值，
         *      同为正负，不会相撞，入栈；
         *      一正一负，当前元素为正，栈元素为负，不会相撞，入栈
         *              当前元素为负，栈元素为正，判断大小
         *                                   如果大小相同，相撞都保证，弹栈比较下一个元素
         *                                   如果小的是当前元素，当前元素消失，比较下一个元素
         *                                   如果小的是栈里面的元素，继续弹出下一个进行比较。
         */
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            int asteroid = asteroids[i];
            while (true) {
                if (stack.isEmpty()) {
                    stack.push(asteroid);
                    break;
                } else {
                    Integer before = stack.peek();
                    if ((before > 0 && asteroid > 0) || (before < 0 && asteroid < 0) || (before < 0 && asteroid > 0)) {
                        stack.push(asteroid);
                        break;
                    } else {
                        int result = asteroid + before;
                        if (result == 0) {
                            stack.pop();
                            break;
                        }
                        if (asteroid < 0 && result < 0) {
                            stack.pop();
                            continue;
                        }
                        if (asteroid < 0 && result > 0) {
                            break;
                        }
                    }

                }
            }
        }
        int size = stack.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[size - 1 - i] = stack.pop();
        }
        return result;
    }


    /**
     * 394. 字符串解码
     * 给定一个经过编码的字符串，返回它解码后的字符串。
     * <p>
     * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
     * <p>
     * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
     * <p>
     * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "3[a]2[bc]"
     * 输出："aaabcbc"
     * 示例 2：
     * <p>
     * 输入：s = "3[a2[c]]"
     * 输出："accaccacc"
     * 示例 3：
     * <p>
     * 输入：s = "2[abc]3[cd]ef"
     * 输出："abcabccdcdcdef"
     * 示例 4：
     * <p>
     * 输入：s = "abc3[cd]xyz"
     * 输出："abccdcdcdxyz"
     */

    public String decodeString(String s) {
        /**
         * 1.用栈来存储字符串遍历出来的字符
         * 2.判断正中括号和反中括号
         * 3.用一个变量存储K
         * 4.用一个遍历存储子字符串
         * 5.把解码出来的子字符串入栈
         * 6.最后出栈，倒序，返回解码后的字符产
         */
        Stack<Character> stack = new Stack<>();
        char left = '[';
        char right = ']';
        List<Character> mathList = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            if (now != right) {
                stack.push(now);
            } else {

                // 获取子字符串
                StringBuilder reverseSubString = new StringBuilder();
                while (true) {
                    Character charSon = stack.pop();
                    if (charSon == left) {
                        break;
                    }
                    reverseSubString.append(charSon);
                }
                // 倒序，按照正序入栈
                StringBuilder subString = reverseSubString.reverse();

                // 获取k
                StringBuilder kString = new StringBuilder();
                while (!stack.isEmpty()) {
                    Character kSon = stack.peek();
                    if (!mathList.contains(kSon)) {
                        break;
                    }
                    kString.append(stack.pop());
                }
                Integer k = Integer.valueOf(kString.reverse().toString());

                // 获取解码后的子字符产
                StringBuilder son = new StringBuilder();
                for (int j = 0; j < k; j++) {
                    son.append(subString);
                }
                String sonStr = son.toString();

                // 把解码后的子字符产入栈
                for (int j = 0; j < sonStr.length(); j++) {
                    stack.push(sonStr.charAt(j));
                }

            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.reverse().toString();

    }

    /**
     933. 最近的请求次数
     写一个 RecentCounter 类来计算特定时间范围内最近的请求。

     请你实现 RecentCounter 类：

     RecentCounter() 初始化计数器，请求数为 0 。
     int ping(int t) 在时间 t 添加一个新请求，其中 t 表示以毫秒为单位的某个时间，并返回过去 3000 毫秒内发生的所有请求数（包括新请求）。确切地说，返回在 [t-3000, t] 内发生的请求数。
     保证 每次对 ping 的调用都使用比之前更大的 t 值。



     示例 1：

     输入：
     ["RecentCounter", "ping", "ping", "ping", "ping"]
     [[], [1], [100], [3001], [3002]]
     输出：
     [null, 1, 2, 3, 3]

     解释：
     RecentCounter recentCounter = new RecentCounter();
     recentCounter.ping(1);     // requests = [1]，范围是 [-2999,1]，返回 1
     recentCounter.ping(100);   // requests = [1, 100]，范围是 [-2900,100]，返回 2
     recentCounter.ping(3001);  // requests = [1, 100, 3001]，范围是 [1,3001]，返回 3
     recentCounter.ping(3002);  // requests = [1, 100, 3001, 3002]，范围是 [2,3002]，返回 3
     */


    /**
     * 分析
     * 1.用队列存储请求时间
     * 2.调用时，把时间放入队列
     * 3.然后计算开发时间，t-3000
     * 4.把队列中时间<t-3000的=请求时间出队列，返回队列的长度
     */
    private final Queue<Integer> pingTimeQueue = new LinkedList<>();

    public int ping(int t) {
        pingTimeQueue.offer(t);

        int begin = t - 3000;

        while (true) {
            Integer time = pingTimeQueue.peek();
            if (time < begin) {
                pingTimeQueue.poll();
            } else {
                break;
            }
        }
        return pingTimeQueue.size();
    }

    /**
     * 2095. 删除链表的中间节点
     * 给你一个链表的头节点 head 。删除 链表的 中间节点 ，并返回修改后的链表的头节点 head 。
     * <p>
     * 长度为 n 链表的中间节点是从头数起第 ⌊n / 2⌋ 个节点（下标从 0 开始），其中 ⌊x⌋ 表示小于或等于 x 的最大整数。
     * <p>
     * 对于 n = 1、2、3、4 和 5 的情况，中间节点的下标分别是 0、1、1、2 和 2 。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：head = [1,3,4,7,1,2,6]
     * 输出：[1,3,4,1,2,6]
     * 解释：
     * 上图表示给出的链表。节点的下标分别标注在每个节点的下方。
     * 由于 n = 7 ，值为 7 的节点 3 是中间节点，用红色标注。
     * 返回结果为移除节点后的新链表。
     * 示例 2：
     * <p>
     * <p>
     * <p>
     * 输入：head = [1,2,3,4]
     * 输出：[1,2,4]
     * 解释：
     * 上图表示给出的链表。
     * 对于 n = 4 ，值为 3 的节点 2 是中间节点，用红色标注。
     * 示例 3：
     * <p>
     * <p>
     * <p>
     * 输入：head = [2,1]
     * 输出：[2]
     * 解释：
     * 上图表示给出的链表。
     * 对于 n = 2 ，值为 1 的节点 1 是中间节点，用红色标注。
     * 值为 2 的节点 0 是移除节点 1 后剩下的唯一一个节点。
     */


    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode deleteMiddle(ListNode head) {
        /**
         * 一个链表
         * 1.先计算链表的长度
         * 2.然后根据链表长度计算中间节点的位置
         * 3.删除中间节点(把中间节点的前后节点连接起来，剔除中间节点);如果链表长度为1，则head为null；如果链表长度大于1，则next为null;
         * 则next为中间节点的下一个节点
         */
        int len = 1;
        ListNode next = head.next;
        while (true) {
            if (next != null) {
                len++;
            } else {
                break;
            }
            next = next.next;
        }
        int middle = len / 2;
        if (len == 1) {
            return null;
        }
        ListNode before = head;
        for (int i = 0; i < middle; i++) {
            if (i == middle - 1) {
                ListNode after = before.next.next;
                before.next = after;
                return head;
            }
            before = before.next;
        }

        return head;
    }


    /**
     * 328. 奇偶链表
     * 给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
     * <p>
     * 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。
     * <p>
     * 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
     * <p>
     * 你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * <p>
     * <p>
     * 输入: head = [1,2,3,4,5]
     * 输出: [1,3,5,2,4]
     * 示例 2:
     * <p>
     * <p>
     * <p>
     * 输入: head = [2,1,3,5,6,4,7]
     * 输出: [2,3,6,7,1,5,4]
     */

    public ListNode oddEvenList(ListNode head) {
        /**
         * 分析
         * 1遍历链表，用j对象指向第一个元素，用o对象指向第二个元素;用oHead指向第二个元素,用来标记偶数链表的头部
         * 2.j的下一个元素指向o的下一个元素。o的下一个元素指向l的下一个元素
         * 3.最后，把奇数链表的尾部指向偶数链表的头部。
         *
         * 分析：如何遍历一个链表
         * 用一个链表对象L指向链表头节点，然后L=L.next。直到L.next == null;
         *
         *
         */
        if (head == null) {
            return null;
        }

        ListNode jNode = head;
        ListNode oNode = head.next;
        ListNode oHead = oNode;

        while (true) {
            if (oNode == null || oNode.next == null) {
                break;
            }

            jNode.next = oNode.next;
            jNode = jNode.next;

            oNode.next = jNode.next;
            oNode = oNode.next;

        }
        jNode.next = oHead;
        return head;
    }

    public static void main(String[] args) {
        Mianshi75_2 m = new Mianshi75_2();
        boolean b = m.uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3});
        Assert.isTrue(b, "每个数的出现次数不是独一无二的");


        boolean b1 = m.closeStrings("abbzzca", "babzzcz");
        Assert.isTrue(!b1, "两个字符串接近");

        int i = m.equalPairs(new int[][]{{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}});
        Assert.isTrue(i == 3, "算法错误");

        String removeStars = m.removeStars("leet**cod*e");

        Assert.isTrue("lecoe".equals(removeStars), "算法错误");

        String predictPartyVictory = m.predictPartyVictory("RDD");
        Assert.isTrue("Dire".equals(predictPartyVictory), "算法错误");


        int[] asteroidCollision = m.asteroidCollision(new int[]{5, 10, -5});
        Assert.isTrue(Arrays.equals(new int[]{5, 10}, asteroidCollision), "算法错误");

        Assert.isTrue("accaccacc".equals(m.decodeString("3[a2[c]]")), "算法错误");

        int[] pingArray = new int[]{1, 100, 3001, 3002};
        int[] pingResultArray = new int[pingArray.length];
        for (int j = 0; j < pingArray.length; j++) {
            pingResultArray[j] = m.ping(pingArray[j]);
        }
        Assert.isTrue(Arrays.equals(new int[]{1, 2, 3, 3}, pingResultArray), "算法错误");


        int[] nodeArray = {2, 1, 3};
        ListNode head = fillListNode(nodeArray);
        ListNode listNode = m.deleteMiddle(head);
        int length = nodeArray.length;
        int[] result = getIntArrayFromListNode(listNode, length - 1);
        Assert.isTrue(Arrays.equals(new int[]{2, 3}, result), "算法错误");


        int[] oddEvenListArray = {1, 2, 3, 4, 5};
        ListNode oddEvenList = m.oddEvenList(fillListNode(oddEvenListArray));
        int[] intArrayFromListNode = getIntArrayFromListNode(oddEvenList, oddEvenListArray.length);
        Assert.isTrue(Arrays.equals(new int[]{1, 3, 5, 2, 4}, intArrayFromListNode), "算法错误");
    }

    /**
     * 把链表转化为数组
     *
     * @param listNode
     * @param length
     * @return
     */
    private static int[] getIntArrayFromListNode(ListNode listNode, int length) {
        int[] result = new int[length];
        for (int j = 0; j < length; j++) {
            result[j] = listNode.val;
            listNode = listNode.next;
        }
        return result;
    }

    /**
     * 填充链表
     *
     * @param nodeArray
     * @return
     */
    private static ListNode fillListNode(int[] nodeArray) {
        ListNode head = new ListNode(nodeArray[0], null);
        ListNode before = head;
        for (int j = 0; j < nodeArray.length; j++) {
            if (j + 1 + 1 > nodeArray.length) {
                break;
            } else {
                ListNode after = new ListNode(nodeArray[j + 1], null);
                before.next = after;
            }
            before = before.next;
        }
        return head;
    }
}
