package q3_Largest_prime_factor

import kotlin.math.max

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
//        findLargestPrimeFactorAlgorithm(1)
//        findLargestPrimeFactorAlgorithm(8)
//        findLargestPrimeFactorAlgorithm(10)
        val start = System.currentTimeMillis()
        findLargestPrimeFactorAlgorithm(600851475143)
        val end = System.currentTimeMillis()
        println("cost:${end - start}ms")
    }

    private fun findLargestPrimeFactorAlgorithm(num: Long) {
        println("$num -> ${LargestPrimeFactorAlgorithm.find(num)}")
    }
}

object LargestPrimeFactorAlgorithm {
    /**
     * 质量集合
     */
    val primes = object : ArrayList<Long>() {
        override fun get(index: Int): Long {
            if (index >= size) {
                addNextPrime(index - 1)
            }
            return super.get(index)
        }

        /**
         * get the prime next of get(index).
         */
        private fun addNextPrime(index: Int) {
            var prime = get(index)
            do {
                prime += 2
            } while (!isPrimeCheckedByPrimes(prime))
            add(prime)
        }
    }.apply {
        add(2)
        add(3)
    }

    /**
     * 获取最大质因子
     */
    fun find(num: Long): Long {
        //要计算的数
        var lNum = num

        //最大质因子（当前为1，当取得更大质因子时更新）
        var largestPrimeFactor = 1L

        //质因子不可能大于这个值
        var factorMaxBound = lNum

        var indexOfPrimes = 0

        while (true) {
            while (!isFactor(lNum, primes[indexOfPrimes])) {
                if (primes[indexOfPrimes + 1] <= factorMaxBound) {
                    indexOfPrimes++
                } else {
                    break
                }
            }

            if (primes[indexOfPrimes] <= factorMaxBound) {
                largestPrimeFactor = max(largestPrimeFactor, primes[indexOfPrimes])

                lNum /= primes[indexOfPrimes]
                factorMaxBound = lNum
            } else {
                break
            }
        }

        return largestPrimeFactor
    }

    /**
     * 是否为质数
     *
     * 注：这里仅根据当前primes中存在的质数进行验证
     */
    private fun isPrimeCheckedByPrimes(num: Long): Boolean {
        return primes.none { num % it == 0L }
    }

    /**
     * factor是否是num的因子
     */
    private fun isFactor(num: Long, factor: Long): Boolean {
        return num % factor == 0L
    }
}