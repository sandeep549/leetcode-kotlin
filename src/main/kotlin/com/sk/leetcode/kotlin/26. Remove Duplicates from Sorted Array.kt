package leetcode.kotlin.array.easy

fun main() {
    var a = intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
    removeDuplicates(a)
    println(a.toList())
}

private fun removeDuplicates(nums: IntArray): Int {
    var j = 0
    for (i in 1..nums.lastIndex) {
        if (nums[i] != nums[j]) {
            j++
            if (i != j) nums[j] = nums[i]
        }
    }
    return j + 1
}


