package artisra.leetcode75.arraystring;

/**
 * This class provides a solution to the "Can Place Flowers" problem on LeetCode.
 * <p>
 * Given a flowerbed represented as an array of 0s and 1s, where 0 means an empty plot and 1 means a planted flower,
 * determine if it's possible to plant a given number of new flowers without violating the rule that flowers cannot be planted
 * in adjacent plots.
 *
 * @see <a href="https://leetcode.com/problems/can-place-flowers/description/">Can Place Flowers on LeetCode</a>
 */
public class CanPlaceFlowers {

    /**
     * Determines if it's possible to plant a given number of flowers in the flowerbed.
     *
     * @param flowerBed      The array representing the flowerbed, where 0 means empty and 1 means planted.
     * @param flowersToPlant The number of flowers to plant.
     * @return `true` if it's possible to plant the flowers, `false` otherwise.
     */
    public boolean canPlaceFlowers(int[] flowerBed, int flowersToPlant) {
        boolean wasJustPlanted = false;

        for (int currentPlot : flowerBed) {
            if (currentPlot == 1 && wasJustPlanted) {
                flowersToPlant++;
            } else if (currentPlot == 1) {
                wasJustPlanted = true;
            } else if (!wasJustPlanted) {
                flowersToPlant--;
                wasJustPlanted = true;
            } else {
                wasJustPlanted = false;
            }
        }

        return flowersToPlant <= 0;
    }
}
