package org.example.stanford;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    BinarySearch binarySearch = new BinarySearch();

    @Test
    void find() {
        int[] array = new int[]{1,12,23,44,55,66};
        System.out.println(binarySearch.find(array, 0,array.length-1,66));
    }
}