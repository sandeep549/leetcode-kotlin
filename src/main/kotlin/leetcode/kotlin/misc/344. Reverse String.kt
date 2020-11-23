package leetcode.kotlin.misc

fun reverseString1(s: CharArray) {
    s.reverse()
}

// for loop swapping
fun reverseString2(s: CharArray) {
    for (i in 0 until s.size / 2) {
        s[i] = s[s.lastIndex - i].also { s[s.lastIndex - i] = s[i] }
    }
}

// while loop swapping
fun reverseString3(s: CharArray) {
    var start = 0
    var end = s.lastIndex
    while (start < end) {
        s[start] = s[end].also { s[end] = s[start] }
        start++
        end--
    }
}
