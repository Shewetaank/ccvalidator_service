package com.expedia.validator.samples.arrays;

public class BinarySearch {

    public int search(int[] arr, int start, int end, int num) {
        if(end >= start) {
            int mid = start + (end - 1)/2;

            if(arr[mid] == num) {
                return num;
            }

            if(num < arr[mid])
                return search(arr, start, mid - 1, num);

        }
        return 0;
    }
}
