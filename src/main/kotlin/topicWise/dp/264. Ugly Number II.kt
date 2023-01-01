package topicWise.dp

fun nthUglyNumber2(n: Int): Int {
    val ugly = IntArray(n)
    ugly[0] = 1
    var index2 = 0
    var index3 = 0
    var index5 = 0
    var factor2 = 2
    var factor3 = 3
    var factor5 = 5
    for (i in 1 until n) {
        val min = minOf(minOf(factor2, factor3), factor5)
        ugly[i] = min
        if (factor2 == min) factor2 = 2 * ugly[++index2]
        if (factor3 == min) factor3 = 3 * ugly[++index3]
        if (factor5 == min) factor5 = 5 * ugly[++index5]
    }
    return ugly[n - 1]
}
