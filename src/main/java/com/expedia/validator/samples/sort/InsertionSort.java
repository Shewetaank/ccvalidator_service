package com.expedia.validator.samples.sort;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {3,5,6,2,3,5,11};

        insertionSort(arr, 1);
    }

    private static void insertionSort(int[] arr, int n) {

        if(n < arr.length) {
            for(int i = 0; i < n; i++) {
                if(arr[n] < arr[i]) {

                }
            }
        }

    }
}
