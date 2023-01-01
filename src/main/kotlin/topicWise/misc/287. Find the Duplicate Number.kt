package topicWise.misc

import kotlin.math.abs

// without modifying array
private fun findDuplicate(nums: IntArray): Int {
    var slow = nums[0]
    var fast = nums[0]
    do {
        slow = nums[slow]
        fast = nums[nums[fast]]
    } while (slow != fast)

    // locate entrace of cycle
    fast = nums[0]
    while (fast != slow) {
        fast = nums[fast]
        slow = nums[slow]
    }
    return slow
}

// with array modification
private fun findDuplicate2(nums: IntArray): Int {
    nums.forEachIndexed { index, item ->
        val absItem = abs(item)
        if (nums[absItem - 1] < 0) return absItem
        nums[absItem - 1] *= -1
    }
    return 0 // we shouldn't never be here
}
