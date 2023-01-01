package topicWise.stack

import java.util.ArrayDeque

fun main() {
    check(isValid("(){}[]"))
    check(!isValid("(}"))
}

private fun isValid(s: String): Boolean {
    val map = hashMapOf(
        '(' to ')',
        '{' to '}',
        '[' to ']'
    )
    val stack = ArrayDeque<Char>()
    s.forEach { ch ->
        if (ch == map[stack.peek()]) stack.pop()
        else stack.push(ch)

    }
    return stack.isEmpty()
}
