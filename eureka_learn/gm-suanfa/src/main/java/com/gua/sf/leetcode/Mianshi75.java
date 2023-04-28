package com.gua.sf.leetcode;

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


    public static void main(String[] args) {
        Mianshi75 m = new Mianshi75();

        String word1 = "12345";
        String word2 = "abc";
        String mergeAlternately = m.mergeAlternately(word1, word2);
        System.out.println(mergeAlternately);


        String gcdOfStrings = m.gcdOfStrings("abc", "abcabc");
        System.out.println(gcdOfStrings);
    }
}
