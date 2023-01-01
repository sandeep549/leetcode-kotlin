package topicWise.string

private fun reverseWords(s: String): String {
    val a = s.toCharArray()
    var start = 0
    val ans = StringBuilder()
    for (i in a.indices) {
        if (a[i] == ' ' || i == a.lastIndex) {
            var r = i
            while (r >= start) ans.append(a[r--])
            start = i
            if (i != a.lastIndex) ans.append(' ')
        }
    }
    return ans.toString()
}
