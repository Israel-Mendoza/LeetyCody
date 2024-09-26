package dev.artisra.topinterview150.arraystring

// https://leetcode.com/problems/rotate-array/description/

class RotateArray {
    fun rotateLongSolution(nums: IntArray, k: Int) {
        // Bad solution. Time complexity = O(k * n)

        // Arrays with a single elements or empty arrays won't change.
        if (nums.isEmpty() || nums.size == 1) return

        repeat(k) {
            // Grabbing the last item, to add it to the start of the array.
            val poppedItem = nums.last()
            // Moving all of the items in the array one step rightward.
            for (i in nums.size - 2 downTo 0) {
                nums[i + 1] = nums[i]
            }
            // Recovering the last item:
            nums[0] = poppedItem
        }
    }

    /**
     * Rotates the elements in the specified array to the right by the specified number of steps.
     *
     * @param nums the array to be rotated
     * @param k    the number of steps to rotate the array to the right
     */
    fun rotate(nums: IntArray, k: Int) {
        // Better solution. Time complexity = O(2n) -> O(n)

        // Arrays with a single elements or empty arrays won't change.
        if (nums.isEmpty() || nums.size == 1) return

        // Eliminating rotation overflow.
        val cleanK = k % nums.size

        var startIndex = 0
        val endIndex = nums.size - cleanK - 1

        // Rotating the first part of the array.
        reverseItemsInArray(nums, startIndex, endIndex)

        // Rotating the second part of the array.
        startIndex = nums.size - cleanK
        reverseItemsInArray(nums, startIndex)

        // Rotate the whole array.
        reverseItemsInArray(nums)
    }

    /**
     * Reverses the order of elements in the specified array between the given start and end indices.
     *
     * @param nums        the array to be reversed
     * @param startIndex  the start index of the range to be reversed (inclusive)
     * @param endIndex    the end index of the range to be reversed (inclusive)
     * @throws IllegalArgumentException if the {@code startIndex} is greater than the {@code endIndex} or if the
     *                                  {@code startIndex} or {@code endIndex} is out of bounds for the array
     */
    private fun reverseItemsInArray(
        nums: IntArray,
        startIndex: Int = 0,
        endIndex: Int = nums.size - 1,
    ) {
        var leftPointer = startIndex
        var rightPointer = endIndex

        while (leftPointer < rightPointer) {
            val tempNum = nums[leftPointer]
            nums[leftPointer] = nums[rightPointer]
            nums[rightPointer] = tempNum
            leftPointer++
            rightPointer--
        }
    }
}