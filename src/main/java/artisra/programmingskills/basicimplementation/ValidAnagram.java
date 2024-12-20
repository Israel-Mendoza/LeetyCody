package artisra.programmingskills.basicimplementation;

/**
 * This class provides a solution to determine if two strings are anagrams of each other.
 * <p>
 * Given two strings, `s` and `t`, the `isAnagram` method checks if `t` can be formed by rearranging the characters of `s`.
 */
public class ValidAnagram {

    private static final int CHAR_POSITION_OFFSET = 97;

    /**
     * Determines if two strings are anagrams.
     * <p>
     * This method first checks if the lengths of the two strings are equal.
     * If not, they cannot be anagrams.
     * <p>
     * It then calculates the frequency of each character in `s` using an integer array.
     * For each character in `t`, it decrements the corresponding frequency in the array.
     * If a frequency becomes negative, it means `t` contains more of that character than `s`,
     * indicating they are not anagrams.
     *
     * @param s the first string
     * @param t the second string
     * @return `true` if `t` is an anagram of `s`, `false` otherwise
     */
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;

        int[] sFrequency = getCharFrequency(s);
        for (int i = 0; i < t.length(); i++) {
            boolean charDidNotExist = reduceCharFrequency(sFrequency, t.charAt(i));
            if (charDidNotExist) return false;
        }
        return true;
    }

    /**
     * Decrements the frequency of a character in the frequency array.
     * <p>
     * This method calculates the position of the character in the alphabet and decrements its frequency.
     * It returns `true` if the frequency becomes negative, indicating the character was not found in `s`.
     *
     * @param charFrequency the frequency array
     * @param c the character to decrement
     * @return `true` if the character was not found in `s`, `false` otherwise
     */
    private boolean reduceCharFrequency(int[] charFrequency, char c) {
        int positionInAlphabet = charPositionInAlphabet(c);
        return --charFrequency[positionInAlphabet] < 0;
    }

    /**
     * Calculates the frequency of each character in a string.
     * <p>
     * This method creates an integer array of size 26 to store the frequency of each lowercase letter.
     * It iterates through the string, incrementing the corresponding index in the array for each character.
     *
     * @param s the input string
     * @return an integer array representing the character frequencies
     */
    private int[] getCharFrequency(String s) {
        int[] charFrequency = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            int charPosition = charPositionInAlphabet(currentChar);
            charFrequency[charPosition]++;
        }
        return charFrequency;
    }

    /**
     * Calculates the position of a character in the alphabet.
     * <p>
     * This method assumes lowercase letters and calculates the position by subtracting the ASCII value of 'a'.
     *
     * @param c the character to calculate the position for
     * @return the position of the character in the alphabet
     */
    private static int charPositionInAlphabet(char c) {
        return c - CHAR_POSITION_OFFSET;
    }
}
