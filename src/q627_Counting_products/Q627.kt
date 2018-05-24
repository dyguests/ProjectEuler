package q627_Counting_products

import java.util.ArrayList

object Q627 {
    @JvmStatic
    fun main(args: Array<String>) {
        val start = System.currentTimeMillis()
        find(9, 2)
        val end = System.currentTimeMillis()
        println("cost:${end - start}ms")
    }

    private fun find(m: Long, n: Long) {
        println("$m,$n -> ${CountingProducts.fMod(m, n)}")
    }

}

object CountingProducts {

    fun fMod(m: Long, n: Long): Long {
        val decompositions = decomposition(m)

//        30^10001,不管重复的话，关键在于怎么去重

        return 0L
    }

    /**
     * 获取 1..m 中的所有值，即1,2,3...m,以因子集的的形式，即 1,2,3,2^2,5,2*3,7,2^3,3^2,2*5,11,2^2*3,...
     *
     * @return 从1到m的每个map<num,power>
     */
    private fun decomposition(m: Long): List<HashMap<Long, Long>> {
        return (1..m).map { findPrimeFactors2(it) }
    }

    /**
     * 获取 1..m 中的所有值，即1,2,3...m,以因子集的的形式，即 1,2,3,2^2,5,2*3,7,2^3,3^2,2*5,11,2^2*3,...
     *
     * @return 这里的结构是 map<num,power> , num是因子，power是个数
     */
    private fun findPrimeFactors2(num: Long): HashMap<Long, Long> {
        // 这里的结构是 map<num,power> , num是因子，power是个数
        val factors = HashMap<Long, Long>()

        var total = num
        var factor = 2L
        while (factor <= total) {
            if (total % factor == 0L) {
                factors[factor] = factors[factor]?.let { it + 1L } ?: 1L
                total /= factor
            } else {
                factor++
            }
        }

        return factors
    }

    fun fMod9_2(m: Long, n: Long): Long {
        val set = HashSet<Long>()
        for (x in 1..9L) {
            for (y in 1..9L) {
                set.add(x * y)
            }
        }
        return set.count().toLong()
    }

    /**
     * 专门用来存储 一个乘方数，保存 底 和 幂
     */
    data class PowerNum(val num: Long, var power: Long)
}
