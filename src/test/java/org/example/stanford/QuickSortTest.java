package org.example.stanford;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    private final QuickSort quickSort = new QuickSort();


    @Test
    void sort() {

        int[] array = new int[]{5,6,2,3,1,9};
        int[] expectedArray = array.clone();
        Arrays.sort(expectedArray);

        quickSort.sort(array,0,array.length-1);

        assertArrayEquals(expectedArray,array);

    }
}