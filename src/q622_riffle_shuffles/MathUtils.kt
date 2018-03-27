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
     * 找出times的质因子
     */
    fun findPrimeFactors(num: Long): List<Long> {
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

    /**
     * 找出times的因子
     */
    fun findFactors(num: Long): List<Long> {
        //TODO 这不是最优算法

        return (2L..num / 2).filter { num % it == 0L }
    }
}