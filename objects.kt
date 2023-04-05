fun main() {
    //1.
    var brand1 = createBrand("BMW", 1897, "Germany")
    println(brand1.name)

    //2.
    var car1 =  createCar("325", 2007, 250, brand1)
    println(car1.horsepower)
    println(car1.brand.year)

    //3. y 4.
    var roleCharacterA = RoleCharacter("Myriarth", 290, 150, 65, arrayOf(RoleCharacter.Races.ORC, RoleCharacter.Races.ELF))
    var roleCharacterB = RoleCharacter("Ruth", 250, 100, 50, arrayOf(RoleCharacter.Races.HUMAN, RoleCharacter.Races.DWARF))
    
    println("${roleCharacterA.name} -> attack : ${roleCharacterA.attack}")
    println("${roleCharacterB.name} -> health : ${roleCharacterB.health}, defense: ${roleCharacterB.defense}")
    roleCharacterA.attacks(roleCharacterB)
    println("${roleCharacterB.name} -> health : ${roleCharacterB.health}")

    //5.
    var spaceShip1 = SpaceShip("NUX-457-UI-29", 390, 120)
    println(spaceShip1.shipName)
    
    var fighter1 = Fighter("JDI0-7P", 500, spaceShip1.shipName, spaceShip1.health, spaceShip1.crew)
    var fighterCarrier1 = FighterCarrier(90, 500, spaceShip1.shipName, spaceShip1.health, spaceShip1.crew)
    
    for(i in 1..100) {
        fighterCarrier1.throwFighters()
    }

    //6.
    var dog = Dog("Carlos III", Sex.FEMALE, "Bearded Collie", 5)
    println(dog.toString())
    dog.run()
    dog.bark()
    print("\n")
    
    var whale = Whale("Patricia", "Blue whale", Sex.FEMALE, 63)
    println(whale.toString())
    whale.exhale()
    whale.sing()
    print("\n")
    
    var bird1 = Bird("Chispi", "Ringed-necked duck", Sex.MALE, 2,  true, true)
    println(bird1.toString())
    bird1.migrate()
    bird1.tweet()
    print("\n")
    
    var bird2 = Bird("Curruquita", "Pidgeon", Sex.FEMALE, 1, true, false)
    println(bird2.toString())
    bird2.migrate()
    bird2.tweet()
    print("\n")
    
    var bird3 = Bird("Bardo", "Chicken", Sex.MALE, 3, false, false)
    println(bird3.toString())
    bird3.migrate()
    bird3.tweet()
    print("\n")
}


class Brand (val name: String, val year: Int, val country: String){}

private fun createBrand(name: String, year: Int, country: String) : Brand {
    return Brand(name, year, country)
}


class Car (val modelName: String, val manufactureYear: Int, val horsepower: Int, val brand: Brand){}

private fun createCar(modelName: String, manufactureYear: Int, horsepower: Int, brand: Brand) : Car {
    return Car(modelName, manufactureYear, horsepower, brand)
}

class RoleCharacter(var name: String, var health: Int, var attack: Int, var defense: Int, var race: Array<Races>) {
    enum class Races {
        HUMAN,
        ELF,
        ORC,
        DWARF
    }

    fun reduceHealth(n : Int) {
        health = health - (n - defense)
    }

    fun attacks(characterBeingAttacked: RoleCharacter) {
        println("$name attacks ${characterBeingAttacked.name}")
        characterBeingAttacked.reduceHealth(attack)
    }
}

open class SpaceShip(var shipName: String, var health: Int, var crew: Int) {}

class Fighter(var fighterName: String, var shots: Int, shipName: String, health: Int, crew: Int) : SpaceShip(shipName, health, crew) {
    fun shoot() { shots=shots-10}
}

class FighterCarrier(var fighterNumber: Int, var shots: Int, shipName: String, health: Int, crew: Int) : SpaceShip(shipName, health, crew) {
	fun shoot() { shots=shots-10 }
    fun throwFighters() { 
        if(fighterNumber>0) {
            fighterNumber--
        } else {
           println("No fighters are left.") 
        }
    }
}

class Dog(var name: String, var sex: Sex, var breed: String, var age: Int) {
    
    fun run () {
        println("$name is running.")
    }

    fun jump() {
        println("$name is jumping.")
    }

    fun bark() {
        println("WOOF WOOF!")
    }
    
    override fun toString() : String {
        return "$name is a ${breed.lowercase()}, it is ${sex.toString().lowercase()} and is $age years old."
    }
}


class Whale(var name: String, var type: String, var sex: Sex, var age: Int) {
    
    fun sing() {
        println("AUUUOOOHII IIHOOOHIOO!")
    }

    fun eatPlakton() {
        println("$name is eating plakton.")
    }

    fun swimToSurface() {
        println("$name is swiming to the surface.")

    }

    fun exhale() {
        swimToSurface()
        println("$name is exhaling, and air is coming out of its blowhole.")
    }

    override fun toString() : String {
        return "$name is a ${type.lowercase()}, it is ${sex.toString().lowercase()} and is $age years old."
    }
}

class Bird(var name: String, var type: String, var sex: Sex, var age: Int,  var canFly: Boolean, var doesBirdMigrate: Boolean) {

    fun tweet() {
        when((1..5).random()) {
            1 -> println("CHIRP CHIRP!")
            2 -> println("TWEET TWEET!")
            3 -> println("HOOT HOOT!")
            4 -> println("SCUACK SCUACK!")
            5 -> println("CHIRP CHIRP!")
        }
    }

    fun fly() {
        if (canFly) {
            println("$name takes flight. $name is flying.")
        } else {
            println("$name can't fly! :(")
        }
    }
    

    fun migrate() {
        if(canFly && doesBirdMigrate) {
            fly()
            println("$name decides to migrate and flies to its new destination.") 
        } else {
         	if(!canFly) fly()
            if(!doesBirdMigrate && canFly) println("$name doesn't like to migrate. $name is happy where it is :3")
        } 
    }
        
    
    override fun toString() : String {
        return "$name is a ${type.lowercase()}, it is ${sex.toString().lowercase()} and is $age years old."
    }
}

enum class Sex {
	MALE,
    FEMALE
}

class User(id: Int, name: String, password: String, email: String, rootAccess: Boolean = false) {

}

class Admin(id: Int, name: String, password: String, email: String, rootAccess: Boolean = true) {

}







