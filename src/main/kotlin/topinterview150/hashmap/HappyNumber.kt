package dev.artisra.topinterview150.hashmap

/**
 * A class to determine if a number is a happy number.
 *
 * A happy number is a number defined by the following process:
 * 1. Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * 2. Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * 3. Those numbers for which this process ends in 1 are happy.
 * @see <a href="https://leetcode.com/problems/happy-number/description/"> Happy Number on LeetCode</a>
 */
class HappyNumber {

    /**
     * Determines if the given number is a happy number.
     *
     * @param n the number to check
     * @return `true` if `n` is a happy number, `false` otherwise
     */
    fun isHappy(n: Int): Boolean {
        var number = n
        val digits = mutableSetOf<Int>()
        while (number != 1) {
            number = number.toDigitsList().sumOf { it * it }
            if (number in digits) return false // Cycle detected, not a happy number
            digits.add(number)
        }
        return true // Reached 1, a happy number
    }

    /**
     * Converts an integer to a list of its digits.
     *
     * @return a list of digits of the integer
     */
    private fun Int.toDigitsList() = this.toString().toCharArray().map { it.digitToInt() }
}
