package dev.artisra.leetcode75.arraystring

/**
 * A class providing a solution to the "Can Place Flowers" problem.
 *
 * Given a flowerbed represented as an array of 0s and 1s (0 means empty, 1 means not empty),
 * determines if it's possible to plant a given number of new flowers without planting them
 * in adjacent plots.
 * @see <a href="https://leetcode.com/problems/can-place-flowers/description/">Can Place Flowers on LeetCode</a>
 */
class CanPlaceFlowers {

    /**
     * Checks if it's possible to plant a given number of flowers in the flowerbed.
     *
     * @param flowerbed An array representing the flowerbed, where 0 means empty and 1 means not empty.
     * @param n The number of flowers to plant.
     * @return `true` if it's possible to plant all `n` flowers, `false` otherwise.
     */
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        var flowersToPlant = n
        var justPlanted = false
        for (currentPlot in flowerbed) {
            when {
                currentPlot == 1 && justPlanted -> flowersToPlant++
                currentPlot == 1 -> justPlanted = true
                !justPlanted -> {
                    flowersToPlant--
                    justPlanted = true
                }

                else -> justPlanted = false
            }
        }
        return flowersToPlant <= 0
    }
}
