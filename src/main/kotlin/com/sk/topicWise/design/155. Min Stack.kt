package com.sk.topicWise.design

private class MinStack() {

    /** initialize your data structure here. */
    var stack = ArrayDeque<Int>()
    var minstack = ArrayDeque<Int>()

    fun push(x: Int) {
        stack.addLast(x)
        if (minstack.isNotEmpty()) {
            minstack.addLast(minOf(minstack.last(), x))
        } else {
            minstack.addLast(x)
        }
    }

    fun pop() {
        stack.removeLast()
        minstack.removeLast()
    }

    fun top(): Int {
        return stack.last()
    }

    fun getMin(): Int {
        return minstack.last()
    }
}

private class MinStack2 {
    private class Element(val value: Int, val min: Int)

    private var stack = ArrayDeque<Element>()
    fun push(x: Int) {
        val min = if (stack.isEmpty()) x else minOf(stack.last().min, x)
        stack.addLast(Element(x, min))
    }

    fun pop() {
        stack.removeLast()
    }

    fun top(): Int {
        return stack.last().value
    }

    fun getMin(): Int {
        return stack.last().min
    }
}

// TODO: 19/2/21 https://leetcode.com/problems/min-stack/discuss/49031/Share-my-Java-solution-with-ONLY-ONE-stack 
