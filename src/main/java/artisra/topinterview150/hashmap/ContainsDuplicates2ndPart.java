package artisra.topinterview150.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * This class provides a solution to the "Contains Duplicate II" problem on LeetCode.
 * <p>
 * Given an integer array `nums` and an integer `k`, this class determines whether there are two distinct indices `i` and `j` in the array such that `nums[i] == nums[j]` and `abs(i - j) <= k`.
 *
 * @see <a href="https://leetcode.com/problems/contains-duplicate-ii/solutions/5985066/java-kotlin-time-o-n-space-o-n"> My solution on LeetCode </a>
 */
public class ContainsDuplicates2ndPart {
    /**
     * Checks if there are two distinct indices `i` and `j` in the array `nums` such that `nums[i] == nums[j]` and `abs(i - j) <= k`.
     *
     * @param nums The input integer array.
     * @param k    The maximum distance between the two indices.
     * @return `true` if such a pair of indices exists, `false` otherwise.
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // Map to store each value, and the last index it appeared at.
        Map<Integer, Integer> valueToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int currentValue = nums[i];
            if (valueToIndex.containsKey(currentValue)) {
                int absoluteDiff = Math.abs(i - valueToIndex.get(currentValue));
                if (absoluteDiff <= k) return true;
            }
            // Updating the index in the map.
            valueToIndex.put(currentValue, i);
        }

        return false;
    }
}
