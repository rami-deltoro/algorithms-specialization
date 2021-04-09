package org.example.exersizes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *  https://leetcode.com/problems/remove-vowels-from-a-string/
 */
public class RemoveVowels {

    final Set<Character> vowelSet = new HashSet<>(Arrays.asList('a','e','i','o','u'));

    public String removeVowels(final String input) {
        final int inputSize = input.length();
        final StringBuilder inputWithoutVowelsSB = new StringBuilder();

        for(int i=0;i<inputSize;i++) {
            char iteratedCharacter = input.charAt(i);
            if(!vowelSet.contains(iteratedCharacter)) {
                inputWithoutVowelsSB.append(iteratedCharacter);
            }
        }

        return inputWithoutVowelsSB.toString();
    }
}
