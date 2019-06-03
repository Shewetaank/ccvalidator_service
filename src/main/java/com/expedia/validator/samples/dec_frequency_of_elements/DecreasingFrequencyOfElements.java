package com.expedia.validator.samples.dec_frequency_of_elements;

import com.expedia.validator.samples.mergeintervals.Interval;

import java.lang.reflect.Array;
import java.util.*;

public class DecreasingFrequencyOfElements {

    public static void main(String[] args) {
        System.out.println("test");
        Integer[] input = new Integer[] { 2,3,5,3,7,9,5,3,7 };
        // Sort the array using custom comparator
        Arrays.sort(input, new FrequencyComparator(input));
        // Print the result
        for (Integer i : input)
            System.out.print(i + " ");
    }

    static class FrequencyComparator implements Comparator<Integer>
    {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        public FrequencyComparator(Integer[] input) {
            for (Integer i : input) {
                frequencyMap.put(i, frequencyMap.get(i) != null ? frequencyMap.get(i) + 1 : 1);
            }
        }

        @Override
        public int compare(Integer i1, Integer i2) {
            // If frequencies are the same then compare the actual numbers
            if (frequencyMap.get(i1) == frequencyMap.get(i2))
                return i1.compareTo(i2);

            return (frequencyMap.get(i1) < frequencyMap.get(i2)) ? 1 : -1;
        }
    }
}
