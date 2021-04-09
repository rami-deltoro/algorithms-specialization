package org.example.exersizes;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {

    private TwoSum twoSum = new TwoSum();


    @Test
    void twoSum() {
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{7,2,11,-15},-8)));
    }
}