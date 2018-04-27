package q625_Gcd_sum

object Q625 {
    @JvmStatic
    fun main(args: Array<String>) {
        val start = System.currentTimeMillis()

        find(60)

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
