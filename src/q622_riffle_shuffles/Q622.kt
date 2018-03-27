package q622_riffle_shuffles

object Q622 {
    @JvmStatic
    fun main(args: Array<String>) {
        val start = System.currentTimeMillis()

        find(8)

        val end = System.currentTimeMillis()
        println("cost:${end - start}ms")

    }

    private fun find(times: Long) {
        println("$times -> ${RiffleShuffles2.sumOfN(times)}")
    }
}

object RiffleShuffles2 {
    fun sumOfN(times: Long): Long {
        //n张切t次可以复原可以简写成：(2^t-1)%(n-1)=0

        //当 n-1 in timesPowFactors 时，size为n的堆切time次后都可以复原
        val timesPowFactors = MathUtils.findFactors(MathUtils.pow(2, times) - 1L)

        //所有因子（不包含1和本身）
        val timesFactors = MathUtils.findFactors(times).filter { it != times }

        //将timesFactors中每个元素的n,中符合以下条件的列表一起放到一个列表中
        //即切timesFactors.each次就可以复原的结果集的
        val subTimesPowFactorss = timesFactors.map {
            //当 n-1 in 下面结果 时，size为n的堆切it次后都可以复原
            MathUtils.findFactors(MathUtils.pow(2, it) - 1L)
        }

        //至少切times次才能复原的所有的(n-1)结果集（即切times/2之类的不算）
        val list = timesPowFactors - subTimesPowFactorss.flatten().distinct()

        val nList = list.map { it + 1 }
        return nList.sum()
    }
}

object RiffleShuffles {
    fun sumOfN(times: Long): Long {
        var sum = 0L

        //(2^t-1)%(n-1)=0

        //[3, 3, 5, 5, 7, 11, 13, 31, 41, 61, 151, 331, 1321]
        //这因因子满足切n次复原，但不一定满足至少切n次才能复原
        val splitFactors = MathUtils.findPrimeFactors(MathUtils.pow(2, times) - 1L)

//        [3, 3, 7, 11, 31, 151, 331]
//        val notOnlySpiltFactors = MathUtils.findPrimeFactors(MathUtils.pow(2, 30) - 1L)


        for (n in 4L..MathUtils.pow(2, times) step 2) {
            if (s(n, times)) {
                println("S($n)=$times")
                sum += n
            }
        }

        return sum
    }

    /**
     * size为n的堆是否至少洗times次就可以复原
     */
    private fun s(n: Long, times: Long): Boolean {
        var currentK = 1L

        for (eachTime in 1L..(times - 1)) {
            currentK = riffle(currentK, n, 1)
            if (currentK == 1L) {
                return false
            }
        }

        return riffle(currentK, n, 1) == 1L
    }

    /**
     * 大于为n的牌堆中第k张牌在洗牌times次后的位置
     *
     * 这里简化成除余的算式
     *
     * @param k k in [0,n-2] 注
     */
    private fun riffle(k: Long, n: Long, times: Long): Long {
        return MathUtils.pow(2, times) * k % (n - 1) //注：这里对最末一位计算有问题，但是我们不需要最末一位的计算
    }

}
