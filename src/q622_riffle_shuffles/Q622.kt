package q622_riffle_shuffles

object Q622 {
    @JvmStatic
    fun main(args: Array<String>) {
        val start = System.currentTimeMillis()

        find(8)
//        println(MathUtils.pow(2,60))

        val end = System.currentTimeMillis()
        println("cost:${end - start}ms")

   }

    private fun find(times: Long) {
        println("$times -> ${RiffleShuffles.sumOfN(times)}")
    }
}

object RiffleShuffles {
    fun sumOfN(times: Long): Long {
        var sum = 0L

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
