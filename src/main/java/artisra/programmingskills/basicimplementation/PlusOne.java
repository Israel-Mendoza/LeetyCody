package artisra.programmingskills.basicimplementation;

/**
 * A class for incrementing a large integer represented as an integer array.
 * @see <a href="https://leetcode.com/problems/plus-one/solutions/6017915/java-kotlin-best-solution-time-o-n-space-o-1-or-o-n">My Solution on LeetCode</a>
 */
public class PlusOne {
    /**
     * Increments a large integer represented as an integer array by one.
     *
     * @param digits The integer array representing the large integer.
     * @return The incremented integer array.
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        for (int i = 0; i < digits.length; i++) {
            result[i + 1] = digits[i];
        }
        return result;
    }
}
