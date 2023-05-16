package com.gua.sf.demo;

import java.util.Stack;

public class StackDemo {
    public Boolean isKuoHao(String s) {
        char leftMiddle = '[';
        char rightMiddle = ']';
        char leftSmall = '(';
        char rightSmall = ')';
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == leftMiddle) {
                stack.push(c);
            }
            if (c == leftSmall) {
                stack.push(c);
            }
            if (c == rightMiddle) {
                Character pop = stack.pop();
                if (pop != leftMiddle) {
                    return false;
                }
            }
            if (c == rightSmall) {
                Character pop = stack.pop();
                if (pop != leftSmall) {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        StackDemo sd = new StackDemo();
        System.out.println(sd.isKuoHao("[()]"));
        System.out.println(sd.isKuoHao("[[)]"));
        System.out.println(sd.isKuoHao("([(]])"));
    }
}
