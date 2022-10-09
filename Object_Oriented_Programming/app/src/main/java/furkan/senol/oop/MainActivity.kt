package furkan.senol.oop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Counstructor
        var user = User("Koray", 25)
        Log.w("deneme", "${user.name + user.age}")

        //Encapsulation
        var musician = Musician("Furkan", "Saksofon", 25)
        //musician.instrument (ulaşılamaz cunku get ve set private)
        //musician.age=24 (set private oldugundan deger atılamıyor)
        Log.w("musician.age", "${musician.age}")
        println(musician.returnBandName("Furkan"))
        println(musician.returnBandName("Koray"))

        //Inheritance
        var supermusician = SuperMusician("Else", "zurna", 22)
        println(supermusician.sign())
        println(supermusician.name)

        //polymorphism
        //static polymorphism
        val mathematics = Mathematics()
        println(mathematics.sum())
        println(mathematics.sum(2, 5))
        println(mathematics.sum(2, 3, 5))

        //dynamic polymorphism
        mathematics.deneme()
        val mat2 = Mat2()
        mat2.deneme()
        mat2.test()

        //abstract
        user.information()

        //interface
        val piano = Piano()
        println(piano.roomName)
        piano.brand = "brand"
        piano.digital = false

        piano.info()

        //Lambda expressions

        fun lambda(a: String) {
            println(a)
        }
        lambda("fun")

        val lambda2 = { a: String -> println(a) }
        lambda2("LAMBDA DENEME 1")

        val lambda3 = { a: Int, b: Int -> a * b }
        println(lambda3(5, 4))

        val lambda4: (Int, Int) -> Int = { a, b -> a * b }
        println(lambda4(5, 4))

        //asynchronous

        fun dowloandMusicians(url: String, completion: (Musician) -> Unit) {
            val music= Musician("name","inst",35)
            completion(music)
        }

        dowloandMusicians("metalica.com", {musician ->
            println(musician.name)
        })
    }
}