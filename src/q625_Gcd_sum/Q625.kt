package q625_Gcd_sum

/**
 * https://projecteuler.net/problem=625
 *
 *
 * G(N)=∑Nj=1∑ji=1gcd(i,j).
 * You are given: G(10)=122.
 *
 * Find G(1011). Give your answer modulo 998244353
 */
object Q625 {
    @JvmStatic
    fun main(args: Array<String>) {
        val start = System.currentTimeMillis()

        find(10)//result=122
//        find(MathUtils.pow(10, 11))

        val end = System.currentTimeMillis()
        println("cost:${end - start}ms")
    }

    private fun find(n: Long) {
        val result = GcdSum.g(n)
        println("$n -> $result")
    }
}

object GcdSum {
    fun g(n: Long): Long {
        return 11
    }
}
