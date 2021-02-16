package leetcode.kotlin.twopointer

fun main() {
//    println(Character.isLetter('A'))
//    println(Character.isLetter(' '))
//    println(Character.isLetter(','))
//    println(Character.isLetter('0'))
//    println(Character.isLetter(':'))
//    println(isPalindrome(".,"))
    println(isPalindrome("0P"))
}

private fun isPalindrome(s: String): Boolean {
    var l = 0
    var r = s.lastIndex
    while (l < r) {
        while (l < r && !s[l].isLetterOrDigit()) l++
        while (l < r && !s[r].isLetterOrDigit()) r--
        if (s[l].toLowerCase() != s[r].toLowerCase()) return false
        l++
        r--
    }
    return true
}

private fun isPalindrome2(s: String): Boolean {
    var l = 0
    var r = s.lastIndex
    while (l < r) {
        if (!s[l].isLetterOrDigit()) {
            l++
        } else if (!s[r].isLetterOrDigit()) {
            r--
        } else {
            if (s[l].toLowerCase() != s[r].toLowerCase()) return false
            l++
            r--
        }
    }
    return true
}
