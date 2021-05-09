package org.example.stanford;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    MergeSort mergeSort = new MergeSort();

    @Test
    void sort() {
        int[] actual = { 5, 1, 6, 2, 3, 4 };
        int[] expected = { 1, 2, 3, 4, 5, 6 };
        mergeSort.sort(actual, actual.length);
        assertArrayEquals(expected, actual);
    }

    @Test
    void sort2() {
        int[] actual = { 5, 1, 6,9 };
        int[] expected = { 1, 5, 6 ,9};
        mergeSort.sort(actual, actual.length);
        assertArrayEquals(expected, actual);
    }


    @Test
    void sort3() {
        int[] actual = { 5,3,8,9,1,7,0,2,6,4};
        int[] expected = { 0,1,2,3,4,5,6,7,8,9};
        mergeSort.sort(actual, actual.length);
        System.out.println("array= "+ Arrays.toString(actual));
        assertArrayEquals(expected, actual);
    }

}