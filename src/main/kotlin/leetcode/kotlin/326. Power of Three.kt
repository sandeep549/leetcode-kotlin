package leetcode.kotlin

fun main() {
    check(!isPowerOfThree(45))
    check(isPowerOfThree(81))
}

private fun isPowerOfThree(n: Int): Boolean {
    var no = n
    if (no < 1) {
        return false
    }

    while (no % 3 == 0) {
        no /= 3
    }

    return no == 1
}