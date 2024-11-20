package com.sk.set26

class Solution2601 {
    fun primeSubOperation(nums: IntArray): Boolean {
        val maxNum = nums.maxOrNull() ?: return false
        val primes = generatePrimes(maxNum)

        var previous = 0
        for (num in nums) {
            var newNum = num
            for (prime in primes) {
                if (num - prime > previous) {
                    newNum = num - prime
                } else {
                    break
                }
            }
            if (newNum <= previous) return false
            previous = newNum
        }
        return true
    }

    private fun generatePrimes(maxNum: Int): List<Int> {
        val isPrime = BooleanArray(maxNum + 1) { true }
        val primes = mutableListOf<Int>()

        for (i in 2..maxNum) {
            if (isPrime[i]) {
                primes.add(i)
                for (j in 2 * i..maxNum step i) {
                    isPrime[j] = false
                }
            }
        }
        return primes
    }
}