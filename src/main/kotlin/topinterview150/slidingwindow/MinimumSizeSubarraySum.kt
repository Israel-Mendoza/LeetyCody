package dev.artisra.topinterview150.slidingwindow

// https://leetcode.com/problems/minimum-size-subarray-sum/description/
// https://leetcode.com/problems/minimum-size-subarray-sum/solutions/5934882/two-pointers-time-o-n-space-o-1-kotlin/

class MinimumSizeSubarraySum {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        if (nums[0] >= target) return 1
        var minLength = nums.size
        var currentSum = nums[0]


        // Using two pointers
        var left = 0
        var right = 1

        while (right < nums.size) {
            if (nums[right] >= target) return 1
            // Updating the current sum
            currentSum += nums[right]

            while (currentSum - nums[left] >= target) {
                currentSum -= nums[left]
                left++
            }

            if (currentSum >= target) {
                minLength = minLength.coerceAtMost(getSubStringSize(left, right))
            }

            right++
        }

        return if (minLength == nums.size && currentSum < target) {
            0
        } else {
            minLength
        }
    }

    private fun getSubStringSize(leftIndex: Int, rightIndex: Int) = rightIndex - leftIndex + 1
}
