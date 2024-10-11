package dev.artisra.topinterview150.arraystring

// https://leetcode.com/problems/reverse-words-in-a-string/description/
// https://leetcode.com/problems/reverse-words-in-a-string/solutions/5897991/iterating-through-the-string-and-using-two-pointers-time-o-n-space-o-n-kotlin/

class ReverseWordsInString {
    fun reverseWords(sentence: String): String {

        // Using two pointers to traverse through the string.
        var firstPointer = sentence.lastIndex
        var secondPointer = sentence.length

        // A StringBuilder to store the result.
        val sb = StringBuilder()

        while (firstPointer >= 0) {
            if (sentence[firstPointer] == ' ' || firstPointer == 0) { // We've found a word delimiter
                val substring = sentence.substring(firstPointer, secondPointer).trim()
                if (substring.isNotBlank()) {
                    sb.append("$substring ")
                    secondPointer = firstPointer
                }
            }
            firstPointer--
        }

        return sb.toString().trim()
    }
}