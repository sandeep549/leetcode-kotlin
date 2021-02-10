package leetcode.kotlin.math

private fun reverse(x: Int): Int {
    var x = x
    var res = 0
    while (x != 0) {
        val tail = x % 10
        val newres = res * 10 + tail
        if ((newres - tail) / 10 != res) return 0
        res = newres
        x /= 10
    }
    return res
}
