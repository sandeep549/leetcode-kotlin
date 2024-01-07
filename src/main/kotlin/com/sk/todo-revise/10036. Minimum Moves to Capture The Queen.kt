package com.sk.`todo-revise`

import kotlin.math.abs

class Solution10036 {
    fun minMovesToCaptureTheQueen(a: Int, b: Int, c: Int, d: Int, e: Int, f: Int): Int {
        if (a == e || b == f) { // rook and queen are in same row or column
            if (a == e && a == c && ((d-b) * (d-f) < 0)) return 2 // d is between b and f, bishop is in rooks way
            if (b == f && b == d && ((c-a) * (c-e) < 0)) return 2 // c is between a and e, bishop is in rooks way
            return 1
        }
        if (abs(c - e) == abs(d - f)) { // bishop and queen are in same diagonal
            if (abs(c - a) == abs(d - b) &&
                abs(e - a) == abs(f - b) &&
                ((b-f) * (b-d) < 0)) { // rook in bishops way
                return 2
            }
            return 1
        }
        return 2
    }
}