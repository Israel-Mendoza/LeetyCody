package dev.artisra.leetcode75.arraystring

// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/description/
// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/solutions/5900825/using-map-time-o-n-space-o-n-kotlin/

class KidsWithTheGreatestNumberOfCandies {
    fun kidsWithCandiesProcedural(candies: IntArray, extraCandies: Int): List<Boolean> {
        val result = mutableListOf<Boolean>()
        val max = candies.max()

        for (candy in candies) {
            val totalCandies = candy + extraCandies
            result.add(totalCandies >= max)
        }
        return result
    }

    fun kidsWithCandiesFunctional(candies: IntArray, extraCandies: Int): List<Boolean> {
        val max = candies.max()
        return candies.map { it + extraCandies >= max }
    }
}
