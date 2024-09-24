package dev.artisra.topinterview150.arraystring

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

class BestTimeToBuyAndSellStock {

    fun maxProfit(prices: IntArray): Int {
        var cheapestStock = prices[0]
        var maxProfit = 0

        for (price in prices) {
            if (price < cheapestStock) {
                cheapestStock = price
            } else if (price - cheapestStock > maxProfit) {
                maxProfit = price - cheapestStock
            }
        }

        return maxProfit
    }

    fun maxProfitShort(prices: IntArray): Int {
        var cheapestStock = prices[0]
        var maxProfit = 0

        for (price in prices) {
            // Updating cheapestStock if price < cheapestStock
            cheapestStock = cheapestStock.coerceAtMost(price)
            // Updating maxProfit if (price - cheapestStock) > maxProfit
            maxProfit = maxProfit.coerceAtLeast(price - cheapestStock)
        }

        return maxProfit
    }

}
