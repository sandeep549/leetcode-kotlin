package leetcode.kotlin.array.medium

import java.util.Arrays
import java.util.PriorityQueue

private fun maxEvents(A: Array<IntArray>): Int {
    val pq = PriorityQueue<Int>()
    Arrays.sort(A) { a: IntArray, b: IntArray ->
        Integer.compare(
            a[0], b[0]
        )
    }
    var i = 0
    var res = 0
    val n = A.size
    for (d in 1..100000) { // simulate everyday
        while (!pq.isEmpty() && pq.peek() < d) pq.poll() // remove closed events
        while (i < n && A[i][0] == d) pq.offer(A[i++][1]) // add end time of all evetns which start today
        if (!pq.isEmpty()) {
            pq.poll() // attend which has sonner end time
            ++res
        }
    }
    return res
}