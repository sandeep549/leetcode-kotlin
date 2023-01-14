package advanceds

// https://en.wikipedia.org/wiki/Disjoint-set_data_structure
// https://www.techiedelight.com/disjoint-set-data-structure-union-find-algorithm/
//https://www.geeksforgeeks.org/introduction-to-disjoint-set-data-structure-or-union-find-algorithm/

/**
 * Problem Statement: We have some number of items. We are allowed to merge any two items to consider them equal.
 * At any point we should be able to answer whether two items are equal or not ?
 */

private class DisjointSet {

    private var parentMap = mutableMapOf<Int, Int>()
    private var rank = mutableMapOf<Int, Int>()

    // perform MakeSet operation
    fun makeSet(x: Int) {
        parentMap[x] = x // create new disjoint set point to itself
        rank[x] = 0
    }

    // find root/representative of disjoint set to which x belongs
    fun find(x: Int): Int {
        // find root of this disjoint set
        var root = x
        while (parentMap[root] != root) {
            root = parentMap[root]!!
        }

        // path compression
        var i = x
        while (parentMap[i] != root) {
            val next = parentMap[i]!!
            parentMap[i] = root   // path compression
            i = next
        }

        return parentMap[x]!!
    }

    // perform union of two disjoint sets
    fun union(x: Int, y: Int) {
        println("Union $x and $y")
        val a = find(x)
        val b = find(y)
        if (a == b) return // if already in same set

        // perform union by rank
        // attach smaller depth tree under the root of deeper tree
        if (rank[x]!! < rank[y]!!)
            parentMap[x] = y
        else if (rank[x]!! > rank[y]!!)
            parentMap[y] = x
        else {
            parentMap[x] = y
            rank[y] = rank[y]!! + 1
        }
    }

    // helper function to print all disjoints sets, i.e. print all representatives
    fun printDisjointSets() {
        parentMap.entries.groupBy { it.value }.toList().let { println(it) }
    }
}

fun main() {
    val dj = DisjointSet()
    dj.makeSet(1)
    dj.makeSet(2)
    dj.makeSet(3)
    dj.makeSet(4)
    dj.makeSet(5)
    dj.printDisjointSets()
    dj.union(1, 2)
    dj.printDisjointSets()
    dj.union(2, 3)
    dj.printDisjointSets()
    dj.union(4, 5)
    dj.printDisjointSets()

    // is 1 and 3 are equal(or friends), yes as belong to same disjoint set
    println(dj.find(1) == dj.find(3))
}
