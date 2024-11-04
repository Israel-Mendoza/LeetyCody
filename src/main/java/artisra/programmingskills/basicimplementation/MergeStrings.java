package artisra.programmingskills.basicimplementation;

/**
 * This class provides a solution to the problem of merging two strings alternately.
 * <p>
 * Given two strings, `word1` and `word2`, the `mergeAlternately` method merges them by
 * alternatively adding characters from each string to a new string. If one string is
 * longer than the other, the remaining characters of the longer string are appended
 * to the end of the merged string.
 */
public class MergeStrings {
    /**
     * Merges two strings alternately.
     *
     * @param word1 the first string
     * @param word2 the second string
     * @return the merged string
     */
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder(word1.length() + word2.length());

        int maxLength = Math.max(word1.length(), word2.length());

        for (int i = 0; i < maxLength; i++) {
            if (i < word1.length()) sb.append(word1.charAt(i));
            if (i < word2.length()) sb.append(word2.charAt(i));
        }

        return sb.toString();
    }
}
