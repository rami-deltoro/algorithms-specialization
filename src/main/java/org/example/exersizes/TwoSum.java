package org.example.exersizes;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * https://leetcode.com/problems/two-sum/
 */
@Slf4j
public class TwoSum {


    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}


