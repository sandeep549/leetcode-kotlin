package com.sk.set2

private fun majorityElement(nums: IntArray): List<Int> {
    val l = nums.size / 3
    val g = nums
        .toList()
        .groupingBy { it }
        .eachCount()
        .filter { it.value > l }
        .map { it.key }
    return g
}

private fun majorityElement2(nums: IntArray): List<Int> {
    var ans = mutableListOf<Int>()
    if (nums.isEmpty()) return ans
    var a = 0
    var b = 1
    var ca = 0
    var cb = 0
    for (x in nums) {
        if (x == a) ca++
        else if (x == b) cb++
        else if (ca == 0) {
            a = x
            ca = 1
        } else if (cb == 0) {
            b = x
            cb = 1
        } else {
            ca--
            cb--
        }
    }

    ca = 0.also { cb = 0 }
    for (x in nums)
        if (x == a) ca++
        else if (x == b) cb++
    if (ca > nums.size / 3) ans.add(a)
    if (cb > nums.size / 3) ans.add(b)
    return ans
}

// https://www.geeksforgeeks.org/boyer-moore-majority-voting-algorithm-for-searching-elements-having-more-than-k-occurrences/
private fun majorityElement3(nums: IntArray): List<Int> {
    val K = 3
    val candidates = HashMap<Int, Int>()
    /**
     * Get all candidates.
     * Traverse through the array, maintain (K-1) slots for different type of elements and their counts.
     * For example for (1/2) case we have keep 1 slot and look for only 1 candidate.
     * When we encounter kth different element, we decrease the count for all and remove
     * all which have count 0
     */
    for (a in nums) {
        candidates[a] = candidates.getOrDefault(a, 0) + 1
        if (candidates.size == K) {
            val it = candidates.entries.iterator()
            while (it.hasNext()) {
                val item = it.next()
                item.setValue(item.value - 1)
                if (item.value == 0) it.remove()
            }
        }
    }

    //Check correctness of all candidates
    val ans = ArrayList<Int>()
    val it = candidates.entries.iterator()
    while (it.hasNext()) {
        val key = it.next().key
        var count = 0
        for (a in nums) {
            if (a == key) count++
            if (count > nums.size / K) {
                ans.add(key)
                break
            }
        }
    }
    return ans
}

fun majorityElement4(nums: IntArray): List<Int> {
    var nOver3 = nums.size/3

    val solution = mutableListOf<Int>()
    nums.sort()
    var count = 1
    for (i in 1 until nums.size) {
        if (nums[i] == nums[i-1]) {
            ++count
        }
        else {
            if (count > nOver3) {
                solution.add(nums[i-1])
            }
            // reset the count
            count = 1
        }
    }

    if (count > nOver3) {
        solution.add(nums[nums.size-1])
    }
    return solution
}