package com.sk.topicWise.linkedlist.medium

private class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}

class Solution138 {
    private fun copyRandomList(node: Node?): Node? {
        val oldNodeMap = HashMap<Node, Node?>()
        val oldListIndex = HashMap<Node, Int>()
        val newList = ArrayList<Node>()
        val dummy = Node(0)
        var newCur: Node? = dummy
        var oldCur = node
        var i = 0
        while (oldCur != null) {
            if (oldCur.random != null) {
                oldNodeMap[oldCur] = oldCur.random
            }
            oldListIndex[oldCur] = i++

            newCur?.next = Node(oldCur.`val`)
            newList.add(newCur?.next!!)

            oldCur = oldCur.next
            newCur = newCur?.next
        }

        oldCur = node
        newCur = dummy.next

        while (oldCur != null) {
            val r = oldNodeMap[oldCur] // Get random node
            if (r != null) {
                val i = oldListIndex[r]!! // Get index in of random node in old list
                val newRandom = newList[i]
                newCur?.random = newRandom
            }

            oldCur = oldCur.next
            newCur = newCur?.next
        }

        return dummy.next
    }

    private fun copyRandomList2(node: Node?): Node? {
        var cur = node
        // Make duplicate node within original list
        while (cur != null) {
            val next = cur.next
            val n = Node(cur.`val`)
            cur.next = n
            n.next = next
            cur = next
        }
        // Adjust random pointer for duplicate nodes
        cur = node
        while (cur != null) {
            val next = cur.next
            next?.random = cur.random?.next
            cur = next?.next
        }
        // Take out duplicate list from original one
        val dummy = Node(0)
        var duplicate = dummy
        cur = node
        while (cur != null) {
            val d = cur.next
            cur.next = d?.next
            duplicate.next = d
            cur = d?.next
            duplicate = duplicate.next!!
        }
        return dummy.next
    }
}