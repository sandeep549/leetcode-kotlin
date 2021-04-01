package leetcode.kotlin

import java.util.ArrayList
import java.util.Random

private class RandomizedSet() {

    var list = ArrayList<Int>()
    var map = mutableMapOf<Int, Int>()
    var rand = Random()

    /** Initialize your data structure here.  */
    fun RandomizedSet() {
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element.  */
    fun insert(`val`: Int): Boolean {
        val contain = map.containsKey(`val`)
        if (contain) return false
        map[`val`] = list.size
        list.add(`val`)
        return true
    }

    /** Removes a value from the set. Returns true if the set contained the specified element.  */
    fun remove(`val`: Int): Boolean {
        val contain = map.containsKey(`val`)
        if (!contain) return false
        val loc = map[`val`]!!
        if (loc < list.size - 1) { // not the last one than swap the last one with this val
            val last = list[list.size - 1]
            list[loc] = last
            map[last] = loc
        }
        list.removeAt(list.size - 1)
        map.remove(`val`)
        return true
    }

    /** Get a random element from the set.  */
    fun getRandom(): Int {
        return list[rand.nextInt(list.size)]
    }
}