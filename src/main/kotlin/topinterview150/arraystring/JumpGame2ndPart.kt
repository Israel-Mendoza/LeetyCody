package dev.artisra.topinterview150.arraystring

// https://leetcode.com/problems/jump-game-ii/description/

class JumpGame2ndPart {

    fun jump(nums: IntArray): Int {
        // No need to jump.
        if (nums.size < 2) return 0

        // Variables to traverse through the array.
        var currentIndex = nums.size - 1
        var lowestOriginIndex = nums.size - 1
        var totalJumps = 0

        // As long as we haven't reached the start of the array...
        while (currentIndex != 0) {
            // Looking for the lowest index we can jump from to the current index.
            for (i in currentIndex downTo 0) {
                if (nums[i] + i >= currentIndex) {
                    lowestOriginIndex = i
                }
            }
            // Update the current index and increase the number of jumps.
            currentIndex = lowestOriginIndex
            totalJumps++
        }

        return totalJumps
    }
}