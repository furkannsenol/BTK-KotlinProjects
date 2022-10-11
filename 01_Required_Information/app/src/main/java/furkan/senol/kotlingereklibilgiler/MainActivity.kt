package furkan.senol.kotlingereklibilgiler

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

private lateinit var age_Input: EditText
private lateinit var age_Text: TextView
private lateinit var name_Input: EditText
private lateinit var sharedPreferences: SharedPreferences
var ageFromPreferences: Int? = null

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.setTitle("StoringData")

        age_Input = findViewById(R.id.age_input)
        age_Text = findViewById(R.id.age_text)
        name_Input = findViewById(R.id.name_input)

        sharedPreferences =
            this.getSharedPreferences("furkan.senol.kotlingereklibilgiler", MODE_PRIVATE)

        ageFromPreferences = sharedPreferences.getInt("age", -1)

        if (ageFromPreferences == -1)
            age_text.text = "Your Age: "
        else
            age_text.text = "Your Age: $ageFromPreferences"

        println("onCreate called")
    }

    fun storingData_Save(view: View) {
        var myAge = age_Input.text.toString().toIntOrNull()

        if (myAge != null) {
            age_Text.text = "Your Age:" + myAge
            sharedPreferences.edit().putInt("age", myAge).apply()
        }

    }

    fun storingData_Delete(view: View) {
        //ageFromPreferences = sharedPreferences.getInt("age", -1)

        if (ageFromPreferences != -1) {
            sharedPreferences.edit().remove("age").apply()
            age_text.text = "Your Age: "
        }
    }

    fun next_button(view: View) {
        var name = name_input.text.toString()

        val intent = Intent(applicationContext, NextActivity::class.java)
        intent.putExtra("name", name)
        startActivity(intent)
        //finish()
    }

    override fun onStart() {
        super.onStart()
        println("onStart called")
    }

    override fun onResume() {
        super.onResume()
        println("onResume called")
    }

    override fun onPause() {
        super.onPause()
        println("onPause called")
    }

    override fun onStop() {
        super.onStop()
        println("onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("onDestroy called")
    }


}