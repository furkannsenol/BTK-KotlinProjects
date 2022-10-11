package furkan.senol.oop

class Piano:HouseDecor,Instrument {
    //interface icin class

    var brand:String? = null
    var digital:Boolean? = null

    override var roomName: String
        get() = "Kitchen"
        set(value) {}

   // override fun info() {
     //   println("Instrument info")
    //}
}