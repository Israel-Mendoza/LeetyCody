package dev.artisra.topinterview150.arraystring

// https://leetcode.com/problems/remove-element/description/

class RemoveElement {
    fun removeElement(numbers: IntArray, value: Int): Int {
        var availableIndex = 0

        for (number in numbers) {
            if (number != value) {
                numbers[availableIndex] = number
                availableIndex++
            }
        }
        return availableIndex
    }
}
