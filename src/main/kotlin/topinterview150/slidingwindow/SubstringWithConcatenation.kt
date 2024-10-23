package dev.artisra.topinterview150.slidingwindow

// https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/

class SubstringWithConcatenation {
    fun findSubstring(str: String, words: Array<String>): List<Int> {

        val result = mutableListOf<Int>()
        val wordLength = words[0].length
        var a = 0

        while (a <= str.length - words.size * wordLength) {
            val wordsMap = words.createWordsHashMap()
            val currentWord = str.substring(a until a + wordLength)
            if (currentWord !in wordsMap) {
                a++
                continue
            }

            wordsMap.decreaseKey(currentWord) // Decreasing count of initial word
            if (wordsMap.isEmpty()) {
                result.add(a)
                break
            }

            var left = a + wordLength
            var right = left + wordLength
            while (true) {
                val nextWord = str.substring(left until right)
                if (nextWord !in wordsMap) {
                    break
                }

                wordsMap.decreaseKey(nextWord)
                if (wordsMap.isEmpty()) {
                    result.add(a)
                    break
                }
                left += wordLength
                right += wordLength
            }
            a++
        }
        return result
    }

    private fun Array<String>.createWordsHashMap(): MutableMap<String, Int> {
        val result = mutableMapOf<String, Int>()
        this.forEach {
            result.put(it, result.getOrDefault(it, 0) + 1)
        }
        return result
    }

    private fun MutableMap<String, Int>.decreaseKey(key: String) {
        val currentValue = this.getOrDefault(key, 0)
        if (currentValue > 1) {
            this[key] = currentValue - 1
        } else {
            this.remove(key)
        }
    }
}
