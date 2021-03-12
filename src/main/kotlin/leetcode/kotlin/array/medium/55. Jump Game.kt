package leetcode.kotlin.array.medium

private fun canJump(nums: IntArray): Boolean {
    val table = Array<Boolean?>(nums.size) { null }
    fun jump(i: Int): Boolean {
        if (i > nums.lastIndex) return false
        if (i == nums.lastIndex) return true
        table[i]?.let { return it }
        var res = false
        for (k in nums[i] downTo 1) {
            res = jump(i + k)
            if (res) break
        }
        table[i] = res
        return res
    }
    return jump(0)
}

private fun canJump2(nums: IntArray): Boolean {
    var lastPos: Int = nums.lastIndex
    for (i in nums.lastIndex downTo 0) {
        if (i + nums[i] >= lastPos) {
            lastPos = i
        }
    }
    return lastPos == 0
}
