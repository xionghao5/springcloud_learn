package com.gua.sf.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author 86188
 */
public class HashMapDemo {
    public static void main(String[] args) {
        int size = 1000000;

        Map<Integer, Integer> map = new HashMap(size);

        Random random = new Random();
        for (int i = 0; i < size; i++) {
            int key = random.nextInt(size);
            int value = random.nextInt(size);
            map.put(key, value);
        }

        for (Map.Entry<Integer, Integer> entrySet : map.entrySet()) {
            System.out.println(entrySet.getKey() + ": " + entrySet.getValue());
        }
        System.out.println(map.size());
    }
}
