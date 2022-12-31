package leetcode.google

import java.util.LinkedList

import java.util.Queue


// ###########################################################################################
//
// ###########################################################################################

fun maximumDetonation(bombs: Array<IntArray>): Int {
    var res = 0
    for (i in bombs.indices) {
        val path = mutableSetOf<Int>()
        maxWithThisExplosion(bombs, i, path)
        res = maxOf(res, path.size)
    }
    return res
}

private fun maxWithThisExplosion(bombs: Array<IntArray>, index: Int, path: MutableSet<Int>) {
    path.add(index)
    val explosion = bombs[index]
    for (i in bombs.indices) {
        if (!path.contains(i) && inRange(explosion, bombs[i])) {
            maxWithThisExplosion(bombs, i, path)
        }
    }
}

private fun inRange(a: IntArray, b: IntArray): Boolean {
    val dx = (a[0] - b[0]).toLong()
    val dy = (a[1] - b[1]).toLong()
    val r = a[2].toLong()
    return dx * dx + dy * dy <= r * r
}

// todo: this range function has some bug
fun isInRange(explosion: IntArray, bomb: IntArray): Boolean {
    return (bomb[0] - explosion[0]) * (bomb[0] - explosion[0]) + (bomb[1] - explosion[1]) * (bomb[1] - explosion[1]) <= explosion[2] * explosion[2]
}

// ###########################################################################################
//
// ###########################################################################################

private fun maximumDetonation2(bombs: Array<IntArray>): Int {
    val graph = HashMap<Int, MutableList<Int>>()

    for (i in bombs.indices) {
        for (j in bombs.indices) {
            if (i == j) continue
            if (inRange(bombs[i], bombs[j])) {
                graph[i]!!.add(j)
            }
            if (inRange(bombs[j], bombs[i])) {
                graph[j]!!.add(i)
            }
        }
    }

    var result = 0
    for (i in bombs.indices) {
        result = maxOf(result, dfs(graph, BooleanArray(bombs.size), i))
    }
    return result
}

private fun dfs(graph: Map<Int, MutableList<Int>>, seen: BooleanArray, index: Int): Int {
    if (seen[index]) return 0
    seen[index] = true
    var result = 1
    for (adjacentNode in graph[index]!!) {
        result += dfs(graph, seen, adjacentNode)
    }
    return result
}

// ###########################################################################################
// BFS
// ###########################################################################################

fun maximumDetonation3(bombs: Array<IntArray>): Int {
    var max = 0
    val queue: Queue<Int> = LinkedList()
    var seen: BooleanArray

    for (index in bombs.indices) {
        seen = BooleanArray(bombs.size)
        seen[index] = true
        queue.offer(index)

        var maxHere = 1 // start from 1 since the first added bomb can detonate itself
        while (!queue.isEmpty()) {
            val currBomb = queue.poll()
            for (j in bombs.indices) { //search for bombs to detonate
                if (!seen[j] && isInRange(bombs[currBomb], bombs[j])) {
                    seen[j] = true
                    maxHere++
                    queue.offer(j)
                }
            }
        }
        max = maxOf(max, maxHere)
    }

    return max
}

