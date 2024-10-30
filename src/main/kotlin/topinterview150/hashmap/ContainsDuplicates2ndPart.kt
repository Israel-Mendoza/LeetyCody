package dev.artisra.topinterview150.hashmap

import kotlin.math.abs

/**
 * This class provides a solution to the "Contains Duplicate II" problem on LeetCode.
 *
 * Given an integer array `nums` and an integer `k`, this class determines whether there are two distinct indices `i` and `j` in the array such that `nums[i] == nums[j]` and `abs(i - j) <= k`.
 * @see <a href="https://leetcode.com/problems/contains-duplicate-ii/solutions/5985066/java-kotlin-time-o-n-space-o-n"> My solution on LeetCode </a>
 */
class ContainsDuplicates2ndPart {
    /**
     * Checks if there are two distinct indices `i` and `j` in the array `nums` such that `nums[i] == nums[j]` and `abs(i - j) <= k`.
     *
     * @param nums The input integer array.
     * @param k The maximum distance between the two indices.
     * @return `true` if such a pair of indices exists, `false` otherwise.
     */
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        // Map to store each value, and the last index it appeared at.
        val valueToIndex = mutableMapOf<Int, Int>()

        nums.forEachIndexed { i, value ->
            if (value in valueToIndex) {
                if (abs(i - valueToIndex[value]!!) <= k) return true
            }
            // Updating the index in the map.
            valueToIndex[value] = i
        }
        return false
    }
}
