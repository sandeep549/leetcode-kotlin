package leetcode.kotlin.dp

// dp, bottom-up
// Time:O(n^2)
private fun longestPalindrome(str: String): String {
    val table = Array(str.length) { BooleanArray(str.length) }
    var max = 0
    var start = 0 // beginning index of max palindrome
    for (k in 1..str.length) { // size of palindrome
        for (i in 0..str.length - k) { // start index
            val j = i + k - 1
            if (k == 1) { // single length palindrome
                table[i][j] = true
            } else if (k == 2) {
                if (str[i] == str[j]) table[i][j] = true
            } else { // for more than 3 length, we'll have middle elements
                if (table[i + 1][j - 1] && str[i] == str[j]) table[i][j] = true
            }
            // we found new bigger palindrome
            if (table[i][j] && k > max) {
                max = k
                start = i
            }
            // println("i$i, j=$j, k=$k table=${table[i][j]}, max=$max, start=$start")
        }
    }
    return str.substring(start, start + max)
}

/**
 * go to every index
 * make current index as palindrome center and expand both side, mark max found
 * make pre and current both as center, expand palindrome, mark max found
 */
private fun longestPalindrome2(s: String): String {
    var left = 0
    var right = 0
    for (i in s.indices) {
        var l = i
        var r = i
        while (l >= 0 && r <= s.lastIndex && s[l] == s[r]) {
            l--
            r++
        }
        if (--r - ++l > right - left) {
            left = l
            right = r
        }

        if (i == 0) continue

        l = i - 1
        r = i
        while (l >= 0 && r <= s.lastIndex && s[l] == s[r]) {
            l--
            r++
        }
        if (--r - ++l > right - left) {
            left = l
            right = r
        }
    }
    return s.substring(left, right + 1)
}
