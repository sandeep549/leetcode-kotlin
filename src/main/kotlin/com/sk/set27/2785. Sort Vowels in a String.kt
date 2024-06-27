package com.sk.set27

class Solution2785 {
    fun sortVowels(s: String): String {
        val vowelSet = setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')

        val arr = s.toCharArray()
        val vowels = mutableListOf<Char>()
        for (ch in s) {
            if (vowelSet.contains(ch)) vowels.add(ch)
        }

        vowels.sortWith(Comparator { o1, o2 -> o1.code.compareTo(o2.code) })

        var i = 0
        for (k in arr.indices) {
            if (vowelSet.contains(arr[k])) {
                arr[k] = vowels[i++]
            }
        }

        return String(arr)
    }

    private fun isVowel(c: Char): Boolean {
        return c == 'a' || c == 'e' || c == 'o' || c == 'u' || c == 'i' || c == 'A' || c == 'E' || c == 'O' || c == 'U' || c == 'I'
    }

    fun sortVowels2(s: String): String {
        val count = IntArray(57)

        // Store the frequencies for each character.
        for (c in s.toCharArray()) {
            if (isVowel(c)) {
                count[c.code - 'A'.code]++
            }
        }

        // Sorted string having all the vowels.
        val sortedVowel = "AEIOUaeiou"
        val ans = StringBuilder()
        var j = 0
        for (i in s.indices) {
            if (!isVowel(s[i])) {
                ans.append(s[i])
            } else {
                // Skip to the character which is having remaining count.
                while (count[sortedVowel[j].code - 'A'.code] == 0) {
                    j++
                }
                ans.append(sortedVowel[j])
                count[sortedVowel[j].code - 'A'.code]--
            }
        }
        return ans.toString()
    }
}