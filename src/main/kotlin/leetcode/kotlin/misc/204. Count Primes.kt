package leetcode.kotlin.misc

fun main() {
    println(countPrime(1000000))
}

private fun countPrime(n: Int): Int {
    if (n == 0 || n == 1) return 0
    val arr = IntArray(n - 1) { -1 }
    var ans = 0
    for (i in 2 until n) {
        if (arr[i - 2] == -1) ans++
        var j = 1
        while (i * j <= n) {
            arr[i * j - 2] = 0
            j++
        }
    }
    return ans
}

private fun isprime(num: Int): Boolean {
    var n: Int = Math.sqrt(num.toDouble()).toInt()
    for (i in 2..n) {
        if (num % i == 0) return false
    }
    return true
}
