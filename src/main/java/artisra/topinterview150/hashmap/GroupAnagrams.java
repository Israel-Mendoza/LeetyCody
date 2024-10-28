package artisra.topinterview150.hashmap;

import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * A class for grouping anagrams in a given array of strings.
 *
 * Anagrams are words that contain the same characters, but in a different order.
 * This class efficiently groups anagrams together using a HashMap.
 * @see <a href="https://leetcode.com/problems/group-anagrams/description/">Group Anagrams on LeetCode</a>
 */
public class GroupAnagrams {

    /**
     * Groups anagrams in the given array of strings.
     *
     * @param strings The array of strings to group.
     * @return A list of lists, where each inner list contains anagrams.
     */
    public List<List<String>> groupAnagrams(@NotNull String[] strings) {
        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String word : strings) {
            String sortedWord = sortString(word);
            if (anagramGroups.containsKey(sortedWord)) {
                anagramGroups.get(sortedWord).add(word);
            } else {
                anagramGroups.put(sortedWord, new ArrayList<>(){{add(word);}});
            }
        }

        return anagramGroups.values().stream().toList();
    }

    /**
     * Sorts the characters of a given string alphabetically.
     *
     * @param string The string to sort.
     * @return The sorted string.
     */
    private String sortString(String string) {
        char[] sortedChars = string.toCharArray();
        Arrays.sort(sortedChars);
        return new String(sortedChars);
    }
}
