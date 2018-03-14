package q622_riffle_shuffles

object MathUtils {
    /**
     * 整型乘方
     * 注：可能溢出！
     */
    fun pow(base: Long, exponent: Long): Long {
        var result = 1L
        for (i in 1..exponent) {
            result *= base
        }
        return result
    }
}