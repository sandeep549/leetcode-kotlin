package com.sk.set27

class Solution2728 {
    fun countBeautifulPairs(nums: IntArray): Int {
        var pairs = 0
        for (i in nums.indices) {
            var n = nums[i]
            while (n >= 10) {
                n /= 10
            }
            for (j in i+1 until nums.size) {
                val d = nums[j] % 10
                pairs += if (gcd(n, d) == 1) 1 else 0
            }
        }
        return pairs
    }

    private fun gcd(x: Int, y: Int): Int {
        var x = x
        var y = y
        while (y != 0) {
            val tmp = x % y
            x = y
            y = tmp
        }
        return x
    }
}