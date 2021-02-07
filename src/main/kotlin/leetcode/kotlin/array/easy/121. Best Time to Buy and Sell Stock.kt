package leetcode.kotlin.array.easy

import kotlin.math.max
import kotlin.math.min

fun main() {
    check(maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)) == 5)
    check(maxProfit(intArrayOf(7, 6, 4, 3, 1)) == 0)

    check(maxProfit3(intArrayOf(7, 1, 5, 3, 6, 4)) == 5)
    check(maxProfit3(intArrayOf(7, 6, 4, 3, 1)) == 0)

    check(maxProfit4(intArrayOf(7, 1, 5, 3, 6, 4)) == 5)
    check(maxProfit4(intArrayOf(7, 6, 4, 3, 1)) == 0)
}

/**
 * Try with buy stock on each day and check the profit if we sell it on
 * every right side of it, retaining max profit found so far
 */
private fun maxProfit(prices: IntArray): Int {
    var max = 0
    for (i in 0 until prices.lastIndex) {
        for (j in i + 1 until prices.lastIndex + 1) {
            (prices[j] - prices[i]).run {
                if (this > max) max = this
            }
        }
    }
    return max
}


/**
 * Iterate from left to right, try selling at every point retaining max profit found so far,
 * and min found so far.
 */
private fun maxProfit3(arr: IntArray): Int {
    var min_price_so_far = arr[0]
    var max_profit_so_far = 0
    for (i in 1..arr.lastIndex) {
        max_profit_so_far = max(max_profit_so_far, arr[i] - min_price_so_far)
        min_price_so_far = min(min_price_so_far, arr[i])
    }
    return max_profit_so_far
}

/**
 * Iterate from left to right, maintain 2 variables min price found so far and max profit found so far.
 */
private fun maxProfit4(arr: IntArray): Int {
    var min_price_so_far = arr[0]
    var max_profit_so_far = 0
    for (i in 1..arr.lastIndex) {
        if (arr[i] < min_price_so_far) {
            min_price_so_far = arr[i]
        } else if (arr[i] - min_price_so_far > max_profit_so_far) {
            max_profit_so_far = arr[i] - min_price_so_far
        }
    }
    return max_profit_so_far
}
