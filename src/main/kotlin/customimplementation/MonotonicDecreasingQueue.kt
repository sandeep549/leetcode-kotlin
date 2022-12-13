package customimplementation

class MonotonicDecreasingQueue<E>(
    val comparator: Comparator<E>
) : MonotonicQueue<E> {

    private var queue = ArrayDeque<E>()

    override fun add(e: E) {
        if (queue.isEmpty()) {
            queue.addLast(e)
            return
        }
        while (queue.isNotEmpty() && comparator.compare(queue.last(), e) < 0) {
            queue.removeLast()
        }
        queue.addLast(e)
    }

    override fun peekFirst(): E {
        return queue.first()
    }

    override fun peekLast(): E {
        return queue.last()
    }

    override fun removeFirst(): E {
        return queue.removeFirst()
    }

    override fun removeLast() {
        queue.removeLast()
    }

    override fun size(): Int {
        return queue.size
    }
}


fun main() {
    `test monotonic decresing queue`()
    `test monotonic increasing queue`()
}

fun `test monotonic decresing queue`() {
    val queue: MonotonicQueue<Int> = MonotonicDecreasingQueue { o1, o2 ->
        if (o1 <= o2) -1 else 1
    }

    queue.add(1)
    require(queue.peekFirst() == 1)

    queue.add(2)
    require(queue.peekFirst() == 2)

    queue.add(9)
    require(queue.peekFirst() == 9)

    queue.add(8)
    require(queue.peekFirst() == 9)
    require(queue.peekLast() == 8)

    queue.add(7)
    require(queue.peekFirst() == 9)
    require(queue.peekLast() == 7)

    queue.add(7)
    require(queue.size() == 3)
}

fun `test monotonic increasing queue`() {
    val queue: MonotonicQueue<Int> = MonotonicDecreasingQueue { o1, o2 ->
        if (o1 >= o2) -1 else 1
    }

    queue.add(1)
    require(queue.peekFirst() == 1)

    queue.add(2)
    require(queue.peekFirst() == 1)
    require(queue.peekLast() == 2)

    queue.add(9)
    require(queue.peekFirst() == 1)
    require(queue.peekLast() == 9)

    queue.add(9)
    require(queue.peekFirst() == 1)
    require(queue.peekLast() == 9)
    require(queue.size() == 3)

    queue.add(1)
    require(queue.peekFirst() == 1)
    require(queue.peekLast() == 1)
    require(queue.size() == 1)

}