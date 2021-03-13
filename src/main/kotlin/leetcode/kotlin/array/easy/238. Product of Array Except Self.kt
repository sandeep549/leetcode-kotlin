package leetcode.kotlin.array.easy

private fun productExceptSelf(nums: IntArray): IntArray? {
    val result = IntArray(nums.size)
    var tmp = 1
    for (i in nums.indices) {
        result[i] = tmp
        tmp *= nums[i]
    }
    tmp = 1
    for (i in nums.indices.reversed()) {
        result[i] *= tmp
        tmp *= nums[i]
    }
    return result
}

private fun productExceptSelf2(nums: IntArray): IntArray? {
    val ans = IntArray(nums.size)
    ans[nums.lastIndex] = 1
    for (i in nums.lastIndex - 1 downTo 0) ans[i] = ans[i + 1] * nums[i + 1]
    var mul = nums[0]
    for (i in 1..nums.lastIndex) {
        ans[i] = mul * ans[i]
        mul *= nums[i]
    }
    return ans
}

// one pass, if don't count initialization pass
private fun productExceptSelf3(nums: IntArray): IntArray? {
    val result = IntArray(nums.size) { 1 }
    var l = 1
    var r = 1
    var i = 0
    var j = nums.lastIndex
    while (i < nums.lastIndex) {
        l *= nums[i]
        r *= nums[j]
        result[i + 1] *= l
        result[j - 1] *= r
        i++
        j--
    }
    return result
}
