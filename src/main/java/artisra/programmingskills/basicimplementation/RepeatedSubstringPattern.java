package artisra.programmingskills.basicimplementation;

/**
 * This class provides a solution to the problem of determining whether a given string can be constructed by repeating a substring multiple times.
 * @see <a href="https://leetcode.com/problems/repeated-substring-pattern/solutions/6009828/time-o-n-2-still-better-than-83-java">My Solution on LeetCode</a>
 */
public class RepeatedSubstringPattern {
    /**
     * Checks if the given string can be constructed by repeating a substring multiple times.
     *
     * @param s the input string
     * @return true if the string is a repeated substring pattern, false otherwise
     */
    public boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i < (s.length() / 2) + 1; i++) {
            if (s.length() % i != 0) continue;
            String possibleSubstring = s.substring(0, i);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(possibleSubstring.repeat(s.length() / possibleSubstring.length()));
            if (stringBuilder.toString().equals(s)) return true;
        }
        return false;
    }
}
