package leetcode.kotlin.array.easy

private fun replaceElements(arr: IntArray): IntArray {
    var max = -1
    for (i in arr.lastIndex downTo 0) {
        val cur = arr[i]
        arr[i] = max
        max = maxOf(max, cur)
    }
    return arr
}