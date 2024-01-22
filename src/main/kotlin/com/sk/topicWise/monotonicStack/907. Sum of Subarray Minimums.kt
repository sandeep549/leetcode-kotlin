package com.sk.topicWise.monotonicStack

import kotlin.math.abs

class Solution907 {

    fun sumSubarrayMins(arr: IntArray): Int {
        val MAX = 1_000_000_007
        val M = 3_000_1
        var ans = 0
        val dp = Array(arr.size) { IntArray(arr.size) { M } }

        for (i in arr.indices) {
            for (j in 0..i) {
                if (j == i) {
                    dp[j][i] = arr[i]
                } else {
                    dp[j][i] = minOf(dp[j][i - 1], arr[i])
                }
                ans = ((ans + dp[j][i]) % MAX).toInt()
                //println("j=$j, i=$i, min=${dp[j][i]}")
            }
        }

        return ans
    }

    fun sumSubarrayMins2(A: IntArray): Int {
        val stack = ArrayDeque<Int>()
        val dp = IntArray(A.size + 1)
        stack.addLast(-1)
        var result = 0
        val M = 1e9.toInt() + 7
        for (i in A.indices) {
            while (stack.last() != -1 && A[stack.last()] >= A[i] ) { // monotone increasing stack
                stack.removeLast()
            }
            dp[i + 1] = (dp[stack.last() + 1] + (i - stack.last()) * A[i]) % M
            stack.addLast(i)
            result += dp[i + 1]
            result %= M
        }
        return result
    }

    fun minimumPushes(word: String): Int {
        val list = word.groupBy { it }.map { it.value.size }
//        val arr = IntArray(26)
//        for(ch in word.toCharArray()) {
//            arr[ch-'a']++
//        }
//        val list = arr.sorted().reversed().toList()
        val q = list.size/8
        val r = list.size % 8
        var ans = 0
        for (i in 1..q) {
            ans += (i*8)
        }
        ans += (r*8)
        return ans
    }

    fun countOfPairs(n: Int, x: Int, y: Int): IntArray {
        val mat = Array(n+1) { IntArray(n+1) }
        for (i in 1.. mat.lastIndex) {
            for (j in 1.. mat[0].lastIndex) {
                mat[i][j] = abs(i-j)
                mat[j][i] = abs(i-j)
            }
        }

        mat[x][y] = 1
        mat[y][x] = 1
        for (i in 1..minOf(x, y)) {
            for (j in maxOf(x, y) .. n) {
                mat[i][j] = mat[i][j] - abs(x-y)
                mat[j][i] = mat[j][i] - abs(x-y)
            }
        }

        val ans = IntArray(n)
        for (i in 1.. mat.lastIndex) {
            for (j in 1.. mat[0].lastIndex) {
                ans[mat[i][j]-1]++
                ans[mat[j][i]-1]++
            }
        }
        return ans
    }
}
