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
         * 0.使用HashMap记录元素的出现次数
         * 1.使用hashSet存储元素次数
         * 2.比较HashSet的length和元素次数的length
         * 3.相同说明没有重复元素，返回true;不相同返回false
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

        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();

        fillMapAndSet(word1, map1, set1);
        fillMapAndSet(word2, map2, set2);

        Object[] count1 = map1.values().toArray();
        Object[] count2 = map2.values().toArray();
        Arrays.sort(count1);
        Arrays.sort(count2);
        if(!Arrays.equals(count1,count2)){
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

            if(map2.get(e)==null){
                map2.put(e,1);
            }else {
                map2.put(e,map2.get(e)+1);
            }
        }
    }

    public static void main(String[] args) {
        Mianshi75_2 m = new Mianshi75_2();
        boolean b = m.uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3});
        Assert.isTrue(b, "每个数的出现次数不是独一无二的");


        boolean b1 = m.closeStrings("abbzzca", "babzzcz");
        Assert.isTrue(!b1, "两个字符串接近");

    }
}
