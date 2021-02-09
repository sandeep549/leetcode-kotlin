package leetcode.kotlin

private fun firstUniqChar(s: String): Int {
    val seen = s.toCharArray().groupBy { it }.mapValues { it.value.size }
    s.indices.forEach {
        if (seen[s[it]] == 1) return it
    }
    return -1
}
