package org.example.stanford;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CountInversionsTest {

    CountInversions countInversions = new CountInversions();

    @Test
    void bruteForce() {
        int[] array = new int[]{1,2,3,4,5,6};
        assertEquals(0, countInversions.bruteForce(array));

        int[] arrayInverted = new int[]{6,5,4,3,2,1};
        assertEquals(15, countInversions.bruteForce(arrayInverted));
    }

    @Test
    void countInversions() {
//        int[] array = new int[]{1,2,3,4,5,6};
//        assertEquals(0, countInversions.countInversions(array, array.length));
//
//        int[] arrayInverted = new int[]{6,5,4,3,2,1};
//        assertEquals(15, countInversions.countInversions(arrayInverted,arrayInverted.length));

        int[] array2 = new int[]{1,2,3,4,-1,0};
        assertEquals(8, countInversions.countInversions(array2, array2.length));

        System.out.println("Final array = "+ Arrays.toString(array2));
    }




}