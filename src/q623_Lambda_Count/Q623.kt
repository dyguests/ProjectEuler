package q623_Lambda_Count

object Q623 {
    @JvmStatic
    fun main(args: Array<String>) {
        val start = System.currentTimeMillis()

        find(60)

        val end = System.currentTimeMillis()
        println("cost:${end - start}ms")
    }

    private fun find(times: Long) {
        println("$times -> ${LambdaCount.aA()}")
    }
}

object LambdaCount {
    fun aA(): Long {

        return 1
    }
}
