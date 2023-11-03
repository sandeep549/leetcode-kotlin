package com.sk.topicWise.stack

import java.lang.StringBuilder

class Solution71 {
    fun simplifyPath(path: String): String {
        val stack = ArrayDeque<String>()
        for (dir in path.split("/")) {
            if (dir == "" || dir == ".") continue
            if (dir == "..") {
                if (stack.isNotEmpty()) stack.removeLast()
            } else {
                stack.addLast(dir)
            }
        }
        val res = StringBuilder()
        while (stack.isNotEmpty()) {
            res.append("/${stack.removeFirst()}")
        }
        return res.toString().ifEmpty { "/" }
    }
}


fun main() {
    val s = Solution71()
    println(s.simplifyPath("/a//b////c/d//././/.."))
}
