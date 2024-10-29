package artisra.topinterview150.hashmap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A class to determine if a number is a happy number.
 *
 * A happy number is defined by the following process:
 * 1. Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * 2. Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * 3. Those numbers for which this process ends in 1 are happy.
 * @see <a href="https://leetcode.com/problems/group-anagrams/description/">Happy Number on LeetCode</a>
 */
public class HappyNumber {

    /**
     * Determines if the given number is a happy number.
     *
     * @param n the number to check
     * @return true if the number is happy, false otherwise
     */
    public boolean isHappy(int n) {
        Set<Integer> seenNumbers = new HashSet<>();
        while (n != 1) {
            n = sumOfSquares(numberToDigits(n));
            if (seenNumbers.contains(n)) {
                return false; // Cycle detected, not a happy number
            }
            seenNumbers.add(n);
        }
        return true; // Reached 1, a happy number
    }

    /**
     * Converts a number to a list of its digits.
     *
     * @param n the number to convert
     * @return a list of the digits of the number
     */
    private static List<Integer> numberToDigits(int n) {
        List<Integer> digits = new ArrayList<>();
        for (char c : String.valueOf(n).toCharArray()) {
            int number = Integer.parseInt(String.valueOf(c));
            digits.add(number);
        }
        return digits;
    }

    /**
     * Calculates the sum of the squares of a list of numbers.
     *
     * @param numbers the list of numbers
     * @return the sum of the squares of the numbers
     */
    private static int sumOfSquares(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number * number;
        }
        return sum;
    }
}
