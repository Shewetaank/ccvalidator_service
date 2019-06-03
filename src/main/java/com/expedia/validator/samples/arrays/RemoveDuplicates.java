package com.expedia.validator.samples.arrays;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RemoveDuplicates {

    public static void main(String[] args) {

        int[] arr = {1,2,1,2,3,4,5,3};

        removeDups(arr);

        removeDuplicates(arr);
    }

    private static void removeDuplicates(int[] arr) {

    }

    private static void removeDups(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < arr.length; i++) {
            if(!set.contains(arr[i])) {
                set.add(arr[i]);
            }
        }

        for (Iterator<Integer> it = set.iterator(); it.hasNext(); ) {
            int val = it.next();
            System.out.println(val);
        }

    }


}
