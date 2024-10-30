package artisra.topinterview150.hashmap;

import java.util.HashSet;
import java.util.Set;

/**
 * This class provides a solution to the problem of finding the longest consecutive sequence in an unsorted array of integers.
 * It implements an efficient algorithm with a time complexity of O(N) and a space complexity of O(N).
 * @see <a href="https://leetcode.com/problems/longest-consecutive-sequence/solutions/5987937/java-kotlin-time-o-n-space-o-n">My Solution on LeetCode.</a>
 */
public class LongestConsecutiveSequence {
    /**
     * Finds the length of the longest consecutive sequence in the given array of integers.
     *
     * @param nums the input array of integers
     * @return the length of the longest consecutive sequence
     */
    public int longestConsecutive(int[] nums) {

        // Storing all the numbers ina hashset.
        Set<Integer> availableNumbers = new HashSet<>() {{
            for (int num : nums) add(num);
        }};

        int longestSeqSize = 0;

        for (int num : nums) {
            if (availableNumbers.isEmpty()) break; // No more items to process.
            int currentNumber = num;
            if (!availableNumbers.contains(currentNumber))
                continue; // This number and its sequence have been processed.

            int seqSize = 1;

            while (availableNumbers.contains(--currentNumber)) {
                seqSize++;
                availableNumbers.remove(currentNumber);
            }

            currentNumber = num;
            while (availableNumbers.contains(++currentNumber)) {
                seqSize++;
                availableNumbers.remove(currentNumber);
            }

            availableNumbers.remove(num);
            if (seqSize > longestSeqSize) longestSeqSize = seqSize;
        }

        return longestSeqSize;
    }
}
