package dev.artisra

import dev.artisra.easy.isPalindrome
import dev.artisra.easy.twoSum

fun main() {
    val number = 12233221
    val result = isPalindrome(number)
    println("$number is${if (result) "" else " NOT"} a palindrome number")
}