package leetcode.kotlin

private fun strStr(haystack: String, needle: String): Int {
    for (i in 0..haystack.length) {
        for (j in 0..needle.length) {
            if (j == needle.length) return i
            if (i + j == haystack.length) return -1
            if (haystack[i + j] != needle[j]) break
        }
    }
    return -1 // we must never hit here
}

// TODO: 13/2/21 KMP and other pattern matching algorithms