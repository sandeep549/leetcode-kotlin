package leetcode.kotlin.string.medium

private fun reverseWords2(s: String): String {
    val str = s.trim()
    val arr = s.split(" ")
    val builder = StringBuilder()
    for (i in arr.indices.reversed()) {
        if (arr[i].isNotBlank()) builder.append(arr[i]).append(" ")
    }
    return builder.toString().trim()
}

private fun reverseWords(s: String?): String? {
    // reverse a[] from a[i] to a[j]
    fun reverse(a: CharArray, i: Int, j: Int) {
        var i = i
        var j = j
        while (i < j) {
            val t = a[i]
            a[i++] = a[j]
            a[j--] = t
        }
    }

    fun reverseWords(a: CharArray, n: Int) {
        var i = 0
        var j = 0
        while (i < n) {
            while (i < j || i < n && a[i] == ' ') i++ // skip spaces
            while (j < i || j < n && a[j] != ' ') j++ // skip non spaces
            reverse(a, i, j - 1) // reverse the word
        }
    }

    // trim leading, trailing and multiple spaces
    fun cleanSpaces(a: CharArray, n: Int): String {
        var i = 0
        var j = 0
        while (j < n) {
            while (j < n && a[j] == ' ') j++ // skip spaces
            while (j < n && a[j] != ' ') a[i++] = a[j++] // keep non spaces
            while (j < n && a[j] == ' ') j++ // skip spaces
            if (j < n) a[i++] = ' ' // keep only one space
        }
        return String(a).substring(0, i)
    }

    if (s == null) return null
    val a = s.toCharArray()
    val n = a.size

    // step 1. reverse the whole string
    reverse(a, 0, n - 1)
    // step 2. reverse each word
    reverseWords(a, n)
    // step 3. clean up spaces
    return cleanSpaces(a, n)
}
