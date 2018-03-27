package q622_riffle_shuffles

object Q622 {
    @JvmStatic
    fun main(args: Array<String>) {
        val start = System.currentTimeMillis()

        find(60)

        val end = System.currentTimeMillis()
        println("cost:${end - start}ms")

    }

    private fun find(times: Long) {
        println("$times -> ${RiffleShuffles.sumOfN(times)}")
    }
}

object RiffleShuffles {
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
