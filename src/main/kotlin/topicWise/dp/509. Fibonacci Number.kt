package topicWise.dp

// recursion
private fun fib(N: Int): Int {
    if (N == 0 || N == 1) return N
    return fib(N - 1) + fib(N - 2)
}

// dp, top-down
private fun fib2(N: Int): Int {
    val dp = IntArray(N + 1)
    fun recur(n: Int): Int {
        if (n == 0 || n == 1) return n
        if (dp[n] == 0) {
            dp[n] = recur(n - 1) + recur(n - 2)
        }
        return dp[n]
    }
    return recur(N)
}

// dp, bottom-up
private fun fib3(N: Int): Int {
    if (N == 0) return 0
    var a = 0
    var b = 1
    var c = 1
    for (i in 2..N) {
        c = a + b
        a = b
        b = c
    }
    return c
}
