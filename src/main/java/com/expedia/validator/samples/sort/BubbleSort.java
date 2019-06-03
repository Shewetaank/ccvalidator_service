package com.expedia.validator.samples.sort;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 2, 8};

        bubbleSort(arr);

        for(int i = 0; i < arr.length;i++) {
            System.out.println(arr[i]);
        }
    }

    private static void bubbleSort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length - 1; j++) {
                if(arr[j+1] < arr[j]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
