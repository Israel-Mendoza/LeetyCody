package dev.artisra.topinterview150.twopointers

// https://leetcode.com/problems/3sum/description/
// https://leetcode.com/problems/3sum/solutions/5923673/using-nested-loop-and-two-pointers-time-o-n-2-space-o-n-kotlin/

class ThreeSum {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val results = mutableSetOf<List<Int>>()

        for (i in nums.indices.take(nums.size - 2)) {
            if (i > 0 && nums[i] == nums[i - 1]) continue // No need to check the same numbers again
            val x = nums[i]
            var yIndex = i + 1
            var zIndex = nums.lastIndex
            while (yIndex < zIndex) {
                val y = nums[yIndex]
                val z = nums[zIndex]
                val total = x + y + z
                when {
                    total < 0 -> yIndex++
                    total > 0 -> zIndex--
                    else -> {
                        results.add(listOf(x, y, z))
                        yIndex++
                        zIndex--
                    }
                }
            }
        }
        return results.toList()
    }
}
