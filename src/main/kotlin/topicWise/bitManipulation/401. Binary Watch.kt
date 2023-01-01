package topicWise.bitManipulation

private fun readBinaryWatch(num: Int): List<String> {
    val res = mutableListOf<String>()
    for (h in 0..11) {
        for (m in 0..59) {
            if (Integer.bitCount(h) + Integer.bitCount(m) == num) {
                res.add(h.toString() + (if (m < 10) ":0" else ":") + m)
            }
        }
    }
    return res
}
