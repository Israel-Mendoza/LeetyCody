package dev.artisra.topinterview150.arraystring

// https://leetcode.com/problems/jump-game/description/

class JumpGame {
    fun canJump(nums: IntArray): Boolean {

        if (nums.isEmpty() || nums.size < 2) return true

        // Starting from the last index.
        var goal = nums.size - 1

        // Iterating from the last index.
        // Updating goal if we can jump to it from nums[i].
        for (i in nums.indices.reversed()) {
            val possibleJumps = nums[i]
            if (possibleJumps + i >= goal) goal = i
        }

        return goal == 0
    }
}