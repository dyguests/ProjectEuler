package q627_Counting_products

object Q627 {
    @JvmStatic
    fun main(args: Array<String>) {
        val start = System.currentTimeMillis()
        find(9, 2)
        val end = System.currentTimeMillis()
        println("cost:${end - start}ms")
    }

    private fun find(m: Long, n: Long) {
        println("$m,$n -> ${CountingProducts.fMod(m, n)}")
    }

}

object CountingProducts {

    fun fMod(m: Long, n: Long): Long {
        val set = HashSet<Long>()
        for (x in 1..9L) {
            for (y in 1..9L) {
                set.add(x * y)
            }
        }
        return set.count().toLong()
    }
}
