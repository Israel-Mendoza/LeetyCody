package dev.artisra.topinterview150.arraystring

// https://leetcode.com/problems/zigzag-conversion/description/
// https://leetcode.com/problems/zigzag-conversion/solutions/5910019/using-stringbuilders-time-o-n-space-o-n-kotlin/

class ZigzagConversion {
    fun convert(string: String, numberOfRows: Int): String {

        if (numberOfRows == 1) return string // No need to zigzag.

        val stringBuilders = buildList {
            repeat(numberOfRows) {
                add(StringBuilder())
            }
        }
        var currentStringBuilder = 0
        var goingForward = true

        for (letter in string) {
            stringBuilders[currentStringBuilder].append(letter)

            // Toggle the direction of the string holders.
            if (currentStringBuilder == 0) goingForward = true
            if (currentStringBuilder == stringBuilders.lastIndex) goingForward = false

            // Moving the cursor to the next string holder.
            if (goingForward) {
                currentStringBuilder++
            } else {
                currentStringBuilder--
            }
        }

        // Building the final string.
        return stringBuilders[0].apply  {
            stringBuilders.drop(1).forEach {
                append(it.toString())
                it.clear() // No more need for this content.
            }
        }.toString()
    }
}