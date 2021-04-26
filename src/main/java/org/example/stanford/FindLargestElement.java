package org.example.stanford;

/**
 *
 *  Just documenting how to find the largest element. This is a sub problem of SecondLargestElement
 *
 *  Q1 from https://www.coursera.org/learn/algorithms-divide-conquer/supplement/Geunn/optional-theory-problems-batch-1
 *  http://users.csc.calpoly.edu/~dekhtyar/349-Spring2010/lectures/lec03.349.pdf
 *  https://stackoverflow.com/questions/9889679/find-second-largest-number-in-array-at-most-nlog₂n%E2%88%922-comparisons
 *
 */
public class FindLargestElement {


    public int findMax(int[] array, int startIndex,int endIndex) {
        if(startIndex==endIndex) {
            return array[startIndex];
        }

        int max1 = findMax(array,startIndex,startIndex+(endIndex-startIndex)/2);
        int max2 = findMax(array,1+startIndex+(endIndex-startIndex)/2,endIndex);

        return Math.max(max1,max2);
    }
}
