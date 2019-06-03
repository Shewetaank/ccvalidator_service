package com.expedia.validator.samples.arrays;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {

        int[] input = {1,2,3,4,5,6,7,8};
        rotateArray(input, 2);
    }

    private static void rotateArray(int[] input, int k) {
        int[] temp = new int[k];
        int i = k - 1;
        for(int j = 0; j < k; j++) {
            temp[j] = input[i];
            i--;
        }

    }
}
