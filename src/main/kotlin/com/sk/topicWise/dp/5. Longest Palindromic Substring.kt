package com.sk.topicWise.dp

class Solution5 {
    private var start = 0
    private var maxLen = 0
    fun longestPalindrome(s: String): String {
        val len = s.length
        if (len < 2) return s
        for (i in 0 until len - 1) {
            extendPalindrome(s, i, i) //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i + 1) //assume even length.
        }
        return s.substring(start, start + maxLen)
    }

    private fun extendPalindrome(s: String, l: Int, r: Int) {
        var l = l
        var r = r
        while (l >= 0 && r < s.length && s[l] == s[r]) {
            l--
            r++
        }
        if (maxLen < r - l - 1) {
            start = l + 1
            maxLen = r - l - 1
        }
    }

    /**
     * go to every index
     * make current index as palindrome center and expand both side, mark max found
     * make pre and current both as center, expand palindrome, mark max found
     */
    fun longestPalindrome2(s: String): String {
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


// dp, bottom-up
// Time:O(n^2)

    fun longestPalindrome3(str: String): String {
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
}


// Taken from comments of
// https://leetcode.com/problems/longest-palindromic-substring/solutions/151144/bottom-up-dp-two-pointers
class Solution5_2 {
    /**
     * If you do the brute force way you would generate a lot more strings than this method looks at.
     * which is set of all subsets ( rather substrings) -
     * E(sigma) (n-i) as i runs from 1 to n-1 = n-squared + n(n+1)/2 - O(n-squared) complexity.
     * This problem can be done using DP with n-squared complexity as shown above by [@GraceMeng](https://leetcode.com/GraceMeng)
     * with a few comments below by me based on that
     */
    fun longestPalindrome(s: String?): String? {
        if (s == null || s.length <= 1) return s
        val len = s.length
        // dp[i][j] stands for status of a substring starting at i and ending at j incl j
        val dp = Array(len) { BooleanArray(len) }

        // initialize all the 1 character palins
        for (i in 0 until len) {
            dp[i][i] = true
        }

        // to compute dp[i][j] we need dp[i+1][j-1]
        // so the i - outer loop needs to go from higher to lower
        // and the j - inner loop needs to go from lower to higher
        var maxLen = 0
        var maxSta = 0
        var maxEnd = 0
        for (i in len downTo 0) {
            // dist of 0 - already covered by initialization
            for (dist in 1 until len - i) {
                val j = i + dist
                // we are ready to compute dp [i] [j]
                if (dist == 1 && s[i] == s[j]) {
                    dp[i][j] = true
                } else if (s[i] == s[j]) {
                    dp[i][j] = dp[i + 1][j - 1]
                }
                // if true
                if (dp[i][j] && maxLen < j - i + 1) {
                    maxLen = j - i + 1
                    maxSta = i
                    maxEnd = j
                }
            }
        }
        return s.substring(maxSta, maxEnd + 1)
    }
}