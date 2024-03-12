package com.sk.`todo-revise`

import java.util.*

private class UnionFind_2092(private val id: MutableList<Int>) {
    init {
        id.indices.forEach { id[it] = it }
    }

    fun connect(a: Int, b: Int) {
        id[find(b)] = find(a)
    }

    fun find(a: Int): Int {
        return if (id[a] == a) a else {
            id[a] = find(id[a])
            id[a]
        }
    }

    fun connected(a: Int, b: Int): Boolean {
        return find(a) == find(b)
    }

    fun reset(a: Int) {
        id[a] = a
    }
}

class Solution2092 {
    fun findAllPeople(n: Int, A: MutableList<MutableList<Int>>, firstPerson: Int): List<Int> {
        A.sortBy { it[2] } // Sort the meetings in ascending order of meeting time
        val uf = UnionFind_2092(mutableListOf<Int>().apply { repeat(n) { add(0) } })
        uf.connect(0, firstPerson) // Connect person 0 with the first person
        val ppl = mutableListOf<Int>()
        var i = 0
        val M = A.size
        while (i < M) {
            ppl.clear()
            val time = A[i][2]
            while (i < M && A[i][2] == time) { // For all the meetings happening at the same time
                uf.connect(A[i][0], A[i][1]) // Connect the two persons
                ppl.add(A[i][0]) // Add both persons into the pool
                ppl.add(A[i][1])
                i++
            }
            for (n in ppl) { // For each person in the pool, check if he/she's connected with person 0.
                if (!uf.connected(0, n)) uf.reset(n) // If not, this person doesn't have secret, reset it.
            }
        }
        val ans = mutableListOf<Int>()
        for (i in 0 until n) {
            if (uf.connected(0, i)) ans.add(i) // Push all the persons who are connected with person 0 into answer array
        }
        return ans
    }
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

class Solution2092_2 {
    fun findAllPeople(n: Int, meetings: Array<IntArray>, firstPerson: Int): List<Int> {
        val adj: MutableList<MutableList<IntArray>> = ArrayList()
        for (i in 0 until n) {
            adj.add(ArrayList())
        }
        for (m in meetings) {
            adj[m[0]].add(intArrayOf(m[1], m[2]))
            adj[m[1]].add(intArrayOf(m[0], m[2]))
        }
        val pq = PriorityQueue<IntArray> { x, y -> x[1] - y[1] } // Person, Time
        pq.add(intArrayOf(0, 0))
        pq.add(intArrayOf(firstPerson, 0))
        val visited = BooleanArray(n)
        while (!pq.isEmpty()) {
            val (person, time) = pq.poll()
            if (visited[person]) continue
            visited[person] = true
            for (p in adj[person]) {
                if (!visited[p[0]] && p[1] >= time) {
                    pq.add(intArrayOf(p[0], p[1]))
                }
            }
        }
        val al = ArrayList<Int>()
        for (i in 0 until n) {
            if (visited[i]) al.add(i)
        }
        return al
    }
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


class UnionFind_2092_3(private val id: MutableList<Int>) {
    fun connect(a: Int, b: Int) {
        id[find(b)] = find(a)
    }

    fun find(a: Int): Int {
        return if (id[a] == a) a else {
            id[a] = find(id[a])
            id[a]
        }
    }

    fun connected(a: Int, b: Int): Boolean {
        return find(a) == find(b)
    }

    fun reset(a: Int) {
        id[a] = a
    }
}

class Solution209_3 {
    fun findAllPeople(n: Int, A: MutableList<MutableList<Int>>, firstPerson: Int): List<Int> {
        A.sortBy { it[2] } // Sort the meetings in ascending order of meeting time
        val uf = UnionFind_2092_3((0 until n).toMutableList())
        uf.connect(0, firstPerson) // Connect person 0 with the first person
        val ppl = mutableListOf<Int>()
        var i = 0
        val M = A.size
        while (i < M) {
            ppl.clear()
            val time = A[i][2]
            while (i < M && A[i][2] == time) { // For all the meetings happening at the same time
                uf.connect(A[i][0], A[i][1]) // Connect the two persons
                ppl.add(A[i][0]) // Add both persons into the pool
                ppl.add(A[i][1])
                i++
            }
            for (n in ppl) { // For each person in the pool, check if he/she's connected with person 0.
                if (!uf.connected(0, n)) uf.reset(n) // If not, this person doesn't have secret, reset it.
            }
        }
        val ans = mutableListOf<Int>()
        for (i in 0 until n) {
            if (uf.connected(0, i)) ans.add(i) // Push all the persons who are connected with person 0 into answer array
        }
        return ans
    }
}
