package leetcode.kotlin

private fun uniquePaths(m: Int, n: Int): Int {
    val arr = Array(m) { IntArray(n) }
    arr[0][0] = 1
    fun ways(i: Int, j: Int): Int {
        return if (i < 0 || i >= m || j < 0 || j >= n) 0 else arr[i][j]
    }
    for (r in 0 until m) {
        for (c in 0 until n) {
            if (r == 0 && c == 0) continue
            arr[r][c] = ways(r - 1, c) + ways(r, c - 1)
        }
    }
    return arr[m - 1][n - 1]
}
