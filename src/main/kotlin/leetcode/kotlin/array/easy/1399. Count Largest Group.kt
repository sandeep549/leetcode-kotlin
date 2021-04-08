package leetcode.kotlin.array.easy

private fun countLargestGroup(n: Int): Int {
    fun dsum(n: Int): Int {
        return if (n == 0) 0 else n % 10 + dsum(n / 10)
    }

    val cnt = IntArray(37) { 0 }
    for (i in 1..n) {
        val c = dsum(i)
        cnt[c] = cnt[c] + 1
    }
    val max = cnt.max()
    return cnt.count { it == max }
}