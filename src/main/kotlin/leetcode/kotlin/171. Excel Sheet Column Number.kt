package leetcode.kotlin

private fun titleToNumber(s: String): Int {
    return s.foldRight(0, { ch, acc -> acc * 26 + (ch - 'A' + 1) })
}

private fun titleToNumber2(s: String): Int {
    var result = 0
    for (element in s) {
        result = result * 26 + (element - 'A' + 1)
    }
    return result
}