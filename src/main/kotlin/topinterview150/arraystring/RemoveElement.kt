package dev.artisra.topinterview150.arraystring

// https://leetcode.com/problems/remove-element/description/

class RemoveElement {
    fun removeElement(nums: IntArray, value: Int): Int {

        if (nums.isEmpty()) return 0 // There is nothing to remove from

        // Creating variables for pointers and remove count:
        var leftPointer = 0
        var rightPointer = nums.size
        var removeCount = 0

        // "Removing" from the end of the array
        while (true) {
            rightPointer--
            if (rightPointer < 0 || nums[rightPointer] != value) break
            removeCount++
        }

        // Moving the pointers towards each other:
        while (leftPointer <= rightPointer) {
            if (nums[leftPointer] == value) { // We've found a number to remove
                // Storing a valid number in the place of a value to remove:
                nums[leftPointer] = nums[rightPointer] // Right pointer will always be different from the value
                removeCount++

                // Moving the right pointer to a number different from the value
                while (true) {
                    rightPointer--
                    if (rightPointer < 0 || nums[rightPointer] != value) break
                    removeCount++
                }
            }
            leftPointer++
        }

        return nums.size - removeCount
    }
}