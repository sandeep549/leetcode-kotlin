package com.sk.set29

import com.sk.advanceds.Heap
import java.util.*;

class Solution2971 {
    fun largestPerimeter(nums: IntArray): Long {
        var sum = nums.sumOf { i: Int ->  i.toLong()}
        val heap = Heap(nums)
        while (heap.heapSize > 2) {
            if (heap.top() < sum - heap.top()) {
                return sum
            }
            sum -= heap.top()
            heap.heappopMax()
        }
        return -1
    }

}
