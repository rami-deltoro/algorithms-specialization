package org.example.stanford;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

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

    @Test
    void sort2() {

        int[] array = new int[]{5,6,2,3,1,9};
        int[] expectedArray = array.clone();
        Arrays.sort(expectedArray);

        new QuickSortFromClass().sort(array,0,array.length-1, QuickSortFromClass.PivotStrategy.FIRST_ELEMENT);

        System.out.println(Arrays.toString(array));
        assertArrayEquals(expectedArray,array);

    }



    @Test
    void countComparison() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("QuickSort.txt").getFile());
        int[] array = new int[10000];
        AtomicInteger atomicInteger = new AtomicInteger();
        Files.lines(file.toPath())
                .forEach(s -> {
                    int number = Integer.valueOf(s);
                    int index = atomicInteger.getAndIncrement();
                    array[index] = number;
                });

        int[] array1 = array.clone();
        int[] array2 = array.clone();
        int[] array3 = array.clone();

        assertEquals(162085,new QuickSortFromClass().sort(array1,0,array.length-1, QuickSortFromClass.PivotStrategy.FIRST_ELEMENT));
        assertEquals(164123,new QuickSortFromClass().sort(array2,0,array.length-1, QuickSortFromClass.PivotStrategy.LAST_ELEMENT));
        assertEquals(138382,new QuickSortFromClass().sort(array3,0,array.length-1, QuickSortFromClass.PivotStrategy.MEDIAN_OF_THREE));


    }
}