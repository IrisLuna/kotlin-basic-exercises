fun main() {    

    var students1 = getFirstArrayOfStudents()
    var students2 = getSecondArrayOfStudents()

    var classroom1 = Classroom(1, 2, "Matemáticas", students1)
	var classroom2 = Classroom(2, 3, "HIstoria de la filosofía", students2)

    var allStudents = getAllStudents(students1, students2)
}

class Classroom (val id: Int, val grade: Int, val subject: String, var students: Array<Student>) {
    override fun toString() : String {
        return "Class $subject $grade has ${students.size} students.\nThe students in the class are as follows: ${getListedStudents(students)}"
    }

    fun getListedStudents(array: Array<Student>) : String {
        var concatenatedString = ""
        
        array.forEach{
            concatenatedString = "$concatenatedString\n$it" 
        }
        
        return concatenatedString
    }
}

class Student (val studentId: Int, var name: String, var passSubject: Boolean, var isProgressing: Boolean, var needsHelp: Boolean = false) {
    override fun toString() : String {
        return "Student ID: $studentId -> $name\nDoes the student pass the subject? ${doesStudentPassSubject()}"
    }

    fun doesStudentPassSubject() : String{
        if(passSubject) return "Yes :D" else return "No :("
    }
}


private fun getAllStudents(firstArray: Array<Student>, secondArray: Array<Student>) : Array<Student> {
    return firstArray+secondArray
}

private fun getFirstArrayOfStudents(): Array<Student> {
    var student1= Student(1, "Kevin", getRandomBool(), getRandomBool())
    var student2=  Student(2, "Patricio", getRandomBool(), getRandomBool())
    var student3= Student(3, "Alejandro", getRandomBool(), getRandomBool())
    var student4= Student(4, "Laura", getRandomBool(), getRandomBool())
    var student5= Student(5, "Paulina", getRandomBool(), getRandomBool())
    var student6= Student(6, "Sandra", getRandomBool(), getRandomBool())
    var student7= Student(7, "Estefan", getRandomBool(), getRandomBool())
    var student8= Student(8, "Pablo", getRandomBool(), getRandomBool())
    var student9= Student(9, "Cristian", getRandomBool(), getRandomBool())
    var student10= Student(10, "Josep", getRandomBool(), getRandomBool())

    return arrayOf(student1, student2, student3, student4, student5, student6, student7, student8, student9, student10)
}


private fun getSecondArrayOfStudents(): Array<Student> {
    var student11= Student(11, "Eva", getRandomBool(), getRandomBool())
    var student12= Student(12, "Maria del Carmen", getRandomBool(), getRandomBool())
    var student13= Student(13, "Alberto", getRandomBool(), getRandomBool())
    var student14= Student(14, "Ana María", getRandomBool(), getRandomBool())
    var student15= Student(15, "Irina", getRandomBool(), getRandomBool())
    var student16= Student(16, "Luís", getRandomBool(), getRandomBool())
    var student17= Student(17, "Federico", getRandomBool(), getRandomBool())
    var student18= Student(18, "Natalia", getRandomBool(), getRandomBool())
    var student19= Student(19, "Jorge", getRandomBool(), getRandomBool())
    var student20= Student(20, "David", getRandomBool(), getRandomBool())

    return arrayOf(student11, student12, student13, student14, student15, student16, student17, student18, student19, student20)
}

private fun getRandomBool() : Boolean {
    return listOf(true, false).random()
}

private fun listStudentsThatAreNotProgressing(allStudents: Array<Student>) {
    println("Students that are not progressing:")
    allStudents.forEach {
        if(!it.isProgressing && !it.passSubject) {
            println("$it")
        }
    }
}

private fun listStudentsThatNeedHelp(allStudents: Array<Student>) {
    println("Students that need help:")
    allStudents.forEach {
        if(it.needsHelp && !it.passSubject) {
            println("$it")
        }
    }
}

private fun setNeedsHelp(allStudents: Array<Student>) {
    allStudents.forEach {
        if(!it.passSubject && !it.isProgressing) {
        	it.needsHelp = true
        } else {
            it.needsHelp = false
        }
    }
}

private fun listAllStudentsWhoseNameContainsSpecifiedChar(char : Char, allStudents: Array<Student>) {
    allStudents.forEach {
        if(it.name.contains(char)) {
            println(it)
        }
    }
}

private fun getAllNotPassed(allStudents: Array<Student>) : MutableList<Student> {
    var mutlist : MutableList<Student> = mutableListOf()
    
	allStudents.forEach {
        if(!it.passSubject) {
           mutlist.add(it)
        }
    }
    
    return mutlist
}