package org.example.stanford;

/**
 *  Q1 from https://www.coursera.org/learn/algorithms-divide-conquer/supplement/Geunn/optional-theory-problems-batch-1
 *  http://users.csc.calpoly.edu/~dekhtyar/349-Spring2010/lectures/lec03.349.pdf
 *  https://stackoverflow.com/questions/9889679/find-second-largest-number-in-array-at-most-nlog₂n%E2%88%922-comparisons
 *
 */
public class SecondLargestElement {


    /*
        Master Method
     */
    public int findMax(int[] array, int startIndex,int endIndex) {
        if(startIndex==endIndex) {
            return array[startIndex];
        }

        int max1 = findMax(array,startIndex,startIndex+(endIndex-startIndex)/2);
        int max2 = findMax(array,1+startIndex+(endIndex-startIndex)/2,endIndex);

        return Math.max(max1,max2);
    }

    public int[] findMaxTournament(int[] array, int startIndex,int endIndex, int length) {
        if(startIndex==endIndex) {
            int[] comparedArray = new int[2];
            comparedArray[0] = 1;
            comparedArray[1] = array[startIndex];
            return comparedArray;
        }

        int[] comparedArray1 = findMaxTournament(array,startIndex,startIndex+(endIndex-startIndex)/2,array.length);
        int[] comparedArray2 = findMaxTournament(array,startIndex,1+startIndex+(endIndex-startIndex)/2,array.length);

        if(comparedArray1[1] > comparedArray2[1]) {
            int k = comparedArray1[0] + 1;
            int[] newcompared1 = new int[k];
            System.arraycopy(comparedArray1, 0, newcompared1, 0, comparedArray1[0]);
            newcompared1[0] = k;
            newcompared1[k-1] = comparedArray2[1];
            return newcompared1;
        }
        int k = comparedArray2[0] + 1;
        int[] newcompared2 = new int[k];
        System.arraycopy(comparedArray2, 0, newcompared2, 0, comparedArray2[0]);
        newcompared2[0] = k;
        newcompared2[k-1] = comparedArray1[1];
        return newcompared2;
    }

    public int findSecondRecursive(int n, int[] A){
        int[] firstCompared = findMaxTournament(0, n-1, A); //n-1 comparisons;
        int[] secondCompared = findMaxTournament(2, firstCompared[0]-1, firstCompared); //log2(n)-1 comparisons.
        //Total comparisons: n+log2(n)-2;
        return secondCompared[1];
    }

    private static int[] findMaxTournament(int low, int high, int[] A){
        if(low == high){
            int[] compared = new int[2];
            compared[0] = 2;
            compared[1] = A[low];
            return compared;
        }
        int[] compared1 = findMaxTournament(low, (low+high)/2, A);
        int[] compared2 = findMaxTournament((low+high)/2+1, high, A);
        if(compared1[1] > compared2[1]){
            int k = compared1[0] + 1;
            int[] newcompared1 = new int[k];
            System.arraycopy(compared1, 0, newcompared1, 0, compared1[0]);
            newcompared1[0] = k;
            newcompared1[k-1] = compared2[1];
            return newcompared1;
        }
        int k = compared2[0] + 1;
        int[] newcompared2 = new int[k];
        System.arraycopy(compared2, 0, newcompared2, 0, compared2[0]);
        newcompared2[0] = k;
        newcompared2[k-1] = compared1[1];
        return newcompared2;
    }

}
