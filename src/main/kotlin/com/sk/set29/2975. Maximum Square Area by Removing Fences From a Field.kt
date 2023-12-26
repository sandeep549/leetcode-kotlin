package com.sk.set29

import kotlin.math.abs


class Solution2975 {
    fun maximizeSquareArea(
        m: Int, n: Int, hFences: IntArray, vFences: IntArray
    ): Int {
        vFences.sort()
        hFences.sort()
        val X = mutableListOf<Int>()
        X.add(0)
        for(x in vFences) X.add(x-1)
        X.add(n-1)

        val Y = mutableListOf<Int>()
        Y.add(m-1)
        for(i in hFences.reversed()) { Y.add(i-1) }
        Y.add(0)
        Y.reverse()

        var ans = 0
        for(x in X.indices) {
            for(y in Y.indices) {
                // x,y is starting point
                var i = x
                var j = y
                while(i < X.size && j < Y.size) {
                    val width = X[i] - X[x]
                    val height = Y[j] - Y[y]
                    if(width == height) {
                        ans = maxOf(ans, width * height)
                    }
                    when {
                        width < height && i < X.size-1 -> i++
                        height < width && j < Y.size-1 -> j++
                        else -> {
                            i++
                            j++
                        }
                    }
                }
            }
        }
        return if(ans == 0) -1 else ans
    }

    fun maximizeSquareArea2(
        m: Int, n: Int, hFences: IntArray, vFences: IntArray
    ): Int {
        var ans = 0L
        val mod: Long = 1000_000_007
        val stripe = mutableSetOf<Int>()

        val horizontal = IntArray(hFences.size+2)
        hFences.copyInto(horizontal, 0, 0, hFences.size)
        horizontal[hFences.size] = 1
        horizontal[hFences.size+1] = m

        val vertical = IntArray(vFences.size+2)
        vFences.copyInto(vertical, 0, 0, vFences.size)
        vertical[vFences.size] = 1
        vertical[vFences.size+1] = n

        for (i in horizontal.indices) {
            for (j in horizontal.indices) {
                if (i != j) stripe.add(abs(horizontal[i] - horizontal[j]))
            }
        }

        for (i in vertical.indices) {
            for (j in vertical.indices) {
                if (stripe.contains(abs(vertical[i] - vertical[j]))) {
                    ans = maxOf(ans, abs(vertical[i] - vertical[j]).toLong())
                }
            }
        }
        return if (ans == 0L) -1 else (ans * ans % mod).toInt()
    }
}