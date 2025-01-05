package com.sk.set19

class Solutio1930 {
    fun countPalindromicSubsequence(s: String): Int {
        val first = IntArray(26) { -1 }
        val last = IntArray(26)
        var result = 0

        // Populate first and last occurrence arrays
        for (i in s.indices) {
            val charIndex = s[i] - 'a'
            if (first[charIndex] == -1) {
                first[charIndex] = i
            }
            last[charIndex] = i
        }

        // Calculate unique characters between first and last occurrence for each character
        for (i in 0 until 26) {
            if (first[i] != -1 && first[i] < last[i]) {
                val seen = BooleanArray(26)
                for (j in first[i] + 1 until last[i]) {
                    seen[s[j] - 'a'] = true
                }
                result += seen.count { it }
            }
        }
        return result
    }
}

/*
Key Optimizations:
	1.	Avoid substring Creation:
	•	Instead of creating a substring for the range between first[i] and last[i], we iterate directly over the range. This avoids extra memory allocation and string operations.
	2.	Replace distinct and count:
	•	Using a BooleanArray(26) to track seen characters is more efficient than converting to a Set with .distinct() and then counting.
	3.	Default Values in first Array:
	•	Instead of initializing with Int.MAX_VALUE, initialize first with -1 for clarity and efficiency. This makes checking uninitialized indices straightforward.
	4.	Better Variable Naming:
	•	Renamed res to result for better readability.

Complexity:
	•	Time Complexity: O(n + 26 * m), where n is the length of the string and m is the average length between first and last occurrence for each character.
	•	Space Complexity: O(26), due to first, last, and seen arrays.
 */