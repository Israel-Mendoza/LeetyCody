package dev.artisra.topinterview150.twopointers

// https://leetcode.com/problems/container-with-most-water/description/
// https://leetcode.com/problems/container-with-most-water/solutions/5919267/two-pointers-and-a-max-area-holder-time-o-n-space-o-1-kotlin/

/**
 * This class provides a solution to the container with most water problem.
 *
 * Given an integer array representing the heights of vertical lines, this class
 * finds two lines that, together with the x-axis, form a container that holds the
 * maximum amount of water.
 */
class ContainerWithMostWater {
    /**
     * Calculates the maximum amount of water a container can hold.
     *
     * @param heights an integer array representing the heights of vertical lines.
     * @return the maximum amount of water a container can hold.
     */
    fun maxArea(heights: IntArray): Int {
        // Using two pointers
        var left = 0
        var right = heights.lastIndex
        // Keeping track of the maximum water in container
        var maxWater = 0

        while (left < right) {
            val waterInContainer = calculateWater(left, heights[left], right, heights[right])
            maxWater = maxWater.coerceAtLeast(waterInContainer)
            // Moving the shortest pointer
            if (heights[left] <= heights[right]) {
                left++
            } else {
                right--
            }
        }

        return maxWater
    }

    /**
     * Calculates the area of a container formed by two vertical lines.
     *
     * @param x the index of the left line.
     * @param xHeight the height of the left line.
     * @param y the index of the right line.
     * @param yHeight the height of the right line.
     * @return the area of the container.
     */
    private fun calculateWater(
        x: Int,
        xHeight: Int,
        y: Int,
        yHeight: Int,
    ) = minOf(xHeight, yHeight) * (y - x)
}
