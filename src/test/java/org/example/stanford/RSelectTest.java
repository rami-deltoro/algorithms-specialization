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


}