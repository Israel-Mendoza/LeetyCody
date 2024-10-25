package dev.artisra.topinterview150.hashmap

// https://leetcode.com/problems/isomorphic-strings/description/
// https://leetcode.com/problems/isomorphic-strings/solutions/5955911/using-two-maps-time-o-n-space-1-kotlin/

class IsomorphicStrings {
    fun isIsomorphic(s: String, t: String): Boolean {
        if (s.length != t.length) return false // Different length strings are not isomorphic

        // Using a couple of hash maps
        val sMap = mutableMapOf<Char, Char>()
        val tSet = mutableSetOf<Char>()

        for (i in s.indices) {
            // Populating the maps if the entries don't exist.
            if (s[i] !in sMap) {
                if (t[i] in tSet) return false
                sMap[s[i]] = t[i]
                tSet.add(t[i])

            } else if (sMap[s[i]] != t[i]) {
                return false
            }

        }

        return true
    }
}
