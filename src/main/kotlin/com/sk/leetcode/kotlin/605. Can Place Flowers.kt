package leetcode.kotlin.array.easy

private fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
    var lastOne = -1
    var count = 0
    for (i in flowerbed.indices) {
        if (flowerbed[i] == 1) lastOne = i
        else if (flowerbed[i] == 0 &&
            (lastOne == -1 || i - lastOne > 1) &&
            (i == flowerbed.lastIndex || flowerbed[i + 1] != 1)
        ) {
            lastOne = i
            count++
        }
    }
    return count >= n
}