package dev.artisra.topinterview150.hashmap

// https://leetcode.com/problems/two-sum/description/
// https://leetcode.com/problems/two-sum/solutions/5929132/33ms-using-a-hashmap-time-o-n-space-o-n/

class TwoSum {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        // Key: Number Value: Index
        val visitedNumbers = mutableMapOf<Int, Int>()
        for (i in numbers.indices) {
            val diff = target - numbers[i]
            if (diff in visitedNumbers) {
                return intArrayOf(i, visitedNumbers[diff]!!)
            }
            visitedNumbers[numbers[i]] = i
        }
        return intArrayOf()
    }
}
