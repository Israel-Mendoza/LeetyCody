package topinterview150.arraystring;

import java.util.Arrays;

/*
https://leetcode.com/problems/merge-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing
the number of elements in nums1 and nums2 respectively.
Merge nums1 and nums2 into a single array sorted in non-decreasing order.
The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 */


public class MergeSortedArray {
    /**
     * Simple solution. Combine the arrays, then sort.
     */
    public void solution(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    /**
     * A solution that uses the same merge step in the merge sort algorithm.
     */
    public void solution2(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, m, n);
            return;
        }
        int pointerNums1 = m - 1;
        int pointerNums2 = n - 1;
        for (int i = nums1.length - 1; i >= 0; i--) {
            if (pointerNums2 < 0) {
                break;
            }
            if (pointerNums1 < 0) {
                nums1[i] = nums2[pointerNums2];
                pointerNums2--;
            } else if (nums2[pointerNums2] > nums1[pointerNums1]) {
                nums1[i] = nums2[pointerNums2];
                pointerNums2--;
            } else {
                nums1[i] = nums1[pointerNums1];
                pointerNums1--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0 ,0};
        int[] nums2 = {2, 5, 6};
        int m = 3, n = 3;
        MergeSortedArray sort = new MergeSortedArray();
        sort.solution2(nums1, m, nums2, n);
        Arrays.stream(nums1).forEach(System.out::print);
    }
}
