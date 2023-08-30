package leetcode.kotlin.array.easy

// brute force
// O(n^2)
private fun majorityElement(nums: IntArray): Int {
    for (i in 0 until nums.lastIndex) {
        var cnt = 1
        for (j in i + 1..nums.lastIndex) {
            if (nums[i] == nums[j]) {
                cnt++
                if (cnt > nums.size / 2) return i
            }
        }
    }
    return nums[0] // we must never land here
}

// By Map
// O(n);O(n)

private fun majorityElement1(nums: IntArray): Int {
    val map = mutableMapOf<Int, Int>()
    for (n in nums) {
        map[n] = map.getOrDefault(n, 0)
        map[n]?.let { if (it > nums.size / 2) return n }
    }
    return 0 // we must never land here
}

// By sorting
// O(nlogn)
private fun majorityElement2(nums: IntArray): Int {
    nums.sort()
    return nums[nums.size / 2]
}

// Boyer - Moore
private fun majorityElement3(nums: IntArray): Int {
    var major = nums[0]
    var count = 1
    for (i in 1 until nums.size) {
        if (count == 0) {
            major = nums[i]
        }
        count += if (nums[i] == major) 1 else -1
    }
    return major
}

// Boyer more
private fun majorityElement5(nums: IntArray): Int {
    var major = nums[0]
    var count = 1
    for (i in 1 until nums.size) {
        count += if (nums[i] == major) 1 else -1
        if (count == 0) {
            major = nums[i]
            count = 1
        }
    }
    return major
}

private fun majorityElement4(nums: IntArray): Int {
    var a = 0
    var ca = 0
    for (x in nums) {
        if (x == a) ca++
        else if (ca == 0) {
            a = x
            ca = 1
        } else {
            ca--
        }
    }
    return a
}
