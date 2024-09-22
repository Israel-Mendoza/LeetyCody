package dev.artisra.topinterview150.arraystring

class RemoveDuplicatesFromSortedArray {
    fun removeDuplicates(nums: IntArray): Int {
        // There are 0 different items in an empty array
        if (nums.isEmpty()) return 0

        // Creating our pointer and tracker
        var availableIndex = 1 // Index to be filled
        var lastVisitedNumber = nums[0] // Last different number

        for (i in nums.indices) {
            val currentNumber = nums[i]
            if (currentNumber > lastVisitedNumber) {
                lastVisitedNumber = currentNumber
                nums[availableIndex] = currentNumber
                availableIndex++
            }
        }
        return availableIndex
    }
}
