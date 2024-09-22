package dev.artisra.topinterview150.arraystring

// https://leetcode.com/problems/merge-sorted-array/description/

class MergeSortedArray {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {

        if (n == 0) return // There is nothing to merge

        // Keeping track of the numbers to merge on both arrays
        var nums1Pointer = m - 1
        var nums2Pointer = n - 1

        // Iterating throught the nums1 array, from the last index to the first:
        for (i in (m + n - 1) downTo 0) {

            // Checking if we've exhausted the numbers to merge on either array:
            if (nums1Pointer < 0) {
                nums1[i] = nums2[nums2Pointer]
                nums2Pointer--
                continue
            }
            if (nums2Pointer < 0) {
                nums1[i] = nums1[nums1Pointer]
                nums1Pointer--
                continue
            }

            // Get the current maximun number from both arrays (arrays are ordered):
            val nums1Number = nums1[nums1Pointer]
            val nums2Number = nums2[nums2Pointer]

            // Compare the numbers and set the i index in nums1 with the max number:
            if (nums1Number >= nums2Number) {
                nums1[i] = nums1Number
                nums1Pointer--
            } else {
                nums1[i] = nums2Number
                nums2Pointer--
            }
        }
    }
}
