package leetcode.kotlin

private fun reverseBits(n: Int): Int {
    var no = n
    var result = 0
    for (i in 0..31) {
        result = result shl 1
        if (no and 1 == 1) result++
        no = no shr 1
    }
    return result
}

private fun reverseBits2(n: Int): Int {
    var no = n
    no = (no shr 16) or (no shl 16)
    no = ((no and 0xff00ff00.toInt()) shr 8) or ((no and 0x00ff00ff.toInt()) shl 8)
    no = ((no and 0xf0f0f0f0.toInt()) shr 4) or ((no and 0x0f0f0f0f.toInt()) shl 4)
    no = ((no and 0xcccccccc.toInt()) shr 2) or ((no and 0x33333333.toInt()) shl 2)
    no = ((no and 0xaaaaaaaa.toInt()) shr 1) or ((no and 0x55555555.toInt()) shl 1)
    return no
}

// private fun test(n: Int) : Int {
//     var n = n
//     n = n.shr(16).or(n.shl(16))
//     n = n.and(-0xff0100).shr(8).or(n.and(0x00ff00ff).shl(8))
//     n = n.and(-0xf0f0f10).shr(4).or(n.and(0x0f0f0f0f).shl(4))
//     n = n.and(-0x33333334).shr(2).or(n.and(0x33333333).shl(2))
//     n = n.and(-0x55555556).shr(1).or(n.and(0x55555555).shl(1))
//     return n
// }
//
// fun main() {
//     println(0xff00ff00)
//     println(-0xff0100)
// }

// TODO: 16/2/21 kotlin hexadecimal problem
// https://youtrack.jetbrains.com/issue/KT-2780
//https://youtrack.jetbrains.com/issue/KT-4749