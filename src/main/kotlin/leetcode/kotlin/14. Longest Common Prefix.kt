package leetcode.kotlin

fun main() {
    println(longestCommonPrefix(arrayOf("flow", "flower", "flight")))
}

private fun longestCommonPrefix(strs: Array<String>): String {
    val common = StringBuilder()
    if (strs.isEmpty()) return common.toString()
    for (index in 0 until strs[0].length) {
        val ch = strs[0][index]
        for (str in 1 until strs.size) {
            if (index >= strs[str].length || strs[str][index] != ch) {
                return common.toString()
            }
        }
        common.append(ch)
    }
    return common.toString()
}
