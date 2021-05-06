package org.example.stanford;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RSelectTest {

    RSelect rSelect = new RSelect();


    @Test
    void testRselect() {
        int[] array = new int[]{3,1,8,4,7,9};
        int num = rSelect.rSelect(array,0,array.length-1,5);
        System.out.println("num="+num);
    }


//    @Test
//    void testPartition() {
//        int[] array = new int[]{3,1,8,4,7,9};
//        RSelect.PivotData pivotData = rSelect.partition(array,0,array.length-1);
//        assertEquals(RSelect.PivotData.builder()
//                .index(1)
//                .leftIndex(0)
//                .rightIndex(array.length-1)
//                .array(new int[]{1, 3, 8, 4, 7, 9})
//                .pivotValue(3)
//                .pivotIndexPartition(1)
//                .build(),pivotData);
//    }
//
//    @Test
//    void testPartition2() {
//        int[] array = new int[]{4,1,8,3,7,9};
//        RSelect.PivotData pivotData = rSelect.partition(array,0,array.length-1);
//        assertEquals(RSelect.PivotData.builder()
//                .index(2)
//                .leftIndex(0)
//                .rightIndex(5)
//                .array(new int[]{3, 1, 4, 8, 7, 9})
//                .pivotValue(4)
//                .pivotIndexPartition(2)
//                .build(),pivotData);
//    }
//
//
//    @Test
//    void testPartition3() {
//        int[] array = new int[]{4,1,8,3,7,9};
//        RSelect.PivotData pivotData = rSelect.partition(array,2,array.length-1);
//        assertEquals(RSelect.PivotData.builder()
//                .index(4)
//                .leftIndex(2)
//                .rightIndex(5)
//                .array(new int[]{4, 1, 7, 3, 8, 9})
//                .pivotValue(8)
//                .pivotIndexPartition(2)
//                .build(),pivotData);
//    }
//
//    @Test
//    void testPartition4() {
//        int[] array = new int[]{4,1,8,3,7,9};
//        RSelect.PivotData pivotData = rSelect.partition(array,3,array.length-1);
//        assertEquals(RSelect.PivotData.builder()
//                .index(3)
//                .leftIndex(3)
//                .rightIndex(5)
//                .array(new int[]{4, 1, 8, 3, 7, 9})
//                .pivotValue(3)
//                .pivotIndexPartition(0)
//                .build(),pivotData);
//    }
//
//    @Test
//    void testPartition5() {
//        int[] array = new int[]{4,1,8,3,7,9};
//        RSelect.PivotData pivotData = rSelect.partition(array,0,3);
//        assertEquals(RSelect.PivotData.builder()
//                .index(2)
//                .leftIndex(0)
//                .rightIndex(3)
//                .array(new int[]{3, 1, 4, 8, 7, 9})
//                .pivotValue(4)
//                .pivotIndexPartition(2)
//                .build(),pivotData);
//    }
}