package org.example.stanford;


/**
 * Master Method :
 *
 * a = 1 :: Number of Recursive calls | Search either lower or higher half of array
 * b = 2 :: Factor smaller than input. Half the size of original array. Thus 2.
 * d = 0 :: No work needed.
 *
 *  This puts us on case 1 since a = b^d => 1 = 2^0 => O(logn)
 */
public class BinarySearch {


    public int find(int[] nums, int leftIndex, int rightIndex,int target) {

        if(rightIndex >=1) {
            int mid = leftIndex + (rightIndex - 1) / 2;


            if (target == nums[mid]) {
                return mid;
            }
            if (target > nums[mid]) {
                return find(nums, mid+1,rightIndex,target);
            } else {
                return find(nums, leftIndex,mid-1,target);
            }
        }

        return Integer.MIN_VALUE;
    }
}
