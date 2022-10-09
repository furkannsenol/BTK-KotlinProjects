package furkan.senol.oop

open class Mathematics {
    //static polymorphism
    fun sum(): Int {
        return 0
    }

    fun sum(x: Int, y: Int): Int {
        return x + y
    }

    fun sum(x: Int, y: Int, z: Int): Int {
        return x + y + z
    }

    //dynamic
    open fun deneme() {
        println("dynamic")
    }
}