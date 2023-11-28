package com.sk.set3

import kotlin.random.Random


class RandomizedSet() {

    /** Initialize your data structure here. */
    private var map = HashMap<Int, Int>() // Element and its location in list
    private var list = ArrayList<Int>()

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    fun insert(`val`: Int): Boolean {
        if (map.containsKey(`val`)) {
            return false
        }
        map[`val`] = list.size
        list.add(`val`)
        return true
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    fun remove(`val`: Int): Boolean {
        if (map.containsKey(`val`).not()) {
            return false
        }
        // Get this element index in list
        val listIndex = map[`val`]!!

        // Move last element to this index
        if (listIndex < list.size - 1) {
            val last = list.last()
            list[listIndex] = last
            map[last] = listIndex
        }

        // Remove last element
        list.removeLast()
        // Remove from map
        map.remove(`val`)

        return true
    }

    /** Get a random element from the set. */
    fun getRandom(): Int {
        return list[Random.nextInt(list.size)]
    }

    fun debug() {
        println("-------")
        println("$list")
        println("${map.entries}")
    }
}
