package leetcode.kotlin.array.easy

fun main() {
    var arr = intArrayOf(0, 1, 0, 3, 12)
    moveZeroes(arr)
    println(arr.toList().toString())
}

private fun moveZeroes(nums: IntArray): Unit {
    var i = 0 // index to iterate
    var j = 0 // keeps just next location to already processed array
    while (i < nums.size) {
        if (nums[i] != 0) {
            if (i != j) nums[j] = nums[i]
            i++
            j++
        } else {
            i++
        }
    }
    while (j < nums.size) {
        nums[j++] = 0
    }
}
