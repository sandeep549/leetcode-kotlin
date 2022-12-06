
private fun isValid(s: String): Boolean {
    val stack = ArrayDeque<Char>()
    val openCloseMap = mapOf(
        '(' to ')',
        '{' to '}',
        '[' to ']'
    )
    for (ch in s) {
        if (openCloseMap.containsKey(ch)) {
            stack.addLast(ch)
        } else {
            if (stack.isNotEmpty() && openCloseMap[stack.last()] == ch) {
                stack.removeLast()
            } else {
                return false
            }
        }
    }

    return stack.isEmpty()
}


fun main() {
    println(isValid("()"))
}




