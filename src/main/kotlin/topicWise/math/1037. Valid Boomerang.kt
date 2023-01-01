package topicWise.math

/**
Compare slope
(y0 - y1) / (x0 - x1) != (y0 - y2) / (x0 - x2) =>
(x0 - x2) * (y0 - y1) != (x0 - x1) * (y0 - y2)
 */
private fun isBoomerang(p: Array<IntArray>): Boolean {
    return (p[0][0] - p[2][0]) * (p[0][1] - p[1][1]) != (p[0][0] - p[1][0]) * (p[0][1] - p[2][1])
}
