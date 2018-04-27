package q622_Riffle_Shuffles

import java.util.ArrayList


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
     * 分解times的质因子
     *  eg: input 60 output {2,2,3,5}
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
     *
     * 不包含1，包含基本身
     *
     * eg: input 60 output {2,3,4,5,6,10,15,20,30,60}
     */
    fun findFactors(num: Long): List<Long> {
        val primeFactors = findPrimeFactors(num)

        val subSet = getSubSet(primeFactors)

        return subSet
                .filter { it.isNotEmpty() }
                .map {
                    var product = 1L
                    for (l in it) {
                        product *= l
                    }
                    product
                }
                .distinct()

//        return (2L..num / 2).filter { num % it == 0L }
    }

    /**
     * 取得一个集合的所有子集
     *
     * TODO:注：可能会出现重复的 如 {2,2,3} 的子集可能会有 {2(第一个2),3},{2(第二个2),3},还需要一个去重处理
     */
    fun getSubSet(set: List<Long>): List<List<Long>> {
        val result = ArrayList<ArrayList<Long>>()
        if (set.isNotEmpty()) {
            var i = 0
            while (i < Math.pow(2.0, set.size.toDouble())) {// 集合子集个数=2的该集合长度的乘方
                val subSet = ArrayList<Long>()
                var index = i// 索引从0一直到2的集合长度的乘方-1
                for (j in set.indices) {
                    // 通过逐一位移，判断索引那一位是1，如果是，再添加此项
                    if (index and 1 == 1) {// 位与运算，判断最后一位是否为1
                        subSet.add(set[j])
                    }
                    index = index shr 1// 索引右移一位
                }
                result.add(subSet) // 把子集存储起来
                i++
            }
        }
        return result
    }

    /**
     * 获取最大公因数
     */
    fun gcd(ii: Long, jj: Long): Long {
        if (ii == 0L || jj == 0L) return 0L
        var i = if (ii > jj) ii else jj
        var j = if (ii > jj) jj else ii

        var t: Long
        do {
            t = i % j
            i = j
            j = t

        } while (t != 0L)
        return j
    }

}