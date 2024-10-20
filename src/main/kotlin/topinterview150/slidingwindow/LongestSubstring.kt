package dev.artisra.topinterview150.slidingwindow

// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
// https://leetcode.com/problems/longest-substring-without-repeating-characters/solutions/5940748/sliding-window-with-a-hash-set-time-o-n-space-o-1-kotlin/

class LongestSubstring {
    fun lengthOfLongestSubstring(str: String): Int {
        val seenChars = mutableSetOf<Char>()
        var maxLength = 0
        var leftIndex = 0

        for (rightIndex in str.indices) {
            val rightValue = str[rightIndex]
            while (rightValue in seenChars) {
                seenChars.remove(str[leftIndex])
                leftIndex++
            }
            maxLength = maxLength.coerceAtLeast(rightIndex - leftIndex + 1)
            seenChars.add(rightValue)
        }

        return maxLength
    }
}
