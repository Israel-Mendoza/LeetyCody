package artisra.programmingskills.basicimplementation;


/**
 * This class provides a method to determine the sign of the product of an array of integers.
 * @see <a href="https://leetcode.com/problems/sign-of-the-product-of-an-array/solutions/6021867/best-than-100-in-java-kotlin-time-o-n-space-o-1/">My Solution on LeetCode</a>
 */
public class SignOfProduct {
    /**
     * Calculates the sign of the product of an array of integers.
     *
     * @param nums the array of integers
     * @return 1 if the product is positive, -1 if the product is negative, and 0 if the product is zero
     */
    public int arraySign(int[] nums) {
        int negativeCount = 0;
        for (int currentNumber : nums) {
            if (currentNumber == 0) return 0;
            if (currentNumber < 0) negativeCount++;
        }
        return negativeCount % 2 == 0 ? 1 : -1;
    }
}
