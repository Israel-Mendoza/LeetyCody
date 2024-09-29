package topinterview150.arraystring;

import java.util.Arrays;

/*
https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class RemoveDuplicatesFromSortedArrayII {

    /**
     * This solution returns k, which represents the number of distinct numbers in a duplicated array.
     * Unlike the previous problem (RemoveDuplicatesFromSorted), this method allows for at least 1 duplicate of each
     * number.
     * Notice that the original array must be modified in place.
     * @param nums: [int]. A sorted (non-decreasing) array of integers. Can't be empty.
     * @return k: An integer. Number of 'distinct' values.
     */

    public int removeDuplicates(int[] nums) {
        int k = 1;
        int indexAvailable = 1;
        int lastAddedNumber = nums[0]; // To keep track of the last digit added
        // Keeps track of a duplicate found and the necessity to change the next item
        boolean mustChange = false;

        for (int n = 1; n < nums.length; n++) {
            if (nums[n] > lastAddedNumber){
                nums[indexAvailable] = nums[n];
                lastAddedNumber = nums[n];
                mustChange = false;
                indexAvailable++;
                k++;
            } else if (nums[n] == lastAddedNumber && !mustChange) {
                // The next two lines may seem redundant, but they're in fact needed to avoid issues when smaller numbers
                // are pushed further into the array.
                nums[indexAvailable] = nums[n];
                lastAddedNumber = nums[n];
                mustChange = true;
                indexAvailable++;
                k++;
            }
        }

        return k;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        RemoveDuplicatesFromSortedArrayII remove = new RemoveDuplicatesFromSortedArrayII();
        remove.removeDuplicates(nums);
        Arrays.stream(nums).boxed().forEach(System.out::println);
    }
}
