package org.example.stanford;


import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class CountInversions {


    /*
        O(n^2)
     */
    public int bruteForce(int[] array) {
        int count = 0;

        for(int i=0;i<array.length;i++) {
            for(int j = i+1;j<array.length;j++) {
                if(array[i] > array[j]) {
                    count++;
                }
            }
        }

        return count;
    }

    /*
        O(n logn) piggy back off mergeSort.
     */
    public int countInversions(int[] array, int n) {
        if(n==1) {
            return 0;
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

        int x = countInversions(leftArray,mid);
        int y = countInversions(rightArray,n-mid);
        int z = countInversions(array,leftArray,rightArray,mid,n-mid);

        return x + y + z;

    }

    private int countInversions(int[] array, int[] leftArray, int[] rightArray,int leftEndIndex,int rightEndIndex) {
        log.info("Array={}",Arrays.toString(array));
        int count = 0;

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
                count = count + (leftArray.length - leftIndexCounter); //remaining elements in left are considered split inversions
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

        return count;
    }


}
