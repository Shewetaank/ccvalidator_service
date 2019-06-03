package com.expedia.validator.samples.sort;

public class RecursiveBubbleSort {

    public static void main(String[] args) {

        int[] arr = {5, 1, 4, 2, 8};

        bubbleSort(arr, arr.length);

        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void bubbleSort(int[] arr, int n) {
        if(n == 1)
            return;

        for(int i = 0; i < n - 1; i++) {
            if(arr[i+1] < arr[i]) {
                int temp = arr[i+1];
                arr[i+1] = arr[i];
                arr[i] = temp;
            }
        }

        bubbleSort(arr, n - 1);
    }
}
