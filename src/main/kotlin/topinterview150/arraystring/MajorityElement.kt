package dev.artisra.topinterview150.arraystring

// https://leetcode.com/problems/majority-element/description/

class MajorityElement {

    /**
     * Using a map to store the numbers and their occurrences.
     */
    fun majorityElement(nums: IntArray): Int {

        // Map, storing the numbers and their occurrences:
        val occurrencesMap = mutableMapOf<Int, Int>()

        // Iterating through the array and storing each number's occurrences in the map:
        for (number in nums) {
            if (number in occurrencesMap) {
                val currentCount = occurrencesMap[number]!!
                occurrencesMap[number] = currentCount + 1
            } else {
                occurrencesMap[number] = 1
            }
        }

        return occurrencesMap.maxBy { it.value }.key
    }

    /**
     * Using the Boyer-Moore majority vote algorithm.
     * See https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm
     * This only works when the number with whe most appearances occurs more than half of the time.
     */
    fun majorityElementV2(nums: IntArray): Int {
        var element: Int? = null
        var count = 0

        for (i in nums.indices) {
            val currentItem = nums[i]
            if (count == 0) {
                element = currentItem
                count = 1
            } else if (currentItem == element) {
                count++
            } else {
                count--
            }
        }
        return element!!
    }
}