package dev.artisra.topinterview150.arraystring

// https://leetcode.com/problems/length-of-last-word/description/
// https://leetcode.com/problems/length-of-last-word/solutions/5880399/iterating-through-the-string-backwards-until-space-is-found-time-o-n-space-o-1-kotlin/

class LengthOfLastWord {
    fun lengthOfLastWord(s: String): Int {
        var letterCounter = 0
        var hasFoundLetter = false // Flag to ignore trailing spaces

        // Iterating through the string backwards.
        for (i in s.indices.reversed()) {
            val currentChar = s[i]
            if (currentChar != ' ' && !hasFoundLetter) {
                hasFoundLetter = true // We have found the first last letter
            }

            if (hasFoundLetter && currentChar != ' ') {
                letterCounter++
            } else if (hasFoundLetter) {
                break
            }
        }

        return letterCounter
    }
}