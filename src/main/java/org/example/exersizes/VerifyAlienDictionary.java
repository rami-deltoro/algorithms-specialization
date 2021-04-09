package org.example.exersizes;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/verifying-an-alien-dictionary/
 */
@Slf4j
public class VerifyAlienDictionary {


    public boolean isAlienSorted(String[] words, String order) {
        int[] orderMap = new int[26];
        for (int i = 0; i < order.length(); i++){
            orderMap[order.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (j >= words[i + 1].length()) return false;

//                if(orderMap[words[i].charAt(j) - 'a'] > orderMap[words[i].charAt(j) - 'a']) {
//                    return false;
//                }

                if (words[i].charAt(j) != words[i + 1].charAt(j)) {
                    int currentWordChar = words[i].charAt(j) - 'a';
                    int nextWordChar = words[i + 1].charAt(j) - 'a';
                    if (orderMap[currentWordChar] > orderMap[nextWordChar]) return false;
                        // if we find the first different letter and they are sorted,
                        // then there's no need to check remaining letters
                    else break;
                }

            }
        }

        return true;
    }

//    private boolean isWordsSorted(String[] words,final int[] orderMap ) {
//        boolean isInOrder = true;
//        int previousCharIndex = Integer.MIN_VALUE;
//
//        for (int i=0;i<words.length;i++) {
//            if(orderMap.get(words[i].charAt(0)) > previousCharIndex) {
//                previousCharIndex = orderMap.get(words[i].charAt(0));
//            } else if(orderMap.get(words[i].charAt(0)) == previousCharIndex) {
//                if(!isPreviousAndNextWordInOrder(words[i-1],words[i],orderMap)) {
//                    isInOrder = false;
//                    break;
//                }
//            } else {
//                isInOrder = false;
//                break;
//            }
//        }
//
//        return isInOrder;
//    }

//    private boolean isPreviousAndNextWordInOrder(String prev,String curr,final Map<Character,Integer> orderMap) {
//        boolean isInOrder = true;
//        int loops = Math.min(prev.length(),curr.length());
//        for(int i=0;i<loops;i++) {
//            if (orderMap.get(prev.charAt(i)) > orderMap.get(curr.charAt(i))) {
//                isInOrder = false;
//                break;
//            }
//        }
//
//        if(isInOrder && prev.length() > curr.length() && prev.substring(0,loops).equals(curr.substring(0,loops))) {
//            isInOrder = false;
//        }
//        return isInOrder;
//    }


}
