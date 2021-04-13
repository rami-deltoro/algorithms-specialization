package org.example.exersizes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumSubarrayTest {

    MaximumSubarray maximumSubarray = new MaximumSubarray();

    @Test
    void maxSubArray() {
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(maximumSubarray.maxSubArray(arr));
    }
}