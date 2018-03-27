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

    /**
     * 将times拆分成数个质数的积
     */
     fun splitFactors(num: Long): List<Long> {
        val factors = ArrayList<Long>()

        var total = num
        var factor = 2L
        while (factor < total) {
            if (total % factor == 0L) {
                factors.add(factor)
                total /= factor
            } else {
                factor++
            }
        }
        factors.add(total)

        return factors
    }
}