package dev.artisra.topinterview150.arraystring

// https://leetcode.com/problems/integer-to-roman/description
// https://leetcode.com/problems/integer-to-roman/solutions/5872218/iteration-through-look-up-table-time-o-n-space-o-1-kotlin/

class IntegerToRoman {

    companion object {

        private val values = listOf(
            1000 to "M",
            900 to "CM",
            500 to "D",
            400 to "CD",
            100 to "C",
            90 to "XC",
            50 to "L",
            40 to "XL",
            10 to "X",
            9 to "IX",
            5 to "V",
            4 to "IV",
            1 to "I"
        )
    }

    fun intToRoman(number: Int): String {
        val sb = StringBuilder()
        var currentNumber = number
        var currentIndex = 0
        while (currentNumber > 0) {
            if (currentNumber >= values[currentIndex].first) {
                sb.append(values[currentIndex].second)
                currentNumber -= values[currentIndex].first
                continue
            }
            currentIndex++
        }
        return sb.toString()
    }
}
