package dev.artisra.topinterview150.arraystring

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/

class BestTimeToBuyAndSellStock2ndPart {
    fun maxProfit(prices: IntArray): Int {

        // Keep track of current lowest price, max profit, and profit history.
        var buyPrice = prices[0]
        var maxProfit = 0
        var profitHistory = 0

        // While having profit, updating maxProfit.
        // If there's no profit in a given day, selling the current stock and buying new one.
        for (price in prices) {
            val todayProfit = price - buyPrice
            when {
                maxProfit < todayProfit -> { // Keeping stock
                    maxProfit = todayProfit
                    continue
                }

                maxProfit != 0 -> { // Selling stock
                    profitHistory += maxProfit
                    maxProfit = 0
                }
            }
            buyPrice = price
        }

        profitHistory += maxProfit

        return profitHistory
    }
}
