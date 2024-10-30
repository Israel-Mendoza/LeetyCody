package dev.artisra.topinterview150.hashmap

/**
 * This class provides a solution to the problem of finding the longest consecutive sequence in an unsorted array of integers.
 * It implements an efficient algorithm with a time complexity of O(N) and a space complexity of O(N).
 * @see <a href="https://leetcode.com/problems/longest-consecutive-sequence/solutions/5987937/java-kotlin-time-o-n-space-o-n">My Solution on LeetCode.</a>
 */
class LongestConsecutiveSequence {
    /**
     * Finds the length of the longest consecutive sequence in the given array of integers.
     *
     * @param nums the input array of integers
     * @return the length of the longest consecutive sequence
     */
    fun longestConsecutive(nums: IntArray): Int {
        val availableNumbers = nums.toMutableSet()
        var longestSeqSize = 0

        for (num in nums) {
            if (availableNumbers.isEmpty()) break // No more numbers to check

            var currentNumber = num

            if (currentNumber !in availableNumbers) continue // This number and its sequence has been processed.

            var currentSeqSize = 1

            // Checking for sequence downwards.
            while (--currentNumber in availableNumbers) {
                currentSeqSize++
                availableNumbers.remove(currentNumber)
            }
            currentNumber = num

            // Checking for sequence upwards.
            while (++currentNumber in availableNumbers) {
                currentSeqSize++
                availableNumbers.remove(currentNumber)
            }
            availableNumbers.remove(num)
            longestSeqSize = longestSeqSize.coerceAtLeast(currentSeqSize)
        }

        return longestSeqSize
    }
}
