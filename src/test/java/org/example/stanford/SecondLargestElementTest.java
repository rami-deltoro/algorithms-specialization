package org.example.stanford;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SecondLargestElementTest {

    private final SecondLargestElement secondLargestElement = new SecondLargestElement();

    @Test
    void findMax() {
        int[] array = new int[]{10,2,3,4,1,5,6,12,9};

        System.out.println(secondLargestElement.findMax(array,0,array.length-1));
    }

    @Test
    void findMaxTournament() {
        int[] array = new int[]{10,2,3,4,1,5,6,12,9};

        System.out.println(secondLargestElement.findMaxTournament(array,0,array.length-1,array.length));
    }

    @Test
    void findMaxTournament2() {
        int[] array = new int[]{10,2,3,4,1,5,6,12,9};

        System.out.println(secondLargestElement.findSecondRecursive(array.length,array));
    }
}