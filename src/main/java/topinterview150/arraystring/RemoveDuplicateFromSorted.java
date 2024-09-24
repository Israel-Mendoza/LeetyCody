package topinterview150.arraystring;

/*
https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class RemoveDuplicateFromSorted {

    /*
    A simple solution that keeps track when a duplicate is found, and inserts a singular element
    in that position. We take advantage of the fact that the array is sorted.
    The returning value is an integer 'k' which represents the number of unique values.
     */
    public static int removeDuplicateFromSortedArrays(int[] nums) {
        // Because one of the constraints indicates that the integer will contain at minimum 1 element
        int unique = 1;
        int indexAvailable = 1;
        for (int n = 1; n < nums.length; n++) {
            if (nums[n] > nums[n-1]){
                nums[indexAvailable] = nums[n];
                indexAvailable++;
                unique++;
            }
        }
        return unique;

    }
}
