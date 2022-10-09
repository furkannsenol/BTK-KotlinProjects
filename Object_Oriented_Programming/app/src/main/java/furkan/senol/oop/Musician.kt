package furkan.senol.oop

open class Musician(name: String, instrument: String, age: Int) {

    //encapsulation
    var name: String? = name
        private set
        get

    private var instrument: String? = instrument

    var age: Int? = age
        get
        private set

    private val bandName: String = "Metallica"

    fun returnBandName(password: String): String {
        if (password == "Furkan")
            return bandName
        else
            return "ZOOOORT"
    }
}