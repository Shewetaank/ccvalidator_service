package com.expedia.validator.samples.sort;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};

        selectionSort(arr);
    }

    private static void selectionSort(int[] arr) {
        int min_index = 0;
        int j = 0, i = 0;
        int n = arr.length;
        for(; i < n; i++) {
            min_index = i;
            j = i + 1;
            for(;j < n; j++) {
                if(arr[j] < arr[min_index]) {
                    min_index = j;
                }
            }
            int temp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = temp;
        }

        for(int k = 0; k < n;k++) {
            System.out.println(arr[k]);
        }
    }
}
