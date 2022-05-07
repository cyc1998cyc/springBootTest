package com.chen.day02;

/**
 * 陈宇超
 * 16:51
 */
public class SelectSort {






    public static void main(String[] args) {
        int[] ints = {12,32,2,45,12,5234,23,123,33,67};
        printArr(ints);
        selectSort(ints);
        printArr(ints);


    }

    public static void selectSort(int[] arrs){
        if (arrs == null || arrs.length < 2){
            return;
        }

        for (int i = 0; i < arrs.length; i++) {
            for (int j = i+1; j < arrs.length; j++) {
                if (arrs[i] > arrs[j]){
                    int value = arrs[i];
                    arrs[i] = arrs[j];
                    arrs[j] = value;
                }
            }
        }
    }

    public static void printArr(int[] arrs){
        for (int i = 0; i < arrs.length; i++) {
            System.out.print(arrs[i] + "  ");
        }
        System.out.println();
    }
}
