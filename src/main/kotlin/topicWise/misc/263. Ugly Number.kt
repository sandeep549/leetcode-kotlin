package topicWise.misc

fun main() {
    println(isUgly(46))
}

private fun isUgly(num: Int): Boolean {
    if (num == 0) return false
    var n = num
    for (i in listOf(2, 3, 5)) {
        while (n % i == 0) n /= i
    }
    return n == 1
}
