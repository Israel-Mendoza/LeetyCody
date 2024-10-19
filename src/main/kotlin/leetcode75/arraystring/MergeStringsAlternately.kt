package dev.artisra.leetcode75.arraystring

// https://leetcode.com/problems/merge-strings-alternately/description/
// https://leetcode.com/problems/merge-strings-alternately/solutions/5934639/using-one-pointer-time-o-n-space-o-n-kotlin/

class MergeStringsAlternately {
    fun mergeAlternately(word1: String, word2: String): String {
        var index = 0
        val maxLength = maxOf(word1.length, word2.length)

        val result = buildString {
            while (index < maxLength) {
                if (index < word1.length) append(word1[index])
                if (index < word2.length) append(word2[index])
                index++
            }
        }

        return result
    }
}
