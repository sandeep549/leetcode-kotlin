package leetcode.kotlin

import java.util.Stack

private abstract class NestedInteger {
    // Constructor initializes an empty nested list.
    constructor()

    // Constructor initializes a single integer.
    constructor(value: Int)

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    abstract fun isInteger(): Boolean

    // @return the single integer that this NestedInteger holds, if it holds a single intege
    // Return null if this NestedInteger holds a nested list
    abstract fun getInteger(): Int?

    // Set this NestedInteger to hold a single integer.
    abstract fun setInteger(value: Int): Unit

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    abstract fun add(ni: NestedInteger): Unit

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    abstract fun getList(): List<NestedInteger>?
}

private class NestedIterator(nestedList: List<NestedInteger>) {
    val stack = Stack<Iterator<NestedInteger>>()
    var nextInt: NestedInteger? = null

    init {
        stack.push(nestedList.iterator())
    }

    fun next(): Int {
        return nextInt!!.getInteger()!!
    }

    fun hasNext(): Boolean {
        while (!stack.isEmpty()) {
            if (!stack.peek().hasNext()) {
                stack.pop()
                continue
            }
            nextInt = stack.peek().next()
            if (nextInt!!.isInteger()) {
                return true
            } else {
                stack.push(nextInt!!.getList()!!.iterator())
            }
        }
        return false
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * var obj = NestedIterator(nestedList)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */
