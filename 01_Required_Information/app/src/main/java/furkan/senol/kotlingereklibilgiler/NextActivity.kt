package furkan.senol.kotlingereklibilgiler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_next.*

private lateinit var alert:AlertDialog.Builder

class NextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

        this.setTitle("Get name from Intent / AlertDialog ")

        //getIntent
        val getsetintent = intent
        val name = getsetintent.getStringExtra("name")

        name_text.text="Name: " + name

        /*alertDialog.setOnClickListener(object:View.OnClickListener{
            override fun onClick(v: View?) {
                Toast.makeText(this@NextActivity,"Merhaba",Toast.LENGTH_LONG).show()
            }

        })*/
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(applicationContext,"Merhaba",Toast.LENGTH_LONG).show()
    }

    fun alertDialog_button(view: View) {
        alert = AlertDialog.Builder(this)
        alert.setTitle("Save")
            .setMessage("Are You Sure?")
            .setPositiveButton("Yes") {dialog , it ->
                Toast.makeText(applicationContext,"Saved",Toast.LENGTH_LONG).show()
            }
            .setNegativeButton("No"){dialog, it ->
                Toast.makeText(applicationContext,"Not Saved",Toast.LENGTH_LONG).show()
            }
            .show()
    }

    fun timer_page(view: View) {
        val timer_page = Intent(this,TimerActivity::class.java)
        startActivity(timer_page)
    }
}