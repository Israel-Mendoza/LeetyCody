package artisra.topinterview150.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * This class provides functionality to check if two strings are anagrams of each other.
 * An anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 * @see <a href="https://leetcode.com/problems/valid-anagram/solutions/5965502/single-hashmap-time-o-n-space-o-n-o-1-java-kotlin/">My Solution on LeetCode.</a>
 */
public class ValidAnagram {
    /**
     * Determines whether two given strings are anagrams of each other.
     *
     * @param s the first string to check
     * @param t the second string to check
     * @return true if the strings are anagrams, false otherwise
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> availableLetters = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            availableLetters.merge(currentChar, 1, Integer::sum);
        }

        for (int i = 0; i < t.length(); i++) {
            char currentChar = t.charAt(i);
            if (!availableLetters.containsKey(currentChar)) {
                return false;
            }

            decreaseCharCountInMap(availableLetters, currentChar);
        }

        return availableLetters.isEmpty();
    }

    /**
     * Decreases the count of a character in the given map by 1.
     * If the count becomes zero, the character is removed from the map.
     *
     * @param map the map containing character counts
     * @param key the character whose count should be decreased
     */
    private void decreaseCharCountInMap(Map<Character, Integer> map, char key) {
        if (!map.containsKey(key)) return;
        map.put(key, map.get(key) - 1);
        if (map.get(key) == 0) {
            map.remove(key);
        }
    }
}
