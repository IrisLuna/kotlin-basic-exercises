fun main() {
    
    var array: IntArray = intArrayOf(1, 2, 3, 4, 5, 6, 4, 4)

    //1.
    var newArray : IntArray? = insertNumberInDesignatedPosition(4, 2, array)
    newArray?.forEach {
        println(it)
    }

    //2. 
    println(checkIfNumberIsInArray(1, array))
    println(checkIfNumberIsInArray(7, array))

    //3.
    println(getNumberOfOcurrencesOfNumberInArray(4, array))

    //4.
    array = sortIntArray(array, false)
    array.forEach {
        println(it)
    }

    //5.
    var stringArray = arrayOf<String>("apples", "oranges", "limes")
    stringArray = addNewStringToArray("tangerines", stringArray)
    
    stringArray.forEach {
        println(it)
    }

}

private fun insertNumberInDesignatedPosition(number: Int, position : Int, array :IntArray) : IntArray? {
    if(position > array.size) {
        return null
    } else {
        array[position] = number
        return array
    }
}

private fun checkIfNumberIsInArray(number: Int, array: IntArray) : Boolean{
    return number in array
} 

private fun getNumberOfOcurrencesOfNumberInArray(number: Int, array: IntArray) : Int{
    var ocurrences = 0
    array.forEach {
        if(it==number) ocurrences++
    }
    return ocurrences
} 

fun sortIntArray(array: IntArray, minToMax: Boolean): IntArray {
    val arraySize = array.size
    var temp: Int

    for (i in 0 until arraySize) {
        for (j in 1 until (arraySize - i)) {
            if(minToMax) {
                if (array[j - 1] > array[j]) {
                    temp = array[j - 1]
                    array[j - 1] = array[j]
                    array[j] = temp
                }
            } else {
                if (array[j - 1] < array[j]) {
                    temp = array[j - 1]
                    array[j - 1] = array[j]
                    array[j] = temp
                }
            }
        }
    }

    return array
}

fun saveIfMinOrMax() {
    
}

private fun addNewStringToArray(string: String, array : Array<String>) : Array<String> {
    return array.plus(string)
}

private fun getFirstNumberInRangeNotInArray(array: IntArray) : Int? {

    for(i in 1..1000000) {
        if(i !in array) return i
    }
    
    return null
}