package org.example.stanford.closestpair;

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
public class ClosestPairMergeSort {


    public int[] sort(int[] array, int n) {
        if(n < 2) {
            return new int[]{0,0};
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

        sort(leftArray,mid);
        sort(rightArray,n-mid);

        return merge(array,leftArray,rightArray,mid,n-mid);
    }

    /*
        1. Compare each element from the array and store into the original array
        2. Add remaining elements from split array into original array.
     */
    private int[] merge(int[] array, int[] leftArray, int[] rightArray,int leftEndIndex,int rightEndIndex) {
        int[] minPair = new int[2];
        int min = Integer.MAX_VALUE;

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

            if(arrayIndex>1) {
                int distance = array[arrayIndex] - array[arrayIndex-1];
                if(distance < min) {
                    min = distance;
                    minPair[0] = arrayIndex-1;
                    minPair[1] = arrayIndex;
                }
            }

            arrayIndex++;
        }

        while(leftIndexCounter < leftEndIndex) {
            array[arrayIndex] = leftArray[leftIndexCounter];
            leftIndexCounter++;
            if(arrayIndex>1) {
                int distance = array[arrayIndex] - array[arrayIndex-1];
                if(distance < min) {
                    min = distance;
                    minPair[0] = arrayIndex-1;
                    minPair[1] = arrayIndex;
                }
            }

            arrayIndex++;


        }

        while(rightIndexCounter < rightEndIndex) {
            array[arrayIndex] = rightArray[rightIndexCounter];
            rightIndexCounter++;
            if(arrayIndex>1) {
                int distance = array[arrayIndex] - array[arrayIndex-1];
                if(distance < min) {
                    min = distance;
                    minPair[0] = arrayIndex-1;
                    minPair[1] = arrayIndex;
                }
            }

            arrayIndex++;


        }

        return minPair;
    }

}
