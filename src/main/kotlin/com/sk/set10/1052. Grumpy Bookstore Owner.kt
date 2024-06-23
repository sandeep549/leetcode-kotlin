package com.sk.set10

class Solution1052 {
    fun maxSatisfied(customers: IntArray, grumpy: IntArray, minutes: Int): Int {
        var l = 0
        var windowMax = 0 // lost customer in current window
        while (l < minutes) {
            windowMax += if (grumpy[l] == 1) customers[l] else 0
            l++
        }

        var r = l
        l = 0
        var maxUnhappy = windowMax // max lost customer when owner is grumpy in window
        while (r < customers.size) {
            var m = if (grumpy[r] == 1) customers[r] else 0
            m -= if (grumpy[l] == 1) customers[l] else 0
            windowMax += m
            maxUnhappy = maxOf(maxUnhappy, windowMax)
            r++
            l++
        }

        val happyCustomers = customers.foldIndexed(0) { index: Int, acc: Int, customer: Int ->
            acc + if (grumpy[index] == 0) customer else 0
        }

        return happyCustomers + maxUnhappy
    }
}