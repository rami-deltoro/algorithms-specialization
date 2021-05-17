package org.example.usd;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class MaxPairwiseProductTest {



    @Test
    void stressTest() {
        while(true) {
            int n = (int)(Math.random() * 3 + 1)+1;
            int[] array = new int[n];

            for(int i = 0;i<n;i++) {
                array[i] = (int)((Math.random() * 12 - 2) + 1);
            }

            System.out.println(Arrays.toString(array));

            long resultNaive = MaxPairwiseProduct.getMaxPairwiseProductNaive(array);
            long resultFast = MaxPairwiseProduct.getMaxPairwiseProduct(array);

            if(resultFast == resultNaive) {
                System.out.println("OK");
            } else {
                System.out.println("Wrong!  resultFast = "+resultFast+" resultNaive="+resultNaive);
                System.exit(2);
            }

        }
    }

}