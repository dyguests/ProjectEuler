package q9_Special_Pythagorean_triplet

/**
 * https://projecteuler.net/problem=625
 *
 *
 * G(N)=∑Nj=1∑ji=1gcd(i,j).
 * You are given: G(10)=122.
 *
 * Find G(1011). Give your answer modulo 998244353
 */
object Q9 {

    @JvmStatic
    fun main(args: Array<String>) {
        val start = System.currentTimeMillis()

//        find(12)
        find(1000)

        val end = System.currentTimeMillis()
        println("cost:${end - start}ms")
    }

    private fun find(sum: Int) {
        val result = PythagoreanTriplet.abc(sum)
        println("$sum -> $result")
    }
}

object PythagoreanTriplet {
    fun abc(sum: Int): Any {
        for (c in ((sum + 2) / 3)..(sum - 3)) {
            for (b in ((c + 1) / 2 + 1)..(c - 2)) {
                val a = sum - c - b
                if (a * a + b * b == c * c) {
                    return a * b * c
                }
            }
        }
        return 0
    }

}
