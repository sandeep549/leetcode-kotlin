package com.sk.leetcode.kotlin

// 0 ,1, 1, 2, 3, 5
fun fib() {
    var a = 0
    var b = 1
    var sum = a + b
    println("$a")
    println("$b")
    while (sum < 50) {
        println("$sum")
        a = b
        b = sum
        sum = a + b
    }
}

class MyStack {
    @ExperimentalStdlibApi
    var q1 = ArrayDeque<Int>(50)

    @ExperimentalStdlibApi
    val q2 = ArrayDeque<Int>(50)

    @ExperimentalStdlibApi
    fun push(n: Int) {
        q1.addFirst(n)
    }

    @ExperimentalStdlibApi
    fun pop(): Int {
        var size = q1.size
        for (i in 0 until q1.size - 1) {
            q2.add(q1.removeLast())
        }
        var item = q1.removeLast()
        q1 = q2
        return item
    }

    @ExperimentalStdlibApi
    fun print() {
        println(q1.toList())
    }
}

@ExperimentalStdlibApi
fun main() {
    val s = MyStack()
    s.push(1)
    s.push(2)
    s.push(3)
    s.print()
    s.pop()
    s.print()
    s.pop()
    s.print()
}
