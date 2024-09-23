package topinterview150.arraystring;

/*
https://leetcode.com/problems/remove-element/description/?envType=study-plan-v2&envId=top-interview-150
 */

import java.util.Arrays;

public class RemoveElement {
    /**
     * Simple solution using built in methods.
     * @param nums: An array of integers
     * @param val: The element to remove from the array
     * @return int: the number of valid elements inside the array after removal
     */
    public static int removeElement(int[] nums, int val) {
        if (nums == null) {
            return 0;
        }
        Arrays.setAll(nums, i -> nums[i] == val ? Integer.MAX_VALUE : nums[i]);
        int validElements = (int) Arrays.stream(nums)
                .filter(i -> i == Integer.MAX_VALUE)
                .count();
        return validElements;
    }

    /*
    Simple solution using a for loop.
    Inside the for loop, we move the valid elements to the front of the array.
     */
    public static int removeElement2(int[] nums, int val) {
        int index = 0;
        int k = 0;
        for (int num : nums) {
            if (num != val) {
                nums[index] = num;
                k++;
                index++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3,2,2,3};
        int val = 3;
        int result = removeElement2(nums, val);
        System.out.println(result);
    }
}