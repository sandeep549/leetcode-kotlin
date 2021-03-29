package leetcode.kotlin.sort

private fun sortByBits(arr: IntArray): IntArray {
    val result = arr.sortedWith(Comparator { o1, o2 ->
        val c = Integer.bitCount(o1) - Integer.bitCount(o2)
        return@Comparator if (c == 0) o1 - o2 else c
    })
    return result.toIntArray()
}