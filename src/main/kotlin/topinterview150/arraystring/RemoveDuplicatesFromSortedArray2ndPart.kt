package dev.artisra.topinterview150.arraystring

// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/

class RemoveDuplicatesFromSortedArray2ndPart {
    fun removeDuplicates(nums: IntArray): Int {

        // There are zero "distinct" items in an empty array
        if (nums.isEmpty()) return 0

        // Creating available index pointer, repeated number tracker, and number in array counter
        var nextAvailableIndex = 1
        var lastAddedNumber = nums[0] to true // Read as "X, is allowed to add one more"
        var newArraySize = 1

        for (i in 1..<nums.size) {
            val currentNumber = nums[i]
            if (currentNumber > lastAddedNumber.first) {
                nums[nextAvailableIndex] = currentNumber
                nextAvailableIndex++
                lastAddedNumber = currentNumber to true // New number, will allow to add another number
                newArraySize++
            } else if (currentNumber == lastAddedNumber.first && lastAddedNumber.second) {
                nums[nextAvailableIndex] = currentNumber
                nextAvailableIndex++
                lastAddedNumber = currentNumber to false // No new number, won't allow to add another number
                newArraySize++
            }
        }
        return newArraySize
    }
}
