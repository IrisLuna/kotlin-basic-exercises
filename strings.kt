fun main() {
    //1.
    concatenateTwoStrings("this is a string", "another string")

    //2.
    replaceCharacterInString("Hello World!", 'o', 'i')

    //3.
    removeGivenLastCharacterOfString("this string is an example", 'e')
    removeGivenLastCharacterOfString("this string is an example", 'z')

    //4.
    println(getFirstTwoCharacterInString("Kotlin"))

    //5.
    println(checkIfStringStartsAndEndsWithSameTwoCharacters("hello!"))
    println(checkIfStringStartsAndEndsWithSameTwoCharacters("hi friend hi"))

    //6.
    println(checkIfTwoStringsAreTheSameEvenWithCapitalLetters("hi friend!", "HI FRIEND!"))
    println(checkIfTwoStringsAreTheSameEvenWithCapitalLetters("ONETWO", "threefour"))
}

private fun concatenateTwoStrings(firstString: String, secondString: String) {
    val concatenatedString = "$firstString$secondString"
    println(concatenatedString)
}

private fun replaceCharacterInString(sentence : String, originalChar: Char, replaceChar: Char) {
    val replacedSentence = sentence.replace(originalChar, replaceChar)
    println(replacedSentence)
}

private fun removeGivenLastCharacterOfString(sentence : String, charToRemove: Char) {
    if(sentence.last() == charToRemove){
        val newSentence = sentence.dropLast(1)
        println(newSentence) 
    } else {
        println("The string given does not have '$charToRemove' as last character.")
    }
}

private fun getFirstTwoCharacterInString(sentence : String) : String {
    val newSentence = "${sentence.take(2)}${sentence.take(2)}"
    return newSentence
}

private fun checkIfStringStartsAndEndsWithSameTwoCharacters(sentence : String) : Boolean{
    return sentence.take(2)==sentence.takeLast(2)
}

private fun checkIfTwoStringsAreTheSameEvenWithCapitalLetters(firstString: String, secondString: String) : Boolean{
    return firstString.lowercase()==secondString.lowercase()
}