package org.example.stanford;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

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
        int[] array = new int[]{1,2,3,4,5,6};
        assertEquals(0, countInversions.countInversions(array, array.length));

        int[] arrayInverted = new int[]{6,5,4,3,2,1};
        assertEquals(15, countInversions.countInversions(arrayInverted,arrayInverted.length));

        int[] array2 = new int[]{1,2,3,4,-1,0};
        assertEquals(8, countInversions.countInversions(array2, array2.length));

    }

    /*
    https://www.coursera.org/learn/algorithms-divide-conquer/exam/YLbzP/programming-assignment-2
     */
    @Test
    void programmingAssesment2() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("integerArray.txt").getFile());
        int[] array = new int[100000];
        AtomicInteger atomicInteger = new AtomicInteger();
        Files.lines(file.toPath())
                .forEach(s -> {
                    int number = Integer.valueOf(s);
                    int index = atomicInteger.getAndIncrement();
                    array[index] = number;
                });

        assertEquals(2407905288L,countInversions.countInversions(array,array.length));
    }



}