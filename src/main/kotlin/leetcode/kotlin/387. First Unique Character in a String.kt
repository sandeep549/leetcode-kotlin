package leetcode.kotlin

private fun firstUniqChar(s: String): Int {
    val map = s.toList().groupingBy { it }.eachCount()
    s.indices.forEach {
        if (map[s[it]] == 1) return it
    }
    return -1
}
