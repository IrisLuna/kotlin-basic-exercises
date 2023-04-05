fun main() {
    //Numbers

    //1.
    println(addTwoIntegerNumbers(2, 2))

    //2.
    println(multiplyTwoIntegerNumbers(2, 2))

    //3.
    println(divideTwoIntegerNumbers(5, 2))
    println(divideTwoIntegerNumbers(0, 2))
    println(divideTwoIntegerNumbers(5, 0))

    //4.
    println(divideTwoIntegerNumbersAndGetIntResult(5, 2))

    //5.
    getFootballVictoryPercentage(10, 9)
    getFootballVictoryPercentage(14, 57)
    getFootballVictoryPercentage(0, 57)
    getFootballVictoryPercentage(11, 0)
    getFootballVictoryPercentage(10, -7)

    //6.
    println(getGreaterNumber(2, 8))
    println(getGreaterNumber(7, -5))
    println(getGreaterNumber(-6, -6))

    //7.
    calculateXAmountOfPrimeNumbers(1)
    calculateXAmountOfPrimeNumbers(5)
    calculateXAmountOfPrimeNumbers(7)
}

private fun addTwoIntegerNumbers(a: Int, b: Int) : Int {
    return (a + b)
}

private fun multiplyTwoIntegerNumbers(a: Int, b: Int) : Int {
    return (a * b)
}

private fun divideTwoIntegerNumbers(a: Int, b: Int) : Double? {
    if(b == 0) {
        return null
    } else {
        return (a.toDouble()/b.toDouble())
    }
}

private fun divideTwoIntegerNumbersAndGetIntResult(a: Int, b: Int) : Int? {
    if(b == 0) {
        return null
    } else {
        return (a/b)
    }
}

private fun getFootballVictoryPercentage(gamesPlayed: Int, gamesWon: Int)  {
    if (gamesPlayed<0 || gamesWon<0) {
        println("Values must be positive and integer.")
    } else if(gamesPlayed == 0) {
        println("No games were played.")
    } else if(gamesPlayed < gamesWon){
        println("The number of games won can not be greater than the number of games played. ")
    } else {
        val victoryPercentage = (100*gamesWon).toDouble()/gamesPlayed.toDouble()
        println("Games played: $gamesPlayed, games won: $gamesWon -> Victory percentage: $victoryPercentage%.")
    }
}

private fun getGreaterNumber(a : Int, b : Int) : Int?{
    if (a == b) {
        println("Values are the same")
        return null
    } else if(a > b) {
        return a
    } else {
        return b
    }
}

private fun getPoolVolume(width:Int, length:Int, height:Int){
    if(width < 0 || length < 0 || height < 0) {
        println("Values can not be negative.")
    } else {
        val volume = width*length*height
        println("Pool: width:$width, length:$length, height:$height -> pool volume:$volume")
    }
}

private fun calculateXAmountOfPrimeNumbers(x : Int) {
    var primeList : MutableList<Int> = mutableListOf()
    var i = 2
    
    while(primeList.size < x){
        checkIfNumberIsPrime(i, primeList)
        i++
	}
    
    println(primeList)
}

private fun checkIfNumberIsPrime(num: Int, primeList: MutableList<Int>) {
    var isPrime = false

    for (i in 2..num / 2) {
        //if there is a divisor greater than half of "num", 
        //then a smaller divisor would already have been found
        // in the first half of "num"

        if (num % i == 0) {
            isPrime = true
            break
        }
    }

    if (!isPrime) primeList.add(num)
}

