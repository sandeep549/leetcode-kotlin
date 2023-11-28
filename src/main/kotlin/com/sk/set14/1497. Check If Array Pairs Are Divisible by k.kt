package com.sk.set14

private fun canArrange2(arr: IntArray, k: Int): Boolean {
    val set = mutableSetOf<Int>()
    for (i in 0 until arr.lastIndex) {
        if (set.contains(i)) continue
        for (j in i + 1..arr.lastIndex) {
            if (set.contains(j)) continue
            if ((arr[i] + arr[j]) % k == 0) {
                set.add(i)
                set.add(j)
                break
            }
        }
        if (!set.contains(i)) return false
    }
    return true
}

private fun canArrange(arr: IntArray, k: Int): Boolean {
    val frequency = IntArray(k)
    for (num in arr) {
        var no = num % k
        if (no < 0) no += k
        frequency[no]++
    }
    if (frequency[0] % 2 != 0) return false
    for (i in 1..k / 2) {
        if (frequency[i] != frequency[k - i]) return false
    }
    return true
}
