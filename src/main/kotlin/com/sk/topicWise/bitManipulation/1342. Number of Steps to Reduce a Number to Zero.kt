package com.sk.topicWise.bitManipulation

private fun numberOfSteps(num: Int): Int {
    var count = 0
    var n = num
    while (n != 0) {
        if (n % 2 == 0) n /= 2 else n -= 1
        count++
    }
    return count
}
