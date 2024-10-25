package artisra.topinterview150.hashmap;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/valid-anagram/solutions/5965502/single-hashmap-time-o-n-space-o-n-o-1-java-kotlin/

public class ValidAnagram {
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

    private void decreaseCharCountInMap(Map<Character, Integer> map, char key) {
        map.put(key, map.get(key) - 1);
        if (map.get(key) == 0) {
            map.remove(key);
        }
    }
}
