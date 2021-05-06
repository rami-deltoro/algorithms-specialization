package org.example.stanford;


import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Random;

/**
 *  Master Method :
 *
 *  a = 1 :: Number of Recursive calls | Chose one side to recurse on
 *  b = 2 :: Factor smaller than input. Half the size of original array when we choose the median as the pivot
 *  d = 1 :: The merge is done in constant time o(1), Thus 1.
 *
 *  This puts us on case 2 since a < b^d => 1 < 2^1 => O(n^1) = O(n)
 */
@Slf4j
public class RSelect {

    private Random random = new Random();

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public int rSelect(int[] array,int leftIndex,int rightIndex,int k) {
        int pivot = choosePivot(array,leftIndex,rightIndex);
        swap(array,leftIndex,pivot);

        int partition = partition(array,leftIndex,rightIndex);
        log.info("partition = {} , pivot = {} , leftIndex = {}, rightIndex = {} , array = {} k ={}",partition,pivot,leftIndex,rightIndex,Arrays.toString(array),k);
        int j =partition;


        if(j==k) {
            return array[partition];
        } else if(j<k) {
            return rSelect(array,partition+1,rightIndex,k);

        } else {
            return rSelect(array,leftIndex,partition-1,k);

        }


    }

    private int choosePivot(int[] array, int leftIndex, int rightIndex) {
        return random.nextInt(rightIndex - leftIndex + 1) + leftIndex;
    }

    public int partition(int[] arr,int low, int high) {
        int i = low + 1;
        int pivot = arr[low];

        for(int j=low+1;j<high+1;j++) {
            if(arr[j] < pivot) {
                swap(arr,j,i);
                i++;
            }
        }

        swap(arr,low,i-1);
        return i-1;
    }


    @Builder
    @Data
    public static class PivotData {
        private int index;
        private int leftIndex;
        private int rightIndex;
        private int pivotValue;
        private int pivotIndexPartition;
        private int[] array;
    }
}


