package org.example.stanford.closestpair;

import lombok.extern.slf4j.Slf4j;
import org.example.model.Point;


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
public class PointMergeSort {

    public void sortByY(Point[] array, int n) {
        if(n < 2) {
            return;
        }

        int mid = n / 2;
        Point[] leftArray = new Point[mid];
        Point[] rightArray = new Point[n - mid];

        for(int i=0;i<mid;i++) {
            leftArray[i] = array[i];
        }

        for(int i=mid;i<n;i++) {
            rightArray[i-mid] = array[i];
        }

        sortByY(leftArray,mid);
        sortByY(rightArray,n-mid);

        mergeByY(array,leftArray,rightArray,mid,n-mid);
    }


    /*
        1. Compare each element from the array and store into the original array
        2. Add remaining elements from split array into original array.
     */
    private void mergeByY(Point[] array, Point[] leftArray, Point[] rightArray,int leftEndIndex,int rightEndIndex) {

        int leftIndexCounter=0;
        int rightIndexCounter=0;
        int arrayIndex=0;

        while(leftIndexCounter < leftEndIndex && rightIndexCounter<rightEndIndex) {
            if(leftArray[leftIndexCounter].getY() <= rightArray[rightIndexCounter].getY()) {
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

    public void sortByX(Point[] array, int n) {
        if(n < 2) {
            return;
        }

        int mid = n / 2;
        Point[] leftArray = new Point[mid];
        Point[] rightArray = new Point[n - mid];

        for(int i=0;i<mid;i++) {
            leftArray[i] = array[i];
        }

        for(int i=mid;i<n;i++) {
            rightArray[i-mid] = array[i];
        }

        sortByX(leftArray,mid);
        sortByX(rightArray,n-mid);

        mergeByX(array,leftArray,rightArray,mid,n-mid);
    }

    /*
        1. Compare each element from the array and store into the original array
        2. Add remaining elements from split array into original array.
     */
    private void mergeByX(Point[] array, Point[] leftArray, Point[] rightArray,int leftEndIndex,int rightEndIndex) {

        int leftIndexCounter=0;
        int rightIndexCounter=0;
        int arrayIndex=0;

        while(leftIndexCounter < leftEndIndex && rightIndexCounter<rightEndIndex) {
            if(leftArray[leftIndexCounter].getX() <= rightArray[rightIndexCounter].getX()) {
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
