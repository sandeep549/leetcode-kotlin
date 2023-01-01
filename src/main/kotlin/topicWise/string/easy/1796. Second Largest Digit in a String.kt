package topicWise.string.easy

private fun secondHighest(s: String): Int {
    var first = -1
    var sec = -1
    for (element in s) {
        val c = element
        if (Character.isDigit(c)) {
            val d = c - '0'
            if (first < d) {
                sec = first
                first = d
            } else if (d in (sec + 1) until first) {
                sec = d
            }
        }
    }
    return sec
}
