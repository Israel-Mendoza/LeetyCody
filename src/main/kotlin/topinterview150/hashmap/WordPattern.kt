package dev.artisra.topinterview150.hashmap

/**
 * This class provides a solution to the Word Pattern matching problem.
 *
 * Given a pattern and a string, it determines whether the string follows the pattern.
 * A pattern follows a string if there is a one-to-one mapping between letters in the pattern
 * and non-empty words in the string.
 * @see <a href="https://leetcode.com/problems/word-pattern/solutions/5960787/using-a-map-and-a-set-time-and-space-o-n-kotlin/">My Solution on LeetCode</a>
 */
class WordPattern {
    /**
     * Checks if a given string follows a specified pattern.
     *
     * @param pattern The pattern string.
     * @param s The input string.
     * @return `true` if the string follows the pattern, `false` otherwise.
     */
    fun wordPattern(pattern: String, s: String): Boolean {
        val words = s.split(" ")
        if (pattern.length != words.size) return false
        val mainMap = mutableMapOf<Char, String>()
        val seenWords = mutableSetOf<String>()

        for (i in pattern.indices) {
            val currentChar = pattern[i]
            val currentWord = words[i]

            if (currentChar in mainMap) {
                if (mainMap[currentChar] != currentWord) return false
                continue
            }

            if (currentWord in seenWords) return false

            mainMap[currentChar] = currentWord
            seenWords.add(currentWord)
        }

        return true
    }
}
