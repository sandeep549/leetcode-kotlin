package com.sk.`todo-revise`


class Solution446 {
    fun numberOfArithmeticSlices(nums: IntArray): Int {
        var count = 0
        fun find(i: Int, list: MutableList<Int>) {
            if (list.size > 2) count++
            //println("i=$i, list=$list")
            if (i >= nums.size) return

            for (k in i..nums.lastIndex) {
                if (list.size < 2) {
                    list.add(nums[k])
                    find(k + 1, list)
                    list.removeLast()
                } else {
                    val s = list.size
                    if (nums[k] - list[s - 1] == list[s - 1] - list[s - 2] &&
                        list[s - 1] xor nums[k] >= 0
                    ) { // last 2 number have same sign
                        list.add(nums[k])
                        find(k + 1, list)
                        list.removeLast()
                    }
                }
            }
        }

        find(0, mutableListOf<Int>())
        return count
    }


    fun numberOfArithmeticSlices2(nums: IntArray): Int {
        val n = nums.size
        var ans = 0
        val dp = Array(n) { HashMap<Int, Int>() }
        for (i in 1 until n) {
            for (j in 0 until i) {
                val diff = nums[i].toLong() - nums[j]
                if (diff <= Int.MIN_VALUE || diff > Int.MAX_VALUE) continue
                val d = diff.toInt()

                val cnt = dp[j].getOrDefault(d, 0)
                dp[i][d] = dp[i].getOrDefault(d, 0) + cnt + 1
                ans += cnt
            }
        }
        return ans
    }

}