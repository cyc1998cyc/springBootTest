package com.chen.day02;

/**
 * 陈宇超
 * 17:11
 */
public class BubboSort {
    public static void main(String[] args) {
        int[] ints = {12,32,2,45,12,5234,23,123,33,67};
        printArr(ints);
        bubboSort(ints);
        printArr(ints);
    }

    public static void bubboSort(int[] arrs) {
        if (arrs == null || arrs.length < 2) {
            return;
        }

        for (int i = 0; i < arrs.length; i++) {
            for (int j = 0; j < arrs.length-i-1; j++) {
                if (arrs[j] > arrs[j + 1]) {
                    int value = arrs[j];
                    arrs[j] = arrs[j + 1];
                    arrs[j + 1] = value;
                }
            }
        }


    }


    public static void printArr(int[] arrs) {
        for (int i = 0; i < arrs.length; i++) {
            System.out.print(arrs[i] + "  ");
        }
        System.out.println();
    }
}
