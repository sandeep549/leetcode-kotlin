package leetcode.kotlin.math

fun main() {
    check(isHappy(19))
}

private fun isHappy(n: Int): Boolean {
    fun next(n: Int): Int {
        var no = n
        var res = 0
        while (no > 0) {
            val r = no % 10
            res += (r * r)
            no /= 10
        }
        return res
    }

    var slow = next(n)
    var fast = next(next(n))
    while (slow != fast) {
        slow = next(slow)
        fast = next(next(fast))
    }
    return fast == 1
}

private fun isHappy2(n: Int): Boolean {
    fun next(n: Int): Int {
        return n.toString()
            .split("").filter { it.isNotEmpty() }
            .fold(0) { acc, s -> acc + (s.toInt() * s.toInt()) }
    }

    var slow = next(n)
    var fast = next(next(n))
    while (fast != 1 && slow != fast) {
        slow = next(slow)
        fast = next(fast)
        if (fast == 1) break
        fast = next(fast)
    }
    return fast == 1
}