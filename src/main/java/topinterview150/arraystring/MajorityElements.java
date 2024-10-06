package topinterview150.arraystring;
// https://leetcode.com/problems/majority-element/description/?envType=study-plan-v2&envId=top-interview-150

import java.util.HashMap;
import java.util.Map;

/**
 * A method that finds the majority element by looping through the array and keeping track of the occurrences
 * a number is found in the array (in a dictionary-hash).
 * We check if the number is present in the hash, if it is, we add 1, otherwise, we start the counter at 1.
 * Return the maximum value within the set.
 */
public class MajorityElements {
    public static int findMajorityElement(int[] numbers) {
        Map<Integer, Integer> numberCount = new HashMap<>();
        for (int num : numbers) {
            if (numberCount.containsKey(num)) {
                numberCount.put(num, numberCount.get(num) + 1);
            } else {
                numberCount.put(num, 1);
            }
        }
        return findMaxValueInSet(numberCount);

    }

    public static int findMaxValueInSet(Map<Integer, Integer> numberSet) {
        int maxCount = 0;
        int mostFrequent = 0;

        for (Map.Entry<Integer, Integer> numberAndCount: numberSet.entrySet()) {
            if (numberAndCount.getValue() > maxCount) {
                maxCount = numberAndCount.getValue();
                mostFrequent = numberAndCount.getKey();
            }
        }
        return mostFrequent;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        int output = findMajorityElement(nums);
        System.out.println(output);
    }
}
