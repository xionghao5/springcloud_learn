package com.gua.sf.leetcode;

import java.util.*;

public class Mianshi75 {

    /**
     * 给你两个字符串 word1 和 word2 。请你从 word1 开始，通过交替添加字母来合并字符串。如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。
     *
     * @param word1
     * @param word2
     * @return
     */

    public String mergeAlternately(String word1, String word2) {

        int length;
        String end;
        if (word1.length() > word2.length()) {
            length = word2.length();
            end = word1.substring(length);
        } else if (word1.length() == word2.length()) {
            length = word1.length();
            end = "";
        } else {
            length = word1.length();
            end = word2.substring(length);
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < length; i++) {
            str.append(word1.charAt(i) + "" + word2.charAt(i));
        }
        str.append(end);

        return str.toString();
    }


    /**
     * 1071. 字符串的最大公因子
     * 对于字符串 s 和 t，只有在 s = t + ... + t（t 自身连接 1 次或多次）时，我们才认定 “t 能除尽 s”。
     * <p>
     * 给定两个字符串 str1 和 str2 。返回 最长字符串 x，要求满足 x 能除尽 str1 且 X 能除尽 str2 。
     *
     * @param str1
     * @param str2
     * @return
     */
    public String gcdOfStrings(String str1, String str2) {
        // 假设str1是N个x，str2是M个x，那么str1+str2肯定是等于str2+str1的。
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        // 辗转相除法求gcd。
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    public int gcd(int a, int b) {
        int remainder = a % b;
        while (remainder != 0) {
            a = b;
            b = remainder;
            remainder = a % b;
        }
        return b;
    }

    /**
     * 1431. 拥有最多糖果的孩子
     * 给你一个数组 candies 和一个整数 extraCandies ，其中 candies[i] 代表第 i 个孩子拥有的糖果数目。
     * <p>
     * 对每一个孩子，检查是否存在一种方案，将额外的 extraCandies 个糖果分配给孩子们之后，此孩子有 最多 的糖果。注意，允许有多个孩子同时拥有 最多 的糖果数目。
     * <p>
     * <p>
     * 示例1
     * <p>
     * 输入：candies = [2,3,5,1,3], extraCandies = 3
     * 输出：[true,true,true,false,true]
     * 解释：
     * 孩子 1 有 2 个糖果，如果他得到所有额外的糖果（3个），那么他总共有 5 个糖果，他将成为拥有最多糖果的孩子。
     * 孩子 2 有 3 个糖果，如果他得到至少 2 个额外糖果，那么他将成为拥有最多糖果的孩子。
     * 孩子 3 有 5 个糖果，他已经是拥有最多糖果的孩子。
     * 孩子 4 有 1 个糖果，即使他得到所有额外的糖果，他也只有 4 个糖果，无法成为拥有糖果最多的孩子。
     * 孩子 5 有 3 个糖果，如果他得到至少 2 个额外糖果，那么他将成为拥有最多糖果的孩子。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/kids-with-the-greatest-number-of-candies
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // 1.求出数组最大值
        // 2.遍历数组,判断每个值+额外糖果数>=数组最大值
        int max = 0;
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] > max) {
                max = candies[i];
            }
        }
        List<Boolean> kidsWithCandies = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            kidsWithCandies.add(candies[i] + extraCandies >= max);
        }
        return kidsWithCandies;
    }

    /**
     * 605. 种花问题
     * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
     * <p>
     * 给你一个整数数组 flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：flowerbed = [1,0,0,0,1], n = 1
     * 输出：true
     * 示例 2：
     * <p>
     * 输入：flowerbed = [1,0,0,0,1], n = 2
     * 输出：false
     */

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        /**
         * 遍历数组，
         * 仅a(i-1)=0,a(i)=0,a(i+1)=0时，可种花数量+1
         * 然后把a(i)=1，继续遍历
         *
         * [0,0,0,0,0]
         *
         * [1,0,0,0,1]
         *
         * [1,0,0,1,0,0,1]
         *
         * [1,0,1,0,1,0,1]
         */

        int number = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            int locate = flowerbed[i];
            if (locate == 1) {
                continue;
            }
            int before = i == 0 ? 0 : flowerbed[i - 1];
            int after = i == flowerbed.length - 1 ? 0 : flowerbed[i + 1];

            if (before == 0 && after == 0 && locate == 0) {
                flowerbed[i] = 1;
                number++;
            }
        }
        return number >= n;
    }

    /**
     * 345. 反转字符串中的元音字母
     * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
     * <p>
     * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次。
     */

    static char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};
    static Set<Character> set = new HashSet<>();

    static {
        for (char c : vowels) {
            set.add(c);
            set.add(Character.toUpperCase(c));
        }
    }

    /**
     * 1.存储元音字符大小写数组
     * 2.双指针相对逼近遍历。将元音字符交换位置
     *
     * @param s
     * @return
     */
    public String reverseVowels(String s) {
        char[] cs = s.toCharArray();
        int n = s.length();
        int l = 0, r = n - 1;
        while (l < r) {
            if (set.contains(cs[l]) && set.contains(cs[r])) {
                swap(cs, l, r);
                l++;
                r--;
            } else {
                if (!set.contains(cs[l])) {
                    l++;
                }
                if (!set.contains(cs[r])) {
                    r--;
                }
            }
        }
        return String.valueOf(cs);
    }

    void swap(char[] cs, int l, int r) {
        char c = cs[l];
        cs[l] = cs[r];
        cs[r] = c;
    }

    /**
     * 151. 反转字符串中的单词
     * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
     * <p>
     * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
     * <p>
     * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
     * <p>
     * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
     * <p>
     * 示例 1：
     * 输入：s = "the sky is blue"
     * 输出："blue is sky the"
     * <p>
     * 示例 2：
     * 输入：s = "  hello world  "
     * 输出："world hello"
     * 解释：反转后的字符串中不能存在前导空格和尾随空格。
     * <p>
     * 示例 3：
     * 输入：s = "a good  example"
     * 输出："example good a"
     * 解释：如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。
     */

    public String reverseWords(String s) {

        /**
         * 1.把字符串进行处理,分解成单词数组
         * 2.遍历数组，交换位置
         * 3.把数组按照一个空格间隔组成字符串
         */

        // 如果字符串中包含多个连续空格或者开头结尾有空格，可以使用正则表达式"\s+"作为分隔符来处理
        String[] sp = s.trim().split("\\s+");
        for (int i = 0; i < (sp.length / 2); i++) {
            String temp;
            temp = sp[i];
            sp[i] = sp[sp.length - 1 - i];
            sp[sp.length - 1 - i] = temp;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sp.length; i++) {
            if (i < sp.length - 1) {
                sb.append(sp[i] + " ");
            } else {
                sb.append(sp[i]);
            }
        }
        return sb.toString();
    }

    /**
     * 238. 除自身以外数组的乘积
     * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
     * <p>
     * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
     * <p>
     * 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
     */

    public int[] productExceptSelf(int[] nums) {
        /**
         * 新数组的元素=老元素的前缀乘积*老元素的后缀乘积
         * 1.求出老数组的前缀乘积数组
         * 2.求出老数组的后缀乘积数组
         * 3.前缀乘积*后缀乘积=新 数组
         */
        int length = nums.length;
        int[] left = new int[length];
        int[] right = new int[length];
        int[] answer = new int[length];
        left[0] = 1;
        for (int i = 1; i < length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        right[length - 1] = 1;
        for (int i = length - 2; i > -1; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < length; i++) {
            answer[i] = left[i] * right[i];
        }

        return answer;
    }

    /**
     * 334. 递增的三元子序列
     * 给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
     * <p>
     * 如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,3,4,5]
     * 输出：true
     * 解释：任何 i < j < k 的三元组都满足题意
     * 示例 2：
     * <p>
     * 输入：nums = [5,4,3,2,1]
     * 输出：false
     * 解释：不存在满足题意的三元组
     * 示例 3：
     * <p>
     * 输入：nums = [2,1,5,0,4,6]
     * 输出：true
     * 解释：三元组 (3, 4, 5) 满足题意，因为 nums[3] == 0 < nums[4] == 4 < nums[5] == 6
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 5 * 105
     * -231 <= nums[i] <= 231 - 1
     * <p>
     * <p>
     * 进阶：你能实现时间复杂度为 O(n) ，空间复杂度为 O(1) 的解决方案吗？
     */

    public boolean increasingTriplet(int[] nums) {
        /**
         * 贪心算法
         */
        if (nums.length < 3) {
            return false;
        }
        int first = nums[0];
        int second = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int three = nums[i];
            if (three > second) {
                return true;
            } else if (three > first) {
                second = three;
            } else {
                first = three;
            }

        }
        return false;
    }

    /**
     * 443. 压缩字符串
     * 给你一个字符数组 chars ，请使用下述算法压缩：
     * <p>
     * 从一个空字符串 s 开始。对于 chars 中的每组 连续重复字符 ：
     * <p>
     * 如果这一组长度为 1 ，则将字符追加到 s 中。
     * 否则，需要向 s 追加字符，后跟这一组的长度。
     * 压缩后得到的字符串 s 不应该直接返回 ，需要转储到字符数组 chars 中。需要注意的是，如果组长度为 10 或 10 以上，则在 chars 数组中会被拆分为多个字符。
     * <p>
     * 请在 修改完输入数组后 ，返回该数组的新长度。
     * <p>
     * 你必须设计并实现一个只使用常量额外空间的算法来解决此问题。
     */

    public int compress(char[] chars) {
        int n = chars.length;
        int write = 0, left = 0;
        for (int read = 0; read < n; read++) {
            if (read == n - 1 || chars[read] != chars[read + 1]) {
                chars[write++] = chars[read];
                int num = read - left + 1;
                if (num > 1) {
                    int anchor = write;
                    while (num > 0) {
                        chars[write++] = (char) (num % 10 + '0');
                        num /= 10;
                    }
                    reverse(chars, anchor, write - 1);
                }
                left = read + 1;
            }
        }
        return write;
    }

    public void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }

    /**
     * 283. 移动零
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * <p>
     * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 示例 2:
     * <p>
     * 输入: nums = [0]
     * 输出: [0]
     */
    public void moveZeroes(int[] nums) {

        /**
         * 1.参考冒泡排序，把0向后移动
         * 2.如果当前元素是0，并且后一个元素不是0，就前后交换位置
         * 3.如果当前是0，后面也是0，不动
         */
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (nums[j] == 0 && nums[j + 1] != 0) {
                    int temp;
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

    }

    public void moveZeroes2(int[] nums) {

        /**
         * 双指针
         * 1.一个指针负责遍历
         * 2.另外一个指针负责记录安排非零元素和数量
         * 3.把非零元素移动到前面
         * 4.把非零位置处后面的元素全部赋值为0.
         */

        int len = nums.length;
        int j = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
        for (int i = j; i < len; i++) {
            nums[i] = 0;
        }

    }

    /**
     * 392. 判断子序列
     * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
     * <p>
     * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
     * <p>
     * 进阶：
     * <p>
     * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
     * <p>
     * 致谢：
     * <p>
     * 特别感谢 @pbrother 添加此问题并且创建所有测试用例。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "abc", t = "ahbgdc"
     * 输出：true
     * 示例 2：
     * <p>
     * 输入：s = "axc", t = "ahbgdc"
     * 输出：false
     */
    public boolean isSubsequence(String s, String t) {
        /**
         * 1使用双指针
         * 2.一个指针i遍历子串
         * 3.一个指针j遍历母串
         * 4.字符相同，则i++,j++,字符不相同，则j++,并继续比较
         * 5.遍历完子串，如果i=字串的长度，则成功；否则，失败
         */
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int i = 0;
        int j = 0;
        while (i < sc.length && j < tc.length) {

            if (sc[i] == tc[j]) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        if (i == sc.length) {
            return true;
        } else {
            return false;
        }


    }

    /**
     * 11. 盛最多水的容器
     * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
     * <p>
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * <p>
     * 返回容器可以储存的最大水量。
     * <p>
     * 说明：你不能倾斜容器。
     * <p>
     * 输入：[1,8,6,2,5,4,8,3,7]
     * 输出：49
     * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
     * 示例 2：
     * <p>
     * 输入：height = [1,1]
     * 输出：1
     */

    public int maxArea2(int[] height) {
        /**
         * 双指针遍历
         * 1.一个指针记录当前位置
         * 2.另一个指针向后遍历
         * 3.计算面积（j-i）*h(min)，最后获取最大值
         *
         */

        int len = height.length;
        int maxArea = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int area;
                int heightMin = height[i] < height[j] ? height[i] : height[j];
                area = (j - i) * heightMin;
                maxArea = maxArea > area ? maxArea : area;
            }
        }
        return maxArea;

    }

    public int maxArea(int[] height) {
        /**
         * 双指针，双向移动
         * 时间复杂度O(n);空间复杂度O(1)
         * 1.双指针分别指向开头和结尾，计算面积。
         * 2.比较开头和结尾的指针处的高度，高度小的向中间移动
         * 3.最后返回面积最大值
         */
        int i = 0;
        int j = height.length - 1;
        int maxArea = 0;
        while (i < j) {
            int minHeight = height[i] < height[j] ? height[i] : height[j];
            int area = minHeight * (j - i);
            maxArea = maxArea > area ? maxArea : area;
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }

    /**
     * 1679. K 和数对的最大数目
     * 给你一个整数数组 nums 和一个整数 k 。
     * <p>
     * 每一步操作中，你需要从数组中选出和为 k 的两个整数，并将它们移出数组。
     * <p>
     * 返回你可以对数组执行的最大操作数。
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,3,4], k = 5
     * 输出：2
     * 解释：开始时 nums = [1,2,3,4]：
     * - 移出 1 和 4 ，之后 nums = [2,3]
     * - 移出 2 和 3 ，之后 nums = []
     * 不再有和为 5 的数对，因此最多执行 2 次操作。
     * 示例 2：
     * <p>
     * 输入：nums = [3,1,3,4,3], k = 6
     * 输出：1
     * 解释：开始时 nums = [3,1,3,4,3]：
     * - 移出前两个 3 ，之后nums = [1,4,3]
     * 不再有和为 6 的数对，因此最多执行 1 次操作。
     */

    public int maxOperations(int[] nums, int k) {

        /**
         * 先排序，然后双指针相向移动
         * 0.先排序
         * 1.指针分别指向开头和结尾
         * 2.如果和为k,两个指针都加1，操作数加1
         * 3.如果和>k,则右边大了，右指针向中间移动；如果和<k，则左边小了，左边指针向中间移动
         * 4.返回操作数
         */
        Arrays.sort(nums);
        int deal = 0;
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == k) {
                i++;
                j--;
                deal++;
            } else if (sum > k) {
                j--;
            } else {
                i++;
            }
        }
        return deal;
    }

    /**
     * 643. 子数组最大平均数 I
     * 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
     * <p>
     * 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
     * <p>
     * 任何误差小于 10-5 的答案都将被视为正确答案。
     * <p>
     * 输入：nums = [1,12,-5,-6,50,3], k = 4
     * 输出：12.75
     * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
     * 示例 2：
     * <p>
     * 输入：nums = [5], k = 1
     * 输出：5.00000
     */
    public double findMaxAverage(int[] nums, int k) {
        /**
         * 1.先求最开始的k个数字和sum1
         * 2.然后下一个和就用sum1-第一个元素+当前元素
         * 3.用maxSum记录最大值
         * 4.计算最大平均值并返回
         */
        double maxAv;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int i = 1; i < nums.length - k + 1; i++) {
            sum = sum - nums[i - 1] + nums[i + k - 1];
            maxSum = maxSum > sum ? maxSum : sum;
        }

        maxAv = (1.0 * maxSum) / k;
        return maxAv;
    }

    /**
     * 给你字符串 s 和整数 k 。
     * <p>
     * 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
     * <p>
     * 英文中的 元音字母 为（a, e, i, o, u）。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "abciiidef", k = 3
     * 输出：3
     * 解释：子字符串 "iii" 包含 3 个元音字母。
     * 示例 2：
     * <p>
     * 输入：s = "aeiou", k = 2
     * 输出：2
     * 解释：任意长度为 2 的子字符串都包含 2 个元音字母。
     */
    public int maxVowels(String s, int k) {

        /**
         * 1.采用滑动窗口的算法
         * 2.先计算最开始的k个元素中的元音字符个数
         * 3.开始从第二个开始遍历，判断第一个是否是元音，判断最后一个是否是元音，计算元音个数
         * 4.返回最大元音字符个数
         */
        int yuanSum = 0;
        for (int i = 0; i < k; i++) {
            if (isYuanYin(s.charAt(i))) {
                yuanSum++;
            }
        }
        int maxYuanSum = yuanSum;
        for (int i = 1; i < s.length() - k + 1; i++) {

            if (isYuanYin(s.charAt(i - 1))) {
                yuanSum--;
            }
            if (isYuanYin(s.charAt(i + k - 1))) {
                yuanSum++;
            }
            maxYuanSum = maxYuanSum > yuanSum ? maxYuanSum : yuanSum;

        }
        return maxYuanSum;
    }

    public boolean isYuanYin(char c) {
        return 'a' == c || 'e' == c || 'i' == c || 'o' == c || 'u' == c;
    }

    /**
     * 1004. 最大连续1的个数 III
     * 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
     * 输出：6
     * 解释：[1,1,1,0,0,1,1,1,1,1,1]
     * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
     * 示例 2：
     * <p>
     * 输入：nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
     * 输出：10
     * 解释：[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
     * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
     */

    public int longestOnes(int[] nums, int k) {
        /**
         * 1.滑动窗口
         * 2.左指针记录左边界，右指针记录右边界，左右指针初始指向0，
         * 3.右指针主动向右移动，左指针被动向右移动；
         * 4.用变量zeros记录0的数量，用maxSum记录最大的1的数量。
         * 5.如果右指针指到0，则zeros++;如果zeros>k,则左指针向右移动，左指针指到0，zeros--
         * 6.最后返回maxSum
         */

        int maxSum = 0;
        int zeros = 0;
        int left = 0;
        int right = 0;
        int sum = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                zeros++;
            }
            while (zeros > k) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }
            sum = right - left + 1;
            maxSum = maxSum > sum ? maxSum : sum;
            right++;
        }
        return maxSum;

    }

    /**
     * 1493. 删掉一个元素以后全为 1 的最长子数组
     * 给你一个二进制数组 nums ，你需要从中删掉一个元素。
     * <p>
     * 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
     * <p>
     * 如果不存在这样的子数组，请返回 0 。
     * <p>
     * <p>
     * <p>
     * 提示 1：
     * <p>
     * 输入：nums = [1,1,0,1]
     * 输出：3
     * 解释：删掉位置 2 的数后，[1,1,1] 包含 3 个 1 。
     * 示例 2：
     * <p>
     * 输入：nums = [0,1,1,1,0,1,1,0,1]
     * 输出：5
     * 解释：删掉位置 4 的数字后，[0,1,1,1,1,1,0,1] 的最长全 1 子数组为 [1,1,1,1,1] 。
     * 示例 3：
     * <p>
     * 输入：nums = [1,1,1]
     * 输出：2
     * 解释：你必须要删除一个元素。
     */
    public int longestSubarray(int[] nums) {
        /**
         * 1.双指针，滑动窗口
         * 2.左指针记录左边界，右指针记录右边界，左右指针初始指向0，
         * 3.右指针主动向右移动，左指针被动向右移动；
         * 4.用变量zeros记录0的数量，用maxSum记录最大的1的数量。
         * 5.如果右指针指到0，则zeros++;如果zeros>1,则左指针向右移动，左指针指到0，zeros--
         * 6.最后返回maxSum，maxSum = (right-left+1)-1
         */
        int sum = 0;
        int maxSum = 0;
        int zeros = 0;
        int right = 0;
        int left = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                zeros++;
            }
            while (zeros > 1) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }
            sum = (right - left + 1) - 1;
            maxSum = maxSum > sum ? maxSum : sum;

            right++;
        }
        return maxSum;
    }

    /**
     * 1732. 找到最高海拔
     * 有一个自行车手打算进行一场公路骑行，这条路线总共由 n + 1 个不同海拔的点组成。自行车手从海拔为 0 的点 0 开始骑行。
     * <p>
     * 给你一个长度为 n 的整数数组 gain ，其中 gain[i] 是点 i 和点 i + 1 的 净海拔高度差（0 <= i < n）。请你返回 最高点的海拔 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：gain = [-5,1,5,0,-7]
     * 输出：1
     * 解释：海拔高度依次为 [0,-5,-4,1,1,-6] 。最高海拔为 1 。
     * 示例 2：
     * <p>
     * 输入：gain = [-4,-3,-2,-1,4,3,2]
     * 输出：0
     * 解释：海拔高度依次为 [0,-4,-7,-9,-10,-6,-3,-1] 。最高海拔为 0 。
     */
    public int largestAltitude(int[] gain) {
        /**
         * 1.遍历求最值
         * 2.第一个海拔a[0]=0，当前海拔a[i]=a[i-1]+gain[i]
         * 3.返回max
         */
        int max = 0;
        int nowHb = 0;
        for (int i = 0; i < gain.length; i++) {
            nowHb = gain[i] + nowHb;
            max = max > nowHb ? max : nowHb;
        }
        return max;
    }

    /**
     * 给你一个整数数组 nums ，请计算数组的 中心下标 。
     * <p>
     * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
     * <p>
     * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
     * <p>
     * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1, 7, 3, 6, 5, 6]
     * 输出：3
     * 解释：
     * 中心下标是 3 。
     * 左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
     * 右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。
     * 示例 2：
     * <p>
     * 输入：nums = [1, 2, 3]
     * 输出：-1
     * 解释：
     * 数组中不存在满足此条件的中心下标。
     * 示例 3：
     * <p>
     * 输入：nums = [2, 1, -1]
     * 输出：0
     * 解释：
     * 中心下标是 0 。
     * 左侧数之和 sum = 0 ，（下标 0 左侧不存在元素），
     * 右侧数之和 sum = nums[1] + nums[2] = 1 + -1 = 0 。
     */

    public int pivotIndex(int[] nums) {

        /**
         * 1.计算左边和和右边和，当左边和=右边和时，返回当前下表
         * 2.当i=0时，leftSum=0,rigth = nums[1]+...+nums[n]
         * 3.遍历，向右移动
         */
        int l = -1;
        int leftSum = 0;
        int rightSum = 0;
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            rightSum += nums[i];
        }
        if (leftSum == rightSum) {
            l = 0;
            return l;
        }
        for (int i = 1; i < nums.length; i++) {
            leftSum += nums[i - 1];
            rightSum -= nums[i];
            if (leftSum == rightSum) {
                l = i;
                break;
            }
        }
        return l;
    }

    /**
     * 2215. 找出两数组的不同
     * 给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，请你返回一个长度为 2 的列表 answer ，其中：
     * <p>
     * answer[0] 是 nums1 中所有 不 存在于 nums2 中的 不同 整数组成的列表。
     * answer[1] 是 nums2 中所有 不 存在于 nums1 中的 不同 整数组成的列表。
     * 注意：列表中的整数可以按 任意 顺序返回。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums1 = [1,2,3], nums2 = [2,4,6]
     * 输出：[[1,3],[4,6]]
     * 解释：
     * 对于 nums1 ，nums1[1] = 2 出现在 nums2 中下标 0 处，然而 nums1[0] = 1 和 nums1[2] = 3 没有出现在 nums2 中。因此，answer[0] = [1,3]。
     * 对于 nums2 ，nums2[0] = 2 出现在 nums1 中下标 1 处，然而 nums2[1] = 4 和 nums2[2] = 6 没有出现在 nums2 中。因此，answer[1] = [4,6]。
     * 示例 2：
     * <p>
     * 输入：nums1 = [1,2,3,3], nums2 = [1,1,2,2]
     * 输出：[[3],[]]
     * 解释：
     * 对于 nums1 ，nums1[2] 和 nums1[3] 没有出现在 nums2 中。由于 nums1[2] == nums1[3] ，二者的值只需要在 answer[0] 中出现一次，故 answer[0] = [3]。
     * nums2 中的每个整数都在 nums1 中出现，因此，answer[1] = [] 。
     */

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        /**
         * 1.取数组1，2的交集
         * 2.数组1-交集；数组2-交集
         * 3.返回结果集合
         */
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        Set<Integer> bj = new HashSet<>();
        for (int i : nums2) {
            if (set.contains(i)) {
                bj.add(i);
            }
        }

        Set<Integer> set1 = new HashSet<>();
        for (int i : nums1) {
            if (!bj.contains(i)) {
                set1.add(i);
            }
        }

        Set<Integer> set2 = new HashSet<>();
        for (int i : nums2) {
            if (!bj.contains(i)) {
                set2.add(i);
            }
        }

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (Integer integer : set1) {
            list1.add(integer);
        }
        for (Integer integer : set2) {
            list2.add(integer);
        }

        list.add(list1);
        list.add(list2);

        return list;
    }

    public static void main(String[] args) {
        Mianshi75 m = new Mianshi75();

        String word1 = "12345";
        String word2 = "abc";
        String mergeAlternately = m.mergeAlternately(word1, word2);
        System.out.println(mergeAlternately);


        String gcdOfStrings = m.gcdOfStrings("abc", "abcabc");
        System.out.println(gcdOfStrings);


        int[] intArray = {1, 0, 0};
        boolean canPlaceFlowers = m.canPlaceFlowers(intArray, 1);
        System.out.println(canPlaceFlowers);
        System.out.println(m.reverseVowels("aei"));


        System.out.println(m.reverseWords("the sky is blue"));

        int[] ints = m.productExceptSelf(new int[]{1, 2, 3, 4});
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
        System.out.println();

        System.out.println(m.increasingTriplet(new int[]{3, 2, 1}));

        System.out.println(m.compress(new char[]{'a', 'a'}));

        int[] moveZeros = {0, 1, 0, 3, 12};
        m.moveZeroes(moveZeros);

        for (int a : moveZeros) {
            System.out.print(a + " ");
        }
        System.out.println();

        int[] moveZeros2 = {0, 1, 0, 3, 12};
        m.moveZeroes2(moveZeros2);

        for (int a : moveZeros2) {
            System.out.print(a + " ");
        }
        System.out.println();

        System.out.println(m.isSubsequence("abc", "abbbc"));

        System.out.println(m.maxArea2(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(m.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));

        System.out.println(m.maxOperations(new int[]{1, 1, 1}, 2));

        System.out.println(m.findMaxAverage(new int[]{5}, 1));

        System.out.println(m.maxVowels("abciiidef", 3));

        System.out.println(m.longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));

        System.out.println(m.longestSubarray(new int[]{1, 1, 1}));

        System.out.println(m.largestAltitude(new int[]{0, -4, -7, -9, -10, -6, -3, -1}));

        System.out.println(m.pivotIndex(new int[]{0, -4, -7, -9, -10, -6, -3, -1}));

        System.out.println(m.findDifference(new int[]{1, 2, 3, 3}, new int[]{1, 1, 2, 2}));
    }
}
