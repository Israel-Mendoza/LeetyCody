package dev.artisra.topinterview150.twopointers

// https://leetcode.com/problems/valid-palindrome/description/
// https://leetcode.com/problems/valid-palindrome/solutions/5913905/two-pointers-time-o-n-space-o-n-kotlin/

class ValidPalindrome {
    fun isPalindrome(string: String): Boolean {
        val cleanString = string
            .filter { it.isLetterOrDigit() }
            .lowercase()

        // Using two pointers.
        var left = 0
        var right = cleanString.lastIndex

        while (left < right) {
            if (cleanString[left] != cleanString[right]) return false
            left++
            right--
        }

        return true
    }
}
