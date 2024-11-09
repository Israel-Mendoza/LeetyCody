package artisra.programmingskills.basicimplementation;

import java.util.Arrays;

/**
 * Determines whether an array can be rearranged to form an arithmetic progression.
 * <p>
 * An arithmetic progression is a sequence of numbers such that the difference between any two consecutive  
 terms is the same.
 *
 * @see <a href="https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/solutions/6027954/java-kotlin-solution-sorting-the-array">My Solution on LeetCode</a>
 */
public class CanMakeArithmeticProgression {
    /**
     * Checks if the given array can be rearranged to form an arithmetic progression.
     *
     * @param arr the input array of integers
     * @return `true` if the array can be rearranged, `false` otherwise
     */
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int prev = arr[0];
        int diff = arr[1] - prev;

        for (int i = 1; i < arr.length; i++) {
            int currentNumber = arr[i];
            if (currentNumber - diff != prev) return false;
            prev = currentNumber;
        }

        return true;
    }
}
