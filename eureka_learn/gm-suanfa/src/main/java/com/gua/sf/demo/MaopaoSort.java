package com.gua.sf.demo;

/**
 * 冒泡排序
 */
public class MaopaoSort {

    public static void main(String[] args) {


        int[] array = {1, 2, 4, 5, 3};

        maopaoSort(array);

        for (int i : array) {
            System.out.print(i+" ");
        }
    }

    private static void maopaoSort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                int temp;
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
