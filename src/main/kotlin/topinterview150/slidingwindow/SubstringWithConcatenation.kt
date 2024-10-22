package dev.artisra.topinterview150.slidingwindow

// https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/

class SubstringWithConcatenation {
    fun findSubstring(s: String, words: Array<String>): List<Int> {
        // TODO: This implementation does not work when the words array contains duplicates
        val result = mutableListOf<Int>()
        val wordLength = words[0].length
        val concatenatedStringLength = words.size * wordLength
        var a = 0

        while (a < s.length - concatenatedStringLength) {
            val wordsSet = words.toMutableList()
            var m = a
            while (m < a + concatenatedStringLength) {
                var n = m
                while (n - m < wordLength) n++
                val currentSubstring = s.substring(m until n)
                if (currentSubstring !in wordsSet) {
                    a = if (a == m) n else m
                    break
                }
                wordsSet.remove(currentSubstring)

                if (wordsSet.isEmpty()) {
                    result.add(a)
                    a += wordLength
                    break
                }

                m = n
            }
        }
        return result
    }
}
