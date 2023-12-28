package com.sk.todo

class Solution1531 {

    fun getLengthOfOptimalCompression(str: String, k: Int): Int {
        fun calcLen(len: Int): Int {
            return when {
                len == 0 -> 0
                len == 1 -> 1
                len < 10 -> 2
                len < 100 -> 3
                else -> 4
            }
        }

        val N = str.length
        val dp = Array(N) {
            Array(26) {
                Array(N + 1) {
                    IntArray(
                        k + 1
                    ) { Int.MAX_VALUE }
                }
            }
        }

        fun solve(i: Int, ch: Int, len: Int, k: Int): Int {
            val space = StringBuilder()
            repeat(i) {space.append(" ")}
            println("$space -> i=$i, ch=${'a' + ch} , len=$len, k=$k, dp= ${dp.println(i,ch,len,k)}")

            if (i == str.length) return calcLen(len)
            if (dp[i][ch][len][k] == Int.MAX_VALUE) {
                if (k > 0) dp[i][ch][len][k] = solve(i + 1, ch, len, k - 1)
                val c = str[i] - 'a'
                if (c == ch) {
                    dp[i][ch][len][k] = minOf(dp[i][ch][len][k], solve(i + 1, ch, len + 1, k))
                } else {
                    dp[i][ch][len][k] = minOf(dp[i][ch][len][k], calcLen(len) + solve(i + 1, c, 1, k))
                }
            }
            println("$space <- i=$i, ch=${'a' + ch} , len=$len, k=$k, dp= ${dp.println(i,ch,len,k)}")
            return dp[i][ch][len][k]
        }

        return solve(0, 0, 0, k)
    }
}

fun main() {
    val s = Solution1531()
    println(s.getLengthOfOptimalCompression("aaabbaa", 2))
}

private fun Array<Array<Array<IntArray>>>.println(i: Int, ch: Int, len: Int, k: Int): String {
    return if (i== this.size) "${calcLen(len)}" else "${this[i][ch][len][k]}"
}

fun calcLen(len: Int): Int {
    return when {
        len == 0 -> 0
        len == 1 -> 1
        len < 10 -> 2
        len < 100 -> 3
        else -> 4
    }
}


class Solution1531_2 {
    private fun xs(x: Int): Int {
        return when {
            x == 1 -> 0
            x < 10 -> 1
            x < 100 -> 2
            else -> 3
        }
    }
    fun getLengthOfOptimalCompression(s: String, k: Int): Int {
        val N = 127
        val dp = Array(N) { IntArray(N) { -1 } }
        val str = s
        val n = s.length

        fun solve(left: Int, k: Int): Int {
            if (k < 0) return N
            if (left >= n || n - left <= k) return 0
            var res = dp[left][k]
            if (res != -1) return res
            res = N
            val cnt = IntArray(26)

            for (j in left until n) {
                var most = 0
                cnt[str[j] - 'a']++
                most = cnt[str[j] - 'a']
                res = minOf(res, 1 + xs(most) + solve(j + 1, k - (j - left + 1 - most)))
            }
            return res
        }

        return solve(0, k)
    }
}

