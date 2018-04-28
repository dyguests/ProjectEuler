package q9_Special_Pythagorean_triplet

/**
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
