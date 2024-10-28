package dev.artisra.topinterview150.hashmap

/**
 * A class for grouping anagrams in a given array of strings.
 *
 * Anagrams are words that contain the same characters, but in different orders.
 * This class efficiently groups anagrams together using a hash map.
 * @see <a href="https://leetcode.com/problems/group-anagrams/description/">Group Anagrams on LeetCode</a>
 */
class GroupAnagrams {

    /**
     * Groups anagrams in the given array of strings.
     *
     * @param words the array of strings to group
     * @return a list of lists, where each inner list contains anagrams
     */
    fun groupAnagrams(words: Array<String>): List<List<String>> {
        val anagramGroups = buildMap<String, MutableList<String>> {
            for (word in words) {
                val sortedWord = word.toSorted()
                val anagramList = this.getOrDefault(sortedWord, mutableListOf())
                anagramList.add(word)
                this[sortedWord] = anagramList
            }
        }

        return anagramGroups.values.toList()
    }

    companion object {

        /**
         * Sorts the characters of a string alphabetically.
         *
         * This helper function is used to create a unique identifier for each anagram group.
         *
         * @param this the string to sort
         * @return the sorted string
         */
        private fun String.toSorted(): String {
            val sortedChars = this.toCharArray()
            sortedChars.sort()
            return sortedChars.joinToString("")
        }
    }
}
