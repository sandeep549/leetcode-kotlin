package leetcode.google

fun maximumDetonation(bombs: Array<IntArray>): Int {
    var res = 0
    for (i in bombs.indices) {
        val path = mutableSetOf<Int>()
        maxWithThisExplosion(bombs, i, path)
        res = maxOf(res, path.size)
    }
    return res
}

fun maxWithThisExplosion(bombs: Array<IntArray>, index: Int, path: MutableSet<Int>) {
    path.add(index)
    val explosion = bombs[index]
    for (i in bombs.indices) {
        if (!path.contains(i) && inRange(explosion, bombs[i])) {
            maxWithThisExplosion(bombs, i, path)
        }
    }
}

private fun inRange(a: IntArray, b: IntArray): Boolean {
    val dx = (a[0] - b[0]).toLong()
    val dy = (a[1] - b[1]).toLong()
    val r = a[2].toLong()
    return dx * dx + dy * dy <= r * r
}

// todo: this range function has some bug
fun isInRange(explosion: IntArray, bomb: IntArray): Boolean {
    return (bomb[0] - explosion[0]) * (bomb[0] - explosion[0]) + (bomb[1] - explosion[1]) * (bomb[1] - explosion[1]) <= explosion[2] * explosion[2]
}