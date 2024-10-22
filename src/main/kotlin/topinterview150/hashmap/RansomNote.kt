package dev.artisra.topinterview150.hashmap

// https://leetcode.com/problems/ransom-note/description/
// https://leetcode.com/problems/ransom-note/solutions/5950242/hash-map-with-count-of-characters-time-o-m-n-space-o-1-kotlin/

class RansomNote {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val lettersPool = mutableMapOf<Char, Int>()

        // Populating the map
        magazine.forEach {
            lettersPool[it] = lettersPool.getOrDefault(it, 0) + 1
        }

        // Taking from the map to build the ransom note
        ransomNote.forEach {
            if (it !in lettersPool || lettersPool[it]!! == 0) return false
            lettersPool[it] = lettersPool[it]!! - 1
        }

        return true
    }
}
