package leetcode.google

/**
 * Time complexity
 * http://www.cs.cornell.edu/courses/cs6110/2014sp/Handouts/UnionFind.pdf
 */
private class Solution {
    class UnionFind {
        private lateinit var parent: HashMap<Int, Int>
        var size = 0

        fun init(N: Int) {
            parent = HashMap()
            size = N
            repeat(N) {
                parent[it] = it
            }
        }

        // find child and return this group representative
        fun find(child: Int): Int {
            if (parent[child] != child) {
                val p = find(parent[child]!!)
                parent[child] = p // path compression
            }
            return parent[child]!!
        }

        fun union(a: Int, b: Int) {
            val pa = find(a)
            val pb = find(b)
            if (pa != pb) {
                parent[pb] = pa
                size-- // reduce total disjoint set count
            }
        }
    }

    fun earliestAcq(logs: Array<IntArray>, n: Int): Int {
        logs.sortWith { a1, a2 -> a1[0] - a2[0] }
        val uf = UnionFind()
        uf.init(n)
        for (log in logs) {
            uf.union(log[1], log[2])
            if (uf.size == 1) {
                return log[0]
            }
        }
        return -1
    }
}

//################################################################
// UnionFind Template
//################################################################
internal class UnionFind(size: Int) {
    private val parent: IntArray
    private val rank: IntArray

    init {
        parent = IntArray(size)
        rank = IntArray(size)
        for (person in 0 until size) {
            parent[person] = person
            rank[person] = 0
        }
    }

    /** Return the id of group that the this item belongs to.  */
    fun find(item: Int): Int {
        if (parent[item] != item) {
            parent[item] = this.find(parent[item])
        }
        return parent[item]
    }

    /**
     * return true if both are merged, false otherwise
     */
    fun union(a: Int, b: Int): Boolean {
        val groupA = this.find(a)
        val groupB = this.find(b)

        // The two people share the same group.
        if (groupA == groupB) {
            return false
        }

        // Otherwise, merge the two groups.
        // Merge the lower-rank group into the higher-rank group.
        if (rank[groupA] > rank[groupB]) {
            parent[groupB] = groupA
        } else if (rank[groupA] < rank[groupB]) {
            parent[groupA] = groupB
        } else {
            parent[groupA] = groupB
            rank[groupB] += 1
        }
        return true
    }
}