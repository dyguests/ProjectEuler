package q625_Gcd_sum

import util.MathUtils

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

//        test(10L, 15L)
        find(10)//result=122
//        find(MathUtils.pow(10, 11))

        val end = System.currentTimeMillis()
        println("cost:${end - start}ms")
    }

    private fun find(n: Long) {
        val result = GcdSum.g(n)
        println("$n -> $result")
    }

    private fun test(i: Long, j: Long) {
        println("$i,$j -> ${MathUtils.gcd(i, j)}")
    }
}

object GcdSum {
    fun g(n: Long): Long {
        var sum = 0L
        for (j in 1..n) {
            for (i in 1..j) {
                sum += gcd(i, j)
            }
        }
        return sum
    }

    private fun gcd(i: Long, j: Long): Long {
        return MathUtils.gcd(i, j)
    }
}
