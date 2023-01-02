package topicWise.design

private class LRUCache(capacity: Int) {

    private var count: Int = 0
    private var capacity = 0
    private var cache: HashMap<Int, DLinkedNode> = HashMap()
    private var head: DLinkedNode
    private var tail: DLinkedNode

    init {
        this.capacity = capacity

        head = DLinkedNode()
        head.pre = null

        tail = DLinkedNode()
        tail.next = null

        head.next = tail
        tail.pre = head
    }

    //region internal methods
    private fun addNode(node: DLinkedNode) {
        node.pre = head
        node.next = head.next

        head.next!!.pre = node
        head.next = node
    }

    private fun removeNode(node: DLinkedNode) {
        val pre = node.pre
        val next = node.next

        pre!!.next = next
        next!!.pre = pre
    }

    private fun moveToHead(node: DLinkedNode) {
        removeNode(node)
        addNode(node)
    }

    private fun popTail(): DLinkedNode? {
        val res = tail.pre
        removeNode(res!!)
        return res
    }
    //endregion

    //region public methods
    fun get(key: Int): Int {
        val node = cache[key] ?: return -1
        moveToHead(node)
        return node.value
    }

    fun put(key: Int, value: Int) {
        val node = cache[key]
        if (node == null) {
            val new = DLinkedNode()
            new.key = key
            new.value = value
            cache[key] = new
            addNode(new)
            ++count
            if (count > capacity) {
                val tail = popTail()
                cache.remove(tail!!.key)
                --count
            }
        } else {
            node.value = value
            moveToHead(node)
        }
    }
    //endregion

    private class DLinkedNode {
        var key = 0
        var value = 0
        var pre: DLinkedNode? = null
        var next: DLinkedNode? = null
    }
}

//#############################################################################################
class LRUCache146(val capacity: Int) {

    val cache = LinkedHashMap<Int, Int>()

    fun get(key: Int): Int {
        val v = cache[key] ?: return -1
        // Move position in cache
        cache.remove(key)
        cache[key] = v
        return v
    }

    fun put(key: Int, value: Int) {
        // Remove to update position if exists
        if (cache.containsKey(key)) {
            cache.remove(key)
        }
        cache[key] = value

        // Evicts old item if size exceeds
        if (cache.size > capacity) cache.remove(cache.entries.first().key)
    }

}

//#############################################################################################

class LRUCache146_2(private val capacity: Int) : LinkedHashMap<Int, Int>(capacity, 0.75f, true) {
    override fun get(key: Int): Int {
        return super.getOrDefault(key, -1)
    }

    override fun put(key: Int, value: Int): Int? {
        return super.put(key, value)
    }

    override fun removeEldestEntry(eldest: Map.Entry<Int?, Int?>?): Boolean {
        return size > capacity
    }
}

//#############################################################################################
