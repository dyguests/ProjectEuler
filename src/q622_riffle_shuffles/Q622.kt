package q622_riffle_shuffles

object Q622 {
    @JvmStatic
    fun main(args: Array<String>) {
        val start = System.currentTimeMillis()
//        find(4)
        find(8)
//        find(60)
        val end = System.currentTimeMillis()
        println("cost:${end - start}ms")
    }

    private fun find(times: Long) {
        println("$times -> ${RiffleShuffles.sumOfN(times)}")
//        println("$times -> ${RiffleShuffles.riffle(0, 10, 1)}")
//        println("$times -> ${RiffleShuffles.riffle(1, 10, 1)}")
//        println("$times -> ${RiffleShuffles.riffle(2, 10, 1)}")
//        println("$times -> ${RiffleShuffles.riffle(3, 10, 1)}")
//        println("$times -> ${RiffleShuffles.riffle(4, 10, 1)}")
//        println("$times -> ${RiffleShuffles.riffle(5, 10, 1)}")
//        println("$times -> ${RiffleShuffles.riffle(6, 10, 1)}")
//        println("$times -> ${RiffleShuffles.riffle(7, 10, 1)}")
//        println("$times -> ${RiffleShuffles.riffle(8, 10, 1)}")
//        println("$times -> ${RiffleShuffles.riffle(9, 10, 1)}")
    }
}

object RiffleShuffles {
    fun sumOfN(times: Long): Long {
        var sum = 0L
//        for (n in times..(times * times * times) step 2) {
        for (n in 52L..52L step 2) {
            if (s(n, times)) {
                println("S($n)=$times")
                sum += n
            }
        }
        return sum
    }

    /**
     * 验证数量为n的牌堆是否**至少**切times次就可以复原
     *
     * 注：如何切times次可以复原，但切 times/n {n > 1} 也可以复原的话，不算
     */
    private fun s(n: Long, times: Long): Boolean {
        val factors: List<Long> = splitFactors(times)

        var currentK = 1L
        factors.forEachIndexed { index, factor ->
            currentK = riffle(currentK, n, factor)
            if (currentK == 1L && index < factors.size - 1) {
                return false
            }
        }
        return currentK == 1L
    }

    /**
     * 计算size为n的牌堆中第k张牌需求洗多少次才能恢复原位
     * 且超过times时不再计算
     * @param k k in [0,n-1]
     * @return 洗牌次数
     */
    private fun findTimes(k: Long, n: Long, maxTimes: Long): Long? {
        var spendedTimes = 0L
        var currentK = k
        do {
            if (spendedTimes >= maxTimes) {
                return null
            }

            currentK = riffle(currentK, n, 1)
            spendedTimes++
        } while (currentK != k)

        return spendedTimes
    }

    /**
     * 大于为n的牌堆中第k张牌在洗牌times次后的位置
     *
     * 这里简化成除余的算式
     *
     * @param k k in [0,n-1]
     */
    fun riffle(k: Long, n: Long, times: Long): Long {
        return MathUtils.pow(2, times) * k % (n - 1) //注：这里对最末一位计算有问题，但是我们不需要最末一位的计算
    }

    /**
     * 将times拆分成数个质数的积
     */
    private fun splitFactors(times: Long): List<Long> {
        val factors = ArrayList<Long>()

        var total = times
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


// 思路1
// 对 s(n)=60
// 牌堆第k张牌在洗一次之后的位置是 r(k,1)=if(k<2/n) 2k-1 else 2(k-2/n)-1
// r(k,2)=r(r(k,1),1)
// 对满足 r(k,60)=k 的 n  就是符合 s(n)=60 的解