package com.expedia.validator.samples.arrays;

public class FindMissingNumber {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,11,12,13,14,15};

        int result = findMissing(arr,15);

        System.out.println(result);
    }

    private static int findMissing(int[] arr, int end) {

        int expectedSum = (end * (end + 1))/2;
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }

        return sum - expectedSum;
    }
}
