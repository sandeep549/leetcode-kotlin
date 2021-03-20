import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

private class Solution(val radius: Double, val x_center: Double, val y_center: Double) {

    fun randPoint(): DoubleArray {
        val len: Double = sqrt(Math.random()) * radius
        val deg = Math.random() * 2 * Math.PI
        val x: Double = x_center + len * cos(deg)
        val y: Double = y_center + len * sin(deg)
        return doubleArrayOf(x, y)
    }
}
