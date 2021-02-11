package leetcode.kotlin

fun main() {
    check(romanToInt("MCMXCIV") == 1994)
}

private fun romanToInt(s: String): Int {
    val map = mapOf(
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000
    )
    var sum = 0
    for (i in 0 until s.lastIndex) {
        map[s[i]]?.let {
            sum += if (it < map[s[i + 1]]!!) -it else it
        }
    }
    sum += map[s[s.lastIndex]]!!
    return sum
}