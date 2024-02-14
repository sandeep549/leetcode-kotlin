package com.sk.topicWise.dp

import kotlin.math.max

class Solution516 {
    fun longestPalindromeSubseq(s: String): Int {
        val dp = Array(s.length) { IntArray(s.length){ -1 } }
        fun find(l: Int, r: Int): Int { // find max palindrome subsequence in [l,r]
            if(l > r) return 0
            if(l == r) return 1
            if(dp[l][r] == -1) {
                if(s[l] == s[r]) {
                    dp[l][r] = find(l+1, r-1) + 2
                } else {
                    dp[l][r] = maxOf(find(l, r-1), find(l+1, r))
                }
            }
            return dp[l][r]
        }
        dp[0][s.length-1] = find(0, s.length-1)
        return dp[0][s.length-1]
    }

    fun longestPalindromeSubseq2(s: String): Int {
        val dp = Array(s.length) { IntArray(s.length) }
        for (l in s.indices.reversed()) {
            dp[l][l] = 1
            for (r in l+1 until s.length) {
                if (s[l] == s[r]) {
                    dp[l][r] = dp[l+1][r-1] + 2
                } else {
                    dp[l][r] = maxOf(dp[l][r-1], dp[l+1][r])
                }
            }
        }
        return dp[0][s.length-1]
    }
}

class Solution {
    fun maxPalindromesAfterOperations(words: Array<String>): Int {
        val arr = IntArray(26)
        for(word in words) {
            for(ch in word.toCharArray()) {
                arr[ch-'a']++
            }
        }
        words.sortBy { it.length }

        var ans = 0
        for(word in words) {
            var len = word.length
            for(i in arr.indices) {
                if(arr[i] == 0) continue
                if(len % 2 == 0 && arr[i] % 2 == 0) {
                    if(arr[i] >= len) {
                        arr[i] -= len
                        len = 0
                    } else {
                        len -= arr[i]
                        arr[i] = 0
                    }
                } else if(len % 2 != 0 && arr[i] % 2 != 0){
                    arr[i] -= 1
                    len--
                }
                if(len == 0) break
            }
            if(len == 0) {
                ans++
            }
        }
        return ans
    }
}