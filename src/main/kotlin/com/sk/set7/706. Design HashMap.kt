package com.sk.set7

class MyHashMap706 {
    private class ListNode(var key: Int, var `val`: Int, var next: ListNode?)

    val size = 19997
    private var buckets: Array<ListNode?> = arrayOfNulls(size)

    private fun hash(key: Int) = key % size

    fun put(key: Int, `val`: Int) {
        remove(key)
        val h = hash(key)
        val node = ListNode(key, `val`, buckets[h])
        buckets[h] = node
    }

    fun get(key: Int): Int {
        val h = hash(key)
        var node = buckets[h]
        while (node != null) {
            if (node.key == key) return node.`val`
            node = node.next
        }
        return -1
    }

    fun remove(key: Int) {
        val h = hash(key)
        var node = buckets[h] ?: return
        if (node.key == key) buckets[h] = node.next
        else while (node.next != null) {
            if (node.next!!.key == key) {
                node.next = node.next!!.next
                return
            }
            node = node.next!!
        }
    }
}