package furkan.senol.oop

class Mat2 :Mathematics() {
    //test fonksiyonu nmathematics sınıfına gidip deneme fonksiyonunu cagırır
    fun test(){
        super.deneme()
    }
    //dynamic polymorphism
    //override ile üstüne yazıyor
    override fun deneme(){
        println("deneme")
    }
}