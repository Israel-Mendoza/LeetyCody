package artisra.programmingskills.basicimplementation;

/**
 * A class for determining if an array is monotonic.
 * <p>
 * An array is monotonic if it is either monotone increasing or monotone decreasing.
 * @see <a href="https://leetcode.com/problems/monotonic-array/solutions/6036141/java-kotlin-time-o-n-space-o-1">My Solution on LeetCode</a>
 */
public class MonotonicArray {
    /**
     * Determines if the given integer array is monotonic.
     *
     * @param nums the integer array to check
     * @return `true` if the array is monotonic, `false` otherwise
     */
    public boolean isMonotonic(int[] nums) {
        boolean isAsc = true;
        boolean isDesc = true;

        int previous = nums[0];

        for (int num : nums) {
            if (num > previous) {
                isDesc = false;
            } else if (num < previous) {
                isAsc = false;
            }

            if (!isAsc && !isDesc) {
                return false;
            }
            previous = num;
        }

        return true;
    }
}
