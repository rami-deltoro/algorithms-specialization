package org.example.exersizes;

import lombok.extern.slf4j.Slf4j;

/**
 * https://leetcode.com/problems/maximum-subarray/solution/
 *
 * TODO may not be done
 */
@Slf4j
public class MaximumSubarray {


    public int maxSubArray(int[] nums) {
        int currentSum = Integer.MIN_VALUE;
        int max = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] > currentSum) {
                currentSum = nums[i];
                log.info("nums[i] > max , i = {} , num[i] = {}",i,nums[i]);
            } else {
                currentSum = currentSum + nums[i];

                log.info("max = max + nums[i] , i = {} , num[i] = {} , max = {}",i,nums[i],max);

            }
        }

        return max;
    }
}
