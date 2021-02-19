package leetcode.kotlin

private fun numberOfArithmeticSlices(A: IntArray): Int {
    var count = 0
    for (s in 0 until A.size - 2) {
        val d = A[s + 1] - A[s]
        for (e in s + 2 until A.size) {
            if (A[e] - A[e - 1] == d) count++ else break
        }
    }
    return count
}