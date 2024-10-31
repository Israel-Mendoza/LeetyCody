package dev.artisra.topinterview150.hashmap

/**
 * This class provides functionality to check if two strings are anagrams of each other.
 * An anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 * @see <a href="https://leetcode.com/problems/valid-anagram/solutions/5965502/single-hashmap-time-o-n-space-o-n-o-1-java-kotlin/">My Solution on LeetCode.</a>
 */
class ValidAnagram {
    /**
     * Determines whether two given strings are anagrams of each other.
     *
     * @param s the first string to check
     * @param t the second string to check
     * @return true if the strings are anagrams, false otherwise
     */
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

    companion object {
        /**
         * Decreases the count of a character in the map by 1.
         * If the count becomes zero, the character is removed from the map.
         *
         * @param key the character whose count should be decreased
         */
        private fun MutableMap<Char, Int>.decreaseCharEntry(key: Char) {
            if (key !in this) return
            this[key] = this[key]!! - 1
            if (this[key] == 0) this.remove(key)
        }
    }
}
