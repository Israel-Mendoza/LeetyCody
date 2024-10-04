package dev.artisra.topinterview150.arraystring

// https://leetcode.com/problems/gas-station/description
// https://leetcode.com/problems/gas-station/solutions/5866909/resetting-starting-point-time-o-n-space-o-1-kotlin/

class GasStation {
    /**
     * Finds the starting gas station index to complete a circular route.
     *
     * @param gas   An array representing the amount of gas at each station.
     * @param cost  An array representing the cost to travel from one station to the next.
     * @return The index of the starting gas station if a solution exists; otherwise, -1.
     */
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        // Checking if the solution is valid:
        if (gas.sum() - cost.sum() < 0) return -1

        var gasMeter = 0 // Total gas available in tank
        var startingPoint = 0 // Index of the valid starting point

        for (i in gas.indices) {
            gasMeter += gas[i] - cost[i]
            // If the gas meter goes below zero, we reset the gas meter and update the new starting point.
            if (gasMeter < 0) {
                gasMeter = 0
                startingPoint = i + 1
            }
        }

        return startingPoint
    }
}
