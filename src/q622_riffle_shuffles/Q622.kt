package q622_riffle_shuffles

object Q622 {
    @JvmStatic
    fun main(args: Array<String>) {
        val start = System.currentTimeMillis()
        find(2)
//        find(60)
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
        for (n in 0L..4 step 2) {
            if (s(n, times)) {
                sum += n
            }
        }
        return sum
    }

    private fun s(n: Long, times: Long): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}


// 思路1
// 对 s(n)=60
// 牌堆第k张牌在洗一次之后的位置是 r(k,1)=if(k<2/n) 2k-1 else 2(k-2/n)-1
// r(k,2)=r(r(k,1),1)
// 对满足 r(k,60)=k 的 n  就是符合 s(n)=60 的解