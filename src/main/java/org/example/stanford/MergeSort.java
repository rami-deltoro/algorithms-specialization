package org.example.stanford;

import lombok.extern.slf4j.Slf4j;

/**
 *              1. Create two empty arrays
 *  SPLIT ARRAY 2. Copy 0-mid elements into leftArray
 *  SPLIT ARRAY 3. Copy mid-n elements into right array.
 *  RECURSIVE   4. Call sort on leftArray
 *  RECURSIVE   5. Call sort on rightArray
 *              6. Merge leftArray & rightArray
 *
 *  Time Complexity : O(n logn)
 */
@Slf4j
public class MergeSort {

    public void sort(int[] array, int n) {
        if(n < 2) {
            return;
        }

        int mid = n / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[n - mid];

        for(int i=0;i<mid;i++) {
            leftArray[i] = array[i];
        }

        for(int i=mid;i<n;i++) {
            rightArray[i-mid] = array[i];
        }

        log.info("Before left Sort. n={}",n);
        sort(leftArray,mid);
        log.info("After left Sort. n={}",n);
        sort(rightArray,n-mid);
        log.info("After right Sort. n={}",n);

        merge(array,leftArray,rightArray,mid,n-mid);
        log.info("After merge. n={}",n);

    }

    /*
        1. Compare each element from the array and store into the original array
        2. Add remaining elements from split array into original array.
     */
    private void merge(int[] array, int[] leftArray, int[] rightArray,int leftEndIndex,int rightEndIndex) {

        int leftIndexCounter=0;
        int rightIndexCounter=0;
        int arrayIndex=0;

        while(leftIndexCounter < leftEndIndex && rightIndexCounter<rightEndIndex) {
            if(leftArray[leftIndexCounter] <= rightArray[rightIndexCounter]) {
                array[arrayIndex] = leftArray[leftIndexCounter];
                leftIndexCounter++;
            } else {
                array[arrayIndex] = rightArray[rightIndexCounter];
                rightIndexCounter++;
            }
            arrayIndex++;
        }

        while(leftIndexCounter < leftEndIndex) {
            array[arrayIndex] = leftArray[leftIndexCounter];
            leftIndexCounter++;
            arrayIndex++;
        }

        while(rightIndexCounter < rightEndIndex) {
            array[arrayIndex] = rightArray[rightIndexCounter];
            rightIndexCounter++;
            arrayIndex++;
        }
    }

}
