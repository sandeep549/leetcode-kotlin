package com.sk.set16

class Solution {
    fun numberOfMatches(n: Int): Int {
        var matches = 0
        var teams = n
        while (teams != 1) {
            if (teams % 2 == 0) {
                matches += (teams/2)
                teams /= 2
            } else {
                matches += (teams-1)/2
                teams = (teams-1)/2 + 1
            }
        }
        return matches
    }
}