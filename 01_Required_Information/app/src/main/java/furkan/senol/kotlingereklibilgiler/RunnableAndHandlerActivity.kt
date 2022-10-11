package furkan.senol.kotlingereklibilgiler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import kotlinx.android.synthetic.main.activity_runnable_and_handler.*

var number = 0
var sayac=0
var runnable: Runnable = Runnable {  }
var handler: Handler = Handler()

class RunnableAndHandlerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_runnable_and_handler)

        this.setTitle("Runnable and Handler")
    }

    fun start(view: View) {
        sayac += 1
        if (sayac == 1) {
            number = 0
            runnable = object : Runnable {
                override fun run() {
                        number += 1
                        textView.text = "Time: $number"
                        handler.postDelayed(this, 1000)
                }
            }
            handler.post(runnable)
        }
    }

    fun stop(view: View) {
        handler.removeCallbacks(runnable)
        number = 0
        textView.text = "Time: 0"
    }
}