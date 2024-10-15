package dev.artisra.topinterview150.twopointers

// https://leetcode.com/problems/is-subsequence/description/
// https://leetcode.com/problems/is-subsequence/solutions/5913973/using-two-pointers-one-per-string-time-o-n-space-o-1-kotlin/

class IsSubsequence {
    fun isSubsequence(possibleSubstring: String, originalString: String): Boolean {
        if (possibleSubstring.length > originalString.length) return false // Substring can't be shorter.
        if (possibleSubstring.isEmpty()) return true // Empty substring is a substring.
        if (possibleSubstring == originalString) return true // Equal string is considered a valid substring.

        // Using two pointers.
        var substringPointer = 0
        var originalStringPointer = 0

        // Loop iterates through the original string.
        while (originalStringPointer < originalString.length) {
            if (possibleSubstring[substringPointer] == originalString[originalStringPointer]) {
                if (++substringPointer == possibleSubstring.length) return true // Reached last substring's character.
            }
            originalStringPointer++
        }
        return false
    }
}
