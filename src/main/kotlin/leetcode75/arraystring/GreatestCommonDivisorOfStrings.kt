package dev.artisra.leetcode75.arraystring

class GreatestCommonDivisorOfStrings {

    fun gcdOfStrings(str1: String, str2: String): String {
        if (str1 + str2 != str2 + str1) return ""
        val length = gcd(str1.length, str2.length)
        return str1.substring(0 until length)
    }

    private fun gcd(a: Int, b: Int): Int {
        var x = a
        var y = b
        while (y != 0) x = y.also { y = x % y }
        return x
    }
}