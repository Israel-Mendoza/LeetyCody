package dev.artisra.topinterview150.arraystring

// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description
// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/solutions/5890311/iterating-through-the-haystack-time-o-n-m-space-o-1-kotlin/

class FindIndexFirstOccurrenceInString {
    fun strStr(haystack: String, needle: String): Int {

        // Needle cannot be larger than the haystack
        if (needle.length > haystack.length) return -1

        // Test the needle in the starting substring (the current index of the haystack)
        for (i in haystack.indices) {
            if (needle[0] != haystack[i]) {
                continue
            }

            for (j in needle.indices) {
                if (j + i >= haystack.length) return -1 // We've reached the end of the haystack
                if (haystack[j + i] != needle[j]) break
                if (j == needle.length - 1) return i // We've found the last end of the needle
            }
        }
        return -1
    }
}
