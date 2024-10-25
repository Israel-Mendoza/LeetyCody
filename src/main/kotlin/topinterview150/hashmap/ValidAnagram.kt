package dev.artisra.topinterview150.hashmap

// https://leetcode.com/problems/valid-anagram/description/
// https://leetcode.com/problems/valid-anagram/solutions/5965502/single-hashmap-time-o-n-space-o-n-o-1-java-kotlin/

class ValidAnagram {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false

        val availableLetters = mutableMapOf<Char, Int>()
        s.forEach {
            availableLetters[it] = availableLetters.getOrDefault(it, 0) + 1
        }

        for (char in t) {
            if (char !in availableLetters) return false
            availableLetters.decreaseCharEntry(char)
        }

        return true
    }

    private fun MutableMap<Char, Int>.decreaseCharEntry(key: Char) {
        this[key] = this[key]!! - 1
        if (this[key] == 0) this.remove(key)
    }
}
