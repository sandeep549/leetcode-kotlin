package leetcode.kotlin.dp

fun main() {
    println(climbStairs(2))
}

// top-down using recursion
private fun climbStairs(n: Int): Int {
    val dp = IntArray(n + 1)
    fun ways(n: Int): Int {
        if (n == 0 || n == 1) return n
        if (n == 2) return 2
        if (dp[n] == 0) {
            dp[n] = ways(n - 1) + ways(n - 2)
        }
        return dp[n]
    }
    return ways(n)
}

// bottom-up
private fun climbStairs2(n: Int): Int {
    var a = 0 // ways to come at step 0
    var b = 1 // ways to come at step 1
    var c = 0 // keep track of ways to reach at every step
    for (i in 1..n) {
        c = a + b
        a = b
        b = c
    }
    return c
}
