package artisra.programmingskills.basicimplementation;

/**
 * This class provides a method to move all zeros to the end of an integer array.
 * @see <a href="https://leetcode.com/problems/move-zeroes/solutions/6014323/java-in-7-lines-time-o-n-space-o-1/">My Solution on LeetCode</a>
 */
public class MoveZeroes {
    /**
     * Moves all zeros to the end of the given integer array `nums` while maintaining the relative order of the non-zero elements.
     * <p>
     * This method operates in-place, modifying the input array directly.
     *
     * @param nums the integer array to be modified
     */
    public void moveZeroes(int[] nums) {
        int availableSpot = 0;
        while (nums[availableSpot] != 0 && availableSpot < nums.length - 1) availableSpot++;

        for (int i = availableSpot + 1; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[availableSpot] = nums[i];
                nums[i] = 0;
                availableSpot++;
            }
        }
    }
}
