package org.example.stanford;

import org.junit.jupiter.api.Test;

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


}