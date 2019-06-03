package com.expedia.validator.string;

import io.swagger.models.auth.In;

import java.util.HashMap;
import java.util.Map;

public class PrintMaxOccurence {

    public static void main(String[] args) {
        String input = "HelloWorld";

        char result = printMaximumOccurringCharacter(input);
        System.out.println(result);
    }

    private static char printMaximumOccurringCharacter(String input) {
        Map<Character, Integer> characterIntegerMap = new HashMap<>();

        char[] arr = input.toCharArray();

        for(int i = 0; i < arr.length; i++) {
            if(characterIntegerMap.containsKey(arr[i])) {
                int value = characterIntegerMap.get(arr[i]) + 1;
                characterIntegerMap.put(arr[i], value);
            } else {
                characterIntegerMap.put(arr[i], 1);
            }
        }

        int max = 0;
        char ch = 'a';
        for (char key:
             characterIntegerMap.keySet()) {
            if(characterIntegerMap.get(key) > max) {
                max = characterIntegerMap.get(key);
                ch = key;
            }
        }
        return ch;
    }
}
