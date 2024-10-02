package dev.artisra.topinterview150.arraystring

// https://leetcode.com/problems/product-of-array-except-self/description/

/**
 *
 */
class ProductOfArrayExceptSelf {
    /**
     * Given an integer array {@code nums}, returns an array {@code answer}
     * such that {@code answer[i]} is equal to the product of all the elements of {@code nums} except {@code nums[i]}.
     *
     * The product of any prefix or suffix of {@code nums} is guaranteed to fit in a 32-bit integer.
     *
     * The algorithm runs in O(n) time and does not use the division operation.
     *
     * @param numbers the input array of integers
     * @return an array {@code answer} where {@code answer[i]} is the product of all the elements of {@code nums} except {@code nums[i]}
     */
    fun productExceptSelf(numbers: IntArray): IntArray {

        val leftAnswer = IntArray(numbers.size) { 1 }

        var left = 1
        var right = 1

        for (i in leftAnswer.indices) {
            leftAnswer[i] = left * if (i > 0) numbers[i - 1] else 1
            left = leftAnswer[i]
        }

        for (i in leftAnswer.indices.reversed()) {
            right *= if (i != numbers.size - 1) numbers[i + 1] else 1
            leftAnswer[i] = leftAnswer[i] * right
        }

        return leftAnswer
    }
}
