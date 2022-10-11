package furkan.senol.kotlingereklibilgiler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import kotlinx.android.synthetic.main.activity_timer.*

class TimerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)

        this.title = "CountDownTimer"
    }

    override fun onStart() {
        super.onStart()
        object : CountDownTimer(10000, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                timer_Text.text = "Left: ${millisUntilFinished / 1000}"
            }

            override fun onFinish() {
                timer_Text.text = "Time is over"
            }
        }.start()
    }//onStart destroy

    fun runnable_page(view: View) {
        val nextpage = Intent(applicationContext,RunnableAndHandlerActivity::class.java)
        startActivity(nextpage)
    }
}