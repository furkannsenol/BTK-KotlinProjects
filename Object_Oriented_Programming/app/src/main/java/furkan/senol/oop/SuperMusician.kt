package furkan.senol.oop

class SuperMusician(name: String, instrument: String, age: Int) : Musician(name, instrument, age) {
    //Inheritance
    fun sign() {
        println("nothing else matters")
    }
}