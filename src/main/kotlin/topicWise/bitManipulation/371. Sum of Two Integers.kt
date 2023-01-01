package topicWise.bitManipulation

private fun getSum(a: Int, b: Int): Int {
    var a = a
    var b = b
    while (b != 0) {
        var carry = a.and(b) // carry contains common set bits
        a = a.xor(b) // sum of bits where at least 1 common bit is not set
        carry = carry.shl(1) // carry needs to be added 1 place left side
        b = carry
    }
    return a
}

fun getSum2(a: Int, b: Int): Int {
    var a = a
    var b = b
    var c: Int
    while (b != 0) {
        c = a and b
        a = a xor b
        b = c shl 1
    }
    return a
}

// TODO write substract function in same way
