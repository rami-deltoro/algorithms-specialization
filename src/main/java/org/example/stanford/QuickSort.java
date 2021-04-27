package org.example.stanford;


public class QuickSort {


    public void sort(int[] array, int leftIndex, int rightIndex) {
        if(leftIndex >= rightIndex) {
            return;
        }

        int pivot = choosePivot(array,leftIndex,rightIndex);
        int index = partition(array,leftIndex,rightIndex,pivot);
        sort(array,leftIndex,index-1);
        sort(array,index,rightIndex);



    }

    /*
        Options
        - Choose first element **Not good!**
        - choose middle
        - Random
     */
    private int choosePivot(int[] array,int leftIndex, int rightIndex) {

        return array[leftIndex];
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private int partition(int[] array, int leftIndex, int rightIndex,int pivot) {
        while(leftIndex <= rightIndex) {
            while (array[leftIndex] < pivot) {
                leftIndex++;
            }

            while (array[rightIndex] > pivot) {
                rightIndex--;
            }

            if(leftIndex<=rightIndex) {
                swap(array,leftIndex,rightIndex);
                leftIndex++;
                rightIndex--;
            }
        }

        return leftIndex;
    }
}
