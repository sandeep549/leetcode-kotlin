package leetcode.kotlin

fun main() {
    println(longestCommonPrefix(arrayOf("flow", "flower", "flight")))
}

private fun longestCommonPrefix(strs: Array<String>): String {
    val common = StringBuilder()
    if (strs.isEmpty()) return common.toString()
    for (index in 0..strs[0].lastIndex) {
        var ch = strs[0][index]
        for (str in 1..strs.lastIndex) {
            if (index > strs[str].lastIndex || strs[str][index] != ch) {
                return common.toString()
            }
        }
        common.append(ch)
    }
    return common.toString()
}