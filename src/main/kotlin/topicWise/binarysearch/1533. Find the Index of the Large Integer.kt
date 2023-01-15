package topicWise.binarysearch

interface ArrayReader {
    fun compareSub(l: Int, r: Int, x: Int, y: Int): Int
    fun length(): Int
}

class Solution1533 {
    fun getIndex(reader: ArrayReader): Int {
        var l = 0
        var r = reader.length() - 1
        while (l < r) {
            val m = l + (r - l) / 2
            val result =
                if ((r - l) % 2 == 0) // odd items in array
                    reader.compareSub(l, m - 1, m + 1, r)
                else // even items in array
                    reader.compareSub(l, m, m + 1, r)

            if (result > 0) {
                r = if ((r - l) % 2 == 0) m - 1 else m
            } else if (result < 0) {
                l = m + 1
            } else { // we would never hit this for even item in search space
                return m
            }
        }
        return l
    }
}
