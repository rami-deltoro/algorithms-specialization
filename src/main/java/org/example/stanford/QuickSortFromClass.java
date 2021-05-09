package org.example.stanford;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class QuickSortFromClass {

    enum PivotStrategy {
        FIRST_ELEMENT,
        LAST_ELEMENT,
        MEDIAN_OF_THREE;
    }

    public int sort(int[] array, int leftIndex, int rightIndex, PivotStrategy pivotStrategy) {
        int count = rightIndex -leftIndex;
        if(leftIndex >= rightIndex) {
            return 0;
        }

        int pivot = choosePivot(array,leftIndex,rightIndex,pivotStrategy);
        swap(array,leftIndex,pivot);
        int index = partition(array,leftIndex,rightIndex);

        int countL = sort(array,leftIndex,index-1,pivotStrategy);
        int countR = sort(array,index+1,rightIndex,pivotStrategy);

        return count + countR + countL;
    }





    private int choosePivot(int[] array, int leftIndex, int rightIndex, PivotStrategy pivotStrategy) {
        if (PivotStrategy.FIRST_ELEMENT == pivotStrategy) {

        } else if(PivotStrategy.LAST_ELEMENT == pivotStrategy) {
            swap(array,leftIndex,rightIndex);
        } else if (PivotStrategy.MEDIAN_OF_THREE == pivotStrategy) {

            int mid = ((rightIndex - leftIndex) / 2) + leftIndex;
            int[] threeElementArray = new int[]{array[leftIndex],array[rightIndex],array[mid]};
            int pivotIndex = 0;
            Arrays.sort(threeElementArray);
            if(threeElementArray[1] == array[leftIndex]) {
                pivotIndex = leftIndex;
            } else if(threeElementArray[1] == array[rightIndex]) {
                pivotIndex = rightIndex;
            } else {
                pivotIndex = mid;
            }

            swap(array,leftIndex,pivotIndex);
        }

        return leftIndex;
    }


    private int partition(int[] array, int leftIndex, int rightIndex) {
        int i = leftIndex + 1;
        int pivot = array[leftIndex];

        for(int j=leftIndex+1;j<rightIndex+1;j++) {
            if(array[j] < pivot) {
                swap(array,j,i);
                i++;
            }
        }

        swap(array,leftIndex,i-1);
        return i-1;
    }


    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
