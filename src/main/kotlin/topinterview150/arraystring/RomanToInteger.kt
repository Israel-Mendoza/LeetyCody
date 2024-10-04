package dev.artisra.topinterview150.arraystring

// https://leetcode.com/problems/roman-to-integer/description
// https://leetcode.com/problems/roman-to-integer/solutions/5867152/running-backwards-time-o-n-space-o-1-kotlin/

class RomanToInteger {
    /**
     * Converts a Roman numeral string to its corresponding integer value.
     *
     * @param romanNumber the Roman numeral string to convert
     * @return the corresponding integer value
     */
    fun romanToInt(romanNumber: String): Int {
        var previous = romanNumber.last().romanToInt()
        var result = previous

        for (i in romanNumber.length - 2 downTo 0) {
            val currentCharValue = romanNumber[i].romanToInt()
            if (currentCharValue < previous) {
                result -= currentCharValue
            } else {
                result += currentCharValue
            }
            previous = currentCharValue
        }
        return result
    }

    /**
     * Converts a single Roman numeral character to its corresponding integer value.
     *
     * @return the integer value of the character, or 0 if the character is not a valid Roman numeral
     */
    private fun Char.romanToInt() = when (this) {
        'M' -> 1000
        'D' -> 500
        'C' -> 100
        'L' -> 50
        'X' -> 10
        'V' -> 5
        'I' -> 1
        else -> 0
    }
}
