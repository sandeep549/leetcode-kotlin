import java.util.PriorityQueue
import kotlin.math.abs

class Solution1046 {
    fun lastStoneWeight(stones: IntArray): Int {
        val priorityQueue = PriorityQueue<Int>{ p1, p2 -> p2 - p1}
        stones.forEach { priorityQueue.add(it) }
        while (priorityQueue.size > 1) {
            val first = priorityQueue.poll()
            val second = priorityQueue.poll()
            val diff = abs(first-second)
            if (diff != 0) priorityQueue.add(diff)
        }
        return if (priorityQueue.size == 1) priorityQueue.poll() else 0
    }
}