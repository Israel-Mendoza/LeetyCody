package dev.artisra.topinterview150.arraystring

// https://leetcode.com/problems/longest-common-prefix/description
// https://leetcode.com/problems/longest-common-prefix/solutions/5884733/iterating-once-over-the-array-and-once-over-each-word-time-o-n-m-space-o-1-kotlin/

class LongestCommonPrefix {
    fun longestCommonPrefix(strings: Array<String>): String {
        var prefix = strings[0]

        for (stringsIndex in 1 until strings.size) {
            if (prefix.isEmpty()) return ""
            var lastMatchingIndex = 0

            val shorterWordLength = minOf(prefix.length, strings[stringsIndex].length)
            for (charIndex in 0 until shorterWordLength) {
                if (strings[stringsIndex][charIndex] != prefix[charIndex]) break
                lastMatchingIndex++
            }
            prefix = strings[stringsIndex].substring(0 until lastMatchingIndex)
        }

        return prefix
    }
}
