package artisra.programmingskills.basicimplementation;

/**
 * This class provides a solution to the problem of finding the first occurrence of a needle string within a haystack string.
 * @see <a href="https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/solutions/6009748/iterating-through-the-haystack-once-time-o-mn-space-o-1-java">My Solution on LeetCode</a>
 */
public class FindIndexOfFirstOccurrence {
    /**
     * Finds the first occurrence of the needle string within the haystack string.
     *
     * @param haystack the string to be searched
     * @param needle   the string to be found
     * @return the index of the first occurrence of the needle in the haystack, or -1 if not found
     */
    public int strStr(String haystack, String needle) {
        // If the needle is longer than the haystack, it's impossible to find a match.
        if (needle.length() > haystack.length()) return -1;
        // If the needle and haystack are of equal length, we can directly compare them.
        if (needle.length() == haystack.length()) {
            if (needle.equals(haystack)) {
                return 0;
            } else {
                return -1;
            }
        }

        // Iterate through the haystack, considering each character as a potential starting point.
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            char currentChar = haystack.charAt(i);
            if (currentChar != needle.charAt(0)) continue;
            boolean matches = false;
            for (int j = 0; j < needle.length(); j++) {
                if (needle.charAt(j) == haystack.charAt(i + j)) {
                    matches = true;
                } else {
                    matches = false;
                    break;
                }
            }
            if (matches) return i;
        }
        // If no match is found after iterating through the entire haystack, return -1.
        return -1;
    }
}
