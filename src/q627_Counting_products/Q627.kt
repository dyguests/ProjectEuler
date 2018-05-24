package q627_Counting_products

object Q627 {
    @JvmStatic
    fun main(args: Array<String>) {
        val start = System.currentTimeMillis()
//        find(4, 2)
        find(4, 3)
//        find(4, 4)
//        find(4, 5)
//        find(5, 2)
//        find(5, 3)
//        find(5, 4)
//        find(5, 5)
//        find(9, 2)
//        find(9, 3)
//        find(9, 4)
//        find(9, 5)
//        find(30, 2)
//        find(30, 3)
//        find(30, 4)
//        find(30, 5)
//        find(30, 10001)
        val end = System.currentTimeMillis()
        println("cost:${end - start}ms")
    }

    private fun find(m: Long, n: Long) {
        println("F($m,$n) -> ${CountingProducts.fMod(m, n)}")
//        println("F($m,$n) -> ${CountingProducts.fModTmp(m, n)}")
    }

}

object CountingProducts {
    private const val MOD_NUM = 1000000007L

    fun fMod(m: Long, n: Long): Long {
        val decompositions = decomposition(m)

//        var result =

//        30^10001,不管重复的话，关键在于怎么去重

        return 0L % MOD_NUM
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

    fun fModTmp(m: Long, n: Long): Long {
        var set = setOf(1L)

        for (l in 1..n) {
            set = set.map { o -> (1..m).map { o * it } }.flatten().toSet()
        }

        return set.count().toLong()
    }

    /**
     * 专门用来存储 一个乘方数，保存 底 和 幂
     */
    data class PowerNum(val num: Long, var power: Long)
}
