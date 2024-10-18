package dev.artisra.topinterview150.twopointers

// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/solutions/5929178/using-two-pointers-time-o-n-space-o-1-kotlin/

class TwoSum2ndPart {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var left = 0
        var right = numbers.lastIndex

        while (left < right) {
            val currentSum = numbers[left] + numbers[right]
            when {
                currentSum < target -> left++
                currentSum > target -> right--
                else -> return intArrayOf(left + 1, right + 1)
            }
        }

        return intArrayOf()
    }
}
