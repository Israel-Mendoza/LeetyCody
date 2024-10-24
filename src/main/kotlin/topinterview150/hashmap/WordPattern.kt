package dev.artisra.topinterview150.hashmap

// https://leetcode.com/problems/word-pattern/description/
// https://leetcode.com/problems/word-pattern/solutions/5960787/using-a-map-and-a-set-time-and-space-o-n-kotlin/

class WordPattern {
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
