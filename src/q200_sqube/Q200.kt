package q200_sqube

/**
 */
object Q9 {

    @JvmStatic
    fun main(args: Array<String>) {
        val start = System.currentTimeMillis()

        find(1)
//        find(200)

        val end = System.currentTimeMillis()
        println("cost:${end - start}ms")
    }

    private fun find(index: Int) {
        val result = Sqube.find(index)
        println("$index -> $result")
    }
}

object Sqube {

    fun find(index: Int): Long {
        return 1L
    }

}
