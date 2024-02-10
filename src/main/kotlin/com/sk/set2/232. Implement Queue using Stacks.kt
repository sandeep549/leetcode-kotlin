package com.sk.set2

class MyQueue232() {

    val s1 = ArrayDeque<Int>()
    val s2 = ArrayDeque<Int>()

    fun push(x: Int) {
        s1.addLast(x)
    }

    fun pop(): Int {
        peek()
        return s2.removeLast()
    }

    fun peek(): Int {
        if (s2.isEmpty()) {
            while (s1.isNotEmpty()) {
                s2.addLast(s1.removeLast())
            }
        }
        return s2.last()
    }

    fun empty(): Boolean {
        return s1.isEmpty() && s2.isEmpty()
    }

}