package dev.artisra.topinterview150.hashmap

// https://leetcode.com/problems/isomorphic-strings/description/
// https://leetcode.com/problems/isomorphic-strings/solutions/5955911/using-two-maps-time-o-n-space-1-kotlin/

class IsomorphicStrings {
    fun isIsomorphic(s: String, t: String): Boolean {
        if (s.length != t.length) return false // Different length strings are not isomorphic

        // Using a couple of hash maps
        val (sMap, tMap) = getCharMappings(s, t)

        for (i in s.indices) {
            // Existing maps must correspond to other
            if (sMap[s[i]] != t[i] || tMap[t[i]] != s[i]) return false
        }

        return true
    }

    companion object {
        fun getCharMappings(s: String, t: String): Pair<Map<Char, Char>, Map<Char, Char>> {

            val sMap = mutableMapOf<Char, Char>()
            val tMap = mutableMapOf<Char, Char>()

            if (s.length == t.length) {
                for (i in s.indices) {
                    // Populating the maps if the entries don't exist.
                    if (s[i] !in sMap && t[i] !in tMap) {
                        sMap[s[i]] = t[i]
                        tMap[t[i]] = s[i]
                    }
                }
            }

            return sMap to tMap
        }
    }
}
