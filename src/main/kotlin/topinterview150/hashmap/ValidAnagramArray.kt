package dev.artisra.topinterview150.hashmap

/**
 * This class provides a solution to determine if two strings are anagrams of each other.
 *
 * Given two strings, `s` and `t`, the `isAnagram` method checks if `t` can be formed by rearranging the characters of `s`.
 * @see <a href="https://leetcode.com/problems/valid-anagram/solutions/6007420/java-kotlin-time-o-n-space-o-1">My Solution on LeetCode</a>
 */
class ValidAnagramArray {
    /**
     * Determines if two strings are anagrams.
     *
     * This method calculates the frequency of each character in `s` using an integer array.
     * For each character in `t`, it decrements the corresponding frequency in the array.
     * If a frequency becomes negative, it means `t` contains more of that character than `s`,
     * indicating they are not anagrams.
     *
     * @param s the first string
     * @param t the second string
     * @return `true` if `t` is an anagram of `s`, `false` otherwise
     */
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false

        val frequency = s.getFrequencyArray()
        for (char in t) {
            val removed = frequency.decreaseCharFrequency(char)
            if (!removed) return false
        }
        return true
    }

    companion object {
        /**
         * Calculates the frequency of each character in a string.
         *
         * This method creates an integer array of size 26 to store the frequency of each lowercase letter.
         * It iterates through the string, incrementing the corresponding index in the array for each character.
         *
         * @return an integer array representing the character frequencies
         */
        private fun String.getFrequencyArray(): IntArray {
            val freqArray = IntArray(26)
            for (char in this) {
                freqArray[char.getAlphabetPosition()]++
            }
            return freqArray
        }
        /**
         * Decrements the frequency of a character in the frequency array.
         *
         * This method calculates the position of the character in the alphabet and decrements its frequency.
         * It returns `true` if the frequency is still non-negative, indicating the character was found in `s`.
         *
         * @param c the character to decrement
         * @return `true` if the character was found in `s`, `false` otherwise
         */
        private fun IntArray.decreaseCharFrequency(c: Char): Boolean {
            this[c.getAlphabetPosition()]--
            return this[c.getAlphabetPosition()] >= 0
        }
        /**
         * Calculates the position of a character in the alphabet.
         *
         * This method assumes lowercase letters and calculates the position by subtracting the ASCII value of 'a'.
         *
         * @return the position of the character in the alphabet
         */
        private fun Char.getAlphabetPosition() = this.code - 97
    }
}